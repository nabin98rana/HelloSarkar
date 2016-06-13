<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="shared/header.jsp" %>
<jsp:useBean id="compDAO" class="com.navin.hellosarkar.dao.impl.ComplainDAOImpl"/>
<jsp:useBean id="clientDAO" class="com.navin.hellosarkar.dao.impl.ClientDAOImpl"/>
<jsp:useBean id="client" class="com.navin.hellosarkar.entity.Client"/>
<jsp:useBean id="complain" class="com.navin.hellosarkar.entity.Complain"/>

<c:forEach var="complain" items="${compDAO.all}">
    
    <h1>${complain.title}</h1>
    <p>${complain.description}</p>
   
    <h1><a class="readmore.jsp?id=${complain.id}"></a></h1>
 
</c:forEach>
<%@include file="shared/footer.jsp" %>
