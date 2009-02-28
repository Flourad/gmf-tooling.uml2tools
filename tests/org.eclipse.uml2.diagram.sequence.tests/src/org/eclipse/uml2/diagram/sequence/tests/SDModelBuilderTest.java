package org.eclipse.uml2.diagram.sequence.tests;

import java.util.LinkedList;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.diagram.sequence.model.builder.LifeLineCallStack;
import org.eclipse.uml2.diagram.sequence.model.builder.SDBuilder;
import org.eclipse.uml2.diagram.sequence.model.builder.SDModelHelper;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDAbstractMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBehaviorSpec;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracket;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDBracketContainer;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDExecution;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDModel;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDInvocation;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDLifeLine;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDMessage;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDSimpleNode;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDTrace;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.UMLPackage;

public class SDModelBuilderTest extends TestCase {

	public void testPrecondition_LoadRedrawInteraction() {
		Package memoryGame = loadExampleFile(MEMORY_GAME_FILE);
		Interaction redraw = (Interaction) memoryGame.getPackagedElement("Redraw", true, UMLPackage.eINSTANCE.getInteraction(), false);
		assertNotNull(redraw);
	}

	public void testBuildNormalAndSelfMessage() {
		SDBuilder builder = buildFrame(MEMORY_GAME_FILE, "ReDraw");
		SDModel sdModel = builder.getSDModel();

		assertTrue(sdModel.getGates().isEmpty());
		assertFalse(sdModel.getLifelines().isEmpty());
		assertFalse(sdModel.getMessages().isEmpty());

		assertEquals(2, sdModel.getLifelines().size());
		assertEquals(2, sdModel.getMessages().size());

		SDMessage mouseClicked = (SDMessage) findMessageByName(sdModel, "mouseClicked");
		SDMessage redraw = (SDMessage) findMessageByName(sdModel, "reDraw");

		assertNotNull(redraw);
		assertNotNull(mouseClicked);
		assertFalse(redraw == mouseClicked);

		assertNotNull(mouseClicked.getSource());
		assertNotNull(mouseClicked.getTarget());

		assertNotNull(redraw.getSource());
		assertNotNull(redraw.getTarget());

		SDInvocation redrawInvocation = redraw.getSource();
		SDExecution redrawExecution = redraw.getTarget();

		assertNull(redrawInvocation.getUmlExecutionSpec());
		assertNotNull(redrawExecution.getUmlExecutionSpec());

		assertNotNull(SDModelHelper.findLifeline(redrawExecution));
		assertSame(SDModelHelper.findLifeline(redrawInvocation), SDModelHelper.findLifeline(redrawExecution));
		assertTrue(redrawInvocation.getBrackets().contains(redrawExecution));
	}

	public void testNormalMessageDetails() {
		SDBuilder builder = buildFrame(MEMORY_GAME_FILE, "ReDraw");
		SDModel sdModel = builder.getSDModel();

		SDMessage redraw = (SDMessage) findMessageByName(sdModel, "reDraw");

		assertNotNull(redraw);
		assertNotNull(redraw.getSource());
		assertNotNull(redraw.getTarget());

		SDInvocation redrawInvocation = redraw.getSource();
		SDExecution redrawExecution = redraw.getTarget();

		assertNull(redrawInvocation.getUmlExecutionSpec());
		assertNotNull(redrawExecution.getUmlExecutionSpec());

		assertNotNull(SDModelHelper.findLifeline(redrawExecution));
		assertSame(SDModelHelper.findLifeline(redrawInvocation), SDModelHelper.findLifeline(redrawExecution));
		assertTrue(redrawInvocation.getBrackets().contains(redrawExecution));

	}

