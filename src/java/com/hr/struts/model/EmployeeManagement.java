package com.hr.struts.model;

import com.hr.struts.model.entities.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeManagement {
    /* Hard-coded sample data. Normally this would come from a real data source: database */

    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    private static final EmployeeManagement service = new EmployeeManagement();
    private static List<Employee> employees;
    /*
     private static final List<Employee> employees = new ArrayList<>(Arrays.asList(
     new Employee("Bob Davidson", "123-45-6789", "0102030405"),
     new Employee("Mary Williams", "987-65-4321", "0000000000"),
     new Employee("Jim Smith", "111-11-1111", "0000000000"),
     new Employee("Beverly Harris", "222-22-2222", "0000000000"),
     new Employee("Thomas Frank", "333-33-3333", "0000000000"),
     new Employee("Jim Davidson", "444-44-4444", "0000000000")
     ));
     */

    /*public static EmployeeManagement getInstance() {
     if (null == instance) {
     instance = new EmployeeManagement();
     }
     createConnection();
     //selectEmployees();
     return instance;
     }*/
    //Singleton pattern
    private EmployeeManagement() {
        employees = new ArrayList<>();
        employees = getEmployees();
    }

    public static EmployeeManagement getInstance() {
        return service;
    }

    private static ArrayList<Employee> getEmployees() {
        ArrayList<Employee> arrayList = new ArrayList<Employee>();
        Employee employe = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/HRStruts", "app", "root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select name, ssNum, phone from employes");

            while (rs.next()) {

                employe = new Employee(rs.getString("name"),
                        rs.getString("ssNum"), rs.getString("phone"));
                arrayList.add(employe);

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.err.println("test: " + arrayList.get(1).getName());
        return arrayList;
    }

    /*
     private static void createConnection() {
     try {
     Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
     //Get a connection
     conn = DriverManager.getConnection(dbURL);
     } catch (Exception except) {
     except.printStackTrace();
     }
     }

     private static ArrayList<Employee> selectEmployees() {
     ArrayList<Employee> arrayList = new ArrayList<Employee>();
     try {
     stmt = conn.createStatement();
     ResultSet results = stmt.executeQuery("select name, '000-00-0000' as ssNum, phone from employes");
     ResultSetMetaData rsmd = results.getMetaData();
     int numberCols = rsmd.getColumnCount();
     for (int i = 1; i <= numberCols; i++) {
     //print Column Names
     System.out.print(rsmd.getColumnLabel(i) + "\t\t");
     }

     while (results.next()) {

     Employee emp = new Employee(
     results.getString("name"),
     results.getString("ssNum"),
     results.getString("phone")
     );

     arrayList.add(emp);
     }

     results.close();
     stmt.close();
     } catch (SQLException sqlExcept) {
     sqlExcept.printStackTrace();
     }

     return arrayList;
     }
     */
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
