package org.eclipse.uml2.diagram.sequence.internal.missed;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IntListValueStyle;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.links.ConnectionRoutingHelper;
import org.eclipse.uml2.diagram.sequence.edit.parts.LayeredInteractionUseEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MessageEditPart;
import org.eclipse.uml2.diagram.sequence.edit.parts.MountingLinkEditPart;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsElement;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.AbsLink;
import org.eclipse.uml2.diagram.sequence.internal.layout.abstractgde.gef.AbsLinkGef;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods._ArcasMetamodelSpecific;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods._ConnectionEditPart;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods._ExecutionSpecification;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods._GraphicalEditPart;
import org.eclipse.uml2.diagram.sequence.internal.missed.MissedMethods._IGraphicalEditPart;
import org.eclipse.uml2.diagram.sequence.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.sequence.part.UMLNodeDescriptor;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionUse;


public class MissedMethodsImpl {
	static class MissedGraphicalEditPartImpl implements _IGraphicalEditPart, _GraphicalEditPart {
		public void setBackgroundColor(IGraphicalEditPart ep, RGB rgb) {
			IFigure shape = getColorTargetFigure(ep);
			Color color = getColor(rgb);
			if (shape != null && color != null){
				shape.setBackgroundColor(color);
			}
		}

		public void setForegroundColor(IGraphicalEditPart ep, RGB rgb) {
			IFigure shape = getColorTargetFigure(ep);
			Color color = getColor(rgb);
			if (shape != null && color != null){
				shape.setForegroundColor(color);
			}
		}
		
		private Color getColor(RGB rgb){
			String symbolic = toSymbolicName(rgb);
			Color result = myColorRegistry.get(symbolic);
			if (result == null){
				myColorRegistry.put(symbolic, rgb);
				result = myColorRegistry.get(symbolic);
			}
			return result;
		}
		
		public boolean isUserResized(GraphicalEditPart ep) {
			View view = ep.getNotationView();
			if (view instanceof Node){
				Node node = (Node)view;
				if (node.getLayoutConstraint() instanceof Size){
					Size size = (Size)node.getLayoutConstraint();
					return size.eIsSet(NotationPackage.eINSTANCE.getSize_Height()) && size.eIsSet(NotationPackage.eINSTANCE.getSize_Width());
				}
			}
			System.err.println("isUserResized asked for incompatible editpart " + ep );
			return false;
		}
		
		public void markUserResized(GraphicalEditPart ep) {
			if (isUserResized(ep)){
				return;
			}
			View view = ep.getNotationView();
			if (view instanceof Node){
				Node node = (Node)view;
				if (node.getLayoutConstraint() instanceof Size){
					Size size = (Size)node.getLayoutConstraint();
					//expected to be changed soon by actual layout
					System.err.println("Temporary set width 999 for : " + ep);
					size.setWidth(999);
				}
			}
		}
		
		private String toSymbolicName(RGB rgb){
			return "RGB[" + rgb.red + "," + rgb.green + "," + rgb.blue + "]";
		}
		
		private IFigure getColorTargetFigure(IGraphicalEditPart editPart){ 
			if (editPart instanceof PrimaryShapeEditPart){
				return ((PrimaryShapeEditPart)editPart).getPrimaryShape();
			}
			return editPart.getFigure();
		}
		
