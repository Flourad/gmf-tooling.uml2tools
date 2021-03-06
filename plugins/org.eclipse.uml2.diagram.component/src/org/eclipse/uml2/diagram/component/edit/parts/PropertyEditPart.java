package org.eclipse.uml2.diagram.component.edit.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.draw2d.CenterLayout;
import org.eclipse.uml2.diagram.common.editparts.CanonicalDisableHelper;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TGraphicalNodeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.component.edit.policies.PropertyItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.component.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;

/**
 * @generated
 */
public class PropertyEditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3006;

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
	public PropertyEditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PropertyItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new U2TGraphicalNodeEditPolicy());
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
		return primaryShape = new PartFigure();
	}

	/**
	 * @generated
	 */
	public PartFigure getPrimaryShape() {
		return (PartFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof PropertyNameEditPart) {
			((PropertyNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigure_PartFigure_name());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

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
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
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
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
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
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(PropertyNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Connector_4008);
		types.add(UMLElementTypes.Dependency_4009);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.Connector_4008);
		types.add(UMLElementTypes.Dependency_4009);
		types.add(UMLElementTypes.CommentAnnotatedElement_4012);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Connector_4008);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.component.edit.parts.PropertyEditPart) {
			types.add(UMLElementTypes.Connector_4008);
		}
		if (targetEditPart instanceof PortOnClassEditPart) {
			types.add(UMLElementTypes.Connector_4008);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof Artifact2EditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof Package3EditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof ClassDiagramNotationClassEditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof Interface3EditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof Artifact3EditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.component.edit.parts.PropertyEditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof AssemblyConnectorCircleEditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof PortOnClassEditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.Connector_4008) {
			types.add(UMLElementTypes.Port_3002);
			types.add(UMLElementTypes.Property_3006);
			types.add(UMLElementTypes.Port_3014);
		} else if (relationshipType == UMLElementTypes.Dependency_4009) {
			types.add(UMLElementTypes.Component_2001);
			types.add(UMLElementTypes.Artifact_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Class_2004);
			types.add(UMLElementTypes.Package_2005);
			types.add(UMLElementTypes.Package_2006);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Interface_2009);
			types.add(UMLElementTypes.Component_3001);
			types.add(UMLElementTypes.Port_3002);
			types.add(UMLElementTypes.Artifact_3003);
			types.add(UMLElementTypes.Artifact_3016);
			types.add(UMLElementTypes.Class_3004);
			types.add(UMLElementTypes.Interface_3005);
			types.add(UMLElementTypes.Property_3006);
			types.add(UMLElementTypes.Connector_3015);
			types.add(UMLElementTypes.Port_3014);
		} else if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4012) {
			types.add(UMLElementTypes.Comment_2008);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.Connector_4008) {
			types.add(UMLElementTypes.Port_3002);
			types.add(UMLElementTypes.Property_3006);
			types.add(UMLElementTypes.Port_3014);
		} else if (relationshipType == UMLElementTypes.Dependency_4009) {
			types.add(UMLElementTypes.Component_2001);
			types.add(UMLElementTypes.Artifact_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Class_2004);
			types.add(UMLElementTypes.Package_2005);
			types.add(UMLElementTypes.Package_2006);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Interface_2009);
			types.add(UMLElementTypes.Component_3001);
			types.add(UMLElementTypes.Port_3002);
			types.add(UMLElementTypes.Artifact_3003);
			types.add(UMLElementTypes.Artifact_3016);
			types.add(UMLElementTypes.Class_3004);
			types.add(UMLElementTypes.Interface_3005);
			types.add(UMLElementTypes.Property_3006);
			types.add(UMLElementTypes.Connector_3015);
			types.add(UMLElementTypes.Port_3014);
		}
		return types;
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
	}

	/**
	 * @generated
	 */
	public class PartFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private Label fFigure_PartFigure_name;

		/**
		 * @generated
		 */
		public PartFigure() {

			CenterLayout layoutThis = new CenterLayout();

			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigure_PartFigure_name = new Label();
			fFigure_PartFigure_name.setText("");

			this.add(fFigure_PartFigure_name);

		}

		/**
		 * @generated
		 */
		public Label getFigure_PartFigure_name() {
			return fFigure_PartFigure_name;
		}

	}

	/**
	 * @NOT generated
	 */
	@Override
	protected Collection<?> disableCanonicalFor(final Request request) {
		return CanonicalDisableHelper.SHARED_PACKAGE_DISABLER.disableCanonicalFor(this, request, super.disableCanonicalFor(request));
	}

}
