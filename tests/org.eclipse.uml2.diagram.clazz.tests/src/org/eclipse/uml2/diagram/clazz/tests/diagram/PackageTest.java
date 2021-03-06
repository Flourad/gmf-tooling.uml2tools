package org.eclipse.uml2.diagram.clazz.tests.diagram;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.uml2.diagram.clazz.edit.parts.Package3EditPart;
import org.eclipse.uml2.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.diagram.clazz.tests.tool.ClassDiagramCreationToolTest;
import org.eclipse.uml2.diagram.common.tests.UMLDiagramFacade;

public class PackageTest extends ClassDiagramCreationToolTest {

	public PackageTest(String name) {
		super(name);
	}

	public void testDiagramCreation() {
		DiagramEditPart diagram = getDiagramEditPart();
		assertNotNull("DiagramEditPart was not created", diagram);
	}

	public void testSecondaryDiagramNodeCreation() {
		DiagramEditPart diagram = getDiagramEditPart();
		UMLDiagramFacade.flushEventQueue();
		assertNotNull("PackageEditPart was not created", diagram);
		IGraphicalEditPart secondaryNode = diagram.getChildBySemanticHint(UMLVisualIDRegistry.getType(Package3EditPart.VISUAL_ID));
		assertNotNull("SecondaryDiagramEditPart was not created", secondaryNode);
	}

}
