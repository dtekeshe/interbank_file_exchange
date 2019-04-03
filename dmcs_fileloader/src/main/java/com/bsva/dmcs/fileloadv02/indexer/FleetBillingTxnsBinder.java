package com.bsva.dmcs.fileloadv02.indexer;

import com.bsva.commonsv02.util.NoFleetBillingTxnsException;
import com.bsva.dao.v02.DirectoryDAO;
import com.bsva.dao.v02.SequenceReaderDAO;
import com.bsva.dao.v02.SequenceUpdateDAO;
import com.bsva.dao.v02.SystemParametersDAO;
import com.bsva.dao.v02.billing.FleetBillingDAO;
import com.bsva.dao.v02.billing.FleetBillingResolvedDAO;
import com.bsva.dmcs.fileloadv02.indexer.util.FleetBillingTxnsBinderAndWriter;
import com.bsva.dmcs.fileloadv02.loaders.FileLoader;
import com.bsva.dmcs.fileloadv02.util.LoaderUtils;
import com.bsva.dmcs.fileloadv02.util.Timer;
import com.bsva.dto.FleetBillingTxnDTO;
import com.bsva.entities.v02.billing.FleetBillingTxnEntity;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author AugustineA
 *
 */
public class FleetBillingTxnsBinder {

	private final static String FILE_PATH_SEPARATOR = System.getProperty("file.separator");

	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

	private final Date processDate;

	private final String indexFolder;

	private final String sqlctlFilename;

	public FleetBillingTxnsBinder() {

		// get process date
		processDate = new SystemParametersDAO().systemParameters().getProcessDate();
		// index folder
		Map<String, String> paths = new DirectoryDAO().directories();
		indexFolder = paths.get("FILE_LOADER_INDEX");
		sqlctlFilename = "dmcs_loader_control_file_fleet_binder.sql";
	}

	public void bind() throws NoFleetBillingTxnsException {

		// clean up bind resolved table
		new FleetBillingResolvedDAO().cleanup();

		// get fleet billing txns
		List<FleetBillingTxnDTO> txns = new FleetBillingDAO().fleetBillingTxns();

		if (txns.size() == 0) {
			throw new NoFleetBillingTxnsException();
		}

		// get next file system seq number
		Long fileSystemSeqNumber = new SequenceReaderDAO().sequences().get("FLEET.FILE_SYSTEM_SEQ_NUMBER").longValue();

		PrintWriter out = null;

		try {
			String filename = "FLEET_BILLING_" + DATE_FORMAT.format(processDate);
			String indexpath = indexFolder + FILE_PATH_SEPARATOR + filename + ".idx";
			out = new PrintWriter(new File(indexpath));

			Long startedAt = System.currentTimeMillis();
			spolog("BINDING " + txns.size() + " FLEET BILLING RECORDS TO " + filename);

			List<FleetBillingTxnEntity> fleetBillingTxn = new ArrayList<>();

			for (FleetBillingTxnDTO fleetBillingTxnDTO : txns) {
				FleetBillingTxnEntity fleetBill = new FleetBillingTxnEntity();
				if (fleetBillingTxnDTO.getAmount() != null) {
					fleetBill.setAmount(fleetBillingTxnDTO.getAmount());
				}
				fleetBill.setCardType(fleetBillingTxnDTO.getCardType());
				fleetBill.setSystemSeqNumber(fleetBillingTxnDTO.getSystemSequenceNumber());

				if (fleetBillingTxnDTO.getTxnCount() != null) {
					fleetBill.setTxnCount(fleetBillingTxnDTO.getTxnCount());
				}
				fleetBill.setAccountNumber(fleetBillingTxnDTO.getAccountNumber());
				fleetBill.setAcquirerBin(fleetBillingTxnDTO.getAcquirerBin());
				fleetBill.setAcquirerCode(fleetBillingTxnDTO.getAcquirerCode());
				fleetBill.setIssuerCode(fleetBillingTxnDTO.getIssuerCode());
				fleetBill.setServiceID(fleetBillingTxnDTO.getServiceID());
				fleetBill.setSubServiceID(fleetBillingTxnDTO.getSubServiceID());
				fleetBill.setTxnCode(fleetBillingTxnDTO.getTxnCode());
				fleetBill.setTxnDateTime(fleetBillingTxnDTO.getTxnDateTime());
				fleetBillingTxn.add(fleetBill);
			}

			FleetBillingTxnsBinderAndWriter.write(out, fileSystemSeqNumber, fleetBillingTxn);
			Long duration = System.currentTimeMillis() - startedAt;
			spolog("INDEXING COMPLETED IN "
					+ (duration < 1000 ? duration + " millis." : ((double) duration / 1000.0) + " secs."));
			try {
				out.flush();
				out.close();
			}
			catch (Exception ex) {
			}
			// load indexed file
			spolog("LOADING " + filename + " INTO CSO_FLEET_BIND_RESOLVED DATABASE TABLE.");

			// file loader
			spolog("INITIALISING SQL LOADER ...");
			FileLoader fileLoader = LoaderUtils.fileLoaderInstance();

			spolog("LOADING FILE ...");
			startedAt = System.currentTimeMillis();
			fileLoader.load(filename, sqlctlFilename, "FLEET");
			duration = System.currentTimeMillis() - startedAt;
			spolog("LOADING COMPLETED IN "
					+ (duration < 1000 ? duration + " millis." : ((double) duration / 1000.0) + " secs."));

			// update sequences database table
			++fileSystemSeqNumber;
			spolog("UPDATING DMCS_SEQ_STORE FLEET.FILE_SYSTEM_SEQ_NUMBER VALUE TO " + fileSystemSeqNumber + ".");
			new SequenceUpdateDAO().update("FLEET.FILE_SYSTEM_SEQ_NUMBER", fileSystemSeqNumber);

			spolog("FLEET BILLING BIND RESOLVE COMPLETED.");
		}
		catch (Exception e) {
			e.printStackTrace();
			spolog("INDEXED in " + Timer.end());
		}
		finally {

			try {
				out.flush();
			}
			catch (Exception e) {
			}
			try {
				out.close();
			}
			catch (Exception e) {
			}
		}
	}

	private void spolog(String message) {
		System.out.println(PROCESS_NAME + " " + VERSION + " " + message);
		// spoLog.log(PROCESS_NAME, VERSION, message);
	}

	/*
	 * public static void main(String[] args) { new FleetBillingTxnsBinder().bind(); }
	 */

	// Metadata
	private final static String PROCESS_NAME = "FLEETIDX";

	private final static String VERSION = "20";
}
