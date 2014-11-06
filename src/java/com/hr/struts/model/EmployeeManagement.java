package com.hr.struts.model;

import com.hr.struts.model.entities.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement implements IEmployeeManagement {

    private static EmployeeManagement service;
    private static List<Employee> employees;

    //Singleton pattern
    public static EmployeeManagement getInstance() {
        if (null == service) { // Premier appel
            service = new EmployeeManagement();
        }
        return service;
    }

    public EmployeeManagement() {
        employees = new ArrayList<Employee>();
    }

    // Search for employees by name.
    @Override
    public ArrayList searchByName(String name) {
        ArrayList resultList = new ArrayList();
        for (Employee employee : employees) {
            if (employee.getName().toUpperCase().contains(name.toUpperCase())) {
                resultList.add(employee);
            }
        }
        return resultList;
    }

    // Search for employee by social security number. 
    @Override
    public ArrayList searchBySsNum(String ssNum) {
        ArrayList resultList = new ArrayList();
        for (Employee employee : employees) {
            if (employee.getSsNum().equals(ssNum)) {
                resultList.add(employee);
            }
        }
        return resultList;
    }

    // Search for employee by phone.
    @Override
    public ArrayList searchByPhone(String phone) {
        ArrayList resultList = new ArrayList();
        for (Employee employee : employees) {
            if (employee.getPhone().equals(phone)) {
                resultList.add(employee);
            }
        }
        return resultList;
    }

    @Override
    public boolean delete(Employee get) {
        employees.remove(get);
        return true;
    }

    @Override
    public ArrayList findAll() {
        return (ArrayList) employees;
    }

    @Override
    public boolean add(String name, String ssNum, String phone) {
        employees.add(new Employee(name, ssNum, phone));
        return true;
    }

    @Override
    public boolean update(Employee e, String name, String ssNum, String phone) {
        for (Employee employee : employees) {
            if (employee.equals(e)) {
                employee.setName(name);
                employee.setSsNum(ssNum);
                employee.setPhone(phone);
            }
        }
        return true;
    }

    @Override
    public void setEmployees(ArrayList<Employee> employees) {
        
    }

}
