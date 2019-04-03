package com.bsva.dmcs.file.reports;

public class CCR420TransReportsDto {
	
	private String bank;
	private String reportName;
	private String time;
	private String companyName;
	private String date;
	private String page;
	private String regNumber;
	private String internal;
	private String transDistReport;
	private String transCarriedForwardDate;
	private String debit;
	private String credit;
	private String service;
	private String subService;
	private String type;
	private String code;
	private String volume;
	private String values;

	private String serviceName;
	private String subServiceName;
	private String typeName;
	private String codeName;
	private String volumeName;
	private String valuesName;

	private String totalsName;
	private String totalsVolumes;
	private String totalsValues;
	
	private String authorizedBy;
	private String authorizedByLine;
	private String singleLine;
	private String doubleLine;
	private String checkedBy;

	
	
	public String getCheckedBy() {
		return checkedBy;
	}
	public void setCheckedBy(String checkedBy) {
		this.checkedBy = checkedBy;
	}
	public String getBank() {
		return bank;
	}
	public String getReportName() {
		return reportName;
	}
	public String getTime() {
		return time;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getDate() {
		return date;
	}
	public String getPage() {
		return page;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public String getInternal() {
		return internal;
	}
	public String getTransDistReport() {
		return transDistReport;
	}
	public String getTransCarriedForwardDate() {
		return transCarriedForwardDate;
	}
	public String getDebit() {
		return debit;
	}
	public String getCredit() {
		return credit;
	}
	public String getService() {
		return service;
	}
	public String getSubService() {
		return subService;
	}
	public String getType() {
		return type;
	}
	public String getCode() {
		return code;
	}
	public String getVolume() {
		return volume;
	}
	public String getValues() {
		return values;
	}
	public String getServiceName() {
		return serviceName;
	}
	public String getSubServiceName() {
		return subServiceName;
	}
	public String getTypeName() {
		return typeName;
	}
	public String getCodeName() {
		return codeName;
	}
	public String getVolumeName() {
		return volumeName;
	}
	public String getValuesName() {
		return valuesName;
	}
	public String getTotalsName() {
		return totalsName;
	}
	public String getTotalsVolumes() {
		return totalsVolumes;
	}
	public String getTotalsValues() {
		return totalsValues;
	}
	public String getAuthorizedBy() {
		return authorizedBy;
	}
	public String getAuthorizedByLine() {
		return authorizedByLine;
	}
	public String getSingleLine() {
		return singleLine;
	}
	public String getDoubleLine() {
		return doubleLine;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public void setInternal(String internal) {
		this.internal = internal;
	}
	public void setTransDistReport(String transDistReport) {
		this.transDistReport = transDistReport;
	}
	public void setTransCarriedForwardDate(String transCarriedForwardDate) {
		this.transCarriedForwardDate = transCarriedForwardDate;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public void setService(String service) {
		this.service = service;
	}
	public void setSubService(String subService) {
		this.subService = subService;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public void setValues(String values) {
		this.values = values;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public void setSubServiceName(String subServiceName) {
		this.subServiceName = subServiceName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public void setVolumeName(String volumeName) {
		this.volumeName = volumeName;
	}
	public void setValuesName(String valuesName) {
		this.valuesName = valuesName;
	}
	public void setTotalsName(String totalsName) {
		this.totalsName = totalsName;
	}
	public void setTotalsVolumes(String totalsVolumes) {
		this.totalsVolumes = totalsVolumes;
	}
	public void setTotalsValues(String totalsValues) {
		this.totalsValues = totalsValues;
	}
	public void setAuthorizedBy(String authorizedBy) {
		this.authorizedBy = authorizedBy;
	}
	public void setAuthorizedByLine(String authorizedByLine) {
		this.authorizedByLine = authorizedByLine;
	}
	public void setSingleLine(String singleLine) {
		this.singleLine = singleLine;
	}
	public void setDoubleLine(String doubleLine) {
		this.doubleLine = doubleLine;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(bank == null ? rightPadding(" ",3) :rightPadding(bank,3));
		builder.append(reportName == null ? paddingLeft(" ",10) :paddingLeft(reportName,10));
		builder.append(time == null ? paddingLeft(" ",16) :paddingLeft(time,16));
		builder.append(companyName == null ? paddingLeft(" ",44) :paddingLeft(companyName,44));
		builder.append(date == null ? paddingLeft(" ",29) :paddingLeft(date,29));
		builder.append(page == null ? paddingLeft(" ",8) :paddingLeft(page,8));
		
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		
		builder.append(regNumber == null ? paddingLeft(" ",53) :paddingLeft(regNumber,53));
		
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		
		builder.append(internal == null ? rightPadding(" ",31) :rightPadding(internal,31));		
		builder.append(transDistReport == null ? paddingLeft(" ",45) :paddingLeft(transDistReport,45));
		
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		
		builder.append(transCarriedForwardDate == null ? paddingLeft(" ",66) :paddingLeft(transCarriedForwardDate,66));
		
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		
		builder.append(debit == null ? paddingLeft(" ",46) :paddingLeft(debit,46));		
		builder.append(credit == null ? paddingLeft(" ",25) :paddingLeft(credit,25));
		
		builder.append(System.lineSeparator());
		
		builder.append(singleLine == null ? paddingLeft(" ",50) :paddingLeft(singleLine,50));
		builder.append(singleLine == null ? paddingLeft(" ",29) :paddingLeft(singleLine,29));
		
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		
		builder.append(serviceName == null ? rightPadding(" ",7) :rightPadding(serviceName,7));
		builder.append(subServiceName == null ? paddingLeft(" ",29) :paddingLeft(subServiceName,29));
		builder.append(typeName == null ? paddingLeft(" ",12) :paddingLeft(typeName,12));
		builder.append(codeName == null ? paddingLeft(" ",1) :paddingLeft(codeName,1));
		builder.append(volumeName == null ? paddingLeft(" ",14) :paddingLeft(volumeName,14));
		builder.append(valuesName == null ? paddingLeft(" ",18) :paddingLeft(valuesName,18));
		builder.append(volumeName == null ? paddingLeft(" ",14) :paddingLeft(volumeName,14));
		builder.append(valuesName == null ? paddingLeft(" ",18) :paddingLeft(valuesName,18));
		
		builder.append(System.lineSeparator());
		
		builder.append(singleLine == null ? paddingLeft(" ",1) :paddingLeft(singleLine,1));
		builder.append(singleLine == null ? paddingLeft(" ",12) :paddingLeft(singleLine,12));
		builder.append(singleLine == null ? paddingLeft(" ",12) :paddingLeft(singleLine,12));
		builder.append(singleLine == null ? paddingLeft(" ",18) :paddingLeft(singleLine,18));
		builder.append(singleLine == null ? paddingLeft(" ",14) :paddingLeft(singleLine,14));
		builder.append(singleLine == null ? paddingLeft(" ",18) :paddingLeft(singleLine,18));
		builder.append(singleLine == null ? paddingLeft(" ",18) :paddingLeft(singleLine,18));
		builder.append(singleLine == null ? paddingLeft(" ",18) :paddingLeft(singleLine,18));
		
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		
		builder.append(service == null ? paddingLeft(" ",5) :paddingLeft(service,5));
		builder.append(subService == null ? paddingLeft(" ",25) :paddingLeft(subService,25));
		builder.append(type == null ? paddingLeft(" ",17) :paddingLeft(type,17));		
		builder.append(code == null ? paddingLeft(" ",5) :paddingLeft(code,5));		
		builder.append(volume == null ? paddingLeft(" ",14) :paddingLeft(volume,14));		
		builder.append(values == null ? paddingLeft(" ",18) :paddingLeft(values,18));
		builder.append(volume == null ? paddingLeft(" ",14) :paddingLeft(volume,14));		
		builder.append(values == null ? paddingLeft(" ",18) :paddingLeft(values,18));
		
		builder.append(System.lineSeparator());
		
		builder.append(singleLine == null ? paddingLeft(" ",1) :paddingLeft(singleLine,1));
		builder.append(singleLine == null ? paddingLeft(" ",12) :paddingLeft(singleLine,12));
		builder.append(singleLine == null ? paddingLeft(" ",12) :paddingLeft(singleLine,12));
		builder.append(singleLine == null ? paddingLeft(" ",18) :paddingLeft(singleLine,18));
		builder.append(singleLine == null ? paddingLeft(" ",14) :paddingLeft(singleLine,14));
		builder.append(singleLine == null ? paddingLeft(" ",18) :paddingLeft(singleLine,18));
		builder.append(singleLine == null ? paddingLeft(" ",18) :paddingLeft(singleLine,18));
		builder.append(singleLine == null ? paddingLeft(" ",18) :paddingLeft(singleLine,18));
		
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		
		builder.append(totalsName == null ? paddingLeft(" ",48) :paddingLeft(totalsName,48));
		builder.append(totalsVolumes == null ? paddingLeft(" ",18) :paddingLeft(totalsVolumes,18));
		builder.append(totalsValues == null ? paddingLeft(" ",19) :paddingLeft(totalsValues,19));
		builder.append(totalsVolumes == null ? paddingLeft(" ",13) :paddingLeft(totalsVolumes,13));
		builder.append(totalsValues == null ? paddingLeft(" ",19) :paddingLeft(totalsValues,19));
		builder.append(System.lineSeparator());
		
		builder.append(doubleLine == null ? paddingLeft(" ",48) :paddingLeft(doubleLine,48));
		builder.append(doubleLine == null ? paddingLeft(" ",23) :paddingLeft(doubleLine,23));
		builder.append(doubleLine == null ? paddingLeft(" ",19) :paddingLeft(doubleLine,19));
		builder.append(doubleLine == null ? paddingLeft(" ",19) :paddingLeft(doubleLine,19));
		
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		
		builder.append(authorizedBy == null ? paddingLeft(" ",48) :paddingLeft(authorizedBy,48));
		builder.append(authorizedByLine == null ? paddingLeft(" ",19) :paddingLeft(authorizedByLine,19));
		
		builder.append(System.lineSeparator());
		builder.append(System.lineSeparator());
		
		builder.append(checkedBy == null ? paddingLeft(" ",45) :paddingLeft(checkedBy,45));
		builder.append(authorizedByLine == null ? paddingLeft(" ",19) :paddingLeft(authorizedByLine,19));
		
		return builder.toString();
	}
	public static String rightPadZeros(String str, int num) {
	    return String.format("%1$-" + num + "s", str).replace(' ', ' ');
	}
	  /**
	 * @param str
	 * @param num
	 * @return
	 */
	public static String rightPadding(String str, int num) {
		    return String.format("%1$-" + num + "s", str);
	}
	/**
	* @param s
	* @param n
	* @return
	*/
	public static String padLeft(String s, int n) {
		    return String.format("%1$" + n + "s", s);
	   }
	 /**
	 * @param s
	 * @param n
	 * @return
	 */
	public static String padLeftString(String s, int n) {
		   return String.format("%0$"+ n +"s", s);
	}
	 /**
	 * @param s
	 * @param n
	 * @return
	 */
	public static String paddingLeft(String s, int n) {
		   return String.format("%1$"+ n + "s", s);
	}


}
