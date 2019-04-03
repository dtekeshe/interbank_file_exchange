package com.bsva.dcms.commons.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bsva.dcms.commons.dto.file.ErrorDTO;
import com.bsva.dcms.commons.dto.file.FileDTO;
import com.bsva.dcms.commons.dto.file.FileTrailer91_92RecordDTO;
import com.bsva.dcms.commons.dto.file.FileTransactionRecordDTO;
import com.bsva.dcms.commons.dto.file.VISAFileDTO;

public class Csr023TotalCalculations {
	
	private String fileName;
    private String processDate;
    private String outputDirectory;
    private String subService;
    private String service;
	private Integer fileOriginatorID;
    private BigInteger accountNumHash = new BigInteger("0");
    private CSR023TotalValues fileTotals = new CSR023TotalValues();
    private Map<Integer , TranCodeCounts> tranCodeCounts = new HashMap<>(100);
    private ErrorDTO errorDto = null;
    private long negCnt = 0;
    
    public Csr023TotalCalculations(String inFileName,String inProcessDate , String outputDirectory){
    	
    	this.outputDirectory = outputDirectory;
    	this.fileName = inFileName;
    	this.processDate = inProcessDate;
    	
    	for(int i = 0 ; i < 100 ; i++){
    		tranCodeCounts.put(i, new TranCodeCounts(i));
    	}
    }
    public Csr023TotalCalculations(String inFileName,String inProcessDate){
    	this.fileName = inFileName;
    	this.processDate = inProcessDate;
    	
    	for(int i = 0 ; i < 100 ; i++){
    		tranCodeCounts.put(i, new TranCodeCounts(i));
    	}
    }

    public void buildCsr023Totals(FileDTO filedto){

    	subService = filedto.getFileSubService();
        fileName = filedto.getFileName();
        service = filedto.getFileService();
        fileOriginatorID = filedto.getFileOriginator();
    	List<FileTransactionRecordDTO> transactionList  = filedto.getFileTransactionRecordDtoList();
    	
    	for(FileTransactionRecordDTO transactionRecordDto : transactionList){
    		
    		int transactionCode = transactionRecordDto.getTransactionCode();
    		
    		if (transactionCode > 1 && transactionCode < 90){
    			
    			accum023(transactionCode , transactionRecordDto.getNonFinRecCount() , transactionRecordDto.getCardNumber(),
    					transactionRecordDto.getTransactionAmount(), transactionRecordDto.isCurrentRecordValid());
    		}
    		
    		if (transactionCode < 2 || transactionCode >= 90){
    			accum023(transactionCode , 0 , "" , 0 ,transactionRecordDto.isCurrentRecordValid() ,true);
    		}
    	}
    	
    	if (filedto.getFileAXSHeaderRecordDto() != null){
    		accum023(Integer.parseInt(filedto.getFileAXSHeaderRecordDto().getRecordId()) , 0 , "" , 0 ,filedto.getFileAXSHeaderRecordDto().isCurrentRecordValid() ,true);
    	}
    	
    	if (filedto instanceof VISAFileDTO){
    		
    		VISAFileDTO visaFileDto = (VISAFileDTO)filedto;
    		
	    	if (visaFileDto.getFileHeader90RecordDto() != null){
	    		accum023(Integer.parseInt(visaFileDto.getFileHeader90RecordDto().getTransactionCode()) , 0 , "" , 0 ,visaFileDto.getFileHeader90RecordDto().isCurrentRecordValid() ,true);
	    	}
    	}
    	
    	if (filedto.getFileEOS98RecordDto() != null){
    		accum023(Integer.parseInt(filedto.getFileEOS98RecordDto().getRecordId()) , 0 , "" , 0 ,filedto.getFileEOS98RecordDto().isCurrentRecordValid() ,true);
    	}
    	
    	if (filedto.getFileAxsTrailorRecordDto() != null){
    		accum023(Integer.parseInt(filedto.getFileAxsTrailorRecordDto().getRecordId()) , 0 , "" , 0 ,filedto.getFileAxsTrailorRecordDto().isCurrentRecordValid() ,true);
    	}
    
    	if (filedto instanceof VISAFileDTO){
    		
    		VISAFileDTO visaFileDto = (VISAFileDTO)filedto;
    		
    		for(FileTrailer91_92RecordDTO trailor91_92Dto : visaFileDto.getFileCtrlTrailorDtoList()){
	    		accum023(Integer.parseInt(trailor91_92Dto.getTransactionCode()) , 0 , "" , 0 ,trailor91_92Dto.isCurrentRecordValid() ,true);
	    	}
    	}
    	 buildFileTotals();
    	 errorDto = filedto.getErrorDto();
    }
    
