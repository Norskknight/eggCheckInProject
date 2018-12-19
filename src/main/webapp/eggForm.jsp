<%@taglib uri="http://indi.project/tags" prefix="tl" %>
<%@include file="header.jsp" %>
<c:set value="Adding Eggs" var="title"/>
<html>
<%@include file="head.jsp" %>
<body>
<div class="container">
    <%@include file="titleBar.jsp" %>

    <div class="message">${message}</div>
    <div class="addEggForm">
        <form action="addEgg" method="post">
            <label for="date">Date Collected</label><br>
            <tl:todaysDate/>
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
    </div>
    <div class="showEggForm">
        <form action="showEgg" method="get">
            <label for="id">ID</label>
            <input id="id" name="id" type="text">
            <input type="submit" value="Find">
        </form>
    </div>
</div>
</body>
</html>
