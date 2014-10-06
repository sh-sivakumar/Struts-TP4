package com.hr.struts.model;

import com.hr.struts.model.entities.Employee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeManagement {
    /* Hard-coded sample data. Normally this would come from a real data source: database */

    private static EmployeeManagement instance;

    public static EmployeeManagement getInstance() {
        if (null == instance) {
            instance = new EmployeeManagement();
        }
        return instance;
    }

    private static final List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Bob Davidson", "123-45-6789", "0102030405"),
            new Employee("Mary Williams", "987-65-4321", "0000000000"),
            new Employee("Jim Smith", "111-11-1111", "0000000000"),
            new Employee("Beverly Harris", "222-22-2222", "0000000000"),
            new Employee("Thomas Frank", "333-33-3333", "0000000000"),
            new Employee("Jim Davidson", "444-44-4444", "0000000000")
    ));

    // Search for employees by name.
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
    public ArrayList searchByPhone(String phone) {
        ArrayList resultList = new ArrayList();
        for (Employee employee : employees) {
            if (employee.getPhone().equals(phone)) {
                resultList.add(employee);
            }
        }
        return resultList;
    }

    public boolean delete(Employee get) {
        employees.remove(get);
        return true;
    }

    public ArrayList findAll() {
        return (ArrayList) employees;
    }

    public boolean add(String name, String ssNum, String phone) {
        employees.add(new Employee(name, ssNum, phone));
        return true;
    }

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
}
