/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */

package za.co.bsv.util.eft.util;

import java.math.BigInteger;

import java.util.List;

import za.co.bsv.util.eft.dto.ContraRecordDTO;
import za.co.bsv.util.eft.dto.EFTTransactionDTO;
import za.co.bsv.util.eft.dto.TransactionSetDTO;
import za.co.bsv.util.eft.dto.UserDataSetDTO;
import za.co.bsv.util.eft.dto.UserTrailerDTO;

/**
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class UserDataSetBuilder {
    private int lastSequence;
    private UserDataSetDTO dataSet;

    public UserDataSetBuilder() {
        dataSet = new UserDataSetDTO();
        this.lastSequence = 1;
    }

    public UserDataSetBuilder(int lastSequence) {
        dataSet = new UserDataSetDTO();
        this.lastSequence = lastSequence;
    }

    public void addUserHeader(int userCode, String generationNumber, String service) {
        dataSet.setUserHeader(UserHeaderBuilder.createUserHeader(userCode, generationNumber, service, lastSequence + 1));
    }

    public void addTransactionSets(List<TransactionSetDTO> transactionSets) {
        dataSet.setTransactionSets(transactionSets);
    }

    public UserDataSetDTO createUserDataSet() {
        dataSet.setUserTrailer(createUserTrailer());
        return dataSet;
    }

    private UserTrailerDTO createUserTrailer() {
        UserTrailerDTO retval = new UserTrailerDTO();

        retval.setRecordId(92);
        retval.setUserCode(dataSet.getUserHeader().getUserCode());
        retval.setFirstSequenceNumber(dataSet.getUserHeader().getFirstSequenceNumber());
        retval.setFirstActionDate(dataSet.getUserHeader().getFirstActionDate());
        retval.setLastActionDate(dataSet.getUserHeader().getLastActionDate());
        retval.setNumberOfContra(dataSet.getTransactionSets().size());

        int sequence = 1 + lastSequence;
        int totalDebits = 0;
        int totalCredits = 0;
        int numberOfDebits = 0;
        int numberOfCredits = 0;
        BigInteger hash = BigInteger.ZERO;

        for(TransactionSetDTO set : dataSet.getTransactionSets()) {

            if(sequence + set.getTransactions().size() + 1 >= 1000000) {
                sequence = 1;
            }

            for(EFTTransactionDTO trns: set.getTransactions()) {

                hash = hash.add(new BigInteger(String.valueOf(trns.getDestinationAccountNumber())));
                trns.setTransactionSequenceNumber(sequence++);

                switch(trns.getRecordId()) {
                    case EFTTransactionDTO.RECORD_ID_CREDIT:
                        numberOfCredits++;
                        totalCredits += trns.getAmount();
                        break;
                    case EFTTransactionDTO.RECORD_ID_DEBIT:
                        numberOfDebits++;
                        totalDebits += trns.getAmount();
                        break;
                }
            }
            set.getContraRecord().setTransactionSequenceNumber(sequence++);

            //Also use the contra record's homing account to calculate the hash total.
            hash = hash.add(new BigInteger(String.valueOf(set.getContraRecord().getDestinationAccountNumber())));

            switch(set.getContraRecord().getRecordId()) {
                case ContraRecordDTO.RECORD_ID_CREDIT:
                    numberOfDebits++;
                    break;
                case ContraRecordDTO.RECORD_ID_DEBIT:
                    numberOfCredits++;
                    break;
            }
        }
        hash = hash.mod(new BigInteger(String.valueOf("1000000000000")));
        long hashTotal = hash.longValue(); //Get the 6 least significant digits
        long total = totalCredits + totalDebits;

        retval.setFirstSequenceNumber(dataSet.getUserHeader().getFirstSequenceNumber());
        retval.setLastSequenceNumber(sequence - 1); //When we set the sequence number for the contra, we go one over
        retval.setNumberOfCredits(numberOfCredits);
        retval.setTotalCredit(total);
        retval.setNumberOfDebits(numberOfDebits);
        retval.setTotalDebit(total);
        retval.setHashTotal(hashTotal);

        return retval;
    }
}
