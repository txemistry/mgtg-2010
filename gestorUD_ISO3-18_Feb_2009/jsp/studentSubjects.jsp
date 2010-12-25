<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.opensymphony.xwork2.*, iso3.pt.*, java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
	    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
	   	<title><s:text name="label.subjects.alumno"/></title>

	</head>
	
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		<h1><s:text name="label.subjects.alumno"/> <s:property value="#session.nombre"/> (<s:property value="#session.dni"/>)</h1>
		
		<table>
			<tr>
				<td>
					<s:url id="urlMatricula" action="estudiante!prepMatricular" escapeAmp="false"/>
					<a href="<s:property value="#urlMatricula"/>"><s:text name="label.matricular"/></a>
				</td>
				<td>
					<s:url id="urlNotas" action="estudiante!mostrarNotas" escapeAmp="false"/>
					<a href="<s:property value="#urlNotas"/>"><s:text name="label.mostrar"/></a>
				</td>
				<td>
					<s:url id="urlVerProfesores" action="estudiante!verProfesores" escapeAmp="false"/>
					<a href="<s:property value="#urlVerProfesores"/>"><s:text name="label.mostrar.profesores"/></a>
				</td>
				<td>
					<s:url id="urlLogout" action="logout" escapeAmp="false"/>
					<a href="<s:property value="#urlLogout"/>"><s:text name="label.logout"/></a>
				</td>
			</tr>
		</table>
		
		<p> </P>
		
		<table class="borderAll">
			<tr>
				<th><s:text name="tabla.subject.codigo"/></th>
				<th><s:text name="tabla.subject.nombre"/></th>
				<th><s:text name="tabla.subject.creditos"/></th>
				<th><s:text name="tabla.subject.profesor"/></th>
				<th><s:text name="tabla.subject.listado"/></th>
				<th><s:text name="tabla.subject.alumnos"/></th>
				<th>&nbsp;&nbsp;</th>
				<th>&nbsp;&nbsp;</th>
			</tr>
			<s:iterator value="asignaturas" status="status">
		        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		            <td class="nowrap"><s:property value="%{ codigo }"/></td>
		            <td class="nowrap"><s:property value="%{ nombre }"/></td>
		            <td class="nowrap"><s:property value="%{ creditos }"/></td>
		            <td class="nowrap"><s:property value="%{ profesor.nombre }"/></td>
					<s:url id="urlVerUnidades" action="unidad!obtenerListaUnidades" escapeAmp="false">
		            	<s:param name="idAsignatura" value="%{ id }"/>
		            </s:url>
		            <td class="nowrap"><a href="<s:property value="#urlVerUnidades"/>"><s:property value="%{ unidades.size }"/></td>		            <td class="nowrap"><s:property value="%{ alumnos.size }"/></td>
		            <s:url id="urlDesmatricular" action="estudiante!desmatricular" escapeAmp="false">
		            	<s:param name="idAsignatura" value="%{ id }"/>
		            </s:url>
		            <td class="nowrap"><a href="<s:property value="#urlDesmatricular"/>"><s:text name="label.desmatricular"/></a></td>
		            <s:url id="urlVerNotas" action="estudiante!verNotas" escapeAmp="false">
		            	<s:param name="idAsignatura" value="%{ id }"/>
		            </s:url>
		            <td class="nowrap"><a href="<s:property value="#urlVerNotas"/>"><s:text name="label.ver.notas"/></a></td>
		        </tr>
		    </s:iterator>
		</table>
		
	</body>

</html>