package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.dao.v02.members.MemberServicesDAO;
import com.bsva.dto.Filename;
import com.bsva.dto.OriginDestinationPair;
import com.bsva.entities.v02.members.MemberParamKey;
import com.bsva.entities.v02.outputcontrols.OutputControlEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class OutputControlDAO extends AbstractDao<OutputControlEntity, Void> {

    /*
        @Column(name = "CR_VOLUME")
    private Long outputFileCrVolume;
    @Column(name = "CR_VALUE")
    private Double outputFileCrValue;
    @Column(name = "DR_VOLUME")
    private Long outputFileDrVolume;
    @Column(name = "DR_VALUE")
    private Double outputFileDrValue;
     */
    private static final String OUTPUT_CONTROL_SQL =
            " SELECT SERVICE, SUB_SERVICE, " +
            "        ORIGINATING_MEMBER AS ACQUIRING_BANK_CODE, BANK_CODE AS ISSUING_BANK_CODE, " +
            "        DISTRIBUTION_CODE, FILENAME_DESCRIPTION, FILENAME_PREFIX, " +
            "        RECORD_COUNT, SEQ_NUMBER, FULLFILEIND," +
            "        CR_VOLUME, CR_VALUE, DR_VOLUME, DR_VALUE " +
            "   FROM CSO_OUTPUT_CONTROLS " +
            "  WHERE SERVICE = :serviceID " +
            "    AND SUB_SERVICE = :subServiceID " +
            "  ORDER BY SEQ_NUMBER ";

    public Map<OriginDestinationPair, List<Filename>> filenames(String serviceID, String subServiceID) {

        // params
        Map<String, Object> params = new HashMap<>();
        params.put("serviceID", serviceID);
        params.put("subServiceID", subServiceID);

        // execute
        List<OutputControlEntity> entities
                = list(OUTPUT_CONTROL_SQL, params, OutputControlEntity.class);

        // prepare result

        // output file size limits
        Map<MemberParamKey, Long> outputFileSizeLimits = new MemberServicesDAO().memberFileLimits();
        Map<OriginDestinationPair, List<Filename>> filenames =
                filenames(entities, outputFileSizeLimits);

        return filenames;
    }

    private Map<OriginDestinationPair, List<Filename>> filenames(
            List<OutputControlEntity> entities, Map<MemberParamKey, Long> outputFileSizeLimits) {

        Map<OriginDestinationPair, List<Filename>> map = new HashMap<>();

        for (OutputControlEntity item : entities ) {
            OriginDestinationPair pair = OriginDestinationPair.instance(item);
            List<Filename> list = map.get(pair);
            if (list == null) {
                list = new ArrayList<>();
                map.put(pair, list);
            }
//            Issuer issuer = Issuer.instance(item);
            // file size limits
            MemberParamKey issuerKey = new MemberParamKey();
            issuerKey.setBankCode(item.getId().getIssuingBankCode());
            issuerKey.setServiceID(item.getId().getServiceID());
            issuerKey.setSubServiceID(item.getId().getSubServiceID());

            Long maxTransactionCount = outputFileSizeLimits.get(issuerKey);

            list.add(
                    new Filename( item.getFilenameDescription(),
                            maxTransactionCount,
                            item.getRecordCount() == 0 ? 2 : item.getRecordCount(),
                            Long.parseLong(item.getSeqNumber()),
                            item.getOutputFileCrVolume(), item.getOutputFileCrValue(),
                            item.getOutputFileDrVolume(), item.getOutputFileDrValue()));
        }

        return map;
    }
}
