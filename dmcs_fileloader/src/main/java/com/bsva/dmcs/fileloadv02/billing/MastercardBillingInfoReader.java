package com.bsva.dmcs.fileloadv02.billing;

import com.bsva.dmcs.fileloadv02.model.TerminalInfo;

import static com.bsva.dmcs.fileloadv02.util.StringUtils.substring;

/**
 * TODO Document
 */
public class MastercardBillingInfoReader {

    public TerminalInfo read(String posData, String posDataAdditional, String serviceCode) {

        TerminalInfo terminalInfo = new TerminalInfo();
        terminalInfo.setTerminalCapability( substring(posData, 0, 1) );
        terminalInfo.setCardPresent(  substring(posData, 5, 6) );
        terminalInfo.setPosEntryMode( substring(posData, 6, 7) );
        terminalInfo.setChipCard(substring(serviceCode, 0, 1));
        terminalInfo.setEcommIndicator(substring(posDataAdditional, 2, 3));

        return terminalInfo;

        /*
        CsoPaymentInstructionsMcardDTO csoPaymentInstructionsMcardDTO = new CsoPaymentInstructionsMcardDTO();
            csoPaymentInstructionsMcardDTO.setSystemSeqNumber2(transactionSystemSequenceNumber);
            CsoPaymentInstructionsMcardDTO instructionsMcardDTO = csoPaymentInstructionsMcardDAO.retrieve(csoPaymentInstructionsMcardDTO);
            if(instructionsMcardDTO != null){
//                String p22DataElement = instructionsMcardDTO.getP22PointOfSaleData();
//                Integer p40DataElement = instructionsMcardDTO.getP40ServiceCode();
//                String p48DataElement = instructionsMcardDTO.getP48AdditionalData();

//                String subField1 = p22DataElement.substring(0, 1);
//                String subField6 = p22DataElement.substring(5, 6);
//                String subField7 = p22DataElement.substring(6, 7);
//                String eComm = p48DataElement.substring(2, 3);

                // TODO Chip Card Value from input file has 3 Characters  - Lookup Field has 1 value
//                String chipCard = String.valueOf(p40DataElement);
//                String chopedChipCard = chipCard.substring(0, 1);

                // Use Data Element 22/40/48 to build Rate Lookup Data
                CsfCardRateLookupDTO cardRateLookupDTO = new CsfCardRateLookupDTO();

//                cardRateLookupDTO.setTerminalCapability(subField1);
//                cardRateLookupDTO.setCardPresent(subField6);
//                cardRateLookupDTO.setPosEntryMode(subField7);
//                cardRateLookupDTO.setChipCard(chopedChipCard);
//                cardRateLookupDTO.seteCommInd(eComm);
//                cardRateLookupDTO.setService("CARD");
//                cardRateLookupDTO.setSubService("MASTERCARD");

                CsfCardRateLookupDTO lookupViewDTO = new CsfCardRateLookupDTO();

                lookupViewDTO = cardRateLookupViewDAO.retrieve(cardRateLookupDTO);
                String rateDesc = null;
                if(lookupViewDTO != null){
                    try {
                        rateDesc = lookupViewDTO.getRateDescriptor();
                    } catch (NullPointerException nlp) {
                        // OBJECT NOT FOUND
                    }
                }

                // Retrieve the view object we use for Billing
                CsvSarbBillingViewDTO csvSarbBillingViewDTO = new CsvSarbBillingViewDTO();
                if (rateDesc == null) {
                    csvSarbBillingViewDTO.setRateDescriptor("CNP BR");
                } else {
                    csvSarbBillingViewDTO.setRateDescriptor(lookupViewDTO.getRateDescriptor());
                }
                csvSarbBillingViewDTO.setCardType(csvTransactionViewDto.getCardType());
                CsvSarbBillingViewDTO billingViewDTO = csvSarbBillingViewDAO.retrieve(csvSarbBillingViewDTO);

                // UPDATE PAYMENT INSTRUCTIONS TABLE WITH cardRateLookupViewDTO
                updateMasterCardPaymentInstructions(instructionsMcardDTO, cardRateLookupDTO, billingViewDTO);
                // LOOKUP THE TRANSACTION TYPE
                CSFTransactionTypesDTO transactionTypeDTO = new CSFTransactionTypesDTO();
                transactionTypeDTO.setTransactionCode((short) csvTransactionViewDto.getTransactionCode());
                CSFTransactionTypesDTO transactionTypesDTO = transactionTypeDAO.retrieve(transactionTypeDTO);

                double billper = 0.0;
                double billfee = 0.0;
                double transactionTax = 0.0;
                float vatPerc = parametersDTO.getVatPercent() / 100f;

                if (csvTransactionViewDto.getCashbackPresent().equals("Y")) {
                    billper = billingViewDTO.getBillingPercent() * transactionTypesDTO.getFeeDirection();
                    billfee = new BigDecimal(((csvTransactionViewDto.getCashbackAmount() + billingViewDTO.getBillingRate()) / 100)).setScale(5, RoundingMode.FLOOR).longValue();
                    transactionTax = new BigDecimal(((billingViewDTO.getBillingPercent() + billingViewDTO.getBillingRate()) * vatPerc) * transactionTypesDTO.getVatDirection()).abs().setScale(5, RoundingMode.FLOOR).doubleValue();
                    // UPDATE BILLING DATA ON PAYMENT INSTRUCTIONS
                    instructionsMcardDTO.setCashbackIcFee(billfee);
                    instructionsMcardDTO.setCashbackIcPerc(billper);
                    instructionsMcardDTO.setCashbackIcVat(transactionTax);
                    csoPaymentInstructionsMcardDAO.update(instructionsMcardDTO);
                } else {
                    // UPDATE BILLING DATA ON PAYMENT INSTRUCTIONS
                    billper = billingViewDTO.getBillingPercent() * transactionTypesDTO.getFeeDirection();
                    billfee = new BigDecimal(((csvTransactionViewDto.getTransactionAmount() * billper) / 100)).setScale(5, RoundingMode.FLOOR).longValue();
                    transactionTax = new BigDecimal(((billingViewDTO.getBillingPercent() + billingViewDTO.getBillingRate()) * vatPerc) * transactionTypesDTO.getVatDirection()).abs().setScale(5, RoundingMode.FLOOR).doubleValue();
                    // UPDATE BILLING DATA ON PAYMENT INSTRUCTIONS
                    instructionsMcardDTO.setInterchangeFee(billfee);
                    instructionsMcardDTO.setInterchangePerc(billper);
                    instructionsMcardDTO.setInterchangeVat(transactionTax);
                    csoPaymentInstructionsMcardDAO.update(instructionsMcardDTO);
                }

                // Perform Billing for CSO_transactions
                CSOTransactionDTO csoTransaction = new CSOTransactionDTO();
                CSOTransactionDTO csoTransactiodto = new CSOTransactionDTO();
                csoTransactiodto.setSystemSeqNumber(transactionSystemSequenceNumber); // update this transaction

                CsoTransactionsDAO csoTransactionsDao = new CsoTransactionsDAO();
                CSOTransactionDTO cSOTransactionDTO = csoTransactionsDao.retrieve(csoTransactiodto);

                if (cSOTransactionDTO != null) {
                    updateBillingForCSOTransactions(cSOTransactionDTO, csvTransactionViewDto, csoTransactionsDao, billper, billfee, transactionTax, transactionSystemSequenceNumber);
                }
            }

        }
                */
    }
}
