<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
  		<li><a href="search.html">Search</a></li>
	</ul>
   <table align="center" >
	    <tr>
	        <td>Search:</td>	        
	        <td><core:out value="${search.searchValue}" /></td>
	    </tr>
	    <tr>
	        <td>Filter:</td>	        
	        <td><core:out value="${search.filterValue}" /></td>
	    </tr>   	       
  </table>
  <table border="1">
   	<tr>
		<th>Address</th>
		<th>companyInfo</th>
		<th>companyReviews</th>	
		<th>eniroId</th>	
		<th>homepage</th>	
		<th>infoPageLink</th>	
		<th>location</th>	
	</tr>
  <core:forEach items="${result.adverts}" var="adverts"> 
	  <tr>
	    <td>${adverts.address}</td>
	    <td>${adverts.companyInfo}</td>
	    <td>${adverts.companyReviews}</td>
	    <td>${adverts.eniroId}</td>
	   	<td>${adverts.homepage}</td>
	    <td>${adverts.infoPageLink}</td>
        <td>${adverts.location}</td>
	  </tr>
  </core:forEach> 
  </table>
</body>
</html>