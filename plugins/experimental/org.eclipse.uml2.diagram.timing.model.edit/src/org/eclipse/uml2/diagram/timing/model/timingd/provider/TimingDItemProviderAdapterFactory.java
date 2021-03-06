/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimingDItemProviderAdapterFactory.java,v 1.1 2008/09/09 17:03:21 mgolubev Exp $
 */
package org.eclipse.uml2.diagram.timing.model.timingd.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.eclipse.uml2.diagram.timing.model.timingd.util.TimingDAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TimingDItemProviderAdapterFactory extends TimingDAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingDItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.uml2.diagram.timing.model.timingd.DFrameContainer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DFrameContainerItemProvider dFrameContainerItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.uml2.diagram.timing.model.timingd.DFrameContainer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDFrameContainerAdapter() {
		if (dFrameContainerItemProvider == null) {
			dFrameContainerItemProvider = new DFrameContainerItemProvider(this);
		}

		return dFrameContainerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DFrameItemProvider dFrameItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.uml2.diagram.timing.model.timingd.DFrame}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDFrameAdapter() {
		if (dFrameItemProvider == null) {
			dFrameItemProvider = new DFrameItemProvider(this);
		}

		return dFrameItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.uml2.diagram.timing.model.timingd.DBlock} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DBlockItemProvider dBlockItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.uml2.diagram.timing.model.timingd.DBlock}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDBlockAdapter() {
		if (dBlockItemProvider == null) {
			dBlockItemProvider = new DBlockItemProvider(this);
		}

		return dBlockItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.uml2.diagram.timing.model.timingd.DValueLine} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DValueLineItemProvider dValueLineItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.uml2.diagram.timing.model.timingd.DValueLine}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDValueLineAdapter() {
		if (dValueLineItemProvider == null) {
			dValueLineItemProvider = new DValueLineItemProvider(this);
		}

		return dValueLineItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.uml2.diagram.timing.model.timingd.DSegment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DSegmentItemProvider dSegmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.uml2.diagram.timing.model.timingd.DSegment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDSegmentAdapter() {
		if (dSegmentItemProvider == null) {
			dSegmentItemProvider = new DSegmentItemProvider(this);
		}

		return dSegmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DSegmentElementItemProvider dSegmentElementItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDSegmentElementAdapter() {
		if (dSegmentElementItemProvider == null) {
			dSegmentElementItemProvider = new DSegmentElementItemProvider(this);
		}

		return dSegmentElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentMiddlePoint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DSegmentMiddlePointItemProvider dSegmentMiddlePointItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentMiddlePoint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDSegmentMiddlePointAdapter() {
		if (dSegmentMiddlePointItemProvider == null) {
			dSegmentMiddlePointItemProvider = new DSegmentMiddlePointItemProvider(this);
		}

		return dSegmentMiddlePointItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentStart} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DSegmentStartItemProvider dSegmentStartItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentStart}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDSegmentStartAdapter() {
		if (dSegmentStartItemProvider == null) {
			dSegmentStartItemProvider = new DSegmentStartItemProvider(this);
		}

		return dSegmentStartItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentEnd} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DSegmentEndItemProvider dSegmentEndItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.uml2.diagram.timing.model.timingd.DSegmentEnd}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDSegmentEndAdapter() {
		if (dSegmentEndItemProvider == null) {
			dSegmentEndItemProvider = new DSegmentEndItemProvider(this);
		}

		return dSegmentEndItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DStateSwitchItemProvider dStateSwitchItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDStateSwitchAdapter() {
		if (dStateSwitchItemProvider == null) {
			dStateSwitchItemProvider = new DStateSwitchItemProvider(this);
		}

		return dStateSwitchItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.uml2.diagram.timing.model.timingd.DMessage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DMessageItemProvider dMessageItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.uml2.diagram.timing.model.timingd.DMessage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDMessageAdapter() {
		if (dMessageItemProvider == null) {
			dMessageItemProvider = new DMessageItemProvider(this);
		}

		return dMessageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.uml2.diagram.timing.model.timingd.DInterval} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DIntervalItemProvider dIntervalItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.uml2.diagram.timing.model.timingd.DInterval}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDIntervalAdapter() {
		if (dIntervalItemProvider == null) {
			dIntervalItemProvider = new DIntervalItemProvider(this);
		}

		return dIntervalItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.uml2.diagram.timing.model.timingd.DPointConstraint} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DPointConstraintItemProvider dPointConstraintItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.uml2.diagram.timing.model.timingd.DPointConstraint}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDPointConstraintAdapter() {
		if (dPointConstraintItemProvider == null) {
			dPointConstraintItemProvider = new DPointConstraintItemProvider(this);
		}

		return dPointConstraintItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.uml2.diagram.timing.model.timingd.DTick} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DTickItemProvider dTickItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.uml2.diagram.timing.model.timingd.DTick}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDTickAdapter() {
		if (dTickItemProvider == null) {
			dTickItemProvider = new DTickItemProvider(this);
		}

		return dTickItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (dFrameContainerItemProvider != null) dFrameContainerItemProvider.dispose();
		if (dFrameItemProvider != null) dFrameItemProvider.dispose();
		if (dBlockItemProvider != null) dBlockItemProvider.dispose();
		if (dValueLineItemProvider != null) dValueLineItemProvider.dispose();
		if (dSegmentItemProvider != null) dSegmentItemProvider.dispose();
		if (dSegmentElementItemProvider != null) dSegmentElementItemProvider.dispose();
		if (dSegmentMiddlePointItemProvider != null) dSegmentMiddlePointItemProvider.dispose();
		if (dSegmentStartItemProvider != null) dSegmentStartItemProvider.dispose();
		if (dSegmentEndItemProvider != null) dSegmentEndItemProvider.dispose();
		if (dStateSwitchItemProvider != null) dStateSwitchItemProvider.dispose();
		if (dMessageItemProvider != null) dMessageItemProvider.dispose();
		if (dIntervalItemProvider != null) dIntervalItemProvider.dispose();
		if (dPointConstraintItemProvider != null) dPointConstraintItemProvider.dispose();
		if (dTickItemProvider != null) dTickItemProvider.dispose();
	}

}
