package com.bsva.entities.v02.endofday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;
import com.bsva.dao.v02.startofday.MonthEndDTO;

public class MisMoTot_DAO extends AbstractDao<MonthEndEntity, Void> {
	
	  private final static String MONTH_TOTAL_SQL = 
	        "     SELECT TO_CHAR(TO_DATE(PROCESS_DATE,'YYYY-MM'),'MONTH') AS MONTH,   "+
            " NVL(CM.MNEMONIC_MEMBER_NAME,                                            "+
            "     SUBSTR(CBS.ISSUING_MEMBER_NAME,1,3)) AS MNEMONIC_MEMBER_NAME,       "+
            "    SUB_SERVICE AS SUB_SERVICE,                                          "+
            " CARD_DESCRIPTION AS CARD_DESCRIPTION,                                   "+
            "    SUM(NVL(VOLUME_BELOW,0)) AS VOLUME_BELOW,                   "+
            "   SUM(NVL(VALUE_BELOW,0)) AS VALUE_BELOW,                      "+
            "   SUM(NVL(VOLUME_ABOVE,0)) AS VOLUME_ABOVE,                    "+
            "    SUM(NVL(VALUE_ABOVE,0)) AS VALUE_ABOVE,                     "+
            "    ROUND(SUM(NVL(CHARGE_BELOW,0)),2) AS CHARGE_BELOW,          "+
            "    ROUND(SUM(NVL(CHARGE_ABOVE,0)),2) AS CHARGE_ABOVE,          "+
            "    ROUND(SUM(NVL(CHARGE_ABOVE,0)),2) +                         "+
            "         ROUND(SUM(NVL(CHARGE_BELOW,0)),2) AS TOTAL_CHARGE,     "+
            "    CM.TIERED_ITEM_CHARGE_BELOW AS TIERED_ITEM_CHARGE_BELOW,              "+ 
            "    CM.TIERED_ITEM_CHARGE_ABOVE AS TIERED_ITEM_CHARGE_ABOVE               "+
            " FROM CSV_MIS_BILLING_VIEW CBS,                                 "+
            "      CSF_MEMBERS CM                                            "+
            " WHERE TO_CHAR(TO_DATE(PROCESS_DATE,'YYYY-MM'),'YYYYMM') =:processDate    "+    
            "   AND                                                          "+
            "  CBS.ISSUING_MEMBER = CM.BANK_CODE                             "+
            " GROUP BY                                                       "+
            "     CBS.ISSUING_MEMBER_NAME                                    "+
            "  ,SUB_SERVICE                                                  "+
            "    ,TO_CHAR(TO_DATE(PROCESS_DATE,'YYYY-MM'),'YYYYMM')          "+
            "    ,CM.TIERED_ITEM_CHARGE_BELOW                                "+
            "    ,CM.TIERED_ITEM_CHARGE_ABOVE                                "+
            "  ,TO_CHAR(TO_DATE(PROCESS_DATE,'YYYY-MM'),'MONTH')             "+
            " ,CARD_DESCRIPTION                                              "+
            " ,CM.MNEMONIC_MEMBER_NAME                                       "+
            " ORDER BY CBS.ISSUING_MEMBER_NAME                               "+
            "        ,CARD_DESCRIPTION ";

	    public List<MonthEndDTO> getMonthEndTotal(String processDate) {
	        Map<String,Object> params = new HashMap<String, Object>();
	        params.put("processDate", processDate);
	        
	        // prepare parameters and execute
	        List<MonthEndEntity> entities
	                = list(MONTH_TOTAL_SQL,params,MonthEndEntity.class);

	        // prepare result
	        List<MonthEndDTO> listData = new ArrayList<MonthEndDTO>();
	        
	        for (MonthEndEntity entity : entities ) {
	        	MonthEndDTO monthEndDTO = new MonthEndDTO();
	        	monthEndDTO.setCardDescription(entity.getEntityId().getCardDescription());
	        	monthEndDTO.setChargeAbove(entity.getChargeAbove());
	        	monthEndDTO.setChargeBelow(entity.getChargeBelow());
	        	monthEndDTO.setMnemonicMemberName(entity.getEntityId().getMnemonicMemberName());
	        	monthEndDTO.setMonth(entity.getMonth());
	        	monthEndDTO.setProduct("CCC&S");
	        	monthEndDTO.setSubService(entity.getEntityId().getSubService());
	        	monthEndDTO.setTieredItemChargeAbove(entity.getTieredItemChargeAbove());
	        	monthEndDTO.setTieredItemChargeBelow(entity.getTieredItemChargeBelow());
	        	monthEndDTO.setTotalCharge(entity.getTotalCharge());
	        	monthEndDTO.setValueAbove(entity.getVolumeAbove());
	        	monthEndDTO.setValueBelow(entity.getValueBelow());
	        	monthEndDTO.setVolumeAbove(entity.getVolumeAbove());
	        	monthEndDTO.setVolumeBelow(entity.getVolumeBelow());
	        	
	        	listData.add(monthEndDTO);
	        }

	        return listData;
	    }

}
