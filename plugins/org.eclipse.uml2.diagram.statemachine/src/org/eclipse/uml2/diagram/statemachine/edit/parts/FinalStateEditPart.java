package org.eclipse.uml2.diagram.statemachine.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.draw2d.CenterLayout;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.statemachine.edit.policies.FinalStateItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.statemachine.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */

public class FinalStateEditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3003;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public FinalStateEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		if (UMLVisualIDRegistry.isShortcutDescendant(getNotationView())) {
			installEditPolicy(UpdateDescriptionEditPolicy.ROLE, new UpdateDescriptionEditPolicy(UMLDiagramUpdater.TYPED_ADAPTER, true));
		}
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new FinalStateItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		ActivityFinalFigure figure = new ActivityFinalFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ActivityFinalFigure getPrimaryShape() {
		return (ActivityFinalFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(23), getMapMode().DPtoLP(23));
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if (result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy) result;
			ep.setResizeDirections(PositionConstants.NONE);
		}
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(getMapMode().DPtoLP(width));
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Transition_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof StateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof State2EditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof State3EditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ConnectionPointReferenceEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ConnectionPointReference2EditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.statemachine.edit.parts.FinalStateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof PseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Pseudostate2EditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Pseudostate3EditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Pseudostate4EditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Pseudostate5EditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Pseudostate6EditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Pseudostate7EditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Pseudostate8EditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Pseudostate9EditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof Pseudostate10EditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.State_3001);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.State_3012);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.State_3016);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.ConnectionPointReference_3017);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.ConnectionPointReference_3018);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.FinalState_3003);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3004);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3005);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3006);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3007);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3008);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3009);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3010);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3011);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3014);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3015);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Transition_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.State_3001);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.State_3012);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.State_3016);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.ConnectionPointReference_3017);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.ConnectionPointReference_3018);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.FinalState_3003);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3004);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3005);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3006);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3007);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3008);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3009);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3010);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3011);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3014);
		}
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.Pseudostate_3015);
		}
		return types;
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
	}

	/**
	 * @generated
	 */
	public class ActivityFinalFigure extends Ellipse {

		/**
		 * @generated
		 */
		public ActivityFinalFigure() {

			CenterLayout layoutThis = new CenterLayout();

			this.setLayoutManager(layoutThis);

			this.setForegroundColor(ColorConstants.black);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(23), getMapMode().DPtoLP(23)));
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(23), getMapMode().DPtoLP(23)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(23), getMapMode().DPtoLP(23)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			Ellipse activityFinalFigure_inner0 = new Ellipse();
			activityFinalFigure_inner0.setBackgroundColor(ColorConstants.black);
			activityFinalFigure_inner0.setPreferredSize(new Dimension(getMapMode().DPtoLP(15), getMapMode().DPtoLP(15)));
			activityFinalFigure_inner0.setMaximumSize(new Dimension(getMapMode().DPtoLP(15), getMapMode().DPtoLP(15)));
			activityFinalFigure_inner0.setMinimumSize(new Dimension(getMapMode().DPtoLP(15), getMapMode().DPtoLP(15)));

			this.add(activityFinalFigure_inner0);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

	}

}
