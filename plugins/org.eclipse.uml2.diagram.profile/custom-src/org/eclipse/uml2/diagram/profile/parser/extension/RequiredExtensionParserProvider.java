/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 */

package org.eclipse.uml2.diagram.profile.parser.extension;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.uml2.diagram.profile.providers.UMLElementTypes;

public class RequiredExtensionParserProvider extends AbstractProvider implements IParserProvider {

	private RequiredExtensionParser myParser;

	public IParser getParser(IAdaptable hint) {
		if (myParser == null) {
			myParser = new RequiredExtensionParser();
		}
		return myParser;
	}

	public boolean provides(IOperation operation) {
		boolean result = false;
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			result = (hint != null) && (hint.getAdapter(IElementType.class) == UMLElementTypes.Extension_4002);
		}
		return result;
	}
}
