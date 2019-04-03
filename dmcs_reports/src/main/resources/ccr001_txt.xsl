<?xml version="1.0" ?>
<x2f:stylesheet xmlns:x2f="http://www.bankservafrica.com/rm/x2f">
  <x2f:for-each select="ToBank">
  
    <x2f:template name="compNameHeadTemplate">
      <x2f:record name="compName" start="0">
        <x2f:value-of select="../../companyName" width="17" align="left"/>
        <x2f:text width="24" align="left">CCR001</x2f:text>
        <x2f:text width="58" align="left">SOUTH AFRICAN BANKERS SERVICES COMPANY LIMITED</x2f:text>
        <x2f:value-of select="../../processDate" width="14" align="left"/>
        <x2f:text width="7" align="left">PAGE:-</x2f:text>
        <x2f:built-in name="pageNumber" width="4" align="right">####</x2f:built-in>
      </x2f:record>
      <x2f:record start="0">
        <x2f:text width="20" align="left">TAX INVOICE NUMBER: </x2f:text>
        <x2f:value-of select="../../invoiceNumber" width="8" align="left"/>
        <x2f:text width="22" align="left"> </x2f:text>
        <x2f:text width="8" align="left">REG.NO.  </x2f:text>
        <x2f:value-of select="../../CompanyRegNumber" width="20" align="left"/>
      </x2f:record>
    </x2f:template>

    <x2f:template name="pageHead">
      <x2f:apply-templates select="compNameHeadTemplate" />

      <x2f:record name="spaces" start="0">
      </x2f:record>
      <x2f:record start="0">
      </x2f:record>
      <x2f:record start="0">
        <x2f:text width="5" align="left"> </x2f:text>
        <x2f:apply-templates select="cardNameTemplate" />
        <x2f:text width="5" align="left"> </x2f:text>
        <x2f:text width="67" align="left">C R E D I T   C A R D   F E E   C A L C U L A T I O N   R E P O R T</x2f:text>
      </x2f:record>
      <x2f:record start="0">
      </x2f:record>
  
      <x2f:record start="0">
        <x2f:text width="3" align="left"> </x2f:text>
        <x2f:text width="104" align="left">---------------------------------------------------------------------------------------------------------</x2f:text>
      </x2f:record>

      <x2f:record start="0">
      </x2f:record>

      <x2f:apply-templates select="addressHeadingTemplate" />

      <x2f:record start="0">
      </x2f:record>

      <x2f:record start="0">
      </x2f:record>

      <x2f:record start="0">
        <x2f:text width="20" align="left"> </x2f:text>
        <x2f:text width="34" align="left">COUNT           AMOUNT        ITEM</x2f:text>
        <x2f:text width="15" align="left">  RE-IMBURSMENT</x2f:text>
        <x2f:text width="44" align="left">        INPUT       OUTPUT             TOTAL</x2f:text>
        <x2f:text width="14" align="left"> </x2f:text>
        <x2f:text width="4" align="left">NETT</x2f:text>
      </x2f:record>

      <x2f:record start="0">
        <x2f:text width="47" align="left"> </x2f:text>
        <x2f:text width="7" align="left">CHARGES</x2f:text>
        <x2f:text width="25" align="left"> </x2f:text>
        <x2f:text width="3" align="left">VAT</x2f:text>
        <x2f:text width="10" align="left"> </x2f:text>
        <x2f:text width="3" align="left">VAT</x2f:text>
        <x2f:text width="11" align="left"> </x2f:text>
        <x2f:text width="7" align="left">CHARGES</x2f:text>
        <x2f:text width="12" align="left"> </x2f:text>
        <x2f:text width="6" align="left">AMOUNT</x2f:text>
      </x2f:record>
    </x2f:template>
    
    <x2f:template name="addressHeadingTemplate">
      <x2f:record start="0">
        <x2f:text width="6" align="left">TO:-</x2f:text>
        <x2f:value-of select="../../TO/contactName" width="30" align="left"/>
        <x2f:text width="30" align="left"> </x2f:text>
        <x2f:text width="8" align="left">FROM:-</x2f:text>
        <x2f:value-of select="../FROM/contactName" width="30" align="left"/>
      </x2f:record>

      <x2f:record start="0">
        <x2f:text width="6" align="left"> </x2f:text>
        <x2f:value-of select="../../TO/Address1" width="30" align="left"/>
        <x2f:text width="30" align="left"> </x2f:text>
        <x2f:text width="8" align="left"> </x2f:text>
        <x2f:value-of select="../FROM/Address1" width="30" align="left"/>
      </x2f:record>

      <x2f:record start="0">
        <x2f:text width="6" align="left"> </x2f:text>
        <x2f:value-of select="../../TO/Address2" width="30" align="left"/>
        <x2f:text width="30" align="left"> </x2f:text>
        <x2f:text width="8" align="left"> </x2f:text>
        <x2f:value-of select="../FROM/Address2" width="30" align="left"/>
      </x2f:record>

      <x2f:record start="0">
        <x2f:text width="6" align="left"> </x2f:text>
        <x2f:value-of select="../../TO/Address3" width="30" align="left"/>
        <x2f:text width="30" align="left"> </x2f:text>
        <x2f:text width="8" align="left"> </x2f:text>
        <x2f:value-of select="../FROM/Address3" width="30" align="left"/>
      </x2f:record>

      <x2f:record start="0">
        <x2f:text width="6" align="left"> </x2f:text>
        <x2f:value-of select="../../TO/Address4" width="30" align="left"/>
        <x2f:text width="30" align="left"> </x2f:text>
        <x2f:text width="8" align="left"> </x2f:text>
        <x2f:value-of select="../FROM/Address4" width="30" align="left"/>
      </x2f:record>

      <x2f:record start="0">
      </x2f:record>

      <x2f:record start="0">
        <x2f:text width="6" align="left"> </x2f:text>
        <x2f:text width="13" align="left">VAT REG. NO. </x2f:text>
        <x2f:value-of select="../../TO/VatRegNo" width="10" align="left"/>
        <x2f:text width="45" align="left"> </x2f:text>
        <x2f:text width="13" align="left">VAT REG. NO. </x2f:text>
        <x2f:value-of select="../FROM/VatRegNo" width="10" align="left"/>
      </x2f:record>
    </x2f:template>

    <x2f:template name="changeCompHeandingTemplate">
        <x2f:template name="compNameHeadTemplate">
          <x2f:record name="compName" start="0">
            <x2f:value-of select="../companyName" width="17" align="left"/>
            <x2f:text width="24" align="left">CCR001</x2f:text>
            <x2f:text width="58" align="left">SOUTH AFRICAN BANKERS SERVICES COMPANY LIMITED</x2f:text>
            <x2f:value-of select="../processDate" width="14" align="left"/>
            <x2f:text width="7" align="left">PAGE:-</x2f:text>
            <x2f:built-in name="pageNumber" width="4" align="right">####</x2f:built-in>
          </x2f:record>
          <x2f:record start="0">
            <x2f:text width="20" align="left">TAX INVOICE NUMBER: </x2f:text>
            <x2f:value-of select="../invoiceNumber" width="8" align="left"/>
            <x2f:text width="22" align="left"> </x2f:text>
            <x2f:text width="8" align="left">REG.NO.  </x2f:text>
            <x2f:value-of select="../CompanyRegNumber" width="20" align="left"/>
          </x2f:record>
        </x2f:template>    
    </x2f:template>
    
    <x2f:template name="changeAddressHeadingTemplate">
      <x2f:template name="addressHeadingTemplate">
        <x2f:record start="0">
          <x2f:text width="6" align="left">TO:-</x2f:text>
          <x2f:value-of select="../TO/contactName" width="30" align="left"/>
        </x2f:record>

        <x2f:record start="0">
          <x2f:text width="6" align="left"> </x2f:text>
          <x2f:value-of select="../TO/Address1" width="30" align="left"/>
        </x2f:record>

        <x2f:record start="0">
          <x2f:text width="6" align="left"> </x2f:text>
          <x2f:value-of select="../TO/Address2" width="30" align="left"/>
        </x2f:record>

        <x2f:record start="0">
          <x2f:text width="6" align="left"> </x2f:text>
          <x2f:value-of select="../TO/Address3" width="30" align="left"/>
        </x2f:record>

        <x2f:record start="0">
          <x2f:text width="6" align="left"> </x2f:text>
          <x2f:value-of select="../TO/Address4" width="30" align="left"/>
        </x2f:record>

        <x2f:record start="0">
        </x2f:record>

        <x2f:record start="0">
          <x2f:text width="6" align="left"> </x2f:text>
          <x2f:text width="13" align="left">VAT REG. NO. </x2f:text>
          <x2f:value-of select="../TO/VatRegNo" width="10" align="left"/>
        </x2f:record>
      </x2f:template>
    </x2f:template>

    <x2f:template name="transDetails">
          <x2f:record start="0">
            <x2f:apply-templates select="descTem" />
            <x2f:text width="1" align="left"> </x2f:text>
            <x2f:value-of select="Volume" width="9" align="right"/>
            <x2f:text width="1" align="left"> </x2f:text>
            <x2f:value-of select="Value" width="17" align="right"/>
            <x2f:text width="1" align="left"> </x2f:text>
            <x2f:value-of select="BillingFee" width="11" align="right"/>
            <x2f:text width="1" align="left"> </x2f:text>
            <x2f:value-of select="AdvolarumFee" width="13" align="right"/>
            <x2f:text width="1" align="left"> </x2f:text>
            <x2f:value-of select="BillingVat" width="12" align="right"/>
            <x2f:text width="1" align="left"> </x2f:text>
            <x2f:text width="12" align="left"> </x2f:text>
            <x2f:value-of select="TotalCharges" width="17" align="right"/>
            <x2f:text width="1" align="left"> </x2f:text>
            <x2f:value-of select="NettAmount" width="17" align="right"/>
          </x2f:record>
    </x2f:template>
    
    <x2f:template name="reportContentTemplate">
        <x2f:apply-templates select="startPage" />
                
        <x2f:for-each select="reportContent">
          <x2f:for-each select="transactionGroup">
            
            <x2f:for-each select="TXTYPE">

              <x2f:template name="descTem">
                <x2f:value-of select="Description" width="15" align="left"/>
              </x2f:template>

              <x2f:apply-templates select="transDetails" />

            </x2f:for-each>  
            <x2f:record start="0">
              <x2f:text width="16" align="left"> </x2f:text>
              <x2f:text width="42" align="left"> --------- ----------------  ----------   </x2f:text>
              <x2f:text width="40" align="left">------------  -----------  -----------  </x2f:text>
              <x2f:text width="16" align="left">----------------</x2f:text>
              <x2f:text width="2" align="left"> </x2f:text>
              <x2f:text width="16" align="left">----------------</x2f:text>
            </x2f:record>
            
            <x2f:for-each select="SUBTOTALS">

              <x2f:template name="descTem">
                <x2f:text width="15" align="left">SUB TOTALS</x2f:text>
              </x2f:template>

              <x2f:apply-templates select="transDetails" />

            </x2f:for-each>
            <x2f:record start="0">
            </x2f:record>
          </x2f:for-each>
          
          <x2f:for-each select="GRANDTOTALS">

              <x2f:template name="descTem">
                <x2f:text width="15" align="left">GRAND TOTALS</x2f:text>
              </x2f:template>

            <x2f:apply-templates select="transDetails" />
          </x2f:for-each>
        </x2f:for-each>
    </x2f:template>
    
    <x2f:template name="cardNameTemplate">
      <x2f:value-of select="CARDTYPEDESC" width="30" align="left"/>
    </x2f:template>
  
    
    
    <x2f:template name="startPage">
      <x2f:apply-templates select="pageHead" />
    </x2f:template>
    <x2f:for-each select="FromBank" >
    
      
      <x2f:for-each select="CardType">
      
        <x2f:apply-templates select="reportContentTemplate" />
              <x2f:template name="startPage">
                <x2f:apply-templates select="pageHead" page-break-before=""/>
              </x2f:template>

      </x2f:for-each>
    </x2f:for-each>
    <x2f:template name="cardNameTemplate">
      <x2f:text width="30" align="left">F I N A L   T O T A L S</x2f:text>
    </x2f:template>
    <x2f:apply-templates select="changeAddressHeadingTemplate" />
    <x2f:apply-templates select="changeCompHeandingTemplate" />
      <x2f:for-each select="FinalTotalsPage">
        <x2f:apply-templates select="reportContentTemplate" />
      </x2f:for-each>
  </x2f:for-each>
      
    
</x2f:stylesheet>

