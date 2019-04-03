<?xml version="1.0" encoding="UTF-8"?>
<x2f:stylesheet version="1.0" xmlns:x2f="http://www.bankservafrica.com/rm/x2f">
<x2f:for-each select="reportContent">
<x2f:max-lines-per-page select="50" />

  <x2f:template name="pageHeading">
  <x2f:record start="0">
    <x2f:value-of select="companyName" width="17" align="left"/>
    <x2f:text width="24" align="left">CSR023</x2f:text>
    <x2f:value-of select="../../paystream" width="1" align="left"/>
    <x2f:text width="58" align="left">SOUTH AFRICAN BANKERS SERVICES COMPANY LIMITED</x2f:text>
    <x2f:value-of select="../processDate" width="14" align="left"/>
    <x2f:text width="7" align="left">PAGE:-</x2f:text>
    <x2f:built-in name="pageNumber" width="4" align="right">####</x2f:built-in>
  </x2f:record>
      
  <x2f:record start="0">
  </x2f:record>
      
  <x2f:record start="0">
    <x2f:text width="35" align="left"> </x2f:text>
    <x2f:text width="8" align="left">REG.NO.  </x2f:text>
    <x2f:value-of select="../CompanyRegNumber" width="20" align="right"/>
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="35" align="left"> </x2f:text>
    <x2f:value-of select="../subService" width="10" align="right" />
    <x2f:text width="11" align="left"> VET REPORT</x2f:text>
  </x2f:record>
  
  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="21" align="left">BSV. FILE REFERENCE:</x2f:text>
    <x2f:value-of select="../bsvFileName" width="8" align="left"/>
    <x2f:text width="14" align="left"> </x2f:text>
    <x2f:text width="20" align="left">***  REJECTIONS  ***</x2f:text>
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="21" align="left">ACQ. FILE REFERENCE:</x2f:text>
    <x2f:value-of select="../bsvFileName" width="8" align="left"/>
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="10" align="left">SERVICE : </x2f:text>
    <x2f:value-of select="../service" width="4" align="left" />
    <x2f:text width="20" align="left"> </x2f:text>
    <x2f:text width="14" align="left">SUB SERVICE : </x2f:text>
    <x2f:value-of select="../subService" width="10" align="left" />
  </x2f:record>
  
  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="132" align="left">REC ID  REC SEQ  REJ NO  ERROR DESCRIPTION                         FIELD CONTENTS</x2f:text>
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="132" align="left">-----   -------  ------  ----------------                          --------------</x2f:text>
  </x2f:record>
  </x2f:template>
  
  <x2f:page-break records="pageHeading" />
  
  <x2f:record start="0">
    <x2f:value-of select="companyName" width="17" align="left"/>
    <x2f:text width="24" align="left">CSR023</x2f:text>
    <x2f:value-of select="paystream" width="1" align="left"/>
    <x2f:text width="58" align="left">SOUTH AFRICAN BANKERS SERVICES COMPANY LIMITED</x2f:text>
    <x2f:value-of select="processDate" width="14" align="left"/>
    <x2f:text width="7" align="left">PAGE:-</x2f:text>
    <x2f:built-in name="pageNumber" width="4" align="right">####</x2f:built-in>
  </x2f:record>
      
  <x2f:record start="0">
  </x2f:record>
      
  <x2f:record start="0">
    <x2f:text width="35" align="left"> </x2f:text>
    <x2f:text width="8" align="left">REG.NO.  </x2f:text>
    <x2f:value-of select="CompanyRegNumber" width="20" align="right"/>
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="35" align="left"> </x2f:text>
    <x2f:value-of select="subService" width="10" align="right" />
    <x2f:text width="11" align="left"> VET REPORT</x2f:text>
  </x2f:record>
  
  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="21" align="left">BSV. FILE REFERENCE:</x2f:text>
    <x2f:value-of select="bsvFileName" width="8" align="left"/>
    <x2f:text width="14" align="left"> </x2f:text>
    <x2f:text width="20" align="left">***  REJECTIONS  ***</x2f:text>
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="21" align="left">ACQ. FILE REFERENCE:</x2f:text>
    <x2f:value-of select="bsvFileName" width="8" align="left"/>
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="10" align="left">SERVICE : </x2f:text>
    <x2f:value-of select="service" width="4" align="left" />
    <x2f:text width="20" align="left"> </x2f:text>
    <x2f:text width="14" align="left">SUB SERVICE : </x2f:text>
    <x2f:value-of select="subService" width="10" align="left" />
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="132" align="left">REC ID  REC SEQ  REJ NO  ERROR DESCRIPTION                         FIELD CONTENTS</x2f:text>
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="132" align="left">-----   -------  ------  ----------------                          --------------</x2f:text>
  </x2f:record>
  
  <x2f:template name="finalHead">
      <x2f:record start="0">
        <x2f:text width="37" align="left"> </x2f:text>
        <x2f:text width="30" align="left">VOLUME                 VALUE</x2f:text>
      </x2f:record>
      <x2f:record start="0">
      </x2f:record>
  </x2f:template>
  
  <x2f:for-each select="fileRejections">
    <x2f:for-each select="error">
        <x2f:record start="0">
          <x2f:value-of select="errorRecordId" width="6" align="left"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="errorRecordNo" width="6" align="left" />
          <x2f:text width="3" align="left"> </x2f:text>
          <x2f:value-of select="errorRejNo" width="6" align="left"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="errorDescription" width="40" align="left" />
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="fieldContent" width="60" align="left" />
        </x2f:record>
    </x2f:for-each>

    <x2f:record start="0">
    </x2f:record>

    <x2f:record start="0">
      <x2f:value-of select="../reportMessage" width="60" align="left" />
    </x2f:record>

    <x2f:record start="0">
    </x2f:record>

    <x2f:template name="finalHead">
        <x2f:record start="0" page-break-before="true">
          <x2f:text width="37" align="left"> </x2f:text>
          <x2f:text width="30" align="left">VOLUME                 VALUE</x2f:text>
        </x2f:record>
        <x2f:record start="0">
        </x2f:record>
    </x2f:template>

  </x2f:for-each>
 
  <x2f:apply-templates select="finalHead" />

  <x2f:record start="0">
    <x2f:text width="26" align="left">TOTAL ACCEPTED - DEBITS_:</x2f:text>
    <x2f:text width="4" align="left"> </x2f:text>
    <x2f:value-of select="totAccDrVol" width="13" align="right"> </x2f:value-of>
    <x2f:text width="4" align="left"> </x2f:text>
    <x2f:value-of select="totAccDrVal" width="18" align="right"> </x2f:value-of>
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="26" align="left">                 CREDITS:</x2f:text>
    <x2f:text width="4" align="left"> </x2f:text>
    <x2f:value-of select="totAccCrVol" width="13" align="right"> </x2f:value-of>
    <x2f:text width="4" align="left"> </x2f:text>
    <x2f:value-of select="totAccCrVal" width="18" align="right"> </x2f:value-of>
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="26" align="left">TOTAL REJECTED - DEBITS_:</x2f:text>
    <x2f:text width="4" align="left"> </x2f:text>
    <x2f:value-of select="totRejDrVol" width="13" align="right"> </x2f:value-of>
    <x2f:text width="4" align="left"> </x2f:text>
    <x2f:value-of select="totRejDrVal" width="18" align="right"> </x2f:value-of>
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="26" align="left">                 CREDITS:</x2f:text>
    <x2f:text width="4" align="left"> </x2f:text>
    <x2f:value-of select="totRejCrVol" width="13" align="right"> </x2f:value-of>
    <x2f:text width="4" align="left"> </x2f:text>
    <x2f:value-of select="totRejCrVal" width="18" align="right"> </x2f:value-of>
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="46" align="left"> </x2f:text>
    <x2f:text width="30" align="left">ACCEPTED         REJECTED</x2f:text>
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="2" align="left"> </x2f:text>
    <x2f:text width="38" align="left">TOTAL NUMBER OF FINANCIAL RECORDS____:</x2f:text>
    <x2f:text width="1" align="left"> </x2f:text>
    <x2f:value-of select="totAccFinRecs" width="13" align="right"> </x2f:value-of>
    <x2f:text width="4" align="left"> </x2f:text>
    <x2f:value-of select="totRejFinRecs" width="13" align="right"> </x2f:value-of>
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="18" align="left"> </x2f:text>
    <x2f:text width="22" align="left">NON FINANCIAL RECORDS:</x2f:text>
    <x2f:text width="1" align="left"> </x2f:text>
    <x2f:value-of select="totAccNonFinRecs" width="13" align="right"> </x2f:value-of>
    <x2f:text width="4" align="left"> </x2f:text>
    <x2f:value-of select="totRejNonFinRecs" width="13" align="right"> </x2f:value-of>
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="18" align="left"> </x2f:text>
    <x2f:text width="22" align="left">NEGATIVE CARD RECORDS:</x2f:text>
    <x2f:text width="1" align="left"> </x2f:text>
    <x2f:value-of select="totNegativeRecords" width="13" align="right"> </x2f:value-of>
    <x2f:text width="4" align="left"> </x2f:text>
    <x2f:text width="13" align="right">0</x2f:text>
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="18" align="left"> </x2f:text>
    <x2f:text width="22" align="left">CONTROL RECORDS______:</x2f:text>
    <x2f:text width="1" align="left"> </x2f:text>
    <x2f:value-of select="totControlRecords" width="13" align="right"> </x2f:value-of>
    <x2f:text width="4" align="left"> </x2f:text>
    <x2f:text width="13" align="right">0</x2f:text>
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="18" align="left"> </x2f:text>
    <x2f:text width="22" align="left">* TOTAL RECORDS______:</x2f:text>
    <x2f:text width="1" align="left"> </x2f:text>
    <x2f:value-of select="totAcceptedRecs" width="13" align="right"> </x2f:value-of>
    <x2f:text width="4" align="left"> </x2f:text>
    <x2f:value-of select="totRejectedRecs" width="13" align="right"> </x2f:value-of>
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>


</x2f:for-each>
</x2f:stylesheet>