package srikar.servlets;

import srikar.model.Model;
import srikar.model.ModelFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// The servlet invoked to search for a "searchstring" in the lists.
// The url http://localhost:8080/runsearch.html is mapped to calling doPost on the servlet object.
@WebServlet("/runsearch.html")
public class SearchServlet extends HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    Model model = null;
    try {
      model = ModelFactory.getModel();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
    ArrayList<String> searchResult = model.searchFor(request.getParameter("searchstring"));
    request.setAttribute("searchResultNames", searchResult);
    ArrayList<Object> listContents = new ArrayList<>();
    for (String listName : searchResult) {
      listContents.add(model.viewList(listName));
    }
    request.setAttribute("searchListContents", listContents);
    // Invoke the JSP page.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/searchResult.jsp");
    dispatch.forward(request, response);
  }
}
