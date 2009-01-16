package org.eclipse.uml2.diagram.common.validation;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.uml.OCL;
import org.eclipse.ocl.uml.OCL.Helper;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.ValueSpecification;

public class OCLFromStereoConstraint extends AbstractModelConstraint {

	private static final String OCL_LANGUAGE = "OCL";

	final private OCL myOCL = org.eclipse.ocl.uml.OCL.newInstance();

	@Override
	public IStatus validate(IValidationContext ctx) {
		Element selected = (Element) ctx.getTarget();
		Helper oclHelper = myOCL.createOCLHelper();
		for (Stereotype stereo : selected.getApplicableStereotypes()) {
			oclHelper.setContext(stereo);
			for (Constraint c : getConstraints(stereo)) {
				try {
					boolean success = runConstraintOn(oclHelper, selected, c);
					if (!success) {
						String name = (selected instanceof NamedElement)? ((NamedElement)selected).getName(): "";
						return ctx.createFailureStatus(name, stereo.getName(), c.getName());
					}
				} catch (ParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ctx.createSuccessStatus();
	}

	private boolean runConstraintOn(Helper oclHelper, Element selected, Constraint umlConstraint) throws ParserException {
		String body = getOCLConstraintBody(umlConstraint);
		Constraint constraint = oclHelper.createInvariant(body);
		return myOCL.check(selected, constraint);
	}

	private String getOCLConstraintBody(Constraint umlConstraint) {
		ValueSpecification s = umlConstraint.getSpecification();
		if (s != null && s instanceof OpaqueExpression) {
			OpaqueExpression e = (OpaqueExpression) s;
			if (!e.getLanguages().isEmpty() && OCL_LANGUAGE.equals(e.getLanguages().get(0))) {
				EList<String> bodies = e.getBodies();
				return bodies.isEmpty() ? null : bodies.get(0);
			}
		}
		return null;
	}

	private static final List<Constraint> getConstraints(EObject stereotype) {
		LinkedList<Constraint> result = new LinkedList<Constraint>();
		for (EObject next : getReferencingObjects(stereotype)) {
			if (isConstraintFor(next, stereotype)) {
				result.add((Constraint) next);
			}
		}
		return result;
	}

	private static boolean isConstraintFor(EObject constraint, EObject constrainedElement) {
		return constraint instanceof Constraint && ((Constraint) constraint).getConstrainedElements().contains(constrainedElement);
	}

	private static final List<EObject> getReferencingObjects(EObject target) {
		LinkedList<EObject> result = new LinkedList<EObject>();
		Collection<EStructuralFeature.Setting> settings = CrossReferencer.find(target.eResource().getContents()).get(target);
		if (settings == null) {
			return Collections.emptyList();
		}
		for (Setting setting : settings) {
			result.add(setting.getEObject());
		}
		return result;
	}

}