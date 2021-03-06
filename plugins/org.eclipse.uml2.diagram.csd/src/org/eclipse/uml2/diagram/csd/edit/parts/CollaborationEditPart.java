package org.eclipse.uml2.diagram.csd.edit.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.draw2d.CenterLayout;
import org.eclipse.uml2.diagram.common.draw2d.DefaultSizeOvalAnchorableFigure;
import org.eclipse.uml2.diagram.common.draw2d.OneLineDashedBorder;
import org.eclipse.uml2.diagram.common.draw2d.SplitEllipseLayout;
import org.eclipse.uml2.diagram.common.draw2d.StereotypeLabel;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.csd.edit.policies.CollaborationItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.csd.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.csd.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class CollaborationEditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2005;

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
	public CollaborationEditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CollaborationItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AsyncDiagramComponentEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
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
		return primaryShape = new CollaborationFigure();
	}

	/**
	 * @generated
	 */
	public CollaborationFigure getPrimaryShape() {
		return (CollaborationFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof CollaborationNameEditPart) {
			((CollaborationNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureCollaborationFigure_name());
			return true;
		}
		if (childEditPart instanceof CollaborationStereoEditPart) {
			((CollaborationStereoEditPart) childEditPart).setLabel(getPrimaryShape().getFigureCollaborationFigure_stereo());
			return true;
		}
		if (childEditPart instanceof CollaborationContentsEditPart) {
			IFigure pane = getPrimaryShape().getFigureCollaborationFigure_contents();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((CollaborationContentsEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof CollaborationContentsEditPart) {
			IFigure pane = getPrimaryShape().getFigureCollaborationFigure_contents();
			pane.remove(((CollaborationContentsEditPart) childEditPart).getFigure());
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
		if (editPart instanceof CollaborationContentsEditPart) {
			return getPrimaryShape().getFigureCollaborationFigure_contents();
		}
		return getContentPane();
	}

	/**
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeOvalAnchorableFigure result = new DefaultSizeOvalAnchorableFigure(getMapMode().DPtoLP(200), getMapMode().DPtoLP(120));
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(CollaborationNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(5);
		types.add(UMLElementTypes.Dependency_4006);
		types.add(UMLElementTypes.InterfaceRealization_4007);
		types.add(UMLElementTypes.Usage_4008);
		types.add(UMLElementTypes.Association_4011);
		types.add(UMLElementTypes.Dependency_4017);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(6);
		types.add(UMLElementTypes.Dependency_4006);
		types.add(UMLElementTypes.Usage_4008);
		types.add(UMLElementTypes.Association_4011);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4012);
		types.add(UMLElementTypes.CommentAnnotatedElement_4016);
		types.add(UMLElementTypes.Dependency_4017);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof org.eclipse.uml2.diagram.csd.edit.parts.CollaborationEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Class3EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof CollaborationUse2EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof PropertyEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Property3EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Port2EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Port3EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4007);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4007);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.csd.edit.parts.CollaborationEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Class3EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof CollaborationUse2EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof PropertyEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Property3EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Port2EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof Port3EditPart) {
			types.add(UMLElementTypes.Usage_4008);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.csd.edit.parts.CollaborationEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof Class3EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.csd.edit.parts.CollaborationEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if (targetEditPart instanceof Class3EditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if (targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if (targetEditPart instanceof CollaborationUse2EditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if (targetEditPart instanceof PropertyEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if (targetEditPart instanceof Property3EditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if (targetEditPart instanceof Port2EditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		if (targetEditPart instanceof Port3EditPart) {
			types.add(UMLElementTypes.Dependency_4017);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Collaboration_2005);
			types.add(UMLElementTypes.Class_2006);
			types.add(UMLElementTypes.Package_2003);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Interface_2009);
			types.add(UMLElementTypes.InstanceSpecification_2011);
			types.add(UMLElementTypes.Constraint_2012);
			types.add(UMLElementTypes.Interface_2014);
			types.add(UMLElementTypes.CollaborationUse_3002);
			types.add(UMLElementTypes.Property_3007);
			types.add(UMLElementTypes.Port_3011);
			types.add(UMLElementTypes.Property_3014);
			types.add(UMLElementTypes.Port_3016);
			types.add(UMLElementTypes.Port_3017);
		} else if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Collaboration_2005);
			types.add(UMLElementTypes.Class_2006);
			types.add(UMLElementTypes.Package_2003);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Interface_2009);
			types.add(UMLElementTypes.InstanceSpecification_2011);
			types.add(UMLElementTypes.Constraint_2012);
			types.add(UMLElementTypes.Interface_2014);
			types.add(UMLElementTypes.CollaborationUse_3002);
			types.add(UMLElementTypes.Property_3007);
			types.add(UMLElementTypes.Port_3011);
			types.add(UMLElementTypes.Property_3014);
			types.add(UMLElementTypes.Port_3016);
			types.add(UMLElementTypes.Port_3017);
		} else if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Collaboration_2005);
			types.add(UMLElementTypes.Class_2006);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Interface_2009);
			types.add(UMLElementTypes.Interface_2014);
		} else if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4012) {
			types.add(UMLElementTypes.Constraint_2012);
		} else if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4016) {
			types.add(UMLElementTypes.Comment_2013);
		} else if (relationshipType == UMLElementTypes.Dependency_4017) {
			types.add(UMLElementTypes.Collaboration_2005);
			types.add(UMLElementTypes.Class_2006);
			types.add(UMLElementTypes.Package_2003);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Interface_2009);
			types.add(UMLElementTypes.InstanceSpecification_2011);
			types.add(UMLElementTypes.Constraint_2012);
			types.add(UMLElementTypes.Interface_2014);
			types.add(UMLElementTypes.CollaborationUse_3002);
			types.add(UMLElementTypes.Property_3007);
			types.add(UMLElementTypes.Port_3011);
			types.add(UMLElementTypes.Property_3014);
			types.add(UMLElementTypes.Port_3016);
			types.add(UMLElementTypes.Port_3017);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Collaboration_2005);
			types.add(UMLElementTypes.Class_2006);
			types.add(UMLElementTypes.Package_2003);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Interface_2009);
			types.add(UMLElementTypes.InstanceSpecification_2011);
			types.add(UMLElementTypes.Constraint_2012);
			types.add(UMLElementTypes.Interface_2014);
			types.add(UMLElementTypes.CollaborationUse_3002);
			types.add(UMLElementTypes.Property_3007);
			types.add(UMLElementTypes.Port_3011);
			types.add(UMLElementTypes.Property_3014);
			types.add(UMLElementTypes.Port_3016);
			types.add(UMLElementTypes.Port_3017);
		} else if (relationshipType == UMLElementTypes.InterfaceRealization_4007) {
			types.add(UMLElementTypes.Interface_2009);
			types.add(UMLElementTypes.Interface_2014);
		} else if (relationshipType == UMLElementTypes.Usage_4008) {
			types.add(UMLElementTypes.Collaboration_2005);
			types.add(UMLElementTypes.Class_2006);
			types.add(UMLElementTypes.Package_2003);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Interface_2009);
			types.add(UMLElementTypes.InstanceSpecification_2011);
			types.add(UMLElementTypes.Constraint_2012);
			types.add(UMLElementTypes.Interface_2014);
			types.add(UMLElementTypes.CollaborationUse_3002);
			types.add(UMLElementTypes.Property_3007);
			types.add(UMLElementTypes.Port_3011);
			types.add(UMLElementTypes.Property_3014);
			types.add(UMLElementTypes.Port_3016);
			types.add(UMLElementTypes.Port_3017);
		} else if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Collaboration_2005);
			types.add(UMLElementTypes.Class_2006);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Interface_2009);
			types.add(UMLElementTypes.Interface_2014);
		} else if (relationshipType == UMLElementTypes.Dependency_4017) {
			types.add(UMLElementTypes.Collaboration_2005);
			types.add(UMLElementTypes.Class_2006);
			types.add(UMLElementTypes.Package_2003);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Interface_2009);
			types.add(UMLElementTypes.InstanceSpecification_2011);
			types.add(UMLElementTypes.Constraint_2012);
			types.add(UMLElementTypes.Interface_2014);
			types.add(UMLElementTypes.CollaborationUse_3002);
			types.add(UMLElementTypes.Property_3007);
			types.add(UMLElementTypes.Port_3011);
			types.add(UMLElementTypes.Property_3014);
			types.add(UMLElementTypes.Port_3016);
			types.add(UMLElementTypes.Port_3017);
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
			if (event.getFeature() == UMLPackage.eINSTANCE.getInterfaceRealization_Contract()) {
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
		for (IUpdaterNodeDescriptor next : getCollaboration_2005ContainedLinks()) {
			EObject nextLink = next.getModelElement();
			if (nextLink == null) {
				continue;
			}
			switch (next.getVisualID()) {
			case InterfaceRealizationEditPart.VISUAL_ID:
				getLinkTargetListener().addReferenceListener(nextLink, UMLPackage.eINSTANCE.getInterfaceRealization_Contract());
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
	private List<? extends IUpdaterLinkDescriptor> getCollaboration_2005ContainedLinks() {
		return UMLDiagramUpdater.getCollaboration_2005ContainedLinks(getNotationView());
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
		if (event.getFeature() == UMLPackage.eINSTANCE.getBehavioredClassifier_InterfaceRealization()) {
			switch (event.getEventType()) {
			case Notification.ADD: {
				Object link = event.getNewValue();
				if (link instanceof InterfaceRealization) {
					getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getInterfaceRealization_Contract());
				}
				if (link instanceof InterfaceRealization) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.REMOVE: {
				Object link = event.getOldValue();
				if (link instanceof InterfaceRealization) {
					getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getInterfaceRealization_Contract());
				}
				if (link instanceof InterfaceRealization) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.ADD_MANY: {
				List<?> links = (List<?>) event.getNewValue();
				for (Object link : links) {
					if (link instanceof InterfaceRealization) {
						getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getInterfaceRealization_Contract());
					}
				}
				for (Object link : links) {
					if (link instanceof InterfaceRealization) {
						guardedRefreshDiagram();
						break;
					}
				}
				break;
			}
			case Notification.REMOVE_MANY: {
				List<?> links = (List<?>) event.getOldValue();
				for (Object link : links) {
					if (link instanceof InterfaceRealization) {
						getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getInterfaceRealization_Contract());
					}
				}
				for (Object link : links) {
					if (link instanceof InterfaceRealization) {
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
	protected void performDirectEditRequest(final Request request) {
		EditPart editPart = this;
		if (request instanceof DirectEditRequest) {
			Point p = new Point(((DirectEditRequest) request).getLocation());
			getFigure().translateToRelative(p);
			IFigure fig = getFigure().findFigureAt(p);
			editPart = (EditPart) getViewer().getVisualPartMap().get(fig);
		}
		if (editPart == this) {
			try {
				editPart = (EditPart) getEditingDomain().runExclusive(new RunnableWithResult.Impl() {

					public void run() {
						setResult(chooseLabelEditPartForDirectEditRequest(request));
					}
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (editPart != null && editPart != this) {
				editPart.performRequest(request);
			}
		}
	}

	/**
	 * @generated
	 */
	protected EditPart chooseLabelEditPartForDirectEditRequest(Request request) {
		if (request.getExtendedData().containsKey(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR)) {
			Character initialChar = (Character) request.getExtendedData().get(RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
			// '<' has special meaning, because we have both name- and stereo- inplaces for single node edit part
			// we want to activate stereotype inplace if user presses '<' (for "<< stereotype >>" 
			// notation, also we don't include '<' and '>' into actual inplace text).
			// If user presses any other alfanum key, we will activate name-inplace, as for all other figures

			if (initialChar.charValue() == '<') {
				EditPart result = getChildBySemanticHint(UMLVisualIDRegistry.getType(CollaborationStereoEditPart.VISUAL_ID));
				if (result != null) {
					return result;
				}
			}
		}
		return getPrimaryChildEditPart();
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest unspecifiedRequest = (CreateUnspecifiedTypeRequest) request;
			List<IElementType> types = unspecifiedRequest.getElementTypes();
			if (types.contains(UMLElementTypes.CollaborationUse_3002)) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(CollaborationContentsEditPart.VISUAL_ID));
			}
			if (types.contains(UMLElementTypes.Property_3007)) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(CollaborationContentsEditPart.VISUAL_ID));
			}
		}

		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class CollaborationFigure extends Ellipse {

		private int myXMargin;

		private int myYMargin;

		/**
		 * @generated
		 */
		private Label fFigureCollaborationFigure_name;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureCollaborationFigure_contents;

		/**
		 * @generated
		 */
		private StereotypeLabel fFigureCollaborationFigure_stereo;

		/**
		 * @generated
		 */
		public CollaborationFigure() {

			SplitEllipseLayout layoutThis = new SplitEllipseLayout();

			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			this.setLineStyle(Graphics.LINE_DASH);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure collaborationFigure_Header0 = new RectangleFigure();
			collaborationFigure_Header0.setFill(false);
			collaborationFigure_Header0.setOutline(false);
			collaborationFigure_Header0.setLineWidth(1);

			this.add(collaborationFigure_Header0, BorderLayout.TOP);

			ToolbarLayout layoutCollaborationFigure_Header0 = new ToolbarLayout();
			layoutCollaborationFigure_Header0.setStretchMinorAxis(true);
			layoutCollaborationFigure_Header0.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutCollaborationFigure_Header0.setSpacing(0);
			layoutCollaborationFigure_Header0.setVertical(true);

			collaborationFigure_Header0.setLayoutManager(layoutCollaborationFigure_Header0);

			RectangleFigure collaborationFigure_StereoContainer1 = new RectangleFigure();
			collaborationFigure_StereoContainer1.setOutline(false);
			collaborationFigure_StereoContainer1.setLineWidth(1);

			collaborationFigure_Header0.add(collaborationFigure_StereoContainer1);

			CenterLayout layoutCollaborationFigure_StereoContainer1 = new CenterLayout();

			collaborationFigure_StereoContainer1.setLayoutManager(layoutCollaborationFigure_StereoContainer1);

			fFigureCollaborationFigure_stereo = new StereotypeLabel();

			fFigureCollaborationFigure_stereo.setBorder(new MarginBorder(getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(0), getMapMode().DPtoLP(5)));

			collaborationFigure_StereoContainer1.add(fFigureCollaborationFigure_stereo);

			RectangleFigure collaborationFigure_NameContainer1 = new RectangleFigure();
			collaborationFigure_NameContainer1.setOutline(false);
			collaborationFigure_NameContainer1.setLineWidth(1);

			collaborationFigure_Header0.add(collaborationFigure_NameContainer1);

			CenterLayout layoutCollaborationFigure_NameContainer1 = new CenterLayout();

			collaborationFigure_NameContainer1.setLayoutManager(layoutCollaborationFigure_NameContainer1);

			fFigureCollaborationFigure_name = new Label();
			fFigureCollaborationFigure_name.setText("");

			fFigureCollaborationFigure_name.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5)));

			collaborationFigure_NameContainer1.add(fFigureCollaborationFigure_name);

			fFigureCollaborationFigure_contents = new RectangleFigure();
			fFigureCollaborationFigure_contents.setFill(false);
			fFigureCollaborationFigure_contents.setOutline(false);
			fFigureCollaborationFigure_contents.setLineWidth(1);
			fFigureCollaborationFigure_contents.setBorder(createBorder0());

			this.add(fFigureCollaborationFigure_contents, BorderLayout.CENTER);

		}

		private Border createBorder0() {
			OneLineDashedBorder result = new OneLineDashedBorder();

			return result;
		}

		/**
		 * @generated
		 */
		public Label getFigureCollaborationFigure_name() {
			return fFigureCollaborationFigure_name;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureCollaborationFigure_contents() {
			return fFigureCollaborationFigure_contents;
		}

		/**
		 * @generated
		 */
		public StereotypeLabel getFigureCollaborationFigure_stereo() {
			return fFigureCollaborationFigure_stereo;
		}

	}

}