		public void setBounds(GraphicalEditPart nodeEP, Rectangle bounds) {
			Rectangle requested = bounds == null ? new Rectangle(0, 0, 0, 0) : bounds.getCopy();
			if (nodeEP.getParent() == null) {
				return;
			}
			if (bounds == null) {
				bounds = new Rectangle(0, 0, 0, 0);
			} else {
				if (nodeEP instanceof LayeredInteractionUseEditPart){
					if (bounds.width < 100){
						System.err.println("Here");
					}
				}
				IFigure actualContainer = nodeEP.getFigure().getParent();
				if (actualContainer.getLayoutManager() instanceof XYLayout){
					XYLayout layout = (XYLayout)actualContainer.getLayoutManager();
					Point origin = layout.getOrigin(actualContainer);
					bounds = bounds.getTranslated(origin.getNegated());
				}
			}
			
			System.err.println(">>>SetBounds: " + nodeEP + ":" + bounds + (bounds.equals(requested) ? "" : ", requested abs: " + requested));
			
			
			Node view = (Node) nodeEP.getNotationView();
			LayoutConstraint constraint = view.getLayoutConstraint();
			if (constraint instanceof Location){
				((Location)constraint).setX(bounds.x);
				((Location)constraint).setY(bounds.y);
			}
			if (constraint instanceof Size){
				((Size)constraint).setHeight(bounds.height);
				((Size)constraint).setWidth(bounds.width);
			}
			
//	        if (!bounds.equals(nodeEP.getFigure().getBounds())) {
//	            setFigureBounds(nodeEP, bounds);
//	        }
		}
		
		public Rectangle getBounds(GraphicalEditPart nodeEP) {
			Rectangle notationModelResult = new Rectangle();
			Node view = (Node) nodeEP.getNotationView();
			LayoutConstraint constraint = view.getLayoutConstraint();
			if (constraint instanceof Location){
				notationModelResult.x = ((Location)constraint).getX();
				notationModelResult.y = ((Location)constraint).getY();
			}
			if (constraint instanceof Size){
				notationModelResult.height = ((Size)constraint).getHeight();
				notationModelResult.width = ((Size)constraint).getWidth();
			}
			
			Rectangle absoluteResult = notationModelResult;
			IFigure actualContainer = nodeEP.getFigure().getParent();
			if (actualContainer.getLayoutManager() instanceof XYLayout){
				XYLayout layout = (XYLayout)actualContainer.getLayoutManager();
				Point origin = layout.getOrigin(actualContainer);
				absoluteResult = notationModelResult.getTranslated(origin);
			}
			
//			Rectangle figureResult = nodeEP.getFigure().getBounds().getCopy();
//			System.err.println("<<<GetBounds: " + nodeEP.toString() + ":" + absoluteResult);
//			if (!absoluteResult.equals(figureResult)){
//				System.err.println("<<<     \t\t (figure bounds:) " + nodeEP.toString() + ":" + figureResult);
//			}
			return absoluteResult;
		}
		
		private void setFigureBounds(GraphicalEditPart nodeEP, Rectangle absBounds) {
			IFigure f = nodeEP.getFigure();
			if (f != null) {
				f.setBounds(absBounds);
				updateFigureConstraint(f, absBounds);
	            f.invalidateTree();
				f.revalidate();
			}
		}
		
	    private void updateFigureConstraint(IFigure f, Rectangle absBounds) {
	        IFigure parent = f.getParent();
	        if (parent != null && parent.getLayoutManager() != null) {
	            LayoutManager layout = parent.getLayoutManager();
	            Rectangle relBounds = toRelative(parent, new Rectangle(absBounds));
	            Object constraint = layout.getConstraint(f);
//	            if (constraint instanceof XYConstraint) {
//	                XYConstraint xyConstraint = (XYConstraint) constraint;
//	                xyConstraint.getBounds().setBounds(relBounds);
//	            }
//	            else if (Draw2DLayoutUtil.isAbsoluteLayout(layout)) {
//	                if (constraint == null || !constraint.equals(absBounds)) {
//	                    layout.setConstraint(f, absBounds.getCopy());
//	                }
//	        	}
//	            else 
	            if (layout instanceof XYLayout) {
	        		if (constraint == null || !constraint.equals(relBounds)) {
	        			layout.setConstraint(f, relBounds);
	        		}
	        	}
	        }
	    }
		
