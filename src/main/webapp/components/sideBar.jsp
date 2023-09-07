<%--
  Created by IntelliJ IDEA.
  User: hector
  Date: 8/27/23
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fa-solid fa-tooth" style="color: #ffffff;"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Dentist</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" href="index.jsp">
            <i class="fa-solid fa-calendar-days" style="color: #ffffff;"></i>
            <span>Calendar</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Info
    </div>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
           aria-expanded="true" aria-controls="collapseTwo">
            <i class="fa-solid fa-user-doctor" style="color: #ffffff;"></i>
            <span>Dentists</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Dentist:</h6>
                <a class="collapse-item" href="buttons.html">See Dentists</a>
            </div>
        </div>

    </li>

    <!-- Nav Item - Utilities Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
           aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fa-solid fa-hospital-user" style="color: #ffffff;"></i>
            <span>Patients</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
             data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Custom Utilities:</h6>
                <a class="collapse-item" href="patients">See Patients</a>
                <a class="collapse-item" href="">Add Patients</a>
            </div>
        </div>
    </li>
    <hr class="sidebar-divider my-0 mb-3">
    <div class="sidebar-heading">
        Gestion
    </div>
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#user"
           aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fa-solid fa-user-plus" style="color: #ffffff;"></i>
            <span>Users</span>
        </a>
        <div id="user" class="collapse" aria-labelledby="headingUtilities"
             data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Users:</h6>
                <a class="collapse-item" href="registry.jsp?user=dentist">Add Dentist</a>
                <a class="collapse-item" href="registry.jsp?user=secretary">Add Secretary</a>
            </div>
        </div>
    </li>
</ul>
