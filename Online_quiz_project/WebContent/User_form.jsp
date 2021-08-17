<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit/Add User</title> 
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
  #invalid{
  //display:none;
  position:relative;
  left:500px;
  background-color:white;
  width:420px;
  font-size:15px;
  border:none;
  color:red;
}
</style>
</head>
<body>
<div class="container">
   <c:if test="${user != null}">
     <form action="updateUser" method="post">
   </c:if>
   <c:if test="${user == null}">
	 <form action="insertUser" method="post">
   </c:if>
   <c:if test="${user!=null}">
     <h2>Edit User</h2>
   </c:if>
   <c:if test="${user==null}">
     <h2>Add User</h2>
     <input type="text" id="invalid" name="invalid" value="${invalid}" disabled><br><br>
   </c:if>
   <table>
   <tr><td><label>User Id:</label> </td>
   <td><c:if test="${user==null}"><input type="text" value="<c:out value='${user.id}' />" name="id" required="required"></c:if>
   <c:if test="${user!=null}"><input type="text" value="<c:out value='${user.id}' />" name="id" readonly="readonly"></c:if></td></tr>
   <tr><td><label>User Name:</label> </td>
   <td><input type="text" value="<c:out value='${user.username}' />" name="username" required="required"></td></tr>
   <tr><td><label>Email Id:</label> </td>
   <td><input type="email" value="<c:out value='${user.emailid}' />" name="emailid" required="required"></td></tr>
   <tr><td><label>Password:</label> </td>
   <td><input type="password" value="<c:out value='${user.userpassword}' />" name="userpassword" required="required"></td></tr>
   </table><br>
   <input type="hidden" value="${teachername}" name="teachername">
   <input type="hidden" value="${teacherid}" name="teacherid">
   <button type="submit">Save</button>
   </form>
</div>
</body>
</html>