	public void testSelfMessageDetails() {
		SDBuilder builder = buildFrame(MEMORY_GAME_FILE, "ReDraw");
		SDModel sdFrame = builder.getSDModel();

		SDMessage mouseClicked = (SDMessage) findMessageByName(sdFrame, "mouseClicked");
		assertNotNull(mouseClicked);

		SDInvocation mouseClickedInvocation = mouseClicked.getSource();
		SDExecution mouseClickedExecution = mouseClicked.getTarget();

		assertNotNull(mouseClickedExecution);
		assertNotNull(mouseClickedInvocation);

		assertNull(mouseClickedInvocation.getUmlExecutionSpec());
		assertNotNull(mouseClickedExecution.getUmlExecutionSpec());

		SDLifeLine sendingLifeline = SDModelHelper.findLifeline(mouseClickedInvocation);
		SDLifeLine receivingLifeline = SDModelHelper.findLifeline(mouseClickedExecution);

		assertNotNull(sendingLifeline);
		assertNotNull(receivingLifeline);
		assertNotSame(sendingLifeline, receivingLifeline);

		assertNotNull(sendingLifeline.getUmlLifeline());
		assertNotNull(receivingLifeline.getUmlLifeline());
		assertNotSame(sendingLifeline.getUmlLifeline(), receivingLifeline.getUmlLifeline());

		assertTrue(sendingLifeline.getBrackets().contains(mouseClickedInvocation));
		assertTrue(receivingLifeline.getBrackets().contains(mouseClickedExecution));
	}

	public void testCallStackCompleted() {
		SDBuilder builder = buildFrame(MEMORY_GAME_FILE, "ReDraw");
		checkCallStackCompleted(builder);
		checkTraces(builder);
	}

	public void testTwoMessagesCreatedFromDiagram() {
		SDBuilder builder = buildFrame("Two Messages Created From Diagram.uml", "Interaction");
		SDModel sdModel = builder.getSDModel();

		SDLifeLine a = findLifeLineByName(sdModel, "a");
		SDLifeLine b = findLifeLineByName(sdModel, "b");

		assertEquals(2, a.getBrackets().size());
		assertEquals(2, b.getBrackets().size());

		for (SDBracket nextABracket : a.getBrackets()) {
			assertTrue(nextABracket instanceof SDInvocation);
			SDInvocation invocation = (SDInvocation) nextABracket;
			assertTrue(invocation.getBrackets().isEmpty());
			assertNotNull(invocation.getOutgoingMessage());
			assertNotNull(invocation.getReceiveExecution());
			assertNotNull(invocation.getReceiveExecution().getIncomingMessage());
			assertSame(invocation.getOutgoingMessage(), invocation.getReceiveExecution().getIncomingMessage());
			assertEquals(a.getBrackets().indexOf(invocation), b.getBrackets().indexOf(invocation.getReceiveExecution()));
		}

		SDMessage firstMessage = null;
		SDMessage secondMessage = null;

		for (SDBracket nextBBracket : b.getBrackets()) {
			assertTrue(nextBBracket instanceof SDExecution);
			SDExecution execution = (SDExecution) nextBBracket;

			assertTrue(execution.getBrackets().isEmpty());
			assertNotNull(execution.getIncomingMessage());

			if (firstMessage == null) {
				firstMessage = execution.getIncomingMessage();
			} else {
				secondMessage = execution.getIncomingMessage();
			}
		}

		assertNotNull(firstMessage.getUmlMessage());
		assertNotNull(secondMessage.getUmlMessage());
		assertFalse(firstMessage == secondMessage);
		assertFalse(firstMessage.getUmlMessage() == secondMessage.getUmlMessage());

		assertEquals("1", firstMessage.getMessageNumber());
		assertEquals("2", secondMessage.getMessageNumber());

		checkCallStackCompleted(builder);
		checkTraces(builder);
	}

