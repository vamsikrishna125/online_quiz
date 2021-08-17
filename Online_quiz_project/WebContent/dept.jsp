<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>ONLINE QUIZ</title>
 <style>
  body{
    background-image:linear-gradient(pink,orange);
 }
 h1{
     text-align:center;
 }
 #branch{
     position:relative;
     text-align:center;
     background-color:rgb(196,73,73);
     cursor:pointer;
     justify-content:center;
     padding:5px 100px;
     left:31%;
     font-size:16px;
     color:white;
     width:500px;
     height:50px;
 }
 #branch:hover{
     background-color:rgb(37,176,30);
     left: 29%;
     width: 550px;
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
<!--  <form action="logout.jsp" method="post">
<button id="logout">Logout</button></form>-->
<div>
<div class="userlogo"><a onclick="profile();"><i class='fas fa-user-circle' style='font-size:40px;color:#434445;'></i></a><br><br>
         </div>
      <div class="userprofile" id="userprofile">
        <i class='fas fa-user-circle' style='font-size:40px;color:#07de41;' id="user"></i>
        <a onclick="profileclose();"><i class="fa fa-times" aria-hidden="true" id="crossmark"></i></a>
        <h3 style="color:#07de41;">${username}</h3>
        <a href="viewStudentProfile?studentid=${id}&&studentname='${username}'"><button id="viewprofile">View Profile</button></a><br>
        <a href="viewMarkslist?studentid=${id}&&studentname='${username}'"><button id="viewprofile">View Marks</button></a><br>
        <a href="logout.jsp"><button id="viewprofile">LogOut</button></a><br>
      </div>
 <h3>Welcome ${username}</h3>
  <h1>Select Your Department</h1>
  <a href="studentquiz?studentdept=cse&&stuid=${id}&&studentname=${username}"><button id="branch">Computer Science and Engineering</button> </a><br><br>
  <a href="studentquiz?studentdept=ece&&stuid=${id}&&studentname=${username}"><button id="branch">Electronics and Communication Engineering</button> </a><br><br>
  <a href="studentquiz?studentdept=eee&&stuid=${id}&&studentname=${username}"><button id="branch">Electrical and Electronics Engineering</button> </a><br><br>
  <a href="studentquiz?studentdept=it&&stuid=${id}&&studentname=${username}"><button id="branch">Information Technology</button> </a><br><br>
  <a href="studentquiz?studentdept=civil&&stuid=${id}&&studentname=${username}"><button id="branch">Civil Engineering</button>  </a><br><br>
 <a href="studentquiz?studentdept=mech&&stuid=${id}&&studentname=${username}"><button id="branch">Mechanical Engineering</button> </a><br><br>
  <a href="studentquiz?studentdept=aptitude&&stuid=${id}&&studentname=${username}"><button id="branch">Aptitude &amp; Reasoning </button></a><br><br>
</div>
</body>
</html>