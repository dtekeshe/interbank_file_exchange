<?xml version="1.0" encoding="UTF-8"?>
<x2f:stylesheet version="1.0" xmlns:x2f="http://www.bankservafrica.com/rm/x2f">
<x2f:for-each select="toBank">
  <x2f:record start="0">
    <x2f:value-of select="companyName" width="17" align="left"/>
    <x2f:text width="8" align="left">CCR002</x2f:text>
    <x2f:value-of select="SubService" width="16" align="left" />
    <x2f:text width="58" align="left">SOUTH AFRICAN BANKERS SERVICES COMPANY LIMITED</x2f:text>
    <x2f:value-of select="processDate" width="14" align="left"/>
    <x2f:text width="7" align="left">PAGE:-</x2f:text>
    <x2f:built-in name="pageNumber" width="4" align="right">####</x2f:built-in>
  </x2f:record>
      
  <x2f:record start="0">
  </x2f:record>
      

  <x2f:record start="0">
    <x2f:text width="20" align="left">TAX INVOICE NUMBER: </x2f:text>
    <x2f:value-of select="invoiceNumber" width="8" align="right"/>
    <x2f:text width="22" align="left"> </x2f:text>
    <x2f:text width="8" align="left">REG.NO.  </x2f:text>
    <x2f:value-of select="CompanyRegNumber" width="20" align="right"/>
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="132" align="center">CREDIT CARD FEES AND TRANSACTION PROCESSING STATEMENT</x2f:text>
  </x2f:record>
  
  <x2f:record start="0">
    <x2f:text width="132" align="center">-----------------------------------------------------</x2f:text>
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="6" align="left">TO:-  </x2f:text>
    <x2f:value-of select="TO/contactName" width="30" align="left" />
    <x2f:text width="53" align="left"> </x2f:text>
    <x2f:text width="25" align="left">BILLING BRANCH NUMBER  : </x2f:text>
    <x2f:value-of select="TO/Branch" width="6" align="right" />
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="6" align="left"> </x2f:text>
    <x2f:value-of select="TO/Address1" width="30" align="left" />
    <x2f:text width="53" align="left"> </x2f:text>
    <x2f:text width="25" align="left">BILLING ACCOUNT NUMBER : </x2f:text>
    <x2f:value-of select="TO/AccountNo" width="11" align="left" />
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="6" align="left"> </x2f:text>
    <x2f:value-of select="TO/Address2" width="30" align="left" />
    <x2f:text width="53" align="left"> </x2f:text>
    <x2f:text width="13" align="left">VAT REG. NO. </x2f:text>
    <x2f:value-of select="TO/VatRegNo" width="10" align="right" />
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="6" align="left"> </x2f:text>
    <x2f:value-of select="TO/Address3" width="30" align="left" />
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="6" align="left"> </x2f:text>
    <x2f:value-of select="TO/Address4" width="30" align="left" />
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="16" align="left">INTERCHANGE FEES</x2f:text>
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="16" align="left">----------------</x2f:text>
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="11" align="left">INTERCHANGE</x2f:text>
    <x2f:text width="15" align="left"> </x2f:text>
    <x2f:text width="20" align="left">  INTERCHANGE FEES  </x2f:text>
    <x2f:text width="10" align="left"> </x2f:text>
    <x2f:text width="18" align="left"> INTERCHANGE FEES </x2f:text>
    <x2f:text width="8" align="left"> </x2f:text>
    <x2f:text width="20" align="left">NET INTERCHANGE FEES</x2f:text>
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="11" align="left">INSTITUTION</x2f:text>
    <x2f:text width="15" align="left"> </x2f:text>
    <x2f:text width="20" align="left">AS AN ACQUIRING BANK</x2f:text>
    <x2f:text width="10" align="left"> </x2f:text>
    <x2f:text width="18" align="left">AS AN ISSUING BANK</x2f:text>
    <x2f:text width="8" align="left"> </x2f:text>
    <x2f:text width="20" align="left">     DUE/PAYABLE    </x2f:text>
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:for-each select="reportContent">
    <x2f:for-each select="fromBank">
      <x2f:record start="0">
        <x2f:value-of select="fromBankName" width="30" align="left" />
        <x2f:text width="3" align="left"> </x2f:text>
        <x2f:value-of select="fromAcqFee" width="15" align="right" />
        <x2f:text width="11" align="left"> </x2f:text>
        <x2f:value-of select="fromIssFee" width="15" align="right" />
        <x2f:text width="14" align="left"> </x2f:text>
        <x2f:value-of select="fromNettFee" width="15" align="right" />
      </x2f:record>
    </x2f:for-each>
    <x2f:record start="0">
    </x2f:record>
    
    <x2f:record start="0">
    </x2f:record>

    <x2f:record start="0">
      <x2f:text width="88" align="left"> </x2f:text>
      <x2f:text width="14" align="left">==============</x2f:text>
    </x2f:record>

    <x2f:record start="0">
      <x2f:text width="50" align="left"> </x2f:text>
      <x2f:text width="34" align="left">TOTAL INTERCHANGE FEES DUE/PAYABLE</x2f:text>
      <x2f:text width="4" align="left"> </x2f:text>
      <x2f:value-of select="totalFee" width="15" align="right" />
    </x2f:record>

    <x2f:record start="0">
      <x2f:text width="88" align="left"> </x2f:text>
      <x2f:text width="14" align="left">==============</x2f:text>
    </x2f:record>    
  </x2f:for-each>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
  </x2f:record>

  <x2f:record start="0">
    <x2f:text width="49" align="left">THE ABOVE AMOUNT WILL BE DEBITED/CREDITED TO YOUR</x2f:text>
    <x2f:text width="18" align="left"> NOMINATED ACCOUNT</x2f:text>
  </x2f:record>

</x2f:for-each>
</x2f:stylesheet>