    public void accum023(int tranCode,int nonFinCnt, String tranAccountNumber, long transactionAmnt,boolean validRecordStatus){
    	
    	TranCodeCounts tranCodeCount = tranCodeCounts.get(tranCode);
    	
    	if (validRecordStatus){
    		
    		if (tranCode > 1 && tranCode < 40){
    			tranCodeCount.accFinCnt++;
    			tranCodeCount.accFinAmt += transactionAmnt;
    			tranCodeCount.accNonFinCnt += nonFinCnt; // everything except 41
    		}
    		
    		if (tranCode == 41){
    			tranCodeCount.accFinCnt++;
    			negCnt++;
    		}
    		
    	}else{
    		
    		if (tranCode > 1 && tranCode < 40){
    			tranCodeCount.rejFinCnt++;
    			tranCodeCount.rejFinAmt += transactionAmnt;
    			tranCodeCount.rejNonFinCnt += nonFinCnt; // everything except 41
    		}
    		
    		if (tranCode == 41){
    			tranCodeCount.rejFinCnt++;
    			negCnt++;
    		}
    	}
    	
    	//update values/totals for this transaction code
    	tranCodeCounts.put(tranCode, tranCodeCount);
    	
    	//update account number hasg
    	accountNumHash = accountNumHash.add(new BigInteger(tranAccountNumber));
    }
    
    public void accum023(int tranCode,int tranSeqNum, String tranAccountNumber, long transactionAmnt,boolean validRecordStatus,boolean nonFin){
    	
    	TranCodeCounts tranCodeCount = tranCodeCounts.get(tranCode);
    	
    	if (validRecordStatus){
    		
    		if (tranCode == 41){
    			tranCodeCount.accFinCnt++;
    		}else{
    			if (tranSeqNum == 0){
    				tranCodeCount.accFinCnt++;
    				tranCodeCount.accFinAmt += transactionAmnt;
    			}else{
    				tranCodeCount.accNonFinCnt++; // except 41 and non financial sequence nums
    			}
    		}
    		
    	}else{
    		if (tranCode == 41){
    			tranCodeCount.rejFinCnt++;
    		}else{
    			if (tranSeqNum == 0){
    				tranCodeCount.rejFinCnt++;
    				tranCodeCount.rejFinAmt += transactionAmnt;
    			}else{
    				tranCodeCount.rejNonFinCnt++; // except 41 and non financial sequence nums
    			}
    		}
    	}
    	
    	//update values/totals for this transaction code
    	tranCodeCounts.put(tranCode, tranCodeCount);
    	
    	//update account number hasg
    	if (tranSeqNum == 0){ // account number comes with tcr0 only
    		accountNumHash = accountNumHash.add(new BigInteger(tranAccountNumber.equals("") ? "0" : tranAccountNumber));
    	}
    }
    
    public void buildFileTotals(){
    	
    	TranCodeCounts tranCodeCount;
    	
    	fileTotals.totalNegativeCrd = getNegCnt();
    	
    	for(int i = 0 ; i < tranCodeCounts.size() ; i++){
    		tranCodeCount = tranCodeCounts.get(i);
    		
    		if (tranCodeCount.tranCde == 41){
    			fileTotals.totalNegativeCrd += tranCodeCount.accFinCnt;
    		}
    		
    		
    		if (tranCodeCount.tranCde > 1 && tranCodeCount.tranCde < 50 && (tranCodeCount.accFinCnt > 0 || tranCodeCount.rejFinCnt > 0)){
    			
	    		if (tranCodeCount.tranCde == 4 || tranCodeCount.tranCde == 5 || tranCodeCount.tranCde == 7 ||
	    				tranCodeCount.tranCde == 14 || tranCodeCount.tranCde == 15 || tranCodeCount.tranCde == 17 || tranCodeCount.tranCde ==26){
	    			
	    			fileTotals.acceptDrCnt += tranCodeCount.accFinCnt;
	    			fileTotals.acceptDrValue += tranCodeCount.accFinAmt;
	    			fileTotals.rejectDrCnt += tranCodeCount.rejFinCnt;
	    			fileTotals.rejectDrValue += tranCodeCount.rejFinAmt;
	    			
	    		}else{
	    			
	    			fileTotals.acceptCrCnt += tranCodeCount.accFinCnt;
	    			fileTotals.acceptCrValue += tranCodeCount.accFinAmt;
	    			fileTotals.rejectCrCnt += tranCodeCount.rejFinCnt;
	    			fileTotals.rejectCrValue += tranCodeCount.rejFinAmt;
	    		}
    		}
    		if (tranCodeCount.tranCde > 1 && tranCodeCount.tranCde < 50){
    			fileTotals.acceptTotalFinCnt += tranCodeCount.accFinCnt;
    			fileTotals.rejectTotalFinCnt += tranCodeCount.rejFinCnt;
    		}
    		
    		fileTotals.acceptTotalNonFin += tranCodeCount.accNonFinCnt;
    		fileTotals.rejectTotalNonFin += tranCodeCount.rejNonFinCnt;
    		
    		if ((tranCodeCount.tranCde >= 90 && tranCodeCount.tranCde <= 99) || tranCodeCount.tranCde < 2){
    			fileTotals.totalControlRecs += tranCodeCount.accFinCnt;
    		}
    	} 
            			
    }
    class TranCodeCounts {
    	
