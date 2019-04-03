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
 * Represents the EFT file
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class EFTFileDTO {
    private List<UserDataSetDTO> dataSets;
    private InstallationHeaderDTO installationHeader;
    private InstallationTrailerDTO installationTrailer;

    /**
     * @return the dataSets
     */
    public List<UserDataSetDTO> getDataSets() {
        return dataSets;
    }

    /**
     * @param dataSets the dataSets to set
     */
    public void setDataSets(List<UserDataSetDTO> dataSets) {
        this.dataSets = dataSets;
    }

    /**
     * @return the installationHeader
     */
    public InstallationHeaderDTO getInstallationHeader() {
        return installationHeader;
    }

    /**
     * @param installationHeader the installationHeader to set
     */
    public void setInstallationHeader(InstallationHeaderDTO installationHeader) {
        this.installationHeader = installationHeader;
    }

    /**
     * @return the installationTrailer
     */
    public InstallationTrailerDTO getInstallationTrailer() {
        return installationTrailer;
    }

    /**
     * @param installationTrailer the installationTrailer to set
     */
    public void setInstallationTrailer(InstallationTrailerDTO installationTrailer) {
        this.installationTrailer = installationTrailer;
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();
        buff.append(installationHeader.toString());
        buff.append('\n');

        for(UserDataSetDTO uds : dataSets) {
            buff.append(uds.toString());
            buff.append('\n');
        }
        buff.append(installationTrailer.toString());

        return buff.toString();
    }
}
