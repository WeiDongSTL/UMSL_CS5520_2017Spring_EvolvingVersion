<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<center>
<h1>Project Name: ­ Power News Management System</h1>
<%--
<h4>Author: Kane, Alexander; Gurung, Gyan; Walker, Joel; Belton, Dillon; Stephen, Benjamin; szunrai@gmail.com; Dong, Wei</h4>
<p>
Welcome to the <b>Spring Boot-MVC-JPA-PostgreSQL-Maven Application!</b><br/>
</p>
 --%>
<h3>Course: UMSL CS5520-2017-Spring</h3>
	<fieldset>
		<form:form id="saveForm" modelAttribute="news" 
			action="saveNews" method="POST">
		<br/>
		<form:input path="id" placeholder="Input id"></form:input>
		<form:input path="source" placeholder="Input source"></form:input>
		<form:input path="title" placeholder="Input title"></form:input>
		<form:input path="content" placeholder="Input content"></form:input>
		<input type="submit" value="Save"></input>
		<br/><br/>
		<br>

		<fieldset>

		<c:if test="${(!empty news) and (news.id ne 0)}">
		<div style="color: teal;font-size: 30px">
			The Following News Just Saved Into Database:
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
		<tr style="background-color:white;color: black;
			text-align: center;" height="30px" >
		<td><c:out value="${news.id}"/></td>
		<td><c:out value="${news.source}"/></td>
		<td><c:out value="${news.title}"/></td>
		<td><c:out value="${news.content}"/></td>
		</tr>
		</table>
		</c:if>
		<br>
		<a href="showSavedNews" >Click here to load saved news</a>
		
		</fieldset>
		

		</form:form>
	</fieldset>
	</center>	
</body>
</html>
