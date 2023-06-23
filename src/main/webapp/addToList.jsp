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
    <p>To add a list to another list, prefix the list name with L:/ (for example to sublist LIST_NAME, type in L:/LIST_NAME)</p><br>
    <p>To add a hyperlink the first three characters must be "www".</p><br>
    <p>To add an image enter an image link ending with gif, png, jpg, or jpeg.</p>
    <form method="POST" action="/addToList.html">
        <input type="text" name="addListName" placeholder="List Name"/>
        <input type="text" name="addItem" placeholder="New Item"/>
        <input type="submit" value="Submit"/>
    </form>


</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
