<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.List" import="by.htp.project1.bean.News"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>You are about to change the news</title>
<link rel="stylesheet" href="style.css">
<style>
.title{
align:right;
width:700px;
height:20px;
}
.brief{
width:700px;
height:50px;
}
.content{
width:700px;
height:250px;
}
</style>

<fmt:setLocale value="${sessionScope.local }" />
<fmt:setBundle basename="localization.local_ru" var="loc" />

<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button" />
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button" />

<fmt:message bundle="${loc}" key="logout" var="Logout" />
<fmt:message bundle="${loc}" key="back" var="Back" />
<fmt:message bundle="${loc}" key="Change.title" var="ChangeTitle" />
<fmt:message bundle="${loc}" key="Change.brief" var="ChangeBrief" />
<fmt:message bundle="${loc}" key="Change.content" var="ChangeContent" />


</head>
<body class="body">

<c:out value = "${hello }"/>
<form  action="Controller" method="post">
	<input type="hidden" name="local" value="ru">
	<input type="hidden" name="commandLocalization" value="command=EDIT" />
	<input type="submit" value="${ru_button}" /> <br/>
</form>
<form action="Controller" method="post">
	<input type="hidden" name="local" value="en">
	<input type="hidden" name="commandLocalization" value="command=EDIT" />
	<input type="submit" value="${en_button}" /> <br/>
</form>

<p align="left">
 <a href="Controller?command=logout"><c:out value="${Logout}" /></a>
<a href="Controller?command=gotomainpage" ><c:out value="${Back}" /></a>
  </p>
  
  <div class = 'news'>
	<c:set var="news" value="${requestScope.news}"/>
	
	<form action="Controller" method="get">
		<input  type="hidden" name='command' value="newsUpdate">
		<input  type="hidden" name='newsaction' value="${news.id }">
			<c:out value="${ChangeTitle}"/><br />
		<input class="title"  type='text' name="title" value="${news.title }"/> <br />
			<c:out value="${ChangeBrief}"/><br />
				<textarea class="brief" name="brief">${news.brief }</textarea><br />
					<c:out value="${ChangeContent}"/><br />
				<textarea class="content" name="content">${news.content }</textarea><br />
		<input  type='submit' value="Отправить" /> <br />
		<br />
	
	</form>
		

	</div>
</body>
</html>