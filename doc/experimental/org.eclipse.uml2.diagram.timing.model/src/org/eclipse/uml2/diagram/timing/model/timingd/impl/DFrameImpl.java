/**
 * <copyright>
 * </copyright>
 *
 * $Id: DFrameImpl.java,v 1.1 2008/09/06 19:44:14 mgolubev Exp $
 */
package org.eclipse.uml2.diagram.timing.model.timingd.impl;

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

import org.eclipse.uml2.diagram.timing.model.timingd.DBlock;
import org.eclipse.uml2.diagram.timing.model.timingd.DFrame;
import org.eclipse.uml2.diagram.timing.model.timingd.DInterval;
import org.eclipse.uml2.diagram.timing.model.timingd.TimingDPackage;

import org.eclipse.uml2.uml.Interaction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DFrame</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DFrameImpl#getInteraction <em>Interaction</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DFrameImpl#getDisplayName <em>Display Name</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DFrameImpl#getBlocks <em>Blocks</em>}</li>
 *   <li>{@link org.eclipse.uml2.diagram.timing.model.timingd.impl.DFrameImpl#getIntervals <em>Intervals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DFrameImpl extends EObjectImpl implements DFrame {
	/**
	 * The cached value of the '{@link #getInteraction() <em>Interaction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteraction()
	 * @generated
	 * @ordered
	 */
	protected Interaction interaction;

	/**
	 * The default value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISPLAY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDisplayName() <em>Display Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayName()
	 * @generated
	 * @ordered
	 */
	protected String displayName = DISPLAY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBlocks() <em>Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<DBlock> blocks;

	/**
	 * The cached value of the '{@link #getIntervals() <em>Intervals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntervals()
	 * @generated
	 * @ordered
	 */
	protected EList<DInterval> intervals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DFrameImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TimingDPackage.Literals.DFRAME;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction getInteraction() {
		if (interaction != null && ((EObject)interaction).eIsProxy()) {
			InternalEObject oldInteraction = (InternalEObject)interaction;
			interaction = (Interaction)eResolveProxy(oldInteraction);
			if (interaction != oldInteraction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TimingDPackage.DFRAME__INTERACTION, oldInteraction, interaction));
			}
		}
		return interaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Interaction basicGetInteraction() {
		return interaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteraction(Interaction newInteraction) {
		Interaction oldInteraction = interaction;
		interaction = newInteraction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingDPackage.DFRAME__INTERACTION, oldInteraction, interaction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplayName(String newDisplayName) {
		String oldDisplayName = displayName;
		displayName = newDisplayName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimingDPackage.DFRAME__DISPLAY_NAME, oldDisplayName, displayName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DBlock> getBlocks() {
		if (blocks == null) {
			blocks = new EObjectContainmentWithInverseEList<DBlock>(DBlock.class, this, TimingDPackage.DFRAME__BLOCKS, TimingDPackage.DBLOCK__FRAME);
		}
		return blocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DInterval> getIntervals() {
		if (intervals == null) {
			intervals = new EObjectContainmentEList<DInterval>(DInterval.class, this, TimingDPackage.DFRAME__INTERVALS);
		}
		return intervals;
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
			case TimingDPackage.DFRAME__BLOCKS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBlocks()).basicAdd(otherEnd, msgs);
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
			case TimingDPackage.DFRAME__BLOCKS:
				return ((InternalEList<?>)getBlocks()).basicRemove(otherEnd, msgs);
			case TimingDPackage.DFRAME__INTERVALS:
				return ((InternalEList<?>)getIntervals()).basicRemove(otherEnd, msgs);
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
			case TimingDPackage.DFRAME__INTERACTION:
				if (resolve) return getInteraction();
				return basicGetInteraction();
			case TimingDPackage.DFRAME__DISPLAY_NAME:
				return getDisplayName();
			case TimingDPackage.DFRAME__BLOCKS:
				return getBlocks();
			case TimingDPackage.DFRAME__INTERVALS:
				return getIntervals();
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
			case TimingDPackage.DFRAME__INTERACTION:
				setInteraction((Interaction)newValue);
				return;
			case TimingDPackage.DFRAME__DISPLAY_NAME:
				setDisplayName((String)newValue);
				return;
			case TimingDPackage.DFRAME__BLOCKS:
				getBlocks().clear();
				getBlocks().addAll((Collection<? extends DBlock>)newValue);
				return;
			case TimingDPackage.DFRAME__INTERVALS:
				getIntervals().clear();
				getIntervals().addAll((Collection<? extends DInterval>)newValue);
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
			case TimingDPackage.DFRAME__INTERACTION:
				setInteraction((Interaction)null);
				return;
			case TimingDPackage.DFRAME__DISPLAY_NAME:
				setDisplayName(DISPLAY_NAME_EDEFAULT);
				return;
			case TimingDPackage.DFRAME__BLOCKS:
				getBlocks().clear();
				return;
			case TimingDPackage.DFRAME__INTERVALS:
				getIntervals().clear();
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
			case TimingDPackage.DFRAME__INTERACTION:
				return interaction != null;
			case TimingDPackage.DFRAME__DISPLAY_NAME:
				return DISPLAY_NAME_EDEFAULT == null ? displayName != null : !DISPLAY_NAME_EDEFAULT.equals(displayName);
			case TimingDPackage.DFRAME__BLOCKS:
				return blocks != null && !blocks.isEmpty();
			case TimingDPackage.DFRAME__INTERVALS:
				return intervals != null && !intervals.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (displayName: ");
		result.append(displayName);
		result.append(')');
		return result.toString();
	}

} //DFrameImpl