	    private Rectangle toRelative(IFigure f, Rectangle b) {
	        b.x -= f.getClientArea().x;
	        b.y -= f.getClientArea().y;
	        return b;
	    }
		
		private final ColorRegistry myColorRegistry = new ColorRegistry();	
	}
	
	static class MissedArcasMetamodelSpecificImpl implements _ArcasMetamodelSpecific {
		public boolean isFrame(EObject eObject) {
			return 
				eObject instanceof CombinedFragment || 
				eObject instanceof InteractionOperand || 
				eObject instanceof InteractionUse;
		}
		
		public boolean isMountingLink(AbsElement absElement) {
			AbsLinkGef impl = (AbsLinkGef)absElement;
			return impl.getEditPart() instanceof MountingLinkEditPart;
		}
		
		public boolean isNoDuration(ExecutionSpecification spec) {
			return false;
		}
		
		public boolean isAlienLink(AbsLink link){
			if (isMountingLink(link)){
				return false;
			}
			if (isMessageLink(link)){
				return false;
			}
			return true; 
		}
		
		public boolean isMessageLink(AbsElement absElement) {
			AbsLinkGef impl = (AbsLinkGef)absElement;
			return impl.getEditPart() instanceof MessageEditPart;
		}
		
		public boolean isAsynchonousMessage(AbsLink link) {
			// TODO Auto-generated method stub
			return false;
		}
		
		public boolean isFoundMessageInvocation(EObject object) {
			// TODO Auto-generated method stub
			return false;
		}
		
		public List<EObject> getArcasMetamodelChildren(View containerView) {
			List<EObject> result = new LinkedList<EObject>();
			for (Object next : UMLDiagramUpdater.getSemanticChildren(containerView)){
				UMLNodeDescriptor nextDescriptor = (UMLNodeDescriptor)next;
				result.add(nextDescriptor.getModelElement());
			}
			return result;
		}
	}
	
	static class MissedConnectionEditPartImpl implements _ConnectionEditPart {
		private static final String SOURCE_ANCHOR_STYLE = "SourceAnchor";
		private static final String TARGET_ANCHOR_STYLE = "TargetAnchor";
		
		public List getBendpoints(ConnectionEditPart linkEP) {
			return Collections.emptyList();
		}
		
		public Point getSourcePoint(ConnectionEditPart linkEP) {
			Point fromStyle = loadPointFromStyle((Edge)linkEP.getNotationView(), SOURCE_ANCHOR_STYLE);
			if (fromStyle != null){
				return fromStyle; 
			}

			PolylineConnection connection = (PolylineConnection) linkEP.getFigure();
			Point result = connection.getSourceAnchor().getReferencePoint();
			if (result.x == 0 && result.y == 0){
				GraphicalEditPart sourceEP = (GraphicalEditPart) linkEP.getSource();
				Rectangle sourceBounds = MissedMethods._graphicalEditPart().getBounds(sourceEP);
				if (sourceBounds != null){
					result = sourceBounds.getCenter();
				}
			}
			return result;
		}
		
		public Point getTargetPoint(ConnectionEditPart linkEP) {
			Point fromStyle = loadPointFromStyle((Edge)linkEP.getNotationView(), TARGET_ANCHOR_STYLE);
			if (fromStyle != null){
				return fromStyle; 
			}
			
			PolylineConnection connection = (PolylineConnection) linkEP.getFigure();
			Point result = connection.getTargetAnchor().getReferencePoint();
			if (result.x == 0 && result.y == 0){
				GraphicalEditPart targetEP = (GraphicalEditPart) linkEP.getTarget();
				Rectangle targetBounds = MissedMethods._graphicalEditPart().getBounds(targetEP);
				if (targetBounds != null){
					result = targetBounds.getCenter();
				}
			}
			return result;
		}
		
