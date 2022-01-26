<nav class="navbar navbar-dark align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0">
    <div class="container-fluid d-flex flex-column p-0">
        <a class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0" href="#">
            <div class="sidebar-brand-icon rotate-n-15">
                <img src='img/icon.png' alt="icon" style="width: 40px;height: 40px;filter: brightness(127%) contrast(184%) grayscale(0%) hue-rotate(0deg) invert(0%) saturate(200%) sepia(0%);margin-right: -10px;"/>
            </div>
            <div class="sidebar-brand-text mx-3">
                <span style="font-size: 20px;color: rgb(10,248,5);margin-top: 0px;margin-bottom: 0px;padding-bottom: 0px;padding-top: 0px;">CROPBZR</span>
            </div>
        </a>
        <hr class="sidebar-divider my-0">
<%--        <a href="register.html">--%>
        <ul class="nav navbar-nav text-light" id="accordionSidebar">
            <li class="nav-item" role="presentation">
                <a class="nav-link" href="<%=request.getContextPath()%>/home">
                    <i class="fas fa-tachometer-alt"></i>
                    <span>Dashboard</span>
                </a>
            </li>

            <li class="nav-item" role="presentation">
                <a class="nav-link" href="<%=request.getContextPath()%>/profile">
                    <i class="fas fa-user"></i>
                    <span>Profile</span>
                </a>
            </li>


            <li class="nav-item dropdown">
                <a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">
                    <i class="fas fa-list-alt"></i>All List</a>
                <div class="dropdown-menu" role="menu">
                    <a class="dropdown-item" role="presentation" href="<%=request.getContextPath()%>/alluser">User List</a>
                    <a class="dropdown-item" role="presentation" href="<%=request.getContextPath()%>/buylistfarmer">Buying List</a>
                    <a class="dropdown-item" role="presentation" href="<%=request.getContextPath()%>/selllistfarmer">Selling List</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">
                    <i class="fab fa-readme"></i>Crop</a>
                <div class="dropdown-menu" role="menu">
                    <a class="dropdown-item" role="presentation" href="<%=request.getContextPath()%>/insert">Create</a>
                    <a class="dropdown-item" role="presentation" href="<%=request.getContextPath()%>/allproduct">Crop List</a>
                </div>
            </li>

<%--            <li class="nav-item" role="presentation">--%>
<%--                <a class="nav-link" href={{route('advertise.myads')}}>--%>
<%--                    <i class="fas fa-id-badge"></i>--%>
<%--                    <span>My Advertisement</span>--%>
<%--                </a>--%>
<%--            </li>--%>

<%--            <li class="nav-item dropdown">--%>
<%--                <a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">--%>
<%--                    <i class="fab fa-readme"></i>Advertisement</a>--%>
<%--                <div class="dropdown-menu" role="menu">--%>
<%--                    {{-- <a class="dropdown-item" role="presentation" href="{{route('ads.cropad')}}">Crops AD</a> --}}--%>
<%--                    <a class="dropdown-item" role="presentation" href="{{route('ads.seedad')}}">Seeds AD</a>--%>
<%--                    <a class="dropdown-item" role="presentation" href="{{route('ads.bankerad')}}">Bankers AD</a>--%>
<%--                </div>--%>
<%--            </li>--%>

            <li class="nav-item dropdown">
                <a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">
                    <i class="fas fa-arrows-alt"></i>Request</a>
                <div class="dropdown-menu" role="menu">
                    <a class="dropdown-item" role="presentation" href="<%=request.getContextPath()%>/requestfarmer">Except Request</a>
                    <a class="dropdown-item" role="presentation" href="<%=request.getContextPath()%>/pendingfarmerreq">My Pending RQ</a>

                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">
                    <i class="fab fa-readme"></i>Order</a>
                <div class="dropdown-menu" role="menu">

                    <a class="dropdown-item" role="presentation" href="<%=request.getContextPath()%>/allcropor">Crop List</a>
                    <a class="dropdown-item" role="presentation" href="<%=request.getContextPath()%>/allseedor">Seed List</a>

                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">
                    <i class="fas fa-comments-dollar"></i>Payment</a>
                <div class="dropdown-menu" role="menu">
                    <a class="dropdown-item" role="presentation" href="#">Receive Pay</a>
                    <a class="dropdown-item" role="presentation" href="#">Make Pay</a>
                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="dropdown-toggle nav-link" data-toggle="dropdown" aria-expanded="false" href="#">
                    <i class="fas fa-comments-dollar"></i>Tips & Question</a>
                <div class="dropdown-menu" role="menu">
                    <a class="dropdown-item" role="presentation" href="<%=request.getContextPath()%>/allquestion">Previous Que&answer</a>
                    <a class="dropdown-item" role="presentation" href="<%=request.getContextPath()%>/question">Make Question</a>
                </div>
            </li>

            <li class="nav-item" role="presentation">
                <a class="nav-link" href="{{route('email.index')}}">
                    <i class="fas fa-building"></i>
                    <span>Complain</span>
                </a>
            </li>

            <li class="nav-item" role="presentation">
                <a class="nav-link" href="{{route('contact.index')}}">
                    <i class="fas fa-address-book"></i>
                    <span>Contact</span>
                </a>
            </li>
        </ul>
        <!-- create a tooggle button -->
<%--        <div class="text-center d-none d-md-inline">--%>
<%--            <button class="btn rounded-circle border-0" id="sidebarToggle" type="button"></button>--%>
<%--        </div>--%>
    </div>
</nav>