<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>List Making Application</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h1>Make New List</h1>
    <form method="POST" action="/newlist.html">
        <input type="text" name="newlistname" placeholder="Enter name of new list"/>
        <input type="text" name="data" placeholder="Enter first entry"/>
        <input type="submit" value="Submit"/>
    </form>
    <p1>Add all additional data using the 'add Item' suboption</p1>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
