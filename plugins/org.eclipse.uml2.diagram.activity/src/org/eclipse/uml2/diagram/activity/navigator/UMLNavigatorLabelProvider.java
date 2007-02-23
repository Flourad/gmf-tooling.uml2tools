package org.eclipse.uml2.diagram.activity.navigator;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;

import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;

import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;

import org.eclipse.swt.graphics.Image;

import org.eclipse.ui.IMemento;

import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import org.eclipse.uml2.diagram.activity.edit.parts.AcceptEventAction2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AcceptEventAction3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AcceptEventAction4EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActionLocalPreconditionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityFinalNode2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityFinalNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityParameterNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityParameterNodeNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AddStructuralFeatureValueAction2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AddStructuralFeatureValueActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AddStructuralFeatureValueActionName2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AddStructuralFeatureValueActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallBehaviorAction2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallBehaviorActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallBehaviorActionName2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallBehaviorActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallOperationAction2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallOperationActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallOperationActionName2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallOperationActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CentralBufferNode2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CentralBufferNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.Constraint2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CreateObjectAction2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CreateObjectActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CreateObjectActionName2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CreateObjectActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.DataStoreNode2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.DataStoreNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.DecisionNode2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.DecisionNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ExceptionHandlerEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.FlowFinalNode2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.FlowFinalNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ForkNode2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ForkNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.InputPin2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.InputPin3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.InputPin4EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.InputPin5EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.InputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.InputPinName2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.InputPinName3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.InputPinName4EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.InputPinName5EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.InputPinNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.JoinNode2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.JoinNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.LiteralString2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.LiteralStringEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.MergeNodeEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ObjectNodeSelectionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueAction2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueActionName2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueActionNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueBehaviorEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueBehaviorNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OutputPin2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OutputPin3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OutputPinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OutputPinName2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OutputPinName3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OutputPinNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.Pin2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.PinEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.PinName2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.PinNameEditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNodeEditPart;

import org.eclipse.uml2.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;

import org.eclipse.uml2.diagram.activity.providers.UMLElementTypes;

import org.eclipse.uml2.uml.NamedElement;

/**
 * @generated
 */
