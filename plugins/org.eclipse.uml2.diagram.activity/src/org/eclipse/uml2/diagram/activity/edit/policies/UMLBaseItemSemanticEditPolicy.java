package org.eclipse.uml2.diagram.activity.edit.policies;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IEditHelperContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.activity.edit.helpers.UMLBaseEditHelper;
import org.eclipse.uml2.diagram.activity.expressions.UMLAbstractExpression;
import org.eclipse.uml2.diagram.activity.expressions.UMLOCLFactory;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLBaseItemSemanticEditPolicy extends SemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getSemanticCommand(IEditCommandRequest request) {
		IEditCommandRequest completedRequest = completeRequest(request);
		Object editHelperContext = completedRequest.getEditHelperContext();
		if (editHelperContext instanceof View || (editHelperContext instanceof IEditHelperContext && ((IEditHelperContext) editHelperContext).getEObject() instanceof View)) {
			// no semantic commands are provided for pure design elements
			return null;
		}
		if (editHelperContext == null) {
			editHelperContext = ViewUtil.resolveSemanticElement((View) getHost().getModel());
		}
		IElementType elementType = ElementTypeRegistry.getInstance().getElementType(editHelperContext);
		if (elementType == ElementTypeRegistry.getInstance().getType("org.eclipse.gmf.runtime.emf.type.core.default")) { //$NON-NLS-1$ 
			elementType = null;
		}
		Command epCommand = getSemanticCommandSwitch(completedRequest);
		if (epCommand != null) {
			ICommand command = epCommand instanceof ICommandProxy ? ((ICommandProxy) epCommand).getICommand() : new CommandProxy(epCommand);
			completedRequest.setParameter(UMLBaseEditHelper.EDIT_POLICY_COMMAND, command);
		}
		Command ehCommand = null;
		if (elementType != null) {
			ICommand command = elementType.getEditCommand(completedRequest);
			if (command != null) {
				if (!(command instanceof CompositeTransactionalCommand)) {
					TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
					command = new CompositeTransactionalCommand(editingDomain, null).compose(command);
				}
				ehCommand = new ICommandProxy(command);
			}
		}
		boolean shouldProceed = true;
		if (completedRequest instanceof DestroyRequest) {
			shouldProceed = shouldProceed((DestroyRequest) completedRequest);
		}
		if (shouldProceed) {
			if (completedRequest instanceof DestroyRequest) {
				TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
				Command deleteViewCommand = new ICommandProxy(new DeleteCommand(editingDomain, (View) getHost().getModel()));
				ehCommand = ehCommand == null ? deleteViewCommand : ehCommand.chain(deleteViewCommand);
			}
			return ehCommand;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommandSwitch(IEditCommandRequest req) {
		if (req instanceof CreateRelationshipRequest) {
			return getCreateRelationshipCommand((CreateRelationshipRequest) req);
		} else if (req instanceof CreateElementRequest) {
			return getCreateCommand((CreateElementRequest) req);
		} else if (req instanceof ConfigureRequest) {
			return getConfigureCommand((ConfigureRequest) req);
		} else if (req instanceof DestroyElementRequest) {
			return getDestroyElementCommand((DestroyElementRequest) req);
		} else if (req instanceof DestroyReferenceRequest) {
			return getDestroyReferenceCommand((DestroyReferenceRequest) req);
		} else if (req instanceof DuplicateElementsRequest) {
			return getDuplicateCommand((DuplicateElementsRequest) req);
		} else if (req instanceof GetEditContextRequest) {
			return getEditContextCommand((GetEditContextRequest) req);
		} else if (req instanceof MoveRequest) {
			return getMoveCommand((MoveRequest) req);
		} else if (req instanceof ReorientReferenceRelationshipRequest) {
			return getReorientReferenceRelationshipCommand((ReorientReferenceRelationshipRequest) req);
		} else if (req instanceof ReorientRelationshipRequest) {
			return getReorientRelationshipCommand((ReorientRelationshipRequest) req);
		} else if (req instanceof SetRequest) {
			return getSetCommand((SetRequest) req);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getConfigureCommand(ConfigureRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getSetCommand(SetRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getEditContextCommand(GetEditContextRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getMoveCommand(MoveRequest req) {
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * @generated
	 */
	protected Command getMSLWrapper(ICommand cmd) {
		return new ICommandProxy(cmd);
	}

	/**
	 * @generated
	 */
	protected EObject getSemanticElement() {
		return ViewUtil.resolveSemanticElement((View) getHost().getModel());
	}

	/**
	 * Finds container element for the new relationship of the specified type.
	 * Default implementation goes up by containment hierarchy starting from
	 * the specified element and returns the first element that is instance of
	 * the specified container class.
	 * 
	 * @generated
	 */
	protected EObject getRelationshipContainer(EObject element, EClass containerClass, IElementType relationshipType) {
		for (; element != null; element = element.eContainer()) {
			if (containerClass.isSuperTypeOf(element.eClass())) {
				return element;
			}
		}
		return null;
	}

	/**
	 * @generated 
	 */
	protected static class LinkConstraints {

		/**
		 * @generated 
		 */
		public static final LinkConstraints ControlFlow_4001 = createControlFlow_4001();

		/**
		 * @generated 
		 */
		private static LinkConstraints createControlFlow_4001() {
			Map sourceEnv = new HashMap(3);
			sourceEnv.put("oppositeEnd", org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getActivityNode()); //$NON-NLS-1$				
			UMLAbstractExpression sourceExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::ObjectNode) implies self.oclAsType(uml::ObjectNode).isControlType", //$NON-NLS-1$
					UMLPackage.eINSTANCE.getActivityNode(), sourceEnv);
			Map targetEnv = new HashMap(3);
			targetEnv.put("oppositeEnd", org.eclipse.uml2.uml.UMLPackage.eINSTANCE.getActivityNode()); //$NON-NLS-1$
			UMLAbstractExpression targetExpression = UMLOCLFactory.getExpression("self.oclIsKindOf(uml::ObjectNode) implies self.oclAsType(uml::ObjectNode).isControlType", //$NON-NLS-1$
					UMLPackage.eINSTANCE.getActivityNode(), targetEnv);
			return new LinkConstraints(sourceExpression, targetExpression);
		}

		/**
		 * @generated 
		 */
		private static final String OPPOSITE_END_VAR = "oppositeEnd"; //$NON-NLS-1$

		/**
		 * @generated 
		 */
		private UMLAbstractExpression srcEndInv;

		/**
		 * @generated 
		 */
		private UMLAbstractExpression targetEndInv;

		/**
		 * @generated 
		 */
		public LinkConstraints(UMLAbstractExpression sourceEnd, UMLAbstractExpression targetEnd) {
			this.srcEndInv = sourceEnd;
			this.targetEndInv = targetEnd;
		}

		/**
		 * @generated 
		 */
		public boolean canCreateLink(CreateRelationshipRequest req, boolean isBackDirected) {
			Object source = req.getSource();
			Object target = req.getTarget();

			UMLAbstractExpression sourceConstraint = isBackDirected ? targetEndInv : srcEndInv;
			UMLAbstractExpression targetConstraint = null;
			if (req.getTarget() != null) {
				targetConstraint = isBackDirected ? srcEndInv : targetEndInv;
			}
			boolean isSourceAccepted = sourceConstraint != null ? evaluate(sourceConstraint, source, target, false) : true;
			if (isSourceAccepted && targetConstraint != null) {
				return evaluate(targetConstraint, target, source, true);
			}
			return isSourceAccepted;
		}

		/**
		 * @generated 
		 */
		private static boolean evaluate(UMLAbstractExpression constraint, Object sourceEnd, Object oppositeEnd, boolean clearEnv) {
			Map evalEnv = Collections.singletonMap(OPPOSITE_END_VAR, oppositeEnd);
			try {
				Object val = constraint.evaluate(sourceEnd, evalEnv);
				return (val instanceof Boolean) ? ((Boolean) val).booleanValue() : false;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}
	}
}
