/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.controller;

import com.hr.struts.model.EmployeeManagement;
import com.hr.struts.model.entities.Employee;
import com.hr.struts.view.AddEmployeeForm;
import com.hr.struts.view.DeleteEmployeeForm;
import com.hr.struts.view.EmployeesShowForm;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author Sinthu
 */
public final class DeleteEmployeeAction extends Action {

    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {
        EmployeeManagement service = new EmployeeManagement();
        boolean results = true;

        DeleteEmployeeForm deleteEmp = (DeleteEmployeeForm) form;

        String ssNum;
        ssNum = (String) request.getParameter("ssNum");
        ArrayList<Employee> listEmp = service.searchBySsNum(ssNum);
        for(int i=0;i<listEmp.size();i++) {
            boolean res;
            res = service.delete(listEmp.get(i));
            if(!res) {
                results = false;
            }
        }

        // Cible par defaut
        String cible = new String("succes");

        // Cible en cas d'echec
        if (results == false) {
            cible = new String("echec");
            ActionMessages errors = new ActionMessages();
            errors.add(null, new ActionMessage("error.delete.employees.false"));
            // Signalement des erreurs a la page d'origine
            if (!errors.isEmpty()) {
                saveErrors(request, errors);
            }
        } else {
            deleteEmp.setResults(results);
        }
        // Transmission a la vue appropriee
        return (mapping.findForward(cible));
    }
}
