<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.opensymphony.xwork2.*, iso3.pt.*, java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
	    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
	   	<title><s:text name="label.notas"/> "<s:property value="%{ alumno.nombre }"/>" <s:text name="label.para"/> "<s:property value="%{ asignatura.nombre }"/>"</title>

	</head>
	
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		<h1><s:text name="label.notas"/> "<s:property value="%{ alumno.nombre }"/>" <s:text name="label.para"/> "<s:property value="%{ asignatura.nombre }"/>"</h1>
		
		
		
		<p> </P>
		
		<table class="borderAll">
			<tr>
				<th><s:text name="tabla.student.dni"/></th>
				<th><s:text name="tabla.subject.nombre"/></th>
				<th><s:text name="tabla.student.telefono"/></th>
			</tr>
		    <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		        <td class="nowrap"><s:property value="%{ alumno.dni }"/></td>
		        <td class="nowrap"><s:property value="%{ alumno.nombre }"/></td>
		        <td class="nowrap"><s:property value="%{ alumno.telefono }"/></td>
		    </tr>
		</table>
		
		&nbsp
		&nbsp
		
		<table class="borderAll">
			<tr>
				<th><s:text name="tabla.subject.codigo"/></th>
				<th><s:text name="tabla.subject.nombre"/></th>
				<th><s:text name="tabla.subject.creditos"/></th>
				<th><s:text name="tabla.subject.profesor"/></th>
     			<th><s:text name="tabla.subject.alumnos"/></th>
				<th>&nbsp;&nbsp;</th>
			</tr>
		
		    <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		        <td class="nowrap"><s:property value="%{ asignatura.codigo }"/></td>
		        <td class="nowrap"><s:property value="%{ asignatura.nombre }"/></td>
		        <td class="nowrap"><s:property value="%{ asignatura.creditos }"/></td>
		        <td class="nowrap"><s:property value="#session.nombre"/></td>
		        <td class="nowrap"><s:property value="%{ asignatura.alumnos.size }"/></td>
			</tr>
		  
		</table>
		
		&nbsp
		&nbsp
		&nbsp
		&nbsp
		&nbsp
		&nbsp
		
		<table class="borderAll">
			<tr>
				<th><s:text name="tabla.student.id"/></th>
				<th><s:text name="label.calificar.concepto"/></th>
				<th><s:text name="label.calificar.nota"/></th>
			</tr>
			<s:iterator value="evaluaciones" status="status">
		        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		            <td class="nowrap"><s:property value="%{ id }"/></td>
		            <td class="nowrap"><s:property value="%{ concepto }"/></td>
		            <td class="nowrap"><s:property value="%{ nota }"/></td>
		        </tr>
		    </s:iterator>
		</table>
		
		&nbsp
		&nbsp
		&nbsp
		&nbsp
		&nbsp
	
		
		<s:form action="profesor!obtenerListaAsignaturas" method="POST">
			
			<s:submit value="%{getText('label.cancel.button')}" align="center"/>
			
		</s:form>
		
	</body>

</html>