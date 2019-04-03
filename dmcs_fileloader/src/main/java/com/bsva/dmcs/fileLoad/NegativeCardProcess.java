//package com.bsva.dmcs.fileLoad;
//
//import com.bsva.dcms.commons.util.NegativeCardProcessing;
//import com.bsva.dcms.commons.util.Utils;
//import com.bsva.dmcs.controller.AbstractProcess;
//
//public class NegativeCardProcess extends AbstractProcess{
//
//	@Override
//	public void init() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void process() {
//		// TODO Auto-generated method stub
//
//		if (Utils.isProcessActivated("EOD", "", "")){
//			NegativeCardProcessing negativeCardProcessor = new NegativeCardProcessing();
//			negativeCardProcessor.processOutgoingNegativeCardFiles();
//		}
//
//	}
//
//}
