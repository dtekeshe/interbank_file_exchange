/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */

package za.co.bsv.util.eft.util;

import java.util.Date;

import za.co.bsv.util.eft.dto.EFTTransactionDTO;

/**
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class EFTTransactionBuilder {

    public static EFTTransactionDTO createCreditTransaction(int sourceBranchCode,
            long sourceAccountNumber, int userCode, int destinationBranchCode,
            long destinationAccountNumber, long amount, String userReference, String accountName, String shortName)
    {
        EFTTransactionDTO retval = createEFTTransaction(sourceBranchCode,
                sourceAccountNumber, userCode, destinationBranchCode,
                destinationAccountNumber, amount, userReference, accountName, shortName);

        retval.setRecordId(EFTTransactionDTO.RECORD_ID_CREDIT);
        retval.setEntryClass(EFTTransactionDTO.ENTRY_CLASS_CREDIT);
        

        return retval;
    }

    public static EFTTransactionDTO createDebitTransaction(int sourceBranchCode,
            long sourceAccountNumber, int userCode, int destinationBranchCode,
            long destinationAccountNumber, long amount, String userReference, String accountName, String shortName)
    {
        EFTTransactionDTO retval = createEFTTransaction(sourceBranchCode,
                sourceAccountNumber, userCode, destinationBranchCode,
                destinationAccountNumber, amount, userReference, accountName, shortName);

        retval.setRecordId(EFTTransactionDTO.RECORD_ID_DEBIT);
        retval.setEntryClass(EFTTransactionDTO.ENTRY_CLASS_DEBIT);

        return retval;
    }

    private static EFTTransactionDTO createEFTTransaction(int sourceBranchCode,
            long sourceAccountNumber, int userCode, int destinationBranchCode,
            long destinationAccountNumber, long amount, String userReference, String accountName, String shortName)
    {
        EFTTransactionDTO retval = new EFTTransactionDTO();

        retval.setSourceBranchCode(sourceBranchCode);
        retval.setSourceAccountNumber(sourceAccountNumber);
        retval.setUserCode(userCode);
        retval.setDestinationBrancCode(destinationBranchCode);
        retval.setDestinationAccountNumber(destinationAccountNumber);
        retval.setAccountType(EFTTransactionDTO.ACCOUNT_TYPE_CURRENT);
        retval.setAmount(amount);
        retval.setActionDate(new Date());
        retval.setTaxCode(0);
        retval.setShortName(shortName);
        retval.setUserReference(userReference);
        retval.setSourceAccountName(accountName);
        retval.setDestinationInstitution(21);

        return retval;
    }
}
