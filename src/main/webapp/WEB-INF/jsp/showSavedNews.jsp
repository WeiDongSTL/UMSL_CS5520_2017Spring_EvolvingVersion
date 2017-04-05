<%--
  Created by IntelliJ IDEA.
  User: dav
  Date: 3/19/17
  Time: 1:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> Saved News Displayed Here: </title>
</head>

<body>
<center>
<h1> Saved News Displayed Here: </h1>
	<fieldset>
		<form:form id="loadForm" modelAttribute="newsList" 
			action="showQuestions.html" method="GET">
		<br/>
		<br/><br/>
		<fieldset>
		
		<br>

		<c:if test="${!empty newsList}">
		<div style="color: teal;font-size: 30px">
			The Following News Are Retrieved From Database: 
		</div>
		<br><br>
		<table border="1" bgcolor="black" width="600px">
		<tr style="background-color: teal;color: white;
			text-align: center;" height="40px">
		<td>ID</td>
		<td>Source</td>
		<td>title</td>
		<td>Content</td>
		</tr>
		<c:forEach items="${newsList}" var="news">
			<tr style="background-color:white;color: black;
				text-align: center;" height="30px" >
			<td><c:out value="${news.id}"/></td>
			<td><c:out value="${news.source}"/></td>
			<td><c:out value="${news.title}"/></td>
			<td><c:out value="${news.content}"/></td>
		</c:forEach>
		</table>
		</c:if>
		<br>
		<a href="inputNews" >Click here to input news</a>
		
		</fieldset>

		<br/>

		<fieldset>
		<a href="toDelNews" >Click here to delete news</a>
		</fieldset>	
		</form:form>
	</fieldset>
	</center>	
</body>
</html>