package org.eclipse.uml2.diagram.clazz.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.diagram.clazz.edit.policies.InterfaceItemSemanticEditPolicy;
import org.eclipse.uml2.diagram.clazz.links.DiagramLinkInfoProvider;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramUpdateCommand;
import org.eclipse.uml2.diagram.clazz.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.diagram.common.async.AsyncDiagramComponentEditPolicy;
import org.eclipse.uml2.diagram.common.draw2d.UnrestrictedOutsideBorderItemLocator;
import org.eclipse.uml2.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.uml2.diagram.common.editpolicies.U2TResizableShapeEditPolicy;
import org.eclipse.uml2.diagram.common.editpolicies.UpdateDescriptionEditPolicy;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.common.links.RefreshComplementaryLinksHelper;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class InterfaceEditPart extends AbstractBorderedShapeEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2010;

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
	public InterfaceEditPart(View view) {
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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InterfaceItemSemanticEditPolicy());
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
				case InterfaceNameEditPart.VISUAL_ID:
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
		if (borderItemEditPart instanceof InterfaceNameEditPart) {
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(InterfaceNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(7);
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
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(14);
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
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceEditPart) {
			types.add(UMLElementTypes.Generalization_4001);
		}
		if (targetEditPart instanceof Interface2EditPart) {
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
		if (targetEditPart instanceof Interface4EditPart) {
			types.add(UMLElementTypes.Generalization_4001);
		}
		if (targetEditPart instanceof Interface5EditPart) {
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceEditPart) {
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
		if (targetEditPart instanceof InstanceSpecification3EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Interface4EditPart) {
			types.add(UMLElementTypes.Dependency_4002);
		}
		if (targetEditPart instanceof Interface5EditPart) {
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceEditPart) {
			types.add(UMLElementTypes.Association_4005);
		}
		if (targetEditPart instanceof Interface2EditPart) {
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
		if (targetEditPart instanceof Interface4EditPart) {
			types.add(UMLElementTypes.Association_4005);
		}
		if (targetEditPart instanceof Interface5EditPart) {
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceEditPart) {
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
		if (targetEditPart instanceof InstanceSpecification3EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Interface4EditPart) {
			types.add(UMLElementTypes.Realization_4010);
		}
		if (targetEditPart instanceof Interface5EditPart) {
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceEditPart) {
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
		if (targetEditPart instanceof InstanceSpecification3EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof DataType3EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof PrimitiveType3EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Interface4EditPart) {
			types.add(UMLElementTypes.Usage_4013);
		}
		if (targetEditPart instanceof Interface5EditPart) {
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
		if (targetEditPart instanceof org.eclipse.uml2.diagram.clazz.edit.parts.InterfaceEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof Interface2EditPart) {
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
		if (targetEditPart instanceof Interface4EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		if (targetEditPart instanceof Interface5EditPart) {
			types.add(UMLElementTypes.TemplateBinding_4016);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.Class_2001);
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.DataType_2004);
			types.add(UMLElementTypes.PrimitiveType_2005);
			types.add(UMLElementTypes.Enumeration_2003);
			types.add(UMLElementTypes.Interface_2010);
			types.add(UMLElementTypes.Interface_2013);
			types.add(UMLElementTypes.AssociationClass_2015);
			types.add(UMLElementTypes.Class_3033);
			types.add(UMLElementTypes.Enumeration_3034);
			types.add(UMLElementTypes.DataType_3036);
			types.add(UMLElementTypes.PrimitiveType_3037);
			types.add(UMLElementTypes.Interface_3042);
			types.add(UMLElementTypes.Interface_3043);
		} else if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_2002);
			types.add(UMLElementTypes.Class_2001);
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.DataType_2004);
			types.add(UMLElementTypes.PrimitiveType_2005);
			types.add(UMLElementTypes.Enumeration_2003);
			types.add(UMLElementTypes.Interface_2010);
			types.add(UMLElementTypes.Constraint_2006);
			types.add(UMLElementTypes.InstanceSpecification_2008);
			types.add(UMLElementTypes.Dependency_2009);
			types.add(UMLElementTypes.GeneralizationSet_2012);
			types.add(UMLElementTypes.Interface_2013);
			types.add(UMLElementTypes.Package_2014);
			types.add(UMLElementTypes.AssociationClass_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.InstanceSpecification_2017);
			types.add(UMLElementTypes.Port_3025);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.Package_3032);
			types.add(UMLElementTypes.Class_3033);
			types.add(UMLElementTypes.Enumeration_3034);
			types.add(UMLElementTypes.InstanceSpecification_3035);
			types.add(UMLElementTypes.DataType_3036);
			types.add(UMLElementTypes.PrimitiveType_3037);
			types.add(UMLElementTypes.Interface_3042);
			types.add(UMLElementTypes.Interface_3043);
		} else if (relationshipType == UMLElementTypes.Property_4003) {
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.AssociationClass_2015);
		} else if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4004) {
			types.add(UMLElementTypes.Constraint_2006);
		} else if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.Class_2001);
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.DataType_2004);
			types.add(UMLElementTypes.PrimitiveType_2005);
			types.add(UMLElementTypes.Enumeration_2003);
			types.add(UMLElementTypes.Interface_2010);
			types.add(UMLElementTypes.Interface_2013);
			types.add(UMLElementTypes.AssociationClass_2015);
			types.add(UMLElementTypes.Class_3033);
			types.add(UMLElementTypes.Enumeration_3034);
			types.add(UMLElementTypes.DataType_3036);
			types.add(UMLElementTypes.PrimitiveType_3037);
			types.add(UMLElementTypes.Interface_3042);
			types.add(UMLElementTypes.Interface_3043);
		} else if (relationshipType == UMLElementTypes.DependencySupplier_4006) {
			types.add(UMLElementTypes.Dependency_2009);
		} else if (relationshipType == UMLElementTypes.DependencyClient_4007) {
			types.add(UMLElementTypes.Dependency_2009);
		} else if (relationshipType == UMLElementTypes.InterfaceRealization_4008) {
			types.add(UMLElementTypes.Class_2001);
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.AssociationClass_2015);
			types.add(UMLElementTypes.Class_3033);
		} else if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_2002);
			types.add(UMLElementTypes.Class_2001);
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.DataType_2004);
			types.add(UMLElementTypes.PrimitiveType_2005);
			types.add(UMLElementTypes.Enumeration_2003);
			types.add(UMLElementTypes.Interface_2010);
			types.add(UMLElementTypes.Constraint_2006);
			types.add(UMLElementTypes.InstanceSpecification_2008);
			types.add(UMLElementTypes.Dependency_2009);
			types.add(UMLElementTypes.GeneralizationSet_2012);
			types.add(UMLElementTypes.Interface_2013);
			types.add(UMLElementTypes.Package_2014);
			types.add(UMLElementTypes.AssociationClass_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.InstanceSpecification_2017);
			types.add(UMLElementTypes.Port_3025);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.Package_3032);
			types.add(UMLElementTypes.Class_3033);
			types.add(UMLElementTypes.Enumeration_3034);
			types.add(UMLElementTypes.InstanceSpecification_3035);
			types.add(UMLElementTypes.DataType_3036);
			types.add(UMLElementTypes.PrimitiveType_3037);
			types.add(UMLElementTypes.Interface_3042);
			types.add(UMLElementTypes.Interface_3043);
		} else if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_2002);
			types.add(UMLElementTypes.Class_2001);
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.DataType_2004);
			types.add(UMLElementTypes.PrimitiveType_2005);
			types.add(UMLElementTypes.Enumeration_2003);
			types.add(UMLElementTypes.Interface_2010);
			types.add(UMLElementTypes.Constraint_2006);
			types.add(UMLElementTypes.InstanceSpecification_2008);
			types.add(UMLElementTypes.Dependency_2009);
			types.add(UMLElementTypes.GeneralizationSet_2012);
			types.add(UMLElementTypes.Interface_2013);
			types.add(UMLElementTypes.Package_2014);
			types.add(UMLElementTypes.AssociationClass_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.InstanceSpecification_2017);
			types.add(UMLElementTypes.Port_3025);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.Package_3032);
			types.add(UMLElementTypes.Class_3033);
			types.add(UMLElementTypes.Enumeration_3034);
			types.add(UMLElementTypes.InstanceSpecification_3035);
			types.add(UMLElementTypes.DataType_3036);
			types.add(UMLElementTypes.PrimitiveType_3037);
			types.add(UMLElementTypes.Interface_3042);
			types.add(UMLElementTypes.Interface_3043);
		} else if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_2002);
			types.add(UMLElementTypes.Class_2001);
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.DataType_2004);
			types.add(UMLElementTypes.PrimitiveType_2005);
			types.add(UMLElementTypes.Enumeration_2003);
			types.add(UMLElementTypes.Interface_2010);
			types.add(UMLElementTypes.Interface_2013);
			types.add(UMLElementTypes.Package_2014);
			types.add(UMLElementTypes.AssociationClass_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Package_3032);
			types.add(UMLElementTypes.Class_3033);
			types.add(UMLElementTypes.Enumeration_3034);
			types.add(UMLElementTypes.DataType_3036);
			types.add(UMLElementTypes.PrimitiveType_3037);
			types.add(UMLElementTypes.Interface_3042);
			types.add(UMLElementTypes.Interface_3043);
		} else if (relationshipType == UMLElementTypes.PortProvided_4017) {
			types.add(UMLElementTypes.Port_3025);
		} else if (relationshipType == UMLElementTypes.PortRequired_4018) {
			types.add(UMLElementTypes.Port_3025);
		} else if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4019) {
			types.add(UMLElementTypes.Comment_2018);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == UMLElementTypes.Generalization_4001) {
			types.add(UMLElementTypes.Class_2001);
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.DataType_2004);
			types.add(UMLElementTypes.PrimitiveType_2005);
			types.add(UMLElementTypes.Enumeration_2003);
			types.add(UMLElementTypes.Interface_2010);
			types.add(UMLElementTypes.Interface_2013);
			types.add(UMLElementTypes.AssociationClass_2015);
			types.add(UMLElementTypes.Class_3033);
			types.add(UMLElementTypes.Enumeration_3034);
			types.add(UMLElementTypes.DataType_3036);
			types.add(UMLElementTypes.PrimitiveType_3037);
			types.add(UMLElementTypes.Interface_3042);
			types.add(UMLElementTypes.Interface_3043);
		} else if (relationshipType == UMLElementTypes.Dependency_4002) {
			types.add(UMLElementTypes.Package_2002);
			types.add(UMLElementTypes.Class_2001);
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.DataType_2004);
			types.add(UMLElementTypes.PrimitiveType_2005);
			types.add(UMLElementTypes.Enumeration_2003);
			types.add(UMLElementTypes.Interface_2010);
			types.add(UMLElementTypes.Constraint_2006);
			types.add(UMLElementTypes.InstanceSpecification_2008);
			types.add(UMLElementTypes.Dependency_2009);
			types.add(UMLElementTypes.GeneralizationSet_2012);
			types.add(UMLElementTypes.Interface_2013);
			types.add(UMLElementTypes.Package_2014);
			types.add(UMLElementTypes.AssociationClass_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.InstanceSpecification_2017);
			types.add(UMLElementTypes.Port_3025);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.Package_3032);
			types.add(UMLElementTypes.Class_3033);
			types.add(UMLElementTypes.Enumeration_3034);
			types.add(UMLElementTypes.InstanceSpecification_3035);
			types.add(UMLElementTypes.DataType_3036);
			types.add(UMLElementTypes.PrimitiveType_3037);
			types.add(UMLElementTypes.Interface_3042);
			types.add(UMLElementTypes.Interface_3043);
		} else if (relationshipType == UMLElementTypes.Association_4005) {
			types.add(UMLElementTypes.Class_2001);
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.DataType_2004);
			types.add(UMLElementTypes.PrimitiveType_2005);
			types.add(UMLElementTypes.Enumeration_2003);
			types.add(UMLElementTypes.Interface_2010);
			types.add(UMLElementTypes.Interface_2013);
			types.add(UMLElementTypes.AssociationClass_2015);
			types.add(UMLElementTypes.Class_3033);
			types.add(UMLElementTypes.Enumeration_3034);
			types.add(UMLElementTypes.DataType_3036);
			types.add(UMLElementTypes.PrimitiveType_3037);
			types.add(UMLElementTypes.Interface_3042);
			types.add(UMLElementTypes.Interface_3043);
		} else if (relationshipType == UMLElementTypes.Realization_4010) {
			types.add(UMLElementTypes.Package_2002);
			types.add(UMLElementTypes.Class_2001);
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.DataType_2004);
			types.add(UMLElementTypes.PrimitiveType_2005);
			types.add(UMLElementTypes.Enumeration_2003);
			types.add(UMLElementTypes.Interface_2010);
			types.add(UMLElementTypes.Constraint_2006);
			types.add(UMLElementTypes.InstanceSpecification_2008);
			types.add(UMLElementTypes.Dependency_2009);
			types.add(UMLElementTypes.GeneralizationSet_2012);
			types.add(UMLElementTypes.Interface_2013);
			types.add(UMLElementTypes.Package_2014);
			types.add(UMLElementTypes.AssociationClass_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.InstanceSpecification_2017);
			types.add(UMLElementTypes.Port_3025);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.Package_3032);
			types.add(UMLElementTypes.Class_3033);
			types.add(UMLElementTypes.Enumeration_3034);
			types.add(UMLElementTypes.InstanceSpecification_3035);
			types.add(UMLElementTypes.DataType_3036);
			types.add(UMLElementTypes.PrimitiveType_3037);
			types.add(UMLElementTypes.Interface_3042);
			types.add(UMLElementTypes.Interface_3043);
		} else if (relationshipType == UMLElementTypes.Generalization_4011) {
			types.add(UMLElementTypes.GeneralizationSet_2012);
		} else if (relationshipType == UMLElementTypes.Usage_4013) {
			types.add(UMLElementTypes.Package_2002);
			types.add(UMLElementTypes.Class_2001);
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.DataType_2004);
			types.add(UMLElementTypes.PrimitiveType_2005);
			types.add(UMLElementTypes.Enumeration_2003);
			types.add(UMLElementTypes.Interface_2010);
			types.add(UMLElementTypes.Constraint_2006);
			types.add(UMLElementTypes.InstanceSpecification_2008);
			types.add(UMLElementTypes.Dependency_2009);
			types.add(UMLElementTypes.GeneralizationSet_2012);
			types.add(UMLElementTypes.Interface_2013);
			types.add(UMLElementTypes.Package_2014);
			types.add(UMLElementTypes.AssociationClass_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.InstanceSpecification_2017);
			types.add(UMLElementTypes.Port_3025);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3027);
			types.add(UMLElementTypes.Package_3032);
			types.add(UMLElementTypes.Class_3033);
			types.add(UMLElementTypes.Enumeration_3034);
			types.add(UMLElementTypes.InstanceSpecification_3035);
			types.add(UMLElementTypes.DataType_3036);
			types.add(UMLElementTypes.PrimitiveType_3037);
			types.add(UMLElementTypes.Interface_3042);
			types.add(UMLElementTypes.Interface_3043);
		} else if (relationshipType == UMLElementTypes.TemplateBinding_4016) {
			types.add(UMLElementTypes.Package_2002);
			types.add(UMLElementTypes.Class_2001);
			types.add(UMLElementTypes.AssociationClass_2007);
			types.add(UMLElementTypes.DataType_2004);
			types.add(UMLElementTypes.PrimitiveType_2005);
			types.add(UMLElementTypes.Enumeration_2003);
			types.add(UMLElementTypes.Interface_2010);
			types.add(UMLElementTypes.Interface_2013);
			types.add(UMLElementTypes.Package_2014);
			types.add(UMLElementTypes.AssociationClass_2015);
			types.add(UMLElementTypes.Package_2016);
			types.add(UMLElementTypes.Package_3032);
			types.add(UMLElementTypes.Class_3033);
			types.add(UMLElementTypes.Enumeration_3034);
			types.add(UMLElementTypes.DataType_3036);
			types.add(UMLElementTypes.PrimitiveType_3037);
			types.add(UMLElementTypes.Interface_3042);
			types.add(UMLElementTypes.Interface_3043);
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
		for (IUpdaterNodeDescriptor next : getInterface_2010ContainedLinks()) {
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
	private List<? extends IUpdaterLinkDescriptor> getInterface_2010ContainedLinks() {
		return UMLDiagramUpdater.getInterface_2010ContainedLinks(getNotationView());
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
