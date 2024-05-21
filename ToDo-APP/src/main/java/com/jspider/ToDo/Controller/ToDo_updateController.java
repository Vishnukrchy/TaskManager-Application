package com.jspider.ToDo.Controller;

import java.io.IOException;

import com.jspider.ToDo.dao.ToDoDao;
import com.jspider.ToDo.dto.Entity;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/updateToDo")
public class ToDo_updateController extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String username=req.getParameter("username");
    String todo=req.getParameter("todo");
    String status=req.getParameter("status");
    
    ToDoDao dao=new ToDoDao();
    Entity e=new Entity(id, username, todo, status);
    
    int result=dao.updateToDo(e);
    if (result>0) {
		System.out.println("========== Todo is Updated Succesfully =================");
		resp.sendRedirect("index.jsp");
	} else {
		System.out.println("============== Todo is Not Updated ==============");
		resp.sendRedirect("index.jsp");
	}
    
    
}
}
