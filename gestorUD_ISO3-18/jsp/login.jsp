<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.opensymphony.xwork2.*, iso3.pt.*, java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
	    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
	   	<title><s:text name="label.login"/></title>
	    
	</head>
	
	
	
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		<h1><s:text name="label.login"/></h1>
		
		<s:form action="login" method="POST">
		
			<tr>
				<td colspan="2">
					<s:actionerror />
				</td>
			</tr>
		
			<s:textfield name="username" label="%{getText('label.login.name')}"/>
			<s:password name="password" label="%{getText('label.login.password')}"/>
			
			<s:select name="userType" list="{'Profesor','Estudiante'}" label="%{getText('label.login.combo')}"/>		
			<s:submit value="%{getText('label.login.button')}" align="center"/>
			
		</s:form>
		
	</body>
	
</html>