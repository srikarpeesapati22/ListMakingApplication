<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Home Page--%>
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
<div class="search">
    <h1>Search</h1>
    <form method="POST" action="/runsearch.html">
        <input type="text" name="searchstring" placeholder="Enter search keyword here"/>
        <input type="submit" value="Search"/>
    </form>
</div>
<div class="delete">
    <h1>Delete List</h1>
    <a href="deletelist.html">Delete a list</a>
</div>
<div class="new">
    <h1>New List</h1>
    <a href="newlist.html">Make a new list</a>
</div>
<div class="rename">
    <h1>Rename List</h1>
    <a href="renamelist.html">Rename List</a>
</div>
<div class="alllists">
    <%
        ArrayList<String> listNames = (ArrayList<String>) request.getAttribute("allListNames");
        ArrayList<ArrayList<String>> listContents = (ArrayList<ArrayList<String>>) request.getAttribute("listContents");
        for (int i = 0; i < listNames.size(); i++) {

        %>
    <p style="font-size:20px; display: inline;"><b><%=listNames.get(i)%></b></p>
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
            for (int j = 0; j < listContents.get(i).size(); j++)
            {
                String temp4 = "";
                String temp3 = "";
                String tempF3 = "";
                if (listContents.get(i).get(j).length() >= 4) {
                    temp4 = listContents.get(i).get(j).substring(listContents.get(i).get(j).length() - 4, listContents.get(i).get(j).length()).toLowerCase();
                }
                if (listContents.get(i).get(j).length() >= 3) {
                    temp3 = listContents.get(i).get(j).substring(listContents.get(i).get(j).length() - 3, listContents.get(i).get(j).length()).toLowerCase();
                    tempF3 = listContents.get(i).get(j).substring(0, 3);
                }
                if (temp4.equals("jpeg") || temp3.equals("jpg") || temp3.equals("png") || temp3.equals("gif")) {
        %>
                    <li class="flex-item"><img src=<%=listContents.get(i).get(j)%>></li>
                <% } else if (tempF3.equals("www")) { %>
                    <li class="flex-item"><a target="_blank" href=<%="https://" + listContents.get(i).get(j)%>><%=listContents.get(i).get(j)%></a></li>
                <% } else if (tempF3.equals("L:/")) {
                    String temp5 = listContents.get(i).get(j).substring(3, listContents.get(i).get(j).length());
                %>
                    <li class="flex-item">
                        <a href="javascript:{}" onclick="document.getElementById('nest').submit(); return false;"><%=temp5%></a>
                        <form id="nest" method="POST" action="innerView.html">
                            <input type="hidden" name="nestedListName" value=<%=temp5%>>
                        </form>
                    </li>
                <% } else { %>
                    <li class="flex-item"><%=listContents.get(i).get(j)%></li>
                <% } %>
        <% } %>
    </ul>
    <% } %>
</div>
<jsp:include page="/footer.jsp"/>
</body>
</html>