	public void testMessageChain_ABCD() {
		SDBuilder builder = buildFrame("Message Chain From Diagram - abcd.uml", "Interaction");
		SDModel sdModel = builder.getSDModel();
		checkCallStackCompleted(builder);
		checkTraces(builder);

		assertEquals(3, sdModel.getMessages().size());

		SDLifeLine a = findLifeLineByName(sdModel, "a");
		SDLifeLine b = findLifeLineByName(sdModel, "b");
		SDLifeLine c = findLifeLineByName(sdModel, "c");
		SDLifeLine d = findLifeLineByName(sdModel, "d");

		assertEquals(1, a.getBrackets().size());
		assertEquals(1, b.getBrackets().size());
		assertEquals(1, c.getBrackets().size());
		assertEquals(1, d.getBrackets().size());

		ThreeMessagesChainChecker chainChecker = new ThreeMessagesChainChecker(//
				a.getBrackets().get(0), //
				b.getBrackets().get(0), //
				c.getBrackets().get(0), //
				d.getBrackets().get(0));

		chainChecker.checkChain("1");
	}

	public void testMessageChainX3_ABCD_BDAC_CADB() {
		SDBuilder builder = buildFrame("Message Chain From Diagram - x3 - abcd - bdac - cadb.uml", "Interaction");
		SDModel sdModel = builder.getSDModel();
		checkCallStackCompleted(builder);
		checkTraces(builder);

		assertEquals(3 * 3, sdModel.getMessages().size());

		SDLifeLine a = findLifeLineByName(sdModel, "a");
		SDLifeLine b = findLifeLineByName(sdModel, "b");
		SDLifeLine c = findLifeLineByName(sdModel, "c");
		SDLifeLine d = findLifeLineByName(sdModel, "d");

		assertEquals(3, a.getBrackets().size());
		assertEquals(3, b.getBrackets().size());
		assertEquals(3, c.getBrackets().size());
		assertEquals(3, d.getBrackets().size());

		ThreeMessagesChainChecker abcdChecker = new ThreeMessagesChainChecker(//
				a.getBrackets().get(0), //
				b.getBrackets().get(0), //
				c.getBrackets().get(0), //
				d.getBrackets().get(0));
		abcdChecker.checkChain("1");

		ThreeMessagesChainChecker bdacChecker = new ThreeMessagesChainChecker(//
				b.getBrackets().get(1), //
				d.getBrackets().get(1), //
				a.getBrackets().get(1), //
				c.getBrackets().get(1));
		bdacChecker.checkChain("2");
	
		ThreeMessagesChainChecker cadbChecker = new ThreeMessagesChainChecker(//
				c.getBrackets().get(2), //
				a.getBrackets().get(2), //
				d.getBrackets().get(2), //
				b.getBrackets().get(2));
		cadbChecker.checkChain("3");
	}
	
	public void testStateInvariant(){
		SDBuilder builder = buildFrame("StateInvariant From Diagram - invariantA-message-invariantB.uml", "Interaction");
		SDModel sdModel = builder.getSDModel();
		checkCallStackCompleted(builder);
		checkTraces(builder);
		
		SDLifeLine a = findLifeLineByName(sdModel, "a");
		SDLifeLine b = findLifeLineByName(sdModel, "b");
		
		assertEquals(2, a.getBrackets().size());
		assertEquals(2, b.getBrackets().size());
		
		assertTrue(a.getBrackets().get(0) instanceof SDSimpleNode);
		assertTrue(a.getBrackets().get(1) instanceof SDInvocation);
		assertTrue(b.getBrackets().get(0) instanceof SDExecution);
		assertTrue(b.getBrackets().get(1) instanceof SDSimpleNode);
		
		SDSimpleNode invariantA = (SDSimpleNode) a.getBrackets().get(0);
		SDSimpleNode invariantB = (SDSimpleNode) b.getBrackets().get(1);
		SDInvocation invocation = (SDInvocation) a.getBrackets().get(1);
		SDExecution execution = (SDExecution) b.getBrackets().get(0);
		
		assertNotNull(invariantA.getUmlFragment());
		assertNotNull(invariantB.getUmlFragment());
		assertTrue(invariantA.getUmlFragment() instanceof StateInvariant);
		assertTrue(invariantB.getUmlFragment() instanceof StateInvariant);
		assertFalse(invariantB.getUmlFragment() == invariantA.getUmlFragment());
		
		assertEquals(execution, invocation.getReceiveExecution());
		assertEquals(invocation, execution.getInvocation());
	}

