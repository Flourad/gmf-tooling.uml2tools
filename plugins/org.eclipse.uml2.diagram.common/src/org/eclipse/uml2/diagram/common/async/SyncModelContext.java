package org.eclipse.uml2.diagram.common.async;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.diagram.common.genapi.IDiagramUpdater;
import org.eclipse.uml2.diagram.common.genapi.IVisualIDRegistry;


public class SyncModelContext {
	private static final String SYNC_RESOURCE_TEMP_URI = "uri://temp/" + SyncModelContext.class.getName() + "/temp";
	private final PreferencesHint myPreferencesHint;
	private final IDiagramUpdater myUpdater;
	private final IVisualIDRegistry myRegistry;
	private final TransactionalEditingDomain myDomain;
	private Resource mySyncModelResource;

	public SyncModelContext(IDiagramUpdater updater, IVisualIDRegistry registry, PreferencesHint preferencesHint, TransactionalEditingDomain domain){
		myUpdater = updater;
		myRegistry = registry;
		myPreferencesHint = preferencesHint;
		myDomain = domain;
	}
	
	public PreferencesHint getPreferencesHint() {
		return myPreferencesHint;
	}
	
	public IDiagramUpdater getUpdater() {
		return myUpdater;
	}
	
	public IVisualIDRegistry getRegistry() {
		return myRegistry;
	}
	
	public TransactionalEditingDomain getDomain() {
		return myDomain;
	}
	
	public Resource getSyncModelResource(){
		if (mySyncModelResource == null){
			URI syncModelURI = URI.createURI(SYNC_RESOURCE_TEMP_URI);
			mySyncModelResource = getResourceSet().createResource(syncModelURI);
			if (mySyncModelResource == null){
				throw new IllegalStateException("Can't create sync model resource: " + syncModelURI);
			}
		}
		return mySyncModelResource;
	}
	
	public void dispose(){
		if (mySyncModelResource != null){
			mySyncModelResource.unload();
			getResourceSet().getResources().remove(mySyncModelResource);
			mySyncModelResource = null;
		}
	}
	
	public void runCommand(AbstractTransactionalCommand command) {
		try {
			//XXX
			OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}		
	}
	
	public void runCommand(final Runnable command){
		runCommand(new AbstractTransactionalCommand(myDomain, "", null){
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				command.run();
				return CommandResult.newOKCommandResult();
			}
		});
	}
	
	private ResourceSet getResourceSet(){
		return myDomain.getResourceSet();
	}
	
}