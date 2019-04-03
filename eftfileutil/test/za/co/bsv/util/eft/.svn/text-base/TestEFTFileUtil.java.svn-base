/**
 * ##########################################################################
 * # $Rev::                                    $: Revision of last commit   #
 * # $Author::                                 $: Author of last commit     #
 * # $Date::                                   $: Date of last commit       #
 * ##########################################################################
 */

package za.co.bsv.util.eft;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import za.co.bsv.util.eft.dto.EFTFileDTO;
import za.co.bsv.util.eft.dto.EFTTransactionDTO;
import za.co.bsv.util.eft.dto.TransactionSetDTO;
import za.co.bsv.util.eft.dto.UserDataSetDTO;
import za.co.bsv.util.eft.dto.UserHeaderDTO;

import za.co.bsv.util.eft.util.EFTFileBuilder;
import za.co.bsv.util.eft.util.EFTFileUtil;
import za.co.bsv.util.eft.util.EFTTransactionBuilder;
import za.co.bsv.util.eft.util.TransactionSetBuilder;
import za.co.bsv.util.eft.util.UserDataSetBuilder;
import za.co.bsv.util.eft.util.UserHeaderBuilder;

import static org.junit.Assert.*;

/**
 *
 * @author Bongani Hlope &lt;bonganih@bankserv.co.za&gt;
 */
public class TestEFTFileUtil {

    public TestEFTFileUtil() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreditTransaction() {
        EFTTransactionDTO trns = EFTTransactionBuilder.createCreditTransaction(632005, 1015320539, 9922, 666, 123456789, 5000, "PAYNETMTSGC1910092010", "South Gate", "PICKNPAY");

        String str = trns.toString();

        System.out.println(str);
        assertEquals(180, str.length());
    }

    @Test
    public void testDebitTransaction() {
        EFTTransactionDTO trns = EFTTransactionBuilder.createDebitTransaction(632005, 1015320539, 9922, 666, 123456789, 5000, "PAYNETMTSGC1910092010", "South Gate", "PICKNPAY");

        String str = trns.toString();

        System.out.println(str);
        assertEquals(180, str.length());
    }

    @Test
    public void testSingleTransactionSetType() {
        EFTTransactionDTO trns1 = EFTTransactionBuilder.createDebitTransaction(632005, 1015320539, 9922, 666, 123456789, 5000, "PAYNETMTSGC1910092010", "South Gate", "PICKNPAY");
        EFTTransactionDTO trns2 = EFTTransactionBuilder.createDebitTransaction(732005, 15320539, 9922, 12666, 23456789, 300, "PAYNETMTSGC1810092010", "Randparkridge", "PICKNPAY");

        TransactionSetBuilder tsBuilder = new TransactionSetBuilder(TransactionSetBuilder.TRANSACTION_SET_GROUP_TYPE, EFTFileUtil.ensureLength("PICKNPAY", ' ', 10, EFTFileUtil.LEFT_JUSTIFY) + "CONTROL");

        tsBuilder.addTransaction(trns1);
        tsBuilder.addTransaction(trns2);

        List<TransactionSetDTO> trnsSet = tsBuilder.createTransactionSets();

        for(TransactionSetDTO set : trnsSet) {
            System.out.println(set);
        }

        assertEquals(1, trnsSet.size());
    }

    @Test
    public void testTwoTansactionSetType() {
        EFTTransactionDTO trns1 = EFTTransactionBuilder.createCreditTransaction(632005, 1015320539, 9922, 666, 123456789, 5000, "PAYNETMTSGC1910092010", "South Gate", "PICKNPAY");
        EFTTransactionDTO trns2 = EFTTransactionBuilder.createDebitTransaction(632005, 1015320539, 9922, 666, 123456789, 5000, "PAYNETMTSGC1910092010", "South Gate", "PICKNPAY");

        TransactionSetBuilder tsBuilder = new TransactionSetBuilder(TransactionSetBuilder.TRANSACTION_SET_GROUP_TYPE, EFTFileUtil.ensureLength("PICKNPAY", ' ', 10, EFTFileUtil.LEFT_JUSTIFY) + "CONTROL");

        tsBuilder.addTransaction(trns1);
        tsBuilder.addTransaction(trns2);

        List<TransactionSetDTO> trnsSet = tsBuilder.createTransactionSets();

        for(TransactionSetDTO set : trnsSet) {
            System.out.println(set);
        }
        assertEquals(2, trnsSet.size());
    }

    @Test
    public void testTwoTansactionSetDestAcc() {
        EFTTransactionDTO trns1 = EFTTransactionBuilder.createDebitTransaction(632005, 1015320539, 9922, 666, 123456789, 5000, "PAYNETMTSGC1910092010", "South Gate", "PICKNPAY");
        EFTTransactionDTO trns2 = EFTTransactionBuilder.createDebitTransaction(732005, 15320539, 9922, 12666, 23456789, 300, "PAYNETMTSGC1810092010", "Randparkridge", "PICKNPAY");

        TransactionSetBuilder tsBuilder = new TransactionSetBuilder(TransactionSetBuilder.TRANSACTION_SET_GROUP_TYPE | TransactionSetBuilder.TRANSACTION_SET_GROUP_DST_ACC_NO, EFTFileUtil.ensureLength("PICKNPAY", ' ', 10, EFTFileUtil.LEFT_JUSTIFY) + "CONTROL");

        tsBuilder.addTransaction(trns1);
        tsBuilder.addTransaction(trns2);

        List<TransactionSetDTO> trnsSet = tsBuilder.createTransactionSets();

        for(TransactionSetDTO set : trnsSet) {
            System.out.println(set);
        }
        assertEquals(2, trnsSet.size());
    }

