/**
 * <copyright>
 * </copyright>
 *
 * $Id: SDFrameImpl.java,v 1.2 2009/02/11 14:36:18 mgolubev Exp $
 */
package org.eclipse.uml2.diagram.sequence.model.sequenced.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDFrame;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDGate;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDPackage;

import org.eclipse.uml2.diagram.sequence.model.sequenced.SDTrace;
import org.eclipse.uml2.uml.Interaction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Frame</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDFrameImpl#getUmlInteraction <em>Uml Interaction</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDFrameImpl#getLifelines <em>Lifelines</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDFrameImpl#getMessages <em>Messages</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.sequence.model.sequenced.impl.SDFrameImpl#getGates <em>Gates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDFrameImpl extends EObjectImpl implements SDFrame {
	private SDTrace myUMLTracing;
	
	/**
	 * The cached value of the '{@link #getUmlInteraction() <em>Uml Interaction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUmlInteraction()
	 * @generated
	 * @ordered
	 */
	protected Interaction umlInteraction;

	/**
	 * The cached value of the '{@link #getLifelines() <em>Lifelines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifelines()
	 * @generated
	 * @ordered
	 */
	protected EList<SDLifeLine> lifelines;

	/**
	 * The cached value of the '{@link #getMessages() <em>Messages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<SDAbstractMessage> messages;

	/**
	 * The cached value of the '{@link #getGates() <em>Gates</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGates()
	 * @generated
	 * @ordered
	 */
	protected EList<SDGate> gates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDFrameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDPackage.Literals.SD_FRAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction getUmlInteraction() {
		if (umlInteraction != null && ((EObject)umlInteraction).eIsProxy()) {
			InternalEObject oldUmlInteraction = (InternalEObject)umlInteraction;
			umlInteraction = (Interaction)eResolveProxy(oldUmlInteraction);
			if (umlInteraction != oldUmlInteraction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDPackage.SD_FRAME__UML_INTERACTION, oldUmlInteraction, umlInteraction));
			}
		}
		return umlInteraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction basicGetUmlInteraction() {
		return umlInteraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUmlInteraction(Interaction newUmlInteraction) {
		Interaction oldUmlInteraction = umlInteraction;
		umlInteraction = newUmlInteraction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDPackage.SD_FRAME__UML_INTERACTION, oldUmlInteraction, umlInteraction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SDLifeLine> getLifelines() {
		if (lifelines == null) {
			lifelines = new EObjectContainmentWithInverseEList<SDLifeLine>(SDLifeLine.class, this, SDPackage.SD_FRAME__LIFELINES, SDPackage.SD_LIFE_LINE__FRAME);
		}
		return lifelines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SDAbstractMessage> getMessages() {
		if (messages == null) {
			messages = new EObjectContainmentWithInverseEList<SDAbstractMessage>(SDAbstractMessage.class, this, SDPackage.SD_FRAME__MESSAGES, SDPackage.SD_ABSTRACT_MESSAGE__FRAME);
		}
		return messages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SDGate> getGates() {
		if (gates == null) {
			gates = new EObjectContainmentEList<SDGate>(SDGate.class, this, SDPackage.SD_FRAME__GATES);
		}
		return gates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public SDTrace getUMLTracing() {
		return myUMLTracing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SDPackage.SD_FRAME__LIFELINES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLifelines()).basicAdd(otherEnd, msgs);
			case SDPackage.SD_FRAME__MESSAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMessages()).basicAdd(otherEnd, msgs);
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
			case SDPackage.SD_FRAME__LIFELINES:
				return ((InternalEList<?>)getLifelines()).basicRemove(otherEnd, msgs);
			case SDPackage.SD_FRAME__MESSAGES:
				return ((InternalEList<?>)getMessages()).basicRemove(otherEnd, msgs);
			case SDPackage.SD_FRAME__GATES:
				return ((InternalEList<?>)getGates()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDPackage.SD_FRAME__UML_INTERACTION:
				if (resolve) return getUmlInteraction();
				return basicGetUmlInteraction();
			case SDPackage.SD_FRAME__LIFELINES:
				return getLifelines();
			case SDPackage.SD_FRAME__MESSAGES:
				return getMessages();
			case SDPackage.SD_FRAME__GATES:
				return getGates();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SDPackage.SD_FRAME__UML_INTERACTION:
				setUmlInteraction((Interaction)newValue);
				return;
			case SDPackage.SD_FRAME__LIFELINES:
				getLifelines().clear();
				getLifelines().addAll((Collection<? extends SDLifeLine>)newValue);
				return;
			case SDPackage.SD_FRAME__MESSAGES:
				getMessages().clear();
				getMessages().addAll((Collection<? extends SDAbstractMessage>)newValue);
				return;
			case SDPackage.SD_FRAME__GATES:
				getGates().clear();
				getGates().addAll((Collection<? extends SDGate>)newValue);
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
			case SDPackage.SD_FRAME__UML_INTERACTION:
				setUmlInteraction((Interaction)null);
				return;
			case SDPackage.SD_FRAME__LIFELINES:
				getLifelines().clear();
				return;
			case SDPackage.SD_FRAME__MESSAGES:
				getMessages().clear();
				return;
			case SDPackage.SD_FRAME__GATES:
				getGates().clear();
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
			case SDPackage.SD_FRAME__UML_INTERACTION:
				return umlInteraction != null;
			case SDPackage.SD_FRAME__LIFELINES:
				return lifelines != null && !lifelines.isEmpty();
			case SDPackage.SD_FRAME__MESSAGES:
				return messages != null && !messages.isEmpty();
			case SDPackage.SD_FRAME__GATES:
				return gates != null && !gates.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * Intentionally not exposed in API, only SDBuilder is expected to call this method (via cast to implementation).
	 * Clients are guarded from calling this because implementation package is not exposed to external plugins.
	 */
	public void setUMLTracing(SDTrace tracing){
		myUMLTracing = tracing;
	}

} //SDFrameImpl
