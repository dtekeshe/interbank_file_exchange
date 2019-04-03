package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.params.CompanyParametersEntity;

/**
 * TODO Document
 */
public class CompanyParametersDAO extends AbstractDao<CompanyParametersEntity, Void> {

    private final static String COMPANY_PARAMETERS_SQL =
            " SELECT COMPANY_NAME, FULL_REPORT_NAME, REGISTRATION_NUMBER, VALIDATION_CODE, VAT_PERCENT ,CURRENCY_CODE_NUMBER" +
            "   FROM CSF_COMPANY_PARAMETERS ";

    public CompanyParametersEntity companyParameters() {

        // execute
        CompanyParametersEntity companyParametersEntity
                = uniqueResult(COMPANY_PARAMETERS_SQL, CompanyParametersEntity.class);

        return companyParametersEntity;
    }
}
