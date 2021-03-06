package org.eclipse.uml2.diagram.clazz.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.clazz.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateableElement;

/**
 * @generated
 */
public class TemplateBindingReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public TemplateBindingReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof TemplateBinding) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof TemplateableElement && newEnd instanceof TemplateableElement)) {
			return false;
		}
		TemplateableElement target = getLink().getSignature().getTemplate();
		if (!(getLink().eContainer() instanceof TemplateableElement)) {
			return false;
		}
		TemplateableElement container = (TemplateableElement) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistTemplateBinding_4016(container, getLink(), getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof TemplateableElement && newEnd instanceof TemplateableElement)) {
			return false;
		}
		TemplateableElement source = getLink().getBoundElement();
		if (!(getLink().eContainer() instanceof TemplateableElement)) {
			return false;
		}
		TemplateableElement container = (TemplateableElement) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistTemplateBinding_4016(container, getLink(), source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setBoundElement(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setSignature(getNewTarget().getOwnedTemplateSignature());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected TemplateBinding getLink() {
		return (TemplateBinding) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected TemplateableElement getOldSource() {
		return (TemplateableElement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected TemplateableElement getNewSource() {
		return (TemplateableElement) newEnd;
	}

	/**
	 * @generated
	 */
	protected TemplateableElement getOldTarget() {
		return (TemplateableElement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected TemplateableElement getNewTarget() {
		return (TemplateableElement) newEnd;
	}
}
