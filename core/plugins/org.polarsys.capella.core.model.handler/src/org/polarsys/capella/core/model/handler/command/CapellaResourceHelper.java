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
package org.polarsys.capella.core.model.handler.command;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.helper.SiriusUtil;
import org.polarsys.capella.common.data.modellingcore.AbstractNamedElement;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.common.helpers.EcoreUtil2;
import org.polarsys.capella.common.mdsofa.common.activator.SolFaCommonActivator;
import org.polarsys.capella.common.mdsofa.common.constant.ICommonConstants;
import org.polarsys.capella.common.mdsofa.common.helper.ExtensionPointHelper;
import org.polarsys.capella.core.model.handler.helpers.ICapellaResourceHelper;
import org.polarsys.kitalpha.emde.model.Element;

/**
 * Helper that deal with Capella resources.
 */
public class CapellaResourceHelper {
  /**
   * The Capella model file extension, value:<code>melodymodeller</code>
   */
  public static final String CAPELLA_MODEL_FILE_EXTENSION = "melodymodeller"; //$NON-NLS-1$
  /**
   * The Capella fragment file extension value:<code>melodyfragment</code>
   */
  public static final String CAPELLA_FRAGMENT_FILE_EXTENSION = "melodyfragment"; //$NON-NLS-1$
  /**
   * The Aird fragment file extension value:<code>airdfragment</code>
   */
  public static final String AIRD_FRAGMENT_FILE_EXTENSION = "airdfragment"; //$NON-NLS-1$
  /**
   * The Aird file extension value:<code>aird</code>
   */
  public static final String AIRD_FILE_EXTENSION = SiriusUtil.SESSION_RESOURCE_EXTENSION;
  /**
   * Fragments default folder name:<code>fragments</code>
   */
  public static final String FRAGMENTS_DEFAULT_FOLDER = "fragments"; //$NON-NLS-1$

  private static boolean __delegatedCapellaResourceHelperLoaded = false;

  private static ICapellaResourceHelper __delegatedCapellaResourceHelper;

  public static final String CAPELLA_PROJECT_NATURE = "org.polarsys.capella.project.nature"; //$NON-NLS-1$

  public static final String CAPELLA_LIBRARY_PROJECT_NATURE = "org.polarsys.capella.library.nature";//$NON-NLS-1$

  public static final String CAPELLA_CONFIGURATION_PROJECT_NATURE = "org.polarsys.capella.core.preferences.project.nature.configNature"; //$NON-NLS-1$

  /**
   * Ensure given resource is writable.<br>
   * If the resource is in read only, a dialog is prompted to ask the end-user to make the resource writable.
   * @param resource
   * @return <code>true</code> means writable; <code>false</code> means read only and the end-user turns down to make the resource writable.
   */
  public static boolean ensureResourceIsWritable(Resource resource) {
    boolean result = false;
    // Precondition.
    if (null == resource) {
      return result;
    }
    IFile file = EcoreUtil2.getFile(resource);
    // Is a read only resource ?
    if ((null != file) && file.isReadOnly()) {
      // Try making the file writable.
      result = SolFaCommonActivator.getDefault().getUserEnforcedHelper().makeFileWritable(file).isOK();
    } else {
      // Resource is writable.
      result = true;
    }
    return result;
  }

  /**
   * Whether or not specified resource has provided file extension.
   * @param resource
   * @param ignoreFragment
   * @param fragmentFileExtension
   * @param modelFileExtension
   * @return
   */
  private static boolean hasFileExtension(IResource resource, boolean ignoreFragment, String fragmentFileExtension, String modelFileExtension) {
    boolean result = false;
    // Precondition.
    if ((null == resource) || (IResource.FILE != resource.getType())) {
      return result;
    }
    String fileExtension = resource.getFileExtension();
    result = modelFileExtension.equals(fileExtension);
    if (!result && !ignoreFragment) {
      result = fragmentFileExtension.equals(fileExtension);
    }
    return result;
  }

