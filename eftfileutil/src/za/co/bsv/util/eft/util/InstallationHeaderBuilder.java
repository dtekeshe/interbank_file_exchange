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

import za.co.bsv.util.eft.dto.InstallationHeaderDTO;

/**
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class InstallationHeaderBuilder {
    public static InstallationHeaderDTO createInstallationHeader(int sourceIdentifier, int destinationIdentifier, String generationNumber, String tapeSerialNumber) {
        InstallationHeaderDTO retval = new InstallationHeaderDTO();

        retval.setRecordId(2);
        retval.setVolumeNumber(1001);
        retval.setTapeSerialNumber(tapeSerialNumber);
        retval.setSourceIdentifier(sourceIdentifier);
        retval.setDestinationIdentifier(destinationIdentifier);
        Calendar now = GregorianCalendar.getInstance();

        retval.setCreationDate(now.getTime());
        now.add(Calendar.DAY_OF_MONTH, 1);
        retval.setPurgeDate(now.getTime());
        retval.setGenerationNumber(generationNumber);
        retval.setBlockLength(1800);
        retval.setRecordLength(180);
        retval.setService("MAGTAPE   ");

        return retval;
    }

}
