package org.eclipse.uml2.diagram.statemachine.edit.parts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.draw2d.LaneLayout;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.editpolicies.LaneLayoutEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.statemachine.edit.policies.State2CanonicalEditPolicy;
import org.eclipse.uml2.diagram.statemachine.edit.policies.State2ItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.statemachine.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */
public class State2EditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3012;

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
	public State2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		if (UMLVisualIDRegistry.isShortcutDescendant(getNotationView())) {
			installEditPolicy(UpdateDescriptionEditPolicy.ROLE, new UpdateDescriptionEditPolicy(UMLDiagramUpdater.TYPED_ADAPTER, true));
		}
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(UMLVisualIDRegistry.TYPED_ADAPTER));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new State2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new State2CanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy("LayoutEditPolicy", new LaneLayoutEditPolicy()); //$NON-NLS-1$
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
		CompositeStateFigure figure = new CompositeStateFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public CompositeStateFigure getPrimaryShape() {
		return (CompositeStateFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof StateName3EditPart) {
			((StateName3EditPart) childEditPart).setLabel(getPrimaryShape().getFigureCompositeStateFigure_name());
			return true;
		}
		if (childEditPart instanceof StateCompositeState_InternalActivitiesEditPart) {
			IFigure pane = getPrimaryShape().getFigureCompositeStateFigure_InternalActivitiesCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((StateCompositeState_InternalActivitiesEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof StateCompositeState_InternalActivitiesEditPart) {
			IFigure pane = getPrimaryShape().getFigureCompositeStateFigure_InternalActivitiesCompartment();
			pane.remove(((StateCompositeState_InternalActivitiesEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof StateCompositeState_InternalActivitiesEditPart) {
			return getPrimaryShape().getFigureCompositeStateFigure_InternalActivitiesCompartment();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
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
	 * @generated NOT
	 * XXX: Support content pane in xPand custom templates
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return getPrimaryShape().getFigureCompositeStateFigure_Body();
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(StateName3EditPart.VISUAL_ID));
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
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.statemachine.edit.parts.State2EditPart) {
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
		if (targetEditPart instanceof FinalStateEditPart) {
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
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == UMLElementTypes.Behavior_3019) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(StateCompositeState_InternalActivitiesEditPart.VISUAL_ID));
			}
			if (type == UMLElementTypes.Behavior_3020) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(StateCompositeState_InternalActivitiesEditPart.VISUAL_ID));
			}
			if (type == UMLElementTypes.Behavior_3021) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(StateCompositeState_InternalActivitiesEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
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
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
	}

	/**
	 * @generated
	 */
	public class CompositeStateFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private Label fFigureCompositeStateFigure_name;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureCompositeStateFigure_Body;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureCompositeStateFigure_InternalActivitiesCompartment;

		/**
		 * @generated
		 */
		public CompositeStateFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(18), getMapMode().DPtoLP(18)));
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(4), getMapMode().DPtoLP(4), getMapMode().DPtoLP(4), getMapMode().DPtoLP(4)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure compositeStateFigure_UpperContainer0 = new RectangleFigure();
			compositeStateFigure_UpperContainer0.setOutline(false);

			this.add(compositeStateFigure_UpperContainer0, BorderLayout.TOP);

			ToolbarLayout layoutCompositeStateFigure_UpperContainer0 = new ToolbarLayout();
			layoutCompositeStateFigure_UpperContainer0.setStretchMinorAxis(true);
			layoutCompositeStateFigure_UpperContainer0.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutCompositeStateFigure_UpperContainer0.setSpacing(0);
			layoutCompositeStateFigure_UpperContainer0.setVertical(true);

			compositeStateFigure_UpperContainer0.setLayoutManager(layoutCompositeStateFigure_UpperContainer0);

			fFigureCompositeStateFigure_name = new Label();
			fFigureCompositeStateFigure_name.setText("");

			compositeStateFigure_UpperContainer0.add(fFigureCompositeStateFigure_name);

			fFigureCompositeStateFigure_InternalActivitiesCompartment = new RectangleFigure();
			fFigureCompositeStateFigure_InternalActivitiesCompartment.setOutline(false);

			compositeStateFigure_UpperContainer0.add(fFigureCompositeStateFigure_InternalActivitiesCompartment);
			fFigureCompositeStateFigure_InternalActivitiesCompartment.setLayoutManager(new StackLayout());

			fFigureCompositeStateFigure_Body = new RectangleFigure();
			fFigureCompositeStateFigure_Body.setOutline(false);

			this.add(fFigureCompositeStateFigure_Body, BorderLayout.CENTER);

			LaneLayout layoutFFigureCompositeStateFigure_Body = new LaneLayout();

			fFigureCompositeStateFigure_Body.setLayoutManager(layoutFFigureCompositeStateFigure_Body);

		}

		/**
		 * @generated
		 */
		public Label getFigureCompositeStateFigure_name() {
			return fFigureCompositeStateFigure_name;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureCompositeStateFigure_Body() {
			return fFigureCompositeStateFigure_Body;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureCompositeStateFigure_InternalActivitiesCompartment() {
			return fFigureCompositeStateFigure_InternalActivitiesCompartment;
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
