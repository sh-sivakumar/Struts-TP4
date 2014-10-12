/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hr.struts.controller;

import com.hr.struts.model.EmployeeManagement;
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
public final class EmployeesShowAction extends SuperAction
{
  public ActionForward execute(ActionMapping mapping,
     					ActionForm form,
    					HttpServletRequest request,
    					HttpServletResponse response)
  throws Exception
  {
    ArrayList results;
   
    EmployeesShowForm showForm = (EmployeesShowForm) form;
   
    // Perform the show all the employees function.
    results = service.findAll();
    
    // Cible par defaut
    String cible = new String("succes");

    // Cible en cas d'echec
    if (results == null ) {
      cible = new String("echec");
      ActionMessages errors = new ActionMessages();
      errors.add(null, new ActionMessage("error.show.employees.notfound"));
      // Signalement des erreurs a la page d'origine
      if (!errors.isEmpty()) {
        saveErrors(request, errors);
      }
    }
    else {
        // Place search results in EmployeesShowForm for access by JSP.
        showForm.setResults(results);
    }
    // Transmission a la vue appropriee
    return (mapping.findForward(cible));
  }
}
