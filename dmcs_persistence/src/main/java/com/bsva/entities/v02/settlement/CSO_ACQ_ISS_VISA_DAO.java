package com.bsva.entities.v02.settlement;

import java.util.ArrayList;
import java.util.List;

import com.bsva.dao.AbstractDao;

public class CSO_ACQ_ISS_VISA_DAO extends AbstractDao<CsoCCR030AcqIssEntity, Void> {

	private final static String ACQ_ISSUER_PAIR ="SELECT  DISTINCT ACQUIRER_MEMBER,ISSUER_MEMBER from CSO_CCR030_VISA ORDER BY ACQUIRER_MEMBER ASC ,ISSUER_MEMBER ASC ";

	public List<CsoCCR030AcqIssEntity> getAcqIssuerPair() {
		
		List<CsoCCR030AcqIssEntity> trxndata = new ArrayList<>();
		
		List<CsoCCR030AcqIssEntity> acqIssDataPair = list(ACQ_ISSUER_PAIR, CsoCCR030AcqIssEntity.class);
		
		for (CsoCCR030AcqIssEntity acqIssEntity : acqIssDataPair) {

			CsoCCR030AcqIssEntity entityData = new CsoCCR030AcqIssEntity();
			CsoCCR030AcqIssEntityKey key = new CsoCCR030AcqIssEntityKey(); 
			key.setAcquirerMember(acqIssEntity.getId().getAcquirerMember());
			key.setIssuerMember(acqIssEntity.getId().getIssuerMember());
			entityData.setId(key);
			trxndata.add(entityData);

		}

		return trxndata;
	}

}
