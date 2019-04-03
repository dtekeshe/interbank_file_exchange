<?xml version="1.0" encoding="UTF-8"?>
<x2f:stylesheet version="1.0" xmlns:x2f="http://www.bankservafrica.com/rm/x2f">
<x2f:for-each select="csrbinRoot">
<x2f:variable name="reportHead" select="BIN TABLE TOTALS FOR SYSTEM" />
<x2f:max-lines-per-page select="50" />

  <x2f:template name="compNameTemplate">
      <x2f:value-of select="companyName" width="17" align="left"/>
  </x2f:template>
  <x2f:template name="compNameRepTemplate">
      <x2f:value-of select="companyReportName" width="60" align="left"/>
  </x2f:template>
  <x2f:template name="compRegNoTemplate">
      <x2f:value-of select="CompanyRegNumber" width="20" align="right"/>
  </x2f:template>
  <x2f:template name="processDateTemplate">
      <x2f:value-of select="processDate" width="14" align="left"/>
  </x2f:template>
  <x2f:template name="siteNameTemplate">
      <x2f:value-of select="siteName" width="50" align="left"/>
  </x2f:template>
  
  <x2f:template name="reportHeading" start="0" use-this-root="true">
    <x2f:record name="compName" start="0">
      <x2f:apply-templates select="compNameTemplate" />
      <x2f:text width="24" align="left">CSRBIN</x2f:text>
      <x2f:apply-templates select="compNameRepTemplate" />
      <x2f:apply-templates select="processDateTemplate" />
      <x2f:text width="7" align="left">PAGE:-</x2f:text>
      <x2f:built-in name="pageNumber" width="4" align="right">####</x2f:built-in>
    </x2f:record>
    <x2f:record name="compRegNo" start="0">
      <x2f:text width="50" align="left">  </x2f:text>
      <x2f:text width="8" align="left">REG.NO.  </x2f:text>
      <x2f:apply-templates select="compRegNoTemplate" />
    </x2f:record>
    <x2f:record name="spaces" start="0">
    </x2f:record>
    <x2f:record name="siteNameRed" start="0">
      <x2f:apply-templates select="siteNameTemplate" />
      <x2f:text width="5" align="left"> </x2f:text>
      <x2f:value-of select="reportHead" width="50" align="left" />
    </x2f:record>
  </x2f:template>


    <x2f:apply-templates select="reportHeading" />
  
    <x2f:record start="0">
      <x2f:text width="10" align="left"> </x2f:text>
      <x2f:text width="60" align="left">TOTAL NUMBER OF BINS</x2f:text>
      <x2f:value-of select="csrbinTotals/totalNumberOfBins" width="10" align="right"/>
    </x2f:record>
    <x2f:record start="0">
      <x2f:text width="10" align="left"> </x2f:text>
      <x2f:text width="60" align="left">NUMBER OF BINS DELETED </x2f:text>
      <x2f:value-of select="csrbinTotals/numberOfBinsDeleted" width="10" align="right"/>
    </x2f:record>
    <x2f:record start="0">
      <x2f:text width="10" align="left"> </x2f:text>
      <x2f:text width="60" align="left">NUMBER OF BINS IN DELETION CYCLE</x2f:text>
      <x2f:value-of select="csrbinTotals/numberOfBinsInDeleteCycle" width="10" align="right"/>
    </x2f:record>
    <x2f:record start="0">
      <x2f:text width="10" align="left"> </x2f:text>
      <x2f:text width="60" align="left">NUMBER OF SET FOR DELETION </x2f:text>
      <x2f:value-of select="csrbinTotals/numberOfBinsSetForDelete" width="10" align="right"/>
    </x2f:record>
    <x2f:record start="0">
      <x2f:text width="10" align="left"> </x2f:text>
      <x2f:text width="60" align="left">NUMBER OF ACTIVE BINS</x2f:text>
      <x2f:value-of select="csrbinTotals/numberOfBinsActive" width="10" align="right"/>
    </x2f:record>


<x2f:variable name="reportHead" select="LIST OF BINS AND ASSOCIATED AUDIT TRAIL" />

<x2f:template name="changeCompNameToBankLevelTemplate">
  <x2f:template name="compNameTemplate">
      <x2f:value-of select="../../companyName" width="17" align="left"/>
  </x2f:template>
  <x2f:template name="compNameRepTemplate">
      <x2f:value-of select="../../companyReportName" width="60" align="left"/>
  </x2f:template>
  <x2f:template name="compRegNoTemplate">
      <x2f:value-of select="../../CompanyRegNumber" width="20" align="right"/>
  </x2f:template>
  <x2f:template name="processDateTemplate">
      <x2f:value-of select="../../processDate" width="14" align="left"/>
  </x2f:template>
  <x2f:template name="siteNameTemplate">
      <x2f:value-of select="../../siteName" width="50" align="left"/>
  </x2f:template>
</x2f:template>

