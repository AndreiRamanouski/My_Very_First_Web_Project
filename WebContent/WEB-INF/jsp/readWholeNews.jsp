<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List" import="by.htp.project1.bean.News"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>You are reading the news</title>
<link rel="stylesheet" href="style.css">

<fmt:setLocale value="${sessionScope.local }" />
<fmt:setBundle basename="localization.local_ru" var="loc" />

<fmt:message bundle="${loc}" key="local.message" var="hello"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button"/>

<fmt:message bundle="${loc}" key="logout" var="Logout"/>
<fmt:message bundle="${loc}" key="back" var="Back"/>
<fmt:message bundle="${loc}" key="edit" var="Edit"/>

</head>
<body class="body">

<c:out value = "${hello }"/>
<form  action="Controller" method="post">
	<input type="hidden" name="local" value="ru">
	<input type="hidden" name="commandLocalization" value="command=READWHOLENEWS" />
	<input type="submit" value="${ru_button}" /> <br/>
</form>
<form action="Controller" method="post">
	<input type="hidden" name="local" value="en">
	<input type="hidden" name="commandLocalization" value="command=READWHOLENEWS" />
	<input type="submit" value="${en_button}" /> <br/>
</form>
	
 <a href="Controller?command=logout"><p align="left"><c:out value="${Logout }"/></p></a>

  
  
  <div class = 'news'>
	<c:set var="news" value="${requestScope.news}"/>
	
		<tr>
			<td>
				<p align="right">
				<c:out value="${news.date }" />
				</p>
				<h2>
				<c:out value="${news.title }" /> 
				<br />
				</h2>
				
				<h5 align="left" style="font-family:Arial, Verdana, sans-serif">
				<c:out value="${news.brief }" /> <br/>
				<c:out value="${news.content }" />
				
				<c:if test="${sessionScope.role eq \"admin\" }" >
				<a href="Controller?command=edit&newsaction=${news.id }"><c:out value="${Edit }"/></a>
				</c:if>
			
				 
				</h5>
				<a href="Controller?command=gotomainpage" align="center"><c:out value="${Back }"/></a>
			</td>
		</tr>
		
	
	</div>
</body>
</html>