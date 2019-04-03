package com.bsva.dao.v02.cisbins.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dao.AbstractDao;

public class CisBinsMembersDao extends AbstractDao<CisBinsEntity, Void> {
	private final static String CIS_BINS_SQL = 
			"  SELECT A.BIN_NO,A.DELETION_DATE, B.PROCESS_DATE ,C.MONTHS_UNTIL_CIS_BIN_DELETION , B.PROCESS_ACTIVE_IND ,"+
	 			" A.BANK_CODE ,	 A.BIN_DESCRIPTION,	 A.CARD_TYPE, A.OLD_CARD_TYPE, A.FUEL_ALLOWED, A.ISS_ACQ_BOTH ,A.LIVE_DATE"+
                " FROM CIS_BINS A  ,CSO_SYSTEM_PARAMETERS B  ,CSF_MEMBERS C  WHERE B.PROCESS_ACTIVE_IND = 'Y' "+
                " AND C.BANK_CODE = A.BANK_CODE AND  C.BANK_CODE =:bankCode";

	public List<CisBinsEntity> returnBins(String bankCode) {

		List<CisBinsEntity> listData = new ArrayList<CisBinsEntity>();
		
		Map<String,Object> mapParam = new HashMap<>();
		mapParam.put("bankCode", bankCode);
		// execute
		List<CisBinsEntity> entities = list(CIS_BINS_SQL,mapParam, CisBinsEntity.class);

		// prepare result
		for (CisBinsEntity entity : entities) {
			CisBinsEntity cisBins = new CisBinsEntity();
			cisBins.setBinNo(entity.getBinNo());
			cisBins.setBankCode(entity.getBankCode());
			cisBins.setBinDescription(entity.getBinDescription());
			cisBins.setCardType(entity.getCardType());
			cisBins.setDeletionDate(entity.getDeletionDate());
			cisBins.setFuelAllowed(entity.getFuelAllowed());
			cisBins.setIssAcqBoth(entity.getIssAcqBoth());
			cisBins.setMonthsUntilCisBinDeletion(entity.getMonthsUntilCisBinDeletion());
			cisBins.setOldCardType(entity.getOldCardType());
			cisBins.setProcessActiveInd(entity.getProcessActiveInd());
			cisBins.setProcessDate(entity.getProcessDate());
			cisBins.setLiveDate(entity.getLiveDate());
			listData.add(cisBins);
		}

		return listData;
	}

}
