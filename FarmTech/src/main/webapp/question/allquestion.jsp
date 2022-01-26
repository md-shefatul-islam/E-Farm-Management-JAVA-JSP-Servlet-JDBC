<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Question</title>
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
                <h3 class="text-dark mb-4">Question & Answer</h3>

                <%--                @if (session()->has('msg'))--%>
                <%--                {{session('msg')}}--%>
                <%--                @endif--%>

                <div class="text-justify mb-3">

                    <div class="row text-justify">
                        <div class="col text-justify">
                            <div class="card shadow mb-3">


                                <div class="card-body">
                                    <c:set var="pass" scope="request" value='<%= request.getAttribute("search")%>'>
                                    </c:set>

                                    <c:if test="${fn:contains(pass, 'failed')}">
                                        <p><b>No Data Matched...Try Again...</b></p>
                                    </c:if>

<%--                                    <c:set var="farmer" scope="request" value='<%= request.getAttribute("alluser")%>'>--%>
<%--                                    </c:set>--%>



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

                                        </thead>
                                        <tbody>
                                        <c:forEach var="que" items='<%= request.getAttribute("que")%>'>

                                            <tr>
                                                <td>Question : <c:out value="${que.id}"/></td>
                                                <td><c:out value="${que.question}"/></td>
                                            </tr>
                                            <form action="allquestion" method="post">
                                            <tr>
                                                <td>Answer : </td>
                                                <td>
                                                    <div class="form-row">
                                                        <div class="col">
                                                            <div class="form-group">

                                                                <input class="form-control" type="text" name="id" value="${que.id}" hidden>
                                                                <input class="form-control" type="text" name="answer" value="${que.answer}" placeholder="Enter Your Answer">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>
                                                    <c:if test="${empty que.answer}">
                                                        <input type="submit" value="Answer">
                                                    </c:if>
                                                </td>
                                            </tr>
                                            </form>
                                            <tr>
<%--                                                <td><c:out value="${que.id}"/><c:out value="${que.question}"/></td>--%>
<%--                                                <td><c:out value="${que.email}"/><c:out value="${que.answer}"/></td>--%>
<%--                                                <td><c:out value="${alluser.email}"/></td>--%>
<%--                                                <td><c:out value="${alluser.phone}"/></td>--%>
<%--                                                <td><c:out value="${alluser.city}"/></td>--%>
<%--                                                <td><c:out value="${alluser.gender}"/></td>--%>
<%--                                                <td><c:out value="${alluser.dob}"/></td>--%>
                                                    <%--                                                <td>--%>
                                                    <%--                                                    <c:if test="${empty student.attendance}">--%>
                                                    <%--                                                        <button class="btn btn-success">--%>
                                                    <%--                                                            <a style="color: aliceblue"--%>
                                                    <%--                                                               href="<%=request.getContextPath()%>/present?id=${student.id}">P</a>--%>
                                                    <%--                                                        </button>--%>
                                                    <%--                                                        ||--%>
                                                    <%--                                                        <button class="btn btn-danger">--%>
                                                    <%--                                                            <a style="color: aliceblue"--%>
                                                    <%--                                                               href="<%=request.getContextPath()%>/absent?id=${student.id}">A</a>--%>
                                                    <%--                                                        </button>--%>

                                                    <%--                                                    </c:if>--%>
                                                    <%--                                                    <c:if test="${not empty student.attendance}">--%>
                                                    <%--                                                        <c:out value="${student.attendance}"/>--%>
                                                    <%--                                                    </c:if>--%>
                                                    <%--                                                </td>--%>

                                                    <%--                                                <td>--%>
                                                    <%--                                                    <a href='<%=request.getContextPath()%>/updatestudent?id=${student.id}'>Edit</a>--%>
                                                    <%--                                                    &nbsp;&nbsp;&nbsp;&nbsp;--%>
                                                    <%--                                                    <a href='<%=request.getContextPath()%>/deletestudent?id=${student.id}'>Delete</a>--%>
                                                    <%--                                                </td>--%>
                                                    <%--                                                <td>--%>
                                                    <%--                                                    <c:if test="${not empty student.attendance}">--%>
                                                    <%--                                                        <a href='<%=request.getContextPath()%>/updateattendance?id=${student.id}'>Change</a>--%>
                                                    <%--                                                    </c:if>--%>

                                                    <%--                                                </td>--%>
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
