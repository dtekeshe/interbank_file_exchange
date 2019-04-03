package com.bsva.settlementv02.dto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.bsva.settlementv02.dto.ControlRecordDTO;
import com.bsva.settlementv02.dto.DetailRecordDTO;
import com.bsva.settlementv02.dto.HeaderRecordDTO;
import com.bsva.settlementv02.dto.TrailerRecordDTO;

public class SettlementLoader {
	
	private HeaderRecordDTO headerRecordDTO;
	private List<DetailRecordDTO> detailRecordDTO;
	private ControlRecordDTO controlRecordDTO;
	private TrailerRecordDTO trailerRecordDTO;
	private String fileName;
	private String outPutDirectory;
	
	
	
	public SettlementLoader(HeaderRecordDTO headerRecordDTO, List<DetailRecordDTO> detailRecordDTO,ControlRecordDTO controlRecordDTO
			,TrailerRecordDTO trailerRecordDTO, String fileName, String outPutDirectory) {
		super();
		this.headerRecordDTO = headerRecordDTO;
		this.detailRecordDTO = detailRecordDTO;
		this.controlRecordDTO = controlRecordDTO;
		this.trailerRecordDTO = trailerRecordDTO;
		this.fileName = fileName;
		this.outPutDirectory = outPutDirectory;
	}
	
	public void execute(){

		String pathname = outPutDirectory +"/"+fileName;


		File output = new File(pathname);

		try {


			BufferedWriter writer = new BufferedWriter(new FileWriter(output));

			writer.write(headerRecordDTO.toString());
			writer.newLine();

			for(DetailRecordDTO detail : detailRecordDTO){	
				writer.write(detail.toString()); 
				writer.newLine();	
			}

			writer.write(controlRecordDTO.toString());
			writer.newLine();

			writer.write(trailerRecordDTO.toString());
			writer.newLine();	
			writer.close();

		} catch (IOException e) {  
			e.printStackTrace();
		}

	}


}

