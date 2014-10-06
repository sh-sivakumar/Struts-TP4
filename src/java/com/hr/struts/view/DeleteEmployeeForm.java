/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.view;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Sinthu
 */
public class DeleteEmployeeForm extends ActionForm {
    
    private String ssNum;
    private boolean results = false;

    public String getSsNum() {
        return ssNum;
    }

    public void setSsNum(String ssNum) {
        this.ssNum = ssNum;
    }

    public void setResults(boolean results) {
        this.results = results;
    }

    public boolean getResults() {
        return results;
    }

    // Reset form fields. 
    public void reset(ActionMapping map, HttpServletRequest req) {
        results = false;
    }

}
