package com.bsva.dmcs.file.reports;


/**
 * @author AugustineA
 *
 */
public class ReportLine {
	
	private String line ;

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public ReportLine(String line) {
		super();
		this.line = line;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(line == null ? padLeft(" ",77) : padLeft(line,77));
		return builder.toString();
	}

	public ReportLine() {
		super();
	}
	
	
	/**
	* @param s
	* @param n
	* @return
	*/
	public static String padLeft(String s, int n) {
			    return String.format("%1$" + n + "s", s);
		   }
	

}
