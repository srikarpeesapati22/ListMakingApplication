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

// The servlet invoked to remove an item a list.
// The url http://localhost:8080/deletelist.html is mapped to calling doPost on the servlet object.
@WebServlet("/removeFromList.html")
public class removeFromListServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = null;
        try {
            model = ModelFactory.getModel();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String removalItem = (String) request.getParameter("removeItem");
        String removeListName = (String) request.getParameter("removeListName");
        ArrayList<String> temp = model.viewList(removeListName);
        temp.remove(removalItem);
        try {
            model.replaceList(removeListName, temp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/removeFromList.jsp");
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
        RequestDispatcher dispatch = context.getRequestDispatcher("/removeFromList.jsp");
        dispatch.forward(request, response);

    }
}
