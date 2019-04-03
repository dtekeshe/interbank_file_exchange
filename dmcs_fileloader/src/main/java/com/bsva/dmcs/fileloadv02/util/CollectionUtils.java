package com.bsva.dmcs.fileloadv02.util;

import static com.bsva.dmcs.fileloadv02.util.InsertionSort.sort;

import com.bsva.dmcs.fileloadv02.dto.ErrorDTO;
import com.bsva.dmcs.fileloadv02.model.FileDetailDTO;
import com.bsva.entities.CsfTransactionTypes;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class CollectionUtils {

    public static int[] toTransactionCodeArray(Collection<CsfTransactionTypes> codes) {

        int[] result = new int[codes.size()];
        int idx = 0;
        for (CsfTransactionTypes code : codes) {
            result[idx++] = code.getTransactionCode();
        }

        return sort(result);
    }

    public static int[] toTransactionCodeArray(Set<String> codes) {

        int[] result = new int[codes.size()];
        int idx = 0;

        for (String code : codes) {
            result[idx++] = Integer.parseInt(code);
        }

        return sort(result);
    }

    public static boolean isValid(List<ErrorDTO> errors) {
        return errors.size() == 0;
    }

    public static boolean empty(FileDetailDTO[] paymentLines) {
        return paymentLines.length == 0;
    }

    public final static FileDetailDTO[] EMPTY;
    static {
        EMPTY = new FileDetailDTO[]{};
    }

}
