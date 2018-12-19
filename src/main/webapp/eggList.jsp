<%@include file="header.jsp" %>
<c:set value="Egg List" var="title"/>

<html>
<%@include file="head.jsp" %>
<body>
<div class="container">
    <%@include file="titleBar.jsp" %>
    <div>${message}</div>
        <table id="datatable" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
            <thead>
            <th class="th-sm">ID</th>
            <th class="th-sm">Type</th>
            <th class="th-sm">collectedDate</th>
            <th class="th-sm">wash By</th>
            <th class="th-sm">best By</th>
            <th class="th-sm">Notes</th>
            <th class="th-sm">Go To</th>
            </thead>
            <tbody>

            <c:forEach var="egg" items="${eggs}">
            <tr>
                <td>${egg.id}</td>
                <td>${egg.type}</td>
                <td>${egg.collectedDate}</td>
                <td>${egg.twoWeeks}</td>
                <td>${egg.fiveWeeks}</td>
                <td>${egg.notes} </td>
                <td><a href="showEgg?id=${egg.id}">Go to</a></td>
            </tr>

            </c:forEach>
            <tfoot>
            <th>ID</th>
            <th>Type</th>
            <th>collectedDate</th>
            <th>wash By</th>
            <th>best By</th>
            <th>Notes</th>
            <th>Edit</th>
            </tfoot>
        </table>
</div>
</body>
<script>

    $(document).ready(function () {
        var table = $('#datatable').DataTable();
    });
</script>

</html>
