<%@include file="header.jsp" %>
<c:set value="Sign Up" var="title"/>
<html>
<%@include file="head.jsp" %>
<body>
<div class="container">

    <div class="message">
        <form action="signUpUser" method="post">
            <label for="userName">UserName</label>
            <input required type="text" id="userName" name="userName">
            <br>
            <label for="userPass">Password</label>
            <input required type="password" id="userPass" name="userPass">
            <br>
            <label for="zip">Zipcode</label>
            <input required type="text" id="zip" name="zip">
            <br>
            <input type="submit">
        </form>
    </div>
    <%@include file="titleBar.jsp" %>
</div>
</body>
</html>
