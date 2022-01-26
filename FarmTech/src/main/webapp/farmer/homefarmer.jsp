<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Home</title>
    <jsp:include page="../css.jsp" />
</head>
<body id="page-top">
<c:set var="msg" scope="request" value='<%= session.getAttribute("token")%>'>
</c:set>
<c:if test="${fn:contains(msg, '1')}">
<!-- nav option -->
<div id="wrapper">

<jsp:include page="../navbar.jsp" />
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <jsp:include page="../header.jsp" />



            <div class="container-fluid">
                <div class="d-sm-flex justify-content-between align-items-center mb-4">

                </div>
                <div class="row float-none justify-content-center">
                    <div class="col">
                        <img width="1000px" src="img/dashboards.jpg" alt="dashboard"/>
                    </div>
                </div>
            </div>




            <jsp:include page="../footer.jsp" />
        </div>
    </div>
</div>

<jsp:include page="../script.jsp" />

</c:if>
<c:if test="${!fn:contains(msg, '1')}">
    <%
        response.sendRedirect("../login.jsp");
    %>
</c:if>
</body>
</html>
