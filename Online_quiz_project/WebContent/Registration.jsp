<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online quiz</title>
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
top:200px;
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
align:center;
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
  <div class="image">
     <div class="form-content">
       <form action="insert" method="post" autocomplete="off"><br>
        <h2>Create Account</h2>
        <input type="text" id="invalid" name="invalid" value="${invalid}" disabled><br><br>
        <label><b>User ID:        </b></label>
        <input type="text" id="id" name="id" value="${id}" required><br><br>
        <label><b>Username:        </b></label>
        <input type="text" id="username" name="username" value="${username}" required><br><br>
        <!--<label id="nameval" style="color:red; visibility: hidden;">Please enter the name</label><br>  -->
        <label><b>Email id:        </b></label>
        <input type="email" id="email" name="emailid" value="${emailid}" required><br><br>
        <!--<label id="mailval" style="color:red; visibility:hidden;">Please enter the mail</label><br>  -->
        <label><b>Password:        </b></label>
        <input type="password" id="pass" name="userpassword" value="${userpassword}" required><br><br>
        <!--<label id="invalid_password" style="color:red;visibility:hidden;">Password must contain atleast 8 characters</label><br>  -->
        <label><b>Confirm Password:</b></label>
        <input type="password" id="conpass" name="confirmpassword" value="${confirmpassword}" required><br><br><br>
        <button name="submit">Sign Up</button><br> <br><br>
       </form>
    </div>
   </div>
</body>
</html>