<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.opensymphony.xwork2.*, iso3.pt.*, java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
	    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
	   	<title><s:text name="label.anyadir.nota"/></title>

	</head>
	
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		<h1><s:text name="label.anyadir.nota"/></h1>
		
		
		
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
		
		<s:form  action="calificar!calificar" method="POST">
		
			<s:hidden name="hiddenIdAsignatura" value="%{ asignatura.id }"/>
			<s:hidden name="hiddenDniAlumno" value="%{ alumno.dni }"/>
			
			<tr>
				<td colspan="2">
					<s:actionerror />
				</td>
			</tr>
			
			<s:textfield name="concepto" label="%{getText('label.calificar.concepto')}"/>
			<s:textfield name="nota" label="%{getText('label.calificar.nota')}"/>
			<s:submit value="%{getText('label.calificar.entregar')}" align="right"/>
			<s:submit value="%{getText('label.cancel.button')}" align="right" name="redirect-action:profesor!obtenerListaAsignaturas"/>
			
		</s:form>
		
	</body>

</html>