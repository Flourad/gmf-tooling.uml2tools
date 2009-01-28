/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDAbstractMessageImpl.java,v 1.1 2009/01/28 05:27:46 mgolubev Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;

import org.eclipse.uml2.uml.Message;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDAbstractMessageImpl#getUmlMessage <em>Uml Message</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDAbstractMessageImpl#getFrame <em>Frame</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SDAbstractMessageImpl extends EObjectImpl implements SDAbstractMessage {
	/**
	 * The cached value of the '{@link #getUmlMessage() <em>Uml Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlMessage()
	 * @generated
	 * @ordered
	 */
	protected Message umlMessage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDAbstractMessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_ABSTRACT_MESSAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getUmlMessage() {
		if (umlMessage != null && ((EObject)umlMessage).eIsProxy()) {
			InternalEObject oldUmlMessage = (InternalEObject)umlMessage;
			umlMessage = (Message)eResolveProxy(oldUmlMessage);
			if (umlMessage != oldUmlMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_ABSTRACT_MESSAGE__UML_MESSAGE, oldUmlMessage, umlMessage));
			}
		}
		return umlMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetUmlMessage() {
		return umlMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlMessage(Message newUmlMessage) {
		Message oldUmlMessage = umlMessage;
		umlMessage = newUmlMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_ABSTRACT_MESSAGE__UML_MESSAGE, oldUmlMessage, umlMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDFrame getFrame() {
		if (eContainerFeatureID != SDPackage.SD_ABSTRACT_MESSAGE__FRAME) return null;
		return (SDFrame)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SDPackage.SD_ABSTRACT_MESSAGE__FRAME:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd, SDPackage.SD_ABSTRACT_MESSAGE__FRAME, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SDPackage.SD_ABSTRACT_MESSAGE__FRAME:
				return eBasicSetContainer(null, SDPackage.SD_ABSTRACT_MESSAGE__FRAME, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case SDPackage.SD_ABSTRACT_MESSAGE__FRAME:
				return eInternalContainer().eInverseRemove(this, SDPackage.SD_FRAME__MESSAGES, SDFrame.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDPackage.SD_ABSTRACT_MESSAGE__UML_MESSAGE:
				if (resolve) return getUmlMessage();
				return basicGetUmlMessage();
			case SDPackage.SD_ABSTRACT_MESSAGE__FRAME:
				return getFrame();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SDPackage.SD_ABSTRACT_MESSAGE__UML_MESSAGE:
				setUmlMessage((Message)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SDPackage.SD_ABSTRACT_MESSAGE__UML_MESSAGE:
				setUmlMessage((Message)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SDPackage.SD_ABSTRACT_MESSAGE__UML_MESSAGE:
				return umlMessage != null;
			case SDPackage.SD_ABSTRACT_MESSAGE__FRAME:
				return getFrame() != null;
		}
		return super.eIsSet(featureID);
	}

} //SDAbstractMessageImpl