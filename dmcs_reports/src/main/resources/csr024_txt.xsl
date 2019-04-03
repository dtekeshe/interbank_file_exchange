<?xml version="1.0" encoding="UTF-8"?>
<x2f:stylesheet version="1.0" xmlns:x2f="http://www.bankservafrica.com/rm/x2f">
    <x2f:for-each select="reportContent">
        <x2f:max-lines-per-page select="50" />

        <x2f:template name="pageHeading">
            <x2f:record start="0">
                <x2f:value-of select="companyName" width="17" align="left"/>
                <x2f:text width="24" align="left">CSR003</x2f:text>
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
                <x2f:text width="20" align="left"> SUMMARY OF CCC INPUT</x2f:text>
            </x2f:record>
  
            <x2f:record start="0">
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

        </x2f:template>
  
        <x2f:page-break records="pageHeading" />
  
        <x2f:record start="0">
            <x2f:value-of select="companyName" width="17" align="left"/>
            <x2f:text width="24" align="left">CCR024</x2f:text>
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
            <x2f:text width="30" align="left">SUMMARY OF CCC INPUT</x2f:text>
        </x2f:record>
  
        <x2f:record start="0">
        </x2f:record>

        <x2f:record start="0">
        </x2f:record>

        <x2f:record start="0">
            <x2f:text width="10" align="left">SERVICE : </x2f:text>
            <x2f:value-of select="service" width="4" align="left" />
        </x2f:record>

        <x2f:record start="0">
        </x2f:record>	
  
        <x2f:template name="finalHead">
        </x2f:template>
    
        <x2f:for-each select="subServiceElement">
            <x2f:record start="0">
                <x2f:text width="14" align="left">SUB SERVICE : </x2f:text>
                <x2f:value-of select="/controlSubService" width="10" align="left" />
                <x2f:text width="20" align="left"> </x2f:text>
            </x2f:record>
  
            <x2f:record start="0">
            </x2f:record>	
            <x2f:record start="0">
                <x2f:text width="170" align="left">|------------------------------------------------------------------------------------------------------------------|</x2f:text>
            </x2f:record>
            <x2f:record start="0">
                <x2f:text width="170" align="left">                                                                                                                   </x2f:text>
            </x2f:record>
            <x2f:record start="0">
                <x2f:text width="170" align="left">| LOAD     | FILE NAME  | ACQ. NAME |  STATUS  | REJECTS  |   NUMBER    |     VALUE     |     NUMBER   |  NUMBER   |</x2f:text>      
            </x2f:record>
            <x2f:record start="0">
                <x2f:text width="170" align="left">| DATE     |            |           |          |          |    OF       |      OF       |      OF      |    OF     |</x2f:text>
            </x2f:record>
            <x2f:record start="0">
                <x2f:text width="170" align="left">|          |            |           |          |          | TRANSACTIONS|   TRANSACTIONS|    NEGATIVES | DUPLICATES|</x2f:text>       
            </x2f:record>
            <x2f:record start="0">
                <x2f:text width="170" align="left">|------------------------------------------------------------------------------------------------------------------|</x2f:text>
            </x2f:record> 
  
            <x2f:for-each select="inputControl">
                <x2f:record start="0">
                    |<x2f:value-of select="loaddate" width="8" align="center"/>
                    <x2f:text width="6" align="center"> |</x2f:text>
                    |<x2f:value-of select="filename" width="8" align="center" />
                    <x2f:text width="3" align="center"> |</x2f:text>
                    |<x2f:value-of select="acq_name" width="8" align="center"/>
                    <x2f:text width="6" align="center"> |</x2f:text>
                    |<x2f:value-of select="status" width="7" align="center" />
                    <x2f:text width="2" align="center"> |</x2f:text>
                    |<x2f:value-of select="rejects" width="8" align="center" />
                    <x2f:text width="4" align="center"> |</x2f:text>
                    |<x2f:value-of select="noOfTransactions" width="11" align="center" />
                    <x2f:text width="2" align="center"> |</x2f:text>
                    |<x2f:value-of select="valueOfTransactions" width="14" align="right" />
                    <x2f:text width="2" align="center"> |</x2f:text>
                    |<x2f:value-of select="numberOfNegatives" width="13" align="center" />
                    <x2f:text width="2" align="center"> |</x2f:text>
                    |<x2f:value-of select="numberOfDuplicates" width="10" align="center" />
                    <x2f:text width="2" align="center">|</x2f:text>
                </x2f:record>
            </x2f:for-each>	
	
            <x2f:record start="0">
            </x2f:record>	
  
            <x2f:record start="0">
                <x2f:text width="170" align="left">|------------------------------------------------------------------------------------------------------------------|</x2f:text>
            </x2f:record>
  
            <x2f:record start="0">
                <x2f:text width="18" align="left"> </x2f:text>
                <x2f:text width="22" align="left">* TOTALS RECEIVED:</x2f:text>
                <x2f:text width="21" align="left"> </x2f:text>
                <x2f:value-of select="subServiceFileTransTotal" width="8" align="center"> </x2f:value-of>  
                <x2f:text width="3" align="left"> </x2f:text>	
                <x2f:value-of select="subServiceFileTransValueTotal" width="15" align="right"> </x2f:value-of>	
            </x2f:record>	
        </x2f:for-each>
  
        <x2f:record start="0">
            <x2f:text width="170" align="left">|------------------------------------------------------------------------------------------------------------------|</x2f:text>
        </x2f:record>


        <x2f:record start="0">
        </x2f:record>
        <x2f:record start="0">
        </x2f:record>
        <x2f:record start="0">
        </x2f:record>
  
        <x2f:record start="0">
        </x2f:record>	
        <x2f:record start="0">
            <x2f:text width="170" align="left">|-----------------------------------------------------------------------------------------------------------------|</x2f:text>
        </x2f:record>
        <x2f:record start="0">
            <x2f:text width="170" align="left">|                                                                                                                 |</x2f:text>
        </x2f:record>
        <x2f:record start="0">
            <x2f:text width="170" align="left">|                     | NUMBER  |                  DEBITS                |              CREDITS                   |</x2f:text>      
        </x2f:record>
        <x2f:record start="0">
            <x2f:text width="170" align="left">|      TOTALS         |   OF    |---------------------------------------------------------------------------------|</x2f:text>
        </x2f:record>
        <x2f:record start="0">
            <x2f:text width="170" align="left">|                     |  FILES  |      VOLUME       |       VALUE        |      VOLUME       |       VALUE        |</x2f:text>       
        </x2f:record>
        <x2f:record start="0">
            <x2f:text width="170" align="left">|-----------------------------------------------------------------------------------------------------------------|</x2f:text>
        </x2f:record> 
  
  
  
        <x2f:for-each select="grandTotals">
            <x2f:record start="0">		
                <x2f:text width="1" align="left">|</x2f:text>
                <x2f:text width="28" align="left">RECEIVED             |</x2f:text>
                <x2f:value-of select="totalFileCount" width="3" align="left"/>
                <x2f:text width="1" align="left">|</x2f:text>
                <x2f:value-of select="debitsVolume" width="19" align="center" />
                <x2f:text width="1" align="center">|</x2f:text>
                <x2f:value-of select="debitsValue" width="20" align="center"/>
                <x2f:text width="1" align="center">|</x2f:text>
                <x2f:value-of select="creditsVolume" width="19" align="center" />
                <x2f:text width="1" align="center">|</x2f:text>
                <x2f:value-of select="creditsValue" width="20" align="center" />
                <x2f:text width="1" align="center">|</x2f:text>          
            </x2f:record>
        </x2f:for-each>	
		<x2f:record start="0">
            <x2f:text width="170" align="left">|-----------------------------------------------------------------------------------------------------------------|</x2f:text>
        </x2f:record> 

  
  	
        <x2f:record start="0">
        </x2f:record>

        <x2f:apply-templates select="finalHead" />
    </x2f:for-each>
</x2f:stylesheet>