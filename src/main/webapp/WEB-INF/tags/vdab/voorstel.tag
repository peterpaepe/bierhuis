<%@ tag description='aantal voor- en tegenstanders van een voorstel'
	pageEncoding='UTF-8'%>
<%@ attribute name='omschrijving' required='true' type='java.lang.String'%>
<%@ attribute name='voor' required='true' type='java.lang.Integer'%>
<%@ attribute name='tegen' required='true' type='java.lang.Integer'%>
<div>${omschrijving} Voor:${voor}, tegen:${tegen}</div>
