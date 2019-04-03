package com.bsva.dmcs.fileloadv02.model;

import static com.bsva.dmcs.fileloadv02.util.StringUtils.format;

import com.bsva.dao.v02.LastSeqNumbersDAO;
import com.bsva.dao.v02.OutputControlDAO;
import com.bsva.dao.v02.OutputControlUpdateDAO;
import com.bsva.dmcs.fileloadv02.dto.Justification;
import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dto.Filename;
import com.bsva.dto.OriginDestinationPair;
import com.bsva.entities.v02.loader.LastSeqNumberKey;
import com.bsva.entities.v02.members.MemberParamKey;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Knows available names.
 * Generates more when the default 8 files for the day are exhausted.
 */
public class FilenameServer {

    private Logger log = Logger.getLogger(FilenameServer.class);

    private final SubService subService;
    private final String filenamePrefix;
    /**
     * A list of filenames available for each acquirer/issuer pair
     * There will be 8 filenames available for each pair at start of day
     * If filenames runs out then more are added on demand
     * If a filename is used up, we drop it from this list.
     */
    private Map<OriginDestinationPair, List<Filename>> filenames;

    private final Map<LastSeqNumberKey, Long> lastSeqNumbers;

    private OutputControlUpdateDAO outputControlUpdateDAO;
    private LastSeqNumbersDAO lastSeqNumbersDAO;
    private Map<MemberParamKey, Long> outputFileSizeLimits;

    public FilenameServer(SubService subService,
                          String filenamePrefix,
                          Map<OriginDestinationPair, List<Filename>> filenames,
                          Map<MemberParamKey, Long> outputFileSizeLimits) {

        //System.out.println("Filename Service Init for filenamePrefix : " + filenamePrefix);

        this.subService = subService;
        this.filenamePrefix = filenamePrefix;
        this.filenames = filenames;
        this.outputFileSizeLimits = outputFileSizeLimits;

        outputControlUpdateDAO = new OutputControlUpdateDAO();
        lastSeqNumbersDAO = new LastSeqNumbersDAO();
        lastSeqNumbers = lastSeqNumbersDAO.lastSeqNumbers();
        //System.out.println("Filename Service :: lastSeqNumbers has : " + lastSeqNumbers.size() + " entities.");
    }

    /**
     * Construct filename for given bank info and service
     * @param originDestinationPair
     * @return
     */
    public Filename getFilename( OriginDestinationPair originDestinationPair) {

        try {

            // existing files for this issuer / acquirer pair
            List<Filename> filenameList = filenames.get(originDestinationPair);

            if (filenameList != null) {

                // get the last file
                int size = filenameList.size();
                Filename filename = filenameList.get(size - 1);

                // is not full use it
                if ( ! isFull(filename)) {

                    // mark it for update
                    if ( ! "INSERT".equals(filename.getActionRequired())) {
                        filename.setActionRequired("UPDATE");
                    }
                    return filename;
                }
            } else {
                // create a new filename list for this issuer / acquirer pair
                // this is unlikely since default files are create at start of day
                filenameList = new ArrayList<>();
            }

            // create a new file
            MemberParamKey param = new MemberParamKey();
            param.setBankCode(originDestinationPair.getDestinationBankCode());
            param.setServiceID("CARD");
            param.setSubServiceID(subService.getDescription());
            Long maxTransactionCount = outputFileSizeLimits.get(param);
            //Filename lastFilename = filenameList.get(filenameList.size() - 1);
            Filename nextFilename = nextFilename(filenamePrefix, originDestinationPair, maxTransactionCount);
            nextFilename.setActionRequired("INSERT");
            filenameList.add(nextFilename);
            filenames.put(originDestinationPair, filenameList);

            return nextFilename;
        } catch(Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * After loading a list of files, the server prunes every filename entry
     * for used filenames.
     * This is not selective because memory operations are not expensive
     */
    public void pruneUsedFilenames() {
        // TODO pruning algorithm
    }

    private boolean isFull( Filename filename) {
        // transaction count + header + trailer
        return filename.getMaxTransactionCount() - filename.getTransactionCount()  <= 0;
    }

    private Filename nextFilename(
                        String filenamePrefix,
                        OriginDestinationPair originDestinationPair,
                        Long maxTransactionCount) {

        LastSeqNumberKey lastSeqNumberKey = new LastSeqNumberKey();
        String distributionCode = originDestinationPair.getDistributionCode();
        lastSeqNumberKey.setExternalFilenamePrefix(filenamePrefix);
        lastSeqNumberKey.setDistributionCode(distributionCode);

        Long seqNumber = null;
        try {
            seqNumber = lastSeqNumbers.get(lastSeqNumberKey) + 1;
            lastSeqNumbers.put(lastSeqNumberKey, seqNumber);
        } catch (Exception e) {
            System.out.println("FilenameServer ; ERROR geting LAST SEQ NUMBER FOR : " + filenamePrefix +
                                ", lastSeqNumberKey : " + lastSeqNumberKey.getDistributionCode() +
                                ", getOriginBankCode : " + originDestinationPair.getOriginBankCode() +
                                ", getDestinationBankCode : " + originDestinationPair.getDestinationBankCode());
            e.printStackTrace();
            System.exit(1);
        }

        Filename filename
                = new Filename(
                        filenamePrefix + distributionCode + format("" + seqNumber, 3, '0', Justification.RIGHT) + "D",
                        maxTransactionCount, 2L, seqNumber, 0L, 0.0, 0L, 0.0);
        return filename;
    }

    public void flashFilenamesToOutputControls() {

        try {

            // update
            outputControlUpdateDAO.updateOutputControls(filenames);
            lastSeqNumbersDAO.updateLastSeqNumbers(lastSeqNumbers);

            // reload
            filenames
                    = new OutputControlDAO().filenames("CARD", subService.getDescription());
        } catch(Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
    /**
     * Construct filename for given bank info and service
     * @param originDestinationPair
     * @return
     */
    public Filename getNegativeFilenames( OriginDestinationPair originDestinationPair) {
        try {
            // existing files for this issuer / acquirer pair
            List<Filename> negFilenameList = filenames.get(originDestinationPair);
             // create a new filename list for this issuer / acquirer pair
             // this is unlikely since default files are create at start of day
            negFilenameList = new ArrayList<>();
            // create a new file
            MemberParamKey param = new MemberParamKey();
            param.setBankCode(originDestinationPair.getDestinationBankCode());
            param.setServiceID("CARD");
            param.setSubServiceID(subService.getDescription());
            Long maxTransactionCount = outputFileSizeLimits.get(param);
            //Filename lastFilename = filenameList.get(filenameList.size() - 1);
            Filename nextFilename = nextFilename(filenamePrefix, originDestinationPair, maxTransactionCount);
            nextFilename.setActionRequired("INSERT");
            negFilenameList.add(nextFilename);
            filenames.put(originDestinationPair, negFilenameList);
           return nextFilename;
        } catch(Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
    }
}
