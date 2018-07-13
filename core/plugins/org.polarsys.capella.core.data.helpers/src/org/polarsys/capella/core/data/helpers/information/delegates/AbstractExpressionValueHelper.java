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

package org.polarsys.capella.core.data.helpers.information.delegates;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.polarsys.capella.core.data.information.datatype.DataType;
import org.polarsys.capella.core.data.information.datavalue.AbstractExpressionValue;
import org.polarsys.capella.core.data.information.datavalue.DatavaluePackage;
import org.polarsys.capella.common.data.modellingcore.AbstractType;

public class AbstractExpressionValueHelper {

  private static AbstractExpressionValueHelper instance;

  private AbstractExpressionValueHelper() {
    // Do nothing
  }

  public static AbstractExpressionValueHelper getInstance() {
    if (instance == null) {
    	instance = new AbstractExpressionValueHelper();
    }
    return instance;
  }

  public Object doSwitch(AbstractExpressionValue element, EStructuralFeature feature) {

	if (feature.equals(DatavaluePackage.Literals.ABSTRACT_EXPRESSION_VALUE__EXPRESSION_TYPE)) {
      return getExpressionType(element);
    }

    // no helper found... searching in super classes...
    return DataValueHelper.getInstance().doSwitch(element, feature);
  }

  protected DataType getExpressionType(AbstractExpressionValue element) {
    AbstractType absType = element.getAbstractType();
    if (absType instanceof DataType) {
      return (DataType) absType;
    }
    return null;
  }
}
