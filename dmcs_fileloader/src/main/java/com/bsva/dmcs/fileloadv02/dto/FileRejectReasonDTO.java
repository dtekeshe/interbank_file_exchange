package com.bsva.dmcs.fileloadv02.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 *
 */
@XmlRootElement(name = "error")
public class FileRejectReasonDTO implements Serializable {

    private List<ErrorDTO> fileRejectionReasons;

    public FileRejectReasonDTO() {
    }

    public FileRejectReasonDTO(List<ErrorDTO> fileRejectionReasons) {
        this.fileRejectionReasons = fileRejectionReasons;
    }

    public List<ErrorDTO> getFileRejectionReasons() {
        return fileRejectionReasons;
    }

    @XmlElement(name = "fileRejectReason")
    public void setFileRejectionReasons(List<ErrorDTO> fileRejectionReasons) {
        this.fileRejectionReasons = fileRejectionReasons;
    }
}
