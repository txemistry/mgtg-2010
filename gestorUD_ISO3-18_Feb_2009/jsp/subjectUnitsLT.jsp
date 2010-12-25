<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.opensymphony.xwork2.*, iso3.pt.*, java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

	<head>
	    <link href="<s:url value='/css/main.css'/>" rel="stylesheet" type="text/css"/>
	   	<title><s:text name="label.unidades"/> "<s:property value="%{ asignatura.nombre }"/>"</title>

	</head>
	
	<body>
		<div class="titleDiv"><s:text name="application.title"/></div>
		<h1><s:text name="label.unidades"/> "<s:property value="%{ asignatura.nombre }"/>"</h1>
		
		
		
		<p> </p>
		
		<table class="borderAll">
			<tr>
				<th><s:text name="tabla.student.id"/></th>
				<th><s:text name="label.unidad.acronimo"/></th>
				<th><s:text name="label.unidad.titulo"/></th>
				<th><s:text name="label.unidad.contenido"/></th>
			</tr>
			<s:iterator value="unidades" status="status">
		        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
		            <td class="nowrap"><s:property value="%{ id }"/></td>
		            <td class="nowrap"><s:property value="%{ acronimo }"/></td>
		            <td class="nowrap"><s:property value="%{ titulo }"/></td>
		         	<td class="nowrap"><s:property value="%{ contenido }"/></td>
		        </tr>
		        
		    </s:iterator>
		</table>
		
		&nbsp
		&nbsp
		&nbsp
		
		<s:form action="profesor!obtenerListaAsignaturas" method="POST">
			
			<s:submit value="%{getText('label.cancel.button')}" align="center"/>
			
		</s:form>
		
	</body>

</html>