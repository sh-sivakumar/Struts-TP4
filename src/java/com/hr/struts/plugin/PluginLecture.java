package com.hr.struts.plugin;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;

import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.apache.struts.action.ActionServlet;

public class PluginLecture implements PlugIn {

    public static final String PROPERTIES = "PROPERTIES";
    private String filePath = null; //retrieves from struts config

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String f) {
        filePath = f;
    }

    public void init(ActionServlet servlet, ModuleConfig applicationConfig)
            throws javax.servlet.ServletException {

        System.out.println("---->Le plug-in démarre<----");
        Properties properties = new Properties();

        try {
            //Read file
            FileInputStream fis = new FileInputStream(getFilePath());
            properties.load(fis);

            //Put properties from file into the session (cache memory)
            ServletContext context = servlet.getServletContext();
            context.setAttribute(PROPERTIES, properties);

            //Show items' value (test)
            System.out.println(properties.getProperty("driver", "Sans Driver"));
            System.out.println(properties.getProperty("url", "Sans URL"));
            System.out.println(properties.getProperty("login", "Sans Login"));
            System.out.println(properties.getProperty("pwd", "Sans Password"));

        } catch (FileNotFoundException fnfe) {
            throw new ServletException(fnfe.getMessage());
        } catch (IOException ioe) {
            throw new ServletException(ioe.getMessage());
        }
    }

    public void destroy() {
        System.out.println("---->Le plug-in s'arrête<----");
    }
}