    @Test
    public void testUserDataSet() {
        int serviceCode = 9922;

        EFTTransactionDTO trns1 = EFTTransactionBuilder.createDebitTransaction(632005, 1015320539, serviceCode, 666, 123456789, 5000, "PAYNETMTSGC1910092010", "South Gate", "PICKNPAY");
        EFTTransactionDTO trns2 = EFTTransactionBuilder.createDebitTransaction(732005, 15320539, serviceCode, 12666, 23456789, 300, "PAYNETMTSGC1810092010", "Randparkridge", "PICKNPAY");

        TransactionSetBuilder tsBuilder = new TransactionSetBuilder(TransactionSetBuilder.TRANSACTION_SET_GROUP_TYPE, EFTFileUtil.ensureLength("PICKNPAY", ' ', 10, EFTFileUtil.LEFT_JUSTIFY) + "CONTROL");

        tsBuilder.addTransaction(trns1);
        tsBuilder.addTransaction(trns2);
        UserDataSetBuilder udsBuilder = new UserDataSetBuilder(0);

        List<TransactionSetDTO> trnsSet = tsBuilder.createTransactionSets();

        udsBuilder.addUserHeader(serviceCode, "TEST", "CORPSSV   ");
        udsBuilder.addTransactionSets(trnsSet);

        UserDataSetDTO uds = udsBuilder.createUserDataSet();

        System.out.println("\n\nUSER DATASET:");
        System.out.println(uds);
        assertTrue(true);
    }

    @Test
    public void testEFTFileBuilder() {
        int destinationIns = 21;
        int serviceCode = 9922;
        String generationNumber = "TEST";

        UserDataSetDTO uds = createDataSetOne(serviceCode, generationNumber);
        EFTFileBuilder eftFB = new EFTFileBuilder();

        eftFB.addInstallationHeader(serviceCode, destinationIns, generationNumber, "00PAYNET");
        eftFB.addUserDataSet(uds);

        EFTFileDTO eftFile = eftFB.createEFTFile();

        System.out.println("\n\nEFT FILE:");
        System.out.println(eftFile);
        assertTrue(true);
    }

    @Test
    public void testEFTFileBuilderComplex() {
        int destinationIns = 21;
        int serviceCode = 9922;
        String generationNumber = "TEST";

        UserDataSetDTO uds1 = createDataSetOne(serviceCode, generationNumber);
        UserDataSetDTO uds2 = createDataSetTwo(serviceCode, generationNumber);

        EFTFileBuilder eftFB = new EFTFileBuilder();

        eftFB.addInstallationHeader(serviceCode, destinationIns, generationNumber, "00PAYNET");
        eftFB.addUserDataSet(uds1);
        eftFB.addUserDataSet(uds2);

        EFTFileDTO eftFile = eftFB.createEFTFile();

        System.out.println("\n\nEFT FILE (Complex):");
        System.out.println(eftFile);
        assertTrue(true);
    }
    
    private UserDataSetDTO createDataSetOne(int serviceCode, String generationNumber) {
        UserDataSetDTO retval = null;

        EFTTransactionDTO trns1 = EFTTransactionBuilder.createDebitTransaction(632005, 1015320539, serviceCode, 666, 123456789, 5000, "PAYNETMTSGC1910092010", "South Gate", "PICKNPAY");
        EFTTransactionDTO trns2 = EFTTransactionBuilder.createDebitTransaction(732005, 15320539, serviceCode, 12666, 23456789, 300, "PAYNETMTSGC1810092010", "Randparkridge", "PICKNPAY");

        TransactionSetBuilder tsBuilder = new TransactionSetBuilder(TransactionSetBuilder.TRANSACTION_SET_GROUP_TYPE, EFTFileUtil.ensureLength("PICKNPAY", ' ', 10, EFTFileUtil.LEFT_JUSTIFY) + "CONTROL");

        tsBuilder.addTransaction(trns1);
        tsBuilder.addTransaction(trns2);
        UserDataSetBuilder udsBuilder = new UserDataSetBuilder(0);

        List<TransactionSetDTO> trnsSet = tsBuilder.createTransactionSets();

        udsBuilder.addUserHeader(serviceCode, generationNumber, "CORPSSV   ");
        udsBuilder.addTransactionSets(trnsSet);

        retval = udsBuilder.createUserDataSet();

        return retval;
    }

    private UserDataSetDTO createDataSetTwo(int serviceCode, String generationNumber) {
        UserDataSetDTO retval = null;

        EFTTransactionDTO trns1 = EFTTransactionBuilder.createCreditTransaction(532005, 115320539, serviceCode, 7666, 123456789, 15000, "PAYNETMTSGC1210092010", "Rosebank", "PICKNPAY");
        EFTTransactionDTO trns2 = EFTTransactionBuilder.createDebitTransaction(832005, 1320539, serviceCode, 82666, 23456789, 1300, "PAYNETMTSGC2110092010", "Secunda", "PICKNPAY");

        TransactionSetBuilder tsBuilder = new TransactionSetBuilder(TransactionSetBuilder.TRANSACTION_SET_GROUP_TYPE, EFTFileUtil.ensureLength("PICKNPAY", ' ', 10, EFTFileUtil.LEFT_JUSTIFY) + "CONTROL");

        tsBuilder.addTransaction(trns1);
        tsBuilder.addTransaction(trns2);
        UserDataSetBuilder udsBuilder = new UserDataSetBuilder(0);

        List<TransactionSetDTO> trnsSet = tsBuilder.createTransactionSets();

        udsBuilder.addUserHeader(serviceCode, generationNumber, "CORPSSV   ");
        udsBuilder.addTransactionSets(trnsSet);

        retval = udsBuilder.createUserDataSet();

        return retval;
    }

}