package com.bsva.dmcs.settlement.load;


/**
 * @author AugustineA
 *
 */
public class SettlementValidatorException extends Exception {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public SettlementValidatorException(){
		super();
	}

	public SettlementValidatorException(String msg){
		super(msg);
	}

	public SettlementValidatorException(String msg, Throwable cause){
		super(msg, cause);
	}
}
