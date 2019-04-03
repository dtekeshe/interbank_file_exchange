package com.bsva.dao.v02.cisbins.entity;

import java.util.ArrayList;
import java.util.List;

import com.bsva.dao.AbstractDao;

public class BankCodeDao extends AbstractDao<BankCodeEntity, Void> {
	
	private final static String BANK_CODE_SQL = 
			" SELECT DISTINCT(BANK_CODE) FROM CSF_MEMBER_SERVICE ";

	public List<BankCodeEntity> returnBankCode() {

		List<BankCodeEntity> listData = new ArrayList<BankCodeEntity>();
		
		// execute
		List<BankCodeEntity> entities = list(BANK_CODE_SQL, BankCodeEntity.class);

		// prepare result
		for (BankCodeEntity entity : entities) {
			BankCodeEntity bankCode1 = new BankCodeEntity();
			bankCode1.setBankCode(entity.getBankCode());
			listData.add(bankCode1);
		}

		return listData;
	}

}
