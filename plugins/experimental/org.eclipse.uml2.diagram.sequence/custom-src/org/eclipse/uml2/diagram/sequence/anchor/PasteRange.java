/*
 * Copyright (c) 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland)
 */
package org.eclipse.uml2.diagram.sequence.anchor;

import org.eclipse.uml2.diagram.sequence.internal.layout.vertical.input.LifeLineElement;
import org.eclipse.uml2.diagram.sequence.model.sequenced.PasteDestination;
import org.eclipse.uml2.diagram.sequence.model.sequenced.SDEntity;

public class PasteRange {

	PasteRange(LifeLineElement rangeUpperElement, LifeLineElement rangeLowerElement, AnchorProcessorInput anchorProcessorInputImpl) {
		myRangeUpperElement = rangeUpperElement;
		myRangeLowerElement = rangeLowerElement;
		myAnchorProcessorInputImpl = anchorProcessorInputImpl;
	}

	LifeLineElement getRangeLowerElement() {
		return myRangeLowerElement;
	}

	LifeLineElement getRangeUpperElement() {
		return myRangeUpperElement;
	}

	public boolean includes(PasteDestination createTarget) throws UnknownElementException {
		return myAnchorProcessorInputImpl.doesInclude(this, createTarget);
	}

	public boolean includes(SDEntity entity) throws UnknownElementException {
		return myAnchorProcessorInputImpl.doesInclude(this, entity);
	}

	public PasteDestination findTargetByContainer(SDEntity container) {
		return myAnchorProcessorInputImpl.findTargetByContainer(this, container);
	}

	public String toString() {
		return "<PasteRange:" + myRangeUpperElement + ":" + myRangeLowerElement + ">";
	}

	private final LifeLineElement myRangeUpperElement;

	private final LifeLineElement myRangeLowerElement;

	private final AnchorProcessorInput myAnchorProcessorInputImpl;
}