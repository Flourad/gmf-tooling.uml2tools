package org.eclipse.uml2.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.OneLineBorder;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.activity.draw2d.PartitionLayout;
import org.eclipse.uml2.diagram.activity.edit.policies.ActivityCanonicalEditPolicy;
import org.eclipse.uml2.diagram.activity.edit.policies.ActivityItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.activity.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.draw2d.BisectionBorderItemLocator;
import org.eclipse.uml2.diagram.common.draw2d.CenterLayout;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;

/**
 * @generated
 */
public class ActivityEditPart extends AbstractBorderedShapeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2026;

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
	public ActivityEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		if (UMLVisualIDRegistry.isShortcutDescendant(getNotationView())) {
			installEditPolicy(UpdateDescriptionEditPolicy.ROLE, new UpdateDescriptionEditPolicy(UMLDiagramUpdater.TYPED_ADAPTER, true));
		}
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(UMLVisualIDRegistry.TYPED_ADAPTER));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ActivityItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ActivityCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child instanceof IBorderItemEditPart) {
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
		ActivityFigure figure = new ActivityFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ActivityFigure getPrimaryShape() {
		return (ActivityFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ActivityNameEditPart) {
			((ActivityNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureActivityFigure_name());
			return true;
		}
		if (childEditPart instanceof ActivityParameterNodeEditPart) {
			IBorderItemLocator locator = new BisectionBorderItemLocator(getMainFigure());
			getBorderedFigure().getBorderItemContainer().add(((ActivityParameterNodeEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof ActivityParameterNodeEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ActivityParameterNodeEditPart) childEditPart).getFigure());
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
	 * @generated NOT
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		if (editPart instanceof ActivityParameterNodeEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(600), getMapMode().DPtoLP(600));
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
	 * @generated NOT
	 * XXX: Support content pane in xPand custom templates
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return getPrimaryShape().getFigureActivityFigure_Body();
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ActivityNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.ObjectNodeSelection_4004);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.DataStoreNode_3036);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.CentralBufferNode_3037);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.OutputPin_3001);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.Pin_3041);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.OutputPin_3002);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3003);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3004);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3005);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.OutputPin_3006);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3007);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3008);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.Pin_3017);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.DataStoreNode_3024);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.CentralBufferNode_3025);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3054);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.OutputPin_3055);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.ActivityParameterNode_3052);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.DataStoreNode_3065);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.CentralBufferNode_3066);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.Pin_3071);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.InputPin_3080);
		}
		if (relationshipType == UMLElementTypes.ObjectNodeSelection_4004) {
			types.add(UMLElementTypes.OutputPin_3081);
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
	public class ActivityFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private Label fFigureActivityFigure_name;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureActivityFigure_Body;

		/**
		 * @generated
		 */
		public ActivityFigure() {

			BorderLayout layoutThis = new BorderLayout();
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(18), getMapMode().DPtoLP(18)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure activityFigureRectangle_name0 = new RectangleFigure();
			activityFigureRectangle_name0.setFill(false);
			activityFigureRectangle_name0.setOutline(false);
			activityFigureRectangle_name0.setBorder(createBorder0());

			this.add(activityFigureRectangle_name0, BorderLayout.TOP);
			activityFigureRectangle_name0.setLayoutManager(new StackLayout());

			fFigureActivityFigure_name = new Label();
			fFigureActivityFigure_name.setText("");

			activityFigureRectangle_name0.add(fFigureActivityFigure_name);

			CenterLayout layoutFFigureActivityFigure_name = new CenterLayout();

			fFigureActivityFigure_name.setLayoutManager(layoutFFigureActivityFigure_name);

			fFigureActivityFigure_Body = new RectangleFigure();
			fFigureActivityFigure_Body.setFill(false);
			fFigureActivityFigure_Body.setOutline(false);

			this.add(fFigureActivityFigure_Body, BorderLayout.CENTER);

			PartitionLayout layoutFFigureActivityFigure_Body = new PartitionLayout();

			layoutFFigureActivityFigure_Body.setViewer(getViewer());

			fFigureActivityFigure_Body.setLayoutManager(layoutFFigureActivityFigure_Body);

		}

		private Border createBorder0() {
			OneLineBorder result = new OneLineBorder();

			result.setPosition(PositionConstants.NONE);

			return result;
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
		public Label getFigureActivityFigure_name() {
			return fFigureActivityFigure_name;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureActivityFigure_Body() {
			return fFigureActivityFigure_Body;
		}

	}

	/**
	 * @generated
	 */
	protected void reorderChild(EditPart child, int index) {
		// Save the constraint of the child so that it does not
		// get lost during the remove and re-add.
		IFigure childFigure = ((GraphicalEditPart) child).getFigure();
		LayoutManager layout = getContentPaneFor((IGraphicalEditPart) child).getLayoutManager();
		Object constraint = null;
		if (layout != null) {
			constraint = layout.getConstraint(childFigure);
		}
		super.reorderChild(child, index);
		setLayoutConstraint(child, childFigure, constraint);
	}

}
