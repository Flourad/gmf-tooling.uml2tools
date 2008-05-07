/**
 * <copyright>
 * </copyright>
 *
 * $Id: InteractionDiagramAttributes.java,v 1.1 2008/05/07 17:42:26 mgolubev Exp $
 */
package org.eclipse.uml2.diagram.codegen.gmfgenext;

import org.eclipse.gmf.codegen.gmfgen.Attributes;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Interaction Diagram Attributes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.codegen.gmfgenext.InteractionDiagramAttributes#isMultiLayered <em>Multi Layered</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.codegen.gmfgenext.GMFGenExtPackage#getInteractionDiagramAttributes()
 * @model
 * @generated
 */
public interface InteractionDiagramAttributes extends Attributes {
	/**
	 * Returns the value of the '<em><b>Multi Layered</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Applicable for gmfgen::GenNode. This node is responcible for distribution of its children's figures between different layers.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Multi Layered</em>' attribute.
	 * @see #setMultiLayered(boolean)
	 * @see org.eclipse.uml2.diagram.codegen.gmfgenext.GMFGenExtPackage#getInteractionDiagramAttributes_MultiLayered()
	 * @model default="true"
	 * @generated
	 */
	boolean isMultiLayered();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.codegen.gmfgenext.InteractionDiagramAttributes#isMultiLayered <em>Multi Layered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi Layered</em>' attribute.
	 * @see #isMultiLayered()
	 * @generated
	 */
	void setMultiLayered(boolean value);

} // InteractionDiagramAttributes
