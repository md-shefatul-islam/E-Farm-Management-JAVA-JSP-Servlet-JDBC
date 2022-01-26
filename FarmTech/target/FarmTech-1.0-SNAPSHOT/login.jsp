<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Login</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="assets/css/untitled-1.css">
    <link rel="stylesheet" href="assets/css/untitled.css">
</head>

<body class="bg-gradient-primary">
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-9 col-lg-12 col-xl-10">
            <div class="card shadow-lg o-hidden border-0 my-5">
                <div class="card-body p-0">
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-flex"><img src="img/login.jpg" alt="login"></div>
                        <div class="col-lg-6">
                            <div class="p-5" style="background-color: #d4f219; height: 480px">
                                <div class="text-center">
                                    <h4 class="text-dark mb-4">Welcome Back!</h4>
                                    <%--                                    @if (session()->has('msg'))--%>
                                    <%--                                    {{session('msg')}}--%>
                                    <%--                                    @endif--%>
                                </div>
                                <c:set var="passs" scope="request" value='<%= request.getAttribute("delete")%>'>
                                </c:set>

                                <c:if test="${fn:contains(passs, 'success')}">
                                    <p>Deleted <b>Successfully...</b> <br> Register <b>Again to Login...</b></p>

                                </c:if>

                                <c:set var="pass" scope="request" value='<%= request.getAttribute("log")%>'>

                                </c:set>
                                <c:if test="${fn:contains(pass, 'failed')}">
                                    <p>Login <b>Failed... Try Again</b></p>
                                </c:if>

                                <form class="user" action="login" method="post">

                                    <div class="form-group">
                                        <input class="form-control form-control-user" type="text" aria-describedby="emailHelp" placeholder="Enter Username..." name="username">
                                    </div>


                                    <div class="form-group">
                                            <input class="form-control form-control-user" type="password" placeholder="Enter Password" name="password">
                                    </div>

                                    <div class="form-group">
                                        <div class="custom-control custom-checkbox small">
                                            <div class="form-check">
                                                <input class="form-check-input custom-control-input" type="checkbox" id="formCheck-1">
                                                <label class="form-check-label custom-control-label" for="formCheck-1">Remember Me</label>
                                            </div>
                                        </div>
                                    </div>

                                    <button class="btn btn-primary btn-block text-white btn-user" type="submit">Login</button>
                                    <hr>
                                </form>







                                <div class="text-center"><a class="small" href="check.jsp" style="color: rgb(37,26,26);">Forgot Password?</a></div>
                                <div class="text-center"><a class="small" href="registration.jsp" style="color: rgb(29,30,34);">Create an Account!</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.js" ></script>
<script src="assets/js/theme.js"></script>
</body>