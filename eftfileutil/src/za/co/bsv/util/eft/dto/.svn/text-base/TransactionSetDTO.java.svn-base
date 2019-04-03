/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */

package za.co.bsv.util.eft.dto;

import java.util.LinkedList;
import java.util.List;

/**
 * Transaction set
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class TransactionSetDTO {
    private ContraRecordDTO contraRecord;
    private List<EFTTransactionDTO> transactions;

    public TransactionSetDTO() {
        transactions = new LinkedList<EFTTransactionDTO>();
    }
    /**
     * @return the contraRecord
     */
    public ContraRecordDTO getContraRecord() {
        return contraRecord;
    }

    /**
     * @param contraRecord the contraRecord to set
     */
    public void setContraRecord(ContraRecordDTO contraRecord) {
        this.contraRecord = contraRecord;
    }

    /**
     * @return the transactions
     */
    public List<EFTTransactionDTO> getTransactions() {
        return transactions;
    }

    /**
     * @param transaction the transactions add
     */
    public void addTransaction(EFTTransactionDTO transaction) {
        transaction.setTransactionSequenceNumber(transactions.size() + 1);
        this.transactions.add(transaction);
    }

    

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();

        for(EFTTransactionDTO trns : transactions) {
            buff.append(trns.toString());
            buff.append('\n');
        }
        buff.append(contraRecord.toString());
        return buff.toString();
    }
}
