package org.eclipse.uml2.diagram.csd.edit.policies;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
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
import org.eclipse.uml2.diagram.csd.edit.helpers.UMLBaseEditHelper;
import org.eclipse.uml2.diagram.csd.expressions.UMLAbstractExpression;
import org.eclipse.uml2.diagram.csd.expressions.UMLOCLFactory;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.csd.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;

/**
 * @generated
 */
public class UMLBaseItemSemanticEditPolicy extends SemanticEditPolicy {

	/**
	 * Extended request data key to hold editpart visual id.
	 * 
	 * @generated
	 */
	public static final String VISUAL_ID_KEY = "visual_id"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private final IElementType myElementType;

	/**
	 * @generated
	 */
	protected UMLBaseItemSemanticEditPolicy(IElementType elementType) {
		myElementType = elementType;
	}

	/**
	 * Extended request data key to hold editpart visual id.
	 * Add visual id of edited editpart to extended data of the request
	 * so command switch can decide what kind of diagram element is being edited.
	 * It is done in those cases when it's not possible to deduce diagram
	 * element kind from domain element.
	 * 
	 * @generated
	 */
	public Command getCommand(Request request) {
		if (request instanceof ReconnectRequest) {
			Object view = ((ReconnectRequest) request).getConnectionEditPart().getModel();
			if (view instanceof View) {
				Integer id = new Integer(UMLVisualIDRegistry.getVisualID((View) view));
				request.getExtendedData().put(VISUAL_ID_KEY, id);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * Returns visual id from request parameters.
	 * 
	 * @generated
	 */
	protected int getVisualID(IEditCommandRequest request) {
		Object id = request.getParameter(VISUAL_ID_KEY);
		return id instanceof Integer ? ((Integer) id).intValue() : -1;
	}

	/**
	 * @generated
	 */
	protected Command getSemanticCommand(IEditCommandRequest request) {
		IEditCommandRequest completedRequest = completeRequest(request);
		Command semanticCommand = getSemanticCommandSwitch(completedRequest);
		semanticCommand = getEditHelperCommand(completedRequest, semanticCommand);
		if (completedRequest instanceof DestroyRequest) {
			DestroyRequest destroyRequest = (DestroyRequest) completedRequest;
			return shouldProceed(destroyRequest) ? addDeleteViewCommand(semanticCommand, destroyRequest) : null;
		}
		return semanticCommand;
	}

	/**
	 * @generated
	 */
	protected Command addDeleteViewCommand(Command mainCommand, DestroyRequest completedRequest) {
		Command deleteViewCommand = getGEFWrapper(new DeleteCommand(getEditingDomain(), (View) getHost().getModel()));
		return mainCommand == null ? deleteViewCommand : mainCommand.chain(deleteViewCommand);
	}

	/**
	 * @generated
	 */
	private Command getEditHelperCommand(IEditCommandRequest request, Command editPolicyCommand) {
		if (editPolicyCommand != null) {
			ICommand command = editPolicyCommand instanceof ICommandProxy ? ((ICommandProxy) editPolicyCommand).getICommand() : new CommandProxy(editPolicyCommand);
			request.setParameter(UMLBaseEditHelper.EDIT_POLICY_COMMAND, command);
		}
		IElementType requestContextElementType = getContextElementType(request);
		request.setParameter(UMLBaseEditHelper.CONTEXT_ELEMENT_TYPE, requestContextElementType);
		ICommand command = requestContextElementType.getEditCommand(request);
		request.setParameter(UMLBaseEditHelper.EDIT_POLICY_COMMAND, null);
		request.setParameter(UMLBaseEditHelper.CONTEXT_ELEMENT_TYPE, null);
		if (command != null) {
			if (!(command instanceof CompositeTransactionalCommand)) {
				command = new CompositeTransactionalCommand(getEditingDomain(), command.getLabel()).compose(command);
			}
			return new ICommandProxy(command);
		}
		return editPolicyCommand;
	}

	/**
	 * @generated
	 */
	private IElementType getContextElementType(IEditCommandRequest request) {
		IElementType requestContextElementType = UMLElementTypes.getElementType(getVisualID(request));
		return requestContextElementType != null ? requestContextElementType : myElementType;
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
	protected final Command getGEFWrapper(ICommand cmd) {
		return new ICommandProxy(cmd);
	}

	/**
	 * Returns editing domain from the host edit part.
	 * 
	 * @generated
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart) getHost()).getEditingDomain();
	}

	/**
	 * Clean all shortcuts to the host element from the same diagram
	 * @generated
	 */
	protected void addDestroyShortcutsCommand(ICompositeCommand cmd, View view) {
		assert view.getEAnnotation("Shortcut") == null; //$NON-NLS-1$
		for (Iterator it = view.getDiagram().getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (nextView.getEAnnotation("Shortcut") == null || !nextView.isSetElement() || nextView.getElement() != view.getElement()) { //$NON-NLS-1$
				continue;
			}
			cmd.add(new DeleteCommand(getEditingDomain(), nextView));
		}
	}

	/**
	 * @generated
	 */
	public static LinkConstraints getLinkConstraints() {
		LinkConstraints cached = UMLDiagramEditorPlugin.getInstance().getLinkConstraints();
		if (cached == null) {
			UMLDiagramEditorPlugin.getInstance().setLinkConstraints(cached = new LinkConstraints());
		}
		return cached;
	}

	/**
	 * @generated
	 */
	public static class LinkConstraints {

		/**
		 * @generated
		 */
		LinkConstraints() {
			// use static method #getLinkConstraints() to access instance
		}

		/**
		 * @generated
		 */
		public boolean canCreateConnector_4005(StructuredClassifier container, ConnectableElement source, ConnectableElement target) {
			return canExistConnector_4005(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateDependency_4006(CollaborationUse container, NamedElement source, NamedElement target) {
			return canExistDependency_4006(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateInterfaceRealization_4007(BehavioredClassifier container, BehavioredClassifier source, Interface target) {
			return canExistInterfaceRealization_4007(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateUsage_4008(Package container, NamedElement source, NamedElement target) {
			return canExistUsage_4008(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreatePortProvided_4010(Port source, Interface target) {
			if (source != null) {
				if (source.getProvideds().contains(target)) {
					return false;
				}
			}

			return canExistPortProvided_4010(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateAssociation_4011(Package container, Type source, Type target) {
			return canExistAssociation_4011(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateConstraintConstrainedElement_4012(Constraint source, Element target) {
			if (source != null) {
				if (source.getConstrainedElements().contains(target)) {
					return false;
				}
			}

			return canExistConstraintConstrainedElement_4012(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreatePortRequired_4014(Port source, Interface target) {
			if (source != null) {
				if (source.getRequireds().contains(target)) {
					return false;
				}
			}

			return canExistPortRequired_4014(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateSlot_4015(InstanceSpecification container, InstanceSpecification source, InstanceSpecification target) {
			return canExistSlot_4015(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateCommentAnnotatedElement_4016(Comment source, Element target) {
			if (source != null) {
				if (source.getAnnotatedElements().contains(target)) {
					return false;
				}
			}

			return canExistCommentAnnotatedElement_4016(source, target);
		}

		/**
		 * @generated
		 */
		public boolean canCreateDependency_4017(Package container, NamedElement source, NamedElement target) {
			return canExistDependency_4017(container, null, source, target);
		}

		/**
		 * @generated
		 */
		public static boolean canReallyCreateDependency_4017(NamedElement source, NamedElement target, EClass linkClass) {
			return canReallyExistDependency_4017(source, target, linkClass);
		}

		/**
		 * @generated
		 */
		public boolean canExistConnector_4005(StructuredClassifier container, Connector linkInstance, ConnectableElement source, ConnectableElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistDependency_4006(CollaborationUse container, Dependency linkInstance, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistInterfaceRealization_4007(BehavioredClassifier container, InterfaceRealization linkInstance, BehavioredClassifier source, Interface target) {
			try {
				if (target == null) {
					return true;
				} else {
					Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", UMLPackage.eINSTANCE.getBehavioredClassifier()); //$NON-NLS-1$
					Object targetVal = UMLOCLFactory.getExpression(26, UMLPackage.eINSTANCE.getInterface(), env).evaluate(target, Collections.singletonMap("oppositeEnd", source)); //$NON-NLS-1$
					if (false == targetVal instanceof Boolean || !((Boolean) targetVal).booleanValue()) {
						return false;
					} // else fall-through
				}
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public boolean canExistUsage_4008(Package container, Usage linkInstance, NamedElement source, NamedElement target) {
			try {
				if (source == null) {
					return true;
				} else {
					Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", UMLPackage.eINSTANCE.getNamedElement()); //$NON-NLS-1$
					Object sourceVal = UMLOCLFactory.getExpression(28, UMLPackage.eINSTANCE.getNamedElement(), env).evaluate(source, Collections.singletonMap("oppositeEnd", target)); //$NON-NLS-1$
					if (false == sourceVal instanceof Boolean || !((Boolean) sourceVal).booleanValue()) {
						return false;
					} // else fall-through
				}
				if (target == null) {
					return true;
				} else {
					Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", UMLPackage.eINSTANCE.getNamedElement()); //$NON-NLS-1$
					Object targetVal = UMLOCLFactory.getExpression(29, UMLPackage.eINSTANCE.getNamedElement(), env).evaluate(target, Collections.singletonMap("oppositeEnd", source)); //$NON-NLS-1$
					if (false == targetVal instanceof Boolean || !((Boolean) targetVal).booleanValue()) {
						return false;
					} // else fall-through
				}
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public boolean canExistPortProvided_4010(Port source, Interface target) {
			try {
				if (source == null) {
					return true;
				} else {
					Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", UMLPackage.eINSTANCE.getInterface()); //$NON-NLS-1$
					Object sourceVal = UMLOCLFactory.getExpression(30, UMLPackage.eINSTANCE.getPort(), env).evaluate(source, Collections.singletonMap("oppositeEnd", target)); //$NON-NLS-1$
					if (false == sourceVal instanceof Boolean || !((Boolean) sourceVal).booleanValue()) {
						return false;
					} // else fall-through
				}
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public boolean canExistAssociation_4011(Package container, Association linkInstance, Type source, Type target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistConstraintConstrainedElement_4012(Constraint source, Element target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistPortRequired_4014(Port source, Interface target) {
			try {
				if (source == null) {
					return true;
				} else {
					Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", UMLPackage.eINSTANCE.getInterface()); //$NON-NLS-1$
					Object sourceVal = UMLOCLFactory.getExpression(31, UMLPackage.eINSTANCE.getPort(), env).evaluate(source, Collections.singletonMap("oppositeEnd", target)); //$NON-NLS-1$
					if (false == sourceVal instanceof Boolean || !((Boolean) sourceVal).booleanValue()) {
						return false;
					} // else fall-through
				}
				return true;
			} catch (Exception e) {
				UMLDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", e); //$NON-NLS-1$
				return false;
			}
		}

		/**
		 * @generated
		 */
		public boolean canExistSlot_4015(InstanceSpecification container, Slot linkInstance, InstanceSpecification source, InstanceSpecification target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistCommentAnnotatedElement_4016(Comment source, Element target) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canExistDependency_4017(Package container, Dependency linkInstance, NamedElement source, NamedElement target) {
			return true;
		}

		/**
		 * @generated
		 */
		public static boolean canReallyExistDependency_4017(NamedElement source, NamedElement target, EClass linkClass) {
			if (UMLPackage.eINSTANCE.getUsage().isSuperTypeOf(linkClass)) {
				if ((source instanceof Classifier || source instanceof Port) && target instanceof Interface) {
					return false;
				}
			}
			return true;
		}

	}

}
