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
   left:400px;
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
   left:400px;
  }
</style>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
  <div class="row">
		<div class="container">
			<h2 class="text-center">Marks</h2>
			<hr width=550px; align=center>
			<br>
			<table border="1" class="table table-bordered">
				<thead>
					<tr>
						<th>Sno</th>
						<th>Student Id</th>
						<!--<th>Faculty Id</th>
						<th>Faculty Name</th>-->
						<th>Department</th>
						<th>Subject</th>
						<th>Marks Obtained</th>
						<th>Total</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="user" items="${MarksList}">

						<tr>
							<td><c:out value="${user.marksid}" /></td>
							<td><c:out value="${user.stuid}" /></td>
							<!--<td><c:out value="${user.conductedid}"/></td>
							<td><c:out value="${user.conductedname}"/></td>-->
							<td><c:out value="${user.studept}" /></td>
							<td><c:out value="${user.sub}" /></td>
							<td><c:out value="${user.marks}"/></td>
							<td><c:out value="${user.total}"/></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>