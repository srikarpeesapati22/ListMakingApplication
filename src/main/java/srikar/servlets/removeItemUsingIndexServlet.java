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

// The servlet invoked to display a list of patients. Note that this data is just example data,
// you replace it with your data.
// The url http://localhost:8080/lists.html is mapped to calling doGet on the servlet object.
// The servlet object is created automatically, you just provide the class.
@WebServlet("/removeIndexInList.html")
public class removeItemUsingIndexServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Use the model to do the search and put the results into the request object sent to the
        // Java Server Page used to display the results.
        Model model = null;
        try {
            model = ModelFactory.getModel();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Integer rindex = Integer.parseInt(request.getParameter("RIndex"));
        String replaceIListName = request.getParameter("removeIListName");
        System.out.println(rindex + " " + replaceIListName);
        ArrayList<String> temp = model.viewList(replaceIListName);
        temp.remove(rindex + 0);
        try {
            model.replaceList(replaceIListName, temp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/removeIndexInList.jsp");
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
        RequestDispatcher dispatch = context.getRequestDispatcher("/removeIndexInList.jsp");
        dispatch.forward(request, response);

    }
}

