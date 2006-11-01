package org.eclipse.uml2.diagram.activity.navigator;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramEditor;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLNavigatorActionProvider extends CommonActionProvider {

	/**
	 * @generated
	 */
	private boolean myContribute;

	/**
	 * @generated
	 */
	private OpenDiagramAction myOpenDiagramAction;

	/**
	 * @generated
	 */
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
		if (aSite.getViewSite() instanceof ICommonViewerWorkbenchSite) {
			myContribute = true;
			makeActions((ICommonViewerWorkbenchSite) aSite.getViewSite());
		} else {
			myContribute = false;
		}
	}

	/**
	 * @generated
	 */
	private void makeActions(ICommonViewerWorkbenchSite viewerSite) {
		myOpenDiagramAction = new OpenDiagramAction(viewerSite);
	}

	/**
	 * @generated
	 */
	public void fillActionBars(IActionBars actionBars) {
		if (!myContribute) {
			return;
		}
		IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
		myOpenDiagramAction.selectionChanged(selection);
		if (myOpenDiagramAction.isEnabled()) {
			actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, myOpenDiagramAction);
		}
	}

	/**
	 * @generated
	 */
	public void fillContextMenu(IMenuManager menu) {
		/*		if (!myContribute || getContext().getSelection().isEmpty()) {
		 return;
		 }

		 IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();

		 myOpenDiagramAction.selectionChanged(selection);
		 if (myOpenDiagramAction.isEnabled()) {
		 menu.insertAfter(ICommonMenuConstants.GROUP_OPEN, myOpenDiagramAction);
		 }*/
	}

	/**
	 * @generated
	 */
	private class OpenDiagramAction extends Action {

		/**
		 * @generated
		 */
		private Diagram myDiagram;

		/**
		 * @generated
		 */
		private ICommonViewerWorkbenchSite myViewerSite;

		/**
		 * @generated
		 */
		public OpenDiagramAction(ICommonViewerWorkbenchSite viewerSite) {
			super("Open Diagram");
			myViewerSite = viewerSite;
		}

		/**
		 * @generated
		 */
		public final void selectionChanged(IStructuredSelection selection) {
			myDiagram = null;
			if (selection.size() == 1) {
				Object selectedElement = selection.getFirstElement();
				if (selectedElement instanceof UMLNavigatorItem) {
					selectedElement = ((UMLNavigatorItem) selectedElement).getView();
				}
				if (selectedElement instanceof Diagram) {
					Diagram diagram = (Diagram) selectedElement;
					if (ActivityEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(diagram))) {
						myDiagram = diagram;
					}
				}
			}
			setEnabled(myDiagram != null);
		}

		/**
		 * @generated
		 */
		public void run() {
			if (myDiagram == null) {
				return;
			}
			DiagramEditorInput editorInput = new DiagramEditorInput(myDiagram);
			IWorkbenchPage page = myViewerSite.getPage();
			try {
				page.openEditor(editorInput, UMLDiagramEditor.ID);
			} catch (PartInitException e) {
				UMLDiagramEditorPlugin.getInstance().logError("Exception while openning diagram", e);
			}
		}

	}

}
