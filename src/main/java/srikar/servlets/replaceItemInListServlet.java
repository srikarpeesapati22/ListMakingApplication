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

// The servlet invoked to replace an item in a list.
// The url http://localhost:8080/replaceItemInList.html is mapped to calling doPost on the servlet object.
@WebServlet("/replaceItemInList.html")
public class replaceItemInListServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = null;
        try {
            model = ModelFactory.getModel();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String oldItem = (String) request.getParameter("oldItem");
        String newItem = (String) request.getParameter("newItem");
        String replaceListName = (String) request.getParameter("replaceListName");
        ArrayList<String> temp = model.viewList(replaceListName);
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).equals(oldItem)) {
                temp.add(i, newItem);
                temp.remove(i + 1);
                break;
            }
        }
        try {
            model.replaceList(replaceListName, temp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/replaceItemInList.jsp");
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
        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/replaceItemInList.jsp");
        dispatch.forward(request, response);
    }
}

