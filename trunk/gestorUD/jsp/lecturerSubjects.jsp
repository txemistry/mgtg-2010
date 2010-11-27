<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.opensymphony.xwork2.*, iso3.pt.*, java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
	    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
	   	<title><s:text name="label.subjects.prof"/></title>

	</head>
	
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		<h1><s:text name="label.subjects.prof"/> <s:property value="#session.nombre"/> (<s:property value="#session.dni"/>)</h1>
		
		<table>
			<tr>
				<td>
					<s:url id="urlLogout" action="login!logout" escapeAmp="false"/>
					<a href="<s:property value="#urlLogout"/>"><s:text name="label.logout"/></a>
				</td>
			</tr>
		</table>
		

		
	</body>

</html>