<%@ page import="jakarta.servlet.http.HttpSession" %>
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
                <h3 class="text-dark mb-4">Tips & Question</h3>
                <div class="text-justify mb-3">

                    <div class="row text-justify">
                        <div class="col text-justify">
                            <div class="card shadow mb-3">
                                <%--<%= request.getSession().getAttribute("username") %>--%>
                                <div class="card-body">
                                    <c:set var="que" scope="request" value='<%= request.getAttribute("que")%>'>
                                    </c:set>
                                    <c:if test="${fn:contains(que, 'success')}">
                                        <p><b>Question Successfully Added...Try Again New One</b></p>
                                    </c:if>

                                    <c:if test="${fn:contains(que, 'failed')}">
                                        <p><b>Question Failed...Try Again</b></p>
                                    </c:if>


                                    <form action="question" method="post">


                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="question">
                                                        <strong>Question</strong>
                                                    </label>
                                                    <input class="form-control" id="question" type="text" placeholder="Enter Your Question" name="question" value="" required>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <button class="btn btn-primary btn-sm" type="submit" name="submit" value="change">Ask</button>
                                            <a class="btn btn-primary btn-sm" type="button" href="<%=request.getContextPath()%>/home">Back</a>

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
