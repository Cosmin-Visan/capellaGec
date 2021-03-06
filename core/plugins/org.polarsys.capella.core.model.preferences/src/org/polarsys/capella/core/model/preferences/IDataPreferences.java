/*******************************************************************************
 * Copyright (c) 2006, 2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.core.model.preferences;

/**
 */
public class IDataPreferences {
  /**
   * Is multiple deployment allowed or not
   */
  public static final String PREFS_ALLOW_PRIMITIVE_SYNCHRONIZATION = "data.primitive.synchro"; //$NON-NLS-1$

  /**
   * Default value for multiple deployment preference
   */
  public static final Boolean PREFS_ALLOW_PRIMITIVE_SYNCHRONIZATION_DEFAULT = Boolean.TRUE;
  
  /**
   * Is allowed to change the Physical Component nature
   */
  public static final String PREFS_ALLOW_PHYSICAL_COMPONENT_NATURE_CHANGE = "data.physical.component.nature.change";
  
  /**
   * Default value form change Physical Component nature preference
   */
  public static final Boolean PREFS_ALLOW_PHYSICAL_COMPONENT_NATURE_CHANGE_DEFAULT  = Boolean.FALSE;
}
