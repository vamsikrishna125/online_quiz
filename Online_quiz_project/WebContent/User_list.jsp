<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Quiz User Details</title>
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
   left:350px;
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
   left:350px;
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
   background-color:#08de41;
   width:250px;
   height:30px;
   font-size:15px;
   border:none;
   cursor:pointer;
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
   background-color:black;
   color:white;
   top:190px;
   text-9align:center; 
   width:250px;
   height:30px;
   font-size:15px;
   border:none;
   cursor:pointer;
  }
  #quiz:hover{
   background-color:green;
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
<body background="quizlogo2.jpg">
  <div class="row">
		 
		 <div class="navbar">
		 <div class="image"></div>
         <div class="userlogo"><i class='fas fa-user-circle' style='font-size:70px;color:#07de41;'></i><br><br>
         </div>
         <h4>${teachername}</h4>
        <c:if test="${teachername=='Admin'}">
		 <a href="admindashboard.jsp"><button id="home">Home</button></a>
		 <a><button id="user">Student Details</button></a>
		 <a href="listfaculty?teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>"><button id="faculty">Facutly Details</button></a>
		 <a href="quizdetails?teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>"><button id="quiz">Quiz Details</button></a>
		 <a href="markdetails?teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>"><button id="marks">Marks Details</button></a>
		 <a href="logout.jsp"><button id="logout">Log Out</button></a>
		 </c:if>
		 <c:if test="${teachername!='Admin'}">
		 <a href="facultydashboard?teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>"><button id="home">Home</button></a>
		 <a><button id="user">Student Details</button></a>
		 <a href="addQuiz?teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>"><button id="faculty">Create Quiz</button></a>
		 <a href="FacultyQuizdetails?teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>"><button id="quiz">Quiz Details</button></a>
		 <a href="markdetails?teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>"><button id="marks">Marks Details</button></a>
		 <a href="logout.jsp"><button id="logout">Log Out</button></a>
		 </c:if>
		 </div>

		<div class="container">
			<h2 class="text-center">List of Users</h2>
			<hr width=550px; align=center>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newUser?teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>" class="adduserbutton"><button id="addbutton">Add
					New User</button></a>
			</div>
			<br>
			<table border="1" class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>User Name</th>
						<th width=150px>Email Id</th>
						<th>Password</th>
						<th>Marks</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.username}" /></td>
							<td width=200px><c:out value="${user.emailid}" /></td>
							<td><c:out value="${user.userpassword}" /></td>
							<td><a href="viewMarks?id=<c:out value='${user.id}' />&&teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>">View</a></td>
							<td><a href="editUser?id=<c:out value='${user.id}'/>&&teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
							 <a href="deleteUser?id=<c:out value='${user.id}'/>&&teachername=<c:out value="${teachername}" />&&teacherid=<c:out value='${teacherid}'/>">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>