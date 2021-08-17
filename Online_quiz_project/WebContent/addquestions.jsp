<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add questions</title>
<style>
 form{
  text-align:center;
 }
 input{
  position:relative;
  width:500px;
 }
 #submit{
  width:100px;
  height:30px;
  background-color:#07de41;
  border:none;
  font-size:15px;
  cursor:pointer;
 }
  .navbar{
    position:absolute;
    background-color:#000;
    width:250px;
    height:100%;
    opacity:0.8;
  }
  .fas fa-user-circle{
    position:relative;
    top:20px;
    left:120px;
  }
  #home{
   position:relative;
   background-color:black;
   color:white;
   top:70px;
   text-align:center; 
   width:250px;
   height:30px;
   font-size:15px;
   border:none;
   cursor:pointer;
  }
  #home:hover{
   background-color:green;
  }
   #user{
   position:relative;
   top:110px;
   text-align:center; 
   background-color:black;
   color:white;
   width:250px;
   height:30px;
   font-size:15px;
   border:none;
   cursor:pointer;
  }
  #user:hover{
   background-color:green;
  }
  #faculty{
   position:relative;
   background-color:black;
   color:white;
   top:150px;
   text-align:center; 
   width:250px;
   height:30px;
   font-size:15px;
   border:none;
   cursor:pointer;
  }
  #faculty:hover{
   background-color:green;
  }
  #quiz{
   position:relative;
   //background-color:#08de41;
   //color:white;
   top:190px;
   text-9align:center; 
   width:250px;
   height:30px;
   font-size:15px;
   border:none;
   cursor:pointer;
  }
  #marks{
   position:relative;
   background-color:black;
   color:white;
   top:230px;
   text-align:center; 
   width:250px;
   height:30px;
   font-size:15px;
   border:none;
   cursor:pointer;
  }
  #marks:hover{
   background-color:green;
  }
  #logout{
   position:relative;
   background-color:black;
   color:white;
   top:270px;
   text-align:center; 
   width:250px;
   height:30px;
   font-size:15px;
   border:none;
   cursor:pointer;
  }
  #logout:hover{
    background-color:green;
  }
  .navbar a{
   position:absolute;
   text-decoration:none;
   color:#000;
   
  }
  .image{
    position:absolute;
    //background-color:green;
    background-image: url("Chrysanthemum.jpg");
    width:50px;
    height:50px;
    align:center;
    right:100px;
  }
  .userlogo{
   position:relative;
   top:80px;
   left:95px;
  }
  h4{
   position:relative;
   top:50px;
   text-align:center;
   color:white;
  }
</style>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
    <div class="navbar">
		 <div class="image"></div>
         <div class="userlogo"><i class='fas fa-user-circle' style='font-size:70px;color:#07de41;'></i><br><br>
         </div>
         <h4>${teachername}</h4>
        <c:if test="${teachername=='Admin'}">
		 <a href="admindashboard.jsp"><button id="home">Home</button></a>
		 <a href="listUser?teachername=<c:out value="${teachername}"/>&&teacherid=<c:out value='${teacherid}'/>"><button id="user">Student Details</button></a>
		 <a href="listfaculty?teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>"><button id="faculty">Facutly Details</button></a>
		 <a href="quizdetails?username=<c:out value="${teachername}" />&&facultyid=<c:out value='${teacherid}'/>"><button id="quiz" style="background-color:#08de41;">Quiz Details</button></a>
		 <a href="markdetails?username=<c:out value="${teachername}" />&&facultyid=<c:out value='${teacherid}'/>"><button id="marks">Marks Details</button></a>
		 <a href="logout.jsp"><button id="logout">Log Out</button></a>
		 </c:if>
		 <c:if test="${teachername!='Admin'}">
		 <a href="facultydashboard?teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>"><button id="home">Home</button></a>
		 <a href="listUser?teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>"><button id="user">Student Details</button></a>
		 <a><button id="faculty" style="background-color:#08de41;">Create Quiz</button></a>
		 <a href="FacultyQuizdetails?facultyname=<c:out value="${teachername}" />&&facultyid=<c:out value='${teacherid}'/>"><button id="quiz" style="background-color:black; color:white;">Quiz Details</button></a>
		 <a href="markdetails?username=<c:out value="${teachername}" />&&facultyid=<c:out value='${teacherid}'/>"><button id="marks">Marks Details</button></a>
		 <a href="logout.jsp"><button id="logout">Log Out</button></a>
		 </c:if>
		 </div>
    <div>
     <form action="insertquestion">
     <input type="text" value="${teachername}" name="teachername">
     <input type="text" value="${teacherid}" name="teacherid">
     <h1>Add Question</h1>
     <label>Quiz name:</label>
     <input type="text" value="${quizname}" name="quizname" readonly="readonly"><br><br>
     <label>Question: </label>
     <input type="text" id="question" name="question"><br><br>
     <label>Option A:</label>
     <input type="text" id="optiona" name="optiona"><br><br>
     <label>Option B:</label>
     <input type="text" id="optionb" name="optionb"><br><br>
     <label>Option C:</label>
     <input type="text" id="optionc" name="optionc"><br><br>
     <label>Option D:</label>
     <input type="text" id="optiond" name="optiond"><br><br>
     <label>Correct Answer:</label>
     <input type="text" id="correctoption" name="correctoption"><br><br>
     <button type="submit" id="submit">Save</button>
   </form>
  </div>
</body>
</html>