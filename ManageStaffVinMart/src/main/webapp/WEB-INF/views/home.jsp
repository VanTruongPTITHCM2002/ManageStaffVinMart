<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang = "en" dir = "ltr">
    <head>
        <meta charset="utf-8">
        <title>Quản lý nhân viên cửa hàng VinMart</title>
      <style>
      body{
    margin: 0;
    padding: 0;
    font-family:montserrat;
    background-image: linear-gradient(120deg,#2c9be4,#8b47a8);
    height: 100vh;
    overflow: hidden;
}

.center{
    position:absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    width: 400px;
    background: white;
    border-radius: 10px;
}

.center h1{
    text-align: center;
    padding: 0 0 20px 0;
    border-bottom:  1px solid silver;
}

.center form {
    padding: 0 40px;
    box-sizing: border-box;
}

form .txt-field{
    position: relative;
    border-bottom: 2px solid #adadad;
    margin: 30px 0;
}

.txt-field input{
    width:100%;
    padding: 0 5px;
    height: 40px;
    font-size: 16px;
    border: none;
    background: none;
    outline: none;
}

.txt-field label{
    position:absolute;
    top:50%;
    left:5px;
    color: #adadad;
    transform: translateY(-50%);
    font-size: 16px;
    pointer-events: none;
    transition: .5s;
}

.txt-field span::before{
    content: '';
    position: absolute;
    top: 40px;
    left:0;
    width: 0%;
    height: 2px;
    background:#2691d9;
    transition: .5s;
}
.txt-field input:focus~label,
.txt-field input:valid~label{
    top:-5px;
    color:#2691d9;
}

.txt-field input:focus~span::before,
.txt-field input:valid~span::before{
   width: 100%;
}

.pass{
    margin: -5px 0 20px 5px;
    color:#a6a6a6;
    cursor: pointer;
}

.pass:hover{
    text-decoration: underline;
}

input[type = "submit"]{
    width: 100%;
    height: 50px;
    border: 1px solid;
    background: #2691d9;
    border-radius:25px;
    font-size: 18px;
    color: #e9f4fb;
    font-weight: 700;
    cursor: pointer;
    outline: none;
}

input[type = "submit"]:hover{
    border-color: #2691d9;
    transition: .5s;
}

.signup_link{
    margin:30px 0;
    text-align: center;
    font-size: 16px;
    color: #666666;
}

.signup_link a{
    color: #2691d9;
    text-decoration: none;
}

.signup_link a:hover{
    text-decoration: underline;
}
      	
      </style>
      
    </head>

    <body>
        <div class="center">
            <h1>Login</h1>
            <form method = "post" action = "home.html">
                <div class="txt-field">
                    <input type="text"  name = "user" required>
                    <span></span>
                    <label >Tài khoản:</label>
                </div>
                <div class="txt-field">
                    <input type="password" name = "password" required>
                    <span></span>
                    <label >Mật khẩu:</label>
                </div>
                <input type="submit" name = "login" value = "Login">
                
                <div class="signup_link">
                <c:if test="${status == 0}">
  					<p  style = "color: red" id = "mess">${message}</p>
  					</c:if>
                </div>
                	<script>
				    // Lấy element chứa message
				    var messageDiv = document.getElementById("mess");
				    // Nếu element tồn tại và có message
				    if (messageDiv != null && messageDiv.innerHTML.trim() != "") {
				        // Đóng message sau 5 giây
				        setTimeout(function() {
				            messageDiv.style.display = "none";
				        }, 2000); // thời gian đóng message (5 giây)
    					}
				</script>
            </form>
        </div>
    </body>
</html>