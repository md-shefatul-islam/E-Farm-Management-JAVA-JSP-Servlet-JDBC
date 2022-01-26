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
                <h3 class="text-dark mb-4">Create Crop</h3>
                <div class="text-justify mb-3">

                    <div class="row text-justify">
                        <div class="col text-justify">
                            <div class="card shadow mb-3">



                                <div class="card-body">
                                    <c:set var="pass" scope="request" value='<%= request.getAttribute("cropinsert")%>'>
                                    </c:set>

                                    <c:if test="${fn:contains(pass, 'success')}">
                                        <p>Inserted <b>Sucessfully</b></p>
                                    </c:if>

                                    <c:if test="${fn:contains(pass, 'failed')}">
                                        <p>Insertion <b>Failed...Try Again...</b></p>
                                    </c:if>


                                    <form action="insert" method="post">
                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="name">
                                                        <strong>Name</strong>
                                                    </label>
                                                    <input class="form-control" type="text" id="name" placeholder="Enter name" name="name" value="">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="description">
                                                        <strong>Description</strong>
                                                    </label>
                                                    <input class="form-control" id="description" type="text" placeholder="Enter description" name="description" value=""></div>
                                            </div>
                                        </div>

                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="quantity">
                                                        <strong>Quantity(KG)</strong>
                                                    </label>
                                                    <input class="form-control" id="quantity" type="text" placeholder="Enter Quantity" name="quantity" value=""></div>
                                            </div>
                                        </div>

                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="price">
                                                        <strong>Price(TK per KG)</strong>
                                                    </label>
                                                    <input class="form-control" id="price" type="text" placeholder="Enter Price" name="price" value="">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-row">
                                            <div class="col">
                                                <div class="form-group">
                                                    <label for="date"><strong>Date</strong><br></label>
                                                    <input class="form-control" id="date" type="date" placeholder="Enter date" name="date" value="">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <button class="btn btn-primary btn-sm" type="submit" name="submit" value="change">Submit</button>

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
