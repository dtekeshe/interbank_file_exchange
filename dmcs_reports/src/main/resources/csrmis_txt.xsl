<?xml version="1.0" encoding="UTF-8"?>
<x2f:stylesheet version="1.0" xmlns:x2f="http://www.bankservafrica.com/rm/x2f">
<x2f:for-each select="csrmisRoot">
    
    <x2f:template name="compNameRepTemplate">
      <x2f:value-of select="companyReportName" width="60" align="left"/>
    </x2f:template>

    <x2f:record start="0">
      <x2f:value-of select="companyName" width="17" align="left"/>
      <x2f:text width="24" align="left">CSRMIS</x2f:text>
      <x2f:apply-templates select="compNameRepTemplate" />
      <x2f:value-of select="processDate" width="14" align="left"/>
      <x2f:text width="7" align="left">PAGE:-</x2f:text>
    </x2f:record>
      
    <x2f:record start="0">
    </x2f:record>
      

    <x2f:record start="0">
      <x2f:text width="50" align="left">  </x2f:text>
      <x2f:text width="8" align="left">REG.NO.  </x2f:text>
      <x2f:value-of select="CompanyRegNumber" width="20" align="right"/>
    </x2f:record>

    <x2f:record start="0">
    </x2f:record>

    <x2f:record start="0">
      <x2f:text width="132" align="center">**** INTERNAL ****                    MIS AND BANKSERV REVENUE CONTROL REPORT</x2f:text>
    </x2f:record>
    
    <x2f:record start="0">
    </x2f:record>

    <x2f:record start="0">
      <x2f:text width="45" align="left">          MONTH-TO-DATE ACCUMULATION AS AT  </x2f:text>
      <x2f:value-of select="processDate" width="20" align="right"/>
    </x2f:record>

    <x2f:record start="0">
    </x2f:record>
    
    <x2f:for-each select="dailySubServiceTotals">
      <x2f:for-each select="dailySubServiceTotal">
        <x2f:record start="0">
          <x2f:text width="22" align="left">          TOTALS FOR </x2f:text>
          <x2f:value-of select="subServProcessDate" width="8" align="right"/>
          <x2f:text width="1" align="left">  </x2f:text>
          <x2f:value-of select="subService" width="11" align="left"/>
          <x2f:text width="7" align="left"> VALUE </x2f:text>
          <x2f:value-of select="subServiceValue" width="17" align="right"/>
          <x2f:text width="7" align="left">VOLUME </x2f:text>
          <x2f:value-of select="subServiceVolume" width="10" align="right"/>
          <x2f:text width="22" align="left">(BALANCE TO CSR024)</x2f:text>
        </x2f:record>
        <x2f:record start="0">
        </x2f:record>
      </x2f:for-each>
    </x2f:for-each>

    <x2f:record start="0">
    </x2f:record>
    
    <x2f:record start="0">
    </x2f:record>

    <x2f:record start="0">
      <x2f:text width="43" align="left">                    SUMMARY OF SUB TOTALS</x2f:text>
    </x2f:record>

    <x2f:record start="0">
    </x2f:record>

    <x2f:record start="0">
    </x2f:record>

    <x2f:record start="0">
    </x2f:record>

    <x2f:record start="0">
      <x2f:text width="132" align="left">  MEMBER NAME                     SUB SERVICE  VOLUME      VALUE            BSV REVENUE VOLUME       VALUE              BSV REVENUE</x2f:text>
    </x2f:record>

    <x2f:record start="0">
      <x2f:text width="132" align="left">                                               BELOW       BELOW            BELOW       ABOVE        ABOVE              ABOVE</x2f:text>
    </x2f:record>

    <x2f:record start="0">
      <x2f:text width="132" align="left">  ------------------------------  -----------  -----------  --------------  ----------  -----------  -----------------  ------------</x2f:text>
    </x2f:record>

    <x2f:record start="0">
    </x2f:record>

    <x2f:for-each select="totalSummary">
      <x2f:for-each select="summaryDetail">
        <x2f:for-each select="summaryDetailLine">
          <x2f:record start="0">
            <x2f:text width="2" align="left"> </x2f:text>
            <x2f:value-of select="issuerName" width="30" align="left"/>
            <x2f:text width="2" align="left"> </x2f:text>
            <x2f:value-of select="subService" width="11" align="left"/>
            <x2f:text width="2" align="left"> </x2f:text>
            <x2f:value-of select="volumeBelow" width="12" align="right"/>
            <x2f:text width="2" align="left"> </x2f:text>
            <x2f:value-of select="valueBelow" width="14" align="right"/>
            <x2f:text width="2" align="left"> </x2f:text>
            <x2f:value-of select="chargeBelow" width="10" align="right"/>
            <x2f:text width="2" align="left"> </x2f:text>
            <x2f:value-of select="volumeAbove" width="11" align="right"/>
            <x2f:text width="2" align="left"> </x2f:text>
            <x2f:value-of select="valueAbove" width="17" align="right"/>
            <x2f:text width="2" align="left"> </x2f:text>
            <x2f:value-of select="chargeAbove" width="12" align="right"/>
          </x2f:record>        
          <x2f:record start="0">
          </x2f:record>
        </x2f:for-each>
      </x2f:for-each>
      <x2f:record start="0">
        <x2f:text width="132" align="left">  ------------------------------  -----------  -----------  --------------  ----------  -----------  -----------------  ------------</x2f:text>
      </x2f:record>
      <x2f:record start="0">
      </x2f:record>
      <x2f:for-each select="grandTotal">
        <x2f:record start="0">
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:text width="30" align="left">GRAND TOTAL</x2f:text>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:text width="11" align="left"> </x2f:text>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="grandTotalVolumeBelow" width="12" align="right"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="grandTotalValueBelow" width="14" align="right"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="grandTotalChargeBelow" width="10" align="right"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="grandTotalVolumeAbove" width="11" align="right"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="grandTotalValueAbove" width="17" align="right"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="grandTotalChargeAbove" width="12" align="right"/>
        </x2f:record>        
      </x2f:for-each>
      <x2f:record start="0">
      </x2f:record>
      <x2f:for-each select="totalOfTotals">
        <x2f:record start="0">
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:text width="30" align="left">TOTAL OF TOTALS</x2f:text>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:text width="11" align="left"> </x2f:text>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:text width="12" align="left"> </x2f:text>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:text width="14" align="left"> </x2f:text>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:text width="10" align="left"> </x2f:text>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="totalVolume" width="11" align="right"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="totalValue" width="17" align="right"/>
          <x2f:text width="2" align="left"> </x2f:text>
          <x2f:value-of select="totalCharge" width="12" align="right"/>
        </x2f:record>        
      </x2f:for-each>
    </x2f:for-each>
</x2f:for-each>
</x2f:stylesheet>