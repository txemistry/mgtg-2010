<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.opensymphony.xwork2.*, iso3.pt.*, java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
	    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
	   	<title><s:text name="label.estudiantes.asignatura"/> "<s:property value="#session.nombre"/>" "<s:text name="label.para"/>"</title>

	</head>
	
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		<h1><s:text name="label.estudiantes.asignatura"/> "<s:property value="#session.nombre"/>" <s:text name="label.para"/> "<s:property value="nomAsignatura"/>"</h1>
		
		
		
		<p> </p>
		
		<table class="borderAll">
			<tr>
				<th><s:text name="tabla.student.dni"/></th>
				<th><s:text name="tabla.subject.nombre"/></th>
				<th><s:text name="tabla.student.telefono"/></th>
				<th><s:text name="tabla.student.id"/></th>
			</tr>
			<s:iterator value="alumnos" status="status">
		        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		            <td class="nowrap"><s:property value="%{ dni }"/></td>
		            <td class="nowrap"><s:property value="%{ nombre }"/></td>
		            <td class="nowrap"><s:property value="%{ telefono }"/></td>
		            <s:url id="urlPrepCalificar" action="profesor!prepCalificar" escapeAmp="false">
		            	<s:param name="dniAlumno" value="%{ dni }"/>
		            	<s:param name="idAsignatura" value="idAsignatura"/>
		            </s:url>
		            <td class="nowrap"><a href="<s:property value="#urlPrepCalificar"/>"><s:text name="label.anyadir.nota"/></a></td>
		        </tr>
		    </s:iterator>
		</table>
		
		<s:form action="profesor!obtenerListaAsignaturas" method="POST">
			
			<s:submit value="%{getText('label.cancel.button')}" align="center"/>
			
		</s:form>
		
	</body>

</html>