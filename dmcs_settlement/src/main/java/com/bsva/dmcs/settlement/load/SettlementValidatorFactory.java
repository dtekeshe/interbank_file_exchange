package com.bsva.dmcs.settlement.load;

import com.bsva.settlement.validator.SettlementValidator;



/**
 * @author AugustineA
 *
 */
public class SettlementValidatorFactory {


		public static Validator getValidator(){

			return new SettlementValidator();

		}

}
