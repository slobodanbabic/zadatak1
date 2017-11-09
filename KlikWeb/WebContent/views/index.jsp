<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet"	href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" />
</head>
<body>	
	<div class="container">
		<h1>Login Form!</h1>
		<form action="/KlikWeb/clicks" method="post">
			<div class="form-group">
				<label>username:</label> 
				<input type="text" name="username"	class="form-coontrol"> <br>
			</div>
			<div class="form-group">
				<label>password:</label>
				 <input type="text" name="password" class="form-coontrol"> <br>
			</div>
			<input type="submit" class="btn btn-success" value="Login">
		</form>
		<br>
		<p style="color:red">
			${poruka}
		</p>
	</div>
</body>

</html>	