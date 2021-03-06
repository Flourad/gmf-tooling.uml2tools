/**
 * <copyright>
 * </copyright>
 *
 * $Id: U2TGenPackageImpl.java,v 1.6 2011/02/11 14:16:05 cwaniek Exp $
 */
package org.eclipse.uml2.diagram.codegen.u2tgen.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;

import org.eclipse.gmf.mappings.GMFMapPackage;

import org.eclipse.uml2.diagram.codegen.u2tgen.AbstractDynamicCanonicalContainer;
import org.eclipse.uml2.diagram.codegen.u2tgen.AuxSecondaryDiagramNodeAttribute;
import org.eclipse.uml2.diagram.codegen.u2tgen.CounterpartSemanticHintAttribute;
import org.eclipse.uml2.diagram.codegen.u2tgen.CustomLocatorAttributes;
import org.eclipse.uml2.diagram.codegen.u2tgen.DependencyToolStackInfoAttribute;
import org.eclipse.uml2.diagram.codegen.u2tgen.DependencyToolStackSupportAttribute;
import org.eclipse.uml2.diagram.codegen.u2tgen.DetailsLevelAttributes;
import org.eclipse.uml2.diagram.codegen.u2tgen.DynamicCanonicalCompartment;
import org.eclipse.uml2.diagram.codegen.u2tgen.GeneralizedLinkConstraintAttribute;
import org.eclipse.uml2.diagram.codegen.u2tgen.InteractionDiagramAttributes;
import org.eclipse.uml2.diagram.codegen.u2tgen.LinkToolStackInfoAttribute;
import org.eclipse.uml2.diagram.codegen.u2tgen.LinkToolStackSupportAttribute;
import org.eclipse.uml2.diagram.codegen.u2tgen.RotatedLabelAttributes;
import org.eclipse.uml2.diagram.codegen.u2tgen.StereotypeSupportAttribute;
import org.eclipse.uml2.diagram.codegen.u2tgen.StereotypeSupportRole;
import org.eclipse.uml2.diagram.codegen.u2tgen.SubstitutableByAttributes;
import org.eclipse.uml2.diagram.codegen.u2tgen.U2TGenFactory;
import org.eclipse.uml2.diagram.codegen.u2tgen.U2TGenPackage;

import org.eclipse.uml2.diagram.codegen.u2tmap.U2TMapPackage;

