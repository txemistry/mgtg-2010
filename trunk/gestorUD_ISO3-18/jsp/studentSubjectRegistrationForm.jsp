<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.opensymphony.xwork2.*, iso3.pt.*, java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
	    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
	   	<title><s:text name="label.alumno.matricular"/> <s:property value="#session.nombre"/> (<s:property value="#session.dni"/>)</title>

	</head>
	
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		<h1><s:text name="label.alumno.matricular"/> <s:property value="#session.nombre"/> (<s:property value="#session.dni"/>)</h1>
		
		<s:form action="estudiante!matricular" method="post">
		
			<tr>
				<td colspan="2">
					<s:actionerror />
				</td>
			</tr>
			
		    <s:select name="idAsignaturaSeleccionada" list="asignaturasTotales" listKey="id" listValue="nombre" label="%{getText('label.subject.select')}"/>
		    <s:submit value="%{getText('label.calificar.entregar')}"/>
		    <s:submit value="%{getText('label.cancel.button')}" name="redirect-action:estudiante!obtenerListaAsignaturas"/>
		</s:form>
		
	</body>

</html>