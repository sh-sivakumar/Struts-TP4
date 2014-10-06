<%-- 
    Document   : deleteEmployee
    Created on : 6 oct. 2014, 11:54:52
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
        <title>Delete Employee</title>
    </head>
    <body>
        <html:form action="/deleteEmployee">
            <table>
                <tr>
                    <td align="right"><bean:message key="label.search.ssNum"/>:</td>
                    <td><html:text property="ssNum"/>(xxx-xx-xxxx)</td>
                </tr>
                <tr>
                    <td></td>
                    <td><html:submit/></td>
                </tr>
            </table>
        </html:form>
    </body>
</html>