package org.eclipse.uml2.diagram.statemachine.action;

import org.eclipse.uml2.diagram.common.actions.ConvertCommentCommandBase;
import org.eclipse.uml2.diagram.common.actions.ConvertCommentIntoNoteAction;
import org.eclipse.uml2.diagram.statemachine.edit.parts.CommentAnnotatedElementEditPart;
import org.eclipse.uml2.diagram.statemachine.edit.parts.CommentEditPart;
import org.eclipse.uml2.diagram.statemachine.providers.UMLElementTypes;

/**
 * @generated
 */
public class TurnCommentIntoNoteAction extends ConvertCommentIntoNoteAction {

	/**
	* @generated
	*/
	public TurnCommentIntoNoteAction() {
		super(new ConvertCommentCommandBase.ConfigImpl(CommentEditPart.VISUAL_ID, CommentAnnotatedElementEditPart.VISUAL_ID, UMLElementTypes.CommentAnnotatedElement_4002));
	}
}
