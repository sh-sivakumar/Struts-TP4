/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.controller;

import org.apache.struts.action.Action;
import com.hr.struts.model.EmployeeManagement;

/**
 *
 * @author Sinthu
 */
public class SuperAction extends Action{
    EmployeeManagement service = EmployeeManagement.getInstance();
}
