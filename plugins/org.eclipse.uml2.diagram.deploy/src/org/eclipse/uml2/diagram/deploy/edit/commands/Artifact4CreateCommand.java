package org.eclipse.uml2.diagram.deploy.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */

public class Artifact4CreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	public Artifact4CreateCommand(CreateElementRequest req) {
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
		return UMLPackage.eINSTANCE.getArtifact();
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		Artifact newElement = UMLFactory.eINSTANCE.createArtifact();

		Artifact owner = (Artifact) getElementToEdit();
		owner.getNestedArtifacts().add(newElement);
		UMLElementTypes.init_Artifact_3008(newElement);
		return newElement;
	}
}