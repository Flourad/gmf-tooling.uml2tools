package org.eclipse.uml2.diagram.csd.part;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.conventions.AssociationEndConvention;
import org.eclipse.uml2.diagram.common.conventions.ConnectorEndConvention;
import org.eclipse.uml2.diagram.common.genapi.IDiagramUpdater;
import org.eclipse.uml2.diagram.common.links.PortOperationsExt;
import org.eclipse.uml2.diagram.common.links.ProvidedInterfaceLink;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.AssociationInstanceEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Class2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Class3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Class4EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassAttributesEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassClass_contentsEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassClassesEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ClassOperationsEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationContentsEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CollaborationUse2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConnectorEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConstraintConstrainedElementEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ConstraintEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Dependency2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.DependencyEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.ElementImportEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InstanceSpecificationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InstanceSpecificationSlotsEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Interface2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceAttributesEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceClassesEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceOperationsEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.InterfaceRealizationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Operation2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.OperationEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Package2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PackageEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PackageImportsEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Port2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Port3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortProvidedEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PortRequiredEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Property2EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Property3EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.Property4EditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.PropertyEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.SlotEditPart;
import org.eclipse.uml2.diagram.csd.edit.parts.UsageEditPart;
import org.eclipse.uml2.diagram.csd.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * @generated
 */
