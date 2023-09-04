<%--
  Created by IntelliJ IDEA.
  User: hector
  Date: 8/28/23
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <jsp:include page="components/basicLinks.jsp"/>
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <jsp:include page="components/sideBar.jsp"/>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <jsp:include page="components/topBar.jsp"/>

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Dentist Consultation</h1>
                </div>

                <div class="container">

                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <!-- Nested Row within Card Body -->
                        <div class="p-5">
                            <div class="text-center">
                                <%
                                    String typeUser = request.getParameter("user");
                                    if (typeUser.equals("dentist")){
                                %>
                                <h1 class="h4 text-gray-900 mb-4">Create a Dentist!</h1>
                                <%
                                } else {
                                %>
                                <h1 class="h4 text-gray-900 mb-4">Create a Secretary!</h1>
                                <%}%>
                            </div>
                            <form class="user" action="users" method="post">
                                <jsp:include page="components/basicRegistry.jsp"/>
                                <jsp:include page="components/userInputs.jsp"/>
                                <%
                                    if (typeUser.equals("dentist")){
                                %>
                                <button type="submit" class="btn btn-primary btn-user btn-block">
                                    Register Dentist
                                </button>
                                <%
                                } else {
                                %>
                                <button type="submit" class="btn btn-primary btn-user btn-block">
                                    Register Secretary
                                </button>
                                <%}%>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <jsp:include page="components/footer.jsp"></jsp:include>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <jsp:include page="components/logoutModel.jsp"/>

    <!-- Bootstrap core JavaScript-->
    <jsp:include page="components/scripts.jsp"/>

</body>

</html>
