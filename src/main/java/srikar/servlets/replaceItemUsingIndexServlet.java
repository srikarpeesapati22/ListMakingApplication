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

// The servlet invoked to replace an item in a list using an index.
// The url http://localhost:8080/replaceIndexInList.html is mapped to calling doPost on the servlet object.
@WebServlet("/replaceIndexInList.html")
public class replaceItemUsingIndexServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = null;
        try {
            model = ModelFactory.getModel();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Integer index = Integer.parseInt(request.getParameter("Index"));
        String newItem = (String) request.getParameter("newItem");
        String replaceIListName = (String) request.getParameter("replaceIListName");
        ArrayList<String> temp = model.viewList(replaceIListName);
        temp.add(index, newItem);
        temp.remove(index + 1);
        try {
            model.replaceList(replaceIListName, temp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/replaceIndexInList.jsp");
        dispatch.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Model model = null;
        try {
            model = ModelFactory.getModel();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // Invoke the JSP.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/replaceIndexInList.jsp");
        dispatch.forward(request, response);
    }
}

