<%@include file="header.jsp" %>
<c:set value="Admin" var="title"/>
<html>
<%@include file="head.jsp" %>
<body class="container">
<%@include file="titleBar.jsp" %>
<div class="contentRow">
<div class="deleteMessage">${message}</div>
<table id="datatable" class="table table-striped table-bordered table-sm">
    <thead>
    <th class="th-sm">User</th>
    <th class="th-sm">Eggs</th>
    <th class="th-sm">Delete</th>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.userName}</td>
            <td>${fn:length(user.eggs)}</td>
            <td>
                <form method="post" action="deleteUser">
                    <input name="userid" type="userid" value="${user.id}" hidden>
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
<script>

    $(document).ready(function () {
        var table = $('#datatable').DataTable();
    });
</script>
</html>