		private Point loadPointFromStyle(Edge edge, String styleName){
			IntListValueStyle style = (IntListValueStyle) edge.getNamedStyle(NotationPackage.eINSTANCE.getIntListValueStyle(), styleName);
			if (style == null){
				return null;
			}
			Integer x = (Integer) style.getIntListValue().get(0);
			Integer y = (Integer) style.getIntListValue().get(1);
			return new Point(x, y);
		}
		
		private void savePointAsStyle(Edge edge, Point point, String styleName){
			IntListValueStyle style = (IntListValueStyle) edge.getNamedStyle(NotationPackage.eINSTANCE.getIntListValueStyle(), styleName);
			if (style == null){
				style = (IntListValueStyle) edge.createStyle(NotationPackage.eINSTANCE.getIntListValueStyle());
				style.setName(styleName);
			}
			style.getIntListValue().clear();
			style.getIntListValue().add(Integer.valueOf(point.x));
			style.getIntListValue().add(Integer.valueOf(point.y));
		}
		
		public void setupBendpoints(ConnectionEditPart linkEP, Point sourcePoint, Point targetPoint, List bendpoints) {
			//System.err.println("Setup bendpoints: " + linkEP);
			//System.err.println("Source: " + sourcePoint + ", Target: " + targetPoint);
			//System.err.println("Bendpoints: " + bendpoints);
			
			Edge edge = (Edge) linkEP.getNotationView();
			GraphicalEditPart sourceEP = (GraphicalEditPart) linkEP.getSource();
			Rectangle sourceBounds = MissedMethods._graphicalEditPart().getBounds(sourceEP);
			ConnectionRoutingHelper.setConnectionSourceAnchor(edge, sourcePoint, sourceBounds);
			savePointAsStyle(edge, sourcePoint, SOURCE_ANCHOR_STYLE);
			
			GraphicalEditPart targetEP = (GraphicalEditPart) linkEP.getTarget();
			Rectangle targetBounds = MissedMethods._graphicalEditPart().getBounds(targetEP);
			ConnectionRoutingHelper.setConnectionTargetAnchor(edge, targetPoint, targetBounds);
			savePointAsStyle(edge, targetPoint, TARGET_ANCHOR_STYLE);
			
			if (!bendpoints.isEmpty()){
				ConnectionRoutingHelper.setConnectionBendPoints(edge, bendpoints, sourcePoint, targetPoint, false);
			}
//			
//			BendpointsGate gate = new BendpointsGate(linkEP);
//			gate.setEdgeAdapter(new EObjectAdapter(linkEP.getNotationView()));
//			PointList pointList = new PointList();
//			pointList.addPoint(sourcePoint);
//			for (Object nextPoint : bendpoints){
//				pointList.addPoint((Point)nextPoint);
//			}
//			pointList.addPoint(targetPoint);
//			gate.setNewPointList(pointList, sourcePoint, targetPoint);
//			gate.run();
		}

		public RelativeBendpoint convert(ConnectionEditPart linkEP, Point point) {
			Connection connection = linkEP.getConnectionFigure();
			Point mySourceRef = connection.getSourceAnchor().getReferencePoint().getCopy();
			connection.translateToRelative(mySourceRef);
			Point myTargetRef = connection.getTargetAnchor().getReferencePoint().getCopy();
			connection.translateToRelative(myTargetRef);

			connection.translateToRelative(point);
			Dimension s = point.getDifference(mySourceRef);
			Dimension t = point.getDifference(myTargetRef);
			return new RelativeBendpoint(s.width, s.height, t.width, t.height);
		}

	
	}
	
	static class MissedExecutionSpecificationImpl implements _ExecutionSpecification{
		public boolean isCreation(ExecutionSpecification spec) {
			// TODO Auto-generated method stub
			return false;
		}
		
		public boolean isDestruction(ExecutionSpecification spec) {
			// TODO Auto-generated method stub
			return false;
		}
		
		public boolean isHideFoundMessage(ExecutionSpecification spec) {
			// TODO Auto-generated method stub
			return false;
		}
	}

}