public class UMLNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?InvalidElement", ImageDescriptor.getMissingImageDescriptor());
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor());
		UMLDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof UMLNavigatorItem && !isOwnView(((UMLNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup) element;
			return UMLDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.0.0/UML?Activity", UMLElementTypes.Activity_2026);
		case ConstraintEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.0.0/UML?Constraint", UMLElementTypes.Constraint_2027);
		case Constraint2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.0.0/UML?Constraint", UMLElementTypes.Constraint_2028);
		case AcceptEventActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?AcceptEventAction", UMLElementTypes.AcceptEventAction_3030);
		case AcceptEventAction2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?AcceptEventAction", UMLElementTypes.AcceptEventAction_3031);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?ActivityFinalNode", UMLElementTypes.ActivityFinalNode_3032);
		case DecisionNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?DecisionNode", UMLElementTypes.DecisionNode_3033);
		case MergeNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?MergeNode", UMLElementTypes.MergeNode_3034);
		case InitialNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?InitialNode", UMLElementTypes.InitialNode_3035);
		case DataStoreNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?DataStoreNode", UMLElementTypes.DataStoreNode_3036);
		case CentralBufferNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?CentralBufferNode", UMLElementTypes.CentralBufferNode_3037);
		case OpaqueActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?OpaqueAction", UMLElementTypes.OpaqueAction_3029);
		case OutputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3001);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?FlowFinalNode", UMLElementTypes.FlowFinalNode_3038);
		case ForkNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?ForkNode", UMLElementTypes.ForkNode_3039);
		case JoinNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?JoinNode", UMLElementTypes.JoinNode_3040);
		case PinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?Pin", UMLElementTypes.Pin_3041);
		case CreateObjectActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?CreateObjectAction", UMLElementTypes.CreateObjectAction_3042);
		case OutputPin2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3002);
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?AddStructuralFeatureValueAction", UMLElementTypes.AddStructuralFeatureValueAction_3043);
		case InputPinEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?InputPin", UMLElementTypes.InputPin_3003);
		case InputPin2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?InputPin", UMLElementTypes.InputPin_3004);
		case InputPin3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?InputPin", UMLElementTypes.InputPin_3005);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?CallBehaviorAction", UMLElementTypes.CallBehaviorAction_3044);
		case OutputPin3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?OutputPin", UMLElementTypes.OutputPin_3006);
		case InputPin4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?InputPin", UMLElementTypes.InputPin_3007);
		case CallOperationActionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?CallOperationAction", UMLElementTypes.CallOperationAction_3045);
		case InputPin5EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?InputPin", UMLElementTypes.InputPin_3008);
		case StructuredActivityNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?StructuredActivityNode", UMLElementTypes.StructuredActivityNode_3046);
		case StructuredActivityNode2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?StructuredActivityNode", UMLElementTypes.StructuredActivityNode_3009);
		case OpaqueAction2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?OpaqueAction", UMLElementTypes.OpaqueAction_3011);
		case AcceptEventAction3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?AcceptEventAction", UMLElementTypes.AcceptEventAction_3012);
		case AcceptEventAction4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?AcceptEventAction", UMLElementTypes.AcceptEventAction_3013);
		case ActivityFinalNode2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?ActivityFinalNode", UMLElementTypes.ActivityFinalNode_3014);
		case DecisionNode2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?DecisionNode", UMLElementTypes.DecisionNode_3015);
		case FlowFinalNode2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?FlowFinalNode", UMLElementTypes.FlowFinalNode_3016);
		case Pin2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?Pin", UMLElementTypes.Pin_3017);
		case CreateObjectAction2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?CreateObjectAction", UMLElementTypes.CreateObjectAction_3018);
		case CallBehaviorAction2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?CallBehaviorAction", UMLElementTypes.CallBehaviorAction_3019);
		case CallOperationAction2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?CallOperationAction", UMLElementTypes.CallOperationAction_3020);
		case ForkNode2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?ForkNode", UMLElementTypes.ForkNode_3021);
		case JoinNode2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?JoinNode", UMLElementTypes.JoinNode_3022);
		case AddStructuralFeatureValueAction2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?AddStructuralFeatureValueAction", UMLElementTypes.AddStructuralFeatureValueAction_3023);
		case DataStoreNode2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?DataStoreNode", UMLElementTypes.DataStoreNode_3024);
		case CentralBufferNode2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?CentralBufferNode", UMLElementTypes.CentralBufferNode_3025);
		case OpaqueBehaviorEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?OpaqueBehavior", UMLElementTypes.OpaqueBehavior_3047);
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?ActivityParameterNode", UMLElementTypes.ActivityParameterNode_3052);
		case LiteralStringEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?LiteralString", UMLElementTypes.LiteralString_3049);
		case LiteralString2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.0.0/UML?LiteralString", UMLElementTypes.LiteralString_3051);
		case PackageEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/uml2/2.0.0/UML?Package", UMLElementTypes.Package_1000);
		case ControlFlowEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.0.0/UML?ControlFlow", UMLElementTypes.ControlFlow_4001);
		case ObjectFlowEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.0.0/UML?ObjectFlow", UMLElementTypes.ObjectFlow_4002);
		case ActionLocalPreconditionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.0.0/UML?Action?localPrecondition", UMLElementTypes.ActionLocalPrecondition_4003);
		case ObjectNodeSelectionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.0.0/UML?ObjectNode?selection", UMLElementTypes.ObjectNodeSelection_4004);
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.0.0/UML?ExceptionHandler", UMLElementTypes.ExceptionHandler_4005);
		default:
			return getImage("Navigator?UnknownElement", null);
		}
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = UMLDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && UMLElementTypes.isKnownElementType(elementType)) {
			image = UMLElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound");
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof UMLNavigatorGroup) {
			UMLNavigatorGroup group = (UMLNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof UMLNavigatorItem) {
			UMLNavigatorItem navigatorItem = (UMLNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2026Text(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2027Text(view);
		case Constraint2EditPart.VISUAL_ID:
			return getConstraint_2028Text(view);
		case AcceptEventActionEditPart.VISUAL_ID:
			return getAcceptEventAction_3030Text(view);
		case AcceptEventAction2EditPart.VISUAL_ID:
			return getAcceptEventAction_3031Text(view);
		case ActivityFinalNodeEditPart.VISUAL_ID:
			return getActivityFinalNode_3032Text(view);
		case DecisionNodeEditPart.VISUAL_ID:
			return getDecisionNode_3033Text(view);
		case MergeNodeEditPart.VISUAL_ID:
			return getMergeNode_3034Text(view);
		case InitialNodeEditPart.VISUAL_ID:
			return getInitialNode_3035Text(view);
		case DataStoreNodeEditPart.VISUAL_ID:
			return getDataStoreNode_3036Text(view);
		case CentralBufferNodeEditPart.VISUAL_ID:
			return getCentralBufferNode_3037Text(view);
		case OpaqueActionEditPart.VISUAL_ID:
			return getOpaqueAction_3029Text(view);
		case OutputPinEditPart.VISUAL_ID:
			return getOutputPin_3001Text(view);
		case FlowFinalNodeEditPart.VISUAL_ID:
			return getFlowFinalNode_3038Text(view);
		case ForkNodeEditPart.VISUAL_ID:
			return getForkNode_3039Text(view);
		case JoinNodeEditPart.VISUAL_ID:
			return getJoinNode_3040Text(view);
		case PinEditPart.VISUAL_ID:
			return getPin_3041Text(view);
		case CreateObjectActionEditPart.VISUAL_ID:
			return getCreateObjectAction_3042Text(view);
		case OutputPin2EditPart.VISUAL_ID:
			return getOutputPin_3002Text(view);
		case AddStructuralFeatureValueActionEditPart.VISUAL_ID:
			return getAddStructuralFeatureValueAction_3043Text(view);
		case InputPinEditPart.VISUAL_ID:
			return getInputPin_3003Text(view);
		case InputPin2EditPart.VISUAL_ID:
			return getInputPin_3004Text(view);
		case InputPin3EditPart.VISUAL_ID:
			return getInputPin_3005Text(view);
		case CallBehaviorActionEditPart.VISUAL_ID:
			return getCallBehaviorAction_3044Text(view);
		case OutputPin3EditPart.VISUAL_ID:
			return getOutputPin_3006Text(view);
		case InputPin4EditPart.VISUAL_ID:
			return getInputPin_3007Text(view);
		case CallOperationActionEditPart.VISUAL_ID:
			return getCallOperationAction_3045Text(view);
		case InputPin5EditPart.VISUAL_ID:
			return getInputPin_3008Text(view);
		case StructuredActivityNodeEditPart.VISUAL_ID:
			return getStructuredActivityNode_3046Text(view);
		case StructuredActivityNode2EditPart.VISUAL_ID:
			return getStructuredActivityNode_3009Text(view);
		case OpaqueAction2EditPart.VISUAL_ID:
			return getOpaqueAction_3011Text(view);
		case AcceptEventAction3EditPart.VISUAL_ID:
			return getAcceptEventAction_3012Text(view);
		case AcceptEventAction4EditPart.VISUAL_ID:
			return getAcceptEventAction_3013Text(view);
		case ActivityFinalNode2EditPart.VISUAL_ID:
			return getActivityFinalNode_3014Text(view);
		case DecisionNode2EditPart.VISUAL_ID:
			return getDecisionNode_3015Text(view);
		case FlowFinalNode2EditPart.VISUAL_ID:
			return getFlowFinalNode_3016Text(view);
		case Pin2EditPart.VISUAL_ID:
			return getPin_3017Text(view);
		case CreateObjectAction2EditPart.VISUAL_ID:
			return getCreateObjectAction_3018Text(view);
		case CallBehaviorAction2EditPart.VISUAL_ID:
			return getCallBehaviorAction_3019Text(view);
		case CallOperationAction2EditPart.VISUAL_ID:
			return getCallOperationAction_3020Text(view);
		case ForkNode2EditPart.VISUAL_ID:
			return getForkNode_3021Text(view);
		case JoinNode2EditPart.VISUAL_ID:
			return getJoinNode_3022Text(view);
		case AddStructuralFeatureValueAction2EditPart.VISUAL_ID:
			return getAddStructuralFeatureValueAction_3023Text(view);
		case DataStoreNode2EditPart.VISUAL_ID:
			return getDataStoreNode_3024Text(view);
		case CentralBufferNode2EditPart.VISUAL_ID:
			return getCentralBufferNode_3025Text(view);
		case OpaqueBehaviorEditPart.VISUAL_ID:
			return getOpaqueBehavior_3047Text(view);
		case ActivityParameterNodeEditPart.VISUAL_ID:
			return getActivityParameterNode_3052Text(view);
		case LiteralStringEditPart.VISUAL_ID:
			return getLiteralString_3049Text(view);
		case LiteralString2EditPart.VISUAL_ID:
			return getLiteralString_3051Text(view);
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000Text(view);
		case ControlFlowEditPart.VISUAL_ID:
			return getControlFlow_4001Text(view);
		case ObjectFlowEditPart.VISUAL_ID:
			return getObjectFlow_4002Text(view);
		case ActionLocalPreconditionEditPart.VISUAL_ID:
			return getActionLocalPrecondition_4003Text(view);
		case ObjectNodeSelectionEditPart.VISUAL_ID:
			return getObjectNodeSelection_4004Text(view);
		case ExceptionHandlerEditPart.VISUAL_ID:
			return getExceptionHandler_4005Text(view);
		default:
			return getUnknownElementText(view);
		}
	}

	/**
	 * @generated
	 */
	private String getActivity_2026Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(ActivityNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.Activity_2026;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5030);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_2027Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2027);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getConstraint_2028Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 2028);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getAcceptEventAction_3030Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3030);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getAcceptEventAction_3031Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3031);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getActivityFinalNode_3032Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3032);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getDecisionNode_3033Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3033);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getMergeNode_3034Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3034);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getInitialNode_3035Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3035);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getDataStoreNode_3036Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3036);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getCentralBufferNode_3037Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3037);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getOpaqueAction_3029Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(OpaqueActionNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.OpaqueAction_3029;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5023);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3001Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(OutputPinNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.OutputPin_3001;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5003);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getFlowFinalNode_3038Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3038);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getForkNode_3039Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3039);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getJoinNode_3040Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3040);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getPin_3041Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(PinNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.Pin_3041;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5024);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getCreateObjectAction_3042Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(CreateObjectActionNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.CreateObjectAction_3042;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5025);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3002Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(OutputPinName2EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.OutputPin_3002;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getAddStructuralFeatureValueAction_3043Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.AddStructuralFeatureValueAction_3043;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5026);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3003Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(InputPinNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.InputPin_3003;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3004Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(InputPinName2EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.InputPin_3004;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3005Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(InputPinName3EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.InputPin_3005;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5008);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getCallBehaviorAction_3044Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(CallBehaviorActionNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.CallBehaviorAction_3044;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5027);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getOutputPin_3006Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(OutputPinName3EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.OutputPin_3006;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5010);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3007Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(InputPinName4EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.InputPin_3007;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5011);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getCallOperationAction_3045Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(CallOperationActionNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.CallOperationAction_3045;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5028);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getInputPin_3008Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(InputPinName5EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.InputPin_3008;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5013);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getStructuredActivityNode_3046Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3046);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getStructuredActivityNode_3009Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3009);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getOpaqueAction_3011Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(OpaqueActionName2EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.OpaqueAction_3011;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5015);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getAcceptEventAction_3012Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3012);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getAcceptEventAction_3013Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3013);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getActivityFinalNode_3014Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3014);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getDecisionNode_3015Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3015);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getFlowFinalNode_3016Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3016);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getPin_3017Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(PinName2EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.Pin_3017;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5016);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getCreateObjectAction_3018Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(CreateObjectActionName2EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.CreateObjectAction_3018;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5017);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getCallBehaviorAction_3019Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(CallBehaviorActionName2EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.CallBehaviorAction_3019;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5018);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getCallOperationAction_3020Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(CallOperationActionName2EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.CallOperationAction_3020;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5019);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getForkNode_3021Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3021);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getJoinNode_3022Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3022);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getAddStructuralFeatureValueAction_3023Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(AddStructuralFeatureValueActionName2EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.AddStructuralFeatureValueAction_3023;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5020);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getDataStoreNode_3024Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3024);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getCentralBufferNode_3025Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3025);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getOpaqueBehavior_3047Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(OpaqueBehaviorNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.OpaqueBehavior_3047;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5029);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getActivityParameterNode_3052Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(ActivityParameterNodeNameEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.ActivityParameterNode_3052;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5031);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getLiteralString_3049Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(LiteralStringEditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.LiteralString_3049;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3049);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getLiteralString_3051Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return UMLVisualIDRegistry.getType(LiteralString2EditPart.VISUAL_ID);
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.LiteralString_3051;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 3051);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getPackage_1000Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getControlFlow_4001Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getObjectFlow_4002Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 4002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getActionLocalPrecondition_4003Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getObjectNodeSelection_4004Text(View view) {
		return "";
	}

	/**
	 * @generated
	 */
	private String getExceptionHandler_4005Text(View view) {
		IParser parser = ParserService.getInstance().getParser(new IAdaptable() {

			public Object getAdapter(Class adapter) {
				if (String.class.equals(adapter)) {
					return CommonParserHint.DESCRIPTION;
				}
				if (IElementType.class.equals(adapter)) {
					return UMLElementTypes.ExceptionHandler_4005;
				}
				return null;
			}
		});
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view), ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 6002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">";
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}

}
