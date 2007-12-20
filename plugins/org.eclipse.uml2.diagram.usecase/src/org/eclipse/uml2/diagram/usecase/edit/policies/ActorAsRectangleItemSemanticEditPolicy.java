package org.eclipse.uml2.diagram.usecase.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.usecase.edit.commands.AssociationCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.commands.AssociationReorientCommand;
import org.eclipse.uml2.diagram.usecase.edit.commands.GeneralizationCreateCommand;
import org.eclipse.uml2.diagram.usecase.edit.commands.GeneralizationReorientCommand;
import org.eclipse.uml2.diagram.usecase.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.usecase.edit.parts.GeneralizationEditPart;
import org.eclipse.uml2.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class ActorAsRectangleItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyShortcutsCommand(cc);
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			req.setElementToDestroy(view);
		}
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req) : getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Generalization_4003 == req.getElementType()) {
			return getGEFWrapper(new GeneralizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Association_4004 == req.getElementType()) {
			return getGEFWrapper(new AssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Generalization_4003 == req.getElementType()) {
			return getGEFWrapper(new GeneralizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Association_4004 == req.getElementType()) {
			return getGEFWrapper(new AssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case GeneralizationEditPart.VISUAL_ID:
			return getGEFWrapper(new GeneralizationReorientCommand(req));
		case AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new AssociationReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}