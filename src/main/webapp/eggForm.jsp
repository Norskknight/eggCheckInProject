<%@taglib uri="http://indi.project/tags" prefix="tl" %>
<%@include file="header.jsp"%>
<c:set value="eggs" var="title"/>
<html>
<%@include file="head.jsp"%>
<body>
<%@include file="nav.jsp"%>
${message}
<form action="addEgg" method="post">
    <label for="date">Date Collected</label><br>
    <input type="date" name="date" id="date">
    <br>
    <label for="type">Egg Type</label>
    <br>
    <select name="type" id="type">
        <option value="chicken">Chicken</option>
        <option value="duck">Duck</option>
    </select>
    <br>
    <input type="submit">
</form>
</body>
</html>
