<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz details</title>
<style type="text/css">
  .container h2{
    text-align:center;
  }
  #addbutton{
   position:relative;
   background-color:#04de17;
   text-decoration:none;
   font-size:15px;
   width:130px;
   height:40px;
   left:300px;
   border:none;
   cursor:pointer;
  }
  table,th,td{
    boarder:2px;
    align:center;
  }
  td{
   width:100px;
  }
  table{
   position:relative;
   text-align:center;
   border-collapse: collapse;
   left:300px;
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
   background-color:#08de41;
   color:white;
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
   <div class="row">
		<div class="navbar">
		 <div class="image"></div>
         <div class="userlogo"><i class='fas fa-user-circle' style='font-size:70px;color:#07de41;'></i><br><br>
         </div>
         <c:if test="${teachername=='Admin'}">
         <h4>${teachername}</h4>
		 <a href="admindashboard.jsp"><button id="home">Home</button></a>
		 <a href="listUser?teachername=<c:out value="${teachername}"/>&&teacherid=<c:out value='${teacherid}'/>"><button id="user">Student Details</button></a>
		 <a href="listfaculty?teachername=<c:out value="${teachername}"/>&&teacherid=<c:out value='${teacherid}'/>"><button id="faculty">Facutly Details</button></a>
		 <a><button id="quiz">Quiz Details</button></a>
		 <a href="markdetails?teachername=<c:out value="${teachername}"/>&&teacherid=<c:out value='${teacherid}'/>"><button id="marks">Marks Details</button></a>
		 <a href="logout.jsp"><button id="logout">Log Out</button></a>
		 </c:if>
		 <c:if test="${teachername!='Admin'}">
		 <h4>${teachername}</h4>
		 <a href="facultydashboard?teachername=<c:out value="${teachername}"/>&&teacherid=<c:out value='${teacherid}'/>"><button id="home">Home</button></a>
		 <a href="listUser?teachername=<c:out value="${teachername}"/>&&teacherid=<c:out value='${teacherid}'/>"><button id="user">Student Details</button></a>
		 <a href="addQuiz?teachername=<c:out value="${teachername}"/>&&teacherid=<c:out value='${teacherid}'/>"><button id="faculty">Create Quiz</button></a>
		 <a href="FacultyQuizdetails?teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>"><button id="quiz">Quiz Details</button></a>
		 <a href="markdetails?teachername=<c:out value="${teachername}"/>&&teacherid=<c:out value='${teacherid}'/>"><button id="marks">Marks Details</button></a>
		 <a href="logout.jsp"><button id="logout">Log Out</button></a>
		 </c:if>
		 </div>

		<div class="container">
			<h2 class="text-center">Quiz Details</h2>
			<hr width=600px; align="center">
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/addQuiz?teachername=<c:out value="${teachername}"/>&&teacherid=${teacherid}" class="adduserbutton"><button id="addbutton">Add
					New Quiz</button></a>
			</div>
			<br>
			<table border="1" class="table table-bordered">
				<thead>
					<tr>
					  <th>Quiz ID</th>
					  <th>Quiz Name</th>
					  <th>Faculty id</th>
					  <th>Faculty Name</th>
					  <th>Department</th>
					  <th>Date</th>
					  <th>Time</th>
					  <th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="quiz" items="${listQuiz}">
					  <tr>
						<td><c:out value="${quiz.quizid}" /></td>
						<td><c:out value="${quiz.quizname}" /></td>
						<td><c:out value="${quiz.facultyid}"/></td>
						<td><c:out value="${quiz.conducted}" /></td>
						<td><c:out value="${quiz.department}"/></td>
						<td><c:out value="${quiz.date}" /></td>
						<td><c:out value="${quiz.time}" /></td>
						<td><a href="viewQuiz?quizname=<c:out value='${quiz.quizname}' />&&teachername=<c:out value="${teachername}"/>&&teacherid=<c:out value='${teacherid}'/>">View Quiz</a></td>
					 </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>