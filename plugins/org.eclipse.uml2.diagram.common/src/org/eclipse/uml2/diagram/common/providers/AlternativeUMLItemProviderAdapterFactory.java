package org.eclipse.uml2.diagram.common.providers;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.uml2.diagram.common.preferences.UmlPreferenceConstants;
import org.eclipse.uml2.uml.edit.providers.CommentItemProvider;
import org.eclipse.uml2.uml.edit.providers.DependencyItemProvider;
import org.eclipse.uml2.uml.edit.providers.TemplateParameterItemProvider;
import org.eclipse.uml2.uml.edit.providers.TemplateSignatureItemProvider;
import org.eclipse.uml2.uml.edit.providers.TemplateBindingItemProvider;
import org.eclipse.uml2.uml.edit.providers.TemplateParameterSubstitutionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ElementImportItemProvider;
import org.eclipse.uml2.uml.edit.providers.PackageImportItemProvider;
import org.eclipse.uml2.uml.edit.providers.PackageItemProvider;
import org.eclipse.uml2.uml.edit.providers.PackageMergeItemProvider;
import org.eclipse.uml2.uml.edit.providers.ProfileApplicationItemProvider;
import org.eclipse.uml2.uml.edit.providers.ProfileItemProvider;
import org.eclipse.uml2.uml.edit.providers.StereotypeItemProvider;
import org.eclipse.uml2.uml.edit.providers.ImageItemProvider;
import org.eclipse.uml2.uml.edit.providers.ClassItemProvider;
import org.eclipse.uml2.uml.edit.providers.GeneralizationItemProvider;
import org.eclipse.uml2.uml.edit.providers.GeneralizationSetItemProvider;
import org.eclipse.uml2.uml.edit.providers.UseCaseItemProvider;
import org.eclipse.uml2.uml.edit.providers.IncludeItemProvider;
import org.eclipse.uml2.uml.edit.providers.ExtendItemProvider;
import org.eclipse.uml2.uml.edit.providers.ConstraintItemProvider;
import org.eclipse.uml2.uml.edit.providers.ExtensionPointItemProvider;
import org.eclipse.uml2.uml.edit.providers.SubstitutionItemProvider;
import org.eclipse.uml2.uml.edit.providers.RealizationItemProvider;
import org.eclipse.uml2.uml.edit.providers.AbstractionItemProvider;
import org.eclipse.uml2.uml.edit.providers.OpaqueExpressionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ParameterItemProvider;
import org.eclipse.uml2.uml.edit.providers.ConnectorEndItemProvider;
import org.eclipse.uml2.uml.edit.providers.PropertyItemProvider;
import org.eclipse.uml2.uml.edit.providers.DeploymentItemProvider;
import org.eclipse.uml2.uml.edit.providers.DeploymentSpecificationItemProvider;
import org.eclipse.uml2.uml.edit.providers.ArtifactItemProvider;
import org.eclipse.uml2.uml.edit.providers.ManifestationItemProvider;
import org.eclipse.uml2.uml.edit.providers.OperationItemProvider;
import org.eclipse.uml2.uml.edit.providers.ParameterSetItemProvider;
import org.eclipse.uml2.uml.edit.providers.DataTypeItemProvider;
import org.eclipse.uml2.uml.edit.providers.InterfaceItemProvider;
import org.eclipse.uml2.uml.edit.providers.ReceptionItemProvider;
import org.eclipse.uml2.uml.edit.providers.SignalItemProvider;
import org.eclipse.uml2.uml.edit.providers.ProtocolStateMachineItemProvider;
import org.eclipse.uml2.uml.edit.providers.StateMachineItemProvider;
import org.eclipse.uml2.uml.edit.providers.RegionItemProvider;
import org.eclipse.uml2.uml.edit.providers.TransitionItemProvider;
import org.eclipse.uml2.uml.edit.providers.TriggerItemProvider;
import org.eclipse.uml2.uml.edit.providers.PortItemProvider;
import org.eclipse.uml2.uml.edit.providers.StateItemProvider;
import org.eclipse.uml2.uml.edit.providers.ConnectionPointReferenceItemProvider;
import org.eclipse.uml2.uml.edit.providers.PseudostateItemProvider;
import org.eclipse.uml2.uml.edit.providers.ProtocolConformanceItemProvider;
import org.eclipse.uml2.uml.edit.providers.OperationTemplateParameterItemProvider;
import org.eclipse.uml2.uml.edit.providers.AssociationItemProvider;
import org.eclipse.uml2.uml.edit.providers.ConnectableElementTemplateParameterItemProvider;
import org.eclipse.uml2.uml.edit.providers.CollaborationUseItemProvider;
import org.eclipse.uml2.uml.edit.providers.CollaborationItemProvider;
import org.eclipse.uml2.uml.edit.providers.ConnectorItemProvider;
import org.eclipse.uml2.uml.edit.providers.RedefinableTemplateSignatureItemProvider;
import org.eclipse.uml2.uml.edit.providers.ClassifierTemplateParameterItemProvider;
import org.eclipse.uml2.uml.edit.providers.InterfaceRealizationItemProvider;
import org.eclipse.uml2.uml.edit.providers.ExtensionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ExtensionEndItemProvider;
import org.eclipse.uml2.uml.edit.providers.StringExpressionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ExpressionItemProvider;
import org.eclipse.uml2.uml.edit.providers.LiteralIntegerItemProvider;
import org.eclipse.uml2.uml.edit.providers.LiteralStringItemProvider;
import org.eclipse.uml2.uml.edit.providers.LiteralBooleanItemProvider;
import org.eclipse.uml2.uml.edit.providers.LiteralNullItemProvider;
import org.eclipse.uml2.uml.edit.providers.SlotItemProvider;
import org.eclipse.uml2.uml.edit.providers.InstanceSpecificationItemProvider;
import org.eclipse.uml2.uml.edit.providers.EnumerationItemProvider;
import org.eclipse.uml2.uml.edit.providers.EnumerationLiteralItemProvider;
import org.eclipse.uml2.uml.edit.providers.PrimitiveTypeItemProvider;
import org.eclipse.uml2.uml.edit.providers.InstanceValueItemProvider;
import org.eclipse.uml2.uml.edit.providers.LiteralUnlimitedNaturalItemProvider;
import org.eclipse.uml2.uml.edit.providers.OpaqueBehaviorItemProvider;
import org.eclipse.uml2.uml.edit.providers.FunctionBehaviorItemProvider;
import org.eclipse.uml2.uml.edit.providers.ActorItemProvider;
import org.eclipse.uml2.uml.edit.providers.UsageItemProvider;
import org.eclipse.uml2.uml.edit.providers.MessageItemProvider;
import org.eclipse.uml2.uml.edit.providers.InteractionItemProvider;
import org.eclipse.uml2.uml.edit.providers.LifelineItemProvider;
import org.eclipse.uml2.uml.edit.providers.PartDecompositionItemProvider;
import org.eclipse.uml2.uml.edit.providers.InteractionUseItemProvider;
import org.eclipse.uml2.uml.edit.providers.GateItemProvider;
import org.eclipse.uml2.uml.edit.providers.ActivityItemProvider;
import org.eclipse.uml2.uml.edit.providers.ActivityPartitionItemProvider;
import org.eclipse.uml2.uml.edit.providers.StructuredActivityNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.VariableItemProvider;
import org.eclipse.uml2.uml.edit.providers.InterruptibleActivityRegionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ExceptionHandlerItemProvider;
import org.eclipse.uml2.uml.edit.providers.OutputPinItemProvider;
import org.eclipse.uml2.uml.edit.providers.PinItemProvider;
import org.eclipse.uml2.uml.edit.providers.InputPinItemProvider;
import org.eclipse.uml2.uml.edit.providers.GeneralOrderingItemProvider;
import org.eclipse.uml2.uml.edit.providers.OccurrenceSpecificationItemProvider;
import org.eclipse.uml2.uml.edit.providers.InteractionOperandItemProvider;
import org.eclipse.uml2.uml.edit.providers.InteractionConstraintItemProvider;
import org.eclipse.uml2.uml.edit.providers.ExecutionOccurrenceSpecificationItemProvider;
import org.eclipse.uml2.uml.edit.providers.ExecutionEventItemProvider;
import org.eclipse.uml2.uml.edit.providers.StateInvariantItemProvider;
import org.eclipse.uml2.uml.edit.providers.ActionExecutionSpecificationItemProvider;
import org.eclipse.uml2.uml.edit.providers.BehaviorExecutionSpecificationItemProvider;
import org.eclipse.uml2.uml.edit.providers.CreationEventItemProvider;
import org.eclipse.uml2.uml.edit.providers.DestructionEventItemProvider;
import org.eclipse.uml2.uml.edit.providers.SendOperationEventItemProvider;
import org.eclipse.uml2.uml.edit.providers.SendSignalEventItemProvider;
import org.eclipse.uml2.uml.edit.providers.MessageOccurrenceSpecificationItemProvider;
import org.eclipse.uml2.uml.edit.providers.ReceiveOperationEventItemProvider;
import org.eclipse.uml2.uml.edit.providers.ReceiveSignalEventItemProvider;
import org.eclipse.uml2.uml.edit.providers.CombinedFragmentItemProvider;
import org.eclipse.uml2.uml.edit.providers.ContinuationItemProvider;
import org.eclipse.uml2.uml.edit.providers.ConsiderIgnoreFragmentItemProvider;
import org.eclipse.uml2.uml.edit.providers.CallEventItemProvider;
import org.eclipse.uml2.uml.edit.providers.ChangeEventItemProvider;
import org.eclipse.uml2.uml.edit.providers.SignalEventItemProvider;
import org.eclipse.uml2.uml.edit.providers.AnyReceiveEventItemProvider;
import org.eclipse.uml2.uml.edit.providers.CreateObjectActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.DestroyObjectActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.TestIdentityActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ReadSelfActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ReadStructuralFeatureActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ClearStructuralFeatureActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.RemoveStructuralFeatureValueActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.AddStructuralFeatureValueActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.LinkEndDataItemProvider;
import org.eclipse.uml2.uml.edit.providers.QualifierValueItemProvider;
import org.eclipse.uml2.uml.edit.providers.ReadLinkActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.LinkEndCreationDataItemProvider;
import org.eclipse.uml2.uml.edit.providers.CreateLinkActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.DestroyLinkActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.LinkEndDestructionDataItemProvider;
import org.eclipse.uml2.uml.edit.providers.ClearAssociationActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.BroadcastSignalActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.SendObjectActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ValueSpecificationActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.TimeExpressionItemProvider;
import org.eclipse.uml2.uml.edit.providers.DurationItemProvider;
import org.eclipse.uml2.uml.edit.providers.ValuePinItemProvider;
import org.eclipse.uml2.uml.edit.providers.DurationIntervalItemProvider;
import org.eclipse.uml2.uml.edit.providers.IntervalItemProvider;
import org.eclipse.uml2.uml.edit.providers.TimeConstraintItemProvider;
import org.eclipse.uml2.uml.edit.providers.IntervalConstraintItemProvider;
import org.eclipse.uml2.uml.edit.providers.TimeIntervalItemProvider;
import org.eclipse.uml2.uml.edit.providers.DurationConstraintItemProvider;
import org.eclipse.uml2.uml.edit.providers.TimeObservationItemProvider;
import org.eclipse.uml2.uml.edit.providers.DurationObservationItemProvider;
import org.eclipse.uml2.uml.edit.providers.OpaqueActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.SendSignalActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.CallOperationActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.CallBehaviorActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.InformationItemItemProvider;
import org.eclipse.uml2.uml.edit.providers.InformationFlowItemProvider;
import org.eclipse.uml2.uml.edit.providers.ModelItemProvider;
import org.eclipse.uml2.uml.edit.providers.ReadVariableActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ClearVariableActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.AddVariableValueActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.RemoveVariableValueActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.RaiseExceptionActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ActionInputPinItemProvider;
import org.eclipse.uml2.uml.edit.providers.ReadExtentActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ReclassifyObjectActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ReadIsClassifiedObjectActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.StartClassifierBehaviorActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ReadLinkObjectEndActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ReadLinkObjectEndQualifierActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.CreateLinkObjectActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.AcceptEventActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.AcceptCallActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ReplyActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.UnmarshallActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ReduceActionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ControlFlowItemProvider;
import org.eclipse.uml2.uml.edit.providers.InitialNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.ActivityParameterNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.ForkNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.FlowFinalNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.CentralBufferNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.MergeNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.DecisionNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.ActivityFinalNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.JoinNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.DataStoreNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.ObjectFlowItemProvider;
import org.eclipse.uml2.uml.edit.providers.SequenceNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.ConditionalNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.ClauseItemProvider;
import org.eclipse.uml2.uml.edit.providers.LoopNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.ExpansionNodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.ExpansionRegionItemProvider;
import org.eclipse.uml2.uml.edit.providers.ComponentRealizationItemProvider;
import org.eclipse.uml2.uml.edit.providers.ComponentItemProvider;
import org.eclipse.uml2.uml.edit.providers.NodeItemProvider;
import org.eclipse.uml2.uml.edit.providers.DeviceItemProvider;
import org.eclipse.uml2.uml.edit.providers.ExecutionEnvironmentItemProvider;
import org.eclipse.uml2.uml.edit.providers.CommunicationPathItemProvider;
import org.eclipse.uml2.uml.edit.providers.FinalStateItemProvider;
import org.eclipse.uml2.uml.edit.providers.TimeEventItemProvider;
import org.eclipse.uml2.uml.edit.providers.ProtocolTransitionItemProvider;
import org.eclipse.uml2.uml.edit.providers.AssociationClassItemProvider;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;
import org.osgi.framework.Bundle;

