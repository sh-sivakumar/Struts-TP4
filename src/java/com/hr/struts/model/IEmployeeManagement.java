/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.model;

import com.hr.struts.model.entities.Employee;
import java.util.ArrayList;

/**
 *
 * @author Sinthu
 */
public interface IEmployeeManagement {

    public boolean add(String name, String ssNum, String phone);

    public boolean delete(Employee e);

    public ArrayList findAll();

    public ArrayList searchByName(String name);

    public ArrayList searchBySsNum(String ssNum);

    public ArrayList searchByPhone(String phone);

    public boolean update(Employee e, String name, String ssNum, String phone);

    public void setEmployees(ArrayList<Employee> employees);
}
