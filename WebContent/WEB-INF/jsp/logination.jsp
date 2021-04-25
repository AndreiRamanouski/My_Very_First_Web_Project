<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Logination Page</title>
<link rel="stylesheet" href="style.css">

<fmt:setLocale value="${sessionScope.local }" />
<fmt:setBundle basename="localization.local_ru" var="loc" />

<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button" />
<fmt:message bundle="${loc}" key="enter.login" var="EnterLogin" />
<fmt:message bundle="${loc}" key="enter.password" var="EnterPassword" />
</head>
<body class='body'>

<c:out value = "${hello }"/>
<form  action="Controller" method="post">
	<input type="hidden" name="local" value="ru">
	<input type="hidden" name="commandLocalization" value="command=LOGINATIONPAGE" />
	<input type="submit" value="${ru_button}" /> <br/>
</form>
<form action="Controller" method="post">
	<input type="hidden" name="local" value="en">
	<input type="hidden" name="commandLocalization" value="command=LOGINATIONPAGE" />
	<input type="submit" value="${en_button}" /> <br/>
</form>
	
 <header>
	<form class='forma' action="Controller" method="post">
		<input class='input' type="hidden" name='command' value="logination">
			<c:out value="${EnterLogin }"/><br />
		<input class='input' type='text' name="login" value='' /> <br />
			<c:out value="${EnterPassword }"/><br />
		<input class='input' type='password' name='password' value="" /> <br />
		<input class='input-words' type='submit' value="Отправить" /> <br />
		<br />
	</form>
</header>


</body>
</html>