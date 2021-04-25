<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<style>
.formaregistration{
	padding-top:15px;
	padding-bottom:20px;
	box-shadow: 4px 4px 4px 5px rgba(0, 0, 128, .4);
	font-size:12px;
	margin-top:5px;
	margin-left:5px;
	
	width:150px;
	height:200px;
}
</style>
 <link rel="stylesheet" href="style.css">
<meta charset="utf-8">
<title>Registration</title>

<fmt:setLocale value="${sessionScope.local }" />
<fmt:setBundle basename="localization.local_ru" var="loc" />

<fmt:message bundle="${loc}" key="local.message" var="hello"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button"/>

<fmt:message bundle="${loc}" key="enter.login" var="EnterLogin"/>
<fmt:message bundle="${loc}" key="enter.password" var="EnterPassword"/>
<fmt:message bundle="${loc}" key="enter.name" var="enterName"/>
<fmt:message bundle="${loc}" key="enter.surname" var="enterSurname"/>


</head>
<body class='body'>

<c:out value = "${hello }"/>
<form  action="Controller" method="post">
	<input type="hidden" name="local" value="ru">
	<input type="hidden" name="commandLocalization" value="command=REGISTRATION" />
	<input type="submit" value="${ru_button}" /> <br/>
</form>
<form action="Controller" method="post">
	<input type="hidden" name="local" value="en">
	<input type="hidden" name="commandLocalization" value="command=REGISTRATION" />
	<input type="submit" value="${en_button}" /> <br/>
</form>
	
 <header >

	
	<form class='formaregistration' action="Controller" method="post">
	<input class='input' type="hidden" name='command' value="savenewuser">
	<c:out value="${EnterLogin }"/><br />
	<input class='input' type='text' name="login" value='' /> <br />
	<c:out value="${EnterPassword }"/><br />
	<input class='input' type='text' name='password' value="" /> <br />
	<c:out value="${enterName }"/><br />
	<input class='input' type='text' name='name' value="" /> <br />
	<c:out value="${enterSurname }"/><br />
	<input class='input' type='text' name='surname' value="" /> <br />
	<input class='input-words' type='submit' value="Registrate" /> <br />
	<br />
	<br />
	<br />
	
	</form>

	
	
	
</header>
</body>
</html>