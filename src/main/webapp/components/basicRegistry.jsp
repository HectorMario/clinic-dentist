<%--
  Created by IntelliJ IDEA.
  User: hector
  Date: 8/27/23
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group row">
    <div class="col-sm-6 mb-3 mb-sm-0">
        <input type="text" class="form-control form-control-user"
               id="exampleFirstName"
               placeholder="First Name"
               name="name"
        >
    </div>
    <div class="col-sm-6">
        <input type="text" class="form-control form-control-user"
               id="exampleLastName"
               placeholder="Last Name" name="surname">
    </div>
</div>
<div class="form-group row">
    <div class="col-sm-4 mb-3 mb-sm-0">
        <input type="date" class="form-control rounded-pill h-100"
               id="birth"
               placeholder="DateBirth"
               name="dateOfBirth"
        >
    </div>
    <div class="col-sm-4">
        <input type="text" class="form-control form-control-user"
               id="address"
               placeholder="Adress"
               name="address"
        >
    </div>
    <%
        String typeUser = request.getParameter("user");
        if (typeUser.equals("dentist")){
    %>
    <div class="col-sm-4">
        <input type="text" class="form-control form-control-user"
               id="speciality"
               placeholder="Speciality"
               name="speciality"
        >
    </div>
    <%
        } else {
    %>
    <div class="col-sm-4">
        <input type="text" class="form-control form-control-user"
               id="sector"
               placeholder="Sector"
               name="sector"
        >
    </div>
    <%
        }
    %>
</div>