	public void testCombinedFragment(){
		SDBuilder builder = buildFrame("CombinedFrgament-alt-x2-message-x2.uml", "Interaction");
		SDModel sdModel = builder.getSDModel();
		assertNotNull(sdModel);
		checkCallStackCompleted(builder);
		checkTraces(builder);
	}

	protected SDAbstractMessage findMessageByName(SDModel frame, String name) {
		for (SDAbstractMessage next : frame.getMessages()) {
			Message nextUML = next.getUmlMessage();
			if (name.equalsIgnoreCase(nextUML.getName())) {
				return next;
			}
		}
		return null;
	}

	protected void checkCallStackCompleted(SDBuilder builder) {
		SDModel sdModel = builder.getSDModel();
		assertNotNull(sdModel.getUmlInteraction());
		assertEquals(sdModel.getUmlInteraction().getLifelines().size(), sdModel.getLifelines().size());

		LifeLineCallStack callStack = builder.getCallStack();

		for (SDLifeLine nextLifeLine : sdModel.getLifelines()) {
			Lifeline umlLifeline = nextLifeLine.getUmlLifeline();
			assertNotNull(umlLifeline);
			assertSame("CallStack not completed for LL: " + umlLifeline, nextLifeLine, callStack.peek(umlLifeline));
		}

	}

	protected void checkTraces(SDBuilder builder) {
		SDModel frame = builder.getSDModel();
		SDTrace trace = frame.getUMLTracing();

		for (SDAbstractMessage next : frame.getMessages()) {
			assertNotNull(next.getUmlMessage());
			assertSame(next, trace.findMessage(next.getUmlMessage()));
		}

		for (SDLifeLine next : frame.getLifelines()) {
			assertNotNull(next.getUmlLifeline());
			assertSame(next, trace.findLifeLine(next.getUmlLifeline()));
		}

		LinkedList<SDBracketContainer> queue = new LinkedList<SDBracketContainer>();
		queue.addAll(frame.getLifelines());

		while (!queue.isEmpty()) {
			SDBracketContainer next = queue.removeFirst();
			if (next instanceof SDBehaviorSpec) {
				SDBehaviorSpec nextToCheck = (SDBehaviorSpec) next;
				if (nextToCheck.getUmlExecutionSpec() == null) {
					assertTrue(nextToCheck instanceof SDInvocation);
				} else {
					assertSame(nextToCheck, trace.findBehaviorSpec(nextToCheck.getUmlExecutionSpec()));
				}
			}

			for (SDBracket nextBracket : next.getBrackets()) {
				if (nextBracket instanceof SDBracketContainer) {
					queue.add((SDBracketContainer) nextBracket);
				}
			}
		}
	}

	protected SDLifeLine findLifeLineByName(SDModel frame, String name) {
		for (SDLifeLine next : frame.getLifelines()) {
			Lifeline nextUML = next.getUmlLifeline();
			if (name.equalsIgnoreCase(nextUML.getName())) {
				return next;
			}
		}
		fail("Can't find SDLifeline " + name);
		throw new InternalError("Never thrown");
	}

	private Package loadExampleFile(String example) {
		URI uri = createExampleURI(example);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource semanticResource = resourceSet.getResource(uri, true);
		assertNotNull(semanticResource);
		assertFalse(semanticResource.getContents().isEmpty());
		assertTrue(semanticResource.getContents().get(0) instanceof Package);
		return (Package) semanticResource.getContents().get(0);
	}

	private SDBuilder buildFrame(String exampleFile, String interactionName) {
		Package pakkage = loadExampleFile(exampleFile);
		Interaction interaction = (Interaction) pakkage.getPackagedElement(interactionName, true, UMLPackage.eINSTANCE.getInteraction(), false);
		assertNotNull(interaction);

		SDBuilder builder = new SDBuilder(interaction);
		SDModel sdModel = builder.getSDModel();
		assertNotNull(sdModel);
		assertSame(interaction, sdModel.getUmlInteraction());
		return builder;
	}

