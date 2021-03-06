package org.eclipse.uml2.diagram.timing.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.genapi.IDiagramUpdater;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterLinkDescriptor;
import org.eclipse.uml2.diagram.common.genapi.IUpdaterNodeDescriptor;
import org.eclipse.uml2.diagram.timing.edit.parts.DBlockEditPart;
import org.eclipse.uml2.diagram.timing.edit.parts.DFrameContainerEditPart;
import org.eclipse.uml2.diagram.timing.edit.parts.DFrameEditPart;
import org.eclipse.uml2.diagram.timing.edit.parts.DIntervalEditPart;
import org.eclipse.uml2.diagram.timing.edit.parts.DMessageEditPart;
import org.eclipse.uml2.diagram.timing.edit.parts.DSegmentEditPart;
import org.eclipse.uml2.diagram.timing.edit.parts.DSegmentEndEditPart;
import org.eclipse.uml2.diagram.timing.edit.parts.DSegmentMiddlePointEditPart;
import org.eclipse.uml2.diagram.timing.edit.parts.DSegmentStartEditPart;
import org.eclipse.uml2.diagram.timing.edit.parts.DStateSwitchEditPart;
import org.eclipse.uml2.diagram.timing.edit.parts.DTickEditPart;
import org.eclipse.uml2.diagram.timing.edit.parts.DValueLineEditPart;
import org.eclipse.uml2.diagram.timing.model.timingd.DBlock;
import org.eclipse.uml2.diagram.timing.model.timingd.DFrame;
import org.eclipse.uml2.diagram.timing.model.timingd.DFrameContainer;
import org.eclipse.uml2.diagram.timing.model.timingd.DInterval;
import org.eclipse.uml2.diagram.timing.model.timingd.DMessage;
import org.eclipse.uml2.diagram.timing.model.timingd.DSegment;
import org.eclipse.uml2.diagram.timing.model.timingd.DSegmentElement;
import org.eclipse.uml2.diagram.timing.model.timingd.DSegmentEnd;
import org.eclipse.uml2.diagram.timing.model.timingd.DSegmentMiddlePoint;
import org.eclipse.uml2.diagram.timing.model.timingd.DSegmentStart;
import org.eclipse.uml2.diagram.timing.model.timingd.DStateSwitch;
import org.eclipse.uml2.diagram.timing.model.timingd.DTick;
import org.eclipse.uml2.diagram.timing.model.timingd.DValueLine;
import org.eclipse.uml2.diagram.timing.model.timingd.TimingDPackage;
import org.eclipse.uml2.diagram.timing.providers.TimingDElementTypes;

/**
 * @generated
 */
