<%@page import="com.jspider.ToDo.dto.Entity"%>
<%@page import="com.jspider.ToDo.dao.ToDoDao"%>
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
	<div class="container">
		<div class="row">
			<div class="col-md 6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h1 class="text-center text-success">ToDo-App Upadate</h1>
						<!--  code for getting input field data from Back-end  -->
						<%
						ToDoDao dao = new ToDoDao();
					     int id=Integer.parseInt(request.getParameter("id"));			
						Entity e = dao.getAllToDoBy__id(id);
						%>


						<form action="updateToDo" method="post">
						<!-- Code for upadte hidden from fields -->
						<input type="hidden" value="<%= e.getId()%>" name="id">
							<div class="form-group">
								<label for="exampleInputPassword1">Name</label> <input
									type="text" class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="username" value="<%=e.getName()%>">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">ToDo</label> <input type="text"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="todo"
									value="<%=e.getToDo()%>">

							</div>

							<div class="form-group">
								<label for="inputState">Status</label> <select id="inputState"
									class="form-control" name="status">
									<!-- Code for selected option in database -->
									<%
								System.out.println(e.getStatus());
									if (e.getStatus().equals("pendding")) {
									%>
									<option value="pendding">Pending</option>
									<option value="completd">Complete</option>
									<%
									} else {
									%>
									<option value="completd">Complete</option>
									<option value="pendding">Pending</option>
									<%
									}
									%>
								</select>
							</div>

							<div class="text=center">
								<button type="submit" class="btn btn-primary">UPDATE</button>

							</div>
						</form>
					</div>
				</div>
			</div>


		</div>
	</div>
</body>
</html>