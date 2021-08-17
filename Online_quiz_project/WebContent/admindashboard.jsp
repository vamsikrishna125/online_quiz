<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<style>
  h1{
   text-align:center;
   font-family:"Lucida Calligraphy";
   color:black;
  }
  form{
   position:relative;
   top:80px;
  }
  button{
    position:absolute;
    float:left;
    width:200px;
    height:150px;
    text-align:center;
    top:55px;
    left:22px;
    border:none;
    font-size:20px;
    font-family:"Lucida Calligraphy";
    background-color:#000;
    color:#07de41;
    border-radius:5px;
    cursor:pointer;
  }
  #userdetails{
   position:relative;
   top:40%;
   left:10%;
  }
   #facultydetails{
   position:relative;
   top:40%;
   left:15%;
  }
   #quizdetails{
   position:relative;
   top:40%;
   left:20%;
  }
  #marksdetails{
   position:relative;
   top:40%;
   left:25%;
  }
</style>
</head>
<body>
<h1>Admin Dashboard</h1>
<form action="listUser" method="post">
    <input type="hidden" name="teachername" value="Admin">
    <input type="hidden" name="teacherid" value="1">
    <button id="userdetails">Student Details</button>
  </form>
  <form action="listfaculty">
    <input type="hidden" name="teachername" value="Admin">
    <input type="hidden" name="teacherid" value="1">
    <button id="facultydetails">Faculty Details</button>
  </form>
  <form action="quizdetails">
     <input type="hidden" name="teachername" value="Admin">
     <input type="hidden" name="teacherid" value="1">
     <button id="quizdetails">Quiz Details</button>
  </form>
  <form action="markdetails">
    <input type="hidden" name="teachername" value="Admin">
    <input type="hidden" name="teacherid" value="1">
     <button id="marksdetails">Marks Details</button>
  </form>
</body>
</html>