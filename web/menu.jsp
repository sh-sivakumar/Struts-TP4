<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
    <head>
        <title><bean:message key="title.portal"/></title> </head>
    <body>
        
        <font size="+1"><bean:message key="title.portal"/></font><br> 
        <hr width="100%" noshade="true">
        
        &#149; <html:link forward="search"><bean:message key="title.search.employee"/></html:link><br>
        &#149; <html:link forward="showAll"><bean:message key="title.show.employee"/></html:link><br>
        &#149; <html:link forward="add"><bean:message key="title.add.employee"/></html:link><br>
        &#149; <html:link forward="delete"><bean:message key="title.delete.employee"/></html:link><br>
        &#149; <html:link forward="update"><bean:message key="title.update.employee"/></html:link><br>
        <br>
        <html:errors/> 

    </body>
</html>