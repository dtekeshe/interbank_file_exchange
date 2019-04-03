package com.bsva.dmcs.fileextractv02;

import java.util.List;
import java.util.Map;

import com.bsva.dao.v02.members.MemberNegCardDAO;
import com.bsva.entities.MemberNegCardEntity;

public class ExtractNegativeCards {
	
	
	private final List<MemberNegCardEntity> negativeMembers ;
	private String bankcode;
	private String negCardDataRequired;
	
	public ExtractNegativeCards(String bankcode,String negCardDataRequired){
		this.bankcode = bankcode;
		this.negCardDataRequired = negCardDataRequired;
		negativeMembers = new MemberNegCardDAO().memberNegCard();
	}

	public String getBankcode() {
		return bankcode;
	}

	public String getNegCardDataRequired() {
		return negCardDataRequired;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public void setNegCardDataRequired(String negCardDataRequired) {
		this.negCardDataRequired = negCardDataRequired;
	}

	public List<MemberNegCardEntity> getNegativeMembers() {
		return negativeMembers;
	}

}
