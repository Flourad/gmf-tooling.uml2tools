package org.eclipse.uml2.diagram.codegen;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.codegen.gmfgen.Attributes;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GenCustomPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenPreferencePage;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.gmf.codegen.util.Generator;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.common.codegen.TextMerger;
import org.eclipse.uml2.diagram.codegen.u2tgen.LinkToolStackSupportAttribute;
import org.eclipse.uml2.diagram.codegen.u2tgen.SubstitutableByAttributes;
import org.eclipse.uml2.uml.UMLPackage;

public class GeneratorExt extends Generator {

	private final GenDiagram myDiagram;

	private final CodegenEmittersExt myEmitters;

	public GeneratorExt(GenEditorGenerator genModel, CodegenEmittersExt emitters) {
		super(genModel, emitters);
		myDiagram = genModel.getDiagram();
		myEmitters = emitters;
	}

	@Override
	protected TextMerger createMergeService() {
		// see #181484, temporary workaround
		final TextMerger defaultMerger = super.createMergeService();
		return new TextMerger() {

			@Override
			public String process(String fileNameExt, String oldText, String newText) {
				if ("properties".equals(fileNameExt) && newText != null && newText.contains("#seeBugzilla=181484")) {
					return newText;
				}
				return defaultMerger.process(fileNameExt, oldText, newText);
			}

			@Override
			public String mergeJava(String oldText, String newText) {
				return defaultMerger.mergeJava(oldText, newText);
			}

			@Override
			public String mergeProperties(String oldText, String newText) {
				return defaultMerger.mergeProperties(oldText, newText);
			}

			@Override
			public String mergeXML(String oldText, String newText) {
				return defaultMerger.mergeXML(oldText, newText);
			}
		};
	}

	@Override
	protected void customRun() throws InterruptedException, UnexpectedBehaviourException {
		super.customRun();
		for (GenNode node : myDiagram.getAllNodes()) {
			generateChangeNotationAction(node);
		}
		generateIconStylePreferencesPage(myDiagram);
		generateIconStylePreferencesHelper(myDiagram);
		generateViewFiltersPreferencesPage(myDiagram);
		generateSwitchBetweenCommentAndNodeActions();
		generatePaletteProvider(myDiagram);
		generateSynchronizationWizardPage(myDiagram);
		generateNewDiagramHadler(myDiagram);
		generateCreateDependencyLinkTool(myDiagram);
		generateVisualIDRegistyExt(myDiagram);
	 }

	private void generateSwitchBetweenCommentAndNodeActions() throws InterruptedException, UnexpectedBehaviourException {
		GenTopLevelNode commentNode = null;
		for (GenTopLevelNode nextNode : myDiagram.getTopLevelNodes()) {
			TypeModelFacet modelFacet = nextNode.getModelFacet();
			if (modelFacet == null || modelFacet.getMetaClass() == null) {
				continue;
			}
			EClass metaclass = modelFacet.getMetaClass().getEcoreClass();
			if (isTheSameEClass(metaclass, UMLPackage.eINSTANCE.getComment())) {
				commentNode = nextNode;
				break;
			}
		}
		if (commentNode == null) {
			return;
		}

		GenLink commentLink = null;
		for (GenLink nextLink : commentNode.getGenOutgoingLinks()) {
			if (false == nextLink.getModelFacet() instanceof FeatureLinkModelFacet) {
				continue;
			}
			FeatureLinkModelFacet facet = (FeatureLinkModelFacet) nextLink.getModelFacet();
			if (facet.getMetaFeature() == null) {
				continue;
			}
			if (isTheSameEFeature(facet.getMetaFeature().getEcoreFeature(), UMLPackage.eINSTANCE.getComment_AnnotatedElement())) {
				commentLink = nextLink;
				break;
			}
		}

		if (commentLink == null) {
			return;
		}

		doGenerateJavaClass(//
				myEmitters.getTurnCommentIntoNoteEmitter(), // 
				myEmitters.getTurnCommentIntoNoteActionFQN(myDiagram), // 
				myDiagram, commentNode, commentLink);

		doGenerateJavaClass(//
				myEmitters.getTurnNoteIntoCommentEmitter(), // 
				myEmitters.getTurnNoteIntoCommentActionFQN(myDiagram), // 
				myDiagram, commentNode, commentLink);

	}

	private void generateChangeNotationAction(GenNode node) throws InterruptedException, UnexpectedBehaviourException {
		for (org.eclipse.gmf.codegen.gmfgen.Attributes attr : node.getViewmap().getAttributes()) {
			if (false == attr instanceof SubstitutableByAttributes) {
				continue;
			}
			SubstitutableByAttributes sba = (SubstitutableByAttributes) attr;
			if (sba.isRequiresAll()) {
				return;
			}
			doGenerateJavaClass(myEmitters.getChangeNotationContributionItemProviderEmitter(), myEmitters.getChangeNotationContributionItemProviderName(new Object[] { node }), node);
			for (Object substitutableByNode : sba.getSubstitutableByNodes()) {
				doGenerateJavaClass(myEmitters.getChangeNotationActionEmitter(), myEmitters.getChangeNotationActionName(new Object[] { node, substitutableByNode }), node, substitutableByNode);
			}
			// we process only the first attribute
			return;
		}
	}

