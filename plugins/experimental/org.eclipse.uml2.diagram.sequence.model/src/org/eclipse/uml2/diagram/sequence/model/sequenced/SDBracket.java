/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDBracket.java,v 1.4 2009/03/03 14:17:28 mgolubev Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bracket</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket#getBracketContainer <em>Bracket Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDBracket()
 * @model abstract="true"
 * @generated
 */
public interface SDBracket extends SDLifeLineElement, SDBackedByFragment {
	/**
	 * Returns the value of the '<em><b>Bracket Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracketContainer#getBrackets <em>Brackets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bracket Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bracket Container</em>' container reference.
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage#getSDBracket_BracketContainer()
	 * @see org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracketContainer#getBrackets
	 * @model opposite="brackets" required="true" transient="false" changeable="false"
	 * @generated
	 */
	SDBracketContainer getBracketContainer();

} // SDBracket
