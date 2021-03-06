/**
 * <copyright>
 * </copyright>
 *
 * $Id: DFrame.java,v 1.1 2008/09/09 17:00:33 mgolubev Exp $
 */
package org.eclipse.uml2.diagram.timing.model.timingd;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Interaction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DFrame</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getContainer <em>Container</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getInteraction <em>Interaction</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getIntervals <em>Intervals</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getMessages <em>Messages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.uml2.diagram.timing.model.timingd.TimingDPackage#getDFrame()
 * @model
 * @generated
 */
public interface DFrame extends EObject {
	/**
	 * Returns the value of the '<em><b>Container</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrameContainer#getFrames <em>Frames</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container</em>' container reference.
	 * @see #setContainer(DFrameContainer)
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.TimingDPackage#getDFrame_Container()
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DFrameContainer#getFrames
	 * @model opposite="frames" transient="false"
	 * @generated
	 */
	DFrameContainer getContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getContainer <em>Container</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container</em>' container reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(DFrameContainer value);

	/**
	 * Returns the value of the '<em><b>Interaction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interaction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction</em>' reference.
	 * @see #setInteraction(Interaction)
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.TimingDPackage#getDFrame_Interaction()
	 * @model type="org.eclipse.uml2.diagram.timing.model.timingd.UMLInteraction" required="true"
	 * @generated
	 */
	Interaction getInteraction();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getInteraction <em>Interaction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interaction</em>' reference.
	 * @see #getInteraction()
	 * @generated
	 */
	void setInteraction(Interaction value);

	/**
	 * Returns the value of the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Display Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Display Name</em>' attribute.
	 * @see #setDisplayName(String)
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.TimingDPackage#getDFrame_DisplayName()
	 * @model
	 * @generated
	 */
	String getDisplayName();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame#getDisplayName <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Display Name</em>' attribute.
	 * @see #getDisplayName()
	 * @generated
	 */
	void setDisplayName(String value);

	/**
	 * Returns the value of the '<em><b>Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.diagram.timing.model.timingd.DBlock}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.timing.model.timingd.DBlock#getFrame <em>Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Blocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Blocks</em>' containment reference list.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.TimingDPackage#getDFrame_Blocks()
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DBlock#getFrame
	 * @model opposite="frame" containment="true" required="true"
	 * @generated
	 */
	EList<DBlock> getBlocks();

	/**
	 * Returns the value of the '<em><b>Intervals</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.diagram.timing.model.timingd.DInterval}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.timing.model.timingd.DInterval#getFrame <em>Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intervals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intervals</em>' containment reference list.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.TimingDPackage#getDFrame_Intervals()
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DInterval#getFrame
	 * @model opposite="frame" containment="true"
	 * @generated
	 */
	EList<DInterval> getIntervals();

	/**
	 * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.diagram.timing.model.timingd.DMessage}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.diagram.timing.model.timingd.DMessage#getFrame <em>Frame</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages</em>' containment reference list.
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.TimingDPackage#getDFrame_Messages()
	 * @see org.eclipse.uml2.diagram.timing.model.timingd.DMessage#getFrame
	 * @model opposite="frame" containment="true"
	 * @generated
	 */
	EList<DMessage> getMessages();

} // DFrame
