package org.eclipse.uml2.diagram.activity.action;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.diagram.activity.part.Messages;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.common.actions.ChangeNotationAction;

/**
 * @generated
 */
public class Set2028Notation extends ChangeNotationAction {

	public static final String ACTION_ID = "set_2028_notation"; //$NON-NLS-1$

	private static final int NEW_VID = 2028;

	/**
	 * @generated
	 */
	public Set2028Notation(IWorkbenchPage workbenchPage, String actionId) {
		super(workbenchPage, actionId);
	}

	/**
	 * @generated
	 */
	@Override
	public void refresh() {
		super.refresh();
		setChecked(calculateChecked());
	}

	/**
	 * @generated
	 */
	@Override
	public boolean isEnabled() {
		GraphicalEditPart ep = getSelectedEditPart();
		return (ep == null) ? false : UMLVisualIDRegistry.getVisualID(ep.getNotationView()) != NEW_VID;
	}

	/**
	 * @generated
	 */
	public boolean calculateChecked() {
		GraphicalEditPart ep = getSelectedEditPart();
		return (ep == null) ? false : UMLVisualIDRegistry.getVisualID(ep.getNotationView()) == NEW_VID;
	}

	/**
	 * @generated
	 */
	@Override
	protected void updateText() {
		setText(Messages.Set2028Notation_text);
		setText(Messages.Set2028Notation_tooltiptext);
	}

	/**
	 * @generated
	 */
	@Override
	protected String getSemanticHint(GraphicalEditPart editPart) {
		return String.valueOf(NEW_VID);
	}

}