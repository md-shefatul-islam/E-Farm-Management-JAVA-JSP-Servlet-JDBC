<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Profile</title>
    <jsp:include page="css.jsp" />
</head>
<body id="page-top">

<!-- nav option -->
<div id="wrapper">

    <jsp:include page="navbar.jsp" />
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
            <jsp:include page="/header.jsp" />




            <div class="container-fluid">
                <h3 class="text-dark mb-4">Profile</h3>

                <%--                @if (session()->has('msg'))--%>
                <%--                {{session('msg')}}--%>
                <%--                @endif--%>

                <div class="text-justify mb-3">

                    <div class="row text-justify">
                        <div class="col text-justify">
                            <div class="card shadow mb-3">

                                <!-- profile picture -->
                                <%--                                <div class="card-body text-center shadow"><img class="rounded-circle mb-3 mt-4" src="{{asset('img/'.$user->picture)}}" width="160" height="160">--%>
                                <%--                                </div>--%>


                                <div class="card-body">

<%--                                    <c:forEach var="user" items='<%= request.getAttribute("user")%>'>--%>
                                    <c:set var="user" scope="request" value='<%= request.getAttribute("user")%>'>
                                    </c:set>
<%--                                    </c:forEach>--%>

                                    <div class="form-row">
                                        <div class="col">
                                            <div class="form-group">
                                                <label for="username">
                                                    <strong>User Name</strong>
                                                </label>
                                                <input class="form-control" type="text" id="username" placeholder="Enter UserName" name="username" value="${user.uname}" readonly>
                                            </div>
                                        </div>
                                    </div>

                                    <%--                                    <div class="form-row">--%>
                                    <%--                                        <div class="col">--%>
                                    <%--                                            <div class="form-group">--%>
                                    <%--                                                <label for="name">--%>
                                    <%--                                                    <strong>Name</strong>--%>
                                    <%--                                                </label>--%>
                                    <%--                                                <input class="form-control" type="text" id="name" placeholder="Enter Full Name" name="name" value="${farmer.name}" readonly></div>--%>
                                    <%--                                        </div>--%>
                                    <%--                                    </div>--%>


                                    <%--                                    <div class="form-row">--%>
                                    <%--                                        <div class="col">--%>
                                    <%--                                            <div class="form-group">--%>
                                    <%--                                                <label for="email">--%>
                                    <%--                                                    <strong>Email</strong><br>--%>
                                    <%--                                                </label>--%>
                                    <%--                                                <input class="form-control" type="email" id="email" placeholder="Enter Email" name="email" value="${farmer.email}" readonly></div>--%>
                                    <%--                                        </div>--%>
                                    <%--                                    </div>--%>
                                    <%--                                    <div class="form-row">--%>
                                    <%--                                        <div class="col">--%>
                                    <%--                                            <div class="form-group">--%>
                                    <%--                                                <label for="phone">--%>
                                    <%--                                                    <strong>Phone</strong>--%>
                                    <%--                                                </label>--%>
                                    <%--                                                <input class="form-control" type="text" id="phone" placeholder="Enter Phone" name="phone" value="${farmer.phone}" readonly></div>--%>
                                    <%--                                        </div>--%>
                                    <%--                                    </div>--%>

                                    <%--                                    <div class="form-row">--%>
                                    <%--                                        <div class="col">--%>
                                    <%--                                            <div class="form-group">--%>
                                    <%--                                                <label for="city">--%>
                                    <%--                                                    <strong>City</strong>--%>
                                    <%--                                                </label>--%>
                                    <%--                                                <input class="form-control" type="text" id="city" placeholder="Enter City" name="city" value="${farmer.city}" readonly></div>--%>
                                    <%--                                        </div>--%>
                                    <%--                                    </div>--%>
                                    <%--                                    <div class="form-row">--%>
                                    <%--                                        <div class="col">--%>
                                    <%--                                            <div class="form-group">--%>
                                    <%--                                                <label for="password">--%>
                                    <%--                                                    <strong>Password</strong>--%>
                                    <%--                                                </label>--%>
                                    <%--                                                <input class="form-control" type="password" id="password" placeholder="Enter Password" name="password" value="${farmer.password}" readonly></div>--%>
                                    <%--                                        </div>--%>
                                    <%--                                    </div>--%>

                                    <%--                                    <div class="form-row">--%>
                                    <%--                                        <div class="col">--%>
                                    <%--                                            <div class="form-group">--%>
                                    <%--                                                <label for="gender">--%>
                                    <%--                                                    <strong>gender</strong>--%>
                                    <%--                                                </label>--%>
                                    <%--                                                <input class="form-control" type="text" id="gender" placeholder="Enter gender" name="gender" value="${farmer.gender}" readonly></div>--%>
                                    <%--                                        </div>--%>
                                    <%--                                    </div>--%>
                                    <%--                                    <div class="form-row">--%>
                                    <%--                                        <div class="col">--%>
                                    <%--                                            <div class="form-group">--%>
                                    <%--                                                <label for="dob">--%>
                                    <%--                                                    <strong>Date of Birth</strong>--%>
                                    <%--                                                </label>--%>
                                    <%--                                                <input class="form-control" type="password" id="dob" placeholder="Enter Date of Birth" name="dob" value="${farmer.dob}" readonly></div>--%>
                                    <%--                                        </div>--%>
                                    <%--                                    </div>--%>

                                    <div class="form-group">
                                        <a href="">
                                            <button class="btn btn-primary btn-sm" type="submit">Edit</button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>





            <jsp:include page="footer.jsp" />
        </div>
    </div>
</div>

<jsp:include page="script.jsp" />
</body>
</html>
