<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Profile</title>
<style>
 .container{
 position:relative;
 text-align:center;
 border:2px solid green;
 left:30%;
 width:550px;
 height:auto;
 }
 .viewprofile{
  position:relative;
  text-align:center;
 }
 input{
   position:relative;
   float:right;
   margin-right:120px;
   height:25px;
   border-radius:5px;
 }
 label{
  position:relative;
  float:left;
  margin-left:120px;
  font-size:20px;
 // font-weight:bold;
 }
 #user{
  position:relative;
  float:leftt;
  margin-left:0px;
 }
 #edit{
  position:relative;
  float:right;
  margin-right:120px;
  cursor:pointer;
 }
</style>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
<div class="container">
 <div class="viewprofile" id="view">
   <h2>View Profile</h2>
   <i class='fas fa-user-circle' style='font-size:80px;color:green;' id="user"></i><br>
   <i class="fas fa-edit" style='color:black;' id="edit"></i><br><br><br>
   <label>Id:</label><input type="text" value="${User.id}" name="userid" readonly="readonly"><br><br><br>
   <label>Name:</label><input type="text" value="${User.username}" name="userid" readonly="readonly"><br><br><br>
   <label>Email Id:</label><input type="text" value="${User.emailid}" name="userid" readonly="readonly"><br><br><br>
   <label>Password:</label><input type="password" value="${User.userpassword}" name="userid" readonly="readonly"><br><br><br>
 </div></div>
</body>
</html>