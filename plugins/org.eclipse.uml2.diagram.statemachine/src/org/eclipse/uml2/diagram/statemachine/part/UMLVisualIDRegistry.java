package org.eclipse.uml2.diagram.statemachine.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.statemachine.edit.parts.Behavior2EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.Behavior3EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.BehaviorEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ConnectionPointReference2EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ConnectionPointReferenceEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ConnectionPointReferenceName2EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.ConnectionPointReferenceNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.FinalStateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.Pseudostate10EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.Pseudostate2EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.Pseudostate3EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.Pseudostate4EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.Pseudostate5EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.Pseudostate6EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.Pseudostate7EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.Pseudostate8EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.Pseudostate9EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.PseudostateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.PseudostateName2EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.PseudostateNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.Region2EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.RegionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.RegionSubvertices2EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.RegionSubverticesEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.State2EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.State3EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateCompositeState_InternalActivities2EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateCompositeState_InternalActivitiesEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachine2EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateName2EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateName3EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateSimpleState_InternalActivitiesEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.TransitionEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.TransitionNameEditPart;
import org.eclipse.uml2.diagram.statemachine.expressions.UMLAbstractExpression;
import org.eclipse.uml2.diagram.statemachine.expressions.UMLOCLFactory;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class UMLVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = UMLDiagramEditorPlugin.getInstance().getBundle().getSymbolicName() + "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression State_3001_Constraint = UMLOCLFactory.getExpression("self.oclIsTypeOf(uml::State) and self.isSimple", UMLPackage.eINSTANCE.getState());

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression State_3012_Constraint = UMLOCLFactory.getExpression("self.oclIsTypeOf(uml::State) and self.isComposite", UMLPackage.eINSTANCE.getState());

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression State_3016_Constraint = UMLOCLFactory.getExpression("self.oclIsTypeOf(uml::State) and self.isSubmachineState", UMLPackage.eINSTANCE.getState());

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression ConnectionPointReference_3017_Constraint = UMLOCLFactory.getExpression(
			"entry->notEmpty() implies entry->forAll(e | e.kind =  PseudostateKind::entryPoint)", UMLPackage.eINSTANCE.getConnectionPointReference());

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression ConnectionPointReference_3018_Constraint = UMLOCLFactory.getExpression(
			"exit->notEmpty() implies exit->forAll(e | e.kind =  PseudostateKind::exitPoint)", UMLPackage.eINSTANCE.getConnectionPointReference());

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression Pseudostate_3004_Constraint = UMLOCLFactory.getExpression("self.kind = PseudostateKind::initial", UMLPackage.eINSTANCE.getPseudostate());

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression Pseudostate_3005_Constraint = UMLOCLFactory.getExpression("self.kind = PseudostateKind::shallowHistory", UMLPackage.eINSTANCE.getPseudostate());

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression Pseudostate_3006_Constraint = UMLOCLFactory.getExpression("self.kind = PseudostateKind::deepHistory", UMLPackage.eINSTANCE.getPseudostate());

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression Pseudostate_3007_Constraint = UMLOCLFactory.getExpression("self.kind = PseudostateKind::fork", UMLPackage.eINSTANCE.getPseudostate());

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression Pseudostate_3008_Constraint = UMLOCLFactory.getExpression("self.kind = PseudostateKind::join", UMLPackage.eINSTANCE.getPseudostate());

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression Pseudostate_3009_Constraint = UMLOCLFactory.getExpression("self.kind = PseudostateKind::junction", UMLPackage.eINSTANCE.getPseudostate());

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression Pseudostate_3010_Constraint = UMLOCLFactory.getExpression("self.kind = PseudostateKind::choice", UMLPackage.eINSTANCE.getPseudostate());

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression Pseudostate_3011_Constraint = UMLOCLFactory.getExpression("self.kind = PseudostateKind::terminate", UMLPackage.eINSTANCE.getPseudostate());

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression Pseudostate_3014_Constraint = UMLOCLFactory.getExpression("self.kind = PseudostateKind::entryPoint", UMLPackage.eINSTANCE.getPseudostate());

	/**
	 * @generated
	 */
	private static final UMLAbstractExpression Pseudostate_3015_Constraint = UMLOCLFactory.getExpression("self.kind = PseudostateKind::exitPoint", UMLPackage.eINSTANCE.getPseudostate());

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (StateMachineEditPart.MODEL_ID.equals(view.getType())) {
				return StateMachineEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.uml2.diagram.statemachine.part.UMLVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				UMLDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getStateMachine().isSuperTypeOf(domainElement.eClass()) && isDiagram((StateMachine) domainElement)) {
			return StateMachineEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.uml2.diagram.statemachine.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!StateMachineEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (StateMachineEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.uml2.diagram.statemachine.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = StateMachineEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case StateMachine2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRegion().isSuperTypeOf(domainElement.eClass())) {
				return RegionEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3014_Constraint, domainElement)) {
				return Pseudostate9EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3015_Constraint, domainElement)) {
				return Pseudostate10EditPart.VISUAL_ID;
			}
			break;
		case State2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRegion().isSuperTypeOf(domainElement.eClass())) {
				return Region2EditPart.VISUAL_ID;
			}
			break;
		case State3EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getRegion().isSuperTypeOf(domainElement.eClass())) {
				return Region2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConnectionPointReference().isSuperTypeOf(domainElement.eClass()) && evaluate(ConnectionPointReference_3017_Constraint, domainElement)) {
				return ConnectionPointReferenceEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getConnectionPointReference().isSuperTypeOf(domainElement.eClass()) && evaluate(ConnectionPointReference_3018_Constraint, domainElement)) {
				return ConnectionPointReference2EditPart.VISUAL_ID;
			}
			break;
		case RegionSubverticesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(domainElement.eClass()) && evaluate(State_3001_Constraint, domainElement)) {
				return StateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(domainElement.eClass()) && evaluate(State_3012_Constraint, domainElement)) {
				return State2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(domainElement.eClass()) && evaluate(State_3016_Constraint, domainElement)) {
				return State3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFinalState().isSuperTypeOf(domainElement.eClass())) {
				return FinalStateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3004_Constraint, domainElement)) {
				return PseudostateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3005_Constraint, domainElement)) {
				return Pseudostate2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3006_Constraint, domainElement)) {
				return Pseudostate3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3007_Constraint, domainElement)) {
				return Pseudostate4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3008_Constraint, domainElement)) {
				return Pseudostate5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3009_Constraint, domainElement)) {
				return Pseudostate6EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3010_Constraint, domainElement)) {
				return Pseudostate7EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3011_Constraint, domainElement)) {
				return Pseudostate8EditPart.VISUAL_ID;
			}
			break;
		case StateSimpleState_InternalActivitiesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getBehavior().isSuperTypeOf(domainElement.eClass()) && JavaConstraints.isEntryActivity((Behavior) domainElement).booleanValue()) {
				return BehaviorEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getBehavior().isSuperTypeOf(domainElement.eClass()) && JavaConstraints.isExitActivity((Behavior) domainElement).booleanValue()) {
				return Behavior2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getBehavior().isSuperTypeOf(domainElement.eClass()) && JavaConstraints.isDoActivity((Behavior) domainElement).booleanValue()) {
				return Behavior3EditPart.VISUAL_ID;
			}
			break;
		case StateCompositeState_InternalActivitiesEditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getBehavior().isSuperTypeOf(domainElement.eClass()) && JavaConstraints.isEntryActivity((Behavior) domainElement).booleanValue()) {
				return BehaviorEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getBehavior().isSuperTypeOf(domainElement.eClass()) && JavaConstraints.isExitActivity((Behavior) domainElement).booleanValue()) {
				return Behavior2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getBehavior().isSuperTypeOf(domainElement.eClass()) && JavaConstraints.isDoActivity((Behavior) domainElement).booleanValue()) {
				return Behavior3EditPart.VISUAL_ID;
			}
			break;
		case RegionSubvertices2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(domainElement.eClass()) && evaluate(State_3001_Constraint, domainElement)) {
				return StateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(domainElement.eClass()) && evaluate(State_3012_Constraint, domainElement)) {
				return State2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getState().isSuperTypeOf(domainElement.eClass()) && evaluate(State_3016_Constraint, domainElement)) {
				return State3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getFinalState().isSuperTypeOf(domainElement.eClass())) {
				return FinalStateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3004_Constraint, domainElement)) {
				return PseudostateEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3005_Constraint, domainElement)) {
				return Pseudostate2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3006_Constraint, domainElement)) {
				return Pseudostate3EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3007_Constraint, domainElement)) {
				return Pseudostate4EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3008_Constraint, domainElement)) {
				return Pseudostate5EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3009_Constraint, domainElement)) {
				return Pseudostate6EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3010_Constraint, domainElement)) {
				return Pseudostate7EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getPseudostate().isSuperTypeOf(domainElement.eClass()) && evaluate(Pseudostate_3011_Constraint, domainElement)) {
				return Pseudostate8EditPart.VISUAL_ID;
			}
			break;
		case StateCompositeState_InternalActivities2EditPart.VISUAL_ID:
			if (UMLPackage.eINSTANCE.getBehavior().isSuperTypeOf(domainElement.eClass()) && JavaConstraints.isEntryActivity((Behavior) domainElement).booleanValue()) {
				return BehaviorEditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getBehavior().isSuperTypeOf(domainElement.eClass()) && JavaConstraints.isExitActivity((Behavior) domainElement).booleanValue()) {
				return Behavior2EditPart.VISUAL_ID;
			}
			if (UMLPackage.eINSTANCE.getBehavior().isSuperTypeOf(domainElement.eClass()) && JavaConstraints.isDoActivity((Behavior) domainElement).booleanValue()) {
				return Behavior3EditPart.VISUAL_ID;
			}
			break;
		case StateMachineEditPart.VISUAL_ID:
			// We want to additionally show the Canvas Semantical Element in the auxiliary 
			// org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachine2EditPart (that serves as a pure visual container for children). 
			// To do this, we modified CanonicalEditPolicy to add the Canvas semantic Element into the children 
			// list. The only remaining part is to return correct VID for this special case.

			if (containerView instanceof Diagram && domainElement != null && domainElement.equals(containerView.getElement())) {
				return StateMachine2EditPart.VISUAL_ID;
			}
			// Diagram header is already processed above
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.uml2.diagram.statemachine.part.UMLVisualIDRegistry.getModelID(containerView);
		if (!StateMachineEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (StateMachineEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.uml2.diagram.statemachine.part.UMLVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = StateMachineEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case StateMachine2EditPart.VISUAL_ID:
			if (StateMachineNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RegionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate9EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate10EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RegionEditPart.VISUAL_ID:
			if (RegionSubverticesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateEditPart.VISUAL_ID:
			if (StateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateSimpleState_InternalActivitiesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case State2EditPart.VISUAL_ID:
			if (StateName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateCompositeState_InternalActivitiesEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Region2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Region2EditPart.VISUAL_ID:
			if (RegionSubvertices2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case State3EditPart.VISUAL_ID:
			if (StateName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateCompositeState_InternalActivities2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Region2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConnectionPointReferenceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ConnectionPointReference2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConnectionPointReferenceEditPart.VISUAL_ID:
			if (ConnectionPointReferenceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ConnectionPointReference2EditPart.VISUAL_ID:
			if (ConnectionPointReferenceName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Pseudostate9EditPart.VISUAL_ID:
			if (PseudostateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Pseudostate10EditPart.VISUAL_ID:
			if (PseudostateName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RegionSubverticesEditPart.VISUAL_ID:
			if (StateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (State2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (State3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FinalStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateSimpleState_InternalActivitiesEditPart.VISUAL_ID:
			if (BehaviorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Behavior2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Behavior3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateCompositeState_InternalActivitiesEditPart.VISUAL_ID:
			if (BehaviorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Behavior2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Behavior3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RegionSubvertices2EditPart.VISUAL_ID:
			if (StateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (State2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (State3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FinalStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate6EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate7EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate8EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateCompositeState_InternalActivities2EditPart.VISUAL_ID:
			if (BehaviorEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Behavior2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Behavior3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateMachineEditPart.VISUAL_ID:
			if (StateMachine2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TransitionEditPart.VISUAL_ID:
			if (TransitionNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (UMLPackage.eINSTANCE.getTransition().isSuperTypeOf(domainElement.eClass())) {
			return TransitionEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(StateMachine element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean evaluate(UMLAbstractExpression expression, Object element) {
		Object result = expression.evaluate(element);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static class JavaConstraints {

		/**
		 * @generated NOT
		 */
		private static java.lang.Boolean isEntryActivity(Behavior self) {
			Element owner = self.getOwner();
			if (owner instanceof State) {
				State state = (State) owner;
				if (state.getEntry().equals(self)) {
					return Boolean.TRUE;
				}
			}
			return Boolean.FALSE;
		}

		/**
		 * @generated NOT
		 */
		private static java.lang.Boolean isExitActivity(Behavior self) {
			Element owner = self.getOwner();
			if (owner instanceof State) {
				State state = (State) owner;
				if (state.getExit().equals(self)) {
					return Boolean.TRUE;
				}
			}
			return Boolean.FALSE;
		}

		/**
		 * @generated NOT
		 */
		private static java.lang.Boolean isDoActivity(Behavior self) {
			Element owner = self.getOwner();
			if (owner instanceof State) {
				State state = (State) owner;
				if (state.getDoActivity().equals(self)) {
					return Boolean.TRUE;
				}
			}
			return Boolean.FALSE;
		}

	}

	/**
	 * @generated
	 */
	protected static boolean hasViewChild(View containerView, EObject domainElement, int visualId) {
		if (domainElement == null) {
			return false;
		}
		for (Object next : containerView.getChildren()) {
			View nextView = (View) next;
			if (domainElement.equals(nextView.getElement()) && getType(visualId).equals(nextView.getType())) {
				return true;
			}
		}
		return false;
	}

}
