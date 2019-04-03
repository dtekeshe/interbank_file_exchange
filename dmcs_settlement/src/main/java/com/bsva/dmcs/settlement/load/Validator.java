package com.bsva.dmcs.settlement.load;

import java.util.List;

import com.bsva.settlementv02.dto.ControlRecordDTO;
import com.bsva.settlementv02.dto.DetailRecordDTO;
import com.bsva.settlementv02.dto.HeaderRecordDTO;
import com.bsva.settlementv02.dto.TrailerRecordDTO;


/**
 * @author AugustineA
 *
 */
public interface Validator {

	public boolean validate(HeaderRecordDTO header, List<DetailRecordDTO> details,ControlRecordDTO controller, TrailerRecordDTO trailer)throws SettlementValidatorException ;


}
