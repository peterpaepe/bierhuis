<%@ tag description="website menu" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var='contextPath'
	value='${pageContext.servletContext.contextPath}' />
<header>
	<nav>
		<span> 
			<c:url value='/welkom.htm' var='welkomURL' /> 
				<a href='${welkomURL}'>Welkom</a>&nbsp;
			
			<c:url value='/brouwers.htm' var='brouwersURL' />
				<a href='${brouwersURL}'>Bieren van een brouwer</a>
				
			<c:if test="${not empty winkelwagen}">
				<c:url value='/winkelwagen.htm' var='winkelwagenURL' />
					&nbsp;<a href='${winkelwagenURL}'>Winkelwagen</a>
			</c:if>
		</span>
	</nav>
</header>
