package org.eclipse.uml2.diagram.activity.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class InputPin7CreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	public InputPin7CreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest()).getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return UMLPackage.eINSTANCE.getStructuredActivityNode();
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		InputPin newElement = (InputPin) super.doDefaultElementCreation();
		if (newElement != null) {
			UMLElementTypes.Initializers.InputPin_3080.init(newElement);
		}
		return newElement;
	}

}