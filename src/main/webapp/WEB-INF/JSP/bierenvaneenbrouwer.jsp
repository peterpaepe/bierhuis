<%@page contentType='text/html' pageEncoding='UTF-8' trimDirectiveWhitespaces="true"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="bierhuis" uri="http://bierhuis.be/tags"%>
<c:set var='contextPath' value='${pageContext.servletContext.contextPath}' />
<!doctype html>
<html lang='nl'>
<head>
<title>Het bierhuis - bieren van een brouwer</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css' />
</head>
<body>
	<bierhuis:menu />
	<h1>${brouwer.naam}&nbsp;(${brouwer.adres.gemeente})</h1>
<!-- 	<div><br></div> -->
	<ul>
		<c:forEach  var='bier' items='${brouwer.bieren}'>
				<c:url value='/bierreservatie.htm' var='urlBierreservatie'>
					<c:param name='bierNr' value='${bier.bierNr}' />
				</c:url>
				<li><a href='${urlBierreservatie}'>${bier.naam} </a></li>			
		</c:forEach>
	</ul>
	<c:import url='/WEB-INF/JSP/fouten.jsp' />
</body>
</html>