  /**
   * Whether or not given resource is an AIRD one i.e a model or a fragment depending on ignoreAirdFragment_p.
   * @param resource
   * @param ignoreAirdFragment <code>true</code> means files with {@link #AIRD_FRAGMENT_FILE_EXTENSION} file extension are ignored.
   * @return <code>true</code> means given resource is a Capella one.
   * @see {@link #AIRD_FRAGMENT_FILE_EXTENSION}, {@link #AIRD_FILE_EXTENSION}
   */
  public static boolean isAirdResource(IResource resource, boolean ignoreAirdFragment) {
    return hasFileExtension(resource, ignoreAirdFragment, AIRD_FRAGMENT_FILE_EXTENSION, AIRD_FILE_EXTENSION);
  }

  /**
   * Whether or not given URI represents an AIRD one i.e a model or a fragment.
   * @param uri
   * @return <code>true</code> means the file extension is either {@link #AIRD_FRAGMENT_FILE_EXTENSION} or {@link #AIRD_FILE_EXTENSION}.
   * @see {@link #AIRD_FRAGMENT_FILE_EXTENSION}, {@link #AIRD_FILE_EXTENSION}
   */
  public static boolean isAirdResource(URI uri) {
    return (uri != null) && (AIRD_FILE_EXTENSION.equals(uri.fileExtension()) || AIRD_FRAGMENT_FILE_EXTENSION.equals(uri.fileExtension()));
  }

  /**
   * Whether or not given resource is a Capella fragment.
   * @param uri
   * @return <code>true</code> means given resource is a Capella fragment.
   * @see #CAPELLA_FRAGMENT_FILE_EXTENSION
   */
  public static boolean isCapellaFragment(URI uri) {
    return (null != uri) ? CAPELLA_FRAGMENT_FILE_EXTENSION.equals(uri.fileExtension()) : false;
  }

  /**
   * Whether or not given resource is a Capella one i.e a model or a fragment.
   * @param resource
   * @return <code>true</code> means given resource is a Capella one.
   * @see {@link #CAPELLA_FRAGMENT_FILE_EXTENSION}, {@link #CAPELLA_MODEL_FILE_EXTENSION}
   */
  public static boolean isCapellaResource(IResource resource) {
    return isCapellaResource(resource, false);
  }

  /**
   * Whether or not given resource is a Capella one i.e a model or a fragment depending on ignoreCapellaFragment_p.
   * @param resource
   * @param ignoreCapellaFragment <code>true</code> means files with {@link #CAPELLA_FRAGMENT_FILE_EXTENSION} file extension are ignored.
   * @return <code>true</code> means given resource is a Capella one.
   * @see {@link #CAPELLA_FRAGMENT_FILE_EXTENSION}, {@link #CAPELLA_MODEL_FILE_EXTENSION}
   */
  public static boolean isCapellaResource(IResource resource, boolean ignoreCapellaFragment) {
    return hasFileExtension(resource, ignoreCapellaFragment, CAPELLA_FRAGMENT_FILE_EXTENSION, CAPELLA_MODEL_FILE_EXTENSION);
  }

  /**
   * Whether or not given object is a Capella resource i.e a model or a fragment.
   * @param object
   * @return
   */
  public static boolean isCapellaResource(Object object) {
    // Must be a EMF resource and a capella one.
    // DO NOT TEST CapellaResourceImpl for CDO compatibility.
    return (object instanceof Resource) && isCapellaResource(((Resource) object));
  }

  /**
   * Whether or not given resource is a Capella one i.e a model or a fragment.
   * @param resource
   * @return <code>true</code> means given resource is a Capella one.
   * @see {@link #CAPELLA_FRAGMENT_FILE_EXTENSION}, {@link #CAPELLA_MODEL_FILE_EXTENSION}
   */
  public static boolean isCapellaResource(Resource resource) {
    return (null != resource) ? isCapellaResource(resource.getURI()) : false;
  }

  /**
   * Whether or not given resource is a Capella one i.e a model or a fragment.
   * @param uri
   * @return <code>true</code> means given resource is a Capella one.
   * @see {@link #CAPELLA_FRAGMENT_FILE_EXTENSION}, {@link #CAPELLA_MODEL_FILE_EXTENSION}
   */
  public static boolean isCapellaResource(URI uri) {
    // Precondition.
    if (null == uri) {
      return false;
    }
    if (!__delegatedCapellaResourceHelperLoaded) {
      __delegatedCapellaResourceHelper = loadDelegatedCapellaResourceHelper();
    }

    // Call the delegation if any.
    boolean isCapellaResource = (null != __delegatedCapellaResourceHelper) ? __delegatedCapellaResourceHelper.isCapellaResource(uri) : false;
    return isCapellaResource || CAPELLA_MODEL_FILE_EXTENSION.equals(uri.fileExtension()) || isCapellaFragment(uri);
  }

