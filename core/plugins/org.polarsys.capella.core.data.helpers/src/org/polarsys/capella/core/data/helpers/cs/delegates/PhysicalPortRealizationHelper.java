/*******************************************************************************
 * Copyright (c) 2006, 2018 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/

package org.polarsys.capella.core.data.helpers.cs.delegates;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.polarsys.capella.core.data.cs.PhysicalPortRealization;
import org.polarsys.capella.core.data.helpers.capellacore.delegates.AllocationHelper;

public class PhysicalPortRealizationHelper {
  private static PhysicalPortRealizationHelper instance;

  private PhysicalPortRealizationHelper() {
    // Do nothing
  }

  public static PhysicalPortRealizationHelper getInstance() {
    if (instance == null) {
    	instance = new PhysicalPortRealizationHelper();
    }
    return instance;
  }

  public Object doSwitch(PhysicalPortRealization element, EStructuralFeature feature) {
    // no helper found... searching in super classes...
    return AllocationHelper.getInstance().doSwitch(element, feature);
  }
}
