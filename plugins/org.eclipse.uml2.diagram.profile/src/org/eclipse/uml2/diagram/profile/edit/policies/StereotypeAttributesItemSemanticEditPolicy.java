package org.eclipse.uml2.diagram.profile.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.uml2.diagram.profile.edit.commands.PropertyCreateCommand;
import org.eclipse.uml2.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class StereotypeAttributesItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Property_3001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getStructuredClassifier_OwnedAttribute());
			}
			return getGEFWrapper(new PropertyCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}
