package org.eclipse.uml2.diagram.clazz.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.diagram.clazz.edit.commands.ConstraintConstrainedElementCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.ConstraintConstrainedElementReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DependencyClientCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DependencyClientReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DependencyLinkCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DependencyLinkReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DependencySupplierCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.DependencySupplierReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.RealizationCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.RealizationReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.UsageCreateCommand;
import org.eclipse.uml2.diagram.clazz.edit.commands.UsageReorientCommand;
import org.eclipse.uml2.diagram.clazz.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Dependency2EditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencyClientEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.DependencySupplierEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.RealizationEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.UsageEditPart;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;

/**
 * @generated
 */
public class ExpressionItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyShortcutsCommand(cc);
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
		if (UMLElementTypes.Dependency_4002 == req.getElementType()) {
			return getGEFWrapper(new DependencyLinkCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4004 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.DependencySupplier_4006 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.DependencyClient_4007 == req.getElementType()) {
			return null;
		}
		if (UMLElementTypes.Realization_4010 == req.getElementType()) {
			return getGEFWrapper(new RealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Usage_4013 == req.getElementType()) {
			return getGEFWrapper(new UsageCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (UMLElementTypes.Dependency_4002 == req.getElementType()) {
			return getGEFWrapper(new DependencyLinkCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.ConstraintConstrainedElement_4004 == req.getElementType()) {
			return getGEFWrapper(new ConstraintConstrainedElementCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.DependencySupplier_4006 == req.getElementType()) {
			return getGEFWrapper(new DependencySupplierCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.DependencyClient_4007 == req.getElementType()) {
			return getGEFWrapper(new DependencyClientCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Realization_4010 == req.getElementType()) {
			return getGEFWrapper(new RealizationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (UMLElementTypes.Usage_4013 == req.getElementType()) {
			return getGEFWrapper(new UsageCreateCommand(req, req.getSource(), req.getTarget()));
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
		case Dependency2EditPart.VISUAL_ID:
			return getGEFWrapper(new DependencyLinkReorientCommand(req));
		case RealizationEditPart.VISUAL_ID:
			return getGEFWrapper(new RealizationReorientCommand(req));
		case UsageEditPart.VISUAL_ID:
			return getGEFWrapper(new UsageReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return getGEFWrapper(new ConstraintConstrainedElementReorientCommand(req));
		case DependencySupplierEditPart.VISUAL_ID:
			return getGEFWrapper(new DependencySupplierReorientCommand(req));
		case DependencyClientEditPart.VISUAL_ID:
			return getGEFWrapper(new DependencyClientReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}