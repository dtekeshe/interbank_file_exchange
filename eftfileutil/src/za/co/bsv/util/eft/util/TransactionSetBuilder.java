/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */

package za.co.bsv.util.eft.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import za.co.bsv.util.eft.dto.ContraRecordDTO;
import za.co.bsv.util.eft.dto.EFTTransactionDTO;
import za.co.bsv.util.eft.dto.TransactionSetDTO;

/**
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class TransactionSetBuilder {
    private int groupingKey;
    private String sourceAccountName;
    private Map<String, TransactionSetDTO> transactionSets;

    public final static int TRANSACTION_SET_GROUP_TYPE          = 1;
    public final static int TRANSACTION_SET_GROUP_DATE          = 2;
    public final static int TRANSACTION_SET_GROUP_DST_ACC_NO    = 4;
    public final static int TRANSACTION_SET_GROUP_ACC_NAME      = 8;
    
    public TransactionSetBuilder(int groupingKey, String sourceAccountName) {
        this.sourceAccountName = sourceAccountName;
        
        if(groupingKey == 0) {
            this.groupingKey = TRANSACTION_SET_GROUP_TYPE;
        }
        else {
            this.groupingKey = groupingKey;
        }
        transactionSets = new HashMap<String, TransactionSetDTO>();
    }
    
    public void addTransaction(EFTTransactionDTO transaction) {
        String key = generateKey(transaction);

        TransactionSetDTO set = transactionSets.get(key);

        if(set == null) {
            set = new TransactionSetDTO();
            transactionSets.put(key, set);
        }
        set.addTransaction(transaction);
    }

    public List<TransactionSetDTO> createTransactionSets() {

        List<TransactionSetDTO> sets = new LinkedList<TransactionSetDTO>();

        for(String key : transactionSets.keySet()) {
            TransactionSetDTO set = transactionSets.get(key);
            set.setContraRecord(createContraRecord(set));

            sets.add(set);
        }
        return sets;
    }

    private String generateKey(EFTTransactionDTO trns) {
        StringBuilder buff = new StringBuilder();
        if((groupingKey & TRANSACTION_SET_GROUP_TYPE) != 0) {
            buff.append(trns.getRecordId());
        }
        if((groupingKey & TRANSACTION_SET_GROUP_DATE) != 0) {            
            buff.append("YYMMDD");
        }
        if((groupingKey & TRANSACTION_SET_GROUP_DST_ACC_NO) != 0) {
            buff.append(trns.getDestinationAccountNumber());
        }
        if((groupingKey & TRANSACTION_SET_GROUP_ACC_NAME) != 0) {
            buff.append(trns.getSourceAccountName());
        }
        return buff.toString();
    }

    private ContraRecordDTO createContraRecord(TransactionSetDTO transactionSet) {
        ContraRecordDTO contraRecord = null;
        List<EFTTransactionDTO> transactions = transactionSet.getTransactions();

        if(!transactions.isEmpty()) {
            EFTTransactionDTO trns = transactions.get(0);
            contraRecord = new ContraRecordDTO();

            int recordId = 0;
            switch(trns.getRecordId()) {
                case EFTTransactionDTO.RECORD_ID_CREDIT:
                    recordId = ContraRecordDTO.RECORD_ID_CREDIT;
                    break;
                case EFTTransactionDTO.RECORD_ID_DEBIT:
                    recordId = ContraRecordDTO.RECORD_ID_DEBIT;
                    break;
            }
            contraRecord.setRecordId(recordId);
            contraRecord.setSourceBranchCode(trns.getSourceBranchCode());
            contraRecord.setSourceAccountNumber(trns.getSourceAccountNumber());
            contraRecord.setUserCode(trns.getUserCode());
            contraRecord.setTransactionSequenceNumber(transactions.size() + 1);
            contraRecord.setDestinationBrancCode(trns.getSourceBranchCode());
            contraRecord.setDestinationAccountNumber(trns.getSourceAccountNumber());

            int sum = 0;

            for(EFTTransactionDTO transaction : transactions) {
                sum += transaction.getAmount();
            }
            contraRecord.setAccountType(EFTTransactionDTO.ACCOUNT_TYPE_CURRENT);
            contraRecord.setAmount(sum);
            contraRecord.setActionDate(trns.getActionDate());
            contraRecord.setEntryClass(10);
            contraRecord.setUserReference(EFTFileUtil.ensureLength(trns.getShortName(), ' ', 10, EFTFileUtil.LEFT_JUSTIFY) +
                    "CONTRA");
            contraRecord.setSourceAccountName(EFTFileUtil.ensureLength(sourceAccountName, ' ', 30, EFTFileUtil.LEFT_JUSTIFY));
        }
        return contraRecord;
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();

        for(String key : transactionSets.keySet()) {
            buff.append(transactionSets.get(key));
            buff.append('\n');
        }
        return buff.toString();
    }
}
