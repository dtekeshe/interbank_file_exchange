package com.bsva.dmcs.fileloadv02.util;

import com.bsva.dto.ErrorCode;
import com.bsva.dto.ErrorDTO;

import java.util.List;

/**
 *
 */
public class FileStructureComparator {

    public static void compare(
                            String[] ids,
                            String[] expectedIds,
                            List<ErrorDTO> errors,
                            int startLineId,
                            ErrorCode errorCode) {

        for (int idx = 0; idx < ids.length && idx < expectedIds.length; ++idx) {
            if (! ids[idx].equals(expectedIds[idx])) {
                errors.add(
                        new ErrorDTO(
                                expectedIds[idx],
                                Long.parseLong("" + (startLineId + idx)),
                                errorCode,
                                1,
                                ids[idx]));
            }
        }
    }
}
