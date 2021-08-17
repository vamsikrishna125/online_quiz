<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${quizname} Quiz</title>
<style type="text/css">
 body{
  text-align:center;
 }
  .container h2{
    text-align:center;
  }
  .container{
   position:relative;
   text-align:center;
   padding:10px 20px;
   background-color:white;
   width:500px;
   height:auto;
   left:30%;
   top:130px;
   border:2px solid black;
   box-shadow:5px 5px rgb(68,68,68,0.6);
  }
  #addbutton{
   position:relative;
   background-color:#04de17;
   text-decoration:none;
   font-size:15px;
   width:130px;
   height:40px;
   left:210px;
   border:none;
   cursor:pointer;
  }
  table{
   position:relative;
   text-align:left;
   border-spacing:10px;
   align-items:center;
   justify-content:center;
  }
  .submit{
   position:relative;
   background-color:#07de41;
   text-align:center;
   width:90px;
   height:30px;
   border:none;
   font-size:15px;
   cursor:pointer;
  }
  .submit:hover{
   width:100px;
   
  }
  button a{
   text-decoration:none;
  }
</style>
<script type="text/javascript">
// var score=0;
  function ascore(){
	  var optiona=document.getElementById("optiona");
	  var optionb=document.getElementById("optionb");
	  var optionc=document.getElementById("optionc");
	  var optiond=document.getElementById("optiond");
	  var correctoption=document.getElementById("correctoption");
	  var scored=document.getElementById("score");
	  if(optiona.checked)
    	  if(optiona.value==correctoption.value)
    		  scored.value++;
      if(optionb.checked)
    	  if(optionb.value==correctoption.value)
    		  scored.value++;
      if(optionc.checked)
    	  if(optionc.value==correctoption.value)
    		  scored.value++;
      if(optiond.checked)
    	  if(optiond.value==correctoption.value)
    		 scored.value++;
      //alert(scored.value);
      document.getElementById("score").value=scored.value;
     //return score;
  }
  //document.getElementById("score").value=score;
</script>
</head>
<body>
  <div class="form">
    <form action="seeQuiz" method="post">
		<div class="container">
			<h2 class="text-center">${quizname} Quiz</h2>
			<table class="table table-bordered">
				<tbody>
						<tr><td><label><b><c:out value="${question.qno}" />.  <c:out value="${question.question}" /></b></label></td></tr>
						<tr><td><input type="radio" id="optiona" name="${question.qno}" value="${question.optiona}"><c:out value="${question.optiona}" /></td></tr>
						<tr><td><input type="radio" id="optionb" name="${question.qno}" value="${question.optionb}"><c:out value="${question.optionb}" /></td></tr>
						<tr><td><input type="radio" id="optionc" name="${question.qno}" value="${question.optionc}"><c:out value="${question.optionc}" /></td></tr>
						<tr><td><input type="radio" id="optiond" name="${question.qno}" value="${question.optiond}"><c:out value="${question.optiond}" /></td></tr>
					    <tr><td><input type="hidden" id="correctoption" name="${question.qno}" value="${question.correctoption}"></td></tr>
				</tbody>
			</table>
			<input type="hidden" name="studentdept" value="${studentdept}" >
			<input type="hidden" name="stuid" value="${stuid}" >
			<input type="hidden" name="quizname" value="${quizname}" id="quizname" >
			<input type="hidden" name="x" value="${x+1}" id="x" >
			<input type="hidden" name="score" value="${score}" id="score" >
		<c:if test="${x<20}"><button type="submit" onclick="ascore();" class='submit'>Next</button></c:if>
	    <c:if test="${x==20}"><button type="submit" class="submit">Submit</button></c:if><br><br>
	</div>
	</form>
	</div>
</body>
</html>