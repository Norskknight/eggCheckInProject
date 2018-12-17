<%@include file="header.jsp"%>
<c:set value="ShowEgg" var="title"/>
<html>
<%@include file="head.jsp"%>
<body>
<%@include file="nav.jsp"%>
    <div>
        <p>Egg Id is: ${egg.id}</p>
        <br>
        <form action="updateEggs" method="post">
            <input id="id" name="id" type="text" value="${egg.id}" hidden>
            <label for="type">Egg Type</label>
            <input id="type" name="type" type="text" value="${egg.type}">
            <br>
            <label for="date">Collected Date</label>
            <input id="date" name="date" type="date" value="${egg.collectedDate}">
            <br>
            <label for="notes">Notes</label>
            <input id="notes" name="notes" type="text" value="${egg.notes}">
            <br>
            <input type="submit" name="job" value="Delete">
            <br>
            <input type="submit" name="job" value="Update">
        </form>
    </div>

</body>
</html>
