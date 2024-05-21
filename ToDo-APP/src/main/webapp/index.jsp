<%@page import="java.util.List"%>
<%@page import="com.jspider.ToDo.dto.Entity"%>
<%@page import="com.jspider.ToDo.dao.ToDoDao"%>
<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="Componnets/allCSS.jsp"%>

</head>
<body>
	<%@include file="Componnets/navbar.jsp"%>
	<h1 class="text-center text-success">ToDo-App</h1>
	<!--  Code for the session tracking  -->
	<%
	HttpSession httpSession = request.getSession();
	String massage = (String) httpSession.getAttribute("sessionMsg");

	if (massage != null) {
	%>

	<div class="alert alert-success" role="alert"><%=massage%></div>
	<%
	/* removed massge after page refresh */
	httpSession.removeAttribute("sessionMsg");
	}
	%>
	<!--  Code for the Delete session tracking  -->
	<%
	
	String msg = (String) httpSession.getAttribute("deleteSessionMsg");

	if (msg != null) {
	%>
	<div class="alert alert-danger" role="alert">
		<%=msg%>
	</div>

	<%
	/* removed massge after page refresh */
	httpSession.removeAttribute("deleteSessionMsg");
	}
	%>





	<div class="container">
		<table class="table table-striped" border="1px">
			<thead class="bg-success text-white ">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">ToDo</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<!-- Code for the display dynamic record from the table -->
				<%
				ToDoDao dao = new ToDoDao();
				List<Entity> list = dao.getAllToDodetails();
				for (Entity e : list) {
				%>
				<tr>
					<th scope="row"><%=e.getId()%></th>
					<th scope="row"><%=e.getName()%></th>
					<td><%=e.getToDo()%></td>
					<td><%=e.getStatus()%></td>
					<td><a href="edit.jsp?id=<%=e.getId() %>" class="btn btn-sm btn-success">
							Edit </a> <a href="delete?id=<%=e.getId()%>"
						class="btn btn-sm btn-danger">Delete</a></td>
				</tr>
				<%
				}
				%>


			</tbody>
		</table>
	</div>

</body>
</html>