public class UMLDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> getSemanticChildren(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID: {
			//We have "dummy" TopLevelNode (with vid = org.eclipse.uml2.diagram.csd.edit.parts.Package2EditPart.VISUAL_ID). 
			//The only purpose for this node is to be a container for children (imports, etc)
			//of the "main" diagram figure (that one shown as Canvas).
			//Also we have modified the VisualIDRegistry#getNodeVisualID() to return
			//VID = org.eclipse.uml2.diagram.csd.edit.parts.Package2EditPart.VISUAL_ID, 
			//for the case when top-level view is created for the same semantic element as the canvas view.

			LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> resultAndHeader = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor>();
			resultAndHeader.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(view.getElement(), Package2EditPart.VISUAL_ID));
			resultAndHeader.addAll(getPackage_1000SemanticChildren(view));
			return resultAndHeader;
		}
		case ClassEditPart.VISUAL_ID:
			return getClass_2006SemanticChildren(view);
		case Class3EditPart.VISUAL_ID:
			return getClass_2007SemanticChildren(view);
		case Property3EditPart.VISUAL_ID:
			return getProperty_3014SemanticChildren(view);
		case CollaborationContentsEditPart.VISUAL_ID:
			return getCollaborationContents_7003SemanticChildren(view);
		case ClassAttributesEditPart.VISUAL_ID:
			return getClassAttributes_7004SemanticChildren(view);
		case ClassOperationsEditPart.VISUAL_ID:
			return getClassOperations_7005SemanticChildren(view);
		case ClassClassesEditPart.VISUAL_ID:
			return getClassClasses_7006SemanticChildren(view);
		case PackageImportsEditPart.VISUAL_ID:
			return getPackageImports_7002SemanticChildren(view);
		case ClassClass_contentsEditPart.VISUAL_ID:
			return getClassArtifactFigure_contents_7007SemanticChildren(view);
		case InstanceSpecificationSlotsEditPart.VISUAL_ID:
			return getInstanceSpecificationSlots_7009SemanticChildren(view);
		case InterfaceAttributesEditPart.VISUAL_ID:
			return getInterfaceAttributes_7010SemanticChildren(view);
		case InterfaceOperationsEditPart.VISUAL_ID:
			return getInterfaceOperations_7011SemanticChildren(view);
		case InterfaceClassesEditPart.VISUAL_ID:
			return getInterfaceClasses_7012SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> getClass_2006SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PortEditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> getClass_2007SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Port3EditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	public static List<UMLNodeDescriptor> getProperty_3014SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Property p = (Property) view.getElement();
		if (p.getType() == null) {
			return Collections.emptyList();
		}
		Type t = p.getType();
		if (false == t instanceof StructuredClassifier) {
			return Collections.emptyList();
		}
		List<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		// [209651] collect duplicate ports
		for (Property attr : ((StructuredClassifier) t).getOwnedAttributes()) {
			if (false == attr instanceof Port) {
				continue;
			}
			for (ConnectorEnd end : ((Port) attr).getEnds()) {
				if (p.equals(end.getPartWithPort())) {
					int visualID = UMLVisualIDRegistry.getNodeVisualID(view, attr);
					if (visualID == Port2EditPart.VISUAL_ID) {
						result.add(new UMLNodeDescriptor(attr, visualID));
					}
				}
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> getCollaborationContents_7003SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Collaboration modelElement = (Collaboration) containerView.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getCollaborationUses().iterator(); it.hasNext();) {
			CollaborationUse childElement = (CollaborationUse) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CollaborationUse2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getCollaborationRoles().iterator(); it.hasNext();) {
			ConnectableElement childElement = (ConnectableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == PropertyEditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> getClassAttributes_7004SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class) containerView.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Property2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> getClassOperations_7005SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class) containerView.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == OperationEditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> getClassClasses_7006SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class) containerView.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Class2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> getPackageImports_7002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Package modelElement = (Package) containerView.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getElementImports().iterator(); it.hasNext();) {
			ElementImport childElement = (ElementImport) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ElementImportEditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	* @generated
	*/
	public static List<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> getClassArtifactFigure_contents_7007SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Class modelElement = (Class) containerView.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Property3EditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> getInstanceSpecificationSlots_7009SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		InstanceSpecification modelElement = (InstanceSpecification) containerView.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getSlots().iterator(); it.hasNext();) {
			Slot childElement = (Slot) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == SlotEditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> getInterfaceAttributes_7010SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Interface modelElement = (Interface) containerView.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
			Property childElement = (Property) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Property4EditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> getInterfaceOperations_7011SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Interface modelElement = (Interface) containerView.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getOwnedOperations().iterator(); it.hasNext();) {
			Operation childElement = (Operation) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Operation2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> getInterfaceClasses_7012SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Interface modelElement = (Interface) containerView.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getNestedClassifiers().iterator(); it.hasNext();) {
			Classifier childElement = (Classifier) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == Class4EditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> getPackage_1000SemanticChildrenGen(View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Package modelElement = (Package) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor>();
		for (Iterator<?> it = modelElement.getPackagedElements().iterator(); it.hasNext();) {
			PackageableElement childElement = (PackageableElement) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CollaborationEditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InstanceSpecificationEditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ConstraintEditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOwnedTypes().iterator(); it.hasNext();) {
			Type childElement = (Type) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == ClassEditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Class3EditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == InterfaceEditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == Interface2EditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator<?> it = modelElement.getOwnedComments().iterator(); it.hasNext();) {
			Comment childElement = (Comment) it.next();
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == CommentEditPart.VISUAL_ID) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	public static List<UMLNodeDescriptor> getPackage_1000SemanticChildren(View view) {
		List<UMLNodeDescriptor> result = new ArrayList<UMLNodeDescriptor>();
		result.addAll(getPackage_1000SemanticChildrenGen(view));
		result.addAll(getPackage_1000SemanticChildren_ConstraintsAsOwnedRules(view));
		return result;
	}

	public static List<UMLNodeDescriptor> getPackage_1000SemanticChildren_ConstraintsAsOwnedRules(View view) {
		Package modelElement = (Package) view.getElement();
		List<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		for (Constraint next : modelElement.getOwnedRules()) {
			int visualID = UMLVisualIDRegistry.getNodeVisualID(view, next);
			if (visualID == ConstraintEditPart.VISUAL_ID) {
				result.add(new UMLNodeDescriptor(next, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getContainedLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return getPackage_1000ContainedLinks(view);
		case CollaborationEditPart.VISUAL_ID:
			return getCollaboration_2005ContainedLinks(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_2006ContainedLinks(view);
		case Package2EditPart.VISUAL_ID:
			return getPackage_2003ContainedLinks(view);
		case Class3EditPart.VISUAL_ID:
			return getClass_2007ContainedLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2009ContainedLinks(view);
		case InstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecification_2011ContainedLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2012ContainedLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2013ContainedLinks(view);
		case Interface2EditPart.VISUAL_ID:
			return getInterface_2014ContainedLinks(view);
		case CollaborationUse2EditPart.VISUAL_ID:
			return getCollaborationUse_3002ContainedLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3007ContainedLinks(view);
		case Property2EditPart.VISUAL_ID:
			return getProperty_3008ContainedLinks(view);
		case OperationEditPart.VISUAL_ID:
			return getOperation_3009ContainedLinks(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3010ContainedLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3011ContainedLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3004ContainedLinks(view);
		case Property3EditPart.VISUAL_ID:
			return getProperty_3014ContainedLinks(view);
		case Port2EditPart.VISUAL_ID:
			return getPort_3016ContainedLinks(view);
		case Port3EditPart.VISUAL_ID:
			return getPort_3017ContainedLinks(view);
		case SlotEditPart.VISUAL_ID:
			return getSlot_3015ContainedLinks(view);
		case Property4EditPart.VISUAL_ID:
			return getProperty_3018ContainedLinks(view);
		case Operation2EditPart.VISUAL_ID:
			return getOperation_3019ContainedLinks(view);
		case Class4EditPart.VISUAL_ID:
			return getClass_3020ContainedLinks(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_4005ContainedLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4006ContainedLinks(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4007ContainedLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4008ContainedLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4011ContainedLinks(view);
		case AssociationInstanceEditPart.VISUAL_ID:
			return getSlot_4015ContainedLinks(view);
		case Dependency2EditPart.VISUAL_ID:
			return getDependency_4017ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getIncomingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case CollaborationEditPart.VISUAL_ID:
			return getCollaboration_2005IncomingLinks(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_2006IncomingLinks(view);
		case Package2EditPart.VISUAL_ID:
			return getPackage_2003IncomingLinks(view);
		case Class3EditPart.VISUAL_ID:
			return getClass_2007IncomingLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2009IncomingLinks(view);
		case InstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecification_2011IncomingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2012IncomingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2013IncomingLinks(view);
		case Interface2EditPart.VISUAL_ID:
			return getInterface_2014IncomingLinks(view);
		case CollaborationUse2EditPart.VISUAL_ID:
			return getCollaborationUse_3002IncomingLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3007IncomingLinks(view);
		case Property2EditPart.VISUAL_ID:
			return getProperty_3008IncomingLinks(view);
		case OperationEditPart.VISUAL_ID:
			return getOperation_3009IncomingLinks(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3010IncomingLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3011IncomingLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3004IncomingLinks(view);
		case Property3EditPart.VISUAL_ID:
			return getProperty_3014IncomingLinks(view);
		case Port2EditPart.VISUAL_ID:
			return getPort_3016IncomingLinks(view);
		case Port3EditPart.VISUAL_ID:
			return getPort_3017IncomingLinks(view);
		case SlotEditPart.VISUAL_ID:
			return getSlot_3015IncomingLinks(view);
		case Property4EditPart.VISUAL_ID:
			return getProperty_3018IncomingLinks(view);
		case Operation2EditPart.VISUAL_ID:
			return getOperation_3019IncomingLinks(view);
		case Class4EditPart.VISUAL_ID:
			return getClass_3020IncomingLinks(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_4005IncomingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4006IncomingLinks(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4007IncomingLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4008IncomingLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4011IncomingLinks(view);
		case AssociationInstanceEditPart.VISUAL_ID:
			return getSlot_4015IncomingLinks(view);
		case Dependency2EditPart.VISUAL_ID:
			return getDependency_4017IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOutgoingLinks(View view) {
		switch (UMLVisualIDRegistry.getVisualID(view)) {
		case CollaborationEditPart.VISUAL_ID:
			return getCollaboration_2005OutgoingLinks(view);
		case ClassEditPart.VISUAL_ID:
			return getClass_2006OutgoingLinks(view);
		case Package2EditPart.VISUAL_ID:
			return getPackage_2003OutgoingLinks(view);
		case Class3EditPart.VISUAL_ID:
			return getClass_2007OutgoingLinks(view);
		case InterfaceEditPart.VISUAL_ID:
			return getInterface_2009OutgoingLinks(view);
		case InstanceSpecificationEditPart.VISUAL_ID:
			return getInstanceSpecification_2011OutgoingLinks(view);
		case ConstraintEditPart.VISUAL_ID:
			return getConstraint_2012OutgoingLinks(view);
		case CommentEditPart.VISUAL_ID:
			return getComment_2013OutgoingLinks(view);
		case Interface2EditPart.VISUAL_ID:
			return getInterface_2014OutgoingLinks(view);
		case CollaborationUse2EditPart.VISUAL_ID:
			return getCollaborationUse_3002OutgoingLinks(view);
		case PropertyEditPart.VISUAL_ID:
			return getProperty_3007OutgoingLinks(view);
		case Property2EditPart.VISUAL_ID:
			return getProperty_3008OutgoingLinks(view);
		case OperationEditPart.VISUAL_ID:
			return getOperation_3009OutgoingLinks(view);
		case Class2EditPart.VISUAL_ID:
			return getClass_3010OutgoingLinks(view);
		case PortEditPart.VISUAL_ID:
			return getPort_3011OutgoingLinks(view);
		case ElementImportEditPart.VISUAL_ID:
			return getElementImport_3004OutgoingLinks(view);
		case Property3EditPart.VISUAL_ID:
			return getProperty_3014OutgoingLinks(view);
		case Port2EditPart.VISUAL_ID:
			return getPort_3016OutgoingLinks(view);
		case Port3EditPart.VISUAL_ID:
			return getPort_3017OutgoingLinks(view);
		case SlotEditPart.VISUAL_ID:
			return getSlot_3015OutgoingLinks(view);
		case Property4EditPart.VISUAL_ID:
			return getProperty_3018OutgoingLinks(view);
		case Operation2EditPart.VISUAL_ID:
			return getOperation_3019OutgoingLinks(view);
		case Class4EditPart.VISUAL_ID:
			return getClass_3020OutgoingLinks(view);
		case ConnectorEditPart.VISUAL_ID:
			return getConnector_4005OutgoingLinks(view);
		case DependencyEditPart.VISUAL_ID:
			return getDependency_4006OutgoingLinks(view);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return getInterfaceRealization_4007OutgoingLinks(view);
		case UsageEditPart.VISUAL_ID:
			return getUsage_4008OutgoingLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_4011OutgoingLinks(view);
		case AssociationInstanceEditPart.VISUAL_ID:
			return getSlot_4015OutgoingLinks(view);
		case Dependency2EditPart.VISUAL_ID:
			return getDependency_4017OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getPackage_1000ContainedLinks(View view) {
		Package modelElement = (Package) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getCollaboration_2005ContainedLinks(View view) {
		Collaboration modelElement = (Collaboration) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getClass_2006ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getPackage_2003ContainedLinks(View view) {
		//no links to, from and inside the diagram header
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getClass_2007ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4007(modelElement));
		return result;
	}

	/**
	 * @generated NOT
	 */
	public static List<UMLLinkDescriptor> getInterface_2009ContainedLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		List<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getInterface_2009ContainedLinksGen(view));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4007_ForAllClassifiers(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getInterface_2009ContainedLinksGen(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getInstanceSpecification_2011ContainedLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Slot_4015(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getConstraint_2012ContainedLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getComment_2013ContainedLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement));
		return result;
	}

	/**
	 * @generated NOT
	 */
	public static List<UMLLinkDescriptor> getInterface_2014ContainedLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		List<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4007_ForAllClassifiers(modelElement));
		result.addAll(getInterface_2014ContainedLinksGen(view));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getInterface_2014ContainedLinksGen(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getCollaborationUse_3002ContainedLinks(View view) {
		CollaborationUse modelElement = (CollaborationUse) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Dependency_4006(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getProperty_3007ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getProperty_3008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOperation_3009ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getClass_3010ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getPort_3011ContainedLinks(View view) {
		Port modelElement = (Port) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Provided_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Required_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getElementImport_3004ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getProperty_3014ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getPort_3016ContainedLinks(View view) {
		Port modelElement = (Port) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Provided_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Required_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getPort_3017ContainedLinks(View view) {
		Port modelElement = (Port) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Provided_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Required_4014(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getSlot_3015ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getProperty_3018ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOperation_3019ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getClass_3020ContainedLinks(View view) {
		Class modelElement = (Class) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Connector_4005(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_InterfaceRealization_4007(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getConnector_4005ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getDependency_4006ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getInterfaceRealization_4007ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getUsage_4008ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getAssociation_4011ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getSlot_4015ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getDependency_4017ContainedLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getCollaboration_2005IncomingLinks(View view) {
		Collaboration modelElement = (Collaboration) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getClass_2006IncomingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getPackage_2003IncomingLinks(View view) {
		//no links to, from and inside the diagram header
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getClass_2007IncomingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getInterface_2009IncomingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Provided_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Required_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getInstanceSpecification_2011IncomingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Slot_4015(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getConstraint_2012IncomingLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getComment_2013IncomingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getInterface_2014IncomingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_InterfaceRealization_4007(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Provided_4010(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Port_Required_4014(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getCollaborationUse_3002IncomingLinks(View view) {
		CollaborationUse modelElement = (CollaborationUse) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getProperty_3007IncomingLinks(View view) {
		Property modelElement = (Property) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Connector_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getProperty_3008IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOperation_3009IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getClass_3010IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getPort_3011IncomingLinks(View view) {
		Port modelElement = (Port) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Connector_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getElementImport_3004IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getProperty_3014IncomingLinks(View view) {
		Property modelElement = (Property) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Connector_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getPort_3016IncomingLinks(View view) {
		Port modelElement = (Port) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Connector_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getPort_3017IncomingLinks(View view) {
		Port modelElement = (Port) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Connector_4005(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getSlot_3015IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getProperty_3018IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOperation_3019IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getClass_3020IncomingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getConnector_4005IncomingLinks(View view) {
		Connector modelElement = (Connector) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getDependency_4006IncomingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getInterfaceRealization_4007IncomingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getUsage_4008IncomingLinks(View view) {
		Usage modelElement = (Usage) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getAssociation_4011IncomingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_4011(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getSlot_4015IncomingLinks(View view) {
		Slot modelElement = (Slot) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getDependency_4017IncomingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4006(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Usage_4008(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement, crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Dependency_4017(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getCollaboration_2005OutgoingLinks(View view) {
		Collaboration modelElement = (Collaboration) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getClass_2006OutgoingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getPackage_2003OutgoingLinks(View view) {
		//no links to, from and inside the diagram header
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getClass_2007OutgoingLinks(View view) {
		Class modelElement = (Class) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_InterfaceRealization_4007(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getInterface_2009OutgoingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getInstanceSpecification_2011OutgoingLinks(View view) {
		InstanceSpecification modelElement = (InstanceSpecification) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Slot_4015(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getConstraint_2012OutgoingLinks(View view) {
		Constraint modelElement = (Constraint) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getComment_2013OutgoingLinks(View view) {
		Comment modelElement = (Comment) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getInterface_2014OutgoingLinks(View view) {
		Interface modelElement = (Interface) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getCollaborationUse_3002OutgoingLinks(View view) {
		CollaborationUse modelElement = (CollaborationUse) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getProperty_3007OutgoingLinks(View view) {
		Property modelElement = (Property) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Connector_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getProperty_3008OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOperation_3009OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getClass_3010OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getPort_3011OutgoingLinks(View view) {
		Port modelElement = (Port) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Connector_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Provided_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Required_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getElementImport_3004OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getProperty_3014OutgoingLinks(View view) {
		Property modelElement = (Property) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Connector_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getPort_3016OutgoingLinks(View view) {
		Port modelElement = (Port) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Connector_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Provided_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Required_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getPort_3017OutgoingLinks(View view) {
		Port modelElement = (Port) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Connector_4005(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Provided_4010(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Port_Required_4014(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getSlot_3015OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getProperty_3018OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOperation_3019OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getClass_3020OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getConnector_4005OutgoingLinks(View view) {
		Connector modelElement = (Connector) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getDependency_4006OutgoingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getInterfaceRealization_4007OutgoingLinks(View view) {
		InterfaceRealization modelElement = (InterfaceRealization) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getUsage_4008OutgoingLinks(View view) {
		Usage modelElement = (Usage) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getAssociation_4011OutgoingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Association_4011(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getSlot_4015OutgoingLinks(View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getDependency_4017OutgoingLinks(View view) {
		Dependency modelElement = (Dependency) view.getElement();
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4006(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Usage_4008(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_Dependency_4017(modelElement));
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Connector_4005(StructuredClassifier container) {
		Collection<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for (Connector link : container.getOwnedConnectors()) {
			if (ConnectorEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ConnectableElement src = ConnectorEndConvention.getSourceEnd(link).getRole();
			ConnectableElement dst = ConnectorEndConvention.getTargetEnd(link).getRole();
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Connector_4005, ConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getContainedTypeModelFacetLinks_Dependency_4006(CollaborationUse container) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		for (Iterator<?> links = container.getRoleBindings().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4006, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_InterfaceRealization_4007(BehavioredClassifier container) {
		return getContainedTypeModelFacetLinks_InterfaceRealization_4007_ForAllClassifiers(container);
	}

	/**
	 * @generated NOT
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_InterfaceRealization_4007_ForAllClassifiers(Classifier container) {
		Collection<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();

		for (Relationship linkObject : container.getRelationships(UMLPackage.eINSTANCE.getInterfaceRealization())) {
			if (false == linkObject instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization) linkObject;
			if (InterfaceRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			EList<NamedElement> targets = link.getSuppliers();
			if (targets.size() != 1) {
				continue;
			}
			if (link.getClients().contains(container)) {
				result.add(new UMLLinkDescriptor(container, targets.get(0), link, UMLElementTypes.InterfaceRealization_4007, InterfaceRealizationEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getContainedTypeModelFacetLinks_Usage_4008(Package container) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		for (Iterator<?> links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Usage) {
				continue;
			}
			Usage link = (Usage) linkObject;
			if (UsageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(src, dst, link, UMLElementTypes.Usage_4008, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Association_4011(Package container) {
		Collection<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for (PackageableElement linkObject : container.getPackagedElements()) {
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association association = (Association) linkObject;
			if (AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(association)) {
				continue;
			}
			if (association.isBinary()) {
				Property sourceEnd = AssociationEndConvention.getSourceEnd(association);
				Property targetEnd = AssociationEndConvention.getTargetEnd(association);
				EObject gmfSource = sourceEnd.getType();
				EObject gmfTarget = targetEnd.getType();
				result.add(new UMLLinkDescriptor(gmfSource, gmfTarget, association, UMLElementTypes.Association_4011, AssociationEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Slot_4015(InstanceSpecification container) {
		return getOutgoingTypeModelFacetLinks_Slot_4015(container);
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getContainedTypeModelFacetLinks_Dependency_4017(Package container) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		for (Iterator<?> links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (Dependency2EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4017, Dependency2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Connector_4005(ConnectableElement target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		Collection<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for (EStructuralFeature.Setting setting : crossReferences.get(target)) {
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getConnectorEnd_Role() || false == setting.getEObject() instanceof Connector) {
				continue;
			}
			Connector link = (Connector) setting.getEObject();
			if (ConnectorEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ConnectableElement src = ConnectorEndConvention.getSourceEnd(link).getRole();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Connector_4005, ConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_4006(NamedElement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) setting.getEObject();
			if (DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4006, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getIncomingTypeModelFacetLinks_InterfaceRealization_4007(Interface target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getInterfaceRealization_Contract() || false == setting.getEObject() instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization) setting.getEObject();
			if (InterfaceRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			BehavioredClassifier src = link.getImplementingClassifier();
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(src, target, link, UMLElementTypes.InterfaceRealization_4007, InterfaceRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Usage_4008(NamedElement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Usage) {
				continue;
			}
			Usage link = (Usage) setting.getEObject();
			if (UsageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(src, target, link, UMLElementTypes.Usage_4008, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Port_Provided_4010(Interface target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getPort_Provided()) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.PortProvided_4010, PortProvidedEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Association_4011(Type target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		return findRelatedAssociations(target, false);
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(Element target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getConstraint_ConstrainedElement()) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.ConstraintConstrainedElement_4012,
						ConstraintConstrainedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Port_Required_4014(Interface target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getPort_Required()) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.PortRequired_4014, PortRequiredEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Slot_4015(InstanceSpecification target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		Collection<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for (EStructuralFeature.Setting setting : crossReferences.get(target)) {
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getInstanceValue_Instance() || false == setting.getEObject() instanceof InstanceValue) {
				continue;
			}
			InstanceValue instanceValue = (InstanceValue) setting.getEObject();
			if (false == instanceValue.eContainer() instanceof Slot) {
				continue;
			}
			Slot link = (Slot) instanceValue.eContainer();
			if (AssociationInstanceEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			InstanceSpecification src = link.getOwningInstance();
			result.add(new UMLLinkDescriptor(src, target, link, UMLElementTypes.Slot_4015, AssociationInstanceEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getIncomingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(Element target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() == UMLPackage.eINSTANCE.getComment_AnnotatedElement()) {
				result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(setting.getEObject(), target, UMLElementTypes.CommentAnnotatedElement_4016,
						CommentAnnotatedElementEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Dependency_4017(NamedElement target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
		for (EStructuralFeature.Setting setting : settings) {
			if (setting.getEStructuralFeature() != UMLPackage.eINSTANCE.getDependency_Supplier() || false == setting.getEObject() instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) setting.getEObject();
			if (Dependency2EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(src, target, link, UMLElementTypes.Dependency_4017, Dependency2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Connector_4005(ConnectableElement source) {
		StructuredClassifier container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof StructuredClassifier) {
				container = (StructuredClassifier) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		Collection<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for (Connector link : container.getOwnedConnectors()) {
			if (ConnectorEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			ConnectableElement src = ConnectorEndConvention.getSourceEnd(link).getRole();
			ConnectableElement dst = ConnectorEndConvention.getTargetEnd(link).getRole();
			if (src != source) {
				continue;
			}
			result.add(new UMLLinkDescriptor(src, dst, link, UMLElementTypes.Connector_4005, ConnectorEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_4006(NamedElement source) {
		CollaborationUse container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof CollaborationUse) {
				container = (CollaborationUse) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		for (Iterator<?> links = container.getRoleBindings().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (DependencyEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4006, DependencyEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_InterfaceRealization_4007(BehavioredClassifier source) {
		BehavioredClassifier container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof BehavioredClassifier) {
				container = (BehavioredClassifier) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		for (Iterator<?> links = container.getInterfaceRealizations().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof InterfaceRealization) {
				continue;
			}
			InterfaceRealization link = (InterfaceRealization) linkObject;
			if (InterfaceRealizationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			Interface dst = link.getContract();
			BehavioredClassifier src = link.getImplementingClassifier();
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(src, dst, link, UMLElementTypes.InterfaceRealization_4007, InterfaceRealizationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Usage_4008(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		for (Iterator<?> links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Usage) {
				continue;
			}
			Usage link = (Usage) linkObject;
			if (UsageEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(src, dst, link, UMLElementTypes.Usage_4008, UsageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Port_Provided_4010(Port source) {
		Collection<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		Collection<UMLLinkDescriptor> generatedLinks = getOutgoingFeatureModelFacetLinks_Port_Provided_4010Gen(source);
		result.addAll(generatedLinks);

		Collection<ProvidedInterfaceLink> provideds = PortOperationsExt.getProvideds(source);
		for (ProvidedInterfaceLink provided : provideds) {
			boolean alreadyAdded = false;
			for (UMLLinkDescriptor linkDescriptor : generatedLinks) {
				if (linkDescriptor.getDestination() == provided.getTarget()) {
					alreadyAdded = true;
					break;
				}
			}
			if (!alreadyAdded) {
				result.add(new UMLLinkDescriptor(source, provided.getTarget(), UMLElementTypes.PortProvided_4010, PortProvidedEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Port_Provided_4010Gen(Port source) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		for (Iterator<?> destinations = source.getProvideds().iterator(); destinations.hasNext();) {
			Interface destination = (Interface) destinations.next();
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(source, destination, UMLElementTypes.PortProvided_4010, PortProvidedEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Association_4011(Type source) {
		return findRelatedAssociations(source, true);
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Constraint_ConstrainedElement_4012(Constraint source) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		for (Iterator<?> destinations = source.getConstrainedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element) destinations.next();
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(source, destination, UMLElementTypes.ConstraintConstrainedElement_4012, ConstraintConstrainedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Port_Required_4014(Port source) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		for (Iterator<?> destinations = source.getRequireds().iterator(); destinations.hasNext();) {
			Interface destination = (Interface) destinations.next();
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(source, destination, UMLElementTypes.PortRequired_4014, PortRequiredEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated NOT
	 */
	private static Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Slot_4015(InstanceSpecification source) {
		InstanceSpecification container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof InstanceSpecification) {
				container = (InstanceSpecification) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		Collection<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for (Slot link : container.getSlots()) {
			if (AssociationInstanceEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			InstanceSpecification src = link.getOwningInstance();
			for (ValueSpecification next : link.getValues()) {
				if (next instanceof InstanceValue) {
					InstanceValue nextValue = (InstanceValue) next;
					InstanceSpecification nextDst = nextValue.getInstance();
					if (nextDst != null) {
						result.add(new UMLLinkDescriptor(src, nextDst, link, UMLElementTypes.Slot_4015, AssociationInstanceEditPart.VISUAL_ID));
					}
				}
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOutgoingFeatureModelFacetLinks_Comment_AnnotatedElement_4016(Comment source) {
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		for (Iterator<?> destinations = source.getAnnotatedElements().iterator(); destinations.hasNext();) {
			Element destination = (Element) destinations.next();
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(source, destination, UMLElementTypes.CommentAnnotatedElement_4016, CommentAnnotatedElementEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Dependency_4017(NamedElement source) {
		Package container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof Package) {
				container = (Package) element;
			}
		}
		if (container == null) {
			return Collections.emptyList();
		}
		LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor> result = new LinkedList<org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor>();
		for (Iterator<?> links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Dependency) {
				continue;
			}
			Dependency link = (Dependency) linkObject;
			if (Dependency2EditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List targets = link.getSuppliers();
			Object theTarget = targets.size() == 1 ? targets.get(0) : null;
			if (false == theTarget instanceof NamedElement) {
				continue;
			}
			NamedElement dst = (NamedElement) theTarget;
			List sources = link.getClients();
			Object theSource = sources.size() == 1 ? sources.get(0) : null;
			if (false == theSource instanceof NamedElement) {
				continue;
			}
			NamedElement src = (NamedElement) theSource;
			if (src != source) {
				continue;
			}
			result.add(new org.eclipse.uml2.diagram.csd.part.UMLLinkDescriptor(src, dst, link, UMLElementTypes.Dependency_4017, Dependency2EditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @NOT-generated
	 */
	private static Collection<UMLLinkDescriptor> findRelatedAssociations(Type type, boolean sourceNotTarget) {
		Package container = type.getNearestPackage();
		if (container == null) {
			return Collections.emptyList();
		}

		List<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for (PackageableElement next : container.getPackagedElements()) {
			if (false == next instanceof Association) {
				continue;
			}
			if (AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(next)) {
				continue;
			}
			Association link = (Association) next;
			Property sourceEnd = AssociationEndConvention.getSourceEnd(link);
			Property targetEnd = AssociationEndConvention.getTargetEnd(link);

			if (sourceEnd == null || targetEnd == null) {
				continue;
			}

			Property subjectEnd = sourceNotTarget ? sourceEnd : targetEnd;
			if (!type.equals(subjectEnd.getType())) {
				continue;
			}

			EObject gmfSource = sourceEnd.getType();
			EObject gmfTarget = targetEnd.getType();
			result.add(new UMLLinkDescriptor(gmfSource, gmfTarget, link, UMLElementTypes.Association_4011, AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final IDiagramUpdater TYPED_ADAPTER = new IDiagramUpdater() {

		/**
		* @generated
		*/
		public List<UMLNodeDescriptor> getSemanticChildren(View view) {
			return org.eclipse.uml2.diagram.csd.part.UMLDiagramUpdater.getSemanticChildren(view);
		}

		/**
		* @generated
		*/
		public List<UMLLinkDescriptor> getContainedLinks(View view) {
			return org.eclipse.uml2.diagram.csd.part.UMLDiagramUpdater.getContainedLinks(view);
		}

		/**
		* @generated
		*/
		public List<UMLLinkDescriptor> getIncomingLinks(View view) {
			return org.eclipse.uml2.diagram.csd.part.UMLDiagramUpdater.getIncomingLinks(view);
		}

		/**
		* @generated
		*/
		public List<UMLLinkDescriptor> getOutgoingLinks(View view) {
			return org.eclipse.uml2.diagram.csd.part.UMLDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
