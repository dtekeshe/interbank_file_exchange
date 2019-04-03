/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */
package za.co.bsv.bend.transformer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import za.co.bsv.bend.transformer.eft.xml.EftFile;
import za.co.bsv.bend.transformer.eft.xml.InstallationType;
import za.co.bsv.bend.transformer.eft.xml.TransactionType;
import za.co.bsv.bend.transformer.eft.xml.UserType;

import za.co.bsv.util.eft.dto.EFTFileDTO;
import za.co.bsv.util.eft.dto.EFTTransactionDTO;
import za.co.bsv.util.eft.dto.TransactionSetDTO;
import za.co.bsv.util.eft.dto.UserDataSetDTO;

import za.co.bsv.util.eft.util.EFTFileBuilder;
import za.co.bsv.util.eft.util.EFTFileUtil;
import za.co.bsv.util.eft.util.EFTTransactionBuilder;
import za.co.bsv.util.eft.util.TransactionSetBuilder;
import za.co.bsv.util.eft.util.UserDataSetBuilder;

/**
 *
 * @author Setumo Rankapole <setumor@bankservafrica.com>
 */
public class EFTTransformer implements za.co.bsv.bend.transformer.Transformer {
    
    @Override
    public byte [] transform(byte [] xmldoc, byte [] xsldoc) throws TransformerException {
        ByteArrayInputStream in = new ByteArrayInputStream(xmldoc);
        return transform(in, xsldoc);
    }
    
    @Override
    public byte[] transform(byte[] xmldoc, InputStream xsldoc) throws TransformerException {
        ByteArrayInputStream in = new ByteArrayInputStream(xmldoc);

        return transform(in, new byte[0]);
    }

    @Override
    public byte[] transform(InputStream xmldoc, InputStream xsldoc) throws TransformerException {
        return transform(xmldoc, new byte[0]);
    }
    
    @Override
    public byte[] transform(InputStream xmldoc, byte[] xsldoc) throws TransformerException {
        byte [] retval = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("za.co.bsv.bend.transformer.eft.xml");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            
            EftFile eftFileType = (EftFile)unmarshaller.unmarshal(xmldoc);
            
            InstallationType installation = eftFileType.getInstallationParameters();
            UserType userType = eftFileType.getUserParameters();
            
            EFTFileBuilder eftFB = new EFTFileBuilder();            
            eftFB.addInstallationHeader(installation.getFrom(), installation.getTo(), installation.getGenerationNumber(), installation.getTapeSerialNumber());
            
            
            TransactionSetBuilder tsBuilder = new TransactionSetBuilder(TransactionSetBuilder.TRANSACTION_SET_GROUP_TYPE  | TransactionSetBuilder.TRANSACTION_SET_GROUP_DST_ACC_NO,
                    userType.getSourceAccountName());
            
            for(TransactionType trns : eftFileType.getTransactions().getTransaction()) {
                tsBuilder.addTransaction(createEFTTransactionDTO(trns, userType.getShortName(), userType.getUserCode()));
            }
            UserDataSetBuilder udsBuilder = new UserDataSetBuilder(userType.getFirstSequenceNumber() - 1);
            
            udsBuilder.addUserHeader(userType.getUserCode(), userType.getGenerationNumber(),
                    EFTFileUtil.ensureLength(userType.getServiceType(), ' ', 10, EFTFileUtil.LEFT_JUSTIFY));

            List<TransactionSetDTO> trnsSet = tsBuilder.createTransactionSets();
            
            udsBuilder.addTransactionSets(trnsSet);
            UserDataSetDTO uds = udsBuilder.createUserDataSet();
            eftFB.addUserDataSet(uds);
            
            EFTFileDTO eftFile = eftFB.createEFTFile();

            //Replace date place holders with actual dates
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
            Calendar cal = GregorianCalendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, 1);

            String str = eftFile.toString();
            str = str.replaceAll("YYMMDD", sdf.format(new Date()));
            str = str.replaceAll("YYMMDT", sdf.format(cal.getTime()));
        
            retval = str.getBytes();
        }
        catch(Exception ex) {
            throw new TransformerException("Error transforming XML document to EFT, cause: " + ex.getMessage(), ex);
        }
        return retval;
    }

    private EFTTransactionDTO createEFTTransactionDTO(TransactionType transf, String shortName, int userCode) {
        EFTTransactionDTO retval = null;

        if("credit".equals(transf.getType())) {
            retval = EFTTransactionBuilder
                    .createCreditTransaction(transf.getSourceBranchCode(), transf.getSourceAccountNumber(),
                    userCode,transf.getDestinationBranchCode(), transf.getDestinationAccountNumber(),
                    Math.abs(transf.getAmount()), transf.getUserReference(), transf.getAccountName(), shortName);
        }
        else {
            retval = EFTTransactionBuilder
                    .createDebitTransaction(transf.getSourceBranchCode(), transf.getSourceAccountNumber(),
                    userCode,transf.getDestinationBranchCode(), transf.getDestinationAccountNumber(),
                    Math.abs(transf.getAmount()), transf.getUserReference(), transf.getAccountName(), shortName);
        }
        return retval;
    }
}