package org.eclipse.uml2.diagram.component.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ClassDiagramNotationInnerClassCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	public ClassDiagramNotationInnerClassCreateCommand(CreateElementRequest req) {
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
		return UMLPackage.eINSTANCE.getClass_();
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		Class newElement = (Class) super.doDefaultElementCreation();
		if (newElement != null) {
			UMLElementTypes.Initializers.Class_3013.init(newElement);
		}
		return newElement;
	}

}
