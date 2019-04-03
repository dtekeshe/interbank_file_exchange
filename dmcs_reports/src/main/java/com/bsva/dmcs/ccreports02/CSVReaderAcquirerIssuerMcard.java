package com.bsva.dmcs.ccreports02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.bsva.entities.Ccr03031McardEntity;
import com.bsva.entities.v02.settlement.CSO_CCR030_MCARD_DAO;

public class CSVReaderAcquirerIssuerMcard {

	public static void main(String... args) {

		writeCSVData("C:\\Users\\AugustineA\\git\\dmcs_reports\\CCR030V.20180403.csv.210003");

	}

	@SuppressWarnings("unused")
	public static void writeCSVData(String url) {
		List<Ccr03031McardEntity> listData = readDataListFromCSV(url);
		for (Ccr03031McardEntity b : listData) {
			new CSO_CCR030_MCARD_DAO().saveFileMcard(b);
		}
		System.out.println("FINISHED WRITING FILE : " + url);
	}

	public static List<Ccr03031McardEntity> readDataListFromCSV(String fileName) {
		
		System.out.println("ABOUT WRITING  : " + fileName + " TO THE TABLE");
		List<Ccr03031McardEntity> listData = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			while ((line = br.readLine()) != null) {
				if(line.startsWith("012")){
					continue;
				}
				if(line.startsWith("ACQ")){
					continue;
				}
				if (line.startsWith("92") || line.startsWith("98") || line.startsWith("99")) {
					break;
				}
				if(line.startsWith("ISS")){
					continue;
				}
				String[] attributes = line.split(",");
				Ccr03031McardEntity VisaEntityData = createData(attributes);
				
				listData.add(VisaEntityData);
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return listData;
	}

	public static Ccr03031McardEntity createData(String[] metadata) {
		
		String acquirer_member = metadata[0].replace('"', ' ');
		String issuer_member = metadata[1].replace('"', ' ');
		String card_type = metadata[2].replace('"', ' ');
		String card_no = metadata[3].replace('"', ' ');
		String transaction_code = metadata[4].replace('"', ' ');
		String tx_process_code = metadata[5].replace('"', ' ');
		String tx_date = metadata[6].replace('"', ' ');
		String tx_time = metadata[7].replace('"', ' ');
		String bsva_seqno = metadata[8].replace('"', ' ');
		String tx_acq_ref_data = metadata[9].replace('"', ' ');
		String tx_point_of_sale = metadata[10].replace('"', ' ');
		String terminal_capability = metadata[11].replace('"', ' ');
		String card_present = metadata[12].replace('"', ' ');
		String tx_service_code = metadata[13].replace('"', ' ');
		String tx_ird = metadata[14].replace('"', ' ');
		String ecomm_ind = metadata[15].replace('"', ' ');
		String mastercard_amount = metadata[16].replace('"', ' ');
		String cashback_purchase_amnt = metadata[17].replace('"', ' ');
		String mcc = metadata[18].replace('"', ' ');
		String rate_desc = metadata[19].replace('"', ' ');
		String interchange_fee = metadata[20].replace('"', ' ');
		String interchange_perc = metadata[21].replace('"', ' ');
		String interchange_vat = metadata[22].replace('"', ' ');
		String cashback_ic_fee = metadata[23].replace('"', ' ');
		String cashback_ic_vat = metadata[24].replace('"', ' ');
		String tx_terminal_type = metadata[25].replace('"', ' ');

		Ccr03031McardEntity Ccr03031McardEntity = new Ccr03031McardEntity();
		/*Ccr03031McardEntity.setAcquirer(acquirer_member);
		Ccr03031McardEntity.setIssuer(issuer_member);
		Ccr03031McardEntity.setCardPresent(card_present);
		Ccr03031McardEntity.setCardType(card_type);
		Ccr03031McardEntity.setCashBackInterchangeFee(cashback_ic_fee);
		Ccr03031McardEntity.setCashBackInterchangeVat(cashback_ic_vat);
		Ccr03031McardEntity.seteCommInd(ecomm_ind);
		Ccr03031McardEntity.setInterChangeFee(interchange_fee);
		Ccr03031McardEntity.setCashBackPurchaseAmount(cashback_purchase_amnt);

		Ccr03031McardEntity.setCardNo(card_no);
		Ccr03031McardEntity.setTrxnRefData(tx_acq_ref_data);
		Ccr03031McardEntity.setmCardAmount(mastercard_amount);

		Ccr03031McardEntity.setInterChangePerc(interchange_perc);
		Ccr03031McardEntity.setInterChangeVat(interchange_vat);
		Ccr03031McardEntity.setMcc(mcc);
		Ccr03031McardEntity.setRateDescriptor(rate_desc);
		Ccr03031McardEntity.setSeqNumber(bsva_seqno);
		Ccr03031McardEntity.setTerminalCapability(terminal_capability);
		Ccr03031McardEntity.setTrxnCode(transaction_code);
		Ccr03031McardEntity.setTrxnDate(tx_date);
		Ccr03031McardEntity.setTrxnIrd(tx_ird);
		Ccr03031McardEntity.setTrxnTime(tx_time);
		Ccr03031McardEntity.setTrxnPointOfSale(tx_point_of_sale);
		Ccr03031McardEntity.setTrxnProcessCode(tx_process_code);
		Ccr03031McardEntity.setTrxnServiceCode(tx_service_code);
		Ccr03031McardEntity.setTrxnTerminalType(tx_terminal_type);*/
		

		
		
		return Ccr03031McardEntity;
	}

}
