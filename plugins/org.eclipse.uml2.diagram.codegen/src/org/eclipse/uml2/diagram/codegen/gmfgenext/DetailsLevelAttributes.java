/**
 * <copyright>
 * </copyright>
 *
 * $Id: DetailsLevelAttributes.java,v 1.1 2007/05/20 19:31:35 mgolubev Exp $
 */
package org.eclipse.uml2.diagram.codegen.gmfgenext;

import org.eclipse.gmf.codegen.gmfgen.Attributes;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Details Level Attributes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.codegen.gmfgenext.DetailsLevelAttributes#isFilteringCompartment <em>Filtering Compartment</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.codegen.gmfgenext.DetailsLevelAttributes#isDetailsAwareParser <em>Details Aware Parser</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.codegen.gmfgenext.GMFGenExtPackage#getDetailsLevelAttributes()
 * @model
 * @generated
 */
public interface DetailsLevelAttributes extends Attributes {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "";

	/**
	 * Returns the value of the '<em><b>Filtering Compartment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Applicable for gmfgen::GenCompartment only. If set, children of this compartment will be filtered according to actual diagram details level.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Filtering Compartment</em>' attribute.
	 * @see #setFilteringCompartment(boolean)
	 * @see org.eclipse.uml2.diagram.codegen.gmfgenext.GMFGenExtPackage#getDetailsLevelAttributes_FilteringCompartment()
	 * @model
	 * @generated
	 */
	boolean isFilteringCompartment();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.codegen.gmfgenext.DetailsLevelAttributes#isFilteringCompartment <em>Filtering Compartment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filtering Compartment</em>' attribute.
	 * @see #isFilteringCompartment()
	 * @generated
	 */
	void setFilteringCompartment(boolean value);

	/**
	 * Returns the value of the '<em><b>Details Aware Parser</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If set, parser for this element should have details-level specific ParserOptions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Details Aware Parser</em>' attribute.
	 * @see #setDetailsAwareParser(boolean)
	 * @see org.eclipse.uml2.diagram.codegen.gmfgenext.GMFGenExtPackage#getDetailsLevelAttributes_DetailsAwareParser()
	 * @model
	 * @generated
	 */
	boolean isDetailsAwareParser();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.codegen.gmfgenext.DetailsLevelAttributes#isDetailsAwareParser <em>Details Aware Parser</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Details Aware Parser</em>' attribute.
	 * @see #isDetailsAwareParser()
	 * @generated
	 */
	void setDetailsAwareParser(boolean value);

} // DetailsLevelAttributes
