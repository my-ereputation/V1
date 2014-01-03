<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="s" uri="/struts-tags" %> 
 
<html> 
    <head> 
        <title><s:text name="myereputation.welcome_message"/></title> 
    </head> 
 
    <body> 
        <h2>
			<s:iterator value="regions">
				<s:property value="name"/><br />
			</s:iterator>
		</h2>
	</body>
</html> 