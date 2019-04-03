package com.bsva.dmcs.fileloadv02.validators;

import com.bsva.dmcs.fileloadv02.dto.ErrorDTO;

import java.io.IOException;
import java.util.List;

/**
 * TODO documentation
 */
public interface Validator {
    void validateFileStructure(String filename, List<ErrorDTO> errors) throws IOException;
}
