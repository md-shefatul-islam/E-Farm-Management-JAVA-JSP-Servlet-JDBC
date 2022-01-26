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
                                    <c:set var="pass" scope="request" value='<%= request.getAttribute("cropedit")%>'>
                                    </c:set>
                                    <c:if test="${fn:contains(pass, 'success')}">
                                        <p>Updated <b>Sucessfully</b></p>
                                    </c:if>

                                    <c:set var="pass" scope="request" value='<%= request.getAttribute("deletecrop")%>'>
                                    </c:set>
                                    <c:if test="${fn:contains(pass, 'success')}">
                                        <p><b>Deleted Successfully</b></p>
                                    </c:if>
                                    <c:if test="${fn:contains(pass, 'failed')}">
                                        <p><b>Delete Failed...Try Again...</b></p>
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
                                                <c:if test="${allcrop.funame == username}">

                                                    <td><c:out value="${allcrop.id}"/></td>
                                                    <td><c:out value="${allcrop.name}"/></td>
                                                    <td><c:out value="${allcrop.description}"/></td>
                                                    <td><c:out value="${allcrop.quantity}"/></td>
                                                    <td><c:out value="${allcrop.price}"/></td>
                                                    <td><c:out value="${allcrop.date}"/></td>
                                                    <td>
                                                        <button class="btn btn-success">
                                                            <a style="color: aliceblue" href="<%=request.getContextPath()%>/editcrop?id=${allcrop.id}">Edit</a>
                                                        </button>
                                                        ||
                                                        <button class="btn btn-danger">
                                                            <a style="color: aliceblue" href="<%=request.getContextPath()%>/deletecrop?id=${allcrop.id}">Delete</a>
                                                        </button>
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
