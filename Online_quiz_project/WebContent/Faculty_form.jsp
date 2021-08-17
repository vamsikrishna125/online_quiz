<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add/Edit Faculty</title>
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
</style>
</head>
<body>
  <div class="container">
   <c:if test="${faculty != null}">
     <form action="updateFaculty" method="post">
   </c:if>
   <c:if test="${faculty == null}">
	 <form action="insertFaculty" method="post">
   </c:if>
   <c:if test="${faculty!=null}">
     <h2>Edit Faculty</h2>
   </c:if>
   <c:if test="${faculty==null}">
     <h2>Add Faculty</h2>
   </c:if>
   <table>
   <tr><td><label>Faculty Id:</label> </td>
   <td><input type="text" value="<c:out value='${faculty.facultyid}' />" name="facultyid" required="required"></td></tr>
   <tr><td><label>Faculty Name:</label> </td>
   <td><input type="text" value="<c:out value='${faculty.facultyname}' />" name="facultyname" required="required"></td></tr>
   <tr><td><label>Email Id:</label> </td>
   <td><input type="email" value="<c:out value='${faculty.facultyemail}' />" name="facultyemail" required="required"></td></tr>
   <tr><td><label>Password:</label> </td>
   <td><input type="password" value="<c:out value='${faculty.facultypassword}' />" name="facultypassword" required="required"></td></tr>
   <tr><td><label>Department:</label> </td>
   <td><input type="text" value="<c:out value='${faculty.branch}' />" name="branch" required="required"></td></tr>
   <tr><td><label>Subject:</label> </td>
   <td><input type="text" value="<c:out value='${faculty.subject}' />" name="subject" required="required"></td></tr>
   </table><br>
   <input type="hidden" value="${teachername}" name="teachername">
   <input type="hidden" value="${teacherid}" name="teacherid">
   <button type="submit">Save</button>
   </form>
</div>
</body>
</html>