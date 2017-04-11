<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<html>
<head>
    <title>Search News</title>

<style> 
input[type=search] {
    width: 250px;
    box-sizing: border-box;
    border: 2px solid teal;
    border-radius: 2px;
    font-size: 16px;
    background-color: white;
    background-image: url('/search-icon-png-18.png');
    background-position: left top; 
    background-repeat: no-repeat;
    padding: 8px 10px 8px 10px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
}

input[type=search]:focus {
    width: 80%;
}
</style>
</head>
<body>
	<center>
		<fieldset>
			<h1>Project Name: ­ Power News Management System</h1>
			<h3>Course: UMSL CS5520-2017-Spring</h3>
			<h2>Search News Pages</h2>

			  	<s:form id="searchNews" modelAttribute="search"
					  action="https://www.google.com/search" method="GET">
				<br/> <br/> <br/> 
				<input type="search" name="q" required autofocus placeholder="    input key word(s) here" >
				<select id="searchEngines">
					<option value="Google" selected>Google</option>
					<option value="Bing">Bing</option>
					<option value="Yahoo">Yahoo</option>
					<option value="Baidu">Baidu</option>
				</select>
				<input type="submit" value="search" />
		  		</s:form>
      	</fieldset>
		<br/>
		<fieldset>
		<a href="showSavedNews" >Click here to load saved news</a>
		</fieldset>
	</center>
</body>
</html>