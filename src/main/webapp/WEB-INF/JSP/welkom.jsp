<%@page contentType='text/html' pageEncoding='UTF-8' trimDirectiveWhitespaces="true"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="bierhuis" uri="http://bierhuis.be/tags"%>
<c:set var='contextPath' value='${pageContext.servletContext.contextPath}' />
<!doctype html>
<html lang='nl'>
<head>
<title>Het bierhuis - welkom</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css' />
</head>
<body>
	<bierhuis:menu />
	<h1>Welkom in het huis van de Belgische bieren</h1>
	<img src='${contextPath}/images/bierhuis.jpg' title='bierhuis' alt='bierhuis'/>
	<div><br></div>
	<div>We hebben momenteel ${aantalbieren} bieren</div>
</body>
</html>