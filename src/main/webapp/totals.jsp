<%@include file="header.jsp"%>
<c:set value="totals" var="title"/>
<html>
<%@include file="head.jsp"%>
<body>
<%@include file="nav.jsp"%>
<table>
    <thead>
    <th>User</th>
    <th>Eggs</th>

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
</body>
</html>
