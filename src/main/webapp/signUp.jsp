<%@include file="header.jsp"%>
<c:set value="Sign Up" var="title"/>
<html>
<%@include file="head.jsp"%>
<body>
<form action="signUpUser" method="post">
    <label for="userName">UserName</label>
    <input required type="text" id="userName">

    <label for="userPass">Password</label>
    <input required type="password" id="userPass">

</form>
<%@include file="nav.jsp"%>
</body>
</html>
