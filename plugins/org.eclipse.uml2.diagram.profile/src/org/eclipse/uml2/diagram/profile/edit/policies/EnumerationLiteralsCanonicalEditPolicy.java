package org.eclipse.uml2.diagram.profile.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.profile.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Constraint2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ElementImport2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.EnumerationEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.EnumerationLiteralEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Profile2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Profile3EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.Stereotype2EditPart;
import org.eclipse.uml2.diagram.profile.edit.parts.StereotypeEditPart;
import org.eclipse.uml2.diagram.profile.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.profile.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class EnumerationLiteralsCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = UMLDiagramUpdater.getEnumerationLiterals_7004SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((IUpdaterNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case StereotypeEditPart.VISUAL_ID:
		case Profile2EditPart.VISUAL_ID:
		case EnumerationEditPart.VISUAL_ID:
		case ElementImportEditPart.VISUAL_ID:
		case Profile3EditPart.VISUAL_ID:
		case Constraint2EditPart.VISUAL_ID:
		case CommentEditPart.VISUAL_ID:
		case PropertyEditPart.VISUAL_ID:
		case ConstraintEditPart.VISUAL_ID:
		case Stereotype2EditPart.VISUAL_ID:
		case ElementImport2EditPart.VISUAL_ID:
			return true;
		case EnumerationLiteralEditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getEnumeration_OwnedLiteral());
		}
		return myFeaturesToSynchronize;
	}

}
