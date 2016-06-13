<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="shared/header.jsp"%>
<jsp:useBean id="compDAO" class="com.navin.hellosarkar.dao.impl.ComplainDAOImpl"/>
<jsp:useBean id="comp" class="com.navin.hellosarkar.entity.Complain"/>


<c:forEach var="complain" items="${compDAO.all}">
    <H1>${complain.title}</H1>
    <p>${complain.description}</p>
    <div class="form-group">
        <a href="readmore.jsp?id=${complain.clientId}">Read More</a>
    </div>
</c:forEach>
