package org.eclipse.uml2.diagram.csd.edit.helpers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class DependencyEditHelper extends UMLBaseEditHelper {

	/**
	 * @generated NOT
	 */
	public static final String PARAMETER_DEPENDENCY_TYPE = DependencyEditHelper.class.getName() + ":ConfigureDependencyKind"; //$NON-NLS-1$

	/**
	 * @generated NOT
	 */
	public static final String PARAMETER_DEPENDENCY_NAME = DependencyEditHelper.class.getName() + ":SetDependencyName"; //$NON-NLS-1$

	/**
	 * @generated NOT
	 */
	protected ICommand getAfterConfigureCommand(ConfigureRequest req) {
		if (req.getElementToConfigure() instanceof Dependency && req.getParameter(PARAMETER_DEPENDENCY_TYPE) instanceof String) {
			Dependency link = (Dependency) req.getElementToConfigure();
			String name = (String) req.getParameter(PARAMETER_DEPENDENCY_TYPE);
			SetRequest request = new SetRequest(link, UMLPackage.eINSTANCE.getNamedElement_Name(), name);
			SetValueCommand setType = new SetValueCommand(request);
			return setType;
		}
		return null;
	}
}