<x2f:template name="changeCompNameToBinLevelTemplate">
  <x2f:template name="compNameTemplate">
      <x2f:value-of select="../../../companyName" width="17" align="left"/>
  </x2f:template>
  <x2f:template name="compNameRepTemplate">
      <x2f:value-of select="../../../companyReportName" width="60" align="left"/>
  </x2f:template>
  <x2f:template name="compRegNoTemplate">
      <x2f:value-of select="../../../CompanyRegNumber" width="20" align="right"/>
  </x2f:template>
  <x2f:template name="processDateTemplate">
      <x2f:value-of select="../../../processDate" width="14" align="left"/>
  </x2f:template>
  <x2f:template name="siteNameTemplate">
      <x2f:value-of select="../../../siteName" width="50" align="left"/>
  </x2f:template>
</x2f:template>

    <x2f:template name="binDetailHead" start="0">
      <x2f:record start="0">
        <x2f:text width="3" align="left"> </x2f:text>
        <x2f:text width="6" align="left">BIN NO</x2f:text>
        <x2f:text width="2" align="left"> </x2f:text>
        <x2f:text width="25" align="left">BIN DESCRIPTION</x2f:text>
        <x2f:text width="2" align="left"> </x2f:text>
        <x2f:text width="7" align="left">CARD NO</x2f:text>
        <x2f:text width="2" align="left"> </x2f:text>
        <x2f:text width="20" align="left">CARD DESCRIPTION</x2f:text>
        <x2f:text width="2" align="left"> </x2f:text>
        <x2f:text width="8" align="left">DEL DATE</x2f:text>
        <x2f:text width="2" align="left"> </x2f:text>
        <x2f:text width="11" align="right">LIMIT 1</x2f:text>
        <x2f:text width="2" align="left"> </x2f:text>
        <x2f:text width="11" align="right">LIMIT 2</x2f:text>
        <x2f:text width="2" align="left"> </x2f:text>
        <x2f:text width="11" align="right">FLOOR LIMIT</x2f:text>
        <x2f:text width="2" align="left"> </x2f:text>
        <x2f:text width="12" align="left">ISS/ACQ/BOTH</x2f:text>
      </x2f:record>
    </x2f:template>


<x2f:template name="pageHeader" >
    <x2f:apply-templates select="reportHeading"/>
    <x2f:record start="0">
    </x2f:record>
    <x2f:apply-templates select="bankNameHead" />
    <x2f:record start="0">
    </x2f:record>
    <x2f:apply-templates select="binDetailHead" />
</x2f:template>

<x2f:template name="bankBinDetTemplate">
      <x2f:template name="bankNameTemplate">
        <x2f:value-of select="bankName" width="30" align="left"/>
      </x2f:template>
      <x2f:template name="monthTilDelTemplate">
          <x2f:value-of select="monthsUntilDeletion" width="2" align="right"/>
      </x2f:template>
</x2f:template>

<x2f:template name="binDetTemplate">
      <x2f:template name="bankNameTemplate">
        <x2f:value-of select="../bankName" width="30" align="left"/>
      </x2f:template>
      <x2f:template name="monthTilDelTemplate">
          <x2f:value-of select="../monthsUntilDeletion" width="2" align="right"/>
      </x2f:template>
</x2f:template>

<x2f:for-each select="binReport">
    <x2f:template name="bankNameHead" start="0">
      <x2f:record start="0">
        <x2f:apply-templates select="bankNameTemplate" />
        <x2f:text width="5" align="left"> </x2f:text>
        <x2f:apply-templates select="monthTilDelTemplate" />
        <x2f:text width="1" align="left"> </x2f:text>
        <x2f:text width="50" align="left">MONTH(S) BETWEEN FIRST AND FINAL DELETION DATES</x2f:text>
      </x2f:record>
    </x2f:template>

    <x2f:page-break records="pageHeader" />
    
  <x2f:for-each select="bankBinDetails"  >
      <x2f:apply-templates select="bankBinDetTemplate" />
      <x2f:apply-templates select="changeCompNameToBankLevelTemplate" />
      <x2f:apply-templates select="pageHeader" page-break-before="yes"/>
      <x2f:apply-templates select="binDetTemplate" />        
      <x2f:apply-templates select="changeCompNameToBinLevelTemplate" />
      <x2f:for-each select="binDetails">
        <x2f:record start="0">
          <x2f:text width="3" align="left"> </x2f:text>
          <x2f:value-of select="binNumber" width="6" align="left"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="binDescription" width="25" align="left"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="binCardType" width="7" align="center"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="binCardDescription" width="20" align="left"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="binDeletionDate" width="8" align="right"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="binLimit1" width="11" align="right"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="binLimit2" width="11" align="right"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="binFloorLimit" width="11" align="right"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="binIssuerAcquirerBoth" width="12" align="left"/>
        </x2f:record>
      </x2f:for-each>
    </x2f:for-each>
</x2f:for-each>
</x2f:for-each>
</x2f:stylesheet>