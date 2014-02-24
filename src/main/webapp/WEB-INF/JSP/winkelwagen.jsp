<%@page contentType='text/html' pageEncoding='UTF-8' trimDirectiveWhitespaces="true"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix="bierhuis" uri="http://bierhuis.be/tags"%>
<c:set var='contextPath' value='${pageContext.servletContext.contextPath}' />
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang='nl'>
<head>
<title>Het bierhuis - winkelwagen</title>
<link rel='stylesheet' href='${contextPath}/styles/default.css' />
</head>
<body>
	<bierhuis:menu />
	<h1>Winkelwagen</h1>
	<table class='zebra' title="bestellingen" summary="bestellingen"
	id="bestellingen">
	<thead>
		<tr>
			<th title="Bier">Bier</th>
			<th title="Prijs">Prijs</th>
			<th title="Aantal">Aantal</th>
			<th title="Te betalen">Te betalen</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var='bestelbonlijn' items='${bestelbon.bestelbonlijnen}' >
			<tr>
				<td>${bestelbonlijn.bier.naam}</td>
				<td class='number'><fmt:formatNumber value='${bestelbonlijn.bier.prijs}' type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
				<td class='number'><fmt:formatNumber value='${bestelbonlijn.aantal}' type="number" minFractionDigits="0" maxFractionDigits="0"/></td>
				<td class='number'><fmt:formatNumber value='${bestelbonlijn.totalBestelbonlijn}' type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" class='number'>Totaal: <fmt:formatNumber value='${bestelbon.totalPrice}' type="number" minFractionDigits="2" maxFractionDigits="2"/></td>
		</tr>
	</tbody>
	</table>
	<br>	
	<c:url value='/winkelwagen.htm' var='action' />
	<form method='post' action='${action}' id='winkelwagenform' >
		<label>Naam <span class='fout'>${fouten.naam}</span><br/>
		<input name='naam' value='${bestelbon.naam}' autofocus type="text" maxlength="50"/></label>
		<label>Straat <span class='fout'>${fouten.straat}</span><br/>
		<input name='straat' value='${bestelbon.adres.straat}' type="text" maxlength="50"/></label>
		<label>Huisnummer <span class='fout'>${fouten.huisnr}</span><br/>
		<input name='huisnr' value='${bestelbon.adres.huisNr}'  type="text" maxlength="50"/></label>
		<label>Postcode <span class='fout'>${fouten.postcode}</span><br/>
		<input name='postcode' value='${bestelbon.adres.postcode}' type="number" maxlength="4"/></label>
		<label>Gemeente <span class='fout'>${fouten.gemeente}</span><br/>
		<input name='gemeente' value='${bestelbon.adres.gemeente}' type="text" maxlength="50"/></label>
		<br>
		<input type='submit' value="Als bestelbon bevestigen" id='bestelbonbevestigenknop' />
	</form>
		<script>
		document.getElementById('winkelwagenform').onsubmit = function() {
			document.getElementById('bestelbonbevestigenknop').disabled = true;
		};
	</script>
</body>
</html>