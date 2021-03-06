package org.eclipse.uml2.diagram.clazz.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.clazz.conventions.InterfaceNotationConvention;
import org.eclipse.uml2.diagram.clazz.edit.policies.InterfaceRealizationItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.clazz.links.DiagramLinkInfoProvider;
import org.eclipse.uml2.diagram.common.links.RefreshComplementaryLinksHelper;

/**
 * @generated
 */
public class InterfaceRealizationEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4008;

	/**
	 * @generated
	 */
	public InterfaceRealizationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InterfaceRealizationItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated NOT 
	 */
	protected Connection createConnectionFigure() {
		if (InterfaceNotationConvention.needsAlternativeNotation(this)) {
			return new ConnectionWithClosedArrowPolylineFigure(getMapMode());
		}
		return new PolylineConnectionEx();
	}

	/**
	 * @generated
	 */
	public PolylineConnectionEx getPrimaryShape() {
		return (PolylineConnectionEx) getFigure();
	}

	/**
	 * NOT generated
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		RefreshComplementaryLinksHelper.getInstance().handleNotification(this, notification, DiagramLinkInfoProvider.getInstance());

		super.handleNotificationEvent(notification);
	}

}
