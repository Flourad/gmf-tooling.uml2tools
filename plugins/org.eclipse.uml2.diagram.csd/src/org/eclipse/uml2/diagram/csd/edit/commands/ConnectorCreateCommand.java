package org.eclipse.uml2.diagram.csd.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.uml2.diagram.csd.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ConnectorCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	private final EObject source;

	/**
	 * @generated
	 */
	private final EObject target;

	/**
	 * @generated
	 */
	private StructuredClassifier container;

	/**
	 * @generated
	 */
	public ConnectorCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request);
		this.source = source;
		this.target = target;
		if (request.getContainmentFeature() == null) {
			setContainmentFeature(UMLPackage.eINSTANCE.getStructuredClassifier_OwnedConnector());
		}

		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null; element = element.eContainer()) {
			if (element instanceof StructuredClassifier) {
				container = (StructuredClassifier) element;
				super.setElementToEdit(container);
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && !(source instanceof ConnectableElement)) {
			return false;
		}
		if (target != null && !(target instanceof ConnectableElement)) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if (getContainer() == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canCreateConnector_4005(getContainer(), getSource(), getTarget());
	}

	/**
	 * @generated NOT
	 */
	protected EObject doDefaultElementCreation() {
		// org.eclipse.uml2.uml.Connector newElement = (org.eclipse.uml2.uml.Connector) super.doDefaultElementCreation();
		Connector newElement = UMLFactory.eINSTANCE.createConnector();
		getContainer().getOwnedConnectors().add(newElement);
		newElement.createEnd().setRole(getSource());
		newElement.createEnd().setRole(getTarget());
		return newElement;
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return UMLPackage.eINSTANCE.getStructuredClassifier();
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		return super.doExecuteWithResult(monitor, info);
	}

	/**
	 * @generated
	 */
	protected ConfigureRequest createConfigureRequest() {
		ConfigureRequest request = super.createConfigureRequest();
		request.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		request.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		return request;
	}

	/**
	 * @generated
	 */
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected ConnectableElement getSource() {
		return (ConnectableElement) source;
	}

	/**
	 * @generated
	 */
	protected ConnectableElement getTarget() {
		return (ConnectableElement) target;
	}

	/**
	 * @generated
	 */
	public StructuredClassifier getContainer() {
		return container;
	}
}
