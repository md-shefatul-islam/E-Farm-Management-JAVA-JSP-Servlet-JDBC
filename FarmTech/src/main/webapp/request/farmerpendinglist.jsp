<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Request</title>
    <jsp:include page="../css.jsp" />
</head>
<body id="page-top">

<!-- nav option -->
<div id="wrapper">

    <jsp:include page="../navbar.jsp" />
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <jsp:include page="../header.jsp" />



            <div class="container-fluid">
                <h3 class="text-dark mb-4">My Request List</h3>
                <div class="text-justify mb-3">

                    <div class="row text-justify">
                        <div class="col text-justify">
                            <div class="card shadow mb-3">

                                <!-- profile picture -->
                                <%--                                <div class="card-body text-center shadow"><img class="rounded-circle mb-3 mt-4" src="{{asset('img/'.$user->picture)}}" width="160" height="160">--%>
                                <%--                                </div>--%>


                                <div class="card-body">
                                    <c:set var="pa" scope="request" value='<%= request.getAttribute("deleteorder")%>'>
                                    </c:set>
                                    <c:if test="${fn:contains(pa, 'success')}">
                                        <p><b>Deleted Successfully...</b></p>
                                    </c:if>


                                    <div class="col-md-4">
                                        <div class="container text-left">

                                            <form action="search" method="get">
                                                <input type="text" class="form-control" name="search"
                                                       placeholder="Search Here..."/>
                                            </form>

                                        </div>
                                    </div>



                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Quantity(KG)</th>
                                            <th>Price(Total)</th>
                                            <th>Date</th>
                                            <th>Type</th>
                                            <th>Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <c:forEach var="order" items='<%= request.getAttribute("order")%>'>
                                            <tr>
                                                <c:set var="username" scope="session" value='<%= session.getAttribute("username")%>' />
                                                <c:if test="${order.buname == username}">
                                                    <c:if test="${order.status.equals('pending')}">

                                                    <td><c:out value="${order.id}"/></td>
                                                    <td><c:out value="${order.name}"/></td>
                                                    <td><c:out value="${order.quantity}"/></td>
                                                    <td><c:out value="${order.price}"/></td>
                                                    <td><c:out value="${order.date}"/></td>
                                                    <td><c:out value="${order.type}"/></td>
                                                    <td>
                                                        <a type="button" class="btn btn-success" style="color: aliceblue" href="<%=request.getContextPath()%>/deleteorder?id=${order.id}">Cancel</a>
                                                            <%--                                                        <c:choose>--%>
                                                            <%--                                                        <c:set var="msg" scope="session" value='<%= session.getAttribute("orderid")%>'>--%>
                                                            <%--                                                        </c:set>--%>
                                                            <%--                                                        <c:choose>--%>
                                                            <%--                                                            <c:when test="${msg.equals(allcrop.id)}">--%>
                                                            <%--                                                                <c:choose>--%>
                                                            <%--                                                                    <c:when test="${cookie.name.value == 'close'}">--%>


                                                            <%--                                                                        <a type="button" class="btn btn-success" style="color: aliceblue" href="<%=request.getContextPath()%>/orderseed?id=${allcrop.id}">Edit</a>--%>
                                                            <%--                                                                        <a type="button" class="btn btn-success" style="color: aliceblue" href="<%=request.getContextPath()%>/deleteseedorder?id=${allcrop.id}">Delete</a>--%>
                                                            <%--                                                                    </c:when>--%>
                                                            <%--                                                                    <c:otherwise>--%>
                                                            <%--                                                                        <a type="button" class="btn btn-success" style="color: aliceblue" href="<%=request.getContextPath()%>/orderseed?id=${allcrop.id}">Order</a>--%>
                                                            <%--                                                                    </c:otherwise>--%>
                                                            <%--                                                                </c:choose>--%>
                                                            <%--                                                            </c:when>--%>
                                                            <%--                                                            <c:otherwise>--%>

                                                            <%--                                                                <a type="button" class="btn btn-success" style="color: aliceblue" href="<%=request.getContextPath()%>/ordercrop?id=${allcrop.id}">Order</a>--%>

                                                            <%--                                                            </c:otherwise>--%>
                                                            <%--                                                        </c:choose>--%>


                                                    </td>
                                                </c:if>
                                                </c:if>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <div class="form-group">
                                        <a class="btn btn-primary btn-sm" type="button" href="<%=request.getContextPath()%>/home">Back</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>




            <jsp:include page="../footer.jsp" />
        </div>
    </div>
</div>

<jsp:include page="../script.jsp" />
</body>
</html>
