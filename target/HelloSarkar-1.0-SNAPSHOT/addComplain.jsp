

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="shared/header.jsp" %>

<form action="readmore.jsp" method="post" class="form-horizontal">
            <div>
                <label >First Name</label>
                <input type="text" name="first_name" placeholder="Enter First Name" required="required"/>
            </div>
            <div>
                <label>Last Name</label>
                <input type="text" name="last_name" placeholder="Enter Last Name" required="required"/>
            </div>
            <div>
                <label>Email</label>
                <input type="email" name="email" placeholder="Enter Email" required="required"/>
           
        <button  type="submit" class="btn btn-success">Send</button>
       
        
    </form>
   
<%@include file="shared/footer.jsp" %>
