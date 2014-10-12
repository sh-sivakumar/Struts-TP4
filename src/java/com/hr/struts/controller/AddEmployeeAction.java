/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.controller;

import com.hr.struts.model.EmployeeManagement;
import com.hr.struts.view.AddEmployeeForm;
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
public final class AddEmployeeAction extends SuperAction {

    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        boolean results;

        AddEmployeeForm addEmp = (AddEmployeeForm) form;

        String name, ssNum, phone;
        name = (String) request.getParameter("name");
        ssNum = (String) request.getParameter("ssNum");
        phone = (String) request.getParameter("phone");

        results = service.add(name, ssNum, phone);

        // Cible par defaut
        String cible = new String("succes");

        // Cible en cas d'echec
        if (results == false) {
            cible = new String("echec");
            ActionMessages errors = new ActionMessages();
            errors.add(null, new ActionMessage("error.add.employees.false"));
            // Signalement des erreurs a la page d'origine
            if (!errors.isEmpty()) {
                saveErrors(request, errors);
            }
        } else {
            addEmp.setResults(results);
        }
        // Transmission a la vue appropriee
        return (mapping.findForward(cible));
    }
}
