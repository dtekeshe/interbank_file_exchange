/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */

package za.co.bsv.util.eft.dto;

import java.util.List;

/**
 * EFT file user data set
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class UserDataSetDTO {
    private UserHeaderDTO userHeader;
    private UserTrailerDTO userTrailer;
    private List<TransactionSetDTO> transactionSets;

    /**
     * @return the userHeader
     */
    public UserHeaderDTO getUserHeader() {
        return userHeader;
    }

    /**
     * @param userHeader the userHeader to set
     */
    public void setUserHeader(UserHeaderDTO userHeader) {
        this.userHeader = userHeader;
    }

    /**
     * @return the userTrailer
     */
    public UserTrailerDTO getUserTrailer() {
        return userTrailer;
    }

    /**
     * @param userTrailer the userTrailer to set
     */
    public void setUserTrailer(UserTrailerDTO userTrailer) {
        this.userTrailer = userTrailer;
    }

    /**
     * @return the transactionSets
     */
    public List<TransactionSetDTO> getTransactionSets() {
        return transactionSets;
    }

    /**
     * @param transactionSets the transactionSets to set
     */
    public void setTransactionSets(List<TransactionSetDTO> transactionSets) {
        this.transactionSets = transactionSets;
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();
        buff.append(userHeader.toString());
        buff.append('\n');
        for(TransactionSetDTO set : transactionSets) {
            buff.append(set.toString());
            buff.append('\n');
        }
        buff.append(userTrailer.toString());
        return buff.toString();
    }
}