	private void generateIconStylePreferencesPage(GenDiagram diagram) throws InterruptedException, UnexpectedBehaviourException {
		doGenerateJavaClass(//
				myEmitters.getIconStylePreferencePageEmitter(), //
				myEmitters.getIconStylePreferencePageFQN(new Object[] { diagram }), //
				diagram);
	}

	private void generateIconStylePreferencesHelper(GenDiagram diagram) throws InterruptedException, UnexpectedBehaviourException {
		doGenerateJavaClass(//
				myEmitters.getIconStylePreferenceHelperEmitter(), //
				myEmitters.getIconStylePreferenceHelperFQN(new Object[] { diagram }), //
				diagram);
	}

	private void generateViewFiltersPreferencesPage(GenDiagram diagram) throws InterruptedException, UnexpectedBehaviourException {
		for (GenPreferencePage page : diagram.getPreferencePages()) {
			generateViewFiltersPreferencesPage(page);
		}
	}

	private void generateViewFiltersPreferencesPage(GenPreferencePage page) throws InterruptedException, UnexpectedBehaviourException {
		if (page instanceof GenCustomPreferencePage && myEmitters.isViewFiltersPreferencePage(new Object[] { page })) {
			doGenerateJavaClass(//
					myEmitters.getViewFiltersPreferencePageEmitter(), //
					myEmitters.getViewFiltersPreferencePageFQN(new Object[] { page }), //
					page);
		}
		for (GenPreferencePage child : page.getChildren()) {
			generateViewFiltersPreferencesPage(child);
		}
	}

	private void generatePaletteProvider(GenDiagram diagram) throws InterruptedException, UnexpectedBehaviourException {
		if (myEmitters.isPaletteProviderNeeded(new Object[] { diagram })) {
			doGenerateJavaClass(myEmitters.getPaletteProviderEmitter(), myEmitters.getPaletteProviderFQN(new Object[] { diagram }), diagram);
		}
	}

	private void generateSynchronizationWizardPage(GenDiagram diagram) throws InterruptedException, UnexpectedBehaviourException {
		if (myEmitters.needsSynchronizationWizardPage(new Object[] { diagram })) {
			doGenerateJavaClass(myEmitters.getSynchronizationWizardPageEmitter(), myEmitters.getSynchronizationWizardPagedFQN(new Object[] { diagram }), diagram);
		}
	}

	private void generateNewDiagramHadler(GenDiagram diagram) throws InterruptedException, UnexpectedBehaviourException {
		if (myEmitters.needsFixedElementsWizard(new Object[] { diagram })) {
			doGenerateJavaClass(myEmitters.getFixedElementsWizardEmitter(), myEmitters.getFixedElementsWizardFQN(new Object[] { diagram }), diagram);
			doGenerateJavaClass(myEmitters.getNewDiagramHandlerEmitter(), myEmitters.getNewDiagramHandlerFQN(new Object[] { diagram }), diagram);
			doGenerateJavaClass(myEmitters.getNewDiagramPropertyTesterEmitter(), myEmitters.getNewDiagramPropertyTesterFQN(new Object[] { diagram }), diagram);
		}
	}

	private void generateCreateDependencyLinkTool(GenDiagram diagram) throws InterruptedException, UnexpectedBehaviourException {
		for (GenLink next : myDiagram.getLinks()) {
			List<Attributes> attributes = next.getViewmap().getAttributes(); 
			for (Attributes attribute : attributes) {
				if (attribute instanceof LinkToolStackSupportAttribute) {
					generateCreateLinkToolStackLink(next); 
				}
			} 
		}
	}

	private void generateCreateLinkToolStackLink(GenLink link) throws InterruptedException, UnexpectedBehaviourException {
		doGenerateJavaClass(myEmitters.getCreateLinkToolStackLinkEmitter(), myEmitters.getCreateLinkToolStackLinkFQN(new Object[] { link }), link);
	}

	private static boolean isTheSameEClass(EClass candidate, EClass pattern) {
		if (pattern.equals(candidate)) {
			return true;
		}
		if (candidate == null) {
			return false;
		}
		// its possible that they are loaded separately and not equals
		return pattern.getEPackage().getNsURI().equals(candidate.getEPackage().getNsURI()) && pattern.getName().equals(candidate.getName());
	}

	private static boolean isTheSameEFeature(EStructuralFeature candidate, EStructuralFeature pattern) {
		if (candidate.equals(pattern)) {
			return true;
		}
		if (candidate == null) {
			return false;
		}
		return isTheSameEClass(candidate.getEContainingClass(), pattern.getEContainingClass()) && pattern.getName().equals(candidate.getName());
	}

	private void generateVisualIDRegistyExt(GenDiagram diagram) throws InterruptedException, UnexpectedBehaviourException {
		doGenerateJavaClass(myEmitters.getVisualIdRegistryExtEmitter(), myEmitters.getVisualIdRegistryExtFQN(new Object[] { diagram }), diagram);
	}
}
