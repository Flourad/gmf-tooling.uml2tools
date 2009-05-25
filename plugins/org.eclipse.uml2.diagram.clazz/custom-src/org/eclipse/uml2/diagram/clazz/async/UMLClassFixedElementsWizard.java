package org.eclipse.uml2.diagram.clazz.async;

import java.util.Arrays;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.clazz.part.UMLCreateShortcutAction;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.clazz.part.UMLNewDiagramFileWizard;
import org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.common.async.ApplySynchronizationCommand;
import org.eclipse.uml2.diagram.common.async.NewDiagramSyncHelper;
import org.eclipse.uml2.diagram.common.async.SyncModelContext;
import org.eclipse.uml2.diagram.common.async.SyncModelNode;
import org.eclipse.uml2.diagram.common.genapi.IDiagramUpdater;
import org.eclipse.uml2.diagram.common.genapi.IVisualIDRegistry;
import org.eclipse.uml2.uml.PackageableElement;

public class UMLClassFixedElementsWizard extends UMLNewDiagramFileWizard {

	private final PackageableElement[] myToSelect;

	private NewDiagramSyncHelperWithFixedElements mySyncHelper;
	
	public UMLClassFixedElementsWizard(URI domainModelURI, EObject diagramRoot, PackageableElement[] toSelect, TransactionalEditingDomain editingDomain) {
		super(domainModelURI, diagramRoot, editingDomain);
		myToSelect = toSelect;
	}

	@Override
	public void addPages() {
		addPage(getFileCreationPage());
		addPage(getDiagramRootElementSelectionPage());
	}

	@Override
	protected boolean needsLayoutAll() throws ExecutionException {
		return true;
	}

	@Override
	protected void layoutAll() throws ExecutionException {
		createShortcutsIfNeeded();
		super.layoutAll();
	}

	private void createShortcutsIfNeeded() {
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		DiagramEditPart diagramEditPart = ((IDiagramWorkbenchPart) editorPart).getDiagramEditPart();
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();
		for (PackageableElement next : myToSelect) {
			if (!canCreateView(next)) {
				UMLCreateShortcutAction.createShortcut(diagramEditPart.getEditingDomain(), history, next, diagramEditPart, editorPart);
			}
		}
	}

	private boolean canCreateView(EObject element) {
		for (Object next : getDiagram().getChildren()) {
			View view = (View) next;
			if (element.equals(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected AbstractTransactionalCommand getApplySynchronizationCommand() {
		EObject semanticRoot = getDiagramRootElementSelectionPage().getModelElement();
		getEditingDomain().getResourceSet().getResource(semanticRoot.eResource().getURI(), true);
		mySyncHelper = new NewDiagramSyncHelperWithFixedElements(createSyncContext(semanticRoot), PackageEditPart.MODEL_ID);
		mySyncHelper.setSemanticRoot(semanticRoot);
		return new ApplySynchronizationCommand(mySyncHelper.getSyncRoot());
	}
	
	protected SyncModelContextWithFixedElements createSyncContext(EObject semanticRoot) {
		return new SyncModelContextWithFixedElements(//
				UMLDiagramUpdater.TYPED_ADAPTER, // 
				UMLVisualIDRegistry.TYPED_ADAPTER, //
				UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT, //
				getEditingDomain(), myToSelect, true);
	}

	@Override
	protected Diagram getDiagram() {
		return mySyncHelper.getNewDiagram();
	}
	
	private static class NewDiagramSyncHelperWithFixedElements extends NewDiagramSyncHelper {
		public NewDiagramSyncHelperWithFixedElements(SyncModelContextWithFixedElements contextImpl, String diagramModelId){
			super(contextImpl, diagramModelId);
		}
		
		protected SyncModelNode createRootNode(SyncModelContext context, Diagram syncDiagram, Diagram tempDiagram) {
			SyncModelNode result = new SyncModelNodeForInitializedDiagram(syncDiagram, tempDiagram, context);
			return result;
		}
	}

	private static class SyncModelNodeForInitializedDiagram extends SyncModelNode {
		public SyncModelNodeForInitializedDiagram(View syncModelRoot, View diagramRoot, SyncModelContext context) {
			super(syncModelRoot, diagramRoot, context);
		}

		@Override
		public boolean isAutoSynchronized() {
			return false;
		}

		private SyncModelNodeForInitializedDiagram(View syncModelView, SyncModelNode parent) {
			super(syncModelView, parent);
		}

		@Override
		public void initWithDiagramView(View diagramView) {
			super.initWithDiagramView(diagramView);
			setChecked(isInToCreateList() || UMLClassDiagramHeaderFilter.SHARED_INSTANCE.isFilteredVisualId(this));
		}

		private boolean isInToCreateList() {
			PackageableElement[] toSelect = ((SyncModelContextWithFixedElements) getContext()).getElementsToDisplay();
			if (toSelect == null || toSelect.length == 0) {
				return true; //diagram is selected, all diagram contents considered as implicit to-create list  
			}
			return Arrays.asList(toSelect).contains(getSyncModelView().getElement());
		}

		@Override
		protected SyncModelNode doCreateNodeView(View syncModelView, SyncModelNode parent) {
			return new SyncModelNodeForInitializedDiagram(syncModelView, parent);
		}

	}

	protected static class SyncModelContextWithFixedElements extends SyncModelContext {
		private PackageableElement[] myElementsToDisplay;

		public SyncModelContextWithFixedElements(IDiagramUpdater updater, IVisualIDRegistry registry, PreferencesHint preferencesHint, TransactionalEditingDomain domain,
				PackageableElement[] toSelect, boolean isDiagramInit) {
			super(updater, registry, preferencesHint, domain, isDiagramInit);
			myElementsToDisplay = toSelect;
		}

		public PackageableElement[] getElementsToDisplay() {
			return myElementsToDisplay;
		}
	}

}
