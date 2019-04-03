package com.bsva.dmcs.fileextractv02;

import com.bsva.dao.v02.extract.OutputFileReaderDAO;
import com.bsva.dcms.commons.util.Utils;
import com.bsva.entities.v02.extract.OutputControlsEntity;
import com.bsva.entities.v02.outputcontrols.LastFileOutputControlKey;
import com.bsva.entities.v02.outputcontrols.OutputControlDayTotalEntity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class FileExtractor extends FileWriter {

    private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###.##");

    private OutputFileReaderDAO outputFileReaderDAO;

    /**
     * TODO Document
     *
     * @param environmentID
     * @param validationCode
     * @param processDate
     * @param exportFolder
     * @param sendFolder
     */
    public FileExtractor( String environmentID,
                          String validationCode,
                          Date processDate,
                          String exportFolder,
                          String sendFolder,
                          OutputFileReaderDAO outputFileReaderDAO ) {

        super(  environmentID,
                validationCode,
                processDate,
                exportFolder,
                sendFolder);

        this.outputFileReaderDAO = outputFileReaderDAO;
    }

    /**
     * TODO Document
     *  @param files
     * @param isEndOfService
     * @param dayTotals
     */
    public void extract(List<OutputControlsEntity> files,
                        boolean isEndOfService,
                        Map<LastFileOutputControlKey, OutputControlDayTotalEntity> dayTotals) {

        for (OutputControlsEntity file : files) {

            String prefix = file.getFilenamePrefix();
            RandomAccessFile writer = null;
            String filepath = null;
            try {

                spolog("FILE OUTPUT FOR: " + file.getFilename() + ", STARTED.", name(prefix));
                long startedAt = System.currentTimeMillis();

                // open export file
                String indexPath = exportFolder + FILE_SEPARATOR + file.getFilename() + ".idx";
                filepath = exportFolder + FILE_SEPARATOR + file.getFilename();
                // rename
                new File(indexPath).renameTo(new File(filepath));

                writer = new RandomAccessFile(filepath, "rw");

                // go to start of file
                writer.skipBytes(0);//.seek(0L);

                // build file header
                String fileHeaderRecord = buildFileHeaderRecord( file );
                //String emptyheader = "";
                // write file header
                writer.write(fileHeaderRecord.getBytes());
               // writer.write(emptyheader.getBytes());
                // close writer
                writer.close();

                
                // re open file
                PrintWriter out = null;

                try {
                    out = new PrintWriter(
                            new BufferedWriter(
                                    new java.io.FileWriter(filepath, true)));

                    // write 98 Rec if last file of the day
                    boolean has98Record = isEndOfService && file.isLastFile();
                    if (has98Record) {

                        LastFileOutputControlKey key
                                = lastFileOutputControlKey(file);
                        OutputControlDayTotalEntity dayTotal
                                    = dayTotals.get(key);

                        String file98Record = build98Record(file, dayTotal);
                        out.println(file98Record);
                    }

                    // build file trailer
                    String fileTrailerRecord = buildFileTrailerRecord(file, has98Record,file.getFilename());
                    // write file trailer
                    out.print(fileTrailerRecord);
                } finally {
                    try {out.flush();} catch (Exception ex){}
                    try {out.close();} catch (Exception ex){}
                }
                // update database
                outputFileReaderDAO.updateOutputFile(file.getId());

                // close writer
                writer.close();

                // move to send folder
                String sendPath = sendFolder + FILE_SEPARATOR + file.getFilename();
                new File(filepath).renameTo(new File(sendPath));

                // write stats
                long duration = System.currentTimeMillis() - startedAt;
                spolog("FILE: " + file.getFilename() + " PROCESSED SUCCESSFULLY ", name(prefix));
                       // "[ IN " + seconds(duration) + " SECS.]", name(prefix));

            } catch (Exception e) {
                e.printStackTrace();
                spolog("OUTPUT 01 FILE OUTPUT NOT STARTED : " + e.getMessage(), name(prefix));
            }
        }
    }

    private LastFileOutputControlKey lastFileOutputControlKey(OutputControlsEntity file) {

        LastFileOutputControlKey key
                = new LastFileOutputControlKey();
        key.setServiceID(file.getId().getServiceID());
        key.setSubServiceID(file.getId().getSubServiceID());
        key.setDistributionCode(file.getDistributionCode());
        key.setIssuingBankCode(file.getId().getDestBankCode());
        key.setFilenamePrefix(file.getFilenamePrefix());

        return key;
    }

    private static void spolog(String message, String processName) {
        System.out.println(processName + " 01 " + message);
        Utils.logSpolog(message, processName);
    }

    private String name(String filenamePrefix) {
        return filenamePrefix + "OUTPUT";
    }

    private String seconds(long millis) {
        return DECIMAL_FORMAT.format(millis / 1000.00);
    }
}
