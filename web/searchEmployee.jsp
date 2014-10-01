<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %> 
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html>
    <head>
        <title> Portal for Employee Management - Employee Search</title> </head>
    <body>

        <font size="+1">
        Portal for Employee Management - Employee Search </font><br>
        <hr width="100%" noshade="true">
        <html:errors/>
        <html:form action="/searchEmployee"> 
            <table>
                <tr>
                    <td align="right"><bean:message key="label.search.name"/>:</td> 
                    <td><html:text property="name"/></td>
                </tr> 
                <tr>
                    <td></td>
                    <td>-- or --</td> 
                </tr>
                <tr>
                    <td align="right"><bean:message key="label.search.ssNum"/>:</td> 
                    <td><html:text property="ssNum"/> (xxx-xx-xxxx)</td>
                </tr>
                <tr>
                    <td></td>
                    <td>-- or --</td> 
                </tr>
                <tr>
                    <td align="right"><bean:message key="label.search.phone"/>:</td> 
                    <td><html:text property="phone"/></td>
                </tr> 
                <tr>
                    <td></td>
                    <td><html:submit/></td> 
                </tr>
            </table> 
        </html:form>

        <logic:present name="employeeSearchForm" property="results">
            <hr width="100%" size="1" noshade="true">
            <bean:size id="size" name="employeeSearchForm" property="results"/> 
            <logic:equal name="size" value="0">
            <center><font color="red">No Employees Found</font></center> 
            </logic:equal>

        <logic:greaterThan name="size" value="0"> 
            <table border="1">
                <tr> 
                    <th>Name</th>
                    <th>Social Security Number</th> 
                    <th>Phone</th>
                </tr>
                <logic:iterate id="result" name="employeeSearchForm" property="results">
                    <tr>
                        <td><bean:write name="result" property="name"/></td> 
                        <td><bean:write name="result" property="ssNum"/></td>
                        <td><bean:write name="result" property="phone"/></td>
                    </tr> 
                </logic:iterate>
            </table> 
        </logic:greaterThan>
    </logic:present> 

</body>
</html>