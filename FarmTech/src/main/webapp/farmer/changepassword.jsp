<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Change Password</title>
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
                <h3 class="text-dark mb-4">Change Password</h3>

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
                                    <c:if test="${fn:contains(pass, 'lock')}">
                                        <p>Update <b>Failed... Try with Correct Current Password</b></p>
                                    </c:if>
                                    <c:if test="${fn:contains(pass, 'val')}">
                                        <p>Update <b>Failed... New and re Type new Password must be same</b></p>
                                    </c:if>

                                    <form action="changepassword" method="post">

                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="cpass">
                                                        <strong>Current Password</strong><br>
                                                    </label>
                                                    <input class="form-control" type="text" id="cpass" placeholder="Enter Current Password" name="cpass" required></div>
                                            </div>
                                        </div>

                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="npass">
                                                        <strong>New Password</strong>
                                                    </label>
                                                    <input class="form-control" type="text" id="npass" placeholder="Enter New Password" name="npass" required></div>
                                            </div>
                                        </div>

                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="rnpass">
                                                        <strong>Re-Type New Password</strong>
                                                    </label>
                                                    <input class="form-control" type="text" id="rnpass" placeholder="Enter New Password Again" name="rnpass" required></div>
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
