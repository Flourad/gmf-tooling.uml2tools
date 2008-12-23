package org.eclipse.uml2.diagram.common.sheet.chooser;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.uml2.uml.ElementImport;

public class ReferencedElementChooserDialog extends TrayDialog {

	private final static int UNSET_BUTTON_ID = IDialogConstants.NO_TO_ALL_ID + 1;

	private TabFolder myTabFolder;
	
	private ElementChooserPage myCurrentPage;
	
	private final IDialogSettings myDialogSettings;
	
	private final String mySettingsKeyLastFocus = "ReferencedElementDialog.KeyLastFocus";

	private final AdapterFactory myItemProvidersAdapterFactory;

	private final EObject mySourceObject;

	private final EStructuralFeature myFeature;

	public  URI mySelectedModelElementURI;

	public ReferencedElementChooserDialog(Shell shell, IDialogSettings settings, AdapterFactory itemProvidersAdapterFactory, EObject sourceObject, EStructuralFeature feature) {
		super(shell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		myDialogSettings = settings;
		myItemProvidersAdapterFactory = itemProvidersAdapterFactory;
		mySourceObject = sourceObject;
		myFeature = feature;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite composite = (Composite) super.createDialogArea(parent);

		myTabFolder = new TabFolder(composite, SWT.NONE);
		myTabFolder.setFont(composite.getFont());
		GridData layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.heightHint = 300;
		layoutData.widthHint = 300;
		myTabFolder.setLayoutData(layoutData);
		
		ElementTreeChooser treeChooserTab = new ElementTreeChooser(myItemProvidersAdapterFactory, mySourceObject);
		addTabPage("Choose from a Tree", treeChooserTab);
		treeChooserTab.addSelectionListener(new OkButtonEnabler());

		addTabPage("Choose from a List", new ElementFilteredListChooser(myItemProvidersAdapterFactory, mySourceObject, myFeature));

//		myTabFolder.setSelection(myCurrPageIndex);
		myCurrentPage= (ElementChooserPage) myTabFolder.getSelection()[0].getData();
		myTabFolder.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {}
			public void widgetSelected(SelectionEvent e) {
				tabChanged((TabItem)e.item);
				// XXX remove check, but give a valid settings
				if (myDialogSettings != null) {
					myDialogSettings.put(mySettingsKeyLastFocus, myTabFolder.getSelectionIndex());
				}
			}
		});
		
		return composite;
	}
	
	public static EObject accept(EObject selectedElement, EStructuralFeature feature) {
		if (selectedElement instanceof ElementImport){
			ElementImport _import = (ElementImport)selectedElement;
			selectedElement = _import.getImportedElement();
		}
		if (selectedElement != null && feature.getEType().isInstance(selectedElement)){
			return selectedElement;
		}
		return null;
	}

	private void tabChanged(TabItem tabItem) {
		ElementChooserPage newPage = (ElementChooserPage) tabItem.getData();
		tabItem.getControl().setFocus();
		if (myCurrentPage != null) {
			Object selection = myCurrentPage.getSelection();
			if (selection != null) {
				newPage.setSelection(selection);
			}
		}
		// XXX add OK button listener to filtered tree
		if (newPage instanceof FilteredTree) {
			setOkButtonEnabled(true);
		}
		myCurrentPage = newPage;
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// create OK and Cancel buttons by default
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, UNSET_BUTTON_ID, "Unset", false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (UNSET_BUTTON_ID == buttonId) {
			unsetPressed();			
		} else {
			super.buttonPressed(buttonId);
		}
	}

	private void unsetPressed() {
		mySelectedModelElementURI = null;
		close();
	}

	@Override
	protected void okPressed() {
		EObject selectedModelElement = (EObject) ((ElementChooserPage)myTabFolder.getSelection()[0].getData()).getSelection();
		mySelectedModelElementURI = EcoreUtil.getURI(selectedModelElement);
		super.okPressed();
	}

	public URI getResult() {
		return mySelectedModelElementURI;
    }

	
	protected final void addTabPage(String title, ElementChooserPage tabPage) {
		final TabItem tabItem= new TabItem(myTabFolder, SWT.NONE);
		applyDialogFont(tabItem.getControl());
		tabItem.setText(title);
		tabItem.setData(tabPage);
		tabItem.setControl(tabPage.createControl(myTabFolder));
	}

	
	@Override
	public void create() {
		super.create();
		int lastFocusNr = 0;
		try {
			// XXX remove check, but give a valid settings
			if (myDialogSettings != null) {
				lastFocusNr = myDialogSettings.getInt(mySettingsKeyLastFocus);
			}
			if (lastFocusNr < 0 || lastFocusNr > myTabFolder.getItemCount()) {
				lastFocusNr = 0;
			}
		} catch (NumberFormatException x) {
			lastFocusNr = 0;
		}

		myTabFolder.setSelection(lastFocusNr);
		((ElementChooserPage) myTabFolder.getSelection()[0].getData()).setSelection(getInitialSelection());
	}
	
	private Object getInitialSelection() {
		return mySourceObject.eGet(myFeature);
	}

	private void setOkButtonEnabled(boolean enabled) {
		getButton(IDialogConstants.OK_ID).setEnabled(enabled);
	}

	private class OkButtonEnabler implements ISelectionChangedListener {

		public void selectionChanged(SelectionChangedEvent event) {
			if (event.getSelection() instanceof IStructuredSelection) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				if (selection.size() == 1) {
					Object selectedElement = selection.getFirstElement();
					if (selectedElement instanceof IWrapperItemProvider) {
						selectedElement = ((IWrapperItemProvider) selectedElement).getValue();
					}
					if (selectedElement instanceof FeatureMap.Entry) {
						selectedElement = ((FeatureMap.Entry) selectedElement).getValue();
					}
					if (selectedElement instanceof EObject) {
						EObject selectedModelElement = (EObject) selectedElement;
						selectedElement = accept(selectedModelElement, myFeature);
						setOkButtonEnabled(selectedModelElement != null);
						return;
					}
				}
			}
			setOkButtonEnabled(false);
		}
	}

}