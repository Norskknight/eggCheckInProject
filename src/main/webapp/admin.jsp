<%@include file="header.jsp"%>
<c:set value="Admin" var="title"/>
<html>
<%@include file="head.jsp"%>
<body>
<%@include file="nav.jsp"%>
this can see all users and totals

<div>${message}</div>
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
            <td>
                <form method="post" action="deleteUser">
                    <input name="userid" type="userid" value="${user.id}" hidden>
                    <input type="submit">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
