<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.opensymphony.xwork2.*, iso3.pt.*, java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
	    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
	   	<title><s:text name="label.profesores.dan.clase"/> "<s:property value="#session.nombre"/>"</title>

	</head>
	
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		<h1><s:text name="label.profesores.dan.clase"/> "<s:property value="#session.nombre"/>"</h1>
		
		
		
		<p> </p>
		
		<table class="borderAll">
			<tr>
				<th><s:text name="tabla.subject.nombre"/></th>
				<th><s:text name="tabla.student.id"/></th>
				<th><s:text name="tabla.student.dni"/></th>
				<th><s:text name="tabla.student.telefono"/></th>
				<th><s:text name="tabla.email"/></th>
				<th><s:text name="tabla.despacho"/></th>
			</tr>
			<s:iterator value="profesores" status="status">
		        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		            <td class="nowrap"><s:property value="%{ nombre }"/></td>
		            <td class="nowrap"><s:property value="%{ id }"/></td>
		            <td class="nowrap"><s:property value="%{ dni }"/></td>
		            <td class="nowrap"><s:property value="%{ telefono }"/></td>
		            <td class="nowrap"><s:property value="%{ email }"/></td>
		            <td class="nowrap"><s:property value="%{ despacho }"/></td>
		        </tr>
		    </s:iterator>
		</table>
		
		<s:form action="estudiante!obtenerListaAsignaturas" method="POST">
			
			<s:submit value="%{getText('label.cancel.button')}" align="center"/>
			
		</s:form>
		
	</body>

</html>