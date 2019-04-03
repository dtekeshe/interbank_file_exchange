package com.bsva.settlement.validator;

import java.util.ArrayList;
import java.util.List;

import com.bsva.dmcs.settlement.load.SettlementValidatorException;
import com.bsva.dmcs.settlement.load.Validator;
import com.bsva.settlementv02.dto.ControlRecordDTO;
import com.bsva.settlementv02.dto.DetailRecordDTO;
import com.bsva.settlementv02.dto.HeaderRecordDTO;
import com.bsva.settlementv02.dto.TrailerRecordDTO;


/**
 * @author AugustineA
 *
 */
public class SettlementValidator implements Validator {

	private HeaderRecordDTO header = null;
	private List<DetailRecordDTO> details = new ArrayList<DetailRecordDTO>();
	private ControlRecordDTO controller = null;
	private TrailerRecordDTO trailer = null;

	@Override
	public boolean validate(HeaderRecordDTO header, List<DetailRecordDTO> details,ControlRecordDTO controller, TrailerRecordDTO trailer)throws SettlementValidatorException {

		this.header = header;
		this.details = details;
		this.controller = controller;
		this.trailer = trailer;

		boolean result = false;

		if(!isSettlementHeaderValid()){

			 return result;
		}

		if(this.details.size() > 0){
		for(DetailRecordDTO detailRecord : this.details){

			if(!isSettlementDetailsValid(detailRecord)){

				return result;
			}
		}
		}else{
			return result;
			}
		if(!isControllerValid()){
			return result;
		}

		result = true;

		return result;
	}

	private boolean isSettlementHeaderValid() {

		boolean result = false;

		if (header != null) {

			if ((header.getHeaderDetailInd() == null || !("D".equals(header.getHeaderDetailInd()))) && header.getHeaderDetailInd().length() > 1) {

				return result;
			}

			if ((header.getHeaderService() == null || "".equals(header.getHeaderService())) && header.getHeaderService().length() > 5) {

				return result;
			}

			if ((header.getHeaderSubService() == null) && header.getHeaderSubService().length() > 5) {

				return result;
			}

			if ((header.getHeaderCentre() == null || "".equals(header.getHeaderCentre())) && header.getHeaderCentre().length() > 3) {

				return result;
			}

			if ((header.getHeaderCurrency() == null || "".equals(header.getHeaderCurrency())) && header.getHeaderCurrency().length() > 3) {

				return result;
			}

			if (header.getHeaderSettlementDate() == null) {

				return result;
			}

			if (header.getHeaderInputDate() == null) {

				return result;
			}

			if ((header.getHeaderLiveInd() == null || "".equals(header.getHeaderLiveInd())) && header.getHeaderLiveInd().length() > 1) {

				return result;
			}

			if ((header.getHeaderMemberCntl() == null || "".equals(header.getHeaderMemberCntl())) && header.getHeaderMemberCntl().length() > 4) {

				return result;
			}

			if ((header.getHeaderDescription() == null || "".equals(header.getHeaderDescription())) && header.getHeaderDescription().length() > 50) {

				return result;
			}

			if ((header.getHeaderCurrDesc() == null || "".equals(header.getHeaderCurrDesc())) && header.getHeaderCurrDesc().length() > 50) {

				return result;
			}

			if ((header.getHeaderAgreementNo() == null || "".equals(header.getHeaderAgreementNo())) && header.getHeaderAgreementNo().length() > 2) {

				return result;
			}

			if ((header.getHeaderEndOfService() == null || "".equals(header.getHeaderEndOfService())) && header.getHeaderEndOfService().length() > 1) {

				return result;
			}

			if ("".equals(header.getHeaderEndOfService())) {

				return result;
			}
			result = true;
		} else {

			return result;
		}

		return result;

	}

