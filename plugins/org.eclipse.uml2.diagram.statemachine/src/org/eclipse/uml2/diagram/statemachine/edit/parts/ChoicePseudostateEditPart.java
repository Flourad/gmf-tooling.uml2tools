package org.eclipse.uml2.diagram.statemachine.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ScalablePolygonShape;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
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
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.statemachine.edit.policies.ChoicePseudostateItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.statemachine.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */

public class ChoicePseudostateEditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3010;

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
	public ChoicePseudostateEditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ChoicePseudostateItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

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
		return primaryShape = new ScalableRhombFigure();
	}

	/**
	 * @generated
	 */
	public ScalableRhombFigure getPrimaryShape() {
		return (ScalableRhombFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		// #265822 Improve appearance of selection feedback
		ResizableEditPolicy result = new U2TResizableShapeEditPolicy();
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
			((Shape) primaryShape).setLineWidth(width);
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
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Transition_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof SimpleStateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof CompositeStateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof SubmachineStateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof EntryConnectionPointReferenceEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ExitConnectionPointReferenceEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof FinalStateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof InitialPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ShallowHistoryPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof DeepHistoryPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ForkPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof JoinPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof JunctionPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.statemachine.edit.parts.ChoicePseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof TerminatePseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof EntryPointPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		if (targetEditPart instanceof ExitPointPseudostateEditPart) {
			types.add(UMLElementTypes.Transition_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.State_3001);
			types.add(UMLElementTypes.State_3012);
			types.add(UMLElementTypes.State_3016);
			types.add(UMLElementTypes.ConnectionPointReference_3017);
			types.add(UMLElementTypes.ConnectionPointReference_3018);
			types.add(UMLElementTypes.FinalState_3003);
			types.add(UMLElementTypes.Pseudostate_3004);
			types.add(UMLElementTypes.Pseudostate_3005);
			types.add(UMLElementTypes.Pseudostate_3006);
			types.add(UMLElementTypes.Pseudostate_3007);
			types.add(UMLElementTypes.Pseudostate_3008);
			types.add(UMLElementTypes.Pseudostate_3009);
			types.add(UMLElementTypes.Pseudostate_3010);
			types.add(UMLElementTypes.Pseudostate_3011);
			types.add(UMLElementTypes.Pseudostate_3014);
			types.add(UMLElementTypes.Pseudostate_3015);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.Transition_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.Transition_4001) {
			types.add(UMLElementTypes.State_3001);
			types.add(UMLElementTypes.State_3012);
			types.add(UMLElementTypes.State_3016);
			types.add(UMLElementTypes.ConnectionPointReference_3017);
			types.add(UMLElementTypes.ConnectionPointReference_3018);
			types.add(UMLElementTypes.FinalState_3003);
			types.add(UMLElementTypes.Pseudostate_3004);
			types.add(UMLElementTypes.Pseudostate_3005);
			types.add(UMLElementTypes.Pseudostate_3006);
			types.add(UMLElementTypes.Pseudostate_3007);
			types.add(UMLElementTypes.Pseudostate_3008);
			types.add(UMLElementTypes.Pseudostate_3009);
			types.add(UMLElementTypes.Pseudostate_3010);
			types.add(UMLElementTypes.Pseudostate_3011);
			types.add(UMLElementTypes.Pseudostate_3014);
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
	public class ScalableRhombFigure extends ScalablePolygonShape {

		/**
		 * @generated
		 */
		public ScalableRhombFigure() {
			this.addPoint(new Point(getMapMode().DPtoLP(20), getMapMode().DPtoLP(0)));
			this.addPoint(new Point(getMapMode().DPtoLP(40), getMapMode().DPtoLP(20)));
			this.addPoint(new Point(getMapMode().DPtoLP(20), getMapMode().DPtoLP(40)));
			this.addPoint(new Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(20)));
			this.setFill(true);
			this.setLineWidth(1);
		}

	}

}