import org.eclipse.uml2.diagram.codegen.u2tmap.impl.U2TMapPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class U2TGenPackageImpl extends EPackageImpl implements U2TGenPackage {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass auxSecondaryDiagramNodeAttributeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass customLocatorAttributesEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass detailsLevelAttributesEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass substitutableByAttributesEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass abstractDynamicCanonicalContainerEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass dynamicCanonicalCompartmentEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass interactionDiagramAttributesEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass rotatedLabelAttributesEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass stereotypeSupportAttributeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass linkToolStackSupportAttributeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass linkToolStackInfoAttributeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass generalizedLinkConstraintAttributeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass counterpartSemanticHintAttributeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EEnum stereotypeSupportRoleEEnum = null;

	/**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.uml2.diagram.codegen.u2tgen.U2TGenPackage#eNS_URI
   * @see #init()
   * @generated
   */
	private U2TGenPackageImpl() {
    super(eNS_URI, U2TGenFactory.eINSTANCE);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private static boolean isInited = false;

	/**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link U2TGenPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
	public static U2TGenPackage init() {
    if (isInited) return (U2TGenPackage)EPackage.Registry.INSTANCE.getEPackage(U2TGenPackage.eNS_URI);

    // Obtain or create and register package
    U2TGenPackageImpl theU2TGenPackage = (U2TGenPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof U2TGenPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new U2TGenPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    GMFGenPackage.eINSTANCE.eClass();
    GMFMapPackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    U2TMapPackageImpl theU2TMapPackage = (U2TMapPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(U2TMapPackage.eNS_URI) instanceof U2TMapPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(U2TMapPackage.eNS_URI) : U2TMapPackage.eINSTANCE);

    // Create package meta-data objects
    theU2TGenPackage.createPackageContents();
    theU2TMapPackage.createPackageContents();

    // Initialize created meta-data
    theU2TGenPackage.initializePackageContents();
    theU2TMapPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theU2TGenPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(U2TGenPackage.eNS_URI, theU2TGenPackage);
    return theU2TGenPackage;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAuxSecondaryDiagramNodeAttribute() {
    return auxSecondaryDiagramNodeAttributeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getAuxSecondaryDiagramNodeAttribute_SubstituteWithCanvasElement() {
    return (EAttribute)auxSecondaryDiagramNodeAttributeEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getCustomLocatorAttributes() {
    return customLocatorAttributesEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getCustomLocatorAttributes_CustomLocatorFQN() {
    return (EAttribute)customLocatorAttributesEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getDetailsLevelAttributes() {
    return detailsLevelAttributesEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getDetailsLevelAttributes_FilteringCompartment() {
    return (EAttribute)detailsLevelAttributesEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getDetailsLevelAttributes_DetailsAwareParser() {
    return (EAttribute)detailsLevelAttributesEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getSubstitutableByAttributes() {
    return substitutableByAttributesEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getSubstitutableByAttributes_SubstitutableByIDs() {
    return (EAttribute)substitutableByAttributesEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getSubstitutableByAttributes_RequiresAll() {
    return (EAttribute)substitutableByAttributesEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getAbstractDynamicCanonicalContainer() {
    return abstractDynamicCanonicalContainerEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getAbstractDynamicCanonicalContainer_AlwaysCanonicalIDs() {
    return (EAttribute)abstractDynamicCanonicalContainerEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getAbstractDynamicCanonicalContainer_InitiallyCanonical() {
    return (EAttribute)abstractDynamicCanonicalContainerEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getDynamicCanonicalCompartment() {
    return dynamicCanonicalCompartmentEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getInteractionDiagramAttributes() {
    return interactionDiagramAttributesEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getInteractionDiagramAttributes_MultiLayered() {
    return (EAttribute)interactionDiagramAttributesEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getRotatedLabelAttributes() {
    return rotatedLabelAttributesEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getStereotypeSupportAttribute() {
    return stereotypeSupportAttributeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getStereotypeSupportAttribute_Role() {
    return (EAttribute)stereotypeSupportAttributeEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getLinkToolStackSupportAttribute() {
    return linkToolStackSupportAttributeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getLinkToolStackSupportAttribute_ToolClassProviderName() {
    return (EAttribute)linkToolStackSupportAttributeEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getLinkToolStackSupportAttribute_BaseSemanticClassName() {
    return (EAttribute)linkToolStackSupportAttributeEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getLinkToolStackInfoAttribute() {
    return linkToolStackInfoAttributeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getLinkToolStackInfoAttribute_ToolgroupTitle() {
    return (EAttribute)linkToolStackInfoAttributeEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getLinkToolStackInfoAttribute_ElementUniqueIdentifier() {
    return (EAttribute)linkToolStackInfoAttributeEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getGeneralizedLinkConstraintAttribute() {
    return generalizedLinkConstraintAttributeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getGeneralizedLinkConstraintAttribute_LinkConstraint() {
    return (EAttribute)generalizedLinkConstraintAttributeEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EClass getCounterpartSemanticHintAttribute() {
    return counterpartSemanticHintAttributeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getCounterpartSemanticHintAttribute_ParentVisualId() {
    return (EAttribute)counterpartSemanticHintAttributeEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EAttribute getCounterpartSemanticHintAttribute_ChildVisualId() {
    return (EAttribute)counterpartSemanticHintAttributeEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EEnum getStereotypeSupportRole() {
    return stereotypeSupportRoleEEnum;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public U2TGenFactory getU2TGenFactory() {
    return (U2TGenFactory)getEFactoryInstance();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private boolean isCreated = false;

	/**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void createPackageContents() {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    auxSecondaryDiagramNodeAttributeEClass = createEClass(AUX_SECONDARY_DIAGRAM_NODE_ATTRIBUTE);
    createEAttribute(auxSecondaryDiagramNodeAttributeEClass, AUX_SECONDARY_DIAGRAM_NODE_ATTRIBUTE__SUBSTITUTE_WITH_CANVAS_ELEMENT);

    customLocatorAttributesEClass = createEClass(CUSTOM_LOCATOR_ATTRIBUTES);
    createEAttribute(customLocatorAttributesEClass, CUSTOM_LOCATOR_ATTRIBUTES__CUSTOM_LOCATOR_FQN);

    detailsLevelAttributesEClass = createEClass(DETAILS_LEVEL_ATTRIBUTES);
    createEAttribute(detailsLevelAttributesEClass, DETAILS_LEVEL_ATTRIBUTES__FILTERING_COMPARTMENT);
    createEAttribute(detailsLevelAttributesEClass, DETAILS_LEVEL_ATTRIBUTES__DETAILS_AWARE_PARSER);

    substitutableByAttributesEClass = createEClass(SUBSTITUTABLE_BY_ATTRIBUTES);
    createEAttribute(substitutableByAttributesEClass, SUBSTITUTABLE_BY_ATTRIBUTES__SUBSTITUTABLE_BY_IDS);
    createEAttribute(substitutableByAttributesEClass, SUBSTITUTABLE_BY_ATTRIBUTES__REQUIRES_ALL);

    abstractDynamicCanonicalContainerEClass = createEClass(ABSTRACT_DYNAMIC_CANONICAL_CONTAINER);
    createEAttribute(abstractDynamicCanonicalContainerEClass, ABSTRACT_DYNAMIC_CANONICAL_CONTAINER__ALWAYS_CANONICAL_IDS);
    createEAttribute(abstractDynamicCanonicalContainerEClass, ABSTRACT_DYNAMIC_CANONICAL_CONTAINER__INITIALLY_CANONICAL);

    dynamicCanonicalCompartmentEClass = createEClass(DYNAMIC_CANONICAL_COMPARTMENT);

    interactionDiagramAttributesEClass = createEClass(INTERACTION_DIAGRAM_ATTRIBUTES);
    createEAttribute(interactionDiagramAttributesEClass, INTERACTION_DIAGRAM_ATTRIBUTES__MULTI_LAYERED);

    rotatedLabelAttributesEClass = createEClass(ROTATED_LABEL_ATTRIBUTES);

    stereotypeSupportAttributeEClass = createEClass(STEREOTYPE_SUPPORT_ATTRIBUTE);
    createEAttribute(stereotypeSupportAttributeEClass, STEREOTYPE_SUPPORT_ATTRIBUTE__ROLE);

    linkToolStackSupportAttributeEClass = createEClass(LINK_TOOL_STACK_SUPPORT_ATTRIBUTE);
    createEAttribute(linkToolStackSupportAttributeEClass, LINK_TOOL_STACK_SUPPORT_ATTRIBUTE__TOOL_CLASS_PROVIDER_NAME);
    createEAttribute(linkToolStackSupportAttributeEClass, LINK_TOOL_STACK_SUPPORT_ATTRIBUTE__BASE_SEMANTIC_CLASS_NAME);

    linkToolStackInfoAttributeEClass = createEClass(LINK_TOOL_STACK_INFO_ATTRIBUTE);
    createEAttribute(linkToolStackInfoAttributeEClass, LINK_TOOL_STACK_INFO_ATTRIBUTE__TOOLGROUP_TITLE);
    createEAttribute(linkToolStackInfoAttributeEClass, LINK_TOOL_STACK_INFO_ATTRIBUTE__ELEMENT_UNIQUE_IDENTIFIER);

    generalizedLinkConstraintAttributeEClass = createEClass(GENERALIZED_LINK_CONSTRAINT_ATTRIBUTE);
    createEAttribute(generalizedLinkConstraintAttributeEClass, GENERALIZED_LINK_CONSTRAINT_ATTRIBUTE__LINK_CONSTRAINT);

    counterpartSemanticHintAttributeEClass = createEClass(COUNTERPART_SEMANTIC_HINT_ATTRIBUTE);
    createEAttribute(counterpartSemanticHintAttributeEClass, COUNTERPART_SEMANTIC_HINT_ATTRIBUTE__PARENT_VISUAL_ID);
    createEAttribute(counterpartSemanticHintAttributeEClass, COUNTERPART_SEMANTIC_HINT_ATTRIBUTE__CHILD_VISUAL_ID);

    // Create enums
    stereotypeSupportRoleEEnum = createEEnum(STEREOTYPE_SUPPORT_ROLE);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private boolean isInitialized = false;

	/**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void initializePackageContents() {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    GMFGenPackage theGMFGenPackage = (GMFGenPackage)EPackage.Registry.INSTANCE.getEPackage(GMFGenPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    auxSecondaryDiagramNodeAttributeEClass.getESuperTypes().add(theGMFGenPackage.getAttributes());
    customLocatorAttributesEClass.getESuperTypes().add(theGMFGenPackage.getAttributes());
    detailsLevelAttributesEClass.getESuperTypes().add(theGMFGenPackage.getAttributes());
    substitutableByAttributesEClass.getESuperTypes().add(theGMFGenPackage.getAttributes());
    abstractDynamicCanonicalContainerEClass.getESuperTypes().add(theGMFGenPackage.getAttributes());
    dynamicCanonicalCompartmentEClass.getESuperTypes().add(this.getAbstractDynamicCanonicalContainer());
    interactionDiagramAttributesEClass.getESuperTypes().add(theGMFGenPackage.getAttributes());
    rotatedLabelAttributesEClass.getESuperTypes().add(theGMFGenPackage.getAttributes());
    stereotypeSupportAttributeEClass.getESuperTypes().add(theGMFGenPackage.getAttributes());
    linkToolStackSupportAttributeEClass.getESuperTypes().add(theGMFGenPackage.getAttributes());
    linkToolStackInfoAttributeEClass.getESuperTypes().add(theGMFGenPackage.getAttributes());
    generalizedLinkConstraintAttributeEClass.getESuperTypes().add(theGMFGenPackage.getAttributes());
    counterpartSemanticHintAttributeEClass.getESuperTypes().add(theGMFGenPackage.getAttributes());

    // Initialize classes and features; add operations and parameters
    initEClass(auxSecondaryDiagramNodeAttributeEClass, AuxSecondaryDiagramNodeAttribute.class, "AuxSecondaryDiagramNodeAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAuxSecondaryDiagramNodeAttribute_SubstituteWithCanvasElement(), ecorePackage.getEBoolean(), "substituteWithCanvasElement", null, 0, 1, AuxSecondaryDiagramNodeAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(customLocatorAttributesEClass, CustomLocatorAttributes.class, "CustomLocatorAttributes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCustomLocatorAttributes_CustomLocatorFQN(), ecorePackage.getEString(), "customLocatorFQN", null, 0, 1, CustomLocatorAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(detailsLevelAttributesEClass, DetailsLevelAttributes.class, "DetailsLevelAttributes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDetailsLevelAttributes_FilteringCompartment(), ecorePackage.getEBoolean(), "filteringCompartment", null, 0, 1, DetailsLevelAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDetailsLevelAttributes_DetailsAwareParser(), ecorePackage.getEBoolean(), "detailsAwareParser", null, 0, 1, DetailsLevelAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(substitutableByAttributesEClass, SubstitutableByAttributes.class, "SubstitutableByAttributes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSubstitutableByAttributes_SubstitutableByIDs(), ecorePackage.getEInt(), "substitutableByIDs", null, 0, -1, SubstitutableByAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSubstitutableByAttributes_RequiresAll(), ecorePackage.getEBoolean(), "requiresAll", null, 0, 1, SubstitutableByAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(substitutableByAttributesEClass, theGMFGenPackage.getGenCommonBase(), "getSubstitutableByNodes", 0, -1, IS_UNIQUE, IS_ORDERED);

    initEClass(abstractDynamicCanonicalContainerEClass, AbstractDynamicCanonicalContainer.class, "AbstractDynamicCanonicalContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAbstractDynamicCanonicalContainer_AlwaysCanonicalIDs(), ecorePackage.getEInt(), "alwaysCanonicalIDs", null, 0, -1, AbstractDynamicCanonicalContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAbstractDynamicCanonicalContainer_InitiallyCanonical(), ecorePackage.getEBoolean(), "initiallyCanonical", "false", 0, 1, AbstractDynamicCanonicalContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(abstractDynamicCanonicalContainerEClass, theGMFGenPackage.getGenCommonBase(), "getAlwaysCanonicalChildren", 0, -1, IS_UNIQUE, IS_ORDERED);

    initEClass(dynamicCanonicalCompartmentEClass, DynamicCanonicalCompartment.class, "DynamicCanonicalCompartment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(interactionDiagramAttributesEClass, InteractionDiagramAttributes.class, "InteractionDiagramAttributes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInteractionDiagramAttributes_MultiLayered(), ecorePackage.getEBoolean(), "multiLayered", "true", 0, 1, InteractionDiagramAttributes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rotatedLabelAttributesEClass, RotatedLabelAttributes.class, "RotatedLabelAttributes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stereotypeSupportAttributeEClass, StereotypeSupportAttribute.class, "StereotypeSupportAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStereotypeSupportAttribute_Role(), this.getStereotypeSupportRole(), "role", null, 0, 1, StereotypeSupportAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(linkToolStackSupportAttributeEClass, LinkToolStackSupportAttribute.class, "LinkToolStackSupportAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLinkToolStackSupportAttribute_ToolClassProviderName(), ecorePackage.getEString(), "toolClassProviderName", null, 0, 1, LinkToolStackSupportAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLinkToolStackSupportAttribute_BaseSemanticClassName(), ecorePackage.getEString(), "baseSemanticClassName", null, 0, 1, LinkToolStackSupportAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(linkToolStackInfoAttributeEClass, LinkToolStackInfoAttribute.class, "LinkToolStackInfoAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLinkToolStackInfoAttribute_ToolgroupTitle(), ecorePackage.getEString(), "toolgroupTitle", null, 0, 1, LinkToolStackInfoAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLinkToolStackInfoAttribute_ElementUniqueIdentifier(), ecorePackage.getEString(), "elementUniqueIdentifier", null, 0, 1, LinkToolStackInfoAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(generalizedLinkConstraintAttributeEClass, GeneralizedLinkConstraintAttribute.class, "GeneralizedLinkConstraintAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGeneralizedLinkConstraintAttribute_LinkConstraint(), ecorePackage.getEString(), "linkConstraint", null, 0, 1, GeneralizedLinkConstraintAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(counterpartSemanticHintAttributeEClass, CounterpartSemanticHintAttribute.class, "CounterpartSemanticHintAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getCounterpartSemanticHintAttribute_ParentVisualId(), ecorePackage.getEString(), "parentVisualId", null, 0, 1, CounterpartSemanticHintAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCounterpartSemanticHintAttribute_ChildVisualId(), ecorePackage.getEString(), "childVisualId", null, 0, 1, CounterpartSemanticHintAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(stereotypeSupportRoleEEnum, StereotypeSupportRole.class, "StereotypeSupportRole");
    addEEnumLiteral(stereotypeSupportRoleEEnum, StereotypeSupportRole.CONTAINER);
    addEEnumLiteral(stereotypeSupportRoleEEnum, StereotypeSupportRole.NAME_LABEL);
    addEEnumLiteral(stereotypeSupportRoleEEnum, StereotypeSupportRole.STEREOTYPE_LABEL);
    addEEnumLiteral(stereotypeSupportRoleEEnum, StereotypeSupportRole.COMBINED_LABEL);
    addEEnumLiteral(stereotypeSupportRoleEEnum, StereotypeSupportRole.DIAGRAM_LABEL);

    // Create resource
    createResource(eNS_URI);
  }

} //U2TGenPackageImpl
