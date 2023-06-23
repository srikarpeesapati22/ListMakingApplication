<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
  <jsp:include page="/meta.jsp"/>
  <title>List Making Application</title>
  <link rel="stylesheet" href="./styles.css">
  <script src="https://kit.fontawesome.com/942c0bd933.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="/header.jsp"/>
<div class="main">
  <h1>View Nested List</h1>
  <%
    String listName = request.getParameter("nestedListName");
    ArrayList<String> listContents = (ArrayList<String>) request.getAttribute("nestedListContents");
  %>
  <p style="font-size:20px; display: inline"><b><%=listName%></b></p>
  <div class="dropdown">
            <span>
            <i class="glyphicon glyphicon-menu-hamburger" style="font-size: 150%"></i>
            </span>
    <div class="dropdown-content">
      <a href="addToList.html">add item</a><br>
      <a href="removeFromList.html">remove item</a><br>
      <a href="removeIndexInList.html">remove with index</a><br>
      <a href="replaceItemInList.html">replace item</a><br>
      <a href="replaceIndexInList.html">replace with index</a><br>
    </div>
  </div>
  <ul class="flex-container">
    <%
      for (int j = 0; j < listContents.size(); j++)
      {
        String temp4 = "";
        String temp3 = "";
        String tempF3 = "";
        if (listContents.get(j).length() >= 4) {
          temp4 = listContents.get(j).substring(listContents.get(j).length() - 4, listContents.get(j).length()).toLowerCase();
        }
        if (listContents.get(j).length() >= 3) {
          temp3 = listContents.get(j).substring(listContents.get(j).length() - 3, listContents.get(j).length()).toLowerCase();
          tempF3 = listContents.get(j).substring(0, 3);
        }
        if (temp4.equals("jpeg") || temp3.equals("jpg") || temp3.equals("png") || temp3.equals("gif")) {
    %>
            <li class="flex-item"><img src=<%=listContents.get(j)%>></li>
        <% } else if (tempF3.equals("www")) { %>
            <li class="flex-item"><a target="_blank" href=<%="https://" + listContents.get(j)%>><%=listContents.get(j)%></a></li>
        <% } else if (tempF3.equals("L:/")) {
                String temp5 = listContents.get(j).substring(3, listContents.get(j).length());
        %>
          <li class="flex-item">
              <a href="javascript:{}" onclick="document.getElementById('nest').submit(); return false;"><%=temp5%></a>
              <form id="nest" method="POST" action="innerView.html">
                   <input type="hidden" name="nestedListName" value=<%=temp5%>>
              </form>
          </li>
        <% } else { %>
            <li class="flex-item"><%=listContents.get(j)%></li>
        <% } %>
    <% } %>
  </ul>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>