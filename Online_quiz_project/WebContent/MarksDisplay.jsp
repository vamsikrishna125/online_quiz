<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${quizname} Marks</title>
<style>
 .marks{
   position:relative;
   text-align:center;
   width:500px;
   height:300px;
   left:30%;
   top:130px;
   border:2px solid black;
   box-shadow:5px 5px rgb(68,68,68,0.6);
 }
 p{
  font-size:25px;
 }
 #backquiz{
   position:relative;
   background-color:#07de41;
   text-align:center;
   width:150px;
   height:30px;
   border:none;
   font-size:15px;
   cursor:pointer;
 }
 #grade{
  font-size:15px;
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
<div>
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
   <div class="marks">
   <c:if test="${x==20}">
     <p>${quizname} Quiz</p>
     <p>Your Score is:</p>
     <p>${score}/${x}</p>
     <c:choose>
       <c:when test="${score>x-3}"><p id="grade">Excellent</p></c:when>
       <c:when test="${score>x-5}"><p id="grade">Good</p></c:when>
       <c:when test="${score>x-10}"><p id="grade">Need to work some more time.</p></c:when>
       <c:otherwise><p id="grade">Need to work hard.</p></c:otherwise>
     </c:choose></c:if>
    <c:if test="${x<20 && x!=0}">
      <p>${quizname} Quiz</p>
     <p>Your Score is:</p>
     <p>${score}/${x}</p>
     <c:choose>
       <c:when test="${score>x-2}"><p id="grade">Excellent</p></c:when>
       <c:when test="${score>x-4}"><p id="grade">Good</p></c:when>
       <c:when test="${score>x-10}"><p id="grade">Need to work some more time.</p></c:when>
       <c:otherwise><p id="grade">Need to work hard.</p></c:otherwise>
     </c:choose>
    </c:if>
     <c:if test="${x==0}">
       <p>Sorry , No questions to display </p>
     </c:if>
     <a href="studentquiz?studentdept=<c:out value="${studentdept}"/>&&stuid=${stuid}"><button  id="backquiz">Back to Quizzes</button></a>
  </div>
  </div>
</body>
</html>