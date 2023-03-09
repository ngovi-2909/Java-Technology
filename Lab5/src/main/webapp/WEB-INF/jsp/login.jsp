<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <h3 class="text-center text-secondary mt-5 mb-3">User Login</h3>
            <form class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light" action = "login" method = "post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input name = "username" id="username" type="text" class="form-control" placeholder="Username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input name = "password" id="password" type="password" class="form-control" placeholder="Password">
                </div>
                
                <div class="form-group">
                    <button class="btn btn-success px-5">Login</button>
                </div>
                
                <div class="form-group">
                    <p>Forgot password? <a href="#">Click here</a></p>
                </div>
                <div class="form-group">
              <c:if test="${not empty flash_message}">
              <div class="alert alert-danger alert-dismissible fade show">${flash_message}</div>
                <button type="button" class="close" data-dismiss="alert"></button>
                </c:if>
               </div>
            </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>
