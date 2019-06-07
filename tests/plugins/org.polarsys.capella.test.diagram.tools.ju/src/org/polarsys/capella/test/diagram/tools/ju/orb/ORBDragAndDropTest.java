/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.test.diagram.tools.ju.orb;

import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.capella.test.diagram.common.ju.api.AbstractDiagramTestCase;
import org.polarsys.capella.test.diagram.common.ju.context.ORBDiagram;
import org.polarsys.capella.test.framework.context.SessionContext;
import org.polarsys.capella.test.framework.model.GenericModel;

public class ORBDragAndDropTest extends AbstractDiagramTestCase {

  @Override
  protected String getRequiredTestModel() {
    return "DiagramToolsModel";
  }

  @Override
  public void test() throws Exception {

    String diagramName = "Test Operational Role Breakdown Diagram";

    Session session = getSession(getRequiredTestModel());
    SessionContext context = new SessionContext(session);

    ORBDiagram orb = ORBDiagram.openDiagram(context, diagramName);

    String diagramId = orb.getDiagramId();

    orb.createOperationalRole(orb.getDiagramId());

    String role1 = orb.createOperationalRole(diagramId);
    String role2 = orb.createOperationalRole(diagramId);
    String opActivity1 = orb.createOperationalActivity(role1);
    orb.dragAndDropChangeAllocation(opActivity1, role2);

    orb.removeOperationalRoles(diagramId, role2);
    orb.dragAndDropRoleFromExplorer(role2, diagramId);
    orb.hasntView(opActivity1);

    orb.dragAndDropOperationalActivitiesFromExplorer(opActivity1, role2);

    String constraint = orb.createConstraint(GenericModel.CONSTRAINT_1);
    orb.removeConstraint(constraint, diagramId);
    orb.dragAndDropConstraintsFromExplorer(constraint, orb.getDiagramId());
  }
}
