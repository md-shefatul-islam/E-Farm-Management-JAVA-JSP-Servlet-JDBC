<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="assets/css/untitled-1.css">
    <link rel="stylesheet" href="assets/css/untitled.css">
</head>
<body class="bg-gradient-primary">
<div class="container" style="margin-right: 12px;padding: 0 0;">
    <div class="card shadow-lg o-hidden border-0 my-5">
        <div class="card-body p-0">
            <div class="row">
                <div class="col-lg-5 d-none d-lg-flex">
                    <img src="img/login.jpg" alt="login" style="width: 600px; margin-right: -1px;"/>
                </div>
                <div class="col-lg-7">
                    <div class="px-5 py-3">
                        <div class="text-center">
                            <h4 class="text-dark mb-2">Create an Account!</h4>
                        </div>

                        <!-- main body -->
                        <div class="card-body">

                            <c:set var="message" scope="request" value='<%= request.getAttribute("message")%>'>
                            </c:set>
                            <c:if test="${fn:contains(message, 'success')}">
                                <p><b>'Registration Successful...'</b></p>
                            </c:if>
                            <c:if test="${fn:contains(message, 'failed')}">
                                <p><b>'Enter a unique User Name...And Try Again...'</b></p>
                            </c:if>
                            <c:if test="${fn:contains(message, 'not')}">
                                <p><b>'Enter a unique User Name...And Try Again...'</b></p>
                            </c:if>

<%--                            <form action="registration" method="post" enctype="multipart/form-data">--%>
                            <form action="registration" method="post">
                                <c:set var="register" scope="request" value='<%= request.getAttribute("regester")%>'>
                                </c:set>
                                <div class="form-row">
<%--                                    <div class="col-lg-6">--%>
<%--                                        <div class="form-group">--%>
<%--                                            <label>--%>
<%--                                                <strong>Picture</strong>--%>
<%--                                            </label>--%>
<%--                                            <input class="form-control border-0" type="file" name="file">--%>
<%--                                        </div>--%>
<%--                                    </div>--%>

                                    <div class="col-lg-6">
                                        <div class="form-check">
                                            <label>
                                                <strong>Account Type</strong>
                                            </label>
                                            <div>
                                                <input class="form-check-label" type="radio" name="actype" value="admin" required>admin

                                                <input class="form-check-label" type="radio" name="actype" value="farmer">farmer

                                                <input class="form-check-label" type="radio" name="actype" value="seedbanker">seedbanker
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label for="name">
                                                <strong>Name</strong>
                                            </label>

                                            <input class="form-control" type="text" placeholder="Enter Full Name" name="name" id="name" value="${register.name}" required>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label for="username">
                                                <strong>User Name</strong>
                                            </label>
                                            <input class="form-control" type="text" placeholder="Enter UserName" id="username" name="username" value="${register.uname}" required>
                                        </div>
                                    </div>

                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label for="email">
                                                <strong>Email</strong>
                                            </label>
                                            <input class="form-control" type="email" placeholder="Enter Email"  id="email" name="email" value="${register.email}" required>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label for="phone">
                                                <strong>Phone</strong>
                                            </label>
                                            <input class="form-control" type="text" placeholder="Enter Phone" id="phone" name="phone" value="${register.phone}" required>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label for="city">
                                                <strong>City</strong>
                                            </label>
                                            <input class="form-control" type="text" placeholder="Enter your City " id="city" name="city" value="${register.city}" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="col-lg-6">
                                        <div class="form-check">
                                            <label>
                                                <strong>Gender</strong>
                                            </label>
                                            <div>
                                                <input class="form-check-label" type="radio" name="gender" value="Male" required <c:if test="${register.gender == 'Male'}">
                                                    <c:out value="checked"/>
                                                </c:if>>Male

                                                <input class="form-check-label" type="radio" name="gender" value="Female" <c:if test="${register.gender == 'Female'}">
                                                    <c:out value="checked"/>
                                                </c:if> >Female

                                                <input class="form-check-label" type="radio" name="gender" value="Other"  <c:if test="${register.gender == 'Other'}">
                                                    <c:out value="checked"/>
                                                </c:if>>other
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-lg-6">
                                        <div class="form-group">
                                            <label for="dob">
                                                <strong>Date of Birth</strong>
                                            </label>
                                            <input class="form-control" type="date" placeholder="Enter Date of Birth" id="dob" name="dob" value="${register.dob}" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="col">
                                        <div class="form-group">
                                            <label for="password">
                                                <strong>Password</strong>
                                            </label>
                                            <input class="form-control" type="password" placeholder="Enter Password" id="password" name="password" value="" required>
                                        </div>
                                    </div>
                                </div>

                                    <div class="form-group">
                                        <button class="btn btn-primary btn-sm" type="submit" name="submit" value="change">Save</button>
                                    </div>
                            </form>
                        </div>


                        <div class="text-center"></div>
                        <div class="text-center"><a class="small" href="login.jsp">Already have an account? Login!</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js"></script>
<script src="assets/js/theme.js"></script>
</body>
</html>
