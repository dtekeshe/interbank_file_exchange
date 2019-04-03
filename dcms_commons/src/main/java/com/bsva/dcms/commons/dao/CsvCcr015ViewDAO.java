package com.bsva.dcms.commons.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bsva.dao.CsvCcr015ViewDao;
import com.bsva.dcms.commons.dto.CsvCcr015ViewDTO;
import com.bsva.dcms.commons.exceptions.DAOException;
import com.bsva.entities.CsvCcr015View;

public class CsvCcr015ViewDAO {

	
	private CsvCcr015ViewDao csvCcr15ViewDao = new CsvCcr015ViewDao();
	
	
	public CsvCcr015ViewDAO(){

	}

	/**
	 * Retrieve a list of records from Database.
	 *
	 * @param bean The List of Objects to be retrieved.
	 * @exception SQLException if something is wrong.
	 */

	@SuppressWarnings("unchecked")
	public List<CsvCcr015ViewDTO> retrieveRelated() throws DAOException {
		List<CsvCcr015ViewDTO> dtoList = new ArrayList<CsvCcr015ViewDTO>();
		
		try {
            String  sql = "from  CsvCcr015View";
			
			List<CsvCcr015View> csvCcr15DataViewList = csvCcr15ViewDao.executeQueryParametersNative(sql);	
			
			for (CsvCcr015View csvCcr15DataView : csvCcr15DataViewList) {			

				CsvCcr015ViewDTO dto = new CsvCcr015ViewDTO();
				
				dto.setAcquiringMember((int)csvCcr15DataView.getCsvCcr015ViewPK().getAcquiringMember().longValue());
				dto.setAcquiringMemberName(csvCcr15DataView.getAcquiringMemberName());
				dto.setCardDescription(csvCcr15DataView.getCsvCcr015ViewPK().getCardDescription());
				dto.setCardType((int)csvCcr15DataView.getCsvCcr015ViewPK().getCardType().longValue());
				dto.setInterchangeRateDesignator((int)csvCcr15DataView.getCsvCcr015ViewPK().getInterchangeRateDesignator().longValue());
				dto.setIssuerBin(csvCcr15DataView.getCsvCcr015ViewPK().getIssuerBin());
				dto.setIssuerMember((int)csvCcr15DataView.getCsvCcr015ViewPK().getIssuerMember().longValue());
				dto.setIssuerMemberName(csvCcr15DataView.getAcquiringMemberName());
				dto.setItemCharge((int)csvCcr15DataView.getCsvCcr015ViewPK().getItemCharge().longValue());
				dto.setItemChargeAmount((int)csvCcr15DataView.getItemChargeAmount().longValue());
				dto.setMerchantCatCode(csvCcr15DataView.getCsvCcr015ViewPK().getMerchantCatCode());
				dto.setProcessMonth(csvCcr15DataView.getCsvCcr015ViewPK().getProcessMonth());
				dto.setTotalCost((int)csvCcr15DataView.getTotalCost().longValue());
				dto.setTransactionDescription(csvCcr15DataView.getCsvCcr015ViewPK().getTransactionDescription());
				dto.setValue((int)csvCcr15DataView.getValue().longValue());
				dto.setVolume((int)csvCcr15DataView.getVolume().longValue());
				
				dtoList.add(dto);			
			}
			return dtoList;

		} catch (Exception ex) {
			throw new DAOException("Error retrieving related CsvCcr015View, cause: "+ ex.getMessage(), ex);
		} 
	}
	
	/**
	 * Build a Dynamic Where Clause.
	 *
	 * @param bean The Object to be used.
	 * @param select Is the where clause for a Query or Update.
	 * @exception SQLException if something is wrong.
	 */
	

}

