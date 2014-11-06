<%-- 
    Document   : showEmployees
    Created on : 6 oct. 2014, 10:52:42
    Author     : Sinthu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1><bean:message key="title.show.employee"/></h1>

        <html:form action="/showEmployees"> 
            <html:submit/>
        </html:form>

        <logic:present name="employeesShowForm" property="results">
            <hr width="100%" size="1" noshade="true"/>
            <bean:size id="size" name="employeesShowForm" property="results"/> 
            <logic:equal name="size" value="0">
            <center>
                <font color="red"> <b><bean:message key="error.show.employees.notfound"/></b></font>
            </center> 
        </logic:equal>

        <logic:greaterThan name="size" value="0">
            <table border="1">
                <tr>
                    <th><bean:message key="label.search.name"/></th>
                    <th><bean:message key="label.search.ssNum"/></th>
                </tr>
                <logic:iterate id="result" name="employeesShowForm" property="results">
                    <tr>
                        <td><bean:write name="result" property="name"/></td>
                        <td><bean:write name="result" property="ssNum"/></td>
                    </tr>
                </logic:iterate>
            </table>
        </logic:greaterThan>

    </logic:present>
</body>
</html>
