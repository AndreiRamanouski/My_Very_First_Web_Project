<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List" import="by.htp.project1.bean.News"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>First</title>
<link rel="stylesheet" href="style.css">
<style>
.p{
text-align:left;
}
</style>

<fmt:setLocale value="${sessionScope.local }" />
<fmt:setBundle basename="localization.local_ru" var="loc" />

<fmt:message bundle="${loc}" key="local.message" var="hello"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button"/>

<fmt:message bundle="${loc}" key="registration" var="registration" />
<fmt:message bundle="${loc}" key="logination" var="logination" />


</head>
	<body class='body'>
	
<c:out value = "${hello }"/>
<form  action="Controller" method="post">
	<input type="hidden" name="local" value="ru">
	<input type="hidden" name="commandLocalization" value="command=GOTOMAINPAGE" />
	<input type="submit" value="${ru_button}" /> <br/>
</form>
<form action="Controller" method="post">
	<input type="hidden" name="local" value="en">
	<input type="hidden" name="commandLocalization" value="command=GOTOMAINPAGE" />
	<input type="submit" value="${en_button}" /> <br/>
</form>
	
	
 <header>
 	
	<p class="p"><a href="Controller?command=registration"> <c:out value="${registration}"/></a> 
	 <a href="Controller?command=loginationPage"> <c:out value="${logination}"/></a>
	</p>
	
	<font color="green" >	
		<c:out value="${param.message}"></c:out>
	</font>
	
	
	
	<div class = 'news'>
		<c:forEach var="n" items="${requestScope.news }">
			<tr>
				<td>
					<h2>
					<c:out value="${n.title }" /> 
					<br />
					</h2>
					<h5 align="left" style="font-family:Arial, Verdana, sans-serif">
					<c:out value="${n.brief }" />
					</h5>
				</td>
			</tr>
		</c:forEach>
	</div>
	
</header>


</body>
</html>