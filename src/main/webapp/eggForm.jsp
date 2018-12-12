<%@taglib uri="http://indi.project/tags" prefix="tl" %>
<%@include file="header.jsp"%>
<c:set value="eggs" var="title"/>
<html>
<%@include file="head.jsp"%>
<body>
<%@include file="nav.jsp"%>

<form action="/addEgg">
    <label for="date">Date Collected</label><br>
    <tl:todaysDate/>



</form>
</body>
</html>
