/**
 * <copyright>
 * </copyright>
 *
 * $Id: CustomLocatorAttributesImpl.java,v 1.2 2011/02/11 14:16:06 cwaniek Exp $
 */
package org.eclipse.uml2.diagram.codegen.u2tgen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.uml2.diagram.codegen.u2tgen.CustomLocatorAttributes;
import org.eclipse.uml2.diagram.codegen.u2tgen.U2TGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Locator Attributes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.uml2.diagram.codegen.u2tgen.impl.CustomLocatorAttributesImpl#getCustomLocatorFQN <em>Custom Locator FQN</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomLocatorAttributesImpl extends EObjectImpl implements CustomLocatorAttributes {
	/**
   * The default value of the '{@link #getCustomLocatorFQN() <em>Custom Locator FQN</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getCustomLocatorFQN()
   * @generated
   * @ordered
   */
	protected static final String CUSTOM_LOCATOR_FQN_EDEFAULT = null;

	/**
   * The cached value of the '{@link #getCustomLocatorFQN() <em>Custom Locator FQN</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getCustomLocatorFQN()
   * @generated
   * @ordered
   */
	protected String customLocatorFQN = CUSTOM_LOCATOR_FQN_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected CustomLocatorAttributesImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return U2TGenPackage.Literals.CUSTOM_LOCATOR_ATTRIBUTES;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public String getCustomLocatorFQN() {
    return customLocatorFQN;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setCustomLocatorFQN(String newCustomLocatorFQN) {
    String oldCustomLocatorFQN = customLocatorFQN;
    customLocatorFQN = newCustomLocatorFQN;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, U2TGenPackage.CUSTOM_LOCATOR_ATTRIBUTES__CUSTOM_LOCATOR_FQN, oldCustomLocatorFQN, customLocatorFQN));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case U2TGenPackage.CUSTOM_LOCATOR_ATTRIBUTES__CUSTOM_LOCATOR_FQN:
        return getCustomLocatorFQN();
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
    switch (featureID)
    {
      case U2TGenPackage.CUSTOM_LOCATOR_ATTRIBUTES__CUSTOM_LOCATOR_FQN:
        setCustomLocatorFQN((String)newValue);
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
    switch (featureID)
    {
      case U2TGenPackage.CUSTOM_LOCATOR_ATTRIBUTES__CUSTOM_LOCATOR_FQN:
        setCustomLocatorFQN(CUSTOM_LOCATOR_FQN_EDEFAULT);
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
    switch (featureID)
    {
      case U2TGenPackage.CUSTOM_LOCATOR_ATTRIBUTES__CUSTOM_LOCATOR_FQN:
        return CUSTOM_LOCATOR_FQN_EDEFAULT == null ? customLocatorFQN != null : !CUSTOM_LOCATOR_FQN_EDEFAULT.equals(customLocatorFQN);
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
    result.append(" (customLocatorFQN: ");
    result.append(customLocatorFQN);
    result.append(')');
    return result.toString();
  }

} //CustomLocatorAttributesImpl
