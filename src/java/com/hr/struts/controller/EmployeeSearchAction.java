package com.hr.struts.controller;

import com.hr.struts.model.EmployeeManagement;
import com.hr.struts.view.EmployeeSearchForm;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class EmployeeSearchAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        EmployeeManagement service = new EmployeeManagement();
        ArrayList results;
        EmployeeSearchForm searchForm = (EmployeeSearchForm) form;
        
        // Perform employee search based on the criteria entered. 
        String name = searchForm.getName();
        if (name != null && name.trim().length() > 0) {
            results = service.searchByName(name);
        } else {
            results = service.searchBySsNum(searchForm.getSsNum().trim());
        }
        
        // Place search results in EmployeeSearchForm bean for access in the JSP. 
        searchForm.setResults(results);
        
        // Forward control to this Action's input page.
        return mapping.getInputForward();
    }
}