        public TranCodeCounts(int txCde) {
            tranCde = txCde;
        }
        
        int tranCde = 0;
        
        long accFinCnt = 0;
        long accNonFinCnt = 0;
        long accFinAmt = 0;
        
        long rejFinCnt = 0;
        long rejNonFinCnt = 0;
        long rejFinAmt = 0;
    }
    
    class CSR023TotalValues {
       
    	long totFileTxCnt = 0;
        long totalNegativeCrd = 0;
        
        long acceptTotalFinCnt = 0;
        long acceptTotalNonFin = 0;
        
        long rejectTotalFinCnt = 0;
        long rejectTotalNonFin = 0;
       
        long acceptDrCnt = 0;
        long acceptDrValue = 0;
        
        long acceptCrCnt = 0;
        long acceptCrValue = 0;
        
        long rejectDrCnt = 0;
        long rejectDrValue = 0;
        
        long rejectCrCnt = 0;
        long rejectCrValue = 0;
        
        long totalControlRecs = 0;
    }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getProcessDate() {
		return processDate;
	}

	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}

	public ErrorDTO getErrorDto() {
		return errorDto;
	}

	public void setErrorDto(ErrorDTO errorDto) {
		this.errorDto = errorDto;
	}

	public String getSubService() {
		return subService;
	}

	public void setSubService(String subService) {
		this.subService = subService;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
	 public long getTotAccDrVol() {
	        return fileTotals.acceptDrCnt;
	    }

	    public long getTotAccDrVal() {
	        return fileTotals.acceptDrValue;
	    }

	    public long getTotAccCrVol() {
	        return fileTotals.acceptCrCnt;
	    }

	    public long getTotAccCrVal() {
	        return fileTotals.acceptCrValue;
	    }

	    public long getTotRejDrVol() {
	        return fileTotals.rejectDrCnt;
	    }

	    public long getTotRejDrVal() {
	        return fileTotals.rejectDrValue;
	    }

	    public long getTotRejCrVol() {
	        return fileTotals.rejectCrCnt;
	    }

	    public long getTotRejCrVal() {
	        return fileTotals.rejectCrValue;
	    }
	    public long getTotalAcceptedFinRecords() {
	        return fileTotals.acceptTotalFinCnt;
	    }
	    public long getTotalRejectedFinRecords() {
	        return fileTotals.rejectTotalFinCnt;
	    }
	    public long getTotalAcceptedNonFinRecords() {
	        return fileTotals.acceptTotalNonFin;
	    }
	    public long getTotalRejectedNonFinRecords() {
	        return fileTotals.rejectTotalNonFin;
	    }
	    public long getTotalNegativeCards() {
	        return fileTotals.totalNegativeCrd;
	    }
	    public long getTotalControlRecords() {
	        return fileTotals.totalControlRecs;
	    }   
	    public long getTotalAcceptedRecords() {
	        return (fileTotals.acceptTotalFinCnt +
	               fileTotals.acceptTotalNonFin +
	               fileTotals.totalNegativeCrd +
	               fileTotals.totalControlRecs);
	    }
	    
	    public long getTotalRejectedRecords() {
	        return (fileTotals.rejectTotalFinCnt +
	               fileTotals.rejectTotalNonFin);
	    }

		public String getOutputDirectory() {
			return outputDirectory;
		}

		public void setOutputDirectory(String outputDirectory) {
			this.outputDirectory = outputDirectory;
		}
		public long getNegCnt() {
			return negCnt;
		}
		public void setNegCnt(long negCnt) {
			this.negCnt = negCnt;
		}

	public Integer getFileOriginatorID() {
		return fileOriginatorID;
	}
}
