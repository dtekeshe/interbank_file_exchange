package dmcs_fileExtract.dmcs_fileExtract;

import com.bsva.dcms.commons.fileextract.FileExtracts;

public class FileExtractTest {

	public static void main(String[] args) {
		
		FileExtracts filExtracts = new FileExtracts();
		try {
			
			filExtracts.processFiles();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//CSO_INPUT_FILE_CONTROLS
		}

	}

}
