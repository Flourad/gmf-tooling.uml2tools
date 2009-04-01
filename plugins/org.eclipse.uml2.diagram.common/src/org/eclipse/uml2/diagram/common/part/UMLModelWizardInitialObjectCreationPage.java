package org.eclipse.uml2.diagram.common.part;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This is a copy of standard <code>ModelWizardInitialObjectCreationPage</code>
 * class generated by EMF. The difference is the following: <li>BaseClass is
 * given in the constructor</li> <li>Initial Object Names list is not hardcoded,
 * it is calculated as all subtypes of the BaseClass.</li> <li>There always a
 * default Intial Object which is the BaseClass.</li>
 */
public class UMLModelWizardInitialObjectCreationPage extends WizardPage {

	protected List<String> initialObjectNames;

	protected UMLPackage umlPackage = UMLPackage.eINSTANCE;

	protected Combo initialObjectField;

	protected List<String> encodings;

	protected Combo encodingField;

	private final EClass baseClass;

	public UMLModelWizardInitialObjectCreationPage(String pageId, EClass bc) {
		super(pageId);
		baseClass = bc;
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		{
			GridLayout layout = new GridLayout();
			layout.numColumns = 1;
			layout.verticalSpacing = 12;
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			composite.setLayoutData(data);
		}

		Label containerLabel = new Label(composite, SWT.LEFT);
		{
			containerLabel.setText("Model Object");

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			containerLabel.setLayoutData(data);
		}

		initialObjectField = new Combo(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			initialObjectField.setLayoutData(data);
		}

		for (String objectName : getInitialObjectNames()) {
			initialObjectField.add(getLabel(objectName));
		}
		// tfesenko always set default value for initial object
		if (initialObjectField.getItemCount() > 1) {
			initialObjectField.select(0);
		}
		initialObjectField.addModifyListener(validator);

		Label encodingLabel = new Label(composite, SWT.LEFT);
		{
			encodingLabel.setText("XML Encoding");

			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			encodingLabel.setLayoutData(data);
		}
		encodingField = new Combo(composite, SWT.BORDER);
		{
			GridData data = new GridData();
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			encodingField.setLayoutData(data);
		}

		for (String encoding : getEncodings()) {
			encodingField.add(encoding);
		}

		encodingField.select(0);
		encodingField.addModifyListener(validator);

		setPageComplete(validatePage());
		setControl(composite);
	}

	protected ModifyListener validator = new ModifyListener() {

		public void modifyText(ModifyEvent e) {
			setPageComplete(validatePage());
		}
	};

	protected boolean validatePage() {
		return getInitialObjectName() != null && getEncodings().contains(encodingField.getText());
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			if (initialObjectField.getItemCount() == 1) {
				initialObjectField.clearSelection();
				encodingField.setFocus();
			} else {
				encodingField.clearSelection();
				initialObjectField.setFocus();
			}
		}
	}

	public String getInitialObjectName() {
		String label = initialObjectField.getText();

		for (String name : getInitialObjectNames()) {
			if (getLabel(name).equals(label)) {
				return name;
			}
		}
		return null;
	}

	public String getEncoding() {
		return encodingField.getText();
	}

	protected String getLabel(String typeName) {
		// TODO
		// try {
		// return UMLDiagramEditorPlugin.getInstance()
		//				.getString("_UI_" + typeName + "_type"); //$NON-NLS-1$ //$NON-NLS-2$
		// } catch (MissingResourceException mre) {
		// UMLEditorPlugin.INSTANCE.log(mre);
		// }
		return typeName;
	}

	protected Collection<String> getEncodings() {
		if (encodings == null) {
			encodings = new ArrayList<String>();
			for (StringTokenizer stringTokenizer = new StringTokenizer(" UTF-8 ASCII UTF-16 UTF-16BE UTF-16LE ISO-8859-1"); stringTokenizer.hasMoreTokens();) {
				encodings.add(stringTokenizer.nextToken());
			}
		}
		return encodings;
	}

	protected Collection<String> getInitialObjectNames() {
		if (initialObjectNames == null) {
			initialObjectNames = new ArrayList<String>();
			Collection<EClass> types = getAllSubTypes(baseClass);
			for (EClass next : types) {
				initialObjectNames.add(next.getName());
			}
		}
		return initialObjectNames;
	}

	private Collection<EClass> getAllSubTypes(EClass baseClass) {
		List<EClass> result = new LinkedList<EClass>();
		TreeIterator<EObject> contents = umlPackage.eAllContents();
		// add original class first
		result.add(baseClass);
		while (contents.hasNext()) {
			EObject next = contents.next();
			if (next instanceof EClass) {
				EClass eclass = (EClass) next;
				if (!eclass.isAbstract() && baseClass.isSuperTypeOf(eclass) && !eclass.equals(baseClass)) {
					result.add(eclass);
				}
			}
		}
		return result;
	}

}
