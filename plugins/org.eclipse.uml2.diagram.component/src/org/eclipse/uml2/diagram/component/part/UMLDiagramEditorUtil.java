package org.eclipse.uml2.diagram.component.part;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import java.io.ByteArrayInputStream;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.ResourcesPlugin;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.xmi.XMIResource;

import org.eclipse.jface.dialogs.ErrorDialog;

import org.eclipse.ui.ide.IDE;

import org.eclipse.uml2.diagram.component.edit.parts.PackageEditPart;

import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class UMLDiagramEditorUtil {

	/**
	 * @generated
	 */
	public static final URI createAndOpenDiagram(IPath containerPath, String fileName, IWorkbenchWindow window, IProgressMonitor progressMonitor, boolean openEditor, boolean saveDiagram) {
		IFile diagramFile = createNewDiagramFile(containerPath, fileName, window.getShell(), progressMonitor);
		if (diagramFile != null && openEditor) {
			openDiagramEditor(window, diagramFile, saveDiagram, progressMonitor);
		}
		return URI.createPlatformResourceURI(diagramFile.getFullPath().toString());
	}

	/**
	 * @generated
	 */
	public static final IEditorPart openDiagramEditor(IWorkbenchWindow window, IFile file, boolean saveDiagram, IProgressMonitor progressMonitor) {
		IEditorPart editorPart = null;
		try {
			IWorkbenchPage page = window.getActivePage();
			if (page != null) {
				editorPart = openDiagramEditor(page, file);
				if (saveDiagram) {
					editorPart.doSave(progressMonitor);
				}
			}
			file.refreshLocal(IResource.DEPTH_ZERO, null);
			return editorPart;
		} catch (Exception e) {
			UMLDiagramEditorPlugin.getInstance().logError("Error opening diagram", e);
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static final IEditorPart openDiagramEditor(IWorkbenchPage page, IFile file) throws PartInitException {
		return IDE.openEditor(page, file);
	}

	/**
	 * <p>
	 * This method should be called within a workspace modify operation since it creates resources.
	 * </p>
	 * @generated
	 * @return the created file resource, or <code>null</code> if the file was not created
	 */
	public static final IFile createNewDiagramFile(IPath containerFullPath, String fileName, Shell shell, IProgressMonitor progressMonitor) {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		ResourceSet resourceSet = editingDomain.getResourceSet();
		progressMonitor.beginTask("Creating diagram and model files", 3); //$NON-NLS-1$
		final IFile diagramFile = createNewFile(containerFullPath, fileName, shell);
		final Resource diagramResource = resourceSet.createResource(URI.createPlatformResourceURI(diagramFile.getFullPath().toString()));
		List affectedFiles = new ArrayList();
		affectedFiles.add(diagramFile);
		IPath modelFileRelativePath = diagramFile.getFullPath().removeFileExtension().addFileExtension("uml"); //$NON-NLS-1$
		IFile modelFile = diagramFile.getParent().getFile(new Path(modelFileRelativePath.lastSegment()));
		final Resource modelResource = resourceSet.createResource(URI.createPlatformResourceURI(modelFile.getFullPath().toString()));
		affectedFiles.add(modelFile);
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain, "Creating diagram and model", affectedFiles) { //$NON-NLS-1$

			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				org.eclipse.uml2.uml.Package model = createInitialModel();
				modelResource.getContents().add(createInitialRoot(model));
				Diagram diagram = ViewService.createDiagram(model, PackageEditPart.MODEL_ID, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				if (diagram != null) {
					diagramResource.getContents().add(diagram);
					diagram.setName(diagramFile.getName());
					diagram.setElement(model);
				}
				try {
					Map options = new HashMap();
					options.put(XMIResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
					modelResource.save(options);
					diagramResource.save(Collections.EMPTY_MAP);
				} catch (IOException e) {

					UMLDiagramEditorPlugin.getInstance().logError("Unable to store model and diagram resources", e); //$NON-NLS-1$
				}
				return CommandResult.newOKCommandResult();
			}
		};

		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new SubProgressMonitor(progressMonitor, 1), null);
		} catch (ExecutionException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
		}

		try {
			modelFile.setCharset("UTF-8", new SubProgressMonitor(progressMonitor, 1)); //$NON-NLS-1$
		} catch (CoreException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Unable to set charset for model file", e); //$NON-NLS-1$
		}
		try {
			diagramFile.setCharset("UTF-8", new SubProgressMonitor(progressMonitor, 1)); //$NON-NLS-1$
		} catch (CoreException e) {
			UMLDiagramEditorPlugin.getInstance().logError("Unable to set charset for diagram file", e); //$NON-NLS-1$
		}

		return diagramFile;
	}

	/**
	 * Create a new instance of domain element associated with canvas.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static org.eclipse.uml2.uml.Package createInitialModel() {
		return UMLFactory.eINSTANCE.createPackage();
	}

	/**
	 * @generated
	 */
	private static EObject createInitialRoot(org.eclipse.uml2.uml.Package model) {
		return model;
	}

	/**
	 * @generated
	 */
	public static IFile createNewFile(IPath containerPath, String fileName, Shell shell) {
		IPath newFilePath = containerPath.append(fileName);
		IFile newFileHandle = ResourcesPlugin.getWorkspace().getRoot().getFile(newFilePath);
		try {
			createFile(newFileHandle);
		} catch (CoreException e) {
			ErrorDialog.openError(shell, "Creation Problems", null, e.getStatus());
			return null;
		}
		return newFileHandle;
	}

	/**
	 * @generated
	 */
	protected static void createFile(IFile fileHandle) throws CoreException {
		try {
			fileHandle.create(new ByteArrayInputStream(new byte[0]), false, new NullProgressMonitor());
		} catch (CoreException e) {
			// If the file already existed locally, just refresh to get contents
			if (e.getStatus().getCode() == IResourceStatus.PATH_OCCUPIED) {
				fileHandle.refreshLocal(IResource.DEPTH_ZERO, null);
			} else {
				throw e;
			}
		}
	}
}
