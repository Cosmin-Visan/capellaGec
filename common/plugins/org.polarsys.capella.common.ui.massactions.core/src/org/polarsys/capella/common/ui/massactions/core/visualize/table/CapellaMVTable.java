/*******************************************************************************
 * Copyright (c) 2018, 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.common.ui.massactions.core.visualize.table;

import org.eclipse.swt.widgets.Composite;
import org.polarsys.kitalpha.massactions.visualize.table.MVTable;
import org.polarsys.kitalpha.massactions.visualize.table.factory.MVFactory;

/**
 * A Capella Mass Visualization extension of the default {@link MVTable}.
 * 
 * @author Sandu Postaru
 *
 */
public class CapellaMVTable extends MVTable {

  public CapellaMVTable(Composite parentView) {
    super(parentView);
  }

  @Override
  public MVFactory createMAFactory() {
    return new CapellaMVFactory();
  }
}
