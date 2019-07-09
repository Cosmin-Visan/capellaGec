/*******************************************************************************
 * Copyright (c) 2006, 2016 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/

package org.polarsys.capella.core.data.information.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.CopyCommand.Helper;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.common.data.modellingcore.provider.AbstractExchangeItemItemProvider;
import org.polarsys.capella.common.model.copypaste.SharedInitializeCopyCommand;
import org.polarsys.capella.core.data.capellacommon.CapellacommonFactory;
import org.polarsys.capella.core.data.capellacore.CapellacoreFactory;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.core.data.capellamodeller.CapellamodellerFactory;
import org.polarsys.capella.core.data.cs.CsFactory;
import org.polarsys.capella.core.data.ctx.CtxFactory;
import org.polarsys.capella.core.data.epbs.EpbsFactory;
import org.polarsys.capella.core.data.fa.FaFactory;
import org.polarsys.capella.core.data.information.ExchangeItem;
import org.polarsys.capella.core.data.information.ExchangeMechanism;
import org.polarsys.capella.core.data.information.InformationFactory;
import org.polarsys.capella.core.data.information.InformationPackage;
import org.polarsys.capella.core.data.information.communication.CommunicationFactory;
import org.polarsys.capella.core.data.information.datatype.DatatypeFactory;
import org.polarsys.capella.core.data.information.datavalue.DatavalueFactory;
import org.polarsys.capella.core.data.interaction.InteractionFactory;
import org.polarsys.capella.core.data.la.LaFactory;
import org.polarsys.capella.core.data.oa.OaFactory;
import org.polarsys.capella.core.data.pa.PaFactory;
import org.polarsys.capella.core.data.pa.deployment.DeploymentFactory;
import org.polarsys.capella.core.data.requirement.RequirementFactory;
import org.polarsys.capella.core.data.sharedmodel.SharedmodelFactory;
import org.polarsys.kitalpha.emde.extension.ExtensionModelManager;
import org.polarsys.kitalpha.emde.extension.ModelExtensionHelper;
import org.polarsys.kitalpha.emde.model.edit.provider.NewChildDescriptorHelper;

/**
 * This is the item provider adapter for a {@link org.polarsys.capella.core.data.information.ExchangeItem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExchangeItemItemProvider
  extends AbstractExchangeItemItemProvider
  implements  
    IEditingDomainItemProvider, 
    IStructuredItemContentProvider, 
    ITreeItemContentProvider, 
    IItemLabelProvider, 
    IItemPropertySource {
  
  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IItemPropertyDescriptor statusPropertyDescriptor;

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExchangeItemItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void checkChildCreationExtender(Object object) {
		super.checkChildCreationExtender(object);
		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			// Process CapellacorePackage.Literals.CAPELLA_ELEMENT__STATUS
			if (statusPropertyDescriptor != null) {
				Object statusValue = eObject.eGet(CapellacorePackage.Literals.CAPELLA_ELEMENT__STATUS, true);
				if (statusValue != null && statusValue instanceof EObject && ModelExtensionHelper.getInstance(eObject).isExtensionModelDisabled((EObject) statusValue)) {
					itemPropertyDescriptors.remove(statusPropertyDescriptor);
				} else if (statusValue == null && ExtensionModelManager.getAnyType(eObject, CapellacorePackage.Literals.CAPELLA_ELEMENT__STATUS) != null) {
					itemPropertyDescriptors.remove(statusPropertyDescriptor);				  					
				} else if (itemPropertyDescriptors.contains(statusPropertyDescriptor) == false) {
					itemPropertyDescriptors.add(statusPropertyDescriptor);
				}
			}
		}		
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addFinalPropertyDescriptor(object);
			addIncomingTracesPropertyDescriptor(object);
			addOutgoingTracesPropertyDescriptor(object);
			addVisibleInDocPropertyDescriptor(object);
			addVisibleInLMPropertyDescriptor(object);
			addSummaryPropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addReviewPropertyDescriptor(object);
			addAppliedPropertyValuesPropertyDescriptor(object);
			addAppliedPropertyValueGroupsPropertyDescriptor(object);
			addStatusPropertyDescriptor(object);
			addFeaturesPropertyDescriptor(object);
			addAppliedRequirementsPropertyDescriptor(object);
			addContainedGenericTracesPropertyDescriptor(object);
			addContainedRequirementsTracesPropertyDescriptor(object);
			addTypedElementsPropertyDescriptor(object);
			addAbstractPropertyDescriptor(object);
			addSuperGeneralizationsPropertyDescriptor(object);
			addSubGeneralizationsPropertyDescriptor(object);
			addSuperPropertyDescriptor(object);
			addSubPropertyDescriptor(object);
			addExchangeMechanismPropertyDescriptor(object);
			addAllocatorInterfacesPropertyDescriptor(object);
			addRealizedExchangeItemsPropertyDescriptor(object);
			addRealizingExchangeItemsPropertyDescriptor(object);
			addRealizingOperationsPropertyDescriptor(object);
		}
		// begin-extension-code
		checkChildCreationExtender(object);
		// end-extension-code
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Incoming Traces feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIncomingTracesPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TraceableElement_incomingTraces_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TraceableElement_incomingTraces_feature", "_UI_TraceableElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ModellingcorePackage.Literals.TRACEABLE_ELEMENT__INCOMING_TRACES,
				 false,
				 false,
				 false,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Outgoing Traces feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutgoingTracesPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_TraceableElement_outgoingTraces_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_TraceableElement_outgoingTraces_feature", "_UI_TraceableElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ModellingcorePackage.Literals.TRACEABLE_ELEMENT__OUTGOING_TRACES,
				 false,
				 false,
				 false,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Visible In Doc feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVisibleInDocPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PublishableElement_visibleInDoc_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PublishableElement_visibleInDoc_feature", "_UI_PublishableElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ModellingcorePackage.Literals.PUBLISHABLE_ELEMENT__VISIBLE_IN_DOC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Visible In LM feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVisibleInLMPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_PublishableElement_visibleInLM_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_PublishableElement_visibleInLM_feature", "_UI_PublishableElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ModellingcorePackage.Literals.PUBLISHABLE_ELEMENT__VISIBLE_IN_LM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Summary feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSummaryPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CapellaElement_summary_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CapellaElement_summary_feature", "_UI_CapellaElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.CAPELLA_ELEMENT__SUMMARY,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CapellaElement_description_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CapellaElement_description_feature", "_UI_CapellaElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.CAPELLA_ELEMENT__DESCRIPTION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Review feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReviewPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CapellaElement_review_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CapellaElement_review_feature", "_UI_CapellaElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.CAPELLA_ELEMENT__REVIEW,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Applied Property Values feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAppliedPropertyValuesPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CapellaElement_appliedPropertyValues_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CapellaElement_appliedPropertyValues_feature", "_UI_CapellaElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.CAPELLA_ELEMENT__APPLIED_PROPERTY_VALUES,
				 true,
				 false,
				 true,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Applied Property Value Groups feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAppliedPropertyValueGroupsPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CapellaElement_appliedPropertyValueGroups_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CapellaElement_appliedPropertyValueGroups_feature", "_UI_CapellaElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.CAPELLA_ELEMENT__APPLIED_PROPERTY_VALUE_GROUPS,
				 true,
				 false,
				 true,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Status feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStatusPropertyDescriptor(Object object) {
		// begin-extension-code
		statusPropertyDescriptor = createItemPropertyDescriptor
		// end-extension-code		
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CapellaElement_status_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CapellaElement_status_feature", "_UI_CapellaElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.CAPELLA_ELEMENT__STATUS,
				 true,
				 false,
				 true,
				 null,
				 null,
		// begin-extension-code
				 null);
		itemPropertyDescriptors.add(statusPropertyDescriptor);
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFeaturesPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CapellaElement_features_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CapellaElement_features_feature", "_UI_CapellaElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.CAPELLA_ELEMENT__FEATURES,
				 true,
				 false,
				 true,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Applied Requirements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAppliedRequirementsPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CapellaElement_appliedRequirements_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_CapellaElement_appliedRequirements_feature", "_UI_CapellaElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.CAPELLA_ELEMENT__APPLIED_REQUIREMENTS,
				 false,
				 false,
				 false,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Contained Generic Traces feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainedGenericTracesPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Namespace_containedGenericTraces_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Namespace_containedGenericTraces_feature", "_UI_Namespace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.NAMESPACE__CONTAINED_GENERIC_TRACES,
				 false,
				 false,
				 false,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Contained Requirements Traces feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContainedRequirementsTracesPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Namespace_containedRequirementsTraces_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Namespace_containedRequirementsTraces_feature", "_UI_Namespace_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.NAMESPACE__CONTAINED_REQUIREMENTS_TRACES,
				 false,
				 false,
				 false,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Typed Elements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypedElementsPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Type_typedElements_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_Type_typedElements_feature", "_UI_Type_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.TYPE__TYPED_ELEMENTS,
				 false,
				 false,
				 false,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Abstract feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAbstractPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GeneralizableElement_abstract_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_GeneralizableElement_abstract_feature", "_UI_GeneralizableElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.GENERALIZABLE_ELEMENT__ABSTRACT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Super Generalizations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuperGeneralizationsPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GeneralizableElement_superGeneralizations_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_GeneralizableElement_superGeneralizations_feature", "_UI_GeneralizableElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.GENERALIZABLE_ELEMENT__SUPER_GENERALIZATIONS,
				 false,
				 false,
				 false,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Sub Generalizations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubGeneralizationsPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GeneralizableElement_subGeneralizations_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_GeneralizableElement_subGeneralizations_feature", "_UI_GeneralizableElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.GENERALIZABLE_ELEMENT__SUB_GENERALIZATIONS,
				 false,
				 false,
				 false,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Super feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSuperPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GeneralizableElement_super_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_GeneralizableElement_super_feature", "_UI_GeneralizableElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.GENERALIZABLE_ELEMENT__SUPER,
				 false,
				 false,
				 false,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Sub feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSubPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_GeneralizableElement_sub_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_GeneralizableElement_sub_feature", "_UI_GeneralizableElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 CapellacorePackage.Literals.GENERALIZABLE_ELEMENT__SUB,
				 false,
				 false,
				 false,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Final feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFinalPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_FinalizableElement_final_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_FinalizableElement_final_feature", "_UI_FinalizableElement_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 ModellingcorePackage.Literals.FINALIZABLE_ELEMENT__FINAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Exchange Mechanism feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExchangeMechanismPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExchangeItem_exchangeMechanism_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ExchangeItem_exchangeMechanism_feature", "_UI_ExchangeItem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 InformationPackage.Literals.EXCHANGE_ITEM__EXCHANGE_MECHANISM,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Allocator Interfaces feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllocatorInterfacesPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExchangeItem_allocatorInterfaces_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ExchangeItem_allocatorInterfaces_feature", "_UI_ExchangeItem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 InformationPackage.Literals.EXCHANGE_ITEM__ALLOCATOR_INTERFACES,
				 false,
				 false,
				 false,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Realized Exchange Items feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRealizedExchangeItemsPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExchangeItem_realizedExchangeItems_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ExchangeItem_realizedExchangeItems_feature", "_UI_ExchangeItem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 InformationPackage.Literals.EXCHANGE_ITEM__REALIZED_EXCHANGE_ITEMS,
				 false,
				 false,
				 false,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Realizing Exchange Items feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRealizingExchangeItemsPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExchangeItem_realizingExchangeItems_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ExchangeItem_realizingExchangeItems_feature", "_UI_ExchangeItem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 InformationPackage.Literals.EXCHANGE_ITEM__REALIZING_EXCHANGE_ITEMS,
				 false,
				 false,
				 false,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This adds a property descriptor for the Realizing Operations feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRealizingOperationsPropertyDescriptor(Object object) {

		// begin-extension-code
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
		// end-extension-code
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ExchangeItem_realizingOperations_feature"), //$NON-NLS-1$
				 getString("_UI_PropertyDescriptor_description", "_UI_ExchangeItem_realizingOperations_feature", "_UI_ExchangeItem_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				 InformationPackage.Literals.EXCHANGE_ITEM__REALIZING_OPERATIONS,
				 false,
				 false,
				 false,
				 null,
				 null,
		// begin-extension-code
				 null));
		// end-extension-code
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(CapellacorePackage.Literals.CAPELLA_ELEMENT__OWNED_PROPERTY_VALUES);
			childrenFeatures.add(CapellacorePackage.Literals.CAPELLA_ELEMENT__OWNED_ENUMERATION_PROPERTY_TYPES);
			childrenFeatures.add(CapellacorePackage.Literals.CAPELLA_ELEMENT__OWNED_PROPERTY_VALUE_GROUPS);
			childrenFeatures.add(CapellacorePackage.Literals.NAMESPACE__OWNED_TRACES);
			childrenFeatures.add(CapellacorePackage.Literals.NAMESPACE__NAMING_RULES);
			childrenFeatures.add(CapellacorePackage.Literals.GENERALIZABLE_ELEMENT__OWNED_GENERALIZATIONS);
			childrenFeatures.add(InformationPackage.Literals.EXCHANGE_ITEM__OWNED_ELEMENTS);
			childrenFeatures.add(InformationPackage.Literals.EXCHANGE_ITEM__OWNED_INFORMATION_REALIZATIONS);
			childrenFeatures.add(InformationPackage.Literals.EXCHANGE_ITEM__OWNED_EXCHANGE_ITEM_INSTANCES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

		/**
	 * This returns ExchangeItem.gif.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Object getImageGen(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ExchangeItem")); //$NON-NLS-1$
	}
  
  /**
   * This returns ExchangeItem.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   */
  @Override
  public Object getImage(Object object) {
    ExchangeItem item = (ExchangeItem)object;
    String imagePath = "full/obj16/ExchangeItem"; //$NON-NLS-1$
    if (item.getExchangeMechanism()==ExchangeMechanism.EVENT) {
      imagePath = "full/obj16/ExchangeItemEvent"; //$NON-NLS-1$
    } else if (item.getExchangeMechanism()==ExchangeMechanism.FLOW) {
      imagePath = "full/obj16/ExchangeItemFlow"; //$NON-NLS-1$
    } else if (item.getExchangeMechanism()==ExchangeMechanism.OPERATION) {
      imagePath = "full/obj16/ExchangeItemOperation"; //$NON-NLS-1$
    } else if (item.getExchangeMechanism()==ExchangeMechanism.SHARED_DATA) { 
      imagePath = "full/obj16/ExchangeItemData"; //$NON-NLS-1$
    }
    
    return overlayImage(object, getResourceLocator().getImage(imagePath));
  }

		/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
	 String[] result = new String[] { null };

    	//begin-capella-code
		String label = ((ExchangeItem)object).getName();
		//end-capella-code
	  
	
			result[0] = label == null || label.length() == 0 ?
			//begin-capella-code
			"[" + getString("_UI_ExchangeItem_type") + "]" : label; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			//end-capella-code

		return result[0];

	}

		/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ExchangeItem.class)) {
			case InformationPackage.EXCHANGE_ITEM__FINAL:
			case InformationPackage.EXCHANGE_ITEM__VISIBLE_IN_DOC:
			case InformationPackage.EXCHANGE_ITEM__VISIBLE_IN_LM:
			case InformationPackage.EXCHANGE_ITEM__SUMMARY:
			case InformationPackage.EXCHANGE_ITEM__DESCRIPTION:
			case InformationPackage.EXCHANGE_ITEM__REVIEW:
			case InformationPackage.EXCHANGE_ITEM__ABSTRACT:
			case InformationPackage.EXCHANGE_ITEM__EXCHANGE_MECHANISM:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case InformationPackage.EXCHANGE_ITEM__OWNED_PROPERTY_VALUES:
			case InformationPackage.EXCHANGE_ITEM__OWNED_ENUMERATION_PROPERTY_TYPES:
			case InformationPackage.EXCHANGE_ITEM__OWNED_PROPERTY_VALUE_GROUPS:
			case InformationPackage.EXCHANGE_ITEM__OWNED_TRACES:
			case InformationPackage.EXCHANGE_ITEM__NAMING_RULES:
			case InformationPackage.EXCHANGE_ITEM__OWNED_GENERALIZATIONS:
			case InformationPackage.EXCHANGE_ITEM__OWNED_ELEMENTS:
			case InformationPackage.EXCHANGE_ITEM__OWNED_INFORMATION_REALIZATIONS:
			case InformationPackage.EXCHANGE_ITEM__OWNED_EXCHANGE_ITEM_INSTANCES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

		/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_CONSTRAINTS,
                         CapellacoreFactory.eINSTANCE.createConstraint());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createProperty());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createAssociation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createClass());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createCollection());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createCollectionValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createCollectionValueReference());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createDataPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createDomainElement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createKeyPart());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createOperationAllocation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createParameter());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createService());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createUnion());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createUnionProperty());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createUnit());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createPortRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createPortAllocation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createExchangeItem());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createExchangeItemElement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createExchangeItemInstance());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createInformationRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InformationFactory.eINSTANCE.createExchangeItemRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellamodellerFactory.eINSTANCE.createProject());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellamodellerFactory.eINSTANCE.createFolder());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellamodellerFactory.eINSTANCE.createSystemEngineering());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellamodellerFactory.eINSTANCE.createSystemEngineeringPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellamodellerFactory.eINSTANCE.createLibrary());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacoreFactory.eINSTANCE.createNamingRule());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacoreFactory.eINSTANCE.createConstraint());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacoreFactory.eINSTANCE.createKeyValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacoreFactory.eINSTANCE.createReuseLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacoreFactory.eINSTANCE.createGeneralization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacoreFactory.eINSTANCE.createStringPropertyValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacoreFactory.eINSTANCE.createIntegerPropertyValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacoreFactory.eINSTANCE.createBooleanPropertyValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacoreFactory.eINSTANCE.createFloatPropertyValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacoreFactory.eINSTANCE.createEnumerationPropertyValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacoreFactory.eINSTANCE.createEnumerationPropertyType());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacoreFactory.eINSTANCE.createEnumerationPropertyLiteral());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacoreFactory.eINSTANCE.createPropertyValueGroup());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacoreFactory.eINSTANCE.createPropertyValuePkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createOperationalAnalysis());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createOperationalActivityPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createOperationalActivity());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createOperationalProcess());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createSwimlane());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createOperationalCapabilityPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createOperationalCapability());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createActivityAllocation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createRolePkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createRole());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createRoleAssemblyUsage());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createRoleAllocation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createEntityPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createEntity());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createConceptPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createConcept());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createConceptCompliance());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createItemInConcept());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createCommunityOfInterest());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createCommunityOfInterestComposition());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createOrganisationalUnit());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createOrganisationalUnitComposition());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createLocation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createCapabilityConfiguration());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createCommunicationMean());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         OaFactory.eINSTANCE.createEntityOperationalCapabilityInvolvement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createSystemAnalysis());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createSystemFunction());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createSystemFunctionPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createSystemCommunicationHook());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createSystemCommunication());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createCapabilityInvolvement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createMissionInvolvement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createMission());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createMissionPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createCapability());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createCapabilityExploitation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createCapabilityPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createOperationalAnalysisRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createSystemComponentPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CtxFactory.eINSTANCE.createSystemComponent());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         LaFactory.eINSTANCE.createLogicalArchitecturePkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         LaFactory.eINSTANCE.createLogicalArchitecture());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         LaFactory.eINSTANCE.createLogicalFunction());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         LaFactory.eINSTANCE.createLogicalFunctionPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         LaFactory.eINSTANCE.createLogicalComponent());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         LaFactory.eINSTANCE.createLogicalComponentPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         LaFactory.eINSTANCE.createCapabilityRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         LaFactory.eINSTANCE.createCapabilityRealizationPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         LaFactory.eINSTANCE.createSystemAnalysisRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         LaFactory.eINSTANCE.createContextInterfaceRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         PaFactory.eINSTANCE.createPhysicalArchitecturePkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         PaFactory.eINSTANCE.createPhysicalArchitecture());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         PaFactory.eINSTANCE.createPhysicalFunction());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         PaFactory.eINSTANCE.createPhysicalFunctionPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         PaFactory.eINSTANCE.createPhysicalComponent());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         PaFactory.eINSTANCE.createPhysicalComponentPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         PaFactory.eINSTANCE.createPhysicalNode());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         PaFactory.eINSTANCE.createLogicalArchitectureRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         PaFactory.eINSTANCE.createLogicalInterfaceRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DeploymentFactory.eINSTANCE.createComponentInstance());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DeploymentFactory.eINSTANCE.createConnectionInstance());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DeploymentFactory.eINSTANCE.createDeploymentAspect());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DeploymentFactory.eINSTANCE.createDeploymentConfiguration());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DeploymentFactory.eINSTANCE.createInstanceDeploymentLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DeploymentFactory.eINSTANCE.createPartDeploymentLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DeploymentFactory.eINSTANCE.createPortInstance());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DeploymentFactory.eINSTANCE.createTypeDeploymentLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         EpbsFactory.eINSTANCE.createEPBSArchitecturePkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         EpbsFactory.eINSTANCE.createEPBSArchitecture());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         EpbsFactory.eINSTANCE.createConfigurationItemPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         EpbsFactory.eINSTANCE.createConfigurationItem());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         EpbsFactory.eINSTANCE.createPhysicalArchitectureRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         EpbsFactory.eINSTANCE.createPhysicalArtifactRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         SharedmodelFactory.eINSTANCE.createSharedPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         SharedmodelFactory.eINSTANCE.createGenericPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         RequirementFactory.eINSTANCE.createRequirementsPkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         RequirementFactory.eINSTANCE.createRequirementsTrace());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         RequirementFactory.eINSTANCE.createSystemFunctionalInterfaceRequirement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         RequirementFactory.eINSTANCE.createSystemFunctionalRequirement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         RequirementFactory.eINSTANCE.createSystemNonFunctionalInterfaceRequirement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         RequirementFactory.eINSTANCE.createSystemNonFunctionalRequirement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         RequirementFactory.eINSTANCE.createSystemUserRequirement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createGenericTrace());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createTransfoLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createJustificationLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createCapabilityRealizationInvolvement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createStateMachine());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createRegion());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createState());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createMode());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createFinalState());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createStateTransition());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createInitialPseudoState());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createJoinPseudoState());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createForkPseudoState());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createChoicePseudoState());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createTerminatePseudoState());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createAbstractStateRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createStateTransitionRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createShallowHistoryPseudoState());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createDeepHistoryPseudoState());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createEntryPointPseudoState());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createExitPointPseudoState());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createStateEventRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createChangeEvent());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CapellacommonFactory.eINSTANCE.createTimeEvent());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CommunicationFactory.eINSTANCE.createException());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CommunicationFactory.eINSTANCE.createMessage());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CommunicationFactory.eINSTANCE.createMessageReference());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CommunicationFactory.eINSTANCE.createSignal());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CommunicationFactory.eINSTANCE.createSignalInstance());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CommunicationFactory.eINSTANCE.createCommunicationLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatatypeFactory.eINSTANCE.createBooleanType());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatatypeFactory.eINSTANCE.createEnumeration());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatatypeFactory.eINSTANCE.createStringType());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatatypeFactory.eINSTANCE.createNumericType());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatatypeFactory.eINSTANCE.createPhysicalQuantity());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatavalueFactory.eINSTANCE.createLiteralBooleanValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatavalueFactory.eINSTANCE.createBooleanReference());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatavalueFactory.eINSTANCE.createEnumerationLiteral());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatavalueFactory.eINSTANCE.createEnumerationReference());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatavalueFactory.eINSTANCE.createLiteralStringValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatavalueFactory.eINSTANCE.createStringReference());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatavalueFactory.eINSTANCE.createLiteralNumericValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatavalueFactory.eINSTANCE.createNumericReference());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatavalueFactory.eINSTANCE.createComplexValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatavalueFactory.eINSTANCE.createComplexValueReference());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatavalueFactory.eINSTANCE.createValuePart());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatavalueFactory.eINSTANCE.createBinaryExpression());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatavalueFactory.eINSTANCE.createUnaryExpression());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         DatavalueFactory.eINSTANCE.createOpaqueExpression());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createPart());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createComponentRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createInterfacePkg());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createInterface());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createInterfaceImplementation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createInterfaceUse());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createExchangeItemAllocation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createPhysicalLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createPhysicalLinkCategory());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createPhysicalLinkEnd());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createPhysicalLinkRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createPhysicalPath());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createPhysicalPathInvolvement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createPhysicalPathReference());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createPhysicalPathRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createPhysicalPort());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         CsFactory.eINSTANCE.createPhysicalPortRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createFunctionSpecification());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createExchangeCategory());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createExchangeLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createExchangeContainment());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createFunctionalExchangeSpecification());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createFunctionalChain());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createFunctionalChainReference());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createFunctionInputPort());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createFunctionOutputPort());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createComponentFunctionalAllocation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createFunctionalChainRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createFunctionalExchangeRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createFunctionRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createFunctionalExchange());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createComponentExchange());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createComponentExchangeAllocation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createComponentExchangeCategory());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createComponentExchangeEnd());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createComponentExchangeFunctionalExchangeAllocation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createComponentExchangeRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createComponentPort());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createComponentPortAllocation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createComponentPortAllocationEnd());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createFunctionalChainInvolvementLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createSequenceLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createFunctionalChainInvolvementFunction());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         FaFactory.eINSTANCE.createControlNode());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createSequenceMessage());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createScenario());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createMessageEnd());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createExecution());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createExecutionEnd());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createCreationEvent());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createDestructionEvent());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createExecutionEvent());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createInstanceRole());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createEventReceiptOperation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createEventSentOperation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createMergeLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createRefinementLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createAbstractCapabilityRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createAbstractCapabilityExtend());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createAbstractCapabilityExtensionPoint());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createAbstractCapabilityGeneralization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createAbstractCapabilityInclude());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createInteractionState());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createInteractionUse());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createCombinedFragment());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createGate());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createInteractionOperand());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createFragmentEnd());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createFunctionalChainAbstractCapabilityInvolvement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createAbstractFunctionAbstractCapabilityInvolvement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createScenarioRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createStateFragment());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createArmTimerEvent());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createCancelTimerEvent());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createConstraintDuration());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS,
                         InteractionFactory.eINSTANCE.createSequenceMessageValuation());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.CAPELLA_ELEMENT__OWNED_PROPERTY_VALUES,
                         CapellacoreFactory.eINSTANCE.createStringPropertyValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.CAPELLA_ELEMENT__OWNED_PROPERTY_VALUES,
                         CapellacoreFactory.eINSTANCE.createIntegerPropertyValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.CAPELLA_ELEMENT__OWNED_PROPERTY_VALUES,
                         CapellacoreFactory.eINSTANCE.createBooleanPropertyValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.CAPELLA_ELEMENT__OWNED_PROPERTY_VALUES,
                         CapellacoreFactory.eINSTANCE.createFloatPropertyValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.CAPELLA_ELEMENT__OWNED_PROPERTY_VALUES,
                         CapellacoreFactory.eINSTANCE.createEnumerationPropertyValue());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.CAPELLA_ELEMENT__OWNED_ENUMERATION_PROPERTY_TYPES,
                         CapellacoreFactory.eINSTANCE.createEnumerationPropertyType());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.CAPELLA_ELEMENT__OWNED_PROPERTY_VALUE_GROUPS,
                         CapellacoreFactory.eINSTANCE.createPropertyValueGroup());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.NAMESPACE__OWNED_TRACES,
                         RequirementFactory.eINSTANCE.createRequirementsTrace());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.NAMESPACE__OWNED_TRACES,
                         CapellacommonFactory.eINSTANCE.createGenericTrace());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.NAMESPACE__OWNED_TRACES,
                         CapellacommonFactory.eINSTANCE.createTransfoLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.NAMESPACE__OWNED_TRACES,
                         CapellacommonFactory.eINSTANCE.createJustificationLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.NAMESPACE__OWNED_TRACES,
                         InteractionFactory.eINSTANCE.createMergeLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.NAMESPACE__OWNED_TRACES,
                         InteractionFactory.eINSTANCE.createRefinementLink());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.NAMESPACE__NAMING_RULES,
                         CapellacoreFactory.eINSTANCE.createNamingRule());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (CapellacorePackage.Literals.GENERALIZABLE_ELEMENT__OWNED_GENERALIZATIONS,
                         CapellacoreFactory.eINSTANCE.createGeneralization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (InformationPackage.Literals.EXCHANGE_ITEM__OWNED_ELEMENTS,
                         InformationFactory.eINSTANCE.createExchangeItemElement());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (InformationPackage.Literals.EXCHANGE_ITEM__OWNED_INFORMATION_REALIZATIONS,
                         InformationFactory.eINSTANCE.createInformationRealization());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


                // begin-extension-code
                {
                    CommandParameter commandParameter = createChildParameter
                        (InformationPackage.Literals.EXCHANGE_ITEM__OWNED_EXCHANGE_ITEM_INSTANCES,
                         InformationFactory.eINSTANCE.createExchangeItemInstance());
                    if (NewChildDescriptorHelper.isValidCommand(object, commandParameter)) {
                        newChildDescriptors.add(commandParameter);      
                    }
                }
                // end-extension-code


	}

		/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_CONSTRAINTS ||
			childFeature == ModellingcorePackage.Literals.MODEL_ELEMENT__OWNED_MIGRATED_ELEMENTS ||
			childFeature == InformationPackage.Literals.EXCHANGE_ITEM__OWNED_ELEMENTS ||
			childFeature == InformationPackage.Literals.EXCHANGE_ITEM__OWNED_EXCHANGE_ITEM_INSTANCES ||
			childFeature == InformationPackage.Literals.EXCHANGE_ITEM__OWNED_INFORMATION_REALIZATIONS ||
			childFeature == CapellacorePackage.Literals.NAMESPACE__NAMING_RULES ||
			childFeature == CapellacorePackage.Literals.GENERALIZABLE_ELEMENT__OWNED_GENERALIZATIONS ||
			childFeature == CapellacorePackage.Literals.CAPELLA_ELEMENT__OWNED_PROPERTY_VALUES ||
			childFeature == CapellacorePackage.Literals.CAPELLA_ELEMENT__OWNED_ENUMERATION_PROPERTY_TYPES ||
			childFeature == CapellacorePackage.Literals.CAPELLA_ELEMENT__OWNED_PROPERTY_VALUE_GROUPS ||
			childFeature == CapellacorePackage.Literals.NAMESPACE__OWNED_TRACES;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2", //$NON-NLS-1$
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Command createInitializeCopyCommand(EditingDomain domain, EObject owner, Helper helper) {
		return new SharedInitializeCopyCommand(domain, owner, helper);
	}

}
