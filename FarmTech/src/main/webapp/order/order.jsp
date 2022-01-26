<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Edit Crop</title>
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
                <h3 class="text-dark mb-4">Edit Crop</h3>
                <div class="text-justify mb-3">

                    <div class="row text-justify">
                        <div class="col text-justify">
                            <div class="card shadow mb-3">
<%--<%= request.getSession().getAttribute("username") %>--%>
                                <div class="card-body">
                                    <c:set var="pass" scope="request" value='<%= request.getAttribute("order")%>'>
                                    </c:set>

                                    <c:if test="${fn:contains(pass, 'failed')}">
                                        <p><b>This amount(KG) is not availavle....Try with valid availavle One...</b></p>
                                    </c:if>


                                    <form action="ordercrop" method="post">


                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="quantity">
                                                        <strong>Quantity(KG)</strong>
                                                    </label>
                                                    <input class="form-control" id="quantity" type="text" placeholder="Enter Quantity" name="quantity" value="<c:set var="quantity" scope="request" value='<%= session.getAttribute("orderquantity")%>'></c:set><c:if test="${not empty quantity}"><%= request.getSession().getAttribute("orderquantity")%></c:if>" required>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <button class="btn btn-primary btn-sm" type="submit" name="submit" value="change">Order</button>
                                            <a class="btn btn-primary btn-sm" type="button" href="<%=request.getContextPath()%>/allcropor">Back</a>

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
