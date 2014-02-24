<%@ page contentType='text/html' pageEncoding='UTF-8' 
	trimDirectiveWhitespaces="true"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="bierhuis" uri="http://bierhuis.be/tags"%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<c:set var='contextPath' value='${pageContext.servletContext.contextPath}' />
<!doctype html>
<html lang='nl'>
<head>
<title>Het bierhuis - bierreservatie</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css' />
</head>
<body>
	<bierhuis:menu />
	<h1>${bier.naam}</h1>
	<dl>
		<dt>Alcohol</dt>
		<dd id="content"><fmt:formatNumber value='${bier.alcohol}' type="number" minFractionDigits="2" maxFractionDigits="2"/> %</dd>
		<dt>Prijs</dt>
		<dd id="content"><fmt:formatNumber value='${bier.prijs}' type="number" minFractionDigits="2" maxFractionDigits="2"/> &euro;</dd>		
		<dt>Soort</dt>
		<dd id="content">${bier.soort.naam}</dd>
		<dt>Brouwer</dt>
		<dd id="content">${bier.brouwer.naam}</dd>
	</dl>

	<c:url value='/bierreservatie.htm' var='url' >
		<c:param name='bierNr' value='${bier.bierNr}' />
	</c:url>			
	<form method='post' action='${url}' id='winkelwagenform'>
		<label>Aantal bakken<span class='fout'>${fouten}</span>
			<input name='aantalBakken' value='${aantalBakken}' autofocus type='number' class='numbers' autofocus>
		</label> 
		<input type='submit' value='Toevoegen' name='toevoegenknop'>
	</form>
	<script>
		document.getElementById('winkelwagenform').onsubmit = function() {
			document.getElementById('toevoegenknop').disabled = true;
		};
	</script>
<%-- 	<c:import url='/WEB-INF/JSP/fouten.jsp' /> --%>
</body>
</html>