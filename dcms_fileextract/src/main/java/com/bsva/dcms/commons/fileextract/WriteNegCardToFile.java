package com.bsva.dcms.commons.fileextract;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.bsva.dcms.commons.dto.file.FileDTO;
import com.bsva.dcms.commons.dto.file.NegativeCardRecordDTO;
import com.bsva.dcms.commons.util.BsvTableLookup;


public class WriteNegCardToFile {
	
	private FileDTO fileDto = new FileDTO();
	private static Logger log = Logger.getLogger(WriteNegCardToFile.class);

	
	//write negative cards to a file
		public void writeNegCardToFile(int fileOrigin) {

			BufferedWriter out = null;

			try {

				/*for(NegativeCardRecordDTO negativeCardRecordDTO : fileDto.getNegativeCardRecordDToList()){
					out = new BufferedWriter(new FileWriter(BsvTableLookup.getInstance().getSendDir() + File.separator + "CNEGFILE." + String.format("%04d", fileOrigin),true));
					out.write(negativeCardRecordDTO.getRecord());
				}*/
				
			} catch (Exception e) {
				log.error("Error in writeNegCardToFile() " + e);
			}finally{
				if (out != null)
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}

		}


}
