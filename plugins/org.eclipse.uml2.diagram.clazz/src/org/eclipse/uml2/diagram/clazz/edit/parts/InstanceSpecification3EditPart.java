package org.eclipse.uml2.diagram.clazz.edit.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.OneLineBorder;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.clazz.edit.policies.InstanceSpecification3ItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.clazz.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.draw2d.CenterLayout;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class InstanceSpecification3EditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3035;

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
	public InstanceSpecification3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		if (UMLVisualIDRegistry.isShortcutDescendant(getNotationView())) {
			installEditPolicy(UpdateDescriptionEditPolicy.ROLE, new UpdateDescriptionEditPolicy(UMLDiagramUpdater.TYPED_ADAPTER, true));
		}
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(UMLVisualIDRegistry.TYPED_ADAPTER) {

			public Command getCommand(Request request) {
				if (understandsRequest(request)) {
					if (request instanceof CreateViewAndElementRequest) {
						CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
						IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
						if (type == UMLElementTypes.Slot_3017) {
							EditPart compartmentEditPart = getChildBySemanticHint(UMLVisualIDRegistry.getType(InstanceSpecificationSlots2EditPart.VISUAL_ID));
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
					}
					return super.getCommand(request);
				}
				return null;
			}
		});
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InstanceSpecification3ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {

		ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof ITextAwareEditPart) {
						return new UMLTextSelectionEditPolicy();
					}
				}
				return super.createChildEditPolicy(child);
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		InstanceNodeFigure figure = new InstanceNodeFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public InstanceNodeFigure getPrimaryShape() {
		return (InstanceNodeFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InstanceSpecificationName2EditPart) {
			((InstanceSpecificationName2EditPart) childEditPart).setLabel(getPrimaryShape().getFigureInstanceNode_NameLabel());
			return true;
		}
		if (childEditPart instanceof InstanceSpecificationSlots2EditPart) {
			IFigure pane = getPrimaryShape().getFigureInstanceNode_SlotsCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((InstanceSpecificationSlots2EditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof InstanceSpecificationSlots2EditPart) {
			IFigure pane = getPrimaryShape().getFigureInstanceNode_SlotsCompartmentFigure();
			pane.remove(((InstanceSpecificationSlots2EditPart) childEditPart).getFigure());
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

		if (editPart instanceof InstanceSpecificationSlots2EditPart) {
			return getPrimaryShape().getFigureInstanceNode_SlotsCompartmentFigure();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(InstanceSpecificationName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Dependency_4002);
		types.add(UMLElementTypes.Realization_4010);
		types.add(UMLElementTypes.Usage_4013);
		types.add(UMLElementTypes.Slot_4015);
		types.add(UMLElementTypes.Comment_4019);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Dependency_4002);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4004);
		types.add(UMLElementTypes.DependencySupplier_4006);
		types.add(UMLElementTypes.DependencyClient_4007);
		types.add(UMLElementTypes.Realization_4010);
		types.add(UMLElementTypes.Usage_4013);
		types.add(UMLElementTypes.Slot_4015);
		types.add(UMLElementTypes.Comment_4019);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof AssociationClass2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof DataType2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof PrimitiveType2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Enumeration2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof InstanceSpecification2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof DependencyEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof GeneralizationSetEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Package4EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof AssociationClassRhombEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof PackageAsFrameEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof InstanceSpecification4EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Package6EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Class5EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Enumeration3EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification3EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof AssociationClass2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof DataType2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof PrimitiveType2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Enumeration2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof InstanceSpecification2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof DependencyEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof GeneralizationSetEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Package4EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof AssociationClassRhombEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof PackageAsFrameEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof InstanceSpecification4EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Package6EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Class5EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Enumeration3EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification3EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof AssociationClass2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof DataType2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof PrimitiveType2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Enumeration2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof InstanceSpecification2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof DependencyEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof GeneralizationSetEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Package4EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof AssociationClassRhombEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof PackageAsFrameEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof InstanceSpecification4EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Package6EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Class5EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Enumeration3EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification3EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof InstanceSpecification2EditPart) {
			types.add(UMLElementTypes.Slot_4015);
		}
		if (targetEditPart instanceof InstanceSpecification4EditPart) {
			types.add(UMLElementTypes.Slot_4015);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification3EditPart) {
			types.add(UMLElementTypes.Slot_4015);
		}
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof AssociationClass2EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof DataType2EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof PrimitiveType2EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof Enumeration2EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof InstanceSpecification2EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof DependencyEditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof GeneralizationSetEditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof Interface2EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof Package4EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof AssociationClassRhombEditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof PackageAsFrameEditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof InstanceSpecification4EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof CommentEditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof Package6EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof Class5EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof Enumeration3EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.InstanceSpecification3EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Comment_4019);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4004) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.DependencySupplier_4006) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.DependencyClient_4007) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		if (relationshipType == UMLElementTypes.Slot_4015) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Slot_4015) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Slot_4015) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Comment_2018);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		if (relationshipType == UMLElementTypes.Slot_4015) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Slot_4015) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Slot_4015) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.InstanceSpecification_2008);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.InstanceSpecification_2017);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Comment_2018);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.InstanceSpecification_3035);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Comment_4019) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		return types;
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		if (isCanonicalEnabled()) {
			handleTypeLinkModification(event);
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
			if (event.getFeature() == UMLPackage.eINSTANCE.getSlot_OwningInstance()) {
				refreshDiagram();
				return;
			}
			if (event.getFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
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
		for (IUpdaterNodeDescriptor next : getInstanceSpecification_3035ContainedLinks()) {
			EObject nextLink = next.getModelElement();
			if (nextLink == null) {
				continue;
			}
			switch (next.getVisualID()) {
			case AssociationInstanceEditPart.VISUAL_ID:
				getLinkTargetListener().addReferenceListener(nextLink, UMLPackage.eINSTANCE.getSlot_OwningInstance());
				break;

			case Comment2EditPart.VISUAL_ID:
				getLinkTargetListener().addReferenceListener(nextLink, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
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
	private List<IUpdaterLinkDescriptor> getInstanceSpecification_3035ContainedLinks() {
		return UMLDiagramUpdater.getInstanceSpecification_3035ContainedLinks(getNotationView());
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
		if (event.getFeature() == UMLPackage.eINSTANCE.getInstanceSpecification_Slot()) {
			switch (event.getEventType()) {
			case Notification.ADD: {
				Object link = event.getNewValue();
				if (link instanceof Slot) {
					getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getSlot_OwningInstance());
				}
				if (link instanceof Slot) {
					refreshDiagram();
				}
				break;
			}
			case Notification.REMOVE: {
				Object link = event.getOldValue();
				if (link instanceof Slot) {
					getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getSlot_OwningInstance());
				}
				if (link instanceof Slot) {
					refreshDiagram();
				}
				break;
			}
			case Notification.ADD_MANY: {
				List<?> links = (List<?>) event.getNewValue();
				for (Object link : links) {
					if (link instanceof Slot) {
						getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getSlot_OwningInstance());
					}
				}
				for (Object link : links) {
					if (link instanceof Slot) {
						refreshDiagram();
						break;
					}
				}
				break;
			}
			case Notification.REMOVE_MANY: {
				List<?> links = (List<?>) event.getOldValue();
				for (Object link : links) {
					if (link instanceof Slot) {
						getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getSlot_OwningInstance());
					}
				}
				for (Object link : links) {
					if (link instanceof Slot) {
						refreshDiagram();
						break;
					}
				}
				break;
			}
			}
		}
		if (event.getFeature() == UMLPackage.eINSTANCE.getElement_OwnedComment()) {
			switch (event.getEventType()) {
			case Notification.ADD: {
				Object link = event.getNewValue();
				if (link instanceof Comment) {
					getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
				}
				if (link instanceof Comment) {
					refreshDiagram();
				}
				break;
			}
			case Notification.REMOVE: {
				Object link = event.getOldValue();
				if (link instanceof Comment) {
					getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
				}
				if (link instanceof Comment) {
					refreshDiagram();
				}
				break;
			}
			case Notification.ADD_MANY: {
				List<?> links = (List<?>) event.getNewValue();
				for (Object link : links) {
					if (link instanceof Comment) {
						getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
					}
				}
				for (Object link : links) {
					if (link instanceof Comment) {
						refreshDiagram();
						break;
					}
				}
				break;
			}
			case Notification.REMOVE_MANY: {
				List<?> links = (List<?>) event.getOldValue();
				for (Object link : links) {
					if (link instanceof Comment) {
						getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getComment_AnnotatedElement());
					}
				}
				for (Object link : links) {
					if (link instanceof Comment) {
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
	private boolean isCanonicalEnabled() {
		//this particular edit part may not have editpolicy at all, 
		//but its compartments still may have it
		EObject semantic = resolveSemanticElement();
		if (semantic == null) {
			return false;
		}
		for (Object next : CanonicalEditPolicy.getRegisteredEditPolicies(semantic)) {
			if (next instanceof CanonicalEditPolicy) {
				CanonicalEditPolicy nextPolicy = (CanonicalEditPolicy) next;
				if (nextPolicy.isEnabled()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	public void refreshDiagram() {
		UMLDiagramUpdateCommand.performCanonicalUpdate(getDiagramView().getElement());
	}

	/**
	 * @generated
	 */
	public class InstanceNodeFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private Label fFigureInstanceNode_NameLabel;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureInstanceNode_SlotsCompartmentFigure;

		/**
		 * @generated
		 */
		public InstanceNodeFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setBorder(new MarginBorder(getMapMode().DPtoLP(1), getMapMode().DPtoLP(1), getMapMode().DPtoLP(1), getMapMode().DPtoLP(1)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure instanceNode_NameContainerFigure0 = new RectangleFigure();
			instanceNode_NameContainerFigure0.setOutline(false);
			instanceNode_NameContainerFigure0.setBorder(createBorder0());

			this.add(instanceNode_NameContainerFigure0);

			ToolbarLayout layoutInstanceNode_NameContainerFigure0 = new ToolbarLayout();
			layoutInstanceNode_NameContainerFigure0.setStretchMinorAxis(true);
			layoutInstanceNode_NameContainerFigure0.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutInstanceNode_NameContainerFigure0.setSpacing(0);
			layoutInstanceNode_NameContainerFigure0.setVertical(true);

			instanceNode_NameContainerFigure0.setLayoutManager(layoutInstanceNode_NameContainerFigure0);

			fFigureInstanceNode_NameLabel = new Label();
			fFigureInstanceNode_NameLabel.setText("");

			instanceNode_NameContainerFigure0.add(fFigureInstanceNode_NameLabel);

			CenterLayout layoutFFigureInstanceNode_NameLabel = new CenterLayout();

			fFigureInstanceNode_NameLabel.setLayoutManager(layoutFFigureInstanceNode_NameLabel);

			fFigureInstanceNode_SlotsCompartmentFigure = new RectangleFigure();
			fFigureInstanceNode_SlotsCompartmentFigure.setOutline(false);

			this.add(fFigureInstanceNode_SlotsCompartmentFigure);

		}

		/**
		 * @generated
		 */
		private Border createBorder0() {
			OneLineBorder result = new OneLineBorder();

			result.setPosition(PositionConstants.BOTTOM);

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
		public Label getFigureInstanceNode_NameLabel() {
			return fFigureInstanceNode_NameLabel;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureInstanceNode_SlotsCompartmentFigure() {
			return fFigureInstanceNode_SlotsCompartmentFigure;
		}

	}

}
