package com.jspider.ToDo.Controller;

import java.io.IOException;

import com.jspider.ToDo.dao.ToDoDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(value = "/delete")
public class TodoDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        ToDoDao dao = new ToDoDao();
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println("ID is " + id);
        
       // String session = (String) httpSession.getAttribute("sessionMsg");
        
            int i = dao.deleteToDo(id);
            if (i > 0) {
            	resp.sendRedirect("index.jsp");
                System.out.println("Data is deleted successfully");
                httpSession.setAttribute("deleteSessionMsg", "Record is deleted successfully");
            } else {
                System.out.println("Data not deleted");
                httpSession.setAttribute("deleteSessionMsg", "Oops, record is not deleted!");
            }
            
       
    }

    
}
