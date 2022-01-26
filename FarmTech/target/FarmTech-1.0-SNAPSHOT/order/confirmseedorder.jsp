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


                                <div class="card-body">
                                    <c:set var="pass" scope="request" value='<%= request.getAttribute("orderinsert")%>'>
                                    </c:set>

                                    <c:if test="${fn:contains(pass, 'success')}">
                                        <p>Order Placed <b>Sucessfully</b></p>
                                    </c:if>

                                    <c:if test="${fn:contains(pass, 'failed')}">
                                        <p>Order Place <b>Failed...Try Again...</b></p>
                                    </c:if>

                                    <c:set var="seed" scope="request" value='<%= request.getAttribute("order")%>'>
                                    </c:set>
                                    <form action="placeorderseed" method="post">
                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="name">
                                                        <strong>Name</strong>
                                                    </label>
                                                    <input class="form-control" type="text" id="name" placeholder="Enter name" name="name" value="${seed.name}" readonly>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="quantity">
                                                        <strong>Quantity(KG)</strong>
                                                    </label>
                                                    <input class="form-control" id="quantity" type="text" placeholder="Enter Quantity" name="quantity" value="<%= session.getAttribute("orderquantity") %>" readonly>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="price">
                                                        <strong>Price(Total)</strong>
                                                    </label>
                                                    <input class="form-control" id="price" type="text" placeholder="Enter Price" name="price" value="<%= session.getAttribute("totalprice") %>" readonly>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="buname">
                                                        <strong>Buyer Username</strong>
                                                    </label>
                                                    <input class="form-control" id="buname" type="text" placeholder="Enter buyer name" name="buname" value="${seed.suname}" readonly>
                                                </div>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <button class="btn btn-primary btn-sm" type="submit" name="submit" value="change">Order</button>
                                            <a class="btn btn-primary btn-sm" type="button" href="<%=request.getContextPath()%>/allseedor">Cancel</a>

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
