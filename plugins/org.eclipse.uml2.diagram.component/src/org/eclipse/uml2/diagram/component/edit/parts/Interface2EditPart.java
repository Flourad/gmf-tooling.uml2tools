package org.eclipse.uml2.diagram.component.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.draw2d.UnrestrictedOutsideBorderItemLocator;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TGraphicalNodeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.common.links.RefreshComplementaryLinksHelper;
import org.eclipse.uml2.diagram.component.edit.policies.Interface2ItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.component.links.DiagramLinkInfoProvider;
import org.eclipse.uml2.diagram.component.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.component.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.component.providers.UMLElementTypes;

/**
 * @generated
 */
public class Interface2EditPart extends AbstractBorderedShapeEditPart implements PrimaryShapeEditPart {

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
	public Interface2EditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Interface2ItemSemanticEditPolicy());
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
				View childView = (View) child.getModel();
				switch (UMLVisualIDRegistry.getVisualID(childView)) {
				case InterfaceName2EditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart) getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				}
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
		return primaryShape = new ProvidedInterfaceCircleFigure();
	}

	/**
	 * @generated
	 */
	public ProvidedInterfaceCircleFigure getPrimaryShape() {
		return (ProvidedInterfaceCircleFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof InterfaceName2EditPart) {
			IBorderItemLocator locator = new UnrestrictedOutsideBorderItemLocator(getMainFigure());
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
			return;
		}

		super.addBorderItem(borderItemContainer, borderItemEditPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(15, 15);
		return result;
	}

	/**
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		// #265822 Improve appearance of selection feedback
		ResizableEditPolicy result = new U2TResizableShapeEditPolicy();
		result.setResizeDirections(PositionConstants.NONE);
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
	protected NodeFigure createMainFigure() {
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(InterfaceName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Dependency_4009);
		types.add(UMLElementTypes.Association_4011);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(7);
		types.add(UMLElementTypes.InterfaceRealization_4001);
		types.add(UMLElementTypes.PortProvided_4006);
		types.add(UMLElementTypes.PortRequired_4004);
		types.add(UMLElementTypes.ComponentRequired_4007);
		types.add(UMLElementTypes.Dependency_4009);
		types.add(UMLElementTypes.Association_4011);
		types.add(UMLElementTypes.CommentAnnotatedElement_4012);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof Artifact2EditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.component.edit.parts.Interface2EditPart) {
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
		if (targetEditPart instanceof PropertyEditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof AssemblyConnectorCircleEditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof PortOnClassEditPart) {
			types.add(UMLElementTypes.Dependency_4009);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof Artifact2EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.component.edit.parts.Interface2EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof ClassDiagramNotationClassEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof Interface3EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof ArtifactEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof Artifact3EditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Association_4011);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.InterfaceRealization_4001) {
			types.add(UMLElementTypes.Component_2001);
			types.add(UMLElementTypes.Class_2004);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Component_3001);
			types.add(UMLElementTypes.Class_3004);
		} else if (relationshipType == UMLElementTypes.PortProvided_4006) {
			types.add(UMLElementTypes.Port_3002);
			types.add(UMLElementTypes.Port_3014);
		} else if (relationshipType == UMLElementTypes.PortRequired_4004) {
			types.add(UMLElementTypes.Port_3002);
			types.add(UMLElementTypes.Port_3014);
		} else if (relationshipType == UMLElementTypes.ComponentRequired_4007) {
			types.add(UMLElementTypes.Component_2001);
			types.add(UMLElementTypes.Component_3001);
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
		} else if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Component_2001);
			types.add(UMLElementTypes.Artifact_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Class_2004);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Interface_2009);
			types.add(UMLElementTypes.Component_3001);
			types.add(UMLElementTypes.Artifact_3003);
			types.add(UMLElementTypes.Artifact_3016);
			types.add(UMLElementTypes.Class_3004);
			types.add(UMLElementTypes.Interface_3005);
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
		if (relationshipType == UMLElementTypes.Dependency_4009) {
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
		} else if (relationshipType == UMLElementTypes.Association_4011) {
			types.add(UMLElementTypes.Component_2001);
			types.add(UMLElementTypes.Artifact_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Class_2004);
			types.add(UMLElementTypes.Class_2007);
			types.add(UMLElementTypes.Interface_2009);
			types.add(UMLElementTypes.Component_3001);
			types.add(UMLElementTypes.Artifact_3003);
			types.add(UMLElementTypes.Artifact_3016);
			types.add(UMLElementTypes.Class_3004);
			types.add(UMLElementTypes.Interface_3005);
		}
		return types;
	}

	/**
	 * @generated NOT
	 */
	protected void handleNotificationEvent(Notification event) {
		handleNotificationEventGen(event);
		RefreshComplementaryLinksHelper.getInstance().handleNotification(this, event, DiagramLinkInfoProvider.getInstance());
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEventGen(Notification event) {
		if (event.getNotifier() == getModel() && EcorePackage.eINSTANCE.getEModelElement_EAnnotations().equals(event.getFeature())) {
			handleMajorSemanticChange();
		} else {
			super.handleNotificationEvent(event);
		}
	}

	/**
	 * @generated
	 */
	public class ProvidedInterfaceCircleFigure extends Ellipse {

		/**
		 * @generated
		 */
		public ProvidedInterfaceCircleFigure() {
			this.setLineWidth(1);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(15), getMapMode().DPtoLP(15)));
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(15), getMapMode().DPtoLP(15)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(15), getMapMode().DPtoLP(15)));
		}

	}

}
