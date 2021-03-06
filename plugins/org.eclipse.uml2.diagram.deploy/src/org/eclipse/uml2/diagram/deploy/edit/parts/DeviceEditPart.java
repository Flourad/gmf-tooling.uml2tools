package org.eclipse.uml2.diagram.deploy.edit.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.draw2d.Cube3DFigure;
import org.eclipse.uml2.diagram.common.draw2d.StereotypeLabel;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.deploy.edit.policies.DeviceCanonicalEditPolicy;
import org.eclipse.uml2.diagram.deploy.edit.policies.DeviceGraphicalNodeEditPolicy;
import org.eclipse.uml2.diagram.deploy.edit.policies.DeviceItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.deploy.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.deploy.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.deploy.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class DeviceEditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2003;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	private LinkTargetListener myLinkTargetListener;

	/**
	 * @generated
	 */
	public DeviceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		if (UMLVisualIDRegistry.isShortcutDescendant(getNotationView())) {
			installEditPolicy(UpdateDescriptionEditPolicy.ROLE, new UpdateDescriptionEditPolicy(UMLDiagramUpdater.TYPED_ADAPTER, true));
		}
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DeviceItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new DeviceGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AsyncDiagramComponentEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new DeviceFigure();
	}

	/**
	 * @generated
	 */
	public DeviceFigure getPrimaryShape() {
		return (DeviceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof DeviceNameEditPart) {
			((DeviceNameEditPart) childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if (childEditPart instanceof DeviceStereoEditPart) {
			((DeviceStereoEditPart) childEditPart).setLabel(getPrimaryShape().getDeviceTypeLabel());
			return true;
		}
		if (childEditPart instanceof DeviceDevicecontentsEditPart) {
			IFigure pane = getPrimaryShape().getContentPane();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((DeviceDevicecontentsEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof DeviceDevicecontentsEditPart) {
			IFigure pane = getPrimaryShape().getContentPane();
			pane.remove(((DeviceDevicecontentsEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof DeviceDevicecontentsEditPart) {
			return getPrimaryShape().getContentPane();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(100, 60);
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		// #265822 Improve appearance of selection feedback
		ResizableEditPolicy result = new U2TResizableShapeEditPolicy();
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(DeviceNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.Deployment_4001);
		types.add(UMLElementTypes.CommunicationPath_4004);
		types.add(UMLElementTypes.Dependency_4005);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(4);
		types.add(UMLElementTypes.Manifestation_4002);
		types.add(UMLElementTypes.CommunicationPath_4004);
		types.add(UMLElementTypes.Dependency_4005);
		types.add(UMLElementTypes.CommentAnnotatedElement_4006);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof Artifact2EditPart) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if (targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if (targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if (targetEditPart instanceof Artifact4EditPart) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if (targetEditPart instanceof DeploymentSpecification2EditPart) {
			types.add(UMLElementTypes.Deployment_4001);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.deploy.edit.parts.DeviceEditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof NodeEditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof ExecutionEnvironmentEditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof Artifact2EditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof Device2EditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof Artifact4EditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof DeploymentSpecification2EditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof ExecutionEnvironment2EditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof Node2EditPart) {
			types.add(UMLElementTypes.CommunicationPath_4004);
		}
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.deploy.edit.parts.DeviceEditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof NodeEditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof ExecutionEnvironmentEditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof Artifact2EditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof Device2EditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof Artifact4EditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof DeploymentSpecification2EditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof ExecutionEnvironment2EditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		if (targetEditPart instanceof Node2EditPart) {
			types.add(UMLElementTypes.Dependency_4005);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.DeploymentSpecification_2007);
			types.add(UMLElementTypes.Artifact_3002);
			types.add(UMLElementTypes.Artifact_3008);
			types.add(UMLElementTypes.DeploymentSpecification_3009);
		} else if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Node_2004);
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.DeploymentSpecification_2007);
			types.add(UMLElementTypes.Device_3004);
			types.add(UMLElementTypes.Artifact_3002);
			types.add(UMLElementTypes.Artifact_3008);
			types.add(UMLElementTypes.DeploymentSpecification_3009);
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
			types.add(UMLElementTypes.Node_3007);
		} else if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Package_2001);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Node_2004);
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.DeploymentSpecification_2007);
			types.add(UMLElementTypes.Device_3004);
			types.add(UMLElementTypes.Artifact_3002);
			types.add(UMLElementTypes.Artifact_3008);
			types.add(UMLElementTypes.DeploymentSpecification_3009);
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
			types.add(UMLElementTypes.Node_3007);
		} else if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4006) {
			types.add(UMLElementTypes.Comment_2008);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.DeploymentSpecification_2007);
			types.add(UMLElementTypes.Artifact_3002);
			types.add(UMLElementTypes.Artifact_3008);
			types.add(UMLElementTypes.DeploymentSpecification_3009);
		} else if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Node_2004);
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.DeploymentSpecification_2007);
			types.add(UMLElementTypes.Device_3004);
			types.add(UMLElementTypes.Artifact_3002);
			types.add(UMLElementTypes.Artifact_3008);
			types.add(UMLElementTypes.DeploymentSpecification_3009);
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
			types.add(UMLElementTypes.Node_3007);
		} else if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Package_2001);
			types.add(UMLElementTypes.Device_2003);
			types.add(UMLElementTypes.Node_2004);
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
			types.add(UMLElementTypes.Artifact_2006);
			types.add(UMLElementTypes.DeploymentSpecification_2007);
			types.add(UMLElementTypes.Device_3004);
			types.add(UMLElementTypes.Artifact_3002);
			types.add(UMLElementTypes.Artifact_3008);
			types.add(UMLElementTypes.DeploymentSpecification_3009);
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
			types.add(UMLElementTypes.Node_3007);
		}
		return types;
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		if (event.getNotifier() == getModel() && EcorePackage.eINSTANCE.getEModelElement_EAnnotations().equals(event.getFeature())) {
			handleMajorSemanticChange();
		} else {
			super.handleNotificationEvent(event);
		}
		handleTypeLinkModification(event);
	}

	/**
	 * @generated
	 */
	private DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = getEditingDomain();
		if (theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private LinkTargetListener getLinkTargetListener() {
		if (myLinkTargetListener == null) {
			myLinkTargetListener = new LinkTargetListener();
		}
		return myLinkTargetListener;
	}

	/**
	 * @generated
	 */
	private class LinkTargetListener implements NotificationListener {

		/**
		 * @generated
		 */
		Map<EObject, Set<EStructuralFeature>> myNotifiers = new HashMap<EObject, Set<EStructuralFeature>>();

		/**
		 * @generated
		 */
		private void added(EObject link, EStructuralFeature feature) {
			if (!myNotifiers.containsKey(link)) {
				myNotifiers.put(link, new HashSet<EStructuralFeature>());
			}
			myNotifiers.get(link).add(feature);
		}

		/**
		 * @generated
		 */
		private void removed(EObject link, EStructuralFeature feature) {
			if (!myNotifiers.containsKey(link)) {
				return;
			}
			myNotifiers.get(link).remove(feature);
		}

		/**
		 * @generated
		 */
		public void dispose() {
			Set<Map.Entry<EObject, Set<EStructuralFeature>>> entrySet = myNotifiers.entrySet();
			for (Map.Entry<EObject, Set<EStructuralFeature>> entry : entrySet) {
				for (EStructuralFeature feature : entry.getValue()) {
					getDiagramEventBroker().removeNotificationListener(entry.getKey(), feature, this);
				}
			}
		}

		/**
		 * @generated
		 */
		private void removeReferenceListener(EObject link, EStructuralFeature feature) {
			getDiagramEventBroker().removeNotificationListener(link, feature, this);
			removed(link, feature);
		}

		/**
		 * @generated
		 */
		private void addReferenceListener(EObject link, EStructuralFeature feature) {
			getDiagramEventBroker().addNotificationListener(link, feature, this);
			added(link, feature);
		}

		/**
		 * @generated
		 */
		public void notifyChanged(Notification event) {
			if (event.getFeature() == UMLPackage.eINSTANCE.getDeployment_DeployedArtifact()) {
				guardedRefreshDiagram();
				return;
			}
		}
	}

	/**
	 * @generated
	 */
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		for (IUpdaterNodeDescriptor next : getDevice_2003ContainedLinks()) {
			EObject nextLink = next.getModelElement();
			if (nextLink == null) {
				continue;
			}
			switch (next.getVisualID()) {
			case DeploymentEditPart.VISUAL_ID:
				getLinkTargetListener().addReferenceListener(nextLink, UMLPackage.eINSTANCE.getDeployment_DeployedArtifact());
				break;

			default:
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	private List<? extends IUpdaterLinkDescriptor> getDevice_2003ContainedLinks() {
		return UMLDiagramUpdater.getDevice_2003ContainedLinks(getNotationView());
	}

	/**
	 * @generated
	 */
	protected void removeSemanticListeners() {
		super.removeSemanticListeners();
		getLinkTargetListener().dispose();
	}

	/**
	 * @generated
	 */
	private void handleTypeLinkModification(Notification event) {
		if (event.getFeature() == UMLPackage.eINSTANCE.getDeploymentTarget_Deployment()) {
			switch (event.getEventType()) {
			case Notification.ADD: {
				Object link = event.getNewValue();
				if (link instanceof Deployment) {
					getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getDeployment_DeployedArtifact());
				}
				if (link instanceof Deployment) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.REMOVE: {
				Object link = event.getOldValue();
				if (link instanceof Deployment) {
					getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getDeployment_DeployedArtifact());
				}
				if (link instanceof Deployment) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.ADD_MANY: {
				List<?> links = (List<?>) event.getNewValue();
				for (Object link : links) {
					if (link instanceof Deployment) {
						getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getDeployment_DeployedArtifact());
					}
				}
				for (Object link : links) {
					if (link instanceof Deployment) {
						guardedRefreshDiagram();
						break;
					}
				}
				break;
			}
			case Notification.REMOVE_MANY: {
				List<?> links = (List<?>) event.getOldValue();
				for (Object link : links) {
					if (link instanceof Deployment) {
						getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getDeployment_DeployedArtifact());
					}
				}
				for (Object link : links) {
					if (link instanceof Deployment) {
						guardedRefreshDiagram();
						break;
					}
				}
				break;
			}
			}
		}
	}

	/**
	 * @generated
	 */
	private boolean isCanonicalDisabled() {
		if (isCanonicalDisabled(getEditPolicy(EditPolicyRoles.CANONICAL_ROLE))) {
			return true;
		}
		if (getParent() != null && isCanonicalDisabled(getParent().getEditPolicy(EditPolicyRoles.CANONICAL_ROLE))) {
			return true;
		}
		//this particular edit part may not have editpolicy at all, 
		//but its compartments still may have it
		EObject semantic = resolveSemanticElement();
		if (semantic != null) {
			for (Object next : CanonicalEditPolicy.getRegisteredEditPolicies(semantic)) {
				if (next instanceof EditPolicy) {
					EditPolicy nextEP = (EditPolicy) next;
					if (isCanonicalDisabled(nextEP)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static boolean isCanonicalDisabled(EditPolicy editPolicy) {
		return editPolicy instanceof CanonicalEditPolicy && !((CanonicalEditPolicy) editPolicy).isEnabled();
	}

	/**
	 * @generated
	 */
	private void guardedRefreshDiagram() {
		if (!isCanonicalDisabled()) {
			UMLDiagramUpdateCommand.performCanonicalUpdate(getDiagramView().getElement());
		}
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest unspecifiedRequest = (CreateUnspecifiedTypeRequest) request;
			List<IElementType> types = unspecifiedRequest.getElementTypes();
			if (types.contains(UMLElementTypes.Device_3004)) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(DeviceDevicecontentsEditPart.VISUAL_ID));
			}
			if (types.contains(UMLElementTypes.Artifact_3002)) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(DeviceDevicecontentsEditPart.VISUAL_ID));
			}
			if (types.contains(UMLElementTypes.ExecutionEnvironment_3005)) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(DeviceDevicecontentsEditPart.VISUAL_ID));
			}
			if (types.contains(UMLElementTypes.Node_3007)) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(DeviceDevicecontentsEditPart.VISUAL_ID));
			}
		}

		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class DeviceFigure extends Cube3DFigure {

		/**
		 * @generated
		 */
		public DeviceFigure() {

			this.setTypeLabelVisible(true);

		}

		/**
		 * @generated
		 */
		public Label getNameLabel() {
			return super.getNameLabel();
		}

		/**
		 * @generated
		 */
		public RectangleFigure getContentPane() {
			return super.getContentPane();
		}

		/**
		 * @generated
		 */
		public StereotypeLabel getDeviceTypeLabel() {
			return getTypeLabel();
		}

	}

}
