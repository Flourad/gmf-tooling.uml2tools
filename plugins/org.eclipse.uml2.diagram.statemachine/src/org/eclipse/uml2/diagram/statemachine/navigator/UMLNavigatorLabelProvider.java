package org.eclipse.uml2.diagram.statemachine.navigator;

import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;

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
import org.eclipse.uml2.diagram.statemachine.edit.parts.State2EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.State3EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachine2EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachineEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateMachineNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateName2EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateName3EditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.StateNameEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.TransitionEditPart;

import org.eclipse.uml2.diagram.statemachine.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.statemachine.part.UMLVisualIDRegistry;

import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.statemachine.providers.UMLParserProvider;

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
		case StateMachine2EditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://www.eclipse.org/uml2/2.1.0/UML?StateMachine", UMLElementTypes.StateMachine_2004);
		case RegionEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Region", UMLElementTypes.Region_3013);
		case StateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?State", UMLElementTypes.State_3001);
		case State2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?State", UMLElementTypes.State_3012);
		case Region2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Region", UMLElementTypes.Region_3002);
		case State3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?State", UMLElementTypes.State_3016);
		case ConnectionPointReferenceEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?ConnectionPointReference", UMLElementTypes.ConnectionPointReference_3017);
		case ConnectionPointReference2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?ConnectionPointReference", UMLElementTypes.ConnectionPointReference_3018);
		case FinalStateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?FinalState", UMLElementTypes.FinalState_3003);
		case PseudostateEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3004);
		case Pseudostate2EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3005);
		case Pseudostate3EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3006);
		case Pseudostate4EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3007);
		case Pseudostate5EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3008);
		case Pseudostate6EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3009);
		case Pseudostate7EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3010);
		case Pseudostate8EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3011);
		case Pseudostate9EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3014);
		case Pseudostate10EditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://www.eclipse.org/uml2/2.1.0/UML?Pseudostate", UMLElementTypes.Pseudostate_3015);
		case StateMachineEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://www.eclipse.org/uml2/2.1.0/UML?StateMachine", UMLElementTypes.StateMachine_1000);
		case TransitionEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://www.eclipse.org/uml2/2.1.0/UML?Transition", UMLElementTypes.Transition_4001);
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
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case StateMachine2EditPart.VISUAL_ID:
			return getStateMachine_2004Text(view);
		case RegionEditPart.VISUAL_ID:
			return getRegion_3013Text(view);
		case StateEditPart.VISUAL_ID:
			return getState_3001Text(view);
		case State2EditPart.VISUAL_ID:
			return getState_3012Text(view);
		case Region2EditPart.VISUAL_ID:
			return getRegion_3002Text(view);
		case State3EditPart.VISUAL_ID:
			return getState_3016Text(view);
		case ConnectionPointReferenceEditPart.VISUAL_ID:
			return getConnectionPointReference_3017Text(view);
		case ConnectionPointReference2EditPart.VISUAL_ID:
			return getConnectionPointReference_3018Text(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_3003Text(view);
		case PseudostateEditPart.VISUAL_ID:
			return getPseudostate_3004Text(view);
		case Pseudostate2EditPart.VISUAL_ID:
			return getPseudostate_3005Text(view);
		case Pseudostate3EditPart.VISUAL_ID:
			return getPseudostate_3006Text(view);
		case Pseudostate4EditPart.VISUAL_ID:
			return getPseudostate_3007Text(view);
		case Pseudostate5EditPart.VISUAL_ID:
			return getPseudostate_3008Text(view);
		case Pseudostate6EditPart.VISUAL_ID:
			return getPseudostate_3009Text(view);
		case Pseudostate7EditPart.VISUAL_ID:
			return getPseudostate_3010Text(view);
		case Pseudostate8EditPart.VISUAL_ID:
			return getPseudostate_3011Text(view);
		case Pseudostate9EditPart.VISUAL_ID:
			return getPseudostate_3014Text(view);
		case Pseudostate10EditPart.VISUAL_ID:
			return getPseudostate_3015Text(view);
		case StateMachineEditPart.VISUAL_ID:
			return getStateMachine_1000Text(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001Text(view);
		default:
			return getUnknownElementText(view);
		}
	}

	/**
	 * @generated
	 */
	private String getStateMachine_2004Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(UMLElementTypes.StateMachine_2004, (view.getElement() != null ? view.getElement() : view), UMLVisualIDRegistry
				.getType(StateMachineNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5005);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getRegion_3013Text(View view) {
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
	private String getState_3001Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(UMLElementTypes.State_3001, (view.getElement() != null ? view.getElement() : view), UMLVisualIDRegistry
				.getType(StateNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getState_3012Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(UMLElementTypes.State_3012, (view.getElement() != null ? view.getElement() : view), UMLVisualIDRegistry
				.getType(StateName3EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5004);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getRegion_3002Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3002);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getState_3016Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(UMLElementTypes.State_3016, (view.getElement() != null ? view.getElement() : view), UMLVisualIDRegistry
				.getType(StateName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5008);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getConnectionPointReference_3017Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(UMLElementTypes.ConnectionPointReference_3017, (view.getElement() != null ? view.getElement() : view), UMLVisualIDRegistry
				.getType(ConnectionPointReferenceNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5009);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getConnectionPointReference_3018Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(UMLElementTypes.ConnectionPointReference_3018, (view.getElement() != null ? view.getElement() : view), UMLVisualIDRegistry
				.getType(ConnectionPointReferenceName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5010);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getFinalState_3003Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3003);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3004Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3004);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3005Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3005);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3006Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3006);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3007Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3007);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3008Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3008);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3009Text(View view) {
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
	private String getPseudostate_3010Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3010);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3011Text(View view) {
		EObject domainModelElement = view.getElement();
		if (domainModelElement != null) {
			return String.valueOf(((NamedElement) domainModelElement).getName());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 3011);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3014Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(UMLElementTypes.Pseudostate_3014, (view.getElement() != null ? view.getElement() : view), UMLVisualIDRegistry
				.getType(PseudostateNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5006);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3015Text(View view) {
		IAdaptable hintAdapter = new UMLParserProvider.HintAdapter(UMLElementTypes.Pseudostate_3015, (view.getElement() != null ? view.getElement() : view), UMLVisualIDRegistry
				.getType(PseudostateName2EditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE.intValue());
		} else {
			UMLDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5007);
			return "";
		}
	}

	/**
	 * @generated
	 */
	private String getStateMachine_1000Text(View view) {
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
	private String getTransition_4001Text(View view) {
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
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">";
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">";
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
		return StateMachineEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(view));
	}

}
