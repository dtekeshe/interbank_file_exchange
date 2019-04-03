//package com.bsva.dmcs.fileloadv02.util;
//
//import com.bsva.dmcs.fileloadv02.dto.BillingKey;
//import com.bsva.dmcs.fileloadv02.dto.CardFeeBilateralRate;
//import com.bsva.dmcs.fileloadv02.model.OriginDestinationPair;
//import com.bsva.dto.Filename;
//import com.bsva.entities.*;
//import com.bsva.entities.v02.members.MemberParamKey;
//import com.bsva.entities.v02.outputcontrols.OutputControlEntity;
//
//import java.util.*;
//
///**
// * TODO document
// */
//public class MapFactory {
//
//    private final static List<Integer> APPLICABLE_BILATERAL_CODES = Arrays.asList(new Integer[]{8, 18, 28});
//
//    public static Map<OriginDestinationPair, List<Filename>> filenames(
//                        List<OutputControlEntity> filenameList, Map<MemberParamKey, Long> outputFileSizeLimits) {
//
//        Map<OriginDestinationPair, List<Filename>> map = new HashMap<>();
//
//        for (OutputControlEntity item : filenameList ) {
//            OriginDestinationPair pair = OriginDestinationPair.instance(item);
//            List<Filename> list = map.get(pair);
//            if (list == null) {
//                list = new ArrayList<>();
//                map.put(pair, list);
//            }
////            Issuer issuer = Issuer.instance(item);
//            // file size limits
//            MemberParamKey issuerKey = new MemberParamKey();
//            issuerKey.setBankCode(item.getId().getIssuingBankCode());
//            issuerKey.setServiceID(item.getId().getServiceID());
//            issuerKey.setSubServiceID(item.getId().getSubServiceID());
//
//            Long maxTransactionCount = outputFileSizeLimits.get(issuerKey);
//
//            list.add(
//                    new Filename( item.getFilenameDescription(),
//                                  maxTransactionCount,
//                                  item.getRecordCount() == 0 ? 2 : item.getRecordCount(),
//                                  Long.parseLong(item.getSeqNumber())));
//        }
//
//        return map;
//    }
//
////    public static Map<Issuer, Long> outputFileSizeLimit(List<CsfMemberService> issuerList) {
////
////        Map<Issuer, Long> map = new HashMap<>();
////        for (CsfMemberService item : issuerList) {
////            map.put(Issuer.instance(item), Long.parseLong(item.getMaxSizeTransFile()));
////        }
////        return map;
////    }
//
//    public static Map<String, Integer> lastSeqNumbers(String filenamePrefix, List<CsoSeqNumbers> seqNumbers) {
//
//        Map<String, Integer> map = new HashMap<>();
//        for (CsoSeqNumbers item : seqNumbers) {
//            if (! item.getCsoSeqNumbersPK().getExternalFilenamePrefix().equalsIgnoreCase(filenamePrefix)) {
//                continue;
//            }
//
//            map.put( item.getCsoSeqNumbersPK().getDistributionCode(),
//                        Integer.parseInt("" + item.getLastSeqNumberUsed()));
//        }
//
//        return map;
//    }
//
//    public static Map<BillingKey, CardFeeBilateralRate> bilateralRatesMap(List<CsfCardFeeBilateral> bilateralRatesList) {
//
//        Map<BillingKey, CardFeeBilateralRate> map = new HashMap<>();
//
//        for (CsfCardFeeBilateral rate : bilateralRatesList) {
//
//            CsfCardFeeBilateralPK id = rate.getCsfCardFeeBilateralPK();
//
//            if ( ! APPLICABLE_BILATERAL_CODES.contains(Integer.parseInt(id.getTransactionCode()))) {
//                continue;
//            }
//
//            BillingKey key
//                    = BillingKey.parse(id.getIssuingMember(),
//                    id.getAcquiringMember(),
//                    id.getTransactionCode(),
//                    rate.getCardType().getCardType());
//
//            map.put(key,
//                    new CardFeeBilateralRate( rate.getInterchangeFee(),
//                                              rate.getInterchangeFeeAmount(),
//                                              rate.getInputVat()));
//        }
//
//        return map;
//    }
//}
