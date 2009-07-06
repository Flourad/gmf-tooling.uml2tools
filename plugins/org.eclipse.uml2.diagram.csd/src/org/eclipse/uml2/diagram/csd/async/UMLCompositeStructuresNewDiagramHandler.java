package org.eclipse.uml2.diagram.csd.async;

import java.util.List;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.diagram.common.part.NewDiagramHandlerBase;
import org.eclipse.uml2.diagram.csd.part.UMLDiagramEditorUtil;
import org.eclipse.uml2.diagram.csd.part.UMLNewDiagramFileWizard;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * @generated
 */
public class UMLCompositeStructuresNewDiagramHandler extends NewDiagramHandlerBase {

	/**
	 * @generated
	 */
	@Override
	protected Wizard getNewDiagramWizard(Package diagramRoot) {
		return new UMLNewDiagramFileWizard(getDiagramFileURI(diagramRoot), diagramRoot, getEditingDomain());
	}

	/**
	 * @generated
	 */
	@Override
	protected Wizard getNewSemiSyncDiagramWizard(Package diagramRoot, List<Element> selectedElements) {
		return new UMLCompositeStructuresFixedElementsWizard(getDiagramFileURI(diagramRoot), diagramRoot, selectedElements.toArray(new Element[selectedElements.size()]), getEditingDomain());
	}

	/**
	 * @generated
	 */
	@Override
	protected void runWizard(Wizard wizard, Shell sh) {
		UMLDiagramEditorUtil.runWizard(sh, wizard, "InitDiagramFile"); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	@Override
	protected Element getValidElement(Object object) {
		Element element = NewDiagramPropertyTester.resolve(object);
		if (NewDiagramPropertyTester.isUMLCompositeStructuresElement(element)) {
			return element;
		}
		return null;
	}
}
