<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>View Quizzes</title>
<style>
  .main h1{
   text-align:center;
  }
 table{
  border-spacing:15px;
 }
 .subject{
  position:relative;
  diplay:inline-block;
  background-color:lightgreen;
  width:500px;
  height:100px;
  text-align:center;
  top:10%;
  left:80%;

 }
 .sub{
  padding-left:inherit;
  padding-top:inherit;
  position:absolute;
  font-size:25px;
  margin-left:25px;
  margin-top:35px;
 }
 .btn{
   padding-left:inherit;
  padding-top:inherit;
  position:absolute;
  background-color:#efefef;
  margin-left:380px;
  margin-top:38px;
  text-align:center;
  width:80px;
  height:20px;
  border:1px solid black;
 }
 a{
  text-align:center;
  color:black;
  text-decoration:none;
 }
 
#logout{
 position:fixed;
 background-color:red;
 color:white;
 top:20px;
 right:20px;
 width:100px;
 height:30px;
 border:none;
 font-size:17px;
 cursor:pointer;
 border-radius:5px;
 border:2px solid #f00033;
}
#logout:hover{
 border:none;
 color:black;
font-size:20px;
 }
 .userlogo{
   position:relative;
   float:right;
  // top:0px;
   right:0px;
   cursor:pointer;
  }
  .userprofile{
   position:relative;
   text-align:center;
   float:right;
   width:200px;
   height:auto;
   background-color:#434445;
   top:45px;
   right:0px;
   display:none;
  }
  #viewprofile{
     border:none;
     background-color:#434445;
     color:white;
     width:200px;
     height:30px;
     text-align:center
   }
  #viewprofile:hover{
   background-color:#07de14;
  }
  #crossmark{
    position:relative;
    float:right;
    top:8px;
    right:10px;
    color:white;
    font-size:20px;
    cursor:pointer;
  }
  #crossmark:hover{
   color:red;
  }
  #user{
   position:relative;
   top:5px;
  }
</style>
  <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
  <script type = "text/javascript" >
//function preventBack() { window.history.forward(); }
//setTimeout("preventBack()", 0);
//window.onunload = function () { null };

function profile(){
 var profile = document.getElementById("userprofile");
 profile.style.display="block";

}

function profileclose(){
	 var profile = document.getElementById("userprofile");
	 profile.style.display="none";
}
</script>
</head>
<body>
  <div class="main">
  <div class="userlogo"><a onclick="profile();"><i class='fas fa-user-circle' style='font-size:40px;color:#434445;'></i></a><br><br>
         </div>
      <div class="userprofile" id="userprofile">
        <i class='fas fa-user-circle' style='font-size:40px;color:#07de41;' id="user"></i>
        <a onclick="profileclose();"><i class="fa fa-times" aria-hidden="true" id="crossmark"></i></a>
        <h3 style="color:#07de41;">${username}</h3>
        <a href="viewStudentProfile?studentid=${stuid}&&studentname='${username}'"><button id="viewprofile">View Profile</button></a><br>
        <a href="viewMarkslist?studentid=${stuid}&&studentname='${username}'"><button id="viewprofile">View Marks</button></a><br>
        <a href="logout.jsp"><button id="viewprofile">LogOut</button></a><br>
      </div>
  <h1>Test Your Knowledge</h1>
  <table>
    <tbody>
     <c:forEach var="quiz" items="${Quizzes}">
		<tr>
		  <td><div class="subject">
		  <div class="sub"><label><c:out value="${quiz.quizname}"/> Quiz</label></div>
          <div class="btn"><a href="seeQuiz?quizname=<c:out value='${quiz.quizname}'/>&&stuid=${stuid}&&studentdept=${studentdept}&&x=1&&score=0&&studentname=${username}">Start Test</a></div>
          </div></td>
	    </tr>
	  </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>