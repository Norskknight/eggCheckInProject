<%@include file="header.jsp" %>
<c:set value="Error" var="title"/>
<html>
<%@include file="head.jsp" %>
<body>
<div class="container">
    <div class="message">
        <h2>Uh-oh I just don't know what went wrong ${message}</h2>
    </div>
    <%@include file="titleBar.jsp" %>
</div>
</body>
</html>
