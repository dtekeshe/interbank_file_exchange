package com.bsva.dto;

/**
 * File Status information required by the BILL, PRE-EXTRACT, EXTRACT and SETTLE processes.
 *
 */
public class FileStatusDTO {

    private final FileProcessStatus fileProcessStatus;
    private final String billed;
    private final String preExtracted;

    public FileStatusDTO(FileProcessStatus fileProcessStatus, String billed, String preExtracted) {
        this.fileProcessStatus = fileProcessStatus;
        this.billed = billed;
        this.preExtracted = preExtracted;
    }

    public String getBilled() {
		return billed;
	}

	public String getPreExtracted() {
		return preExtracted;
	}

	public FileProcessStatus getFileProcessStatus() {
        return fileProcessStatus;
    }

  

    public enum FileProcessStatus {
        ACCEPTED ("A"), BUSY("B"), EXTRACTED("E");

        private final String statusCode;

        FileProcessStatus(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public static FileProcessStatus getByStatusCode(String statusCode) {

            FileProcessStatus[] items = values();
            for (FileProcessStatus item : items) {
                if (item.getStatusCode().equals(statusCode)) {
                    return item;
                }
            }
            return null;
        }


        @Override
        public String toString() {
            return "FileProcessStatus{" +
                    "statusCode='" + statusCode + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "FileStatusDTO{" +
                "fileProcessStatus=" + fileProcessStatus +
                ", billed=" + billed +
                ", preExtracted=" + preExtracted +
                '}';
    }
}
