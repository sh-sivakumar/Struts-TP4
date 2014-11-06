/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hr.struts.controller;

import com.hr.struts.model.EmployeeManagement;
import com.hr.struts.model.IEmployeeManagement;
import com.hr.struts.model.entities.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.actions.MappingDispatchAction;

/**
 *
 * @author Sinthu
 */
public class SuperAction extends MappingDispatchAction {

    protected static final String PROPERTIES = "PROPERTIES";
    protected IEmployeeManagement service = EmployeeManagement.getInstance();
    protected Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public Connection connexion(HttpServletRequest request,
            HttpServletResponse response) {

        if (null == conn) { // First call
            Properties properties = new Properties();

            // Get properties' attributes
            HttpSession session = request.getSession();
            ServletContext context = session.getServletContext();
            properties = (Properties) context.getAttribute(PROPERTIES);

            String driver = properties.getProperty("driver", "Sans Driver");
            String url = properties.getProperty("url", "Sans URL");
            String login = properties.getProperty("login", "Sans Login");
            String pwd = properties.getProperty("pwd", "Sans Password");

            try {
                //Loading driver
                Class.forName(driver);
                conn = DriverManager.getConnection(url, login, pwd);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(SuperAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return conn;
    }

    static ArrayList<Employee> getEmployees(Connection conn) {
        ArrayList<Employee> arrayList = new ArrayList<Employee>();
        Employee employe = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select name, ssNum, phone from employes");

            while (rs.next()) {
                employe = new Employee(rs.getString("name"),
                        rs.getString("ssNum"), rs.getString("phone"));
                arrayList.add(employe);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayList;
    }

}
