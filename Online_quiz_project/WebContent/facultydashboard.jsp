<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Faculty Dashboard</title>
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
    background-color:black;
    color:#07de14;
    border-radius:5px;
    cursor:pointer;
  }
  #userdetails{
   position:relative;
   top:40%;
   left:10%;
  }
   #addquiz{
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
  h3{
   text-align:left;
  }
</style>
</head>
<body>
<h3>Welcome ${teachername}</h3>
<h1>Faculty Dashboard</h1>
 <form action="listUser" method="post">
   <input type="hidden" value="${teachername}" name="teachername">
   <input type="hidden" value="${teacherid}" name="teacherid">
   <button id="userdetails">Student Details</button>
  </form>
<form action="addQuiz">
  <input type="hidden" value="${teachername}" name="teachername" id="facultyname1">
  <input type="hidden" value="${teacherid}" name="teacherid" id="facultyid1">
  <button id="addquiz">Add Quiz</button>
</form>
  <form action="FacultyQuizdetails">
     <input type="hidden" value="${teachername}" name="teachername" id="facultyname">
     <input type="hidden" value="${teacherid}" name="teacherid" id="facultyid">
     <button id="quizdetails">Quiz Details</button>
  </form>
  <form action="markdetails">
     <input type="hidden" value="${teachername}" name="teachername" id="facultyname">
     <input type="hidden" value="${teacherid}" name="teacherid" id="facultyid">
     <button id="marksdetails">Marks Details</button>
  </form>
</body>
</html>