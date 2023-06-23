<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>List Making Application</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h1>Delete List</h1>
    <form method="POST" action="/deletelist.html">
        <input type="text" name="listtodelete" placeholder="Enter name of list to delete"/>
        <input type="submit" value="Submit"/>
    </form>


</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