	private boolean isSettlementDetailsValid(DetailRecordDTO detailRecord) {

		boolean result = false;

		if ((detailRecord.getSettleDetailInd() == null || !("S".equals(detailRecord.getSettleDetailInd()))) && detailRecord.getSettleDetailInd().length() > 1) {

			return result;
		}

		if (detailRecord.getSettleDetailService() == null && detailRecord.getSettleDetailService().length() > 5) {

			return result;
		}

		if (detailRecord.getSettleDetailService() == null) {

			return result;
		}

		if (detailRecord.getSettleDetailSubService() == null && detailRecord.getSettleDetailSubService().length() > 5) {

			return result;
		}

		if (detailRecord.getSettleDetailCentre() == null && detailRecord.getSettleDetailCentre().length() > 5) {

			return result;
		}

		if (detailRecord.getSettleDetailCentre() == null && detailRecord.getSettleDetailCentre().length() > 3) {

			return result;
		}

		if (detailRecord.getSettleDetailCurrency() == null && detailRecord.getSettleDetailCurrency().length() > 3) {

			return result;
		}

		if (detailRecord.getSettleDetailAltCurrency() == null && detailRecord.getSettleDetailAltCurrency().length() > 3) {

			return result;
		}

		if (detailRecord.getSettleDetailActionDate() == null) {

			return result;
		}

		if (detailRecord.getSettleDetailMemberIn() == null || detailRecord.getSettleDetailMemberIn().length() > 6) {

			return result;
		}

		if (detailRecord.getSettleDetailMemberOut() == null || detailRecord.getSettleDetailMemberOut().length() > 6) {

			return result;
		}

		if (detailRecord.getSettleDetailVolume() == null) {

			return result;
		}

		if (detailRecord.getSettleDetailValue() == null) {

			return result;
		}

		if (detailRecord.getSettleDetailSign() == null || detailRecord.getSettleDetailSign().length() > 2) {

			return result;
		}

		if (detailRecord.getSettleDetailMemberCntl() == null || detailRecord.getSettleDetailMemberCntl().length() > 4) {

			return result;
		}

		result = true;
		return result;

	}

	private boolean isControllerValid() {

		boolean result = false;

		if (controller != null) {

			if ((controller.getControlInd() == null || !"C".equals(controller.getControlInd())) && header.getHeaderDetailInd().length() > 1) {
				return result;
			}
			if (controller.getControlService() == null || controller.getControlService().length() > 5) {
				return result;
			}
			if (controller.getControlSubservice() == null) {
				return result;
			}
			if (controller.getControlCurrency() == null || controller.getControlCurrency().length() > 3) {
				return result;
			}
			if (controller.getControlMemberCntl() == null || controller.getControlMemberCntl().length() > 6) {
				return result;
			}
			if (controller.getControlTime() == null && controller.getControlTime().toString().length() > 8) {
				return result;
			}
			if (controller.getControlStatus() == null || controller.getControlStatus().length() > 1) {
				return result;
			}
			if (controller.getControlNoOfRecords() == null) {
				return result;
			}
			result = true;
		}else{

			return result;
		}

		  return result;
	}

	public boolean isTrailerValid(){

		boolean result = false;

		if(trailer != null){

			if((trailer.getTrailerInd() == null || !("T".equals(trailer.getTrailerInd()))) && trailer.getTrailerInd().length() > 1){

				return result;
			}
			if(trailer.getTrailerService() == null && trailer.getTrailerService().length() > 5){
				return result;
			}
			if(trailer.getTrailerSubService() == null){
				return result;
			}
			if(trailer.getTrailerCurrency() == null || trailer.getTrailerCurrency().length() > 3){
				return result;
			}
			if(trailer.getTrailerMemberCntl() == 0 || trailer.getTrailerMemberCntl() > 4){
				return result;
			}
			if(trailer.getTrailerTime() == null && trailer.getTrailerTime().toString().length() > 8){
				return result;
			}
			if(trailer.getTrailerStatus() == null || trailer.getTrailerStatus().length() > 0){
				return result;
			}
			if(trailer.getTrailerNoOfRecords() == null){
				return result;
			}
			if(trailer.getTrailerFiller() == null){
				return result;
			}
			result = true;
		}
	   else{
		   return result;
	}
	return result;
	}
}
