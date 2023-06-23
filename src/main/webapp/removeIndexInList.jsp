<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>List Making Application</title>
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <form method="POST" action="/removeIndexInList.html">
    <input type="text" name="removeIListName" placeholder="List Name"/>
    <input type="text" name="RIndex" placeholder="Index (From 0)"/>
    <input type="submit" value="Submit"/>
  </form>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>
