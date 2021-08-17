<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add/Edit Question</title>
<style>
  h2{
   text-align:center;  
  }
  table{
   position:relative;
   text-align:left;
   left:500px;
   border-spacing:15px;
  }
  td label{
   width:100px;
  }
  td input{
   width:250px;
  }
  button{
    position:relative;
    width:100px;
    height:30px;
    background-color:#04de17;
    text-align:center;
    font-size:15px;
    border:none;
    left:630px;
    cursor:pointer;
  }
  #quizname{
   display:none;
  }
  #qno{
   position:relative;
   right:124px;
   border:none;
   width:50px;
   font-size:20px;
  }
</style>
</head>
<body>
  <div class="container">
   <c:if test="${question != null}">
     <form action="updateQuestion" method="post">
   </c:if>
   <c:if test="${question == null}">
	 <form action="insertquestion" method="post">
   </c:if>
   <h3>${quizname} Quiz</h3>
   <c:if test="${question!=null}">
     <h2>Edit Question</h2>
   </c:if>
   <c:if test="${question==null}">
     <h2>Add Question</h2>
   </c:if>
   <table>
   <tr id="quizname"><td><label>Quizname:</label></td>
   <td><input type="text" value="<c:out value='${quizname}'/>" name="quizname"></td></tr>
   <tr <c:if test="${question!=null}"></c:if>><td>
   <td><input type="text" value="<c:out value='${question.qno}'/>" name="qno" id="qno" required="required" readonly="readonly"></td></tr>
   <tr><td><label>Question:</label> </td>
   <td><input type="text" value="<c:out value='${question.question}'/>" name="question" required="required"></td></tr>
   <tr><td><label>Option A:</label> </td>
   <td><input type="text" value="<c:out value='${question.optiona}' />" name="optiona" required="required"></td></tr>
   <tr><td><label>Option B:</label> </td>
   <td><input type="text" value="<c:out value='${question.optionb}' />" name="optionb" required="required"></td></tr>
   <tr><td><label>Option C:</label> </td>
   <td><input type="text" value="<c:out value='${question.optionc}' />" name="optionc" required="required"></td></tr>
   <tr><td><label>Option D:</label> </td>
   <td><input type="text" value="<c:out value='${question.optiond}' />" name="optiond" required="required"></td></tr>
   <tr><td><label>Correct Option:</label> </td>
   <td><input type="text" value="<c:out value='${question.correctoption}' />" name="correctoption" required="required"></td></tr>
   </table><br>
    <input type="hidden" value="${teachername}" name="teachername">
  <input type="hidden" value="${teacherid}" name="teacherid">
   <button type="submit">Save</button>
   </form>
</div>
</body>
</html>