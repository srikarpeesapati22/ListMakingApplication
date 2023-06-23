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

// The servlet invoked to make a new list.
// The url http://localhost:8080/newlist.html is mapped to calling doPost on the servlet object.
@WebServlet("/newlist.html")
public class NewListServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = null;
        try {
            model = ModelFactory.getModel();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String newlistname= request.getParameter("newlistname");
        String data = request.getParameter("data");
        if (newlistname != null && data != null) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(data);
            try {
                model.addList(newlistname, temp);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        // Invoke the JSP.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/newList.jsp");
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
        RequestDispatcher dispatch = context.getRequestDispatcher("/newList.jsp");
        dispatch.forward(request, response);
    }
}
