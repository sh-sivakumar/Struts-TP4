package com.hr.struts.model;

import com.hr.struts.model.entities.Employee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeManagement {
    /* Hard-coded sample data. Normally this would come from a real data source: database */

    private static List<Employee> employees = new ArrayList<Employee>(Arrays.asList(
            new Employee("Bob Davidson", "123-45-6789"),
            new Employee("Mary Williams", "987-65-4321"),
            new Employee("Jim Smith", "111-11-1111"),
            new Employee("Beverly Harris", "222-22-2222"),
            new Employee("Thomas Frank", "333-33-3333"),
            new Employee("Jim Davidson", "444-44-4444")
    ));

    // Search for employees by name.
    public ArrayList searchByName(String name) {
        ArrayList resultList = new ArrayList();
        for (Employee employee : employees) {
            if (employee.getName().toUpperCase().indexOf(name.toUpperCase()) != -1) {
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

    public boolean delete(Employee get) {
        employees.remove(get);
        return true;
    }

    public ArrayList findAll() {
        return (ArrayList) employees;
    }

    public boolean add(String name, String ssNum) {
        employees.add(new Employee(name, ssNum));
        return true;
    }

    public boolean update(Employee e, String name, String ssNum) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(e)) {
                employees.get(i).setName(name);
                employees.get(i).setSsNum(ssNum);
            }
        }
        return true;
    }
}
