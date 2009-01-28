package org.eclipse.uml2.diagram.sequence.edit.create;

import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.common.editpolicies.CreationEditPolicyWithCustomReparent;
import org.eclipse.uml2.diagram.common.genapi.IVisualIDRegistry;
import org.eclipse.uml2.diagram.sequence.model.SDModelAccess;
import org.eclipse.uml2.diagram.sequence.model.sdnotation.SDModelAccessStyle;
import org.eclipse.uml2.diagram.sequence.model.sdnotation.SDNotationPackage;

public class SDCreationEditPolicy extends CreationEditPolicyWithCustomReparent {

	public SDCreationEditPolicy(IVisualIDRegistry visualIdRegistry) {
		super(visualIdRegistry);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Command getCreateCommand(CreateViewRequest request) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, DiagramUIMessages.AddCommand_Label);

		Iterator descriptors = request.getViewDescriptors().iterator();

		while (descriptors.hasNext()) {
			CreateViewRequest.ViewDescriptor descriptor = (CreateViewRequest.ViewDescriptor) descriptors.next();

			CreateCommand createCommand = new CreateCommand(editingDomain, descriptor, (View) (getHost().getModel()));

			cc.compose(createCommand);
		}
		
		if (cc.canExecute()){
			cc.compose(getInvalidateSDModelCommand((IGraphicalEditPart) getHost()));
		}
		
		return new ICommandProxy(cc.reduce());
	}
	
	public static SetValueCommand getInvalidateSDModelCommand(IGraphicalEditPart editPart){
		return getInvalidateSDModelCommand(editPart.getNotationView());
	}
	
	public static SetValueCommand getInvalidateSDModelCommand(View view){
		if (view == null){
			return null;
		}
		View interactionView = SDModelAccess.findInteractionView(view);
		if (interactionView == null){
			return null;
		}
		
		SDModelAccessStyle sdModelAccessor = SDModelAccess.findSDModelAccess(interactionView);
		if (sdModelAccessor != null && sdModelAccessor.getFrame() != null){
			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(view);
			SetRequest setRequest = new SetRequest(domain, sdModelAccessor, SDNotationPackage.eINSTANCE.getSDModelAccessStyle_Frame(), null);
			return new SetValueCommand(setRequest){
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					CommandResult result = super.doExecuteWithResult(monitor, info);
					if (result.getStatus() != null && result.getStatus().isOK()){
						System.out.println("SDModel invalidated");
					}	
					return result;
				}
			};
		}
		return null;
	}
	
}