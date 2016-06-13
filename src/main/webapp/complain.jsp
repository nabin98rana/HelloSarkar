<%-- 
    Document   : index
    Created on : Jun 8, 2016, 12:19:29 PM
    Author     : Navin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="shared/header.jsp" %>
<form class="form-horizontal" role="form" method="post" action="addcomplain">
    <div class="form-group">
        <label class="control-label col-sm-2" for="title">Title:</label>
        <div class="col-sm-6">
            <input type="text" name="title" class="form-control" id="title" placeholder="Enter Title" required="required"/>
        </div>
    </div>


    <div class="form-group">
        <label class="control-label col-sm-2" for="description">Description:</label>
        <div class="col-sm-6">
            <textarea rows="5" cols="50" name="description" class="form-control" id="description" placeholder="Enter Description" ></textarea>
        </div>
    </div>


    <div class="form-group">
        <label class="control-label col-sm-2" for="first_name">First Name:</label>
        <div class="col-sm-6">
            <input type="text" name="first_name" class="form-control" id="firstname" placeholder="Enter Firstname" required="required"/>
        </div>
    </div>


    <div class="form-group">
        <label class="control-label col-sm-2" for="last_name">Last Name:</label>
        <div class="col-sm-6">
            <input type="text" name="last_name" class="form-control" id="lastname" placeholder="Enter Last Name" required="required"/>
        </div>
    </div>



    <div class="form-group">
        <label class="control-label col-sm-2" for="email">Email:</label>
        <div class="col-sm-6">
            <input type="text" name="email" class="form-control" id="email" placeholder="Enter Email" required="required"/>
        </div>
    </div>

    <div class="form-group submit" >
        <div class="col-sm-offset-2 col-sm-6">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </div>


</form>

<%@include file="shared/footer.jsp" %>
