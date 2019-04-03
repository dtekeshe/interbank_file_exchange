package com.bsva.dao.v02.settlement;

import java.util.List;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.settlement.CsrlkUpEntity;

/**
 * @author AugustineA
 *
 */
public class CsrlkUpEntity_DAO extends AbstractDao<CsrlkUpEntity,Void>{
	
	
    private final static String CARD_TYPES_LOOKUP_SQL = 
            "   SELECT * FROM  CSF_CARD_RATE_LOOKUP ";

    public List<CsrlkUpEntity> cardTypes() {

        //used to execute data 
        List<CsrlkUpEntity> cardTypes
                = list(CARD_TYPES_LOOKUP_SQL, CsrlkUpEntity.class);
        //used return all data fetched
        return cardTypes;
    }

}