public class AlternativeUMLItemProviderAdapterFactory extends UMLItemProviderAdapterFactory {

	public AlternativeUMLItemProviderAdapterFactory(IPreferenceStore preferenceStore) {
		myPreferenceStore = preferenceStore;
	}

	public Adapter createCommentAdapter() {
		if (commentItemProvider == null) {
			commentItemProvider = new CommentItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Comment.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return commentItemProvider;
	}

	public Adapter createDependencyAdapter() {
		if (dependencyItemProvider == null) {
			dependencyItemProvider = new DependencyItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Dependency.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return dependencyItemProvider;
	}

	public Adapter createTemplateParameterAdapter() {
		if (templateParameterItemProvider == null) {
			templateParameterItemProvider = new TemplateParameterItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TemplateParameter.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return templateParameterItemProvider;
	}

	public Adapter createTemplateSignatureAdapter() {
		if (templateSignatureItemProvider == null) {
			templateSignatureItemProvider = new TemplateSignatureItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TemplateSignature.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return templateSignatureItemProvider;
	}

	public Adapter createTemplateBindingAdapter() {
		if (templateBindingItemProvider == null) {
			templateBindingItemProvider = new TemplateBindingItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TemplateBinding.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return templateBindingItemProvider;
	}

	public Adapter createTemplateParameterSubstitutionAdapter() {
		if (templateParameterSubstitutionItemProvider == null) {
			templateParameterSubstitutionItemProvider = new TemplateParameterSubstitutionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TemplateParameterSubstitution.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return templateParameterSubstitutionItemProvider;
	}

	public Adapter createElementImportAdapter() {
		if (elementImportItemProvider == null) {
			elementImportItemProvider = new ElementImportItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ElementImport.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return elementImportItemProvider;
	}

	public Adapter createPackageImportAdapter() {
		if (packageImportItemProvider == null) {
			packageImportItemProvider = new PackageImportItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/PackageImport.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return packageImportItemProvider;
	}

	public Adapter createPackageAdapter() {
		if (packageItemProvider == null) {
			packageItemProvider = new PackageItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Package.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return packageItemProvider;
	}

	public Adapter createPackageMergeAdapter() {
		if (packageMergeItemProvider == null) {
			packageMergeItemProvider = new PackageMergeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/PackageMerge.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return packageMergeItemProvider;
	}

	public Adapter createProfileApplicationAdapter() {
		if (profileApplicationItemProvider == null) {
			profileApplicationItemProvider = new ProfileApplicationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ProfileApplication.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return profileApplicationItemProvider;
	}

	public Adapter createProfileAdapter() {
		if (profileItemProvider == null) {
			profileItemProvider = new ProfileItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Profile.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return profileItemProvider;
	}

	public Adapter createStereotypeAdapter() {
		if (stereotypeItemProvider == null) {
			stereotypeItemProvider = new StereotypeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Stereotype.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return stereotypeItemProvider;
	}

	public Adapter createImageAdapter() {
		if (imageItemProvider == null) {
			imageItemProvider = new ImageItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Image.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return imageItemProvider;
	}

	public Adapter createClassAdapter() {
		if (classItemProvider == null) {
			classItemProvider = new ClassItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Class.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return classItemProvider;
	}

	public Adapter createGeneralizationAdapter() {
		if (generalizationItemProvider == null) {
			generalizationItemProvider = new GeneralizationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Generalization.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return generalizationItemProvider;
	}

	public Adapter createGeneralizationSetAdapter() {
		if (generalizationSetItemProvider == null) {
			generalizationSetItemProvider = new GeneralizationSetItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/GeneralizationSet.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return generalizationSetItemProvider;
	}

	public Adapter createUseCaseAdapter() {
		if (useCaseItemProvider == null) {
			useCaseItemProvider = new UseCaseItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/UseCase.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return useCaseItemProvider;
	}

	public Adapter createIncludeAdapter() {
		if (includeItemProvider == null) {
			includeItemProvider = new IncludeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Include.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return includeItemProvider;
	}

	public Adapter createExtendAdapter() {
		if (extendItemProvider == null) {
			extendItemProvider = new ExtendItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Extend.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return extendItemProvider;
	}

	public Adapter createConstraintAdapter() {
		if (constraintItemProvider == null) {
			constraintItemProvider = new ConstraintItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Constraint.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return constraintItemProvider;
	}

	public Adapter createExtensionPointAdapter() {
		if (extensionPointItemProvider == null) {
			extensionPointItemProvider = new ExtensionPointItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExtensionPoint.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return extensionPointItemProvider;
	}

	public Adapter createSubstitutionAdapter() {
		if (substitutionItemProvider == null) {
			substitutionItemProvider = new SubstitutionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Substitution.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return substitutionItemProvider;
	}

	public Adapter createRealizationAdapter() {
		if (realizationItemProvider == null) {
			realizationItemProvider = new RealizationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Realization.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return realizationItemProvider;
	}

	public Adapter createAbstractionAdapter() {
		if (abstractionItemProvider == null) {
			abstractionItemProvider = new AbstractionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Abstraction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return abstractionItemProvider;
	}

	public Adapter createOpaqueExpressionAdapter() {
		if (opaqueExpressionItemProvider == null) {
			opaqueExpressionItemProvider = new OpaqueExpressionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/OpaqueExpression.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return opaqueExpressionItemProvider;
	}

	public Adapter createParameterAdapter() {
		if (parameterItemProvider == null) {
			parameterItemProvider = new ParameterItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Parameter.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return parameterItemProvider;
	}

	public Adapter createConnectorEndAdapter() {
		if (connectorEndItemProvider == null) {
			connectorEndItemProvider = new ConnectorEndItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ConnectorEnd.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return connectorEndItemProvider;
	}

	public Adapter createPropertyAdapter() {
		if (propertyItemProvider == null) {
			propertyItemProvider = new PropertyItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Property.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return propertyItemProvider;
	}

	public Adapter createDeploymentAdapter() {
		if (deploymentItemProvider == null) {
			deploymentItemProvider = new DeploymentItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Deployment.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return deploymentItemProvider;
	}

	public Adapter createDeploymentSpecificationAdapter() {
		if (deploymentSpecificationItemProvider == null) {
			deploymentSpecificationItemProvider = new DeploymentSpecificationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DeploymentSpecification.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return deploymentSpecificationItemProvider;
	}

	public Adapter createArtifactAdapter() {
		if (artifactItemProvider == null) {
			artifactItemProvider = new ArtifactItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Artifact.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return artifactItemProvider;
	}

	public Adapter createManifestationAdapter() {
		if (manifestationItemProvider == null) {
			manifestationItemProvider = new ManifestationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Manifestation.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return manifestationItemProvider;
	}

	public Adapter createOperationAdapter() {
		if (operationItemProvider == null) {
			operationItemProvider = new OperationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Operation.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return operationItemProvider;
	}

	public Adapter createParameterSetAdapter() {
		if (parameterSetItemProvider == null) {
			parameterSetItemProvider = new ParameterSetItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ParameterSet.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return parameterSetItemProvider;
	}

	public Adapter createDataTypeAdapter() {
		if (dataTypeItemProvider == null) {
			dataTypeItemProvider = new DataTypeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DataType.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return dataTypeItemProvider;
	}

	public Adapter createInterfaceAdapter() {
		if (interfaceItemProvider == null) {
			interfaceItemProvider = new InterfaceItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Interface.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return interfaceItemProvider;
	}

	public Adapter createReceptionAdapter() {
		if (receptionItemProvider == null) {
			receptionItemProvider = new ReceptionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Reception.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return receptionItemProvider;
	}

	public Adapter createSignalAdapter() {
		if (signalItemProvider == null) {
			signalItemProvider = new SignalItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Signal.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return signalItemProvider;
	}

	public Adapter createProtocolStateMachineAdapter() {
		if (protocolStateMachineItemProvider == null) {
			protocolStateMachineItemProvider = new ProtocolStateMachineItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ProtocolStateMachine.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return protocolStateMachineItemProvider;
	}

	public Adapter createStateMachineAdapter() {
		if (stateMachineItemProvider == null) {
			stateMachineItemProvider = new StateMachineItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/StateMachine.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return stateMachineItemProvider;
	}

	public Adapter createRegionAdapter() {
		if (regionItemProvider == null) {
			regionItemProvider = new RegionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Region.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return regionItemProvider;
	}

	public Adapter createTransitionAdapter() {
		if (transitionItemProvider == null) {
			transitionItemProvider = new TransitionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Transition.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return transitionItemProvider;
	}

	public Adapter createTriggerAdapter() {
		if (triggerItemProvider == null) {
			triggerItemProvider = new TriggerItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Trigger.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return triggerItemProvider;
	}

	public Adapter createPortAdapter() {
		if (portItemProvider == null) {
			portItemProvider = new PortItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Port.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return portItemProvider;
	}

	public Adapter createStateAdapter() {
		if (stateItemProvider == null) {
			stateItemProvider = new StateItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/State.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return stateItemProvider;
	}

	public Adapter createConnectionPointReferenceAdapter() {
		if (connectionPointReferenceItemProvider == null) {
			connectionPointReferenceItemProvider = new ConnectionPointReferenceItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ConnectionPointReference.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return connectionPointReferenceItemProvider;
	}

	public Adapter createPseudostateAdapter() {
		if (pseudostateItemProvider == null) {
			pseudostateItemProvider = new PseudostateItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Pseudostate.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return pseudostateItemProvider;
	}

	public Adapter createProtocolConformanceAdapter() {
		if (protocolConformanceItemProvider == null) {
			protocolConformanceItemProvider = new ProtocolConformanceItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ProtocolConformance.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return protocolConformanceItemProvider;
	}

	public Adapter createOperationTemplateParameterAdapter() {
		if (operationTemplateParameterItemProvider == null) {
			operationTemplateParameterItemProvider = new OperationTemplateParameterItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/OperationTemplateParameter.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return operationTemplateParameterItemProvider;
	}

	public Adapter createAssociationAdapter() {
		if (associationItemProvider == null) {
			associationItemProvider = new AssociationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Association.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return associationItemProvider;
	}

	public Adapter createConnectableElementTemplateParameterAdapter() {
		if (connectableElementTemplateParameterItemProvider == null) {
			connectableElementTemplateParameterItemProvider = new ConnectableElementTemplateParameterItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ConnectableElementTemplateParameter.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return connectableElementTemplateParameterItemProvider;
	}

	public Adapter createCollaborationUseAdapter() {
		if (collaborationUseItemProvider == null) {
			collaborationUseItemProvider = new CollaborationUseItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CollaborationUse.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return collaborationUseItemProvider;
	}

	public Adapter createCollaborationAdapter() {
		if (collaborationItemProvider == null) {
			collaborationItemProvider = new CollaborationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Collaboration.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return collaborationItemProvider;
	}

	public Adapter createConnectorAdapter() {
		if (connectorItemProvider == null) {
			connectorItemProvider = new ConnectorItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Connector.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return connectorItemProvider;
	}

	public Adapter createRedefinableTemplateSignatureAdapter() {
		if (redefinableTemplateSignatureItemProvider == null) {
			redefinableTemplateSignatureItemProvider = new RedefinableTemplateSignatureItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/RedefinableTemplateSignature.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return redefinableTemplateSignatureItemProvider;
	}

	public Adapter createClassifierTemplateParameterAdapter() {
		if (classifierTemplateParameterItemProvider == null) {
			classifierTemplateParameterItemProvider = new ClassifierTemplateParameterItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ClassifierTemplateParameter.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return classifierTemplateParameterItemProvider;
	}

	public Adapter createInterfaceRealizationAdapter() {
		if (interfaceRealizationItemProvider == null) {
			interfaceRealizationItemProvider = new InterfaceRealizationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InterfaceRealization.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return interfaceRealizationItemProvider;
	}

	public Adapter createExtensionAdapter() {
		if (extensionItemProvider == null) {
			extensionItemProvider = new ExtensionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Extension.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return extensionItemProvider;
	}

	public Adapter createExtensionEndAdapter() {
		if (extensionEndItemProvider == null) {
			extensionEndItemProvider = new ExtensionEndItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExtensionEnd.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return extensionEndItemProvider;
	}

	public Adapter createStringExpressionAdapter() {
		if (stringExpressionItemProvider == null) {
			stringExpressionItemProvider = new StringExpressionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/StringExpression.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return stringExpressionItemProvider;
	}

	public Adapter createExpressionAdapter() {
		if (expressionItemProvider == null) {
			expressionItemProvider = new ExpressionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Expression.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return expressionItemProvider;
	}

	public Adapter createLiteralIntegerAdapter() {
		if (literalIntegerItemProvider == null) {
			literalIntegerItemProvider = new LiteralIntegerItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LiteralInteger.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return literalIntegerItemProvider;
	}

	public Adapter createLiteralStringAdapter() {
		if (literalStringItemProvider == null) {
			literalStringItemProvider = new LiteralStringItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LiteralString.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return literalStringItemProvider;
	}

	public Adapter createLiteralBooleanAdapter() {
		if (literalBooleanItemProvider == null) {
			literalBooleanItemProvider = new LiteralBooleanItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LiteralBoolean.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return literalBooleanItemProvider;
	}

	public Adapter createLiteralNullAdapter() {
		if (literalNullItemProvider == null) {
			literalNullItemProvider = new LiteralNullItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LiteralNull.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return literalNullItemProvider;
	}

	public Adapter createSlotAdapter() {
		if (slotItemProvider == null) {
			slotItemProvider = new SlotItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Slot.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return slotItemProvider;
	}

	public Adapter createInstanceSpecificationAdapter() {
		if (instanceSpecificationItemProvider == null) {
			instanceSpecificationItemProvider = new InstanceSpecificationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InstanceSpecification.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return instanceSpecificationItemProvider;
	}

	public Adapter createEnumerationAdapter() {
		if (enumerationItemProvider == null) {
			enumerationItemProvider = new EnumerationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Enumeration.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return enumerationItemProvider;
	}

	public Adapter createEnumerationLiteralAdapter() {
		if (enumerationLiteralItemProvider == null) {
			enumerationLiteralItemProvider = new EnumerationLiteralItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/EnumerationLiteral.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return enumerationLiteralItemProvider;
	}

	public Adapter createPrimitiveTypeAdapter() {
		if (primitiveTypeItemProvider == null) {
			primitiveTypeItemProvider = new PrimitiveTypeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/PrimitiveType.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return primitiveTypeItemProvider;
	}

	public Adapter createInstanceValueAdapter() {
		if (instanceValueItemProvider == null) {
			instanceValueItemProvider = new InstanceValueItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InstanceValue.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return instanceValueItemProvider;
	}

	public Adapter createLiteralUnlimitedNaturalAdapter() {
		if (literalUnlimitedNaturalItemProvider == null) {
			literalUnlimitedNaturalItemProvider = new LiteralUnlimitedNaturalItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LiteralUnlimitedNatural.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return literalUnlimitedNaturalItemProvider;
	}

	public Adapter createOpaqueBehaviorAdapter() {
		if (opaqueBehaviorItemProvider == null) {
			opaqueBehaviorItemProvider = new OpaqueBehaviorItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/OpaqueBehavior.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return opaqueBehaviorItemProvider;
	}

	public Adapter createFunctionBehaviorAdapter() {
		if (functionBehaviorItemProvider == null) {
			functionBehaviorItemProvider = new FunctionBehaviorItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/FunctionBehavior.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return functionBehaviorItemProvider;
	}

	public Adapter createActorAdapter() {
		if (actorItemProvider == null) {
			actorItemProvider = new ActorItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Actor.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return actorItemProvider;
	}

	public Adapter createUsageAdapter() {
		if (usageItemProvider == null) {
			usageItemProvider = new UsageItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Usage.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return usageItemProvider;
	}

	public Adapter createMessageAdapter() {
		if (messageItemProvider == null) {
			messageItemProvider = new MessageItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Message.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return messageItemProvider;
	}

	public Adapter createInteractionAdapter() {
		if (interactionItemProvider == null) {
			interactionItemProvider = new InteractionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Interaction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return interactionItemProvider;
	}

	public Adapter createLifelineAdapter() {
		if (lifelineItemProvider == null) {
			lifelineItemProvider = new LifelineItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Lifeline.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return lifelineItemProvider;
	}

	public Adapter createPartDecompositionAdapter() {
		if (partDecompositionItemProvider == null) {
			partDecompositionItemProvider = new PartDecompositionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/PartDecomposition.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return partDecompositionItemProvider;
	}

	public Adapter createInteractionUseAdapter() {
		if (interactionUseItemProvider == null) {
			interactionUseItemProvider = new InteractionUseItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InteractionUse.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return interactionUseItemProvider;
	}

	public Adapter createGateAdapter() {
		if (gateItemProvider == null) {
			gateItemProvider = new GateItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Gate.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return gateItemProvider;
	}

	public Adapter createActivityAdapter() {
		if (activityItemProvider == null) {
			activityItemProvider = new ActivityItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Activity.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return activityItemProvider;
	}

	public Adapter createActivityPartitionAdapter() {
		if (activityPartitionItemProvider == null) {
			activityPartitionItemProvider = new ActivityPartitionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ActivityPartition.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return activityPartitionItemProvider;
	}

	public Adapter createStructuredActivityNodeAdapter() {
		if (structuredActivityNodeItemProvider == null) {
			structuredActivityNodeItemProvider = new StructuredActivityNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/StructuredActivityNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return structuredActivityNodeItemProvider;
	}

	public Adapter createVariableAdapter() {
		if (variableItemProvider == null) {
			variableItemProvider = new VariableItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Variable.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return variableItemProvider;
	}

	public Adapter createInterruptibleActivityRegionAdapter() {
		if (interruptibleActivityRegionItemProvider == null) {
			interruptibleActivityRegionItemProvider = new InterruptibleActivityRegionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InterruptibleActivityRegion.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return interruptibleActivityRegionItemProvider;
	}

	public Adapter createExceptionHandlerAdapter() {
		if (exceptionHandlerItemProvider == null) {
			exceptionHandlerItemProvider = new ExceptionHandlerItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExceptionHandler.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return exceptionHandlerItemProvider;
	}

	public Adapter createOutputPinAdapter() {
		if (outputPinItemProvider == null) {
			outputPinItemProvider = new OutputPinItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/OutputPin.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return outputPinItemProvider;
	}

	public Adapter createPinAdapter() {
		if (pinItemProvider == null) {
			pinItemProvider = new PinItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Pin.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return pinItemProvider;
	}

	public Adapter createInputPinAdapter() {
		if (inputPinItemProvider == null) {
			inputPinItemProvider = new InputPinItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InputPin.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return inputPinItemProvider;
	}

	public Adapter createGeneralOrderingAdapter() {
		if (generalOrderingItemProvider == null) {
			generalOrderingItemProvider = new GeneralOrderingItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/GeneralOrdering.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return generalOrderingItemProvider;
	}

	public Adapter createOccurrenceSpecificationAdapter() {
		if (occurrenceSpecificationItemProvider == null) {
			occurrenceSpecificationItemProvider = new OccurrenceSpecificationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/OccurrenceSpecification.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return occurrenceSpecificationItemProvider;
	}

	public Adapter createInteractionOperandAdapter() {
		if (interactionOperandItemProvider == null) {
			interactionOperandItemProvider = new InteractionOperandItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InteractionOperand.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return interactionOperandItemProvider;
	}

	public Adapter createInteractionConstraintAdapter() {
		if (interactionConstraintItemProvider == null) {
			interactionConstraintItemProvider = new InteractionConstraintItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InteractionConstraint.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return interactionConstraintItemProvider;
	}

	public Adapter createExecutionOccurrenceSpecificationAdapter() {
		if (executionOccurrenceSpecificationItemProvider == null) {
			executionOccurrenceSpecificationItemProvider = new ExecutionOccurrenceSpecificationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExecutionOccurrenceSpecification.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return executionOccurrenceSpecificationItemProvider;
	}

	public Adapter createExecutionEventAdapter() {
		if (executionEventItemProvider == null) {
			executionEventItemProvider = new ExecutionEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExecutionEvent.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return executionEventItemProvider;
	}

	public Adapter createStateInvariantAdapter() {
		if (stateInvariantItemProvider == null) {
			stateInvariantItemProvider = new StateInvariantItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/StateInvariant.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return stateInvariantItemProvider;
	}

	public Adapter createActionExecutionSpecificationAdapter() {
		if (actionExecutionSpecificationItemProvider == null) {
			actionExecutionSpecificationItemProvider = new ActionExecutionSpecificationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ActionExecutionSpecification.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return actionExecutionSpecificationItemProvider;
	}

	public Adapter createBehaviorExecutionSpecificationAdapter() {
		if (behaviorExecutionSpecificationItemProvider == null) {
			behaviorExecutionSpecificationItemProvider = new BehaviorExecutionSpecificationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/BehaviorExecutionSpecification.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return behaviorExecutionSpecificationItemProvider;
	}

	public Adapter createCreationEventAdapter() {
		if (creationEventItemProvider == null) {
			creationEventItemProvider = new CreationEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CreationEvent.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return creationEventItemProvider;
	}

	public Adapter createDestructionEventAdapter() {
		if (destructionEventItemProvider == null) {
			destructionEventItemProvider = new DestructionEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DestructionEvent.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return destructionEventItemProvider;
	}

	public Adapter createSendOperationEventAdapter() {
		if (sendOperationEventItemProvider == null) {
			sendOperationEventItemProvider = new SendOperationEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/SendOperationEvent.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return sendOperationEventItemProvider;
	}

	public Adapter createSendSignalEventAdapter() {
		if (sendSignalEventItemProvider == null) {
			sendSignalEventItemProvider = new SendSignalEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/SendSignalEvent.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return sendSignalEventItemProvider;
	}

	public Adapter createMessageOccurrenceSpecificationAdapter() {
		if (messageOccurrenceSpecificationItemProvider == null) {
			messageOccurrenceSpecificationItemProvider = new MessageOccurrenceSpecificationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/MessageOccurrenceSpecification.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return messageOccurrenceSpecificationItemProvider;
	}

	public Adapter createReceiveOperationEventAdapter() {
		if (receiveOperationEventItemProvider == null) {
			receiveOperationEventItemProvider = new ReceiveOperationEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReceiveOperationEvent.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return receiveOperationEventItemProvider;
	}

	public Adapter createReceiveSignalEventAdapter() {
		if (receiveSignalEventItemProvider == null) {
			receiveSignalEventItemProvider = new ReceiveSignalEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReceiveSignalEvent.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return receiveSignalEventItemProvider;
	}

	public Adapter createCombinedFragmentAdapter() {
		if (combinedFragmentItemProvider == null) {
			combinedFragmentItemProvider = new CombinedFragmentItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CombinedFragment.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return combinedFragmentItemProvider;
	}

	public Adapter createContinuationAdapter() {
		if (continuationItemProvider == null) {
			continuationItemProvider = new ContinuationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Continuation.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return continuationItemProvider;
	}

	public Adapter createConsiderIgnoreFragmentAdapter() {
		if (considerIgnoreFragmentItemProvider == null) {
			considerIgnoreFragmentItemProvider = new ConsiderIgnoreFragmentItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ConsiderIgnoreFragment.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return considerIgnoreFragmentItemProvider;
	}

	public Adapter createCallEventAdapter() {
		if (callEventItemProvider == null) {
			callEventItemProvider = new CallEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CallEvent.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return callEventItemProvider;
	}

	public Adapter createChangeEventAdapter() {
		if (changeEventItemProvider == null) {
			changeEventItemProvider = new ChangeEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ChangeEvent.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return changeEventItemProvider;
	}

	public Adapter createSignalEventAdapter() {
		if (signalEventItemProvider == null) {
			signalEventItemProvider = new SignalEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/SignalEvent.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return signalEventItemProvider;
	}

	public Adapter createAnyReceiveEventAdapter() {
		if (anyReceiveEventItemProvider == null) {
			anyReceiveEventItemProvider = new AnyReceiveEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/AnyReceiveEvent.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return anyReceiveEventItemProvider;
	}

	public Adapter createCreateObjectActionAdapter() {
		if (createObjectActionItemProvider == null) {
			createObjectActionItemProvider = new CreateObjectActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CreateObjectAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return createObjectActionItemProvider;
	}

	public Adapter createDestroyObjectActionAdapter() {
		if (destroyObjectActionItemProvider == null) {
			destroyObjectActionItemProvider = new DestroyObjectActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DestroyObjectAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return destroyObjectActionItemProvider;
	}

	public Adapter createTestIdentityActionAdapter() {
		if (testIdentityActionItemProvider == null) {
			testIdentityActionItemProvider = new TestIdentityActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TestIdentityAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return testIdentityActionItemProvider;
	}

	public Adapter createReadSelfActionAdapter() {
		if (readSelfActionItemProvider == null) {
			readSelfActionItemProvider = new ReadSelfActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadSelfAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return readSelfActionItemProvider;
	}

	public Adapter createReadStructuralFeatureActionAdapter() {
		if (readStructuralFeatureActionItemProvider == null) {
			readStructuralFeatureActionItemProvider = new ReadStructuralFeatureActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadStructuralFeatureAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return readStructuralFeatureActionItemProvider;
	}

	public Adapter createClearStructuralFeatureActionAdapter() {
		if (clearStructuralFeatureActionItemProvider == null) {
			clearStructuralFeatureActionItemProvider = new ClearStructuralFeatureActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ClearStructuralFeatureAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return clearStructuralFeatureActionItemProvider;
	}

	public Adapter createRemoveStructuralFeatureValueActionAdapter() {
		if (removeStructuralFeatureValueActionItemProvider == null) {
			removeStructuralFeatureValueActionItemProvider = new RemoveStructuralFeatureValueActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/RemoveStructuralFeatureValueAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return removeStructuralFeatureValueActionItemProvider;
	}

	public Adapter createAddStructuralFeatureValueActionAdapter() {
		if (addStructuralFeatureValueActionItemProvider == null) {
			addStructuralFeatureValueActionItemProvider = new AddStructuralFeatureValueActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/AddStructuralFeatureValueAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return addStructuralFeatureValueActionItemProvider;
	}

	public Adapter createLinkEndDataAdapter() {
		if (linkEndDataItemProvider == null) {
			linkEndDataItemProvider = new LinkEndDataItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LinkEndData.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return linkEndDataItemProvider;
	}

	public Adapter createQualifierValueAdapter() {
		if (qualifierValueItemProvider == null) {
			qualifierValueItemProvider = new QualifierValueItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/QualifierValue.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return qualifierValueItemProvider;
	}

	public Adapter createReadLinkActionAdapter() {
		if (readLinkActionItemProvider == null) {
			readLinkActionItemProvider = new ReadLinkActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadLinkAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return readLinkActionItemProvider;
	}

	public Adapter createLinkEndCreationDataAdapter() {
		if (linkEndCreationDataItemProvider == null) {
			linkEndCreationDataItemProvider = new LinkEndCreationDataItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LinkEndCreationData.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return linkEndCreationDataItemProvider;
	}

	public Adapter createCreateLinkActionAdapter() {
		if (createLinkActionItemProvider == null) {
			createLinkActionItemProvider = new CreateLinkActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CreateLinkAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return createLinkActionItemProvider;
	}

	public Adapter createDestroyLinkActionAdapter() {
		if (destroyLinkActionItemProvider == null) {
			destroyLinkActionItemProvider = new DestroyLinkActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DestroyLinkAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return destroyLinkActionItemProvider;
	}

	public Adapter createLinkEndDestructionDataAdapter() {
		if (linkEndDestructionDataItemProvider == null) {
			linkEndDestructionDataItemProvider = new LinkEndDestructionDataItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LinkEndDestructionData.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return linkEndDestructionDataItemProvider;
	}

	public Adapter createClearAssociationActionAdapter() {
		if (clearAssociationActionItemProvider == null) {
			clearAssociationActionItemProvider = new ClearAssociationActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ClearAssociationAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return clearAssociationActionItemProvider;
	}

	public Adapter createBroadcastSignalActionAdapter() {
		if (broadcastSignalActionItemProvider == null) {
			broadcastSignalActionItemProvider = new BroadcastSignalActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/BroadcastSignalAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return broadcastSignalActionItemProvider;
	}

	public Adapter createSendObjectActionAdapter() {
		if (sendObjectActionItemProvider == null) {
			sendObjectActionItemProvider = new SendObjectActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/SendObjectAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return sendObjectActionItemProvider;
	}

	public Adapter createValueSpecificationActionAdapter() {
		if (valueSpecificationActionItemProvider == null) {
			valueSpecificationActionItemProvider = new ValueSpecificationActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ValueSpecificationAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return valueSpecificationActionItemProvider;
	}

	public Adapter createTimeExpressionAdapter() {
		if (timeExpressionItemProvider == null) {
			timeExpressionItemProvider = new TimeExpressionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TimeExpression.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return timeExpressionItemProvider;
	}

	public Adapter createDurationAdapter() {
		if (durationItemProvider == null) {
			durationItemProvider = new DurationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Duration.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return durationItemProvider;
	}

	public Adapter createValuePinAdapter() {
		if (valuePinItemProvider == null) {
			valuePinItemProvider = new ValuePinItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ValuePin.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return valuePinItemProvider;
	}

	public Adapter createDurationIntervalAdapter() {
		if (durationIntervalItemProvider == null) {
			durationIntervalItemProvider = new DurationIntervalItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DurationInterval.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return durationIntervalItemProvider;
	}

	public Adapter createIntervalAdapter() {
		if (intervalItemProvider == null) {
			intervalItemProvider = new IntervalItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Interval.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return intervalItemProvider;
	}

	public Adapter createTimeConstraintAdapter() {
		if (timeConstraintItemProvider == null) {
			timeConstraintItemProvider = new TimeConstraintItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TimeConstraint.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return timeConstraintItemProvider;
	}

	public Adapter createIntervalConstraintAdapter() {
		if (intervalConstraintItemProvider == null) {
			intervalConstraintItemProvider = new IntervalConstraintItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/IntervalConstraint.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return intervalConstraintItemProvider;
	}

	public Adapter createTimeIntervalAdapter() {
		if (timeIntervalItemProvider == null) {
			timeIntervalItemProvider = new TimeIntervalItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TimeInterval.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return timeIntervalItemProvider;
	}

	public Adapter createDurationConstraintAdapter() {
		if (durationConstraintItemProvider == null) {
			durationConstraintItemProvider = new DurationConstraintItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DurationConstraint.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return durationConstraintItemProvider;
	}

	public Adapter createTimeObservationAdapter() {
		if (timeObservationItemProvider == null) {
			timeObservationItemProvider = new TimeObservationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TimeObservation.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return timeObservationItemProvider;
	}

	public Adapter createDurationObservationAdapter() {
		if (durationObservationItemProvider == null) {
			durationObservationItemProvider = new DurationObservationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DurationObservation.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return durationObservationItemProvider;
	}

	public Adapter createOpaqueActionAdapter() {
		if (opaqueActionItemProvider == null) {
			opaqueActionItemProvider = new OpaqueActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/OpaqueAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return opaqueActionItemProvider;
	}

	public Adapter createSendSignalActionAdapter() {
		if (sendSignalActionItemProvider == null) {
			sendSignalActionItemProvider = new SendSignalActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/SendSignalAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return sendSignalActionItemProvider;
	}

	public Adapter createCallOperationActionAdapter() {
		if (callOperationActionItemProvider == null) {
			callOperationActionItemProvider = new CallOperationActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CallOperationAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return callOperationActionItemProvider;
	}

	public Adapter createCallBehaviorActionAdapter() {
		if (callBehaviorActionItemProvider == null) {
			callBehaviorActionItemProvider = new CallBehaviorActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CallBehaviorAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return callBehaviorActionItemProvider;
	}

	public Adapter createInformationItemAdapter() {
		if (informationItemItemProvider == null) {
			informationItemItemProvider = new InformationItemItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InformationItem.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return informationItemItemProvider;
	}

	public Adapter createInformationFlowAdapter() {
		if (informationFlowItemProvider == null) {
			informationFlowItemProvider = new InformationFlowItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InformationFlow.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return informationFlowItemProvider;
	}

	public Adapter createModelAdapter() {
		if (modelItemProvider == null) {
			modelItemProvider = new ModelItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Model.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return modelItemProvider;
	}

	public Adapter createReadVariableActionAdapter() {
		if (readVariableActionItemProvider == null) {
			readVariableActionItemProvider = new ReadVariableActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadVariableAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return readVariableActionItemProvider;
	}

	public Adapter createClearVariableActionAdapter() {
		if (clearVariableActionItemProvider == null) {
			clearVariableActionItemProvider = new ClearVariableActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ClearVariableAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return clearVariableActionItemProvider;
	}

	public Adapter createAddVariableValueActionAdapter() {
		if (addVariableValueActionItemProvider == null) {
			addVariableValueActionItemProvider = new AddVariableValueActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/AddVariableValueAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return addVariableValueActionItemProvider;
	}

	public Adapter createRemoveVariableValueActionAdapter() {
		if (removeVariableValueActionItemProvider == null) {
			removeVariableValueActionItemProvider = new RemoveVariableValueActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/RemoveVariableValueAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return removeVariableValueActionItemProvider;
	}

	public Adapter createRaiseExceptionActionAdapter() {
		if (raiseExceptionActionItemProvider == null) {
			raiseExceptionActionItemProvider = new RaiseExceptionActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/RaiseExceptionAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return raiseExceptionActionItemProvider;
	}

	public Adapter createActionInputPinAdapter() {
		if (actionInputPinItemProvider == null) {
			actionInputPinItemProvider = new ActionInputPinItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ActionInputPin.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return actionInputPinItemProvider;
	}

	public Adapter createReadExtentActionAdapter() {
		if (readExtentActionItemProvider == null) {
			readExtentActionItemProvider = new ReadExtentActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadExtentAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return readExtentActionItemProvider;
	}

	public Adapter createReclassifyObjectActionAdapter() {
		if (reclassifyObjectActionItemProvider == null) {
			reclassifyObjectActionItemProvider = new ReclassifyObjectActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReclassifyObjectAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return reclassifyObjectActionItemProvider;
	}

	public Adapter createReadIsClassifiedObjectActionAdapter() {
		if (readIsClassifiedObjectActionItemProvider == null) {
			readIsClassifiedObjectActionItemProvider = new ReadIsClassifiedObjectActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadIsClassifiedObjectAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return readIsClassifiedObjectActionItemProvider;
	}

	public Adapter createStartClassifierBehaviorActionAdapter() {
		if (startClassifierBehaviorActionItemProvider == null) {
			startClassifierBehaviorActionItemProvider = new StartClassifierBehaviorActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/StartClassifierBehaviorAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return startClassifierBehaviorActionItemProvider;
	}

	public Adapter createReadLinkObjectEndActionAdapter() {
		if (readLinkObjectEndActionItemProvider == null) {
			readLinkObjectEndActionItemProvider = new ReadLinkObjectEndActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadLinkObjectEndAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return readLinkObjectEndActionItemProvider;
	}

	public Adapter createReadLinkObjectEndQualifierActionAdapter() {
		if (readLinkObjectEndQualifierActionItemProvider == null) {
			readLinkObjectEndQualifierActionItemProvider = new ReadLinkObjectEndQualifierActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReadLinkObjectEndQualifierAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return readLinkObjectEndQualifierActionItemProvider;
	}

	public Adapter createCreateLinkObjectActionAdapter() {
		if (createLinkObjectActionItemProvider == null) {
			createLinkObjectActionItemProvider = new CreateLinkObjectActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CreateLinkObjectAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return createLinkObjectActionItemProvider;
	}

	public Adapter createAcceptEventActionAdapter() {
		if (acceptEventActionItemProvider == null) {
			acceptEventActionItemProvider = new AcceptEventActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/AcceptEventAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return acceptEventActionItemProvider;
	}

	public Adapter createAcceptCallActionAdapter() {
		if (acceptCallActionItemProvider == null) {
			acceptCallActionItemProvider = new AcceptCallActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/AcceptCallAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return acceptCallActionItemProvider;
	}

	public Adapter createReplyActionAdapter() {
		if (replyActionItemProvider == null) {
			replyActionItemProvider = new ReplyActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReplyAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return replyActionItemProvider;
	}

	public Adapter createUnmarshallActionAdapter() {
		if (unmarshallActionItemProvider == null) {
			unmarshallActionItemProvider = new UnmarshallActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/UnmarshallAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return unmarshallActionItemProvider;
	}

	public Adapter createReduceActionAdapter() {
		if (reduceActionItemProvider == null) {
			reduceActionItemProvider = new ReduceActionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ReduceAction.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return reduceActionItemProvider;
	}

	public Adapter createControlFlowAdapter() {
		if (controlFlowItemProvider == null) {
			controlFlowItemProvider = new ControlFlowItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ControlFlow.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return controlFlowItemProvider;
	}

	public Adapter createInitialNodeAdapter() {
		if (initialNodeItemProvider == null) {
			initialNodeItemProvider = new InitialNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/InitialNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return initialNodeItemProvider;
	}

	public Adapter createActivityParameterNodeAdapter() {
		if (activityParameterNodeItemProvider == null) {
			activityParameterNodeItemProvider = new ActivityParameterNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ActivityParameterNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return activityParameterNodeItemProvider;
	}

	public Adapter createForkNodeAdapter() {
		if (forkNodeItemProvider == null) {
			forkNodeItemProvider = new ForkNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ForkNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return forkNodeItemProvider;
	}

	public Adapter createFlowFinalNodeAdapter() {
		if (flowFinalNodeItemProvider == null) {
			flowFinalNodeItemProvider = new FlowFinalNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/FlowFinalNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return flowFinalNodeItemProvider;
	}

	public Adapter createCentralBufferNodeAdapter() {
		if (centralBufferNodeItemProvider == null) {
			centralBufferNodeItemProvider = new CentralBufferNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CentralBufferNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return centralBufferNodeItemProvider;
	}

	public Adapter createMergeNodeAdapter() {
		if (mergeNodeItemProvider == null) {
			mergeNodeItemProvider = new MergeNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/MergeNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return mergeNodeItemProvider;
	}

	public Adapter createDecisionNodeAdapter() {
		if (decisionNodeItemProvider == null) {
			decisionNodeItemProvider = new DecisionNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DecisionNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return decisionNodeItemProvider;
	}

	public Adapter createActivityFinalNodeAdapter() {
		if (activityFinalNodeItemProvider == null) {
			activityFinalNodeItemProvider = new ActivityFinalNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ActivityFinalNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return activityFinalNodeItemProvider;
	}

	public Adapter createJoinNodeAdapter() {
		if (joinNodeItemProvider == null) {
			joinNodeItemProvider = new JoinNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/JoinNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return joinNodeItemProvider;
	}

	public Adapter createDataStoreNodeAdapter() {
		if (dataStoreNodeItemProvider == null) {
			dataStoreNodeItemProvider = new DataStoreNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/DataStoreNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return dataStoreNodeItemProvider;
	}

	public Adapter createObjectFlowAdapter() {
		if (objectFlowItemProvider == null) {
			objectFlowItemProvider = new ObjectFlowItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ObjectFlow.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return objectFlowItemProvider;
	}

	public Adapter createSequenceNodeAdapter() {
		if (sequenceNodeItemProvider == null) {
			sequenceNodeItemProvider = new SequenceNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/SequenceNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return sequenceNodeItemProvider;
	}

	public Adapter createConditionalNodeAdapter() {
		if (conditionalNodeItemProvider == null) {
			conditionalNodeItemProvider = new ConditionalNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ConditionalNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return conditionalNodeItemProvider;
	}

	public Adapter createClauseAdapter() {
		if (clauseItemProvider == null) {
			clauseItemProvider = new ClauseItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Clause.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return clauseItemProvider;
	}

	public Adapter createLoopNodeAdapter() {
		if (loopNodeItemProvider == null) {
			loopNodeItemProvider = new LoopNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/LoopNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return loopNodeItemProvider;
	}

	public Adapter createExpansionNodeAdapter() {
		if (expansionNodeItemProvider == null) {
			expansionNodeItemProvider = new ExpansionNodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExpansionNode.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return expansionNodeItemProvider;
	}

	public Adapter createExpansionRegionAdapter() {
		if (expansionRegionItemProvider == null) {
			expansionRegionItemProvider = new ExpansionRegionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExpansionRegion.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return expansionRegionItemProvider;
	}

	public Adapter createComponentRealizationAdapter() {
		if (componentRealizationItemProvider == null) {
			componentRealizationItemProvider = new ComponentRealizationItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ComponentRealization.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return componentRealizationItemProvider;
	}

	public Adapter createComponentAdapter() {
		if (componentItemProvider == null) {
			componentItemProvider = new ComponentItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Component.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return componentItemProvider;
	}

	public Adapter createNodeAdapter() {
		if (nodeItemProvider == null) {
			nodeItemProvider = new NodeItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Node.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return nodeItemProvider;
	}

	public Adapter createDeviceAdapter() {
		if (deviceItemProvider == null) {
			deviceItemProvider = new DeviceItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/Device.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return deviceItemProvider;
	}

	public Adapter createExecutionEnvironmentAdapter() {
		if (executionEnvironmentItemProvider == null) {
			executionEnvironmentItemProvider = new ExecutionEnvironmentItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ExecutionEnvironment.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return executionEnvironmentItemProvider;
	}

	public Adapter createCommunicationPathAdapter() {
		if (communicationPathItemProvider == null) {
			communicationPathItemProvider = new CommunicationPathItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/CommunicationPath.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return communicationPathItemProvider;
	}

	public Adapter createFinalStateAdapter() {
		if (finalStateItemProvider == null) {
			finalStateItemProvider = new FinalStateItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/FinalState.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return finalStateItemProvider;
	}

	public Adapter createTimeEventAdapter() {
		if (timeEventItemProvider == null) {
			timeEventItemProvider = new TimeEventItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/TimeEvent.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return timeEventItemProvider;
	}

	public Adapter createProtocolTransitionAdapter() {
		if (protocolTransitionItemProvider == null) {
			protocolTransitionItemProvider = new ProtocolTransitionItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						return overlayImage(object, FileLocator.find(UML_BUNDLE, new Path("icons/obj16/ProtocolTransition.gif"), null));
					}
					return super.getImage(object);
				}
			};
		}
		return protocolTransitionItemProvider;
	}

	public Adapter createAssociationClassAdapter() {
		if (associationClassItemProvider == null) {
			associationClassItemProvider = new AssociationClassItemProvider(this) {

				@Override
				public Object getImage(Object object) {
					if (useAlternativeIcons(object)) {
						URL url = FileLocator.find(UML_BUNDLE, new Path("/icons/obj16/AssociationClass.gif"), null);
						try {
							System.err.println(FileLocator.toFileURL(url));
						} catch (IOException e) {
							e.printStackTrace();
						}
						return overlayImage(object, url);
					}
					return super.getImage(object);
				}
			};
		}
		return associationClassItemProvider;
	}

	private boolean useAlternativeIcons(Object object) {
		return UmlPreferenceConstants.PREF_ICON_STYLE_CHEERFUL.equals(myPreferenceStore.getString(UmlPreferenceConstants.PREF_ICON_STYLE));
	}

	private static final Bundle UML_BUNDLE = Platform.getBundle("org.eclipse.uml2.diagram.common");

	private IPreferenceStore myPreferenceStore;
}
