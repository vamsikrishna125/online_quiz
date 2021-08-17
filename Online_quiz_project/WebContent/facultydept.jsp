<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style>
  body{
   position:absolute;
  // text-align:center;
   top:200px;
   left:400px;
   font-size:20px;
  }
  button{
   text-align:center;
   border:none;
   background-color:#07de14;
   width:80px;
   height: 30px;
   border-radius:5px;
   font-size:15px;
   cursor:pointer;
  }
  #facultyname{
   display:none;
  }
  h2{
   position:fixed;
   top:30px;
   left:30px;
  }
  
</style>
<script type="text/javascript">
  function show(){
	  var dept=document.getElementById("dept");
	  var csesub=document.getElementById("csesubjects");
	  var ecesub=document.getElementById("ecesubjects");
	  var eeesub=document.getElementById("eeesubjects");
	  var itsub=document.getElementById("itsubjects");
	  var civilsub=document.getElementById("civilsubjects");
	  var mechsub=document.getElementById("mechsubjects");
	  var btn=document.getElementById("btn");
	  csesub.style.display= dept.value=="cse" ? "block" : "none" ;
	  ecesub.style.display= dept.value=="ece" ? "block" : "none" ;
	  eeesub.style.display= dept.value=="eee" ? "block" : "none" ;
	  itsub.style.display= dept.value=="it" ? "block" : "none" ;
	  civilsub.style.display= dept.value=="civil" ? "block" : "none" ;
	  mechsub.style.display= dept.value=="mech" ? "block" : "none" ;
	  btn.style.display= dept.value!="" ? "block" : "none"; 
  }
</script>
</head>
<body>
   <h2>Welcome ${facultyname}</h2>
    <form action="insertFacultydept" method="post">
     <div class="form-group">
       <input type="text" value='${facultyname}' name="facultyname" readonly="readonly" id="facultyname"><br>
       <input type="hidden" value="${facultyid}" name="facultyid" id="facultyid">
       <label for="dept">Choose Department:</label>
       <select name="dept" id="dept" onchange="show()">
         <option value="select" selected>--Select department--</option>
         <option value="cse">Computer Science and Engineering</option>
         <option value="ece">Electronics and Communication Engineering</option>
         <option value="eee">Electrical and Electronics Engineering</option>
         <option value="it">Information Technology</option>
         <option value="civil">Civil Engineering</option>
         <option value="mech">Mechanical Engineering</option>
       </select>
      </div><br>
     <div class="csesub" id="csesubjects" style="display:none;">
      <label for="csesub">Choose Subject:</label>
        <select name="subjectcse" id="cse">
         <option value="select" selected>--Select Subject--</option>
         <option value="c">C</option>
         <option value="java">Java</option>
         <option value="python">Python</option>
         <option value="html">HTML</option>
         <option value="css">CSS</option>
         <option value="js">Java Script</option>
       </select>
       </div> 
     <div class="ecesub" id="ecesubjects" style="display:none;">
      <label for="ecesub">Choose Subject:</label>
        <select name="subjectece" id="ece">
         <option value="select" selected>--Select Subject--</option>
         <option value="c">C</option>
         <option value="dc">Digital Communication</option>
         <option value="ds">Data Structures</option>
         <option value="mp">Micro Processor</option>
         <option value="hd">HardWare Design</option>
       </select>
     </div> 
      <div class="eeesub" id="eeesubjects" style="display:none;">
      <label for="eeesub">Choose Subject:</label>
        <select name="subjecteee" id="eee">
         <option value="select" selected>--Select Subject--</option>
         <option value="cs">Control System</option>
         <option value="td">Transmission and Distribution</option>
         <option value="pcp">Power System Protection</option>
         <option value="eca">Electric Circuit Analysis</option>
       </select>
     </div> 
     <div class="itsub" id="itsubjects" style="display:none;">
      <label for="itsub">Choose Subject:</label>
       <select name="subit" id="it">
         <option value="select" selected>--Select Subject--</option>
         <option value="cc">C</option>
         <option value="javait">Java</option>
         <option value="dsit">Data Structures</option>
         <option value="pyit">Python</option>
       </select>
      </div>
      <div class="civilsub" id="civilsubjects" style="display:none;">
      <label for="civilsub">Choose Subject:</label>
         <select name="subjectcivil" id="civil">
         <option value="select" selected>--Select Subject--</option>
         <option value="sa">Structural Analysis</option>
         <option value="apc">Air Pollution and Control</option>
         <option value="hgd">Highway Geometric Design</option>
         <option value="geo">Geology</option>
       </select>
      </div>
      <div class="mechsub" id="mechsubjects" style="display:none;">
      <label for="mechsub">Choose Subject:</label>
        <select name="subjectmech" id="mech">
         <option value="select" selected>--Select Subject--</option>
         <option value="thermo">Thermodynamics</option>
         <option value="sm">Solid Mechanics</option>
         <option value="csd">Control System Design</option>
         <option value="km">Kinematics of Machinery</option>
        </select>
      </div><br>
     <div class="btn" id="btn" style="display:none;">
      <button>Submit</button>
     </div>
    </form>
</body>
</html>