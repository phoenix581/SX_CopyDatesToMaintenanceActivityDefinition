package com.byes.paap;

import java.util.Date;

import com.planonsoftware.platform.backend.businessrule.v3.IBusinessRule;
import com.planonsoftware.platform.backend.businessrule.v3.IBusinessRuleContext;
import com.planonsoftware.platform.backend.data.v1.IBusinessObject;

public class CopyDatesToMaintenanceActivityDefinition implements IBusinessRule {

    @Override
    public void execute(IBusinessObject newBO, IBusinessObject oldBO, IBusinessRuleContext context) {
        IBusinessObject contractMaintenanceActivityDefinition = newBO.getReferenceFieldByName("ContractMaintenanceActivityRef").getValue();

        if (contractMaintenanceActivityDefinition != null) {
            Date startDate = contractMaintenanceActivityDefinition.getDateTimeNeutralFieldByName("FreeDateTime1").getValueAsDateTime();
            Date endDate = contractMaintenanceActivityDefinition.getDateTimeNeutralFieldByName("FreeDateTime2").getValueAsDateTime();

            newBO.getDateNeutralFieldByName("BeginDateTime").setValue(startDate);
            newBO.getDateNeutralFieldByName("EndDateTime").setValue(endDate);
        }

    }
}