@SuppressWarnings("unchecked")
public class TimingDDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (TimingDVisualIDRegistry.getVisualID(view)) {
		case DFrameEditPart.VISUAL_ID:
			return getDFrame_2001SemanticChildren(view);
		case DBlockEditPart.VISUAL_ID:
			return getDBlock_3001SemanticChildren(view);
		case DValueLineEditPart.VISUAL_ID:
			return getDValueLine_3002SemanticChildren(view);
		case DSegmentEditPart.VISUAL_ID:
			return getDSegment_3003SemanticChildren(view);
		case DFrameContainerEditPart.VISUAL_ID:
			return getDFrameContainer_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDFrame_2001SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DFrame modelElement = (DFrame) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getBlocks().iterator(); it.hasNext();) {
			DBlock childElement = (DBlock) it.next();
			int visualID = TimingDVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DBlockEditPart.VISUAL_ID) {
				result.add(new TimingDNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDBlock_3001SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DBlock modelElement = (DBlock) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getStates().iterator(); it.hasNext();) {
			DValueLine childElement = (DValueLine) it.next();
			int visualID = TimingDVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DValueLineEditPart.VISUAL_ID) {
				result.add(new TimingDNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getTicks().iterator(); it.hasNext();) {
			DTick childElement = (DTick) it.next();
			int visualID = TimingDVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DTickEditPart.VISUAL_ID) {
				result.add(new TimingDNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDValueLine_3002SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DValueLine modelElement = (DValueLine) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getSegments().iterator(); it.hasNext();) {
			DSegment childElement = (DSegment) it.next();
			int visualID = TimingDVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DSegmentEditPart.VISUAL_ID) {
				result.add(new TimingDNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDSegment_3003SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DSegment modelElement = (DSegment) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getMiddlePoints().iterator(); it.hasNext();) {
			DSegmentMiddlePoint childElement = (DSegmentMiddlePoint) it.next();
			int visualID = TimingDVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DSegmentMiddlePointEditPart.VISUAL_ID) {
				result.add(new TimingDNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		{
			DSegmentStart childElement = modelElement.getStart();
			int visualID = TimingDVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DSegmentStartEditPart.VISUAL_ID) {
				result.add(new TimingDNodeDescriptor(childElement, visualID));
			}
		}
		{
			DSegmentEnd childElement = modelElement.getEnd();
			int visualID = TimingDVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DSegmentEndEditPart.VISUAL_ID) {
				result.add(new TimingDNodeDescriptor(childElement, visualID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDFrameContainer_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		DFrameContainer modelElement = (DFrameContainer) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getFrames().iterator(); it.hasNext();) {
			DFrame childElement = (DFrame) it.next();
			int visualID = TimingDVisualIDRegistry.getNodeVisualID(view, childElement);
			if (visualID == DFrameEditPart.VISUAL_ID) {
				result.add(new TimingDNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (TimingDVisualIDRegistry.getVisualID(view)) {
		case DFrameContainerEditPart.VISUAL_ID:
			return getDFrameContainer_1000ContainedLinks(view);
		case DFrameEditPart.VISUAL_ID:
			return getDFrame_2001ContainedLinks(view);
		case DBlockEditPart.VISUAL_ID:
			return getDBlock_3001ContainedLinks(view);
		case DValueLineEditPart.VISUAL_ID:
			return getDValueLine_3002ContainedLinks(view);
		case DSegmentEditPart.VISUAL_ID:
			return getDSegment_3003ContainedLinks(view);
		case DSegmentMiddlePointEditPart.VISUAL_ID:
			return getDSegmentMiddlePoint_3004ContainedLinks(view);
		case DSegmentStartEditPart.VISUAL_ID:
			return getDSegmentStart_3005ContainedLinks(view);
		case DSegmentEndEditPart.VISUAL_ID:
			return getDSegmentEnd_3006ContainedLinks(view);
		case DTickEditPart.VISUAL_ID:
			return getDTick_3007ContainedLinks(view);
		case DStateSwitchEditPart.VISUAL_ID:
			return getDStateSwitch_4001ContainedLinks(view);
		case DMessageEditPart.VISUAL_ID:
			return getDMessage_4002ContainedLinks(view);
		case DIntervalEditPart.VISUAL_ID:
			return getDInterval_4003ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (TimingDVisualIDRegistry.getVisualID(view)) {
		case DFrameEditPart.VISUAL_ID:
			return getDFrame_2001IncomingLinks(view);
		case DBlockEditPart.VISUAL_ID:
			return getDBlock_3001IncomingLinks(view);
		case DValueLineEditPart.VISUAL_ID:
			return getDValueLine_3002IncomingLinks(view);
		case DSegmentEditPart.VISUAL_ID:
			return getDSegment_3003IncomingLinks(view);
		case DSegmentMiddlePointEditPart.VISUAL_ID:
			return getDSegmentMiddlePoint_3004IncomingLinks(view);
		case DSegmentStartEditPart.VISUAL_ID:
			return getDSegmentStart_3005IncomingLinks(view);
		case DSegmentEndEditPart.VISUAL_ID:
			return getDSegmentEnd_3006IncomingLinks(view);
		case DTickEditPart.VISUAL_ID:
			return getDTick_3007IncomingLinks(view);
		case DStateSwitchEditPart.VISUAL_ID:
			return getDStateSwitch_4001IncomingLinks(view);
		case DMessageEditPart.VISUAL_ID:
			return getDMessage_4002IncomingLinks(view);
		case DIntervalEditPart.VISUAL_ID:
			return getDInterval_4003IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (TimingDVisualIDRegistry.getVisualID(view)) {
		case DFrameEditPart.VISUAL_ID:
			return getDFrame_2001OutgoingLinks(view);
		case DBlockEditPart.VISUAL_ID:
			return getDBlock_3001OutgoingLinks(view);
		case DValueLineEditPart.VISUAL_ID:
			return getDValueLine_3002OutgoingLinks(view);
		case DSegmentEditPart.VISUAL_ID:
			return getDSegment_3003OutgoingLinks(view);
		case DSegmentMiddlePointEditPart.VISUAL_ID:
			return getDSegmentMiddlePoint_3004OutgoingLinks(view);
		case DSegmentStartEditPart.VISUAL_ID:
			return getDSegmentStart_3005OutgoingLinks(view);
		case DSegmentEndEditPart.VISUAL_ID:
			return getDSegmentEnd_3006OutgoingLinks(view);
		case DTickEditPart.VISUAL_ID:
			return getDTick_3007OutgoingLinks(view);
		case DStateSwitchEditPart.VISUAL_ID:
			return getDStateSwitch_4001OutgoingLinks(view);
		case DMessageEditPart.VISUAL_ID:
			return getDMessage_4002OutgoingLinks(view);
		case DIntervalEditPart.VISUAL_ID:
			return getDInterval_4003OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDFrameContainer_1000ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDFrame_2001ContainedLinks(View view) {
		DFrame modelElement = (DFrame) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_DMessage_4002(modelElement));
		result.addAll(getContainedTypeModelFacetLinks_DInterval_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDBlock_3001ContainedLinks(View view) {
		DBlock modelElement = (DBlock) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_DStateSwitch_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDValueLine_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDSegment_3003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDSegmentMiddlePoint_3004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDSegmentStart_3005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDSegmentEnd_3006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDTick_3007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDStateSwitch_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDMessage_4002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDInterval_4003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDFrame_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDBlock_3001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDValueLine_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDSegment_3003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDSegmentMiddlePoint_3004IncomingLinks(View view) {
		DSegmentMiddlePoint modelElement = (DSegmentMiddlePoint) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_DMessage_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDSegmentStart_3005IncomingLinks(View view) {
		DSegmentStart modelElement = (DSegmentStart) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_DStateSwitch_4001(modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_DMessage_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDSegmentEnd_3006IncomingLinks(View view) {
		DSegmentEnd modelElement = (DSegmentEnd) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_DMessage_4002(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDTick_3007IncomingLinks(View view) {
		DTick modelElement = (DTick) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_DInterval_4003(modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDStateSwitch_4001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDMessage_4002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDInterval_4003IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDFrame_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDBlock_3001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDValueLine_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDSegment_3003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDSegmentMiddlePoint_3004OutgoingLinks(View view) {
		DSegmentMiddlePoint modelElement = (DSegmentMiddlePoint) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_DMessage_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDSegmentStart_3005OutgoingLinks(View view) {
		DSegmentStart modelElement = (DSegmentStart) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_DMessage_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDSegmentEnd_3006OutgoingLinks(View view) {
		DSegmentEnd modelElement = (DSegmentEnd) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_DStateSwitch_4001(modelElement));
		result.addAll(getOutgoingTypeModelFacetLinks_DMessage_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDTick_3007OutgoingLinks(View view) {
		DTick modelElement = (DTick) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_DInterval_4003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDStateSwitch_4001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDMessage_4002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDInterval_4003OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_DStateSwitch_4001(DBlock container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getSwitches().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof DStateSwitch) {
				continue;
			}
			DStateSwitch link = (DStateSwitch) linkObject;
			if (DStateSwitchEditPart.VISUAL_ID != TimingDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			DSegmentStart dst = link.getToSegmentStart();
			DSegmentEnd src = link.getFromSegmentEnd();
			result.add(new TimingDLinkDescriptor(src, dst, link, TimingDElementTypes.DStateSwitch_4001, DStateSwitchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_DMessage_4002(DFrame container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof DMessage) {
				continue;
			}
			DMessage link = (DMessage) linkObject;
			if (DMessageEditPart.VISUAL_ID != TimingDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			DSegmentElement dst = link.getMessageTarget();
			DSegmentElement src = link.getMessageSource();
			result.add(new TimingDLinkDescriptor(src, dst, link, TimingDElementTypes.DMessage_4002, DMessageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_DInterval_4003(DFrame container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getIntervals().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof DInterval) {
				continue;
			}
			DInterval link = (DInterval) linkObject;
			if (DIntervalEditPart.VISUAL_ID != TimingDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			DTick dst = link.getToTick();
			DTick src = link.getFromTick();
			result.add(new TimingDLinkDescriptor(src, dst, link, TimingDElementTypes.DInterval_4003, DIntervalEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_DStateSwitch_4001(DSegmentStart target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != TimingDPackage.eINSTANCE.getDStateSwitch_ToSegmentStart() || false == setting.getEObject() instanceof DStateSwitch) {
				continue;
			}
			DStateSwitch link = (DStateSwitch) setting.getEObject();
			if (DStateSwitchEditPart.VISUAL_ID != TimingDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			DSegmentEnd src = link.getFromSegmentEnd();
			result.add(new TimingDLinkDescriptor(src, target, link, TimingDElementTypes.DStateSwitch_4001, DStateSwitchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_DMessage_4002(DSegmentElement target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != TimingDPackage.eINSTANCE.getDMessage_MessageTarget() || false == setting.getEObject() instanceof DMessage) {
				continue;
			}
			DMessage link = (DMessage) setting.getEObject();
			if (DMessageEditPart.VISUAL_ID != TimingDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			DSegmentElement src = link.getMessageSource();
			result.add(new TimingDLinkDescriptor(src, target, link, TimingDElementTypes.DMessage_4002, DMessageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_DInterval_4003(DTick target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
			if (setting.getEStructuralFeature() != TimingDPackage.eINSTANCE.getDInterval_ToTick() || false == setting.getEObject() instanceof DInterval) {
				continue;
			}
			DInterval link = (DInterval) setting.getEObject();
			if (DIntervalEditPart.VISUAL_ID != TimingDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			DTick src = link.getFromTick();
			result.add(new TimingDLinkDescriptor(src, target, link, TimingDElementTypes.DInterval_4003, DIntervalEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_DStateSwitch_4001(DSegmentEnd source) {
		DBlock container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof DBlock) {
				container = (DBlock) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getSwitches().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof DStateSwitch) {
				continue;
			}
			DStateSwitch link = (DStateSwitch) linkObject;
			if (DStateSwitchEditPart.VISUAL_ID != TimingDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			DSegmentStart dst = link.getToSegmentStart();
			DSegmentEnd src = link.getFromSegmentEnd();
			if (src != source) {
				continue;
			}
			result.add(new TimingDLinkDescriptor(src, dst, link, TimingDElementTypes.DStateSwitch_4001, DStateSwitchEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_DMessage_4002(DSegmentElement source) {
		DFrame container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof DFrame) {
				container = (DFrame) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getMessages().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof DMessage) {
				continue;
			}
			DMessage link = (DMessage) linkObject;
			if (DMessageEditPart.VISUAL_ID != TimingDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			DSegmentElement dst = link.getMessageTarget();
			DSegmentElement src = link.getMessageSource();
			if (src != source) {
				continue;
			}
			result.add(new TimingDLinkDescriptor(src, dst, link, TimingDElementTypes.DMessage_4002, DMessageEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_DInterval_4003(DTick source) {
		DFrame container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element.eContainer()) {
			if (element instanceof DFrame) {
				container = (DFrame) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getIntervals().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof DInterval) {
				continue;
			}
			DInterval link = (DInterval) linkObject;
			if (DIntervalEditPart.VISUAL_ID != TimingDVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			DTick dst = link.getToTick();
			DTick src = link.getFromTick();
			if (src != source) {
				continue;
			}
			result.add(new TimingDLinkDescriptor(src, dst, link, TimingDElementTypes.DInterval_4003, DIntervalEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static final IDiagramUpdater TYPED_ADAPTER = new IDiagramUpdater() {

		/**
		 * @generated
		 */
		public List<IUpdaterNodeDescriptor> getSemanticChildren(View view) {
			return org.eclipse.uml2.diagram.timing.part.TimingDDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		public List<IUpdaterLinkDescriptor> getContainedLinks(View view) {
			return org.eclipse.uml2.diagram.timing.part.TimingDDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		public List<IUpdaterLinkDescriptor> getIncomingLinks(View view) {
			return org.eclipse.uml2.diagram.timing.part.TimingDDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		public List<IUpdaterLinkDescriptor> getOutgoingLinks(View view) {
			return org.eclipse.uml2.diagram.timing.part.TimingDDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
