package org.eclipse.uml2.diagram.deploy.edit.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.deploy.edit.policies.Artifact4CanonicalEditPolicy;
import org.eclipse.uml2.diagram.deploy.edit.policies.Artifact4ItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.deploy.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.deploy.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.deploy.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.deploy.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */

public class Artifact4EditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3008;

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
	public Artifact4EditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Artifact4ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new Artifact4CanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

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
		ArtifactFigure figure = new ArtifactFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ArtifactFigure getPrimaryShape() {
		return (ArtifactFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ArtifactFileName3EditPart) {
			((ArtifactFileName3EditPart) childEditPart).setLabel(getPrimaryShape().getFigureArtifactFigure_name());
			return true;
		}
		if (childEditPart instanceof ArtifactArtifactFigure_contents2EditPart) {
			IFigure pane = getPrimaryShape().getFigureArtifactFigure_Body();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ArtifactArtifactFigure_contents2EditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof ArtifactArtifactFigure_contents2EditPart) {
			IFigure pane = getPrimaryShape().getFigureArtifactFigure_Body();
			pane.remove(((ArtifactArtifactFigure_contents2EditPart) childEditPart).getFigure());
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

		if (editPart instanceof ArtifactArtifactFigure_contents2EditPart) {
			return getPrimaryShape().getFigureArtifactFigure_Body();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(80), getMapMode().DPtoLP(60));
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
			layout.setSpacing(getMapMode().DPtoLP(5));
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
			((Shape) primaryShape).setLineWidth(getMapMode().DPtoLP(width));
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ArtifactFileName3EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Manifestation_4002);
		types.add(UMLElementTypes.CommunicationPath_4004);
		types.add(UMLElementTypes.Dependency_4005);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Deployment_4001);
		types.add(UMLElementTypes.Manifestation_4002);
		types.add(UMLElementTypes.CommunicationPath_4004);
		types.add(UMLElementTypes.Dependency_4005);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof DeviceEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof NodeEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof ExecutionEnvironmentEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof Artifact2EditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof DeploymentSpecificationEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof Device2EditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.deploy.edit.parts.Artifact4EditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof DeploymentSpecification2EditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof ExecutionEnvironment2EditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof Node2EditPart) {
			types.add(UMLElementTypes.Manifestation_4002);
		}
		if (targetEditPart instanceof DeviceEditPart) {
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.deploy.edit.parts.Artifact4EditPart) {
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
		if (targetEditPart instanceof DeviceEditPart) {
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.deploy.edit.parts.Artifact4EditPart) {
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
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.Device_2003);
		}
		if (relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.Node_2004);
		}
		if (relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
		}
		if (relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.Device_3004);
		}
		if (relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
		}
		if (relationshipType == UMLElementTypes.Deployment_4001) {
			types.add(UMLElementTypes.Node_3007);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Artifact_2006);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.DeploymentSpecification_2007);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Artifact_3002);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Artifact_3008);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.DeploymentSpecification_3009);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Device_2003);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Node_2004);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Artifact_2006);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.DeploymentSpecification_2007);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Device_3004);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Artifact_3002);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Artifact_3008);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.DeploymentSpecification_3009);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Node_3007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Package_2001);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Device_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Node_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Artifact_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.DeploymentSpecification_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Device_3004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Artifact_3002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Artifact_3008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.DeploymentSpecification_3009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Node_3007);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Package_2001);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Device_2003);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Node_2004);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Artifact_2006);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.DeploymentSpecification_2007);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Device_3004);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Artifact_3002);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Artifact_3008);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.DeploymentSpecification_3009);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
		}
		if (relationshipType == UMLElementTypes.Manifestation_4002) {
			types.add(UMLElementTypes.Node_3007);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Device_2003);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Node_2004);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Artifact_2006);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.DeploymentSpecification_2007);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Device_3004);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Artifact_3002);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Artifact_3008);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.DeploymentSpecification_3009);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
		}
		if (relationshipType == UMLElementTypes.CommunicationPath_4004) {
			types.add(UMLElementTypes.Node_3007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Package_2001);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Device_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Node_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.ExecutionEnvironment_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Artifact_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.DeploymentSpecification_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Device_3004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Artifact_3002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Artifact_3008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.DeploymentSpecification_3009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.ExecutionEnvironment_3005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4005) {
			types.add(UMLElementTypes.Node_3007);
		}
		return types;
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		handleTypeLinkModification(event);
	}

	/**
	 * @generated
	 */
	public class ArtifactFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private Label fFigureArtifactFigure_name;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureArtifactFigure_Body;

		/**
		 * @generated
		 */
		public ArtifactFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure artifactFigure_NameContainer0 = new RectangleFigure();
			artifactFigure_NameContainer0.setFill(false);
			artifactFigure_NameContainer0.setOutline(false);

			this.add(artifactFigure_NameContainer0, BorderLayout.TOP);

			ToolbarLayout layoutArtifactFigure_NameContainer0 = new ToolbarLayout();
			layoutArtifactFigure_NameContainer0.setStretchMinorAxis(true);
			layoutArtifactFigure_NameContainer0.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutArtifactFigure_NameContainer0.setSpacing(0);
			layoutArtifactFigure_NameContainer0.setVertical(true);

			artifactFigure_NameContainer0.setLayoutManager(layoutArtifactFigure_NameContainer0);

			fFigureArtifactFigure_name = new Label();
			fFigureArtifactFigure_name.setText("");

			artifactFigure_NameContainer0.add(fFigureArtifactFigure_name);

			Label artifactFigure_fixed_artifact1 = new Label();
			artifactFigure_fixed_artifact1.setText("\u00ABartifact\u00BB");

			artifactFigure_NameContainer0.add(artifactFigure_fixed_artifact1);

			fFigureArtifactFigure_Body = new RectangleFigure();
			fFigureArtifactFigure_Body.setMinimumSize(new Dimension(getMapMode().DPtoLP(0), getMapMode().DPtoLP(55)));

			this.add(fFigureArtifactFigure_Body, BorderLayout.CENTER);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		public Label getFigureArtifactFigure_name() {
			return fFigureArtifactFigure_name;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureArtifactFigure_Body() {
			return fFigureArtifactFigure_Body;
		}

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
			if (event.getFeature() == UMLPackage.eINSTANCE.getManifestation_UtilizedElement()) {
				refreshDiagram();
				return;
			}
		}
	}

	/**
	 * @generated
	 */
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		for (IUpdaterNodeDescriptor next : getArtifact_3008ContainedLinks()) {
			EObject nextLink = next.getModelElement();
			if (nextLink == null) {
				continue;
			}
			switch (next.getVisualID()) {
			case ManifestationEditPart.VISUAL_ID:
				getLinkTargetListener().addReferenceListener(nextLink, UMLPackage.eINSTANCE.getManifestation_UtilizedElement());
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
	private List<IUpdaterLinkDescriptor> getArtifact_3008ContainedLinks() {
		return UMLDiagramUpdater.getArtifact_3008ContainedLinks(getNotationView());
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
		if (event.getFeature() == UMLPackage.eINSTANCE.getArtifact_Manifestation()) {
			switch (event.getEventType()) {
			case Notification.ADD: {
				Object link = event.getNewValue();
				if (link instanceof Manifestation) {
					getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getManifestation_UtilizedElement());
				}
				if (link instanceof Manifestation) {
					refreshDiagram();
				}
				break;
			}
			case Notification.REMOVE: {
				Object link = event.getOldValue();
				if (link instanceof Manifestation) {
					getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getManifestation_UtilizedElement());
				}
				if (link instanceof Manifestation) {
					refreshDiagram();
				}
				break;
			}
			case Notification.ADD_MANY: {
				List<?> links = (List<?>) event.getNewValue();
				for (Object link : links) {
					if (link instanceof Manifestation) {
						getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getManifestation_UtilizedElement());
					}
				}
				for (Object link : links) {
					if (link instanceof Manifestation) {
						refreshDiagram();
						break;
					}
				}
				break;
			}
			case Notification.REMOVE_MANY: {
				List<?> links = (List<?>) event.getOldValue();
				for (Object link : links) {
					if (link instanceof Manifestation) {
						getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getManifestation_UtilizedElement());
					}
				}
				for (Object link : links) {
					if (link instanceof Manifestation) {
						refreshDiagram();
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
	public void refreshDiagram() {
		UMLDiagramUpdateCommand.performCanonicalUpdate(getDiagramView().getElement());
	}

}