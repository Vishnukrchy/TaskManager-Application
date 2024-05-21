<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="Componnets/allCSS.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="Componnets/navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md 6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center text-success">
							ToDo-App
							</h1>
							<form action="addToDo" method="post">
							 <div class="form-group">
								<label for="exampleInputPassword1">Name</label> <input
									type="text" class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="username">
							</div> 
								<div class="form-group">
									<label for="exampleInputEmail1">ToDo</label> <input type="text"
										class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" name="todo">

								</div>
								
								<div class="form-group">
									<label for="inputState">Status</label> <select id="inputState"
										class="form-control" name="status">
										<option selected value="selected">Select...</option>
										<option value="pendding"> Pending</option>
										<option value="completd">Complete</option>
									</select>
								</div>

								<div class="text=center">
									<button type="submit" class="btn btn-primary">ADD</button>

								</div>
							</form>
					</div>
				</div>
			</div>


		</div>
	</div>
</body>
</html>