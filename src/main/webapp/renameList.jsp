<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>List Making Application</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <h1>Rename List</h1>
    <form method="POST" action="/renamelist.html">
        <input type="text" name="listtorename" placeholder="Enter name of list to rename"/>
        <input type="text" name="newlistname" placeholder="Enter new name"/>
        <input type="submit" value="Submit"/>
    </form>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
