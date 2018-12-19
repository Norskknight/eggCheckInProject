<%@include file="header.jsp" %>
<c:set value="Totals" var="title"/>
<html>
<%@include file="head.jsp" %>
<body>
<div class="container">
    <%@include file="titleBar.jsp" %>
    <div class="content">
    <table id="datatable" class="table table-striped table-bordered table-sm">
        <thead>
        <th class="th-sm">User</th>
        <th class="th-sm">Eggs</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userName}</td>
                <td>${fn:length(user.eggs)}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
</body>
<script>

    $(document).ready(function () {
        var table = $('#datatable').DataTable();
    });
</script>
</html>
