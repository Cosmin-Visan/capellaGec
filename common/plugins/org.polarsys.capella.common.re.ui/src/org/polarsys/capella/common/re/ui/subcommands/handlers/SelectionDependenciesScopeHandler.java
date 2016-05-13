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
package org.polarsys.capella.common.re.ui.subcommands.handlers;

import java.util.Collection;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.jface.viewers.StructuredSelection;
import org.polarsys.capella.common.flexibility.properties.loader.PropertiesLoader;
import org.polarsys.capella.common.flexibility.properties.property.PropertyContext;
import org.polarsys.capella.common.flexibility.properties.schema.IProperties;
import org.polarsys.capella.common.flexibility.properties.schema.IProperty;
import org.polarsys.capella.common.flexibility.properties.schema.IPropertyContext;
import org.polarsys.capella.common.flexibility.wizards.schema.IRendererContext;
import org.polarsys.capella.common.flexibility.wizards.ui.util.ExecutionEventUtil;

/**
 *
 */
public class SelectionDependenciesScopeHandler extends SelectionCommandHandler {

  @Override
  protected String getScope() {
    return "org.polarsys.capella.common.re.retrieve.dependenciesElements";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setEnabled(Object evaluationContext) {
    IEvaluationContext context = (IEvaluationContext) evaluationContext;
    Collection<Object> selectedObjects = getSelectedObjects(context);
    IRendererContext rendererContext = ExecutionEventUtil.getRendererContext(context);

    if (selectedObjects.isEmpty()) {
      setBaseEnabled(false);
    } else {
      if (rendererContext == null) {
        setBaseEnabled(false);
      } else {

        String scope = getScope();
        String propertyId = scope;

        if ((scope == null) || scope.isEmpty()) {
          setBaseEnabled(false);
        } else {

          IProperties delegatedProperties = new PropertiesLoader().getProperties(scope);
          Object source = getPropertySource(new StructuredSelection(selectedObjects), rendererContext);
          IPropertyContext delegatedContext = new PropertyContext(delegatedProperties, source);
          IProperty property = delegatedProperties.getProperty(propertyId);
          Object current = delegatedContext.getCurrentValue(property);
          setBaseEnabled((current instanceof Collection) && !((Collection) current).isEmpty());
        }
      }
    }
  }
}
