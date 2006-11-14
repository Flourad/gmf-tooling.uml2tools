package org.eclipse.uml2.diagram.clazz.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.draw2d.Connection;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;

import org.eclipse.uml2.diagram.clazz.edit.policies.GeneralizationItemSemanticEditPolicy;

/**
 * @generated
 */
public class GeneralizationEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4001;

	/**
	 * @generated
	 */
	public GeneralizationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new GeneralizationItemSemanticEditPolicy());

	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new SolidLineWDstClosedArrow();
	}

	/**
	 * @generated
	 */
	public class SolidLineWDstClosedArrow extends org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx {

		/**
		 * @generated
		 */
		public SolidLineWDstClosedArrow() {
			this.setFill(true);
			this.setFillXOR(false);
			this.setOutline(true);
			this.setOutlineXOR(false);
			this.setLineWidth(1);
			this.setLineStyle(org.eclipse.draw2d.Graphics.LINE_SOLID);

			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private org.eclipse.draw2d.RotatableDecoration createTargetDecoration() {
			org.eclipse.draw2d.PolygonDecoration df = new org.eclipse.draw2d.PolygonDecoration();
			df.setFill(true);
			df.setFillXOR(false);
			df.setOutline(true);
			df.setOutlineXOR(false);
			df.setLineWidth(1);
			df.setLineStyle(org.eclipse.draw2d.Graphics.LINE_SOLID);
			org.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
			pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(2));
			pl.addPoint(getMapMode().DPtoLP(-2), getMapMode().DPtoLP(-2));
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
			df.setTemplate(pl);
			df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
			return df;
		}

	}

}
