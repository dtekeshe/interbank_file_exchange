package com.bsva.dmcs.fileloadv02.util;

import com.bsva.dao.v02.*;
import com.bsva.dao.v02.fileloader.FilenamePrefixesDAO;
import com.bsva.dao.v02.members.MemberTapeIDsDAO;
import com.bsva.dao.v02.members.MembersDAO;
import com.bsva.dmcs.fileloadv02.billing.BillingCalculator;
import com.bsva.dmcs.fileloadv02.dto.Service;
import com.bsva.dmcs.fileloadv02.dto.SubService;
import com.bsva.dmcs.fileloadv02.indexer.FileIndexer;
import com.bsva.dmcs.fileloadv02.indexer.GenericFileIndexer;
import com.bsva.dmcs.fileloadv02.loaders.FileLoader;
import com.bsva.dmcs.fileloadv02.loaders.OracleSQLLoader;
import com.bsva.dmcs.fileloadv02.model.ServiceType;
import com.bsva.dmcs.fileloadv02.parsers.TxnRecordParser;
import com.bsva.dmcs.reportv02.loader.CR003VetFileWriter;
import com.bsva.dmcs.reportv02.loader.CR023VetFileWriter;
import com.bsva.dmcs.reportv02.loader.CRVetFileWriter;
import com.bsva.dmcs.reportv02.loader.CSR003VetFileWriter;
import com.bsva.dmcs.reportv02.loader.CSR021VetFileWriter;
import com.bsva.dmcs.reportv02.loader.CSR023VetFileWriter;
import com.bsva.dmcs.reportv02.loader.VetFileWriter;
import com.bsva.dto.Environment;
import com.bsva.entities.v02.params.CompanyParametersEntity;
import com.bsva.entities.v02.loader.ServiceTypeEntity;
import com.bsva.entities.v02.params.SystemParametersEntity;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.Oracle8iDialect;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Document
 */
public class LoaderUtils {

    /**
     * Load service types
     *
     * @param entities
     * @return
     * @throws UnknownHostException
     */
    public static Map<String, ServiceType> loadServiceTypes(Map<String,
            ServiceTypeEntity> entities)
            throws UnknownHostException, SystemConfigurationException {

        Map<String, ServiceType> serviceTypes = new HashMap<>();

        // system parameters
        SystemParametersEntity systemParametersEntity = new SystemParametersDAO().systemParameters();
        // company parameters
        CompanyParametersEntity companyParametersEntity = new CompanyParametersDAO().companyParameters();
        // directories
        Map<String, String> paths = new DirectoryDAO().directories();
        // member codes
        Map<Integer, Integer> memberCodes = new MembersDAO().memberCodes();

        // is today a public holiday
        List<Date> publicHolidays = new PublicHolidaysDAO().publicHolidays();
        //LocalDate date = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(systemParametersEntity.getProcessDate()));
        Calendar cal = Calendar.getInstance();
        cal.setTime(systemParametersEntity.getProcessDate());
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        
        boolean isPublicHoliday = publicHolidays
                                    .contains(cal.getTime());
        // error codes
        Map<Integer, String> errorCodes = new ErrorCodesDAO().errorCodes();

        // program controls
        ProgramControlsDAO programControlsDAO = new ProgramControlsDAO();

        // outbound filename prefixes
        Map<String, String> filenamePrefixes
                = new FilenamePrefixesDAO().filenamePrefixes("O");

        // inbound filename prefixes
        Map<String, String> inboundFilenamePrefixes
                = new FilenamePrefixesDAO().filenamePrefixes("I");

        for (String key : entities.keySet()) {

            ServiceTypeEntity entity = entities.get( key );

            try {

                // instantiate billing calculator
                BillingCalculator billingCalculator = billingCalculatorInstance(entity, companyParametersEntity);

                // instantiate txn record parser
                TxnRecordParser txnRecordParser = txnRecordParserInstance(entity);

                // member tape ids
                Map<String, Integer> memberTapeIds
                        = new MemberTapeIDsDAO().memberTapeIds(entity.getSubServiceID());

                // instantiate report writers
                // CSR003
                VetFileWriter csr003VetFileWriter =
                        new CSR003VetFileWriter(
                                companyParametersEntity,
                                systemParametersEntity.getProcessDate(),
                                entity.getServiceID(),
                                entity.getSubServiceID(),
                                paths.get("REPORTS"),
                                errorCodes );

                //CSR023
                VetFileWriter csr023VetFileWriter =
                        new CSR023VetFileWriter(
                                companyParametersEntity,
                                systemParametersEntity.getProcessDate(),
                                entity.getServiceID(),
                                entity.getSubServiceID(),
                                paths.get("REPORTS"),
                                errorCodes );
                //CSR021
                VetFileWriter csr021VetFileWriter =
                        new CSR021VetFileWriter(
                                companyParametersEntity,
                                systemParametersEntity.getProcessDate(),
                                entity.getServiceID(),
                                entity.getSubServiceID(),
                                paths.get("REPORTS"),
                                errorCodes );
                
                //CR023
                CRVetFileWriter cr023VetFileWriter =
                        new CR023VetFileWriter(
                                companyParametersEntity,
                                systemParametersEntity.getProcessDate(),
                                entity.getServiceID(),
                                entity.getSubServiceID(),
                                paths.get("SEND"),
                                errorCodes );
                
                //CR003
                CRVetFileWriter cr003VetFileWriter =
                        new CR003VetFileWriter(
                                companyParametersEntity,
                                systemParametersEntity.getProcessDate(),
                                entity.getServiceID(),
                                entity.getSubServiceID(),
                                paths.get("SEND"),
                                errorCodes );

                // instantiate file indexer
                String subServiceID = entity.getSubServiceID();
                String outFilenamePrefix = filenamePrefixes.get(subServiceID);
                String inFilenamePrefix = inboundFilenamePrefixes.get(subServiceID);

                FileIndexer fileIndexer
                        = new GenericFileIndexer(
                        memberCodes,
                        memberTapeIds,
                        billingCalculator,
                        txnRecordParser,
                        csr003VetFileWriter,
                        csr023VetFileWriter,
                        csr021VetFileWriter,
                        cr003VetFileWriter,
                        cr023VetFileWriter,
                        Environment.environment(systemParametersEntity.getEnvironmentID()),
                        systemParametersEntity.getProcessDate(),
                        isPublicHoliday,
                        paths.get("RECEIVE_PATH"),
                        paths.get("FILE_LOADER_INDEX"),
                        paths.get("REPORTS_PATH"),
                        paths.get("EXPORT_FOLDER"),
                        paths.get("SEND_PATH"),
                        Service.valueOf(entity.getServiceID()),
                        SubService.getEnum(entity.getSubServiceID()),
                        companyParametersEntity,
                        programControlsDAO,
                        outFilenamePrefix,
                        inFilenamePrefix);
                // instantiate service type
                ServiceType serviceType
                        = new ServiceType(
                                SubService.getEnum(entity.getSubServiceID()),
                                fileIndexer,
                                entity.getFileLoaderName());

                // save service type
                serviceTypes.put(key, serviceType);

            } catch ( ClassNotFoundException | NoSuchMethodException | InvocationTargetException
                        | InstantiationException | IllegalAccessException | SystemConfigurationException  e) {
                throw new SystemConfigurationException(e.getMessage());
            }
        }
        return serviceTypes;
    }

