<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Home</title>
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
                <h3 class="text-dark mb-4">My Crop List</h3>
                <div class="text-justify mb-3">

                    <div class="row text-justify">
                        <div class="col text-justify">
                            <div class="card shadow mb-3">

                                <!-- profile picture -->
                                <%--                                <div class="card-body text-center shadow"><img class="rounded-circle mb-3 mt-4" src="{{asset('img/'.$user->picture)}}" width="160" height="160">--%>
                                <%--                                </div>--%>


                                <div class="card-body">
                                    <c:set var="pa" scope="request" value='<%= request.getAttribute("delete")%>'>
                                    </c:set>
                                    <c:if test="${fn:contains(pa, 'success')}">
                                        <p><b>Deleted Successfully...Try New One...</b></p>
                                    </c:if>

                                    <c:set var="pas" scope="request" value='${cookie.orderinsert.value}'>
                                    </c:set>
                                    <c:if test="${fn:contains(pas, 'success')}">
                                        <p><b>Order Placed Successfully</b></p>
                                    </c:if>

                                    <c:set var="pas" scope="request" value='<%= request.getAttribute("orderinsert")%>'>
                                    </c:set>
                                    <c:if test="${fn:contains(pas, 'failed')}">
                                        <p><b>Order Place Failed...Try Again...</b></p>
                                    </c:if>
                                    <c:if test="${fn:contains(pas, 'update')}">
                                        <p><b>Order Place Failed...Try Again in Update...</b></p>
                                    </c:if>


                                    <c:set var="pa" scope="request" value='${cookie.alert.value}'>
                                    </c:set>
                                    <c:if test="${fn:contains(pa, 'alert')}">
                                        <p><b>You have only 1 min to edit or cancel placed order......</b></p>
                                    </c:if>

                                    <c:set var="passs" scope="request" value='<%= request.getAttribute("search")%>'>
                                    </c:set>
                                    <c:if test="${fn:contains(passs, 'failed')}">
                                        <p><b>No Data Matched...Try Again...</b></p>
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
                                            <th>Description</th>
                                            <th>Quantity(KG)</th>
                                            <th>Price(TK per KG)</th>
                                            <th>Date</th>
                                            <th>Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <c:forEach var="allcrop" items='<%= request.getAttribute("allcrop")%>'>
                                            <tr>
                                                <c:set var="username" scope="session" value='<%= session.getAttribute("username")%>' />
                                                <c:if test="${allcrop.funame != username}">

                                                    <td><c:out value="${allcrop.id}"/></td>
                                                    <td><c:out value="${allcrop.name}"/></td>
                                                    <td><c:out value="${allcrop.description}"/></td>
                                                    <td><c:out value="${allcrop.quantity}"/></td>
                                                    <td><c:out value="${allcrop.price}"/></td>
                                                    <td><c:out value="${allcrop.date}"/></td>
                                                    <td>
                                                        <c:set var="msg" scope="session" value='<%= session.getAttribute("orderid")%>'>
                                                        </c:set>
                                                        <c:choose>
                                                            <c:when test="${msg.equals(allcrop.id)}">
                                                                <c:choose>
                                                                    <c:when test="${cookie.name.value == 'close'}">


                                                                        <a type="button" class="btn btn-success" style="color: aliceblue" href="<%=request.getContextPath()%>/ordercrop?id=${allcrop.id}">Edit</a>
                                                                        <a type="button" class="btn btn-success" style="color: aliceblue" href="<%=request.getContextPath()%>/deletecroporder?id=${allcrop.id}">Delete</a>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <a type="button" class="btn btn-success" style="color: aliceblue" href="<%=request.getContextPath()%>/ordercrop?id=${allcrop.id}">Order</a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:when>
                                                            <c:otherwise>

                                                                <a type="button" class="btn btn-success" style="color: aliceblue" href="<%=request.getContextPath()%>/ordercrop?id=${allcrop.id}">Order</a>

                                                            </c:otherwise>
                                                        </c:choose>


                                                    </td>
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
