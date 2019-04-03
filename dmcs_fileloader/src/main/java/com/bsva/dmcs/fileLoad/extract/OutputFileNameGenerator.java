//package com.bsva.dmcs.fileLoad.extract;
//
//
//import org.apache.log4j.Logger;
//
//
//public class OutputFileNameGenerator {
//
//	private Logger log = Logger.getLogger(OutputFileNameGenerator.class);
//
//	public OutputFileNameGenerator(){
//	}
//	public boolean execute(String fileRefNumber , String subService) throws OutputFileNameGeneratorException{
//		try{
//
//			log.info("Generate Output File Name for " + fileRefNumber.substring(0 , 8));
//			//Test
//			TxOutputFileNameGenerator successfulTxsProcess = new TxOutputFileNameGenerator();
//			successfulTxsProcess.execute(fileRefNumber , subService);
//
//			RejTxOutputFileNameGenerator rejectedTxsProcess = new RejTxOutputFileNameGenerator();
//			rejectedTxsProcess.execute(fileRefNumber, subService);
//
////			//TODO: this needs to be done at EOD
////			// all files with rejected transactions must be marked as completed
////			CompleteInputFiles inputFilesProcess = new CompleteInputFiles(connection);
////			inputFilesProcess.execute(subService);
//
//			log.info("Finished Generating Output File Name for " + fileRefNumber.substring(0 , 8));
//			return Boolean.TRUE;
//		} catch(Exception e){
//			return Boolean.FALSE;
////			throw new OutputFileNameGeneratorException("Error preparing for file extracts" , e);
//		}
//	}
//}