  /**
   * Returns whether an object is a semantic element. Such element benefit of all basic tooling provided by capella
   */
  public static boolean isSemanticElement(Object object) {
    return object instanceof Element;
  }

  /**
   * Returns whether objects are semantic elements. Such element benefit of all basic tooling provided by capella
   */
  public static boolean isSemanticElements(Collection<?> objects) {
    for (Object o : objects) {
      if (!isSemanticElement(o)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Create a new capella resource and loads it in the given editing domain
   */
  public static Resource createCapellaResource(IProject project, String filename, TransactionalEditingDomain domain) {
    // Creates the XMI serialization file.
    String fullPath =
        project.getFullPath().toString() + ICommonConstants.SLASH_CHARACTER + filename + ICommonConstants.POINT_CHARACTER + CAPELLA_MODEL_FILE_EXTENSION;
    URI capellaModelURI = URI.createPlatformResourceURI(fullPath, true);

    // create a resource
    ResourceSet set = domain.getResourceSet();
    Resource xmiResource = set.createResource(capellaModelURI);

    return xmiResource;
  }

  /**
   * Load the unique delegated Capella Resource Helper.
   */
  private static ICapellaResourceHelper loadDelegatedCapellaResourceHelper() {
    ICapellaResourceHelper delegatedHelper = null;
    // Load SemanticEditingDomain providers if any.
    IConfigurationElement[] configurationElements =
        ExtensionPointHelper.getConfigurationElements("org.polarsys.capella.core.model.handler", "delegatedCapellaResourceHelper"); //$NON-NLS-1$ //$NON-NLS-2$
    // Loop over contributed SemanticEditingDomain providers, must be only
    // one.
    if (configurationElements.length > 0) {
      delegatedHelper = (ICapellaResourceHelper) ExtensionPointHelper.createInstance(configurationElements[0], ExtensionPointHelper.ATT_CLASS);
    }
    __delegatedCapellaResourceHelperLoaded = true;
    return delegatedHelper;
  }

  /**
   * Retrieve editable attribute
   * @param selectedElement
   * @return a changeable, no-transient, no-derived, no-isMany attribute, or null
   */
  public static EAttribute getEditableAttribute(EObject selectedElement) {
    EAttribute attribute = null;
    if (selectedElement != null) {

      // We should externalize that when Project Explorer will be MDK
      // compliant
      if (selectedElement instanceof AbstractNamedElement) {
        attribute = ModellingcorePackage.Literals.ABSTRACT_NAMED_ELEMENT__NAME;
        // } else if (.....) {
        // FIXME should read some extension point somewhere
      } else if (selectedElement.eClass() != null) {
        // try default feature if exist
        EStructuralFeature feature = selectedElement.eClass().getEStructuralFeature("name"); //$NON-NLS-1$
        if ((feature != null) && (feature instanceof EAttribute)) {
          attribute = (EAttribute) feature;
        }
      }
    }
    return attribute;
  }

  /**
   * Returns whether the given project is a Capella project (project or library)
   */
  public static boolean isCapellaProject(IProject targetProject) {
    try {
      return targetProject.hasNature(CAPELLA_PROJECT_NATURE) || targetProject.hasNature(CAPELLA_LIBRARY_PROJECT_NATURE);
    } catch (CoreException exception_p) {
      return false;
    }
  }

  /**
   * @param eObject
   * @return the main model resource if eObject is in a fragmented resource
   */
  public static Resource getMainModelResource(EObject eObject) {
    Resource objRes = eObject.eResource();
    if (objRes != null) {
      // If the resource is a fragment, find the resource of the
      // main model
      if (CapellaResourceHelper.isCapellaFragment(objRes.getURI())) {
        Resource mainModelResource = EcoreUtil.getRootContainer(eObject, true).eResource();
        if (mainModelResource != null) {
          return mainModelResource;
        }
      } else {
        return objRes;
      }
    }
    return null;
  }
}
