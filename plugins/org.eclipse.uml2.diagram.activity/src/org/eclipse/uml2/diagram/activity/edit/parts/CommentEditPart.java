package org.eclipse.uml2.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.activity.edit.policies.CommentCanonicalEditPolicy;
import org.eclipse.uml2.diagram.activity.edit.policies.CommentItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.draw2d.CommentFigureBase;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class CommentEditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 2029;

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
	public CommentEditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CommentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new CommentCanonicalEditPolicy());
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
		return primaryShape = new CommentFigure();
	}

	/**
	* @generated
	*/
	public CommentFigure getPrimaryShape() {
		return (CommentFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof CommentBodyEditPart) {
			((CommentBodyEditPart) childEditPart).setLabel(getPrimaryShape().getBodyLabel());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {

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
		return getContentPane();
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
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
	}

	/**
	* @generated
	*/
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		return types;
	}

	/**
	* @generated
	*/
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ActivityEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof LocalPreconditionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof LocalPostconditionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.activity.edit.parts.CommentEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof AcceptEventActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof AcceptTimeEventActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof DecisionNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof MergeNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof InitialNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof DataStoreNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof CentralBufferNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof OpaqueActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof OpaqueAction_OutputPinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof OpaqueAction_InputPinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ForkNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof JoinNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof PinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof CreateObjectActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof CreateObjectAction_OutputPinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof AddStructuralFeatureValueActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof AddStructuralFeatureValueAction_insertAt_InputPinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof AddStructuralFeatureValueAction_value_InputPinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof AddStructuralFeatureValueAction_object_InputPinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof CallAction_OutputPinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof CallAction_InputPinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof CallOperationActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof CallOperationAction_InputPinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_OpaqueActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_AcceptEventActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_AcceptTimeEventActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_DecisionNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_PinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_CreateObjectActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_CallOperationActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_ForkNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_JoinNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_AddStructuralFeatureValueActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_DataStoreNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_CentralBufferNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_InputPinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_OutputPinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_ConditionalNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_InitialNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof OpaqueBehaviorEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityParameterNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof SendSignalActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartitionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_ActivityPartitionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_AcceptEventActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_AcceptTimeEventActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_ActivityFinalNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_DecisionNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_MergeNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_InitialNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_DataStoreNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_CentralBufferNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_OpaqueActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_FlowFinalNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_ForkNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_JoinNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_PinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_CreateObjectActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_AddStructuralFeatureValueActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_CallBehaviorActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_CallOperationActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_StructuredActivityNode_StructuredActivityNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_StructuredActivityNode_InputPinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof StructuredActivityNode_StructuredActivityNode_OutputPinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_SendSignalActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_LoopNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_ConditionalNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_ExpansionRegionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ActivityPartition_ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ValueSpecificationAction_OutputPinEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof LoopNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ConditionalNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ExpansionRegionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ExpansionNodeEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ParameterSetEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ParameterEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		if (targetEditPart instanceof ValueSpecificationActionEditPart) {
			types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		}
		return types;
	}

	/**
	* @generated
	*/
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4007) {
			types.add(UMLElementTypes.Activity_2026);
			types.add(UMLElementTypes.Constraint_2027);
			types.add(UMLElementTypes.Constraint_2028);
			types.add(UMLElementTypes.Comment_2029);
			types.add(UMLElementTypes.AcceptEventAction_3030);
			types.add(UMLElementTypes.AcceptEventAction_3031);
			types.add(UMLElementTypes.ActivityFinalNode_3032);
			types.add(UMLElementTypes.DecisionNode_3033);
			types.add(UMLElementTypes.MergeNode_3034);
			types.add(UMLElementTypes.InitialNode_3035);
			types.add(UMLElementTypes.DataStoreNode_3036);
			types.add(UMLElementTypes.CentralBufferNode_3037);
			types.add(UMLElementTypes.OpaqueAction_3029);
			types.add(UMLElementTypes.OutputPin_3001);
			types.add(UMLElementTypes.InputPin_3094);
			types.add(UMLElementTypes.FlowFinalNode_3038);
			types.add(UMLElementTypes.ForkNode_3039);
			types.add(UMLElementTypes.JoinNode_3040);
			types.add(UMLElementTypes.Pin_3041);
			types.add(UMLElementTypes.CreateObjectAction_3042);
			types.add(UMLElementTypes.OutputPin_3002);
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3043);
			types.add(UMLElementTypes.InputPin_3003);
			types.add(UMLElementTypes.InputPin_3004);
			types.add(UMLElementTypes.InputPin_3005);
			types.add(UMLElementTypes.CallBehaviorAction_3044);
			types.add(UMLElementTypes.OutputPin_3006);
			types.add(UMLElementTypes.InputPin_3007);
			types.add(UMLElementTypes.CallOperationAction_3045);
			types.add(UMLElementTypes.InputPin_3008);
			types.add(UMLElementTypes.StructuredActivityNode_3046);
			types.add(UMLElementTypes.StructuredActivityNode_3009);
			types.add(UMLElementTypes.OpaqueAction_3011);
			types.add(UMLElementTypes.AcceptEventAction_3012);
			types.add(UMLElementTypes.AcceptEventAction_3013);
			types.add(UMLElementTypes.ActivityFinalNode_3014);
			types.add(UMLElementTypes.DecisionNode_3015);
			types.add(UMLElementTypes.FlowFinalNode_3016);
			types.add(UMLElementTypes.Pin_3017);
			types.add(UMLElementTypes.CreateObjectAction_3018);
			types.add(UMLElementTypes.CallBehaviorAction_3019);
			types.add(UMLElementTypes.CallOperationAction_3020);
			types.add(UMLElementTypes.ForkNode_3021);
			types.add(UMLElementTypes.JoinNode_3022);
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3023);
			types.add(UMLElementTypes.DataStoreNode_3024);
			types.add(UMLElementTypes.CentralBufferNode_3025);
			types.add(UMLElementTypes.InputPin_3054);
			types.add(UMLElementTypes.OutputPin_3055);
			types.add(UMLElementTypes.ConditionalNode_3092);
			types.add(UMLElementTypes.InitialNode_3093);
			types.add(UMLElementTypes.OpaqueBehavior_3047);
			types.add(UMLElementTypes.ActivityParameterNode_3052);
			types.add(UMLElementTypes.SendSignalAction_3053);
			types.add(UMLElementTypes.ActivityPartition_3056);
			types.add(UMLElementTypes.ActivityPartition_3057);
			types.add(UMLElementTypes.AcceptEventAction_3059);
			types.add(UMLElementTypes.AcceptEventAction_3060);
			types.add(UMLElementTypes.ActivityFinalNode_3061);
			types.add(UMLElementTypes.DecisionNode_3062);
			types.add(UMLElementTypes.MergeNode_3063);
			types.add(UMLElementTypes.InitialNode_3064);
			types.add(UMLElementTypes.DataStoreNode_3065);
			types.add(UMLElementTypes.CentralBufferNode_3066);
			types.add(UMLElementTypes.OpaqueAction_3067);
			types.add(UMLElementTypes.FlowFinalNode_3068);
			types.add(UMLElementTypes.ForkNode_3069);
			types.add(UMLElementTypes.JoinNode_3070);
			types.add(UMLElementTypes.Pin_3071);
			types.add(UMLElementTypes.CreateObjectAction_3072);
			types.add(UMLElementTypes.AddStructuralFeatureValueAction_3073);
			types.add(UMLElementTypes.CallBehaviorAction_3074);
			types.add(UMLElementTypes.CallOperationAction_3075);
			types.add(UMLElementTypes.StructuredActivityNode_3076);
			types.add(UMLElementTypes.StructuredActivityNode_3079);
			types.add(UMLElementTypes.InputPin_3080);
			types.add(UMLElementTypes.OutputPin_3081);
			types.add(UMLElementTypes.SendSignalAction_3077);
			types.add(UMLElementTypes.LoopNode_3078);
			types.add(UMLElementTypes.ConditionalNode_3083);
			types.add(UMLElementTypes.ExpansionRegion_3085);
			types.add(UMLElementTypes.ValueSpecificationAction_3088);
			types.add(UMLElementTypes.OutputPin_3090);
			types.add(UMLElementTypes.LoopNode_3058);
			types.add(UMLElementTypes.ConditionalNode_3082);
			types.add(UMLElementTypes.ExpansionRegion_3084);
			types.add(UMLElementTypes.ExpansionNode_3091);
			types.add(UMLElementTypes.ParameterSet_3086);
			types.add(UMLElementTypes.Parameter_3087);
			types.add(UMLElementTypes.ValueSpecificationAction_3089);
		}
		return types;
	}

	/**
	* @generated
	*/
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		return types;
	}

	/**
	* @generated
	*/
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4007) {
			types.add(UMLElementTypes.Comment_2029);
		}
		return types;
	}

	/**
	* @generated
	*/
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		handleFeatureLinkModification(event);
	}

	/**
	 * @generated
	 */
	public class CommentFigure extends CommentFigureBase {

		/**
		 * @generated
		 */
		public CommentFigure() {

			this.setTextLabelWrap(true);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getBodyLabel() {
			return super.getBodyLabel();
		}

	}

	/**
	* @generated
	*/
	private void handleFeatureLinkModification(Notification event) {
		if (event.getFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
			guardedRefreshDiagram();
			return;
		}
	}

	/**
	* @generated
	*/
	private boolean isCanonicalDisabled() {
		if (isCanonicalDisabled(getEditPolicy(EditPolicyRoles.CANONICAL_ROLE))) {
			return true;
		}
		if (getParent() != null && isCanonicalDisabled(getParent().getEditPolicy(EditPolicyRoles.CANONICAL_ROLE))) {
			return true;
		}
		//this particular edit part may not have editpolicy at all, 
		//but its compartments still may have it
		EObject semantic = resolveSemanticElement();
		if (semantic != null) {
			for (Object next : CanonicalEditPolicy.getRegisteredEditPolicies(semantic)) {
				if (next instanceof EditPolicy) {
					EditPolicy nextEP = (EditPolicy) next;
					if (isCanonicalDisabled(nextEP)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	* @generated
	*/
	private static boolean isCanonicalDisabled(EditPolicy editPolicy) {
		return editPolicy instanceof CanonicalEditPolicy && !((CanonicalEditPolicy) editPolicy).isEnabled();
	}

	/**
	* @generated
	*/
	private void guardedRefreshDiagram() {
		if (!isCanonicalDisabled()) {
			UMLDiagramUpdateCommand.performCanonicalUpdate(getDiagramView().getElement());
		}
	}

}
