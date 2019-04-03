/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */

package za.co.bsv.util.eft.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

import za.co.bsv.util.eft.dto.UserHeaderDTO;

/**
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class UserHeaderBuilder {
    public static UserHeaderDTO createUserHeader(int userCode, String generationNumber, String service, int firstSequence) {
        UserHeaderDTO retval = new UserHeaderDTO();

        retval.setRecordId(4);
        retval.setUserCode(userCode);
        Calendar now = GregorianCalendar.getInstance();

        retval.setCreationDate(now.getTime());
        retval.setFirstActionDate(now.getTime());
        retval.setLastActionDate(now.getTime());

        now.add(Calendar.DAY_OF_MONTH, 1);
        retval.setPurgeDate(now.getTime());
        retval.setFirstSequenceNumber(firstSequence);
        retval.setGenerationNumber(generationNumber);
        retval.setService(service);
        return retval;
    }

}
