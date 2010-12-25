<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.opensymphony.xwork2.*, iso3.pt.*, java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
	    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
	   	<title><s:text name="label.registro"/></title>
	    
	</head>
	
	
	
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		<h1><s:text name="label.registro"/></h1>
		
		<s:form action="registrar!registrar" method="POST">
		
			<tr>
				<td colspan="2">
					<s:actionerror />
				</td>
			</tr>
		
			<s:textfield name="user" label="%{getText('label.login.name')}"/>
			<s:password name="pass" label="%{getText('label.login.password')}"/>
			<s:textfield name="nom" label="%{getText('tabla.subject.nombre')}"/>
			<s:textfield name="tel" label="%{getText('tabla.student.telefono')}"/>
						
			<s:submit value="%{getText('label.registrar.button')}" align="center"/>
			
		</s:form>
		
	</body>
	
</html>