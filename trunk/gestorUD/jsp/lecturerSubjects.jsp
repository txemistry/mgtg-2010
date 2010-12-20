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
			</tr>
			<s:iterator value="asignaturas" status="status">
		        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		            <td class="nowrap"><s:property value="%{ codigo }"/></td>
		            <td class="nowrap"><s:property value="%{ nombre }"/></td>
		            <td class="nowrap"><s:property value="%{ creditos }"/></td>
		            <td class="nowrap"><s:property value="#session.nombre"/></td>
		            <s:url id="urlVerUnidades" action="unidad!obtenerListaUnidades" escapeAmp="false">
		            	<s:param name="idAsignatura" value="%{ id }"/>
		            </s:url>
		            <td class="nowrap"><a href="<s:property value="#urlVerUnidades"/>"><s:property value="%{ unidades.size }"/></td>
		            <td class="nowrap"><s:property value="%{ alumnos.size }"/></td>
		            <s:url id="urlVerEstudiantes" action="profesor!obtenerListaEstudiantes" escapeAmp="false">
		            	<s:param name="idAsignatura" value="%{ id }"/>
		            	<s:param name="nomAsignatura" value="%{ nombre }"/>
		            </s:url>
		            <td class="nowrap"><a href="<s:property value="#urlVerEstudiantes"/>"><s:text name="label.ver.estudiantes"/></a></td>
		        </tr>
		    </s:iterator>
		</table>
		
	</body>

</html>