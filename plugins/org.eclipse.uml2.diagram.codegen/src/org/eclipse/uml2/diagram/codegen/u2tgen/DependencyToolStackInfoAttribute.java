/**
 * <copyright>
 * </copyright>
 *
 * $Id: DependencyToolStackInfoAttribute.java,v 1.1 2010/05/14 17:15:02 mgolubev Exp $
 */
package org.eclipse.uml2.diagram.codegen.u2tgen;

import org.eclipse.gmf.codegen.gmfgen.Attributes;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency Tool Stack Info Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.codegen.u2tgen.DependencyToolStackInfoAttribute#getToolgroupTitle <em>Toolgroup Title</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.codegen.u2tgen.DependencyToolStackInfoAttribute#getElementUniqueIdentifier <em>Element Unique Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.codegen.u2tgen.U2TGenPackage#getDependencyToolStackInfoAttribute()
 * @model
 * @generated
 */
public interface DependencyToolStackInfoAttribute extends Attributes {
	/**
	 * Returns the value of the '<em><b>Toolgroup Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Passed to the diagram, contains title of dependency tool stack toolgroup.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Toolgroup Title</em>' attribute.
	 * @see #setToolgroupTitle(String)
	 * @see org.eclipse.uml2.diagram.codegen.u2tgen.U2TGenPackage#getDependencyToolStackInfoAttribute_ToolgroupTitle()
	 * @model
	 * @generated
	 */
	String getToolgroupTitle();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.codegen.u2tgen.DependencyToolStackInfoAttribute#getToolgroupTitle <em>Toolgroup Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Toolgroup Title</em>' attribute.
	 * @see #getToolgroupTitle()
	 * @generated
	 */
	void setToolgroupTitle(String value);

	/**
	 * Returns the value of the '<em><b>Element Unique Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Passed the diagram, used in a tool to create correct icons. Contains unique identifier of the type corresponding to the icon.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Element Unique Identifier</em>' attribute.
	 * @see #setElementUniqueIdentifier(String)
	 * @see org.eclipse.uml2.diagram.codegen.u2tgen.U2TGenPackage#getDependencyToolStackInfoAttribute_ElementUniqueIdentifier()
	 * @model
	 * @generated
	 */
	String getElementUniqueIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.codegen.u2tgen.DependencyToolStackInfoAttribute#getElementUniqueIdentifier <em>Element Unique Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Unique Identifier</em>' attribute.
	 * @see #getElementUniqueIdentifier()
	 * @generated
	 */
	void setElementUniqueIdentifier(String value);

} // DependencyToolStackInfoAttribute
