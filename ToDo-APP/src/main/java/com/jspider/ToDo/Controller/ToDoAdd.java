package com.jspider.ToDo.Controller;

import java.io.IOException;

import com.jspider.ToDo.dao.ToDoDao;
import com.jspider.ToDo.dto.Entity;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addToDo")
public class ToDoAdd extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // Read input from  front end 
		String username=req.getParameter("username");
        String todo=req.getParameter("todo");
        String status=req.getParameter("status");
        
       // System.out.println(username+" "+todo+" "+status);
       /*
        * Session is created becouse we need the print massege on front end
        */
        HttpSession httpSession=req.getSession();
        
       ToDoDao dao=new ToDoDao();
       Entity e=new Entity(0, username, todo, status);
       
      boolean result= dao.addToDo(e);
      if (result) {
		//System.out.println(" Data is enter in database Successfully");
    	  httpSession.setAttribute("sessionMsg", "Todo added sucessfully");
    	  /* after successfully added home page will be open we can do this 
    	   * by req.getRequestDispature("home.jsp") or resp.sendRedirect("home.jsp);
    	   */
    	  resp.sendRedirect("index.jsp");
	} else {
		 httpSession.setAttribute("sessionMsg", "Todo is Not added ");
		//System.out.println(" Data is   not enter");
		 req.getRequestDispatcher("index.jsp").include(req, resp);
		
	}
	}
	
}
