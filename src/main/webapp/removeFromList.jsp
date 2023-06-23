<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/meta.jsp"/>
    <title>List Making Application</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
    <form method="POST" action="/removeFromList.html">
        <input type="text" name="removeListName" placeholder="List Name"/>
        <input type="text" name="removeItem" placeholder="Item to Remove"/>
        <input type="submit" value="Submit"/>
    </form>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
