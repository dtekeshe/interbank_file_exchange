/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */

package za.co.bsv.util.eft.util;

import java.util.LinkedList;

import za.co.bsv.util.eft.dto.EFTFileDTO;
import za.co.bsv.util.eft.dto.InstallationTrailerDTO;
import za.co.bsv.util.eft.dto.TransactionSetDTO;
import za.co.bsv.util.eft.dto.UserDataSetDTO;

/**
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class EFTFileBuilder {
    private EFTFileDTO eftFile;

    public EFTFileBuilder() {
        eftFile = new EFTFileDTO();
    }

    public void addInstallationHeader(int sourceIdentifier, int destinationIdentifier, String generationNumber, String tapeSerialNumber) {
        eftFile.setInstallationHeader(InstallationHeaderBuilder
                .createInstallationHeader(sourceIdentifier, destinationIdentifier, generationNumber, tapeSerialNumber));
    }

    public void addUserDataSet(UserDataSetDTO userDataSet) {
        if(eftFile.getDataSets() == null) {
            eftFile.setDataSets(new LinkedList<UserDataSetDTO>());
        }
        eftFile.getDataSets().add(userDataSet);
    }

    public EFTFileDTO createEFTFile() {
        eftFile.setInstallationTrailer(createInstallationTrailer());

        return eftFile;
    }

    private InstallationTrailerDTO createInstallationTrailer() {
        InstallationTrailerDTO retval = new InstallationTrailerDTO();

        retval.setRecordId(94);
        retval.setVolumeNumber(eftFile.getInstallationHeader().getVolumeNumber());
        retval.setTapeSerialNumber(eftFile.getInstallationHeader().getTapeSerialNumber());
        retval.setSourceIdentifier(eftFile.getInstallationHeader().getSourceIdentifier());
        retval.setDestinationIdentifier(eftFile.getInstallationHeader().getDestinationIdentifier());
        retval.setCreationDate(eftFile.getInstallationHeader().getCreationDate());
        retval.setPurgeDate(eftFile.getInstallationHeader().getPurgeDate());
        retval.setGenerationNumber(eftFile.getInstallationHeader().getGenerationNumber());
        retval.setBlockLength(eftFile.getInstallationHeader().getBlockLength());
        retval.setRecordLength(eftFile.getInstallationHeader().getRecordLength());
        retval.setService(eftFile.getInstallationHeader().getService());

        int recordCount = 1; //Count installation header
        int headerTrailerCount = 0;

        for(UserDataSetDTO dataSet : eftFile.getDataSets()) {
            recordCount += 2; //Count user header and trailer
            headerTrailerCount += 2;

            for(TransactionSetDTO trnsSet : dataSet.getTransactionSets()) {
                recordCount++; //Count contra records
                recordCount += trnsSet.getTransactions().size();
            }
        }
        recordCount += 1; //Also count the installation trailer
        retval.setRecordCount(recordCount);
        retval.setBlockCount(recordCount/10 + (recordCount % 10 == 0 ? 0 : 1));
        retval.setUserHeaderTrailerCount(headerTrailerCount);

        return retval;
    }
}
