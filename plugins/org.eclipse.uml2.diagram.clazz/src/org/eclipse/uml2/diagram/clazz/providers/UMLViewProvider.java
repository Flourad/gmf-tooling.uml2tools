package org.eclipse.uml2.diagram.clazz.providers;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.uml2.diagram.clazz.details.UMLDetailLevelService;
import org.eclipse.uml2.diagram.clazz.edit.parts.*;
import org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.common.notation.u2tnotation.U2TDiagramCanonicalStyle;
import org.eclipse.uml2.diagram.common.notation.u2tnotation.U2TNotationFactory;
import org.eclipse.uml2.diagram.common.view.ViewProviderUtils;

/**
 * @generated
 */
public class UMLViewProvider extends AbstractProvider implements IViewProvider {

	/**
	 * @generated
	 */
	public final boolean provides(IOperation operation) {
		if (operation instanceof CreateViewForKindOperation) {
			return provides((CreateViewForKindOperation) operation);
		}
		assert operation instanceof CreateViewOperation;
		if (operation instanceof CreateDiagramViewOperation) {
			return provides((CreateDiagramViewOperation) operation);
		} else if (operation instanceof CreateEdgeViewOperation) {
			return provides((CreateEdgeViewOperation) operation);
		} else if (operation instanceof CreateNodeViewOperation) {
			return provides((CreateNodeViewOperation) operation);
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateViewForKindOperation op) {
		/*
		    if (op.getViewKind() == Node.class)
		      return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		    if (op.getViewKind() == Edge.class)
		      return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		*/
		return true;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation op) {
		return PackageEditPart.MODEL_ID.equals(op.getSemanticHint()) && UMLVisualIDRegistry.getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateNodeViewOperation op) {
		if (op.getContainerView() == null) {
			return false;
		}
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		int visualID;
		if (op.getSemanticHint() == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return false;
			}
			visualID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(op.getSemanticHint());
			if (elementType != null) {
				if (!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
					return false; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
				if (!op.getSemanticHint().equals(elementTypeHint)) {
					return false; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null && !UMLVisualIDRegistry.checkNodeVisualID(op.getContainerView(), domainElement, visualID)) {
					return false; // visual id for node EClass should match visual id from element type, or at least be substitutable for it
				}
			} else {
				if (!PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch (visualID) {
				case Package2EditPart.VISUAL_ID: {
					if (domainElement == null) {
						return false;
					}

					int suggestedID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
					if (visualID != suggestedID && PackageAsFrameEditPart.VISUAL_ID != suggestedID && true) {
						return false;
					}
					break;
				}
				case AssociationClass2EditPart.VISUAL_ID: {
					if (domainElement == null) {
						return false;
					}

					int suggestedID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
					if (visualID != suggestedID && AssociationClassRhombEditPart.VISUAL_ID != suggestedID && true) {
						return false;
					}
					break;
				}
				case InterfaceEditPart.VISUAL_ID: {
					if (domainElement == null) {
						return false;
					}

					int suggestedID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
					if (visualID != suggestedID && Interface2EditPart.VISUAL_ID != suggestedID && true) {
						return false;
					}
					break;
				}
				case InstanceSpecification2EditPart.VISUAL_ID: {
					if (domainElement == null) {
						return false;
					}

					int suggestedID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
					if (visualID != suggestedID && InstanceSpecification4EditPart.VISUAL_ID != suggestedID && true) {
						return false;
					}
					break;
				}
				case Interface2EditPart.VISUAL_ID: {
					if (domainElement == null) {
						return false;
					}

					int suggestedID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
					if (visualID != suggestedID && InterfaceEditPart.VISUAL_ID != suggestedID && true) {
						return false;
					}
					break;
				}
				case AssociationClassRhombEditPart.VISUAL_ID: {
					if (domainElement == null) {
						return false;
					}

					int suggestedID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
					if (visualID != suggestedID && AssociationClass2EditPart.VISUAL_ID != suggestedID && true) {
						return false;
					}
					break;
				}
				case PackageAsFrameEditPart.VISUAL_ID: {
					if (domainElement == null) {
						return false;
					}

					int suggestedID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
					if (visualID != suggestedID && Package2EditPart.VISUAL_ID != suggestedID && true) {
						return false;
					}
					break;
				}
				case InstanceSpecification4EditPart.VISUAL_ID: {
					if (domainElement == null) {
						return false;
					}

					int suggestedID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
					if (visualID != suggestedID && InstanceSpecification2EditPart.VISUAL_ID != suggestedID && true) {
						return false;
					}
					break;
				}
				case Interface4EditPart.VISUAL_ID: {
					if (domainElement == null) {
						return false;
					}

					int suggestedID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
					if (visualID != suggestedID && Interface5EditPart.VISUAL_ID != suggestedID && true) {
						return false;
					}
					break;
				}
				case Interface5EditPart.VISUAL_ID: {
					if (domainElement == null) {
						return false;
					}

					int suggestedID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
					if (visualID != suggestedID && Interface4EditPart.VISUAL_ID != suggestedID && true) {
						return false;
					}
					break;
				}
				case ConstraintEditPart.VISUAL_ID:
				case DependencyEditPart.VISUAL_ID:
				case GeneralizationSetEditPart.VISUAL_ID:
				case CommentEditPart.VISUAL_ID:
				case ClassEditPart.VISUAL_ID:
				case DataTypeEditPart.VISUAL_ID:
				case PrimitiveTypeEditPart.VISUAL_ID:
				case EnumerationEditPart.VISUAL_ID:
				case AssociationClassEditPart.VISUAL_ID:
				case Interface3EditPart.VISUAL_ID:
				case InstanceSpecificationEditPart.VISUAL_ID:
				case PropertyEditPart.VISUAL_ID:
				case OperationEditPart.VISUAL_ID:
				case PortEditPart.VISUAL_ID:
				case RedefinableTemplateSignatureEditPart.VISUAL_ID:
				case EnumerationLiteralEditPart.VISUAL_ID:
				case SlotEditPart.VISUAL_ID:
				case ElementImportEditPart.VISUAL_ID:
				case LiteralStringEditPart.VISUAL_ID:
				case LiteralIntegerEditPart.VISUAL_ID:
				case ExpressionEditPart.VISUAL_ID:
				case Class2EditPart.VISUAL_ID:
				case DataType2EditPart.VISUAL_ID:
				case PrimitiveType2EditPart.VISUAL_ID:
				case Enumeration2EditPart.VISUAL_ID:
				case Package4EditPart.VISUAL_ID:
				case Package3EditPart.VISUAL_ID:
				case Class3EditPart.VISUAL_ID:
				case Property2EditPart.VISUAL_ID:
				case Operation2EditPart.VISUAL_ID:
				case Property3EditPart.VISUAL_ID:
				case Operation3EditPart.VISUAL_ID:
				case Property4EditPart.VISUAL_ID:
				case Operation4EditPart.VISUAL_ID:
				case Property5EditPart.VISUAL_ID:
				case Operation5EditPart.VISUAL_ID:
				case Property6EditPart.VISUAL_ID:
				case Operation6EditPart.VISUAL_ID:
				case Class4EditPart.VISUAL_ID:
				case Package6EditPart.VISUAL_ID:
				case Class5EditPart.VISUAL_ID:
				case Enumeration3EditPart.VISUAL_ID:
				case InstanceSpecification3EditPart.VISUAL_ID:
				case DataType3EditPart.VISUAL_ID:
				case PrimitiveType3EditPart.VISUAL_ID:
					if (domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return Package2EditPart.VISUAL_ID == visualID || Class2EditPart.VISUAL_ID == visualID || AssociationClass2EditPart.VISUAL_ID == visualID || DataType2EditPart.VISUAL_ID == visualID
				|| PrimitiveType2EditPart.VISUAL_ID == visualID || Enumeration2EditPart.VISUAL_ID == visualID || InterfaceEditPart.VISUAL_ID == visualID || ConstraintEditPart.VISUAL_ID == visualID
				|| InstanceSpecification2EditPart.VISUAL_ID == visualID || DependencyEditPart.VISUAL_ID == visualID || GeneralizationSetEditPart.VISUAL_ID == visualID
				|| Interface2EditPart.VISUAL_ID == visualID || Package4EditPart.VISUAL_ID == visualID || AssociationClassRhombEditPart.VISUAL_ID == visualID
				|| PackageAsFrameEditPart.VISUAL_ID == visualID || InstanceSpecification4EditPart.VISUAL_ID == visualID || CommentEditPart.VISUAL_ID == visualID
				|| Package3EditPart.VISUAL_ID == visualID || ClassEditPart.VISUAL_ID == visualID || DataTypeEditPart.VISUAL_ID == visualID || PrimitiveTypeEditPart.VISUAL_ID == visualID
				|| EnumerationEditPart.VISUAL_ID == visualID || AssociationClassEditPart.VISUAL_ID == visualID || Interface3EditPart.VISUAL_ID == visualID
				|| InstanceSpecificationEditPart.VISUAL_ID == visualID || PropertyEditPart.VISUAL_ID == visualID || OperationEditPart.VISUAL_ID == visualID || Class3EditPart.VISUAL_ID == visualID
				|| PortEditPart.VISUAL_ID == visualID || RedefinableTemplateSignatureEditPart.VISUAL_ID == visualID || Property2EditPart.VISUAL_ID == visualID
				|| Operation2EditPart.VISUAL_ID == visualID || Property3EditPart.VISUAL_ID == visualID || Operation3EditPart.VISUAL_ID == visualID || Property4EditPart.VISUAL_ID == visualID
				|| Operation4EditPart.VISUAL_ID == visualID || EnumerationLiteralEditPart.VISUAL_ID == visualID || Property5EditPart.VISUAL_ID == visualID || Operation5EditPart.VISUAL_ID == visualID
				|| SlotEditPart.VISUAL_ID == visualID || Property6EditPart.VISUAL_ID == visualID || Operation6EditPart.VISUAL_ID == visualID || Class4EditPart.VISUAL_ID == visualID
				|| ElementImportEditPart.VISUAL_ID == visualID || Package6EditPart.VISUAL_ID == visualID || Class5EditPart.VISUAL_ID == visualID || Enumeration3EditPart.VISUAL_ID == visualID
				|| InstanceSpecification3EditPart.VISUAL_ID == visualID || DataType3EditPart.VISUAL_ID == visualID || PrimitiveType3EditPart.VISUAL_ID == visualID
				|| Interface4EditPart.VISUAL_ID == visualID || Interface5EditPart.VISUAL_ID == visualID || LiteralStringEditPart.VISUAL_ID == visualID || LiteralIntegerEditPart.VISUAL_ID == visualID
				|| ExpressionEditPart.VISUAL_ID == visualID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateEdgeViewOperation op) {
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		if (!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
			return false; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
			return false; // our hint is visual id and must be specified, and it should be the same as in element type
		}
		int visualID = UMLVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		if (domainElement != null && visualID != UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
			return false; // visual id for link EClass should match visual id from element type
		}
		return true;
	}

	/**
	 * @generated
	 */
	public Diagram createDiagramGen(IAdaptable semanticAdapter, String diagramKind, PreferencesHint preferencesHint) {
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		diagram.getStyles().add(NotationFactory.eINSTANCE.createDiagramStyle());
		U2TDiagramCanonicalStyle canonicalStyle_Package_1000 = U2TNotationFactory.eINSTANCE.createU2TDiagramCanonicalStyle();
		canonicalStyle_Package_1000.setCanonical(true);
		canonicalStyle_Package_1000.setSyncNodes(true);
		canonicalStyle_Package_1000.setSyncLinks(true);
		diagram.getStyles().add(canonicalStyle_Package_1000);
		diagram.setType(PackageEditPart.MODEL_ID);
		diagram.setElement(getSemanticElement(semanticAdapter));
		diagram.setMeasurementUnit(MeasurementUnit.PIXEL_LITERAL);
		return diagram;
	}

	/**
	 * @generated NOT
	 */
	public Diagram createDiagram(IAdaptable semanticAdapter, String diagramKind, PreferencesHint preferencesHint) {
		Diagram diagram = createDiagramGen(semanticAdapter, diagramKind, preferencesHint);
		diagram.getStyles().add(NotationFactory.eINSTANCE.createFilteringStyle()); //[171240]
		return diagram;
	}

	/**
	 * @generated
	 */
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		final EObject domainElement = getSemanticElement(semanticAdapter);
		final int visualID;
		if (semanticHint == null) {
			visualID = UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(semanticHint);
		}
		switch (visualID) {
		case Package2EditPart.VISUAL_ID:
			return createPackage_2002(domainElement, containerView, index, persisted, preferencesHint);
		case Class2EditPart.VISUAL_ID:
			return createClass_2001(domainElement, containerView, index, persisted, preferencesHint);
		case AssociationClass2EditPart.VISUAL_ID:
			return createAssociationClass_2007(domainElement, containerView, index, persisted, preferencesHint);
		case DataType2EditPart.VISUAL_ID:
			return createDataType_2004(domainElement, containerView, index, persisted, preferencesHint);
		case PrimitiveType2EditPart.VISUAL_ID:
			return createPrimitiveType_2005(domainElement, containerView, index, persisted, preferencesHint);
		case Enumeration2EditPart.VISUAL_ID:
			return createEnumeration_2003(domainElement, containerView, index, persisted, preferencesHint);
		case InterfaceEditPart.VISUAL_ID:
			return createInterface_2010(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPart.VISUAL_ID:
			return createConstraint_2006(domainElement, containerView, index, persisted, preferencesHint);
		case InstanceSpecification2EditPart.VISUAL_ID:
			return createInstanceSpecification_2008(domainElement, containerView, index, persisted, preferencesHint);
		case DependencyEditPart.VISUAL_ID:
			return createDependency_2009(domainElement, containerView, index, persisted, preferencesHint);
		case GeneralizationSetEditPart.VISUAL_ID:
			return createGeneralizationSet_2012(domainElement, containerView, index, persisted, preferencesHint);
		case Interface2EditPart.VISUAL_ID:
			return createInterface_2013(domainElement, containerView, index, persisted, preferencesHint);
		case Package4EditPart.VISUAL_ID:
			return createPackage_2014(domainElement, containerView, index, persisted, preferencesHint);
		case AssociationClassRhombEditPart.VISUAL_ID:
			return createAssociationClass_2015(domainElement, containerView, index, persisted, preferencesHint);
		case PackageAsFrameEditPart.VISUAL_ID:
			return createPackage_2016(domainElement, containerView, index, persisted, preferencesHint);
		case InstanceSpecification4EditPart.VISUAL_ID:
			return createInstanceSpecification_2017(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPart.VISUAL_ID:
			return createComment_2018(domainElement, containerView, index, persisted, preferencesHint);
		case Package3EditPart.VISUAL_ID:
			return createPackage_3006(domainElement, containerView, index, persisted, preferencesHint);
		case ClassEditPart.VISUAL_ID:
			return createClass_3007(domainElement, containerView, index, persisted, preferencesHint);
		case DataTypeEditPart.VISUAL_ID:
			return createDataType_3008(domainElement, containerView, index, persisted, preferencesHint);
		case PrimitiveTypeEditPart.VISUAL_ID:
			return createPrimitiveType_3009(domainElement, containerView, index, persisted, preferencesHint);
		case EnumerationEditPart.VISUAL_ID:
			return createEnumeration_3011(domainElement, containerView, index, persisted, preferencesHint);
		case AssociationClassEditPart.VISUAL_ID:
			return createAssociationClass_3012(domainElement, containerView, index, persisted, preferencesHint);
		case Interface3EditPart.VISUAL_ID:
			return createInterface_3041(domainElement, containerView, index, persisted, preferencesHint);
		case InstanceSpecificationEditPart.VISUAL_ID:
			return createInstanceSpecification_3013(domainElement, containerView, index, persisted, preferencesHint);
		case PropertyEditPart.VISUAL_ID:
			return createProperty_3001(domainElement, containerView, index, persisted, preferencesHint);
		case OperationEditPart.VISUAL_ID:
			return createOperation_3002(domainElement, containerView, index, persisted, preferencesHint);
		case Class3EditPart.VISUAL_ID:
			return createClass_3003(domainElement, containerView, index, persisted, preferencesHint);
		case PortEditPart.VISUAL_ID:
			return createPort_3025(domainElement, containerView, index, persisted, preferencesHint);
		case RedefinableTemplateSignatureEditPart.VISUAL_ID:
			return createRedefinableTemplateSignature_3027(domainElement, containerView, index, persisted, preferencesHint);
		case Property2EditPart.VISUAL_ID:
			return createProperty_3019(domainElement, containerView, index, persisted, preferencesHint);
		case Operation2EditPart.VISUAL_ID:
			return createOperation_3020(domainElement, containerView, index, persisted, preferencesHint);
		case Property3EditPart.VISUAL_ID:
			return createProperty_3014(domainElement, containerView, index, persisted, preferencesHint);
		case Operation3EditPart.VISUAL_ID:
			return createOperation_3015(domainElement, containerView, index, persisted, preferencesHint);
		case Property4EditPart.VISUAL_ID:
			return createProperty_3021(domainElement, containerView, index, persisted, preferencesHint);
		case Operation4EditPart.VISUAL_ID:
			return createOperation_3022(domainElement, containerView, index, persisted, preferencesHint);
		case EnumerationLiteralEditPart.VISUAL_ID:
			return createEnumerationLiteral_3016(domainElement, containerView, index, persisted, preferencesHint);
		case Property5EditPart.VISUAL_ID:
			return createProperty_3023(domainElement, containerView, index, persisted, preferencesHint);
		case Operation5EditPart.VISUAL_ID:
			return createOperation_3024(domainElement, containerView, index, persisted, preferencesHint);
		case SlotEditPart.VISUAL_ID:
			return createSlot_3017(domainElement, containerView, index, persisted, preferencesHint);
		case Property6EditPart.VISUAL_ID:
			return createProperty_3028(domainElement, containerView, index, persisted, preferencesHint);
		case Operation6EditPart.VISUAL_ID:
			return createOperation_3029(domainElement, containerView, index, persisted, preferencesHint);
		case Class4EditPart.VISUAL_ID:
			return createClass_3030(domainElement, containerView, index, persisted, preferencesHint);
		case ElementImportEditPart.VISUAL_ID:
			return createElementImport_3031(domainElement, containerView, index, persisted, preferencesHint);
		case Package6EditPart.VISUAL_ID:
			return createPackage_3032(domainElement, containerView, index, persisted, preferencesHint);
		case Class5EditPart.VISUAL_ID:
			return createClass_3033(domainElement, containerView, index, persisted, preferencesHint);
		case Enumeration3EditPart.VISUAL_ID:
			return createEnumeration_3034(domainElement, containerView, index, persisted, preferencesHint);
		case InstanceSpecification3EditPart.VISUAL_ID:
			return createInstanceSpecification_3035(domainElement, containerView, index, persisted, preferencesHint);
		case DataType3EditPart.VISUAL_ID:
			return createDataType_3036(domainElement, containerView, index, persisted, preferencesHint);
		case PrimitiveType3EditPart.VISUAL_ID:
			return createPrimitiveType_3037(domainElement, containerView, index, persisted, preferencesHint);
		case Interface4EditPart.VISUAL_ID:
			return createInterface_3042(domainElement, containerView, index, persisted, preferencesHint);
		case Interface5EditPart.VISUAL_ID:
			return createInterface_3043(domainElement, containerView, index, persisted, preferencesHint);
		case LiteralStringEditPart.VISUAL_ID:
			return createLiteralString_3038(domainElement, containerView, index, persisted, preferencesHint);
		case LiteralIntegerEditPart.VISUAL_ID:
			return createLiteralInteger_3039(domainElement, containerView, index, persisted, preferencesHint);
		case ExpressionEditPart.VISUAL_ID:
			return createExpression_3040(domainElement, containerView, index, persisted, preferencesHint);
		}
		// can't happen, provided #provides(CreateNodeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		switch (UMLVisualIDRegistry.getVisualID(elementTypeHint)) {
		case GeneralizationEditPart.VISUAL_ID:
			return createGeneralization_4001(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case Dependency2EditPart.VISUAL_ID:
			return createDependency_4002(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case Property7EditPart.VISUAL_ID:
			return createProperty_4003(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return createConstraintConstrainedElement_4004(containerView, index, persisted, preferencesHint);
		case AssociationEditPart.VISUAL_ID:
			return createAssociation_4005(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case DependencySupplierEditPart.VISUAL_ID:
			return createDependencySupplier_4006(containerView, index, persisted, preferencesHint);
		case DependencyClientEditPart.VISUAL_ID:
			return createDependencyClient_4007(containerView, index, persisted, preferencesHint);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return createInterfaceRealization_4008(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case RealizationEditPart.VISUAL_ID:
			return createRealization_4010(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case Generalization2EditPart.VISUAL_ID:
			return createGeneralization_4011(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case GeneralizationGeneralEditPart.VISUAL_ID:
			return createGeneralizationGeneral_4012(containerView, index, persisted, preferencesHint);
		case UsageEditPart.VISUAL_ID:
			return createUsage_4013(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case AssociationClassConnectorEditPart.VISUAL_ID:
			return createAssociationClass_4014(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case AssociationInstanceEditPart.VISUAL_ID:
			return createSlot_4015(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case TemplateBindingEditPart.VISUAL_ID:
			return createTemplateBinding_4016(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case PortProvidedEditPart.VISUAL_ID:
			return createPortProvided_4017(containerView, index, persisted, preferencesHint);
		case PortRequiredEditPart.VISUAL_ID:
			return createPortRequired_4018(containerView, index, persisted, preferencesHint);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return createCommentAnnotatedElement_4019(containerView, index, persisted, preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createPackage_2002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Package2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5004 = createLabel(node, UMLVisualIDRegistry.getType(PackageNameEditPart.VISUAL_ID));

		Node compartment7010 = createCompartment(node, UMLVisualIDRegistry.getType(PackagePackagesEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_PackagePackages_7010 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_PackagePackages_7010.setCanonical(true);
		compartment7010.getStyles().add(canonicalStyle_PackagePackages_7010);
		UMLDetailLevelService.getLevel(compartment7010).init(compartment7010); // [171240]

		Node compartment7011 = createCompartment(node, UMLVisualIDRegistry.getType(PackageClassifiersEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_PackageClassifiers_7011 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_PackageClassifiers_7011.setCanonical(true);
		compartment7011.getStyles().add(canonicalStyle_PackageClassifiers_7011);
		UMLDetailLevelService.getLevel(compartment7011).init(compartment7011); // [171240]

		Node compartment7012 = createCompartment(node, UMLVisualIDRegistry.getType(PackageOtherEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_PackageOther_7012 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_PackageOther_7012.setCanonical(true);
		compartment7012.getStyles().add(canonicalStyle_PackageOther_7012);
		UMLDetailLevelService.getLevel(compartment7012).init(compartment7012); // [171240]
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_2001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		CanonicalStyle canonicalStyle_Class_2001 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_Class_2001.setCanonical(true);
		node.getStyles().add(canonicalStyle_Class_2001);
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Class2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5003 = createLabel(node, UMLVisualIDRegistry.getType(ClassNameEditPart.VISUAL_ID));
		Node label5019 = createLabel(node, UMLVisualIDRegistry.getType(ClassStereotypeEditPart.VISUAL_ID));

		Node compartment7001 = createCompartment(node, UMLVisualIDRegistry.getType(ClassAttributesEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_ClassAttributes_7001 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_ClassAttributes_7001.setCanonical(true);
		compartment7001.getStyles().add(canonicalStyle_ClassAttributes_7001);
		UMLDetailLevelService.getLevel(compartment7001).init(compartment7001); // [171240]

		Node compartment7002 = createCompartment(node, UMLVisualIDRegistry.getType(ClassOperationsEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_ClassOperations_7002 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_ClassOperations_7002.setCanonical(true);
		compartment7002.getStyles().add(canonicalStyle_ClassOperations_7002);
		UMLDetailLevelService.getLevel(compartment7002).init(compartment7002); // [171240]

		Node compartment7003 = createCompartment(node, UMLVisualIDRegistry.getType(ClassClassesEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_ClassClasses_7003 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_ClassClasses_7003.setCanonical(true);
		compartment7003.getStyles().add(canonicalStyle_ClassClasses_7003);
		UMLDetailLevelService.getLevel(compartment7003).init(compartment7003); // [171240]
		return node;
	}

	/**
	 * @generated
	 */
	public Node createAssociationClass_2007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		CanonicalStyle canonicalStyle_AssociationClass_2007 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_AssociationClass_2007.setCanonical(true);
		node.getStyles().add(canonicalStyle_AssociationClass_2007);
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(AssociationClass2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5009 = createLabel(node, UMLVisualIDRegistry.getType(AssociationClassNameEditPart.VISUAL_ID));
		Node label5031 = createLabel(node, UMLVisualIDRegistry.getType(AssociationClassStereotypeEditPart.VISUAL_ID));

		Node compartment7024 = createCompartment(node, UMLVisualIDRegistry.getType(AssociationClassAttributesEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_AssociationClassAttributes_7024 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_AssociationClassAttributes_7024.setCanonical(true);
		compartment7024.getStyles().add(canonicalStyle_AssociationClassAttributes_7024);
		UMLDetailLevelService.getLevel(compartment7024).init(compartment7024); // [171240]

		Node compartment7025 = createCompartment(node, UMLVisualIDRegistry.getType(AssociationClassOperationsEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_AssociationClassOperations_7025 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_AssociationClassOperations_7025.setCanonical(true);
		compartment7025.getStyles().add(canonicalStyle_AssociationClassOperations_7025);
		UMLDetailLevelService.getLevel(compartment7025).init(compartment7025); // [171240]

		Node compartment7026 = createCompartment(node, UMLVisualIDRegistry.getType(AssociationClassClassesEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_AssociationClassClasses_7026 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_AssociationClassClasses_7026.setCanonical(true);
		compartment7026.getStyles().add(canonicalStyle_AssociationClassClasses_7026);
		UMLDetailLevelService.getLevel(compartment7026).init(compartment7026); // [171240]
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDataType_2004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		CanonicalStyle canonicalStyle_DataType_2004 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_DataType_2004.setCanonical(true);
		node.getStyles().add(canonicalStyle_DataType_2004);
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DataType2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5006 = createLabel(node, UMLVisualIDRegistry.getType(DataTypeNameEditPart.VISUAL_ID));
		Node label5032 = createLabel(node, UMLVisualIDRegistry.getType(DataTypeStereotypeEditPart.VISUAL_ID));

		Node compartment7017 = createCompartment(node, UMLVisualIDRegistry.getType(DataTypeAttributesEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_DataTypeAttributes_7017 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_DataTypeAttributes_7017.setCanonical(true);
		compartment7017.getStyles().add(canonicalStyle_DataTypeAttributes_7017);
		UMLDetailLevelService.getLevel(compartment7017).init(compartment7017); // [171240]

		Node compartment7018 = createCompartment(node, UMLVisualIDRegistry.getType(DataTypeOperationsEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_DataTypeOperations_7018 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_DataTypeOperations_7018.setCanonical(true);
		compartment7018.getStyles().add(canonicalStyle_DataTypeOperations_7018);
		UMLDetailLevelService.getLevel(compartment7018).init(compartment7018); // [171240]
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPrimitiveType_2005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		CanonicalStyle canonicalStyle_PrimitiveType_2005 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_PrimitiveType_2005.setCanonical(true);
		node.getStyles().add(canonicalStyle_PrimitiveType_2005);
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PrimitiveType2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5007 = createLabel(node, UMLVisualIDRegistry.getType(PrimitiveTypeNameEditPart.VISUAL_ID));
		Node label5033 = createLabel(node, UMLVisualIDRegistry.getType(PrimitiveTypeStereotypeEditPart.VISUAL_ID));

		Node compartment7020 = createCompartment(node, UMLVisualIDRegistry.getType(PrimitiveTypeAttributesEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_PrimitiveTypeAttributes_7020 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_PrimitiveTypeAttributes_7020.setCanonical(true);
		compartment7020.getStyles().add(canonicalStyle_PrimitiveTypeAttributes_7020);
		UMLDetailLevelService.getLevel(compartment7020).init(compartment7020); // [171240]

		Node compartment7021 = createCompartment(node, UMLVisualIDRegistry.getType(PrimitiveTypeOperationsEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_PrimitiveTypeOperations_7021 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_PrimitiveTypeOperations_7021.setCanonical(true);
		compartment7021.getStyles().add(canonicalStyle_PrimitiveTypeOperations_7021);
		UMLDetailLevelService.getLevel(compartment7021).init(compartment7021); // [171240]
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumeration_2003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		CanonicalStyle canonicalStyle_Enumeration_2003 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_Enumeration_2003.setCanonical(true);
		node.getStyles().add(canonicalStyle_Enumeration_2003);
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Enumeration2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5005 = createLabel(node, UMLVisualIDRegistry.getType(EnumerationNameEditPart.VISUAL_ID));
		Node label5034 = createLabel(node, UMLVisualIDRegistry.getType(EnumerationStereotypeEditPart.VISUAL_ID));

		Node compartment7013 = createCompartment(node, UMLVisualIDRegistry.getType(EnumerationLiteralsEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_EnumerationLiterals_7013 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_EnumerationLiterals_7013.setCanonical(true);
		compartment7013.getStyles().add(canonicalStyle_EnumerationLiterals_7013);
		UMLDetailLevelService.getLevel(compartment7013).init(compartment7013); // [171240]

		Node compartment7014 = createCompartment(node, UMLVisualIDRegistry.getType(EnumerationAttributesEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_EnumerationAttributes_7014 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_EnumerationAttributes_7014.setCanonical(true);
		compartment7014.getStyles().add(canonicalStyle_EnumerationAttributes_7014);
		UMLDetailLevelService.getLevel(compartment7014).init(compartment7014); // [171240]

		Node compartment7015 = createCompartment(node, UMLVisualIDRegistry.getType(EnumerationOperationsEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_EnumerationOperations_7015 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_EnumerationOperations_7015.setCanonical(true);
		compartment7015.getStyles().add(canonicalStyle_EnumerationOperations_7015);
		UMLDetailLevelService.getLevel(compartment7015).init(compartment7015); // [171240]
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_2010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5012 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceNameEditPart.VISUAL_ID));
		label5012.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5012 = (Location) label5012.getLayoutConstraint();
		location5012.setX(0);
		location5012.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_2006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5008 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameEditPart.VISUAL_ID));
		Node label5042 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintLanguageEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInstanceSpecification_2008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InstanceSpecification2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5010 = createLabel(node, UMLVisualIDRegistry.getType(InstanceSpecificationNameEditPart.VISUAL_ID));
		Node label5039 = createLabel(node, UMLVisualIDRegistry.getType(InstanceSpecificationStereoEditPart.VISUAL_ID));

		Node compartment7028 = createCompartment(node, UMLVisualIDRegistry.getType(InstanceSpecificationSlotsEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_InstanceSpecificationSlots_7028 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_InstanceSpecificationSlots_7028.setCanonical(true);
		compartment7028.getStyles().add(canonicalStyle_InstanceSpecificationSlots_7028);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDependency_2009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createLineStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Node label5011 = createLabel(node, UMLVisualIDRegistry.getType(DependencyNameEditPart.VISUAL_ID));
		label5011.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5011 = (Location) label5011.getLayoutConstraint();
		location5011.setX(0);
		location5011.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createGeneralizationSet_2012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(GeneralizationSetEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5016 = createLabel(node, UMLVisualIDRegistry.getType(GeneralizationSetIsCoveringIsDisjointEditPart.VISUAL_ID));
		label5016.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5016 = (Location) label5016.getLayoutConstraint();
		location5016.setX(0);
		location5016.setY(5);
		Node label5017 = createLabel(node, UMLVisualIDRegistry.getType(GeneralizationSetNameEditPart.VISUAL_ID));
		label5017.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5017 = (Location) label5017.getLayoutConstraint();
		location5017.setX(0);
		location5017.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_2013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Interface2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5018 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceName2EditPart.VISUAL_ID));
		Node label5035 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceStereotypeEditPart.VISUAL_ID));

		Node compartment7029 = createCompartment(node, UMLVisualIDRegistry.getType(InterfaceAttributesEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_InterfaceAttributes_7029 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_InterfaceAttributes_7029.setCanonical(true);
		compartment7029.getStyles().add(canonicalStyle_InterfaceAttributes_7029);
		UMLDetailLevelService.getLevel(compartment7029).init(compartment7029); // [171240]

		Node compartment7030 = createCompartment(node, UMLVisualIDRegistry.getType(InterfaceOperationsEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_InterfaceOperations_7030 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_InterfaceOperations_7030.setCanonical(true);
		compartment7030.getStyles().add(canonicalStyle_InterfaceOperations_7030);
		UMLDetailLevelService.getLevel(compartment7030).init(compartment7030); // [171240]

		Node compartment7031 = createCompartment(node, UMLVisualIDRegistry.getType(InterfaceClassesEditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_InterfaceClasses_7031 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_InterfaceClasses_7031.setCanonical(true);
		compartment7031.getStyles().add(canonicalStyle_InterfaceClasses_7031);
		UMLDetailLevelService.getLevel(compartment7031).init(compartment7031); // [171240]
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_2014(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Package4EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5020 = createLabel(node, UMLVisualIDRegistry.getType(PackageName2EditPart.VISUAL_ID));
		Node label5041 = createLabel(node, UMLVisualIDRegistry.getType(PackageStereo2EditPart.VISUAL_ID));

		Node compartment7032 = createCompartment(node, UMLVisualIDRegistry.getType(PackageImportsEditPart.VISUAL_ID), true, false, true, true);
		CanonicalStyle canonicalStyle_PackageImports_7032 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_PackageImports_7032.setCanonical(true);
		compartment7032.getStyles().add(canonicalStyle_PackageImports_7032);
		DrawerStyle drawerStyle = (DrawerStyle) compartment7032.getStyle(NotationPackage.eINSTANCE.getDrawerStyle());
		if (drawerStyle != null) {
			//#216573 [SecondaryDiagramElement] Collapse imports compartment after creation
			drawerStyle.setCollapsed(true);
		}
		return node;
	}

	/**
	 * @generated
	 */
	public Node createAssociationClass_2015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(AssociationClassRhombEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_2016(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PackageAsFrameEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5026 = createLabel(node, UMLVisualIDRegistry.getType(PackageName3EditPart.VISUAL_ID));

		Node compartment7033 = createCompartment(node, UMLVisualIDRegistry.getType(PackageAsFrameContentsEditPart.VISUAL_ID), true, false, false, false);
		CanonicalStyle canonicalStyle_PackageFramecontents_7033 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_PackageFramecontents_7033.setCanonical(true);
		compartment7033.getStyles().add(canonicalStyle_PackageFramecontents_7033);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInstanceSpecification_2017(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		CanonicalStyle canonicalStyle_InstanceSpecification_2017 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_InstanceSpecification_2017.setCanonical(true);
		node.getStyles().add(canonicalStyle_InstanceSpecification_2017);
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InstanceSpecification4EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5029 = createLabel(node, UMLVisualIDRegistry.getType(InstanceSpecificationName3EditPart.VISUAL_ID));

		Node compartment7046 = createCompartment(node, UMLVisualIDRegistry.getType(InstanceSpecificationValueEditPart.VISUAL_ID), false, false, true, true);
		CanonicalStyle canonicalStyle_InstanceSpecificationValue_7046 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_InstanceSpecificationValue_7046.setCanonical(true);
		compartment7046.getStyles().add(canonicalStyle_InstanceSpecificationValue_7046);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_2018Gen(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5030 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated NOT
	 */
	public Node createComment_2018(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = createComment_2018Gen(domainElement, containerView, index, persisted, preferencesHint);
		ViewProviderUtils.initializeCommentColor(node, preferencesHint);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_3006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Package3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_3007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ClassEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDataType_3008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(DataTypeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPrimitiveType_3009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(PrimitiveTypeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumeration_3011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(EnumerationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createAssociationClass_3012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(AssociationClassEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_3041(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Interface3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInstanceSpecification_3013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(InstanceSpecificationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(PropertyEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(OperationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_3003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Class3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPort_3025(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		node.getStyles().add(NotationFactory.eINSTANCE.createFillStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5013 = createLabel(node, UMLVisualIDRegistry.getType(PortNameEditPart.VISUAL_ID));
		label5013.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5013 = (Location) label5013.getLayoutConstraint();
		location5013.setX(0);
		location5013.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createRedefinableTemplateSignature_3027(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(RedefinableTemplateSignatureEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5015 = createLabel(node, UMLVisualIDRegistry.getType(TemplateSignatureNode_signatureEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3019(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Property2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3020(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Operation2EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3014(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Property3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Operation3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3021(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Property4EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3022(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Operation4EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumerationLiteral_3016(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(EnumerationLiteralEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3023(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Property5EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3024(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Operation5EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSlot_3017(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(SlotEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3028(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Property6EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3029(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Operation6EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_3030(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(Class4EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createElementImport_3031(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ElementImportEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPackage_3032(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.getStyles().add(NotationFactory.eINSTANCE.createHintedDiagramLinkStyle());
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Package6EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5025 = createLabel(node, UMLVisualIDRegistry.getType(PackageName4EditPart.VISUAL_ID));

		Node compartment7034 = createCompartment(node, UMLVisualIDRegistry.getType(PackageAsFrameContents2EditPart.VISUAL_ID), true, false, false, false);
		CanonicalStyle canonicalStyle_PackageFramecontents_7034 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_PackageFramecontents_7034.setCanonical(true);
		compartment7034.getStyles().add(canonicalStyle_PackageFramecontents_7034);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_3033(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		CanonicalStyle canonicalStyle_Class_3033 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_Class_3033.setCanonical(true);
		node.getStyles().add(canonicalStyle_Class_3033);
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Class5EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5021 = createLabel(node, UMLVisualIDRegistry.getType(ClassName2EditPart.VISUAL_ID));
		Node label5022 = createLabel(node, UMLVisualIDRegistry.getType(ClassStereotype2EditPart.VISUAL_ID));

		Node compartment7035 = createCompartment(node, UMLVisualIDRegistry.getType(ClassAttributes2EditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_ClassAttributes_7035 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_ClassAttributes_7035.setCanonical(true);
		compartment7035.getStyles().add(canonicalStyle_ClassAttributes_7035);

		Node compartment7036 = createCompartment(node, UMLVisualIDRegistry.getType(ClassOperations2EditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_ClassOperations_7036 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_ClassOperations_7036.setCanonical(true);
		compartment7036.getStyles().add(canonicalStyle_ClassOperations_7036);

		Node compartment7037 = createCompartment(node, UMLVisualIDRegistry.getType(ClassClasses2EditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_ClassClasses_7037 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_ClassClasses_7037.setCanonical(true);
		compartment7037.getStyles().add(canonicalStyle_ClassClasses_7037);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumeration_3034(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		CanonicalStyle canonicalStyle_Enumeration_3034 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_Enumeration_3034.setCanonical(true);
		node.getStyles().add(canonicalStyle_Enumeration_3034);
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Enumeration3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5023 = createLabel(node, UMLVisualIDRegistry.getType(EnumerationName2EditPart.VISUAL_ID));
		Node label5036 = createLabel(node, UMLVisualIDRegistry.getType(EnumerationStereotype2EditPart.VISUAL_ID));

		Node compartment7038 = createCompartment(node, UMLVisualIDRegistry.getType(EnumerationLiterals2EditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_EnumerationLiterals_7038 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_EnumerationLiterals_7038.setCanonical(true);
		compartment7038.getStyles().add(canonicalStyle_EnumerationLiterals_7038);

		Node compartment7039 = createCompartment(node, UMLVisualIDRegistry.getType(EnumerationAttributes2EditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_EnumerationAttributes_7039 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_EnumerationAttributes_7039.setCanonical(true);
		compartment7039.getStyles().add(canonicalStyle_EnumerationAttributes_7039);

		Node compartment7040 = createCompartment(node, UMLVisualIDRegistry.getType(EnumerationOperations2EditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_EnumerationOperations_7040 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_EnumerationOperations_7040.setCanonical(true);
		compartment7040.getStyles().add(canonicalStyle_EnumerationOperations_7040);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInstanceSpecification_3035(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InstanceSpecification3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5024 = createLabel(node, UMLVisualIDRegistry.getType(InstanceSpecificationName2EditPart.VISUAL_ID));
		Node label5040 = createLabel(node, UMLVisualIDRegistry.getType(InstanceSpecificationStereo2EditPart.VISUAL_ID));

		Node compartment7041 = createCompartment(node, UMLVisualIDRegistry.getType(InstanceSpecificationSlots2EditPart.VISUAL_ID), false, true, true, true);
		CanonicalStyle canonicalStyle_InstanceSpecificationSlots_7041 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_InstanceSpecificationSlots_7041.setCanonical(true);
		compartment7041.getStyles().add(canonicalStyle_InstanceSpecificationSlots_7041);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDataType_3036(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		CanonicalStyle canonicalStyle_DataType_3036 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_DataType_3036.setCanonical(true);
		node.getStyles().add(canonicalStyle_DataType_3036);
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DataType3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5027 = createLabel(node, UMLVisualIDRegistry.getType(DataTypeName2EditPart.VISUAL_ID));
		Node label5037 = createLabel(node, UMLVisualIDRegistry.getType(DataTypeStereotype2EditPart.VISUAL_ID));

		Node compartment7042 = createCompartment(node, UMLVisualIDRegistry.getType(DataTypeAttributes2EditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_DataTypeAttributes_7042 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_DataTypeAttributes_7042.setCanonical(true);
		compartment7042.getStyles().add(canonicalStyle_DataTypeAttributes_7042);

		Node compartment7043 = createCompartment(node, UMLVisualIDRegistry.getType(DataTypeOperations2EditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_DataTypeOperations_7043 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_DataTypeOperations_7043.setCanonical(true);
		compartment7043.getStyles().add(canonicalStyle_DataTypeOperations_7043);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPrimitiveType_3037(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		CanonicalStyle canonicalStyle_PrimitiveType_3037 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_PrimitiveType_3037.setCanonical(true);
		node.getStyles().add(canonicalStyle_PrimitiveType_3037);
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PrimitiveType3EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5028 = createLabel(node, UMLVisualIDRegistry.getType(PrimitiveTypeName2EditPart.VISUAL_ID));
		Node label5038 = createLabel(node, UMLVisualIDRegistry.getType(PrimitiveTypeStereotype2EditPart.VISUAL_ID));

		Node compartment7044 = createCompartment(node, UMLVisualIDRegistry.getType(PrimitiveTypeAttributes2EditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_PrimitiveTypeAttributes_7044 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_PrimitiveTypeAttributes_7044.setCanonical(true);
		compartment7044.getStyles().add(canonicalStyle_PrimitiveTypeAttributes_7044);

		Node compartment7045 = createCompartment(node, UMLVisualIDRegistry.getType(PrimitiveTypeOperations2EditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_PrimitiveTypeOperations_7045 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_PrimitiveTypeOperations_7045.setCanonical(true);
		compartment7045.getStyles().add(canonicalStyle_PrimitiveTypeOperations_7045);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_3042(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Interface4EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5043 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceName3EditPart.VISUAL_ID));
		Node label5044 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceStereotype2EditPart.VISUAL_ID));

		Node compartment7047 = createCompartment(node, UMLVisualIDRegistry.getType(InterfaceAttributes2EditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_InterfaceAttributes_7047 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_InterfaceAttributes_7047.setCanonical(true);
		compartment7047.getStyles().add(canonicalStyle_InterfaceAttributes_7047);

		Node compartment7048 = createCompartment(node, UMLVisualIDRegistry.getType(InterfaceOperations2EditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_InterfaceOperations_7048 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_InterfaceOperations_7048.setCanonical(true);
		compartment7048.getStyles().add(canonicalStyle_InterfaceOperations_7048);

		Node compartment7049 = createCompartment(node, UMLVisualIDRegistry.getType(InterfaceClasses2EditPart.VISUAL_ID), true, true, true, true);
		CanonicalStyle canonicalStyle_InterfaceClasses_7049 = NotationFactory.eINSTANCE.createCanonicalStyle();
		canonicalStyle_InterfaceClasses_7049.setCanonical(true);
		compartment7049.getStyles().add(canonicalStyle_InterfaceClasses_7049);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_3043(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(Interface5EditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle nodeFontStyle = (FontStyle) node.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (nodeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			nodeFontStyle.setFontName(fontData.getName());
			nodeFontStyle.setFontHeight(fontData.getHeight());
			nodeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			nodeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			nodeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FILL_COLOR);
		ViewUtil.setStructuralFeatureValue(node, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		Node label5045 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceName4EditPart.VISUAL_ID));
		label5045.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5045 = (Location) label5045.getLayoutConstraint();
		location5045.setX(0);
		location5045.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createLiteralString_3038(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(LiteralStringEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createLiteralInteger_3039(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(LiteralIntegerEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createExpression_3040(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createNode();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(ExpressionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralization_4001(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6018 = createLabel(edge, UMLVisualIDRegistry.getType(GeneralizationStereotypeEditPart.VISUAL_ID));
		label6018.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6018 = (Location) label6018.getLayoutConstraint();
		location6018.setX(0);
		location6018.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependency_4002(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(Dependency2EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6001 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyName2EditPart.VISUAL_ID));
		label6001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6001 = (Location) label6001.getLayoutConstraint();
		location6001.setX(0);
		location6001.setY(40);
		Node label6010 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyName3EditPart.VISUAL_ID));
		label6010.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6010 = (Location) label6010.getLayoutConstraint();
		location6010.setX(0);
		location6010.setY(20);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createProperty_4003(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(Property7EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6002 = createLabel(edge, UMLVisualIDRegistry.getType(PropertyNameEditPart.VISUAL_ID));
		label6002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6002 = (Location) label6002.getLayoutConstraint();
		location6002.setX(0);
		location6002.setY(-15);
		Node label6012 = createLabel(edge, UMLVisualIDRegistry.getType(PropertyName2EditPart.VISUAL_ID));
		label6012.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6012 = (Location) label6012.getLayoutConstraint();
		location6012.setX(0);
		location6012.setY(15);
		Node label6017 = createLabel(edge, UMLVisualIDRegistry.getType(PropertyName3EditPart.VISUAL_ID));
		label6017.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6017 = (Location) label6017.getLayoutConstraint();
		location6017.setX(0);
		location6017.setY(-30);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createConstraintConstrainedElement_4004(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAssociation_4005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(AssociationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6003 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationNameEditPart.VISUAL_ID));
		label6003.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6003 = (Location) label6003.getLayoutConstraint();
		location6003.setX(0);
		location6003.setY(20);
		Node label6004 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationName2EditPart.VISUAL_ID));
		label6004.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6004 = (Location) label6004.getLayoutConstraint();
		location6004.setX(0);
		location6004.setY(-15);
		Node label6005 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationName3EditPart.VISUAL_ID));
		label6005.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6005 = (Location) label6005.getLayoutConstraint();
		location6005.setX(0);
		location6005.setY(-15);
		Node label6006 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationName4EditPart.VISUAL_ID));
		label6006.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6006 = (Location) label6006.getLayoutConstraint();
		location6006.setX(0);
		location6006.setY(-30);
		Node label6007 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationName5EditPart.VISUAL_ID));
		label6007.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6007 = (Location) label6007.getLayoutConstraint();
		location6007.setX(0);
		location6007.setY(-30);
		Node label6008 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationName6EditPart.VISUAL_ID));
		label6008.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6008 = (Location) label6008.getLayoutConstraint();
		location6008.setX(0);
		location6008.setY(15);
		Node label6009 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationName7EditPart.VISUAL_ID));
		label6009.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6009 = (Location) label6009.getLayoutConstraint();
		location6009.setX(0);
		location6009.setY(15);
		Node label6019 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationStereotypeEditPart.VISUAL_ID));
		label6019.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6019 = (Location) label6019.getLayoutConstraint();
		location6019.setX(0);
		location6019.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependencySupplier_4006(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DependencySupplierEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependencyClient_4007(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DependencyClientEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createInterfaceRealization_4008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6020 = createLabel(edge, UMLVisualIDRegistry.getType(InterfaceRealizationStereotypeEditPart.VISUAL_ID));
		label6020.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6020 = (Location) label6020.getLayoutConstraint();
		location6020.setX(0);
		location6020.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createRealization_4010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6011 = createLabel(edge, UMLVisualIDRegistry.getType(RealizationNameEditPart.VISUAL_ID));
		label6011.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6011 = (Location) label6011.getLayoutConstraint();
		location6011.setX(0);
		location6011.setY(40);
		Node label6021 = createLabel(edge, UMLVisualIDRegistry.getType(RealizationStereotypeEditPart.VISUAL_ID));
		label6021.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6021 = (Location) label6021.getLayoutConstraint();
		location6021.setX(0);
		location6021.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralization_4011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(Generalization2EditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6022 = createLabel(edge, UMLVisualIDRegistry.getType(GeneralizationStereotype2EditPart.VISUAL_ID));
		label6022.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6022 = (Location) label6022.getLayoutConstraint();
		location6022.setX(0);
		location6022.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralizationGeneral_4012(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(GeneralizationGeneralEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createUsage_4013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6023 = createLabel(edge, UMLVisualIDRegistry.getType(UsageStereotypeEditPart.VISUAL_ID));
		label6023.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6023 = (Location) label6023.getLayoutConstraint();
		location6023.setX(0);
		location6023.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAssociationClass_4014(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(AssociationClassConnectorEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createSlot_4015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(AssociationInstanceEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6015 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationInstanceSourceEditPart.VISUAL_ID));
		label6015.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6015 = (Location) label6015.getLayoutConstraint();
		location6015.setX(0);
		location6015.setY(20);
		Node label6016 = createLabel(edge, UMLVisualIDRegistry.getType(AssociationInstanceTargetEditPart.VISUAL_ID));
		label6016.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6016 = (Location) label6016.getLayoutConstraint();
		location6016.setX(0);
		location6016.setY(-15);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createTemplateBinding_4016(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Edge edge = NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(NotationFactory.eINSTANCE.createRoutingStyle());
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(TemplateBindingEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		Node label6013 = createLabel(edge, UMLVisualIDRegistry.getType(TemplateBinding_BindLabelEditPart.VISUAL_ID));
		label6013.getStyles().add(NotationFactory.eINSTANCE.createDescriptionStyle());
		label6013.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6013 = (Location) label6013.getLayoutConstraint();
		location6013.setX(0);
		location6013.setY(40);
		Node label6014 = createLabel(edge, UMLVisualIDRegistry.getType(TemplateParameterSubstitutionEditPart.VISUAL_ID));
		label6014.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6014 = (Location) label6014.getLayoutConstraint();
		location6014.setX(0);
		location6014.setY(60);
		Node label6024 = createLabel(edge, UMLVisualIDRegistry.getType(TemplateBindingStereotypeEditPart.VISUAL_ID));
		label6024.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6024 = (Location) label6024.getLayoutConstraint();
		location6024.setX(0);
		location6024.setY(40);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createPortProvided_4017(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(PortProvidedEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createPortRequired_4018(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(PortRequiredEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createCommentAnnotatedElement_4019(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		ArrayList<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore) preferencesHint.getPreferenceStore();

		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_LINE_COLOR);
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
		FontStyle edgeFontStyle = (FontStyle) edge.getStyle(NotationPackage.Literals.FONT_STYLE);
		if (edgeFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(prefStore, IPreferenceConstants.PREF_DEFAULT_FONT);
			edgeFontStyle.setFontName(fontData.getName());
			edgeFontStyle.setFontHeight(fontData.getHeight());
			edgeFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			edgeFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(prefStore, IPreferenceConstants.PREF_FONT_COLOR);
			edgeFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
		Routing routing = Routing.get(prefStore.getInt(IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		return edge;
	}

	/**
	 * @generated
	 */
	private void stampShortcut(View containerView, Node target) {
		if (!PackageEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", PackageEditPart.MODEL_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}

	/**
	 * @generated
	 */
	private Node createLabel(View owner, String hint) {
		DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * @generated
	 */
	private Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort, boolean canFilter) {
		//SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
		//rv.setShowTitle(showTitle);
		//rv.setCollapsed(isCollapsed);
		Node rv;
		if (canCollapse) {
			rv = NotationFactory.eINSTANCE.createBasicCompartment();
		} else {
			rv = NotationFactory.eINSTANCE.createDecorationNode();
		}
		if (hasTitle) {
			TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
			ts.setShowTitle(true);
			rv.getStyles().add(ts);
		}
		if (canSort) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createSortingStyle());
		}
		if (canFilter) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createFilteringStyle());
		}
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * @generated
	 */
	private EObject getSemanticElement(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			return EMFCoreUtil.resolve(TransactionUtil.getEditingDomain(eObject), eObject);
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}

}
