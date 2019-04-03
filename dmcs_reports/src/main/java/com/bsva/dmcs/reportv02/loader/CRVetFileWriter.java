package com.bsva.dmcs.reportv02.loader;

import static com.bsva.dmcs.reportv02.util.StringUtils.format;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bsva.dmcs.reportv02.commons.CRFileWriter;
import com.bsva.dmcs.reportv02.util.Justification;
import com.bsva.dto.Direction;
import com.bsva.dto.ErrorDTO;
import com.bsva.dto.FileHeaderDTO;
import com.bsva.dto.FileStats;
import com.bsva.entities.v02.params.CompanyParametersEntity;

public abstract class CRVetFileWriter extends CRFileWriter {

    protected final static String LINE_SEPARATOR = System.getProperty("line.separator");
    protected final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    protected final static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH'H'mm");

    protected final static DecimalFormat NUMBER_FORMAT
            = new DecimalFormat("###,###,###,##0");

    protected final static DecimalFormat DECIMAL_FORMAT
            = new DecimalFormat("###,###,###,##0.00");

    protected final CompanyParametersEntity params;
    protected final Date processDate;
    protected final String serviceID;
    protected final String subServiceID;
    protected final Map<Integer, String> errorCodes;

    protected Integer pageNumber;

    public CRVetFileWriter(CompanyParametersEntity params,
                         Date processDate,
                         String serviceID,
                         String subServiceID,
                         String reportFolder,
                         String reportID,
                         Map<Integer, String> errorCodes) {

        super(subServiceID, reportFolder, reportID);

        this.params = params;
        this.processDate = processDate;
        this.serviceID = serviceID;
        this.subServiceID = subServiceID;
        this.errorCodes = errorCodes;
    }
    public abstract void writeData(Integer issuerMemberCode,
                               String filename,
                               FileHeaderDTO header,
                               List<ErrorDTO> errors,
                               FileStats fileStats)
            throws FileNotFoundException;

    protected void writeData( Integer issuerMemberCode,
                          String filename,
                          FileHeaderDTO header,
                          List<ErrorDTO> errors,
                          FileStats stats,
                          Integer errorLimit,
                          String reportName)
            throws FileNotFoundException {

        PrintWriter out = null;
        try {

            // create output file
            String reportFilename = csr00xFilename(issuerMemberCode, filename);
            out = new PrintWriter(reportFilename);
            String headerFilename =  filename.substring(2);
            // increment counter and write control header
            int count = 1;
            header.setRecordLength(132);
            header.setDirection(Direction.OUT);
            String originalSubServiceID = header.getSubServiceID();
            header.setSubServiceID("REPORTS");
            writeControlHeaderData(processDate, header, out);

            // increment counter and write file header
            count += 15;
            writerHeaderData(out, header.getFilename(), originalSubServiceID, reportName, header.getOriginatorID());

            // increment counter and write txn details
            count += ( errorLimit == null ?
                        errors.size()
                        : ( errors.size() > errorLimit ?
                                errorLimit
                                : errors.size() ) );
            writeDetailData(out, errors, errorLimit, filename);

            // increment counter and write file stats
            count += 15;
            writeFileStatsData(out, stats);

            // increment counter and writer control trailer
            count += 1;
            header.setRecordCount(count);
            writeControlTrailerData(processDate, header, out);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {out.flush();} catch (Exception e){}
            try {out.close();} catch (Exception e){}
        }
    }

    protected abstract void writerHeaderData( PrintWriter out,
                                          String filename,
                                          String subServiceID,
                                          String reportName,
                                          Integer acquirerCode);

    protected void writeDetailData(PrintWriter out, List<ErrorDTO> errors, Integer errorLimit, String filename) {

        if (errorLimit == null || errorLimit > errors.size()) {
            errorLimit = errors.size();
        }

        for ( int idx = 0; idx < errorLimit; ++idx) {

            ErrorDTO error = errors.get(idx);

            Integer errorCode = error.getErrorCode().getCode();

            String s =
                    format(error.getRecordID(),            10, ' ', Justification.LEFT) +
                    format(error.getRecordSequence(),      10, ' ', Justification.LEFT) +
                    format(errorCode,                      10, ' ', Justification.LEFT) +
                    format(errorCodes.get(errorCode),     43, ' ', Justification.LEFT) +
                    format(error.getFieldContents(),      14, ' ', Justification.LEFT);

            out.println( s );
        }
    }

    protected abstract void writeFileStatsData(PrintWriter out, FileStats stats);

    protected Long totalAcceptedRecCount(FileStats stats) {

        return stats.getAcceptedFinRecCount() +
                stats.getAcceptedNonFinRecCount() +
                stats.getAcceptedNegativeCardRecCount() +
                stats.getAcceptedControlRecCount();
    }

    protected Long totalRejectedRecCount(FileStats stats) {

        return stats.getRejectedFinRecCount() +
                stats.getRejectedNonFinRecCount() +
                stats.getRejectedNegativeCardRecCount() +
                stats.getRejectedControlRecCount();
    }
}

