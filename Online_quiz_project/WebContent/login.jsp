<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Quiz</title>
<style>
body{
  min-width:600px;
  max-width:2000px;
}
.image{
    background-image:url(qiz2.jpg); 
    position:relative;
    width:100%;
    height:635px;
    background-repeat:no-repeat;
    background-size:100% 100%;
    opacity:0.9;
}
label{
color:white;
font-weight:800;
}
h2{text-align:center;
color:white;
}
.form-content{
align:center;
text-align:center;
width:500px;
background-color:black;
position:relative;
top:180px;
left:33%;
opacity:0.7;
}
input{
font-size:17px;
color:black;
font-weight:bold;
margin-right:70px;
float:right;
}
#passval,#email{
font-weight:bold;
margin-right:70px;
float:right;
}
p{
color:white;
}
a{
color:cyan;
text-decoration:none;
}
button{
width:100px;
height:30px;
font-size:20px;
background-color:#cdefef;
color:black;
cursor:pointer;
border:1px solid white;
border-radius:5%;
}
button:hover{
  background-color:#00ff00;
}
#invalid{
  //display:none;
  position:relative;
  margin-right:0px;
  background-color:black;
  width:420px;
  font-size:15px;
  border:none;
  color:red;
}
</style>
</head>
<body>
<!--  <%
   response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
%>-->
   <div class="image">
     <div class="form-content">
       <form action="Verifylogin" method="post"><br>
        <h2>Login</h2>
        <input type="text" id="invalid" name="invalid" value="${invalid}" disabled><br><br>
        <label><b>User id:</b></label>
        <input type="text" name="id" id="id" value="${id}" required><br><br>
        <label><b>User name:</b></label>
        <input type="text" name="username" id="username" value="${username}" required><br><br>
        <!--<label id="mailval" style="color:red;visibility:hidden;">Invalid Email Address</label><br>  -->
        <label><b>Password:</b></label>
        <input type="password" name="userpassword" id="userpassword" value="${userpassword}" required><br><br><br>
        <!--<label id="passval" style="color:red;visibility:hidden;">Invalid password</label><br>  -->
       <button name="submit">Submit</button><br>
        <p>Don't have an account? <a href="Registration.jsp"><b>Sign Up</b></a> 
  <br><br>
       </form>
    </div>
   </div>
</body>
</html>