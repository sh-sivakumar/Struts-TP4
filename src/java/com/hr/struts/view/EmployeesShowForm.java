/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.view;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Sinthu
 */
public class EmployeesShowForm extends ActionForm {

    private List results = null;

    public void setResults(List results) {
        this.results = results;
    }

    public List getResults() {
        return results;
    }

    // Reset form fields. 
    public void reset(ActionMapping map, HttpServletRequest req) {
        results = null;
    }
}
