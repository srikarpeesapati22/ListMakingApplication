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


// The servlet invoked to rename a list.
// The url http://localhost:8080/rename.html is mapped to calling doPost on the servlet object.
@WebServlet("/renamelist.html")
public class RenameListServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = null;
        try {
            model = ModelFactory.getModel();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String listName = request.getParameter("listtorename");
        String newlistName = request.getParameter("newlistname");
        try {
            model.renameList(listName, newlistName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // Invoke the JSP.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/renameList.jsp");
        dispatch.forward(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // Get the data from the model
        Model model = null;
        try {
            model = ModelFactory.getModel();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Invoke the JSP.
        // A JSP page is actually converted into a Java class, so behind the scenes everything is Java.
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/renameList.jsp");
        dispatch.forward(request, response);
    }
}
