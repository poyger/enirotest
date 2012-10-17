<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>        
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
  <form:form action="result.html" commandName="search"  >
   <table align="center" >
		<tr>
			<td>Search</td>
			<td><form:input path="searchValue" /></td>
		</tr>
		<tr>
			<td>Filter</td>
			<td><form:input path="filterValue" /></td>
		</tr>		
		<tr>
			<td></td>
			<td><input type="submit" value="Search" /></td>
		</tr>
	</table>
  </form:form> 
   <table align="center"  >
   	<tr>
		<th>History Search</th>
		<th>History Filter</th>
	</tr>
  <core:forEach items="${historySearches}" var="historySearches"> 
	  <tr>
	    <td>${historySearches.searchValue}</td>
	    <td>${historySearches.filterValue}</td>
	  </tr>
  </core:forEach>   
  
</body>
</html>