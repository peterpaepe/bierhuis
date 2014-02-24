<%@page contentType='text/html' pageEncoding='UTF-8' trimDirectiveWhitespaces="true"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="bierhuis" uri="http://bierhuis.be/tags"%>
<c:set var='contextPath' value='${pageContext.servletContext.contextPath}' />
<!doctype html>
<html lang='nl'>
<head>
<title>Het bierhuis - brouwers</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css' />
</head>
<body>
	<bierhuis:menu />
	<h1>Brouwers</h1>
	<ul>
		<c:forEach  var='brouwer' items='${brouwers}'>
				<c:url value='/bierenvaneenbrouwer.htm' var='urlBiervaneenbrouwer'>
					<c:param name='brouwerNr' value='${brouwer.brouwerNr}' />
				</c:url>
				<li><a href='${urlBiervaneenbrouwer}'>${brouwer.naam}&nbsp;(${brouwer.gemeente})</a></li>
		</c:forEach>
	</ul>
</body>
</html>