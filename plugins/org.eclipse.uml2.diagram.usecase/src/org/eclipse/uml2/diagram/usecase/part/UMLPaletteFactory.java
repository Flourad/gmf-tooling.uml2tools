package org.eclipse.uml2.diagram.usecase.part;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.uml2.diagram.common.part.LinkToolEntry;
import org.eclipse.uml2.diagram.common.part.NodeToolEntry;
import org.eclipse.uml2.diagram.usecase.providers.UMLElementTypes;

/**
 * @generated
 */
public class UMLPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createChildren2Group());
		paletteRoot.add(createLinks3Group());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Nodes1Group_desc);

		paletteContainer.add(createUseCase1CreationTool());
		paletteContainer.add(createActor2CreationTool());
		paletteContainer.add(createSubject3CreationTool());
		paletteContainer.add(createPackage4CreationTool());
		paletteContainer.add(createConstraint5CreationTool());
		paletteContainer.add(createComment6CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Children" palette tool group
	 * @generated
	 */
	private PaletteContainer createChildren2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Children2Group_title);
		paletteContainer.setId("createChildren2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Children2Group_desc);

		paletteContainer.add(createExtensionPoint1CreationTool());
		paletteContainer.add(createElementImport2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinks3Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Links3Group_title);
		paletteContainer.setId("createLinks3Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Links3Group_desc);

		paletteContainer.add(createAssociation1CreationTool());
		paletteContainer.add(createExtend2CreationTool());
		paletteContainer.add(createInclude3CreationTool());
		paletteContainer.add(createGeneralization4CreationTool());
		paletteContainer.add(createConstrainedElement5CreationTool());
		paletteContainer.add(createDependency6CreationTool());
		paletteContainer.add(createAnnotatedElement7CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUseCase1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(UMLElementTypes.UseCase_2003);
		types.add(UMLElementTypes.UseCase_3004);
		types.add(UMLElementTypes.UseCase_3006);
		NodeToolEntry entry = new NodeToolEntry(Messages.UseCase1CreationTool_title, Messages.UseCase1CreationTool_desc, types);

		entry.setId("createUseCase1CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.UseCase_2003));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActor2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.Actor_2002);
		types.add(UMLElementTypes.Actor_3005);
		NodeToolEntry entry = new NodeToolEntry(Messages.Actor2CreationTool_title, Messages.Actor2CreationTool_desc, types);

		entry.setId("createActor2CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Actor_2002));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubject3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Subject3CreationTool_title, Messages.Subject3CreationTool_desc, Collections.singletonList(UMLElementTypes.Component_2006));

		entry.setId("createSubject3CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Component_2006));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPackage4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Package4CreationTool_title, Messages.Package4CreationTool_desc, Collections.singletonList(UMLElementTypes.Package_2007));

		entry.setId("createPackage4CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Package_2007));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstraint5CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Constraint5CreationTool_title, Messages.Constraint5CreationTool_desc, Collections.singletonList(UMLElementTypes.Constraint_2008));

		entry.setId("createConstraint5CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Constraint_2008));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComment6CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Comment6CreationTool_title, Messages.Comment6CreationTool_desc, Collections.singletonList(UMLElementTypes.Comment_2009));

		entry.setId("createComment6CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Comment_2009));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExtensionPoint1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(UMLElementTypes.ExtensionPoint_3002);
		types.add(UMLElementTypes.ExtensionPoint_3003);
		NodeToolEntry entry = new NodeToolEntry(Messages.ExtensionPoint1CreationTool_title, Messages.ExtensionPoint1CreationTool_desc, types);

		entry.setId("createExtensionPoint1CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ExtensionPoint_3002));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createElementImport2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.ElementImport2CreationTool_title, Messages.ElementImport2CreationTool_desc, Collections.singletonList(UMLElementTypes.ElementImport_3001));

		entry.setId("createElementImport2CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ElementImport_3001));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Association1CreationTool_title, Messages.Association1CreationTool_desc, Collections.singletonList(UMLElementTypes.Association_4004));

		entry.setId("createAssociation1CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Association_4004));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExtend2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Extend2CreationTool_title, Messages.Extend2CreationTool_desc, Collections.singletonList(UMLElementTypes.Extend_4002));

		entry.setId("createExtend2CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Extend_4002));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInclude3CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Include3CreationTool_title, Messages.Include3CreationTool_desc, Collections.singletonList(UMLElementTypes.Include_4001));

		entry.setId("createInclude3CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Include_4001));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralization4CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Generalization4CreationTool_title, Messages.Generalization4CreationTool_desc, Collections.singletonList(UMLElementTypes.Generalization_4003));

		entry.setId("createGeneralization4CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Generalization_4003));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstrainedElement5CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.ConstrainedElement5CreationTool_title, Messages.ConstrainedElement5CreationTool_desc,
				Collections.singletonList(UMLElementTypes.ConstraintConstrainedElement_4005));

		entry.setId("createConstrainedElement5CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.ConstraintConstrainedElement_4005));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependency6CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Dependency6CreationTool_title, Messages.Dependency6CreationTool_desc, Collections.singletonList(UMLElementTypes.Dependency_4006));

		entry.setId("createDependency6CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.Dependency_4006));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnnotatedElement7CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.AnnotatedElement7CreationTool_title, Messages.AnnotatedElement7CreationTool_desc,
				Collections.singletonList(UMLElementTypes.CommentAnnotatedElement_4007));

		entry.setId("createAnnotatedElement7CreationTool"); //$NON-NLS-1$

		entry.setSmallIcon(UMLElementTypes.getImageDescriptor(UMLElementTypes.CommentAnnotatedElement_4007));

		entry.setLargeIcon(entry.getSmallIcon());

		return entry;
	}
}
