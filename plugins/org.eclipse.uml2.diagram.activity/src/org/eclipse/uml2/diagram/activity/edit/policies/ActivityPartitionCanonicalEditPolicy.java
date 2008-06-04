package org.eclipse.uml2.diagram.activity.edit.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Ratio;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.diagram.activity.edit.parts.AcceptEventAction5EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AcceptEventAction6EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityFinalNode3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ActivityPartition2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.AddStructuralFeatureValueAction3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallBehaviorAction3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CallOperationAction3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CentralBufferNode3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ConditionalNode2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.CreateObjectAction3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.DataStoreNode3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.DecisionNode3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ExpansionRegion2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.FlowFinalNode3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.ForkNode3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.InitialNode2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.JoinNode3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.LoopNode2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.MergeNode2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.OpaqueAction3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.Pin3EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.SendSignalAction2EditPart;
import org.eclipse.uml2.diagram.activity.edit.parts.StructuredActivityNode3EditPart;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.uml2.diagram.activity.part.UMLDiagramUpdater;
import org.eclipse.uml2.diagram.activity.part.UMLNodeDescriptor;
import org.eclipse.uml2.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ActivityPartitionCanonicalEditPolicy extends CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = UMLDiagramUpdater.getActivityPartition_3056SemanticChildren(viewObject).iterator(); it.hasNext();) {
			result.add(((UMLNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = UMLVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case ActivityPartition2EditPart.VISUAL_ID:
		case AcceptEventAction5EditPart.VISUAL_ID:
		case AcceptEventAction6EditPart.VISUAL_ID:
		case ActivityFinalNode3EditPart.VISUAL_ID:
		case DecisionNode3EditPart.VISUAL_ID:
		case MergeNode2EditPart.VISUAL_ID:
		case InitialNode2EditPart.VISUAL_ID:
		case DataStoreNode3EditPart.VISUAL_ID:
		case CentralBufferNode3EditPart.VISUAL_ID:
		case OpaqueAction3EditPart.VISUAL_ID:
		case FlowFinalNode3EditPart.VISUAL_ID:
		case ForkNode3EditPart.VISUAL_ID:
		case JoinNode3EditPart.VISUAL_ID:
		case Pin3EditPart.VISUAL_ID:
		case CreateObjectAction3EditPart.VISUAL_ID:
		case AddStructuralFeatureValueAction3EditPart.VISUAL_ID:
		case CallBehaviorAction3EditPart.VISUAL_ID:
		case CallOperationAction3EditPart.VISUAL_ID:
		case StructuredActivityNode3EditPart.VISUAL_ID:
		case SendSignalAction2EditPart.VISUAL_ID:
		case LoopNode2EditPart.VISUAL_ID:
		case ConditionalNode2EditPart.VISUAL_ID:
		case ExpansionRegion2EditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
			EObject domainModelElement = view.getElement();
			if (visualID != UMLVisualIDRegistry.getNodeVisualID((View) getHost().getModel(), domainModelElement)) {
				List createdViews = createViews(Collections.singletonList(domainModelElement));
				assert createdViews.size() == 1;
				final View createdView = (View) ((IAdaptable) createdViews.get(0)).getAdapter(View.class);
				if (createdView != null) {
					try {
						new AbstractEMFOperation(host().getEditingDomain(), StringStatics.BLANK, Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE)) {

							protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
								populateViewProperties(view, createdView);
								return Status.OK_STATUS;
							}
						}.execute(new NullProgressMonitor(), null);
					} catch (ExecutionException e) {
						UMLDiagramEditorPlugin.getInstance().logError("Error while copyign view information to newly created view", e); //$NON-NLS-1$
					}
				}
				deleteViews(Collections.singletonList(view).iterator());
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	private void populateViewProperties(View oldView, View newView) {
		if (oldView instanceof Node && newView instanceof Node) {
			Node oldNode = (Node) oldView;
			Node newNode = (Node) newView;
			if (oldNode.getLayoutConstraint() instanceof Location && newNode.getLayoutConstraint() instanceof Location) {
				((Location) newNode.getLayoutConstraint()).setX(((Location) oldNode.getLayoutConstraint()).getX());
				((Location) newNode.getLayoutConstraint()).setY(((Location) oldNode.getLayoutConstraint()).getY());
			}
			if (oldNode.getLayoutConstraint() instanceof Size && newNode.getLayoutConstraint() instanceof Size) {
				((Size) newNode.getLayoutConstraint()).setWidth(((Size) oldNode.getLayoutConstraint()).getWidth());
				((Size) newNode.getLayoutConstraint()).setHeight(((Size) oldNode.getLayoutConstraint()).getHeight());
			}
			if (oldNode.getLayoutConstraint() instanceof Ratio && newNode.getLayoutConstraint() instanceof Ratio) {
				((Ratio) newNode.getLayoutConstraint()).setValue(((Ratio) oldNode.getLayoutConstraint()).getValue());
			}
			newNode.persist();
		}
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getActivityPartition_Subpartition());
			myFeaturesToSynchronize.add(UMLPackage.eINSTANCE.getActivity_Node());
		}
		return myFeaturesToSynchronize;
	}

}