	private URI createExampleURI(String fileName) {
		return URI.createURI("platform:/plugin/org.eclipse.uml2.diagram.sequence.tests/examples/" + fileName);
	}

	private static final String MEMORY_GAME_FILE = "Testable Version Of MemoryGame Model.uml";

	class ThreeMessagesChainChecker extends Assert {

		private final SDInvocation myRoot;

		private final SDExecution myMiddle1;

		private final SDExecution myMiddle2;

		private final SDExecution myTarget;

		public ThreeMessagesChainChecker(SDBracket root, SDBracket middle1, SDBracket middle2, SDBracket target) {
			assertTrue(root instanceof SDInvocation);
			assertTrue(middle1 instanceof SDExecution);
			assertTrue(middle2 instanceof SDExecution);
			assertTrue(target instanceof SDExecution);

			myRoot = (SDInvocation) root;
			myMiddle1 = (SDExecution) middle1;
			myMiddle2 = (SDExecution) middle2;
			myTarget = (SDExecution) target;
		}

		public void checkChain(String expectedRootNumber) {
			checkInvocationExecutionPair(myRoot, myMiddle1);

			assertEquals(1, myMiddle1.getBrackets().size());
			assertTrue(myMiddle1.getBrackets().get(0) instanceof SDInvocation);
			SDInvocation deepInvocation1 = (SDInvocation) myMiddle1.getBrackets().get(0);
			checkInvocationExecutionPair(deepInvocation1, myMiddle2);

			assertEquals(1, myMiddle2.getBrackets().size());
			assertTrue(myMiddle2.getBrackets().get(0) instanceof SDInvocation);
			SDInvocation deepInvocation2 = (SDInvocation) myMiddle2.getBrackets().get(0);
			checkInvocationExecutionPair(deepInvocation2, myTarget);

			assertTrue(myRoot.getBrackets().isEmpty());
			assertTrue(deepInvocation1.getBrackets().isEmpty());
			assertTrue(deepInvocation2.getBrackets().isEmpty());
			assertTrue(myTarget.getBrackets().isEmpty());

			SDMessage msgRoot = myRoot.getOutgoingMessage();
			SDMessage msgMiddle = deepInvocation1.getOutgoingMessage();
			SDMessage msgFinal = deepInvocation2.getOutgoingMessage();

			assertNotNull(msgRoot);
			assertNotNull(msgMiddle);
			assertNotNull(msgFinal);
			assertTrue(msgRoot != msgMiddle);
			assertTrue(msgRoot != msgFinal);
			assertTrue(msgMiddle != msgFinal);

			assertEquals(expectedRootNumber, msgRoot.getMessageNumber());
			assertEquals(expectedRootNumber + ".1", msgMiddle.getMessageNumber());
			assertEquals(expectedRootNumber + ".1.1", msgFinal.getMessageNumber());
		}

		protected void checkInvocationExecutionPair(SDInvocation invocation, SDExecution execution) {
			assertNotNull(invocation);
			assertNotNull(execution);
			assertNotNull(invocation.getUmlExecutionSpec());
			assertNotNull(execution.getUmlExecutionSpec());

			assertSame(execution, invocation.getReceiveExecution());
			assertSame(invocation, execution.getInvocation());
			assertSame(invocation.getOutgoingMessage(), execution.getIncomingMessage());

			SDMessage sdMessage = execution.getIncomingMessage();
			assertNotNull(sdMessage);
			assertNotNull(sdMessage.getUmlMessage());

			assertSame(invocation.getUmlExecutionSpec().getStart(), sdMessage.getUmlMessage().getSendEvent());
			assertSame(execution.getUmlExecutionSpec().getStart(), sdMessage.getUmlMessage().getReceiveEvent());
		}
	}

}
