/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsva.dmcs.reports;

import java.util.List;

/**
 *
 * @author RinusE
 */
public interface DMCSReportInterface {
    public List<String> getListOfReportNames();
    public void printTextFile() throws Exception;
}
