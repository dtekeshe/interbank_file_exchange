package com.bsva.dmcs.ccreports02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bsva.entities.Ccr03031VisaEntity;
import com.bsva.entities.v02.settlement.CSO_CCR030_VISA_DAO;

public class CSVReaderAcquirerIssuerVisa {

	public static void main(String... args) {

		//writeCSVData("C:\\Users\\AugustineA\\git\\dmcs_reports\\CCR030V.20180403.csv.210003");

	}

	@SuppressWarnings("unused")
	public static void writeCSVData(String url) {
		List<Ccr03031VisaEntity> listData = readDataListFromCSV(url);
		for (Ccr03031VisaEntity b : listData) {
			new CSO_CCR030_VISA_DAO().saveFileVisa(b);
		}
		System.out.println("FINISHED WRITING  FILE : " + url);
	}

	public static List<Ccr03031VisaEntity> readDataListFromCSV(String fileName) {
		System.out.println("ABOUT WRITING  FILE : " + fileName);
		List<Ccr03031VisaEntity> listData = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("012")) {
					continue;
				}
				/*if (line.startsWith("00")) {
					continue;
				}*/
				if (line.startsWith("90")) {
					continue;
				}
				if (line.startsWith("ACQ")) {
					continue;
				}
				if ( line.startsWith("91") || line.startsWith("92") || line.startsWith("98") || line.startsWith("99")) {
					break;
				}
				if (line.startsWith("ISS")) {
					continue;
				}
				String[] attributes = line.split(",");
				Ccr03031VisaEntity VisaEntityData = createData(attributes);
				listData.add(VisaEntityData);

			}

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return listData;
	}

	public static Ccr03031VisaEntity createData(String[] metadata) {
		String acquirer = metadata[0].replace('"', ' ');
		String issuer = metadata[1].replace('"', ' ');
		String cardType = metadata[2].replace('"', ' ');
		String cardNo = metadata[3].replace('"', ' ');
		String trxnCode = metadata[4].replace('"', ' ');
		String trxnDate = metadata[5].replace('"', ' ');
		String bsvaSeqNumber = metadata[6].replace('"', ' ');
		String trxnAcqRefData = metadata[7].replace('"', ' ');
		String posEntryMode = metadata[8].replace('"', ' ');
		String terminalCapability = metadata[9].replace('"', ' ');
		String fpi = metadata[10].replace('"', ' ');
		String eCommIndicator = metadata[11].replace('"', ' ');
		String visaAmount = metadata[12].replace('"', ' ');
		String cashBackPurchase = metadata[13].replace('"', ' ');
		String mcc = metadata[14].replace('"', ' ');
		String rateDescriptor = metadata[15].replace('"', ' ');
		String InterChangeFee = metadata[16].replace('"', ' ');
		String InterChangePerc = metadata[17].replace('"', ' ');
		String InterChangeVat = metadata[18].replace('"', ' ');
		String cashBackInterChangeFee = metadata[19].replace('"', ' ');
		String cashBackInterChangeVat = metadata[20].replace('"', ' ');
		String trxnCardIdMethod = metadata[21].replace('"', ' ');

		Ccr03031VisaEntity ccr03031VisaEntity = new Ccr03031VisaEntity();
/*		ccr03031VisaEntity.setAcquirer(acquirer);
		ccr03031VisaEntity.setBsvaSeqNumber(bsvaSeqNumber);
		ccr03031VisaEntity.setCardType(cardType);
		ccr03031VisaEntity.setCashBackInterChangeFee(cashBackInterChangeFee);
		ccr03031VisaEntity.setCashBackInterChangeVat(cashBackInterChangeVat);
		ccr03031VisaEntity.setCashBackPurchase(cashBackPurchase);
		ccr03031VisaEntity.seteCommIndicator(eCommIndicator);
		ccr03031VisaEntity.setFpi(fpi);

		ccr03031VisaEntity.setCardNo(cardNo);
		ccr03031VisaEntity.setTrxnAcqRefData(trxnAcqRefData);
		ccr03031VisaEntity.setVisaAmount(visaAmount);

		ccr03031VisaEntity.setInterChangeFee(InterChangeFee);
		ccr03031VisaEntity.setInterChangePerc(InterChangePerc);
		ccr03031VisaEntity.setInterChangeVat(InterChangeVat);
		ccr03031VisaEntity.setIssuer(issuer);
		ccr03031VisaEntity.setMcc(mcc);
		ccr03031VisaEntity.setPosEntryMode(posEntryMode);
		ccr03031VisaEntity.setRateDescriptor(rateDescriptor);
		ccr03031VisaEntity.setTerminalCapability(terminalCapability);
		ccr03031VisaEntity.setTrxnCardIdMethod(trxnCardIdMethod);
		ccr03031VisaEntity.setTrxnCode(trxnCode);
		ccr03031VisaEntity.setTrxnDate(trxnDate);*/


		return ccr03031VisaEntity;
	}

}