    /**
     * Instantiate billing calculator
     *
     * @param serviceTypeEntity
     * @param companyParametersEntity
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private static BillingCalculator billingCalculatorInstance(
                        ServiceTypeEntity serviceTypeEntity,
                        CompanyParametersEntity companyParametersEntity)

            throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {

        BillingCalculator billingCalculator =
                Class.forName(serviceTypeEntity.getFileBillingCalculatorName())
                        .asSubclass(BillingCalculator.class)
                        .getConstructor(
                                Service.class,
                                SubService.class,
                                BigDecimal.class)
                        .newInstance(
                                Service.valueOf(serviceTypeEntity.getServiceID()),
                                SubService.getEnum(serviceTypeEntity.getSubServiceID()),
                                companyParametersEntity.getVatPercentage());

        return billingCalculator;
    }

    /**
     * Instantiate billing calculator
     *
     * @param serviceTypeEntity
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    private static TxnRecordParser txnRecordParserInstance(
            ServiceTypeEntity serviceTypeEntity)

            throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {

        TxnRecordParser txnRecordParser =
                Class.forName(serviceTypeEntity.getTxnRecordParserName())
                        .asSubclass(TxnRecordParser.class)
                        .newInstance();

        return txnRecordParser;
    }

    /**
     * Instantiate file loader
     *
     * @return
     * @throws SQLLoaderNotImplemented
     * @throws UnknownHostException
     */
    public static FileLoader fileLoaderInstance()
            throws SQLLoaderNotImplemented, UnknownHostException {

        // file folders
        Map<String, String> paths = new DirectoryDAO().directories();

        // get dialect
        Dialect dialect = new UtilDAO().getDialect();

        // select file loader
        if (dialect instanceof Oracle8iDialect) {
            return new OracleSQLLoader(
                            paths.get("FILE_LOADER_CONTROL"),
                            paths.get("FILE_LOADER_INDEX"),
                            paths.get("FILE_LOADER_LOG"));
        } else if (dialect instanceof MySQLDialect) {

            throw new SQLLoaderNotImplemented("File Loader for MYSQL not implemented yet.");
        } else {

            throw new SQLLoaderNotImplemented("File Loader for this unknown database not implemented yet.");
        }
    }
}
