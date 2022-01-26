<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Edit Profile</title>
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
                <h3 class="text-dark mb-4">Edit Profile</h3>

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

                                    <c:set var="pass" scope="request" value='<%= request.getAttribute("update")%>'></c:set>

                                    <c:if test="${fn:contains(pass, 'success')}">
                                        <p>Updated <b>Successfully</b></p>
                                    </c:if>
                                    <c:if test="${fn:contains(pass, 'failed')}">
                                        <p>Update <b>Failed... Try Again</b></p>
                                    </c:if>

                                    <form action="editprofile" method="post">

                                        <c:set var="farmer" scope="request" value='<%= request.getAttribute("user")%>'>
                                        </c:set>

                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="username">
                                                        <strong>User Name</strong>
                                                    </label>
                                                    <input class="form-control" type="text" id="username" placeholder="Enter UserName" name="username" value="${farmer.uname}">
                                                </div>
                                            </div>

                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="name">
                                                        <strong>Name</strong>
                                                    </label>
                                                    <input class="form-control" type="text" id="name" placeholder="Enter Full Name" name="name" value="${farmer.name}">
                                                </div>
                                            </div>
                                        </div>


                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="email">
                                                        <strong>Email</strong><br>
                                                    </label>
                                                    <input class="form-control" type="email" id="email" placeholder="Enter Email" name="email" value="${farmer.email}">
                                                </div>
                                            </div>

                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="phone">
                                                        <strong>Phone</strong>
                                                    </label>
                                                    <input class="form-control" type="text" id="phone" placeholder="Enter Phone" name="phone" value="${farmer.phone}">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="city">
                                                        <strong>City</strong>
                                                    </label>
                                                    <input class="form-control" type="text" id="city" placeholder="Enter City" name="city" value="${farmer.city}"></div>
                                            </div>

                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="password">
                                                        <strong>Password</strong>
                                                    </label>
                                                    <input class="form-control" type="text" id="password" placeholder="Enter Password" name="password" value="${farmer.password}">
                                                </div>
                                            </div>
                                        </div>


                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-check">
                                                    <label>
                                                         <strong>gender</strong>
                                                     </label>
                                                     <div>
                                                         <input class="form-check-label" type="radio" name="gender" value="Male" required <c:if test="${farmer.gender == 'Male'}">
                                                             <c:out value="checked"/>
                                                         </c:if>>Male

                                                         <input class="form-check-label" type="radio" name="gender" value="Female" <c:if test="${farmer.gender == 'Female'}">
                                                             <c:out value="checked"/>
                                                         </c:if> >Female

                                                         <input class="form-check-label" type="radio" name="gender" value="Other"  <c:if test="${farmer.gender == 'Other'}">
                                                             <c:out value="checked"/>
                                                         </c:if>>Other
                                                     </div>
                                                </div>
                                            </div>

                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="dob">
                                                        <strong>Date of Birth</strong>
                                                    </label>
                                                    <input class="form-control" type="date" id="dob" placeholder="Enter Date of Birth" name="dob" value="${farmer.dob}">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">

                                                <button class="btn btn-primary btn-sm" type="submit">Save Change</button>

                                            <a class="btn btn-primary btn-sm" href="<%=request.getContextPath()%>/profile" type="button">
                                                Back
                                            </a>
                                        </div>
                                    </form>
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
