package org.eclipse.uml2.diagram.statemachine.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;

import org.eclipse.gef.commands.Command;

import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;

import org.eclipse.gef.requests.CreateRequest;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;

import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;

import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.uml2.diagram.statemachine.edit.policies.Pseudostate2ItemSemanticEditPolicy;

/**
 * @generated
 */
public class Pseudostate2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3005;

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
	public Pseudostate2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Pseudostate2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());

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
		ShallowHistoryFigure figure = new ShallowHistoryFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ShallowHistoryFigure getPrimaryShape() {
		return (ShallowHistoryFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(25), getMapMode().DPtoLP(25));
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
	public class ShallowHistoryFigure extends org.eclipse.draw2d.Ellipse {

		/**
		 * @generated
		 */
		public ShallowHistoryFigure() {

			this.setLayoutManager(new org.eclipse.draw2d.StackLayout());
			this.setFill(true);
			this.setFillXOR(false);
			this.setOutline(true);
			this.setOutlineXOR(false);
			this.setLineWidth(1);
			this.setLineStyle(org.eclipse.draw2d.Graphics.LINE_SOLID);
			this.setPreferredSize(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(25), getMapMode().DPtoLP(25)));
			this.setMaximumSize(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(25), getMapMode().DPtoLP(25)));
			this.setMinimumSize(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(25), getMapMode().DPtoLP(25)));
			this.setBorder(new org.eclipse.draw2d.MarginBorder(getMapMode().DPtoLP(6), getMapMode().DPtoLP(8), getMapMode().DPtoLP(6), getMapMode().DPtoLP(8)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			class ShallowHistoryFigure_Letter0Class extends org.eclipse.draw2d.Shape {

				/**
				 * @generated
				 */
				private final org.eclipse.draw2d.geometry.PointList myTemplate = new org.eclipse.draw2d.geometry.PointList();

				/**
				 * @generated
				 */
				private org.eclipse.draw2d.geometry.Rectangle myTemplateBounds;

				/**
				 * @generated
				 */
				public void addPoint(org.eclipse.draw2d.geometry.Point point) {
					myTemplate.addPoint(point);
					myTemplateBounds = null;
				}

				/**
				 * @generated
				 */
				protected void fillShape(org.eclipse.draw2d.Graphics graphics) {
					org.eclipse.draw2d.geometry.Rectangle bounds = getBounds();
					graphics.pushState();
					graphics.translate(bounds.x, bounds.y);
					graphics.fillPolygon(scalePointList());
					graphics.popState();
				}

				/**
				 * @generated
				 */
				protected void outlineShape(org.eclipse.draw2d.Graphics graphics) {
					org.eclipse.draw2d.geometry.Rectangle bounds = getBounds();
					graphics.pushState();
					graphics.translate(bounds.x, bounds.y);
					graphics.drawPolygon(scalePointList());
					graphics.popState();
				}

				/**
				 * @generated
				 */
				private org.eclipse.draw2d.geometry.Rectangle getTemplateBounds() {
					if (myTemplateBounds == null) {
						myTemplateBounds = myTemplate.getBounds().getCopy().union(0, 0);
						//just safety -- we are going to use this as divider 
						if (myTemplateBounds.width < 1) {
							myTemplateBounds.width = 1;
						}
						if (myTemplateBounds.height < 1) {
							myTemplateBounds.height = 1;
						}
					}
					return myTemplateBounds;
				}

				/**
				 * @generated
				 */
				private int[] scalePointList() {
					org.eclipse.draw2d.geometry.Rectangle pointsBounds = getTemplateBounds();
					org.eclipse.draw2d.geometry.Rectangle actualBounds = getBounds();

					float xScale = ((float) actualBounds.width) / pointsBounds.width;
					float yScale = ((float) actualBounds.height) / pointsBounds.height;

					if (xScale == 1 && yScale == 1) {
						return myTemplate.toIntArray();
					}
					int[] scaled = (int[]) myTemplate.toIntArray().clone();
					for (int i = 0; i < scaled.length; i += 2) {
						scaled[i] = (int) Math.floor(scaled[i] * xScale);
						scaled[i + 1] = (int) Math.floor(scaled[i + 1] * yScale);
					}
					return scaled;
				}
			}
			;
			ShallowHistoryFigure_Letter0Class shallowHistoryFigure_Letter0 = new ShallowHistoryFigure_Letter0Class();
			shallowHistoryFigure_Letter0.addPoint(new org.eclipse.draw2d.geometry.Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(40)));
			shallowHistoryFigure_Letter0.addPoint(new org.eclipse.draw2d.geometry.Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(20)));
			shallowHistoryFigure_Letter0.addPoint(new org.eclipse.draw2d.geometry.Point(getMapMode().DPtoLP(40), getMapMode().DPtoLP(20)));
			shallowHistoryFigure_Letter0.addPoint(new org.eclipse.draw2d.geometry.Point(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40)));
			shallowHistoryFigure_Letter0.addPoint(new org.eclipse.draw2d.geometry.Point(getMapMode().DPtoLP(40), getMapMode().DPtoLP(0)));
			shallowHistoryFigure_Letter0.addPoint(new org.eclipse.draw2d.geometry.Point(getMapMode().DPtoLP(40), getMapMode().DPtoLP(20)));
			shallowHistoryFigure_Letter0.addPoint(new org.eclipse.draw2d.geometry.Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(20)));
			shallowHistoryFigure_Letter0.addPoint(new org.eclipse.draw2d.geometry.Point(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0)));
			shallowHistoryFigure_Letter0.setFill(true);
			shallowHistoryFigure_Letter0.setFillXOR(false);
			shallowHistoryFigure_Letter0.setOutline(true);
			shallowHistoryFigure_Letter0.setOutlineXOR(false);
			shallowHistoryFigure_Letter0.setLineWidth(1);
			shallowHistoryFigure_Letter0.setLineStyle(org.eclipse.draw2d.Graphics.LINE_SOLID);

			this.add(shallowHistoryFigure_Letter0);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = true;

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

	}

}
