import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
@WebServlet("/Verifylogin")
public class Verifylogin extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		 int id=Integer.parseInt(req.getParameter("id")); 
		 String username=req.getParameter("username");
		 String userpassword=req.getParameter("userpassword");
		 int facultyid=Integer.parseInt(req.getParameter("id"));
		 String facultyname=req.getParameter("username");
		 String facultypassword=req.getParameter("userpassword");
		 int i=0,j=0;
		 try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		     Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=samplelogin;","sa","root");
	         //System.out.print("Database Connected");
			 Statement st=con.createStatement();
		   	if(id<1000) {
			 ResultSet rs=st.executeQuery("select id,username,userpassword from student;");
			 while(rs.next()) {
				 int uid=rs.getInt("id");
				 String name=rs.getString("username");
				 String pass=rs.getString("userpassword");
				 if(uid==id && name.equals(username) && pass.equals(userpassword)) {
				    i=1;
				    break;
				 }
				 else {
					 i=0;
				 } 
			 }
			}
			else {
				 ResultSet rs=st.executeQuery("select facultyid,facultyname,facultypassword from faculty;");
				 while(rs.next()) {
					 int uid=rs.getInt("facultyid");
					 String name=rs.getString("facultyname");
					 String pass=rs.getString("facultypassword");
					 if(uid==facultyid && name.equals(facultyname) && pass.equals(facultypassword)) {
					    j=1;
					    break;
					 }
					 else {
						 j=0;
					 } 
				 }
			}
			 if(username.equals("quizadmin") && userpassword.equals("quizadmin")) {
				 res.sendRedirect("admindashboard.jsp");
			 }
			 else if(i==1) {
				 RequestDispatcher dispatcher=req.getRequestDispatcher("dept.jsp");
			        req.setAttribute("id", id);
			        req.setAttribute("username", username);
			        dispatcher.forward(req, res);
			 }
			 else if(j==1) {
				 RequestDispatcher dispatcher=req.getRequestDispatcher("facultydashboard.jsp");
				 req.setAttribute("teachername", facultyname);
				 req.setAttribute("teacherid", facultyid);
				 dispatcher.forward(req, res);
			 }
			 else {
				 String invalid="Invalid details. If you are not registered please Sign Up";
				 RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				 req.setAttribute("invalid", invalid);
				 req.setAttribute("id", id);
				 req.setAttribute("username", username);
				 req.setAttribute("userpassword", userpassword);
				 dispatcher.forward(req, res);
			 }
				 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	}
}