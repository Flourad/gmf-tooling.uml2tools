package org.eclipse.uml2.diagram.clazz.edit.parts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
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
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.diagram.clazz.edit.policies.Interface2ItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.clazz.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.draw2d.CenterLayout;
import org.eclipse.uml2.diagram.common.draw2d.NameAndStereotypeBlock;
import org.eclipse.uml2.diagram.common.draw2d.StereotypeLabel;
import org.eclipse.uml2.diagram.common.draw2d.StereotypeLabel2;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class Interface2EditPart extends ShapeNodeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2013;

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
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicyWithCustomReparent(UMLVisualIDRegistry.TYPED_ADAPTER));
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Interface2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new AsyncDiagramComponentEditPolicy());
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
		ClassFigure figure = new ClassFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ClassFigure getPrimaryShape() {
		return (ClassFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InterfaceName2EditPart) {
			((InterfaceName2EditPart) childEditPart).setLabel(getPrimaryShape().getFigureClassFigure_NameLabel());
			return true;
		}
		if (childEditPart instanceof InterfaceStereotypeEditPart) {
			((InterfaceStereotypeEditPart) childEditPart).setLabel(getPrimaryShape().getFigureClassFigure_StereoLabel());
			return true;
		}
		if (childEditPart instanceof InterfaceAttributesEditPart) {
			IFigure pane = getPrimaryShape().getFigureClassFigure_PropertiesCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((InterfaceAttributesEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof InterfaceOperationsEditPart) {
			IFigure pane = getPrimaryShape().getFigureClassFigure_OperationsCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((InterfaceOperationsEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof InterfaceClassesEditPart) {
			IFigure pane = getPrimaryShape().getFigureClassFigure_ClassesCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((InterfaceClassesEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof InterfaceAttributesEditPart) {
			IFigure pane = getPrimaryShape().getFigureClassFigure_PropertiesCompartment();
			pane.remove(((InterfaceAttributesEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof InterfaceOperationsEditPart) {
			IFigure pane = getPrimaryShape().getFigureClassFigure_OperationsCompartment();
			pane.remove(((InterfaceOperationsEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof InterfaceClassesEditPart) {
			IFigure pane = getPrimaryShape().getFigureClassFigure_ClassesCompartment();
			pane.remove(((InterfaceClassesEditPart) childEditPart).getFigure());
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
		if (editPart instanceof InterfaceAttributesEditPart) {
			return getPrimaryShape().getFigureClassFigure_PropertiesCompartment();
		}
		if (editPart instanceof InterfaceOperationsEditPart) {
			return getPrimaryShape().getFigureClassFigure_OperationsCompartment();
		}
		if (editPart instanceof InterfaceClassesEditPart) {
			return getPrimaryShape().getFigureClassFigure_ClassesCompartment();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(100), getMapMode().DPtoLP(60));
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(InterfaceName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Generalization_4001);
		types.add(UMLElementTypes.Dependency_4002);
		types.add(UMLElementTypes.Association_4005);
		types.add(UMLElementTypes.Realization_4010);
		types.add(UMLElementTypes.Generalization_4011);
		types.add(UMLElementTypes.Usage_4013);
		types.add(UMLElementTypes.TemplateBinding_4016);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Generalization_4001);
		types.add(UMLElementTypes.Dependency_4002);
		types.add(UMLElementTypes.Property_4003);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4004);
		types.add(UMLElementTypes.Association_4005);
		types.add(UMLElementTypes.DependencySupplier_4006);
		types.add(UMLElementTypes.DependencyClient_4007);
		types.add(UMLElementTypes.InterfaceRealization_4008);
		types.add(UMLElementTypes.Realization_4010);
		types.add(UMLElementTypes.Usage_4013);
		types.add(UMLElementTypes.TemplateBinding_4016);
		types.add(UMLElementTypes.PortProvided_4017);
		types.add(UMLElementTypes.PortRequired_4018);
		types.add(UMLElementTypes.CommentAnnotatedElement_4019);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.Generalization_4001);
		}
		if (targetEditPart instanceof AssociationClass2EditPart) {
			types.add(UMLElementTypes.Generalization_4001);
		}
		if (targetEditPart instanceof DataType2EditPart) {
			types.add(UMLElementTypes.Generalization_4001);
		}
		if (targetEditPart instanceof PrimitiveType2EditPart) {
			types.add(UMLElementTypes.Generalization_4001);
		}
		if (targetEditPart instanceof Enumeration2EditPart) {
			types.add(UMLElementTypes.Generalization_4001);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Generalization_4001);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.Interface2EditPart) {
			types.add(UMLElementTypes.Generalization_4001);
		}
		if (targetEditPart instanceof AssociationClassRhombEditPart) {
			types.add(UMLElementTypes.Generalization_4001);
		}
		if (targetEditPart instanceof Class5EditPart) {
			types.add(UMLElementTypes.Generalization_4001);
		}
		if (targetEditPart instanceof Enumeration3EditPart) {
			types.add(UMLElementTypes.Generalization_4001);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Generalization_4001);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Generalization_4001);
		}
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.Interface2EditPart) {
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
		if (targetEditPart instanceof InstanceSpecification3EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.Association_4005);
		}
		if (targetEditPart instanceof AssociationClass2EditPart) {
			types.add(UMLElementTypes.Association_4005);
		}
		if (targetEditPart instanceof DataType2EditPart) {
			types.add(UMLElementTypes.Association_4005);
		}
		if (targetEditPart instanceof PrimitiveType2EditPart) {
			types.add(UMLElementTypes.Association_4005);
		}
		if (targetEditPart instanceof Enumeration2EditPart) {
			types.add(UMLElementTypes.Association_4005);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Association_4005);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.Interface2EditPart) {
			types.add(UMLElementTypes.Association_4005);
		}
		if (targetEditPart instanceof AssociationClassRhombEditPart) {
			types.add(UMLElementTypes.Association_4005);
		}
		if (targetEditPart instanceof Class5EditPart) {
			types.add(UMLElementTypes.Association_4005);
		}
		if (targetEditPart instanceof Enumeration3EditPart) {
			types.add(UMLElementTypes.Association_4005);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Association_4005);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Association_4005);
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.Interface2EditPart) {
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
		if (targetEditPart instanceof InstanceSpecification3EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof GeneralizationSetEditPart) {
			types.add(UMLElementTypes.Generalization_4011);
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.Interface2EditPart) {
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
		if (targetEditPart instanceof InstanceSpecification3EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Package2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof Class2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof AssociationClass2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof DataType2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof PrimitiveType2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof Enumeration2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.Interface2EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof Package4EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof AssociationClassRhombEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof PackageAsFrameEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof Package6EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof Class5EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof Enumeration3EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
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
		if (relationshipType == UMLElementTypes.Property_4003) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Property_4003) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4004) {
			types.add(UMLElementTypes.Constraint_2006);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		if (relationshipType == UMLElementTypes.DependencySupplier_4006) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.DependencyClient_4007) {
			types.add(UMLElementTypes.Dependency_2009);
		}
		if (relationshipType == UMLElementTypes.InterfaceRealization_4008) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.InterfaceRealization_4008) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.InterfaceRealization_4008) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.InterfaceRealization_4008) {
			types.add(UMLElementTypes.Class_3033);
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
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
		if (relationshipType == UMLElementTypes.PortProvided_4017) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.PortRequired_4018) {
			types.add(UMLElementTypes.Port_3025);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4019) {
			types.add(UMLElementTypes.Comment_2018);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == UMLElementTypes.Property_3028) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(InterfaceAttributesEditPart.VISUAL_ID));
			}
			if (type == UMLElementTypes.Operation_3029) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(InterfaceOperationsEditPart.VISUAL_ID));
			}
			if (type == UMLElementTypes.Class_3030) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(InterfaceClassesEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.PrimitiveType_3037);
		}
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
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.Association_4005) {
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
		if (relationshipType == UMLElementTypes.Generalization_4011) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
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
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_2002);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Class_2001);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.AssociationClass_2007);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.DataType_2004);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.PrimitiveType_2005);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Enumeration_2003);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Interface_2010);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Interface_2013);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_2014);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.AssociationClass_2015);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_3032);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Class_3033);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Enumeration_3034);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.DataType_3036);
		}
		if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.PrimitiveType_3037);
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
	public class ClassFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private RectangleFigure fFigureClassFigure_PropertiesCompartment;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureClassFigure_OperationsCompartment;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureClassFigure_ClassesCompartment;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureClassFigure_LiteralsCompartment;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureClassFigure_OthersCompartment;

		/**
		 * @generated
		 */
		private NameAndStereotypeBlock fNameAndStereotypeBlock;

		/**
		 * @generated
		 */
		public ClassFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fNameAndStereotypeBlock = new NameAndStereotypeBlock();

			fNameAndStereotypeBlock.setBorder(new MarginBorder(getMapMode().DPtoLP(8), getMapMode().DPtoLP(5), getMapMode().DPtoLP(6), getMapMode().DPtoLP(5)));

			this.add(fNameAndStereotypeBlock);

			fFigureClassFigure_PropertiesCompartment = new RectangleFigure();
			fFigureClassFigure_PropertiesCompartment.setLineWidth(1);

			this.add(fFigureClassFigure_PropertiesCompartment);
			fFigureClassFigure_PropertiesCompartment.setLayoutManager(new StackLayout());

			fFigureClassFigure_OperationsCompartment = new RectangleFigure();
			fFigureClassFigure_OperationsCompartment.setLineWidth(1);

			this.add(fFigureClassFigure_OperationsCompartment);
			fFigureClassFigure_OperationsCompartment.setLayoutManager(new StackLayout());

			fFigureClassFigure_ClassesCompartment = new RectangleFigure();
			fFigureClassFigure_ClassesCompartment.setLineWidth(1);

			this.add(fFigureClassFigure_ClassesCompartment);
			fFigureClassFigure_ClassesCompartment.setLayoutManager(new StackLayout());

			fFigureClassFigure_LiteralsCompartment = new RectangleFigure();
			fFigureClassFigure_LiteralsCompartment.setLineWidth(1);

			this.add(fFigureClassFigure_LiteralsCompartment);
			fFigureClassFigure_LiteralsCompartment.setLayoutManager(new StackLayout());

			fFigureClassFigure_OthersCompartment = new RectangleFigure();
			fFigureClassFigure_OthersCompartment.setLineWidth(1);

			this.add(fFigureClassFigure_OthersCompartment);
			fFigureClassFigure_OthersCompartment.setLayoutManager(new StackLayout());

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
		public RectangleFigure getFigureClassFigure_PropertiesCompartment() {
			return fFigureClassFigure_PropertiesCompartment;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureClassFigure_OperationsCompartment() {
			return fFigureClassFigure_OperationsCompartment;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureClassFigure_ClassesCompartment() {
			return fFigureClassFigure_ClassesCompartment;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureClassFigure_LiteralsCompartment() {
			return fFigureClassFigure_LiteralsCompartment;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureClassFigure_OthersCompartment() {
			return fFigureClassFigure_OthersCompartment;
		}

		/**
		 * @generated
		 */
		public NameAndStereotypeBlock getNameAndStereotypeBlock() {
			return fNameAndStereotypeBlock;
		}

		/**
		 * @generated
		 */
		public StereotypeLabel2 getFigureClassFigure_StereoLabel() {
			return getNameAndStereotypeBlock().getStereotypeLabel();
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureClassFigure_NameLabel() {
			return getNameAndStereotypeBlock().getNameLabel();
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
			if (event.getFeature() == UMLPackage.eINSTANCE.getGeneralization_General()) {
				guardedRefreshDiagram();
				return;
			}
			if (event.getFeature() == UMLPackage.eINSTANCE.getGeneralization_GeneralizationSet()) {
				guardedRefreshDiagram();
				return;
			}
			if (event.getFeature() == UMLPackage.eINSTANCE.getTemplateSignature_Template()) {
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
		for (IUpdaterNodeDescriptor next : getInterface_2013ContainedLinks()) {
			EObject nextLink = next.getModelElement();
			if (nextLink == null) {
				continue;
			}
			switch (next.getVisualID()) {
			case GeneralizationEditPart.VISUAL_ID:
				getLinkTargetListener().addReferenceListener(nextLink, UMLPackage.eINSTANCE.getGeneralization_General());
				break;

			case Generalization2EditPart.VISUAL_ID:
				getLinkTargetListener().addReferenceListener(nextLink, UMLPackage.eINSTANCE.getGeneralization_GeneralizationSet());
				break;

			case TemplateBindingEditPart.VISUAL_ID:
				getLinkTargetListener().addReferenceListener(nextLink, UMLPackage.eINSTANCE.getTemplateSignature_Template());
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
	private List<IUpdaterLinkDescriptor> getInterface_2013ContainedLinks() {
		return UMLDiagramUpdater.getInterface_2013ContainedLinks(getNotationView());
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
		if (event.getFeature() == UMLPackage.eINSTANCE.getClassifier_Generalization()) {
			switch (event.getEventType()) {
			case Notification.ADD: {
				Object link = event.getNewValue();
				if (link instanceof Generalization) {
					getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getGeneralization_General());
					getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getGeneralization_GeneralizationSet());
				}
				if (link instanceof Generalization) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.REMOVE: {
				Object link = event.getOldValue();
				if (link instanceof Generalization) {
					getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getGeneralization_General());
					getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getGeneralization_GeneralizationSet());
				}
				if (link instanceof Generalization) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.ADD_MANY: {
				List<?> links = (List<?>) event.getNewValue();
				for (Object link : links) {
					if (link instanceof Generalization) {
						getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getGeneralization_General());
						getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getGeneralization_GeneralizationSet());
					}
				}
				for (Object link : links) {
					if (link instanceof Generalization) {
						guardedRefreshDiagram();
						break;
					}
				}
				break;
			}
			case Notification.REMOVE_MANY: {
				List<?> links = (List<?>) event.getOldValue();
				for (Object link : links) {
					if (link instanceof Generalization) {
						getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getGeneralization_General());
						getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getGeneralization_GeneralizationSet());
					}
				}
				for (Object link : links) {
					if (link instanceof Generalization) {
						guardedRefreshDiagram();
						break;
					}
				}
				break;
			}
			}
		}
		if (event.getFeature() == UMLPackage.eINSTANCE.getTemplateableElement_TemplateBinding()) {
			switch (event.getEventType()) {
			case Notification.ADD: {
				Object link = event.getNewValue();
				if (link instanceof TemplateBinding) {
					getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getTemplateSignature_Template());
				}
				if (link instanceof TemplateBinding) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.REMOVE: {
				Object link = event.getOldValue();
				if (link instanceof TemplateBinding) {
					getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getTemplateSignature_Template());
				}
				if (link instanceof TemplateBinding) {
					guardedRefreshDiagram();
				}
				break;
			}
			case Notification.ADD_MANY: {
				List<?> links = (List<?>) event.getNewValue();
				for (Object link : links) {
					if (link instanceof TemplateBinding) {
						getLinkTargetListener().addReferenceListener((EObject) link, UMLPackage.eINSTANCE.getTemplateSignature_Template());
					}
				}
				for (Object link : links) {
					if (link instanceof TemplateBinding) {
						guardedRefreshDiagram();
						break;
					}
				}
				break;
			}
			case Notification.REMOVE_MANY: {
				List<?> links = (List<?>) event.getOldValue();
				for (Object link : links) {
					if (link instanceof TemplateBinding) {
						getLinkTargetListener().removeReferenceListener((EObject) link, UMLPackage.eINSTANCE.getTemplateSignature_Template());
					}
				}
				for (Object link : links) {
					if (link instanceof TemplateBinding) {
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

}
