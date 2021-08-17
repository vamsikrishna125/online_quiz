package userWeb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userDao.UserDAO;
import userBean.Faculty;
import userBean.Marks;
import userBean.Quiz;
import userBean.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
       
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		userDAO = new UserDAO();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/newUser":
				showNewUserForm(request, response);
				break;
			case "/newFaculty":
				showNewFacultyForm(request, response);
				break;			
			case "/newQuestion":
				showNewQuestionForm(request, response);
				break;
			case "/insert":
				insert(request, response);
				break;
			case "/insertUser":
				insertUser(request, response);
				break;
			case "/insertFaculty":
				insertFaculty(request, response);
				break;
			case "/insertFacultydept":
				insertFacultydept(request, response);
				break;
			case "/insertquestion":
				insertQuestion(request, response);
				break;
			case "/deleteUser": 
				deleteUser(request, response);
				break;
			case "/deletefaculty":
				deletefaculty(request, response);
				break;
			case "/deleteQuestion":
				deleteQuestion(request, response);
				break;
			case "/editUser":
				showEditUserForm(request, response);
				break;
			case "/editfaculty":
				 showEditFacultyForm(request, response);
				 break;
			case "/editQuestion":
				 showEditQuestionForm(request, response);
				 break;
			case "/updateUser":
				updateUser(request, response);
				break;
			case "/updateFaculty":
				updateFaculty(request, response);
				break;
			case "/updateQuestion":
				updateQuestion(request, response);
				break;
			case "/listUser":
				listUser(request, response);
				break;
			case "/listfaculty":
				listfaculty(request, response);
				break;
			case "/listQuestions":
				listQuestions(request, response);
				break;
			case "/createquiz":
				createQuiz(request , response);
				break;
			case "/addQuiz":
				addQuiz(request, response);
				break;
			case "/facultydashboard":
				facultyDashboard(request, response);
				break;
			case "/quizdetails":
				Quizdetails(request, response);
				break;
			case "/viewQuiz":
				viewQuiz(request , response);
				break;
			case "/seeQuiz":
				seeQuiz(request, response);
				break;
			case "/FacultyQuizdetails":
				FacultyQuizdetails(request, response);
				break;
			case "/studentquiz":
				 studentQuiz(request, response);
				 break;
			case "/viewMarks":
				  viewMarks(request, response);
				  break;
			case "/markdetails":
				  MarksDetails(request, response);
				  break;
			case "/viewStudentProfile":
				viewStudentProfile(request, response);
				break;
			case "/viewMarkslist":
				viewMarkslist(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	} 

     //view Student profile
	 public void viewStudentProfile(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
		 int studentid=Integer.parseInt(request.getParameter("studentid"));
		 String studentname=request.getParameter("studentname");
		 User user= userDAO.studentprofile(studentid,studentname);
		 RequestDispatcher dispatcher=request.getRequestDispatcher("Studentprofile.jsp");
		 request.setAttribute("User", user);
		 dispatcher.forward(request, response);
	 }
	 
	 //view Marks List
	 public void viewMarkslist(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
		 int studentid=Integer.parseInt(request.getParameter("studentid"));
		 String studentname=request.getParameter("studentname");
		 List<Marks> listmarks= userDAO.DisplayMarks(studentid);
		 RequestDispatcher dispatcher=request.getRequestDispatcher("StudentMarksList.jsp");
		 request.setAttribute("studentid", studentid);
		 request.setAttribute("studentname", studentname);
		 request.setAttribute("MarksList", listmarks);
		 dispatcher.forward(request, response);
	 }
	 
	 //faculty Dashboard
	 public void facultyDashboard(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
		 String teachername=request.getParameter("teachername");
		 int teacherid =Integer.parseInt(request.getParameter("teacherid"));
		 RequestDispatcher dispatcher = request.getRequestDispatcher("facultydashboard.jsp");
		 request.setAttribute("teachername", teachername);
		 request.setAttribute("teacherid",teacherid);
		 dispatcher.forward(request, response);
	 }
	
	 //add Quiz
	 public void addQuiz(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
		 String username=request.getParameter("teachername");
		 String teachername=request.getParameter("teachername");
		 int teacherid =Integer.parseInt(request.getParameter("teacherid"));
		 RequestDispatcher dispatcher = request.getRequestDispatcher("addQuiz.jsp");
		 request.setAttribute("teachername", teachername);
		 request.setAttribute("username", teachername);
		 request.setAttribute("teacherid",teacherid);
		 dispatcher.forward(request, response);
	 }
	 
	 //quiz details
	 private void Quizdetails(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			userDAO=new UserDAO();
			String username=request.getParameter("teachername");
			String teachername=request.getParameter("teachername");
			int teacherid=Integer.parseInt(request.getParameter("teacherid"));
			List<Quiz> quizzes = userDAO.selectAllQuiz();
			request.setAttribute("listQuiz", quizzes);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Quiz_list.jsp");
			request.setAttribute("username",username);
			request.setAttribute("teachername", teachername);
			request.setAttribute("teacherid", teacherid);
			dispatcher.forward(request, response);
		}
	 
	//student marks list
	 private void  MarksDetails(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
		    userDAO=new UserDAO();
		    String teachername=request.getParameter("teachername");
		    int teacherid=Integer.parseInt(request.getParameter("teacherid"));
			List<Marks> listmarks = userDAO.selectMarksList();
			request.setAttribute("listMarks", listmarks);
			RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayMarksList.jsp");
			request.setAttribute("teachername",teachername);
			request.setAttribute("teacherid", teacherid);
			dispatcher.forward(request, response);
	 }
	 
	 //view Quiz
	 private void viewQuiz(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
		 String quizname=request.getParameter("quizname");
		 String teachername = request.getParameter("teachername");
		 int teacherid = Integer.parseInt(request.getParameter("teacherid"));
		 List<Quiz> listquiz=userDAO.selectAllQuestions(quizname);
		 request.setAttribute("listQuestions", listquiz);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("Questions_list.jsp");
		 request.setAttribute("quizname", quizname);
		 request.setAttribute("teachername", teachername);
		 request.setAttribute("teacherid",teacherid);
	     dispatcher.forward(request, response);
	 }
	 
	 //user side quiz display
	 private void seeQuiz(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
		 String studentdept=request.getParameter("studentdept");
		 String quizname=request.getParameter("quizname");
		 List<Quiz> quizlen=userDAO.selectAllQuestions(quizname);
		 int len=quizlen.size();
		 int i=0;
		 int x=Integer.parseInt(request.getParameter("x"));
		 int score=Integer.parseInt(request.getParameter("score"));
		 int stuid=Integer.parseInt(request.getParameter("stuid"));
		 String studentname=request.getParameter("studentname");
		 if(len>=20) {
			 i=20;
		 }
		 else {
			 i=len;
		 }
		if((len>=20 && x<=20) || (len<20 && x<=len)) {
		 Quiz listquiz=userDAO.selectQuestion(x,quizname);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("StudentQuestions_list.jsp");
		 request.setAttribute("question", listquiz);
		 request.setAttribute("quizname", quizname);
		 request.setAttribute("x", x);
		 request.setAttribute("score", score);
		 request.setAttribute("studentdept", studentdept);
		 request.setAttribute("stuid", stuid);
		 request.setAttribute("i","i");
	     dispatcher.forward(request, response);
		}
		else {
			//List<Marks> facultyquiz=userDAO.facultyquizforMarks(studentdept,quizname);
			userDAO.insertMarks(score,x-1,studentdept,quizname,stuid);
			RequestDispatcher dispatcher=request.getRequestDispatcher("MarksDisplay.jsp");
			 request.setAttribute("quizname", quizname);
			 request.setAttribute("x", i);
			 request.setAttribute("score", score);
			 request.setAttribute("studentdept", studentdept);
			 request.setAttribute("stuid", stuid);
			 request.setAttribute("username", studentname);
			 dispatcher.forward(request, response);
		}
	 }
	 
	 //view Student Marks
	 public void viewMarks(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
		 int id=Integer.parseInt(request.getParameter("id"));
		 int teacherid=Integer.parseInt(request.getParameter("teacherid"));
		 String teachername=request.getParameter("teachername");
		 List<Marks> listmarks= userDAO.DisplayMarks(id);
		 RequestDispatcher dispatcher=request.getRequestDispatcher("DisplayMarksList.jsp");
		 request.setAttribute("teachername",teachername);
		 request.setAttribute("teacherid", teacherid);
		 request.setAttribute("listMarks", listmarks);
		 dispatcher.forward(request, response);
	 }
	 
	 //List of users
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		userDAO=new UserDAO();
		String teachername=request.getParameter("teachername");
		String facultyname=request.getParameter("teachername");
		System.out.println(teachername+"fafafdsfafafa"+facultyname);
		int teacherid=Integer.parseInt(request.getParameter("teacherid"));
		System.out.println(teacherid);
		List< User > listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("User_list.jsp");
		request.setAttribute("teachername", teachername);
		request.setAttribute("teacherid", teacherid);
		request.setAttribute("facultyname",facultyname);
		dispatcher.forward(request, response);
	}

	 //List of faculty
	private void listfaculty(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		userDAO=new UserDAO();
		String teachername=request.getParameter("teachername");
		int teacherid=Integer.parseInt(request.getParameter("teacherid"));
		System.out.println(teachername+"listFaculty"+teacherid);
		List<Faculty> listfaculty = userDAO.selectAllfaculty();
		request.setAttribute("listfaculty", listfaculty);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Faculty_list.jsp");
		request.setAttribute("teachername", teachername);
		request.setAttribute("teacherid", teacherid);
		dispatcher.forward(request, response);
	}
	
	//List questions
	private void listQuestions(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		userDAO=new UserDAO();
		String username=request.getParameter("username");
		String teachername=(String)request.getParameter("teachername");
		int teacherid =Integer.parseInt(request.getParameter("teacherid"));
		System.out.println(teachername+"fdasfsa"+teacherid);
		String quizname=(String) request.getAttribute("quizname");
		List<Quiz> listquiz=userDAO.selectAllQuestions(quizname);
		request.setAttribute("listQuestions", listquiz);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Questions_list.jsp");
		request.setAttribute("quizname", quizname);
		request.setAttribute("teachername", teachername);
		//request.setAttribute("facultyname", facultyname);
		request.setAttribute("teacherid", teacherid);
		dispatcher.forward(request, response);
	}
	
	private void showNewUserForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teachername = request.getParameter("teachername");
		int teacherid= Integer.parseInt(request.getParameter("teacherid"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("User_form.jsp");
		request.setAttribute("teachername", teachername);
		request.setAttribute("teacherid", teacherid);
		dispatcher.forward(request, response);
	}
	
	private void showNewFacultyForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teachername=request.getParameter("teachername");
		int teacherid=Integer.parseInt(request.getParameter("teacherid"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("Faculty_form.jsp");
		request.setAttribute("teachername", teachername);
		request.setAttribute("teacherid", teacherid);
		dispatcher.forward(request, response);
	}
	
	private void showNewQuestionForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String quizname=request.getParameter("quizname");
		String teachername = request.getParameter("teachername");
		int teacherid= Integer.parseInt(request.getParameter("teacherid"));
		System.out.print("show New Edit form : "+quizname+"fsaf"+teachername+"id"+teacherid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("QuestionEdit_form.jsp");
		request.setAttribute("quizname", quizname);
		request.setAttribute("teachername", teachername);
		request.setAttribute("teacherid", teacherid);
		dispatcher.forward(request, response);
	}

	private void showEditUserForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		String teachername=request.getParameter("teachername");
		int teacherid= Integer.parseInt(request.getParameter("teacherid"));
		System.out.println(teachername+"facultyid"+teacherid);
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("User_form.jsp");
		request.setAttribute("user", existingUser);
		request.setAttribute("teachername", teachername);
		request.setAttribute("teacherid", teacherid);
		dispatcher.forward(request, response);

	}
	
	private void showEditFacultyForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int facultyid =Integer.parseInt(request.getParameter("facultyid"));
		String teachername=request.getParameter("teachername");
		int teacherid =Integer.parseInt(request.getParameter("teacherid"));
		Faculty existingFaculty = userDAO.selectFaculty(facultyid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Faculty_form.jsp");
		request.setAttribute("faculty", existingFaculty);
		request.setAttribute("teachername", teachername);
		request.setAttribute("teacherid", teacherid);
		dispatcher.forward(request, response);

	}
	
	private void showEditQuestionForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int qno=Integer.parseInt(request.getParameter("qno"));
		String quizname=request.getParameter("quizname");
		String teachername=request.getParameter("teachername");
		int teacherid= Integer.parseInt(request.getParameter("teacherid"));
		Quiz editquestion=userDAO.selectQuestion(qno,quizname);
		System.out.print(teachername+"dsfsf");
		RequestDispatcher dispatcher = request.getRequestDispatcher("QuestionEdit_form.jsp");
		request.setAttribute("question", editquestion);
		request.setAttribute("quizname", quizname);
		request.setAttribute("teachername", teachername);
		request.setAttribute("teacherid", teacherid);
		dispatcher.forward(request, response);		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int id=Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String emailid = request.getParameter("emailid");
		String userpassword = request.getParameter("userpassword");
		String confirmpassword = request.getParameter("confirmpassword");
		if(userpassword.equals(confirmpassword)) {
			User newUser = new User(id, username, emailid, userpassword,confirmpassword);
			if(id<1000) {
				int verify=userDAO.verifyRegister(id);
				if(verify==1) {
			        userDAO.insertUser(newUser);
			        RequestDispatcher dispatcher=request.getRequestDispatcher("dept.jsp");
			        request.setAttribute("id", id);
			        dispatcher.forward(request, response);
				}
				else {
					String invalid="Already a registered user or verify your details once";
					RequestDispatcher dispatcher=request.getRequestDispatcher("Registration.jsp");
					request.setAttribute("invalid", invalid);
					request.setAttribute("id", id);
					request.setAttribute("username", username);
					request.setAttribute("emailid", emailid);
					request.setAttribute("userpassword", userpassword);
					request.setAttribute("confirmpassword", confirmpassword);
					dispatcher.forward(request, response);
				}
			}
			else {
				Faculty newFaculty = new Faculty(id, username, emailid, userpassword,confirmpassword);
				int verify=userDAO.verifyFacultyRegister(id);
				if(verify==1) {
				 userDAO.insertFaculty(newFaculty);
				//System.out.print("Inserted Faculty");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("facultydept.jsp");
				 request.setAttribute("facultyname", username);
				 request.setAttribute("facultyid", id);
				 dispatcher.forward(request, response);	
				}
				else {
					String invalid="Already a registered faculty or verify your details once";
					RequestDispatcher dispatcher=request.getRequestDispatcher("Registration.jsp");
					request.setAttribute("invalid", invalid);
					request.setAttribute("id", id);
					request.setAttribute("username", username);
					request.setAttribute("emailid", emailid);
					request.setAttribute("userpassword", userpassword);
					request.setAttribute("confirmpassword", confirmpassword);
					dispatcher.forward(request, response);
				}
			}
		}
		else{
			System.out.println(userpassword);
			System.out.println(confirmpassword);
			String invalid="Password does not match with confirm password";
			RequestDispatcher dispatcher=request.getRequestDispatcher("Registration.jsp");
			request.setAttribute("invalid", invalid);
			request.setAttribute("id", id);
			request.setAttribute("username", username);
			request.setAttribute("emailid", emailid);
			request.setAttribute("userpassword", userpassword);
			request.setAttribute("confirmpassword", confirmpassword);
			dispatcher.forward(request, response);
	  }
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("username");
		String emailid = request.getParameter("emailid");
		String userpassword = request.getParameter("userpassword");
		String confirmpassword = userpassword;
		String teachername= request.getParameter("teachername");
		int teacherid =Integer.parseInt(request.getParameter("teacherid"));
		User newUser = new User(id, name, emailid, userpassword, confirmpassword);
		int verify=userDAO.verifyRegister(id);
		 if(verify==1) {
			userDAO.insertUser(newUser);
			System.out.print("new user name"+teachername);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listUser");
			//request.setAttribute("name", name);
			request.setAttribute("teachername", teachername);
			request.setAttribute("teacherid", teacherid);
			dispatcher.forward(request, response);	
		  }
		 else {
				String invalid="Already a registered user or please verify the details.";
				RequestDispatcher dispatcher = request.getRequestDispatcher("User_form.jsp");
				request.setAttribute("invalid", invalid);
				request.setAttribute("id", id);
				request.setAttribute("username",name);
				request.setAttribute("emailid", emailid);
				request.setAttribute("userpassword", userpassword);
				request.setAttribute("confirmpassword", confirmpassword);
				dispatcher.forward(request, response);	
		}
	}
	
	private void insertFaculty(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int facultyid=Integer.parseInt(request.getParameter("facultyid"));
		String facultyname = request.getParameter("facultyname");
		String facultyemail = request.getParameter("facultyemail");
		String facultypassword = request.getParameter("facultypassword");
		String facultyconfirmpassword = facultypassword;
		String branch = request.getParameter("branch");
		String subject = request.getParameter("subject");
		String teachername = request.getParameter("teachername");
		int teacherid=Integer.parseInt(request.getParameter("teacherid"));
		Faculty newFaculty = new Faculty(facultyid, facultyname, facultyemail, facultypassword, facultyconfirmpassword, branch, subject);
		int verify=userDAO.verifyFacultyRegister(facultyid);
		if(verify==1) {
		userDAO.insertFaculty(newFaculty);
		//System.out.print("Inserted Faculty");
		RequestDispatcher dispatcher = request.getRequestDispatcher("listfaculty");
		request.setAttribute("teachername", teachername);
		request.setAttribute("teacherid", teacherid);
		request.setAttribute("facultyname", facultyname);
		dispatcher.forward(request, response);
		}
		else {
			String invalid="Already a registered faculty or please verify the details.";
			RequestDispatcher dispatcher = request.getRequestDispatcher("Faculty_form.jsp");
			request.setAttribute("invalid", invalid);
			request.setAttribute("id", facultyid);
			request.setAttribute("username", facultyname);
			request.setAttribute("emailid", facultyemail);
			request.setAttribute("userpassword", facultypassword);
			request.setAttribute("confirmpassword", facultyconfirmpassword);
			request.setAttribute("branch", branch);
			request.setAttribute("subject", subject);
			dispatcher.forward(request, response);	
	}
	}
	
	private void insertFacultydept(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		 String facultyname=request.getParameter("facultyname");
		 int facultyid=Integer.parseInt(request.getParameter("facultyid"));
		 String branch=request.getParameter("dept");
		 String subject;
		 if(branch.equals("cse"))
		     subject=request.getParameter("subjectcse");
		 else if(branch.equals("ece"))
		     subject=request.getParameter("subjectece");
		 else if(branch.equals("eee"))
			   subject=request.getParameter("subjecteee");
		 else if(branch.equals("it"))
			   subject=request.getParameter("subit");
		 else if(branch.equals("civil"))
			   subject=request.getParameter("subjectcivil");
		 else if(branch.equals("mech"))
			   subject=request.getParameter("subjectmech");
		 else
		     subject=request.getParameter("subjectcse");
		 System.out.print(subject);
		 userDAO.facultyDept(facultyid,branch,subject);
		 RequestDispatcher dispatcher=request.getRequestDispatcher("facultydashboard.jsp");
	     request.setAttribute("teachername", facultyname);
	     request.setAttribute("teacherid", facultyid);
	     dispatcher.forward(request, response);
	}
	
	private void insertQuestion(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		String quizname=request.getParameter("quizname");
		String question=request.getParameter("question");
		String optiona=request.getParameter("optiona");
		String optionb=request.getParameter("optionb");
		String optionc=request.getParameter("optionc");
		String optiond=request.getParameter("optiond");
		String correctoption=request.getParameter("correctoption");
		String teachername= request.getParameter("teachername");
		int teacherid =Integer.parseInt(request.getParameter("teacherid"));
		System.out.print(teachername);
		Quiz quiz= new Quiz(question, optiona, optionb, optionc, optiond, correctoption);
		userDAO.insertQuestion(quiz,quizname);
		System.out.print(quizname);
		RequestDispatcher dispatcher=request.getRequestDispatcher("listQuestions");
		request.setAttribute("quizname", quizname);
		request.setAttribute("teachername", teachername);
		request.setAttribute("teacherid", teacherid);
		dispatcher.forward(request, response);
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("username");
		String emailid = request.getParameter("emailid");
		String userpassword = request.getParameter("userpassword");
		String confirmpassword = request.getParameter("confirmpassword");
		User user = new User(id, name, emailid, userpassword,confirmpassword);
		String teachername= request.getParameter("teachername");
		int teacherid =Integer.parseInt(request.getParameter("teacherid"));
		System.out.println(teachername+"adsfasfda"+teacherid);
		userDAO.updateUser(user);
		System.out.println(teachername+"after updating the user"+teacherid);
		RequestDispatcher dispatcher=request.getRequestDispatcher("listUser");
		request.setAttribute("teachername", teachername);
		request.setAttribute("teacherid", teacherid);
		dispatcher.forward(request, response);
	}

	private void updateFaculty(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int facultyid = Integer.parseInt(request.getParameter("facultyid"));
		String facultyname = request.getParameter("facultyname");
		String facultyemail = request.getParameter("facultyemail");
		String facultypassword = request.getParameter("facultypassword");
		String branch = request.getParameter("branch");
		String subject = request.getParameter("subject");
		String teachername=request.getParameter("teachername");
		int teacherid=Integer.parseInt(request.getParameter("teacherid"));
		Faculty faculty = new Faculty(facultyid, facultyname, facultyemail, facultypassword, branch, subject);
		userDAO.updateFaculty(faculty);
		System.out.println(teachername+"update faculty"+teacherid);
		RequestDispatcher dispatcher=request.getRequestDispatcher("listfaculty");
		request.setAttribute("teachername", teachername);
		request.setAttribute("teacherid", teacherid);
		dispatcher.forward(request, response);
	}
	
	private void updateQuestion(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int qno=Integer.parseInt(request.getParameter("qno"));
		String question=request.getParameter("question");
		String optiona=request.getParameter("optiona");
		String optionb=request.getParameter("optionb");
		String optionc=request.getParameter("optionc");
		String optiond=request.getParameter("optiond");
		String correctoption=request.getParameter("correctoption");
		String quizname=request.getParameter("quizname");
		String teachername= request.getParameter("teachername");
		int teacherid = Integer.parseInt(request.getParameter("teacherid"));
		Quiz quiz=new Quiz(qno,question, optiona, optionb, optionc, optiond, correctoption);
		userDAO.updateQuestion(quiz,quizname);
		RequestDispatcher dispatcher=request.getRequestDispatcher("listQuestions");
		request.setAttribute("quizname", quizname);
		request.setAttribute("teachername", teachername);
		request.setAttribute("teacherid", teacherid);
		dispatcher.forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		    String teachername=request.getParameter("teachername");
		    int teacherid= Integer.parseInt(request.getParameter("teacherid"));
		    int id = Integer.parseInt(request.getParameter("id"));
			userDAO.deleteUser(id);
			System.out.println(teachername+"Delete"+teacherid);
		    RequestDispatcher dispatcher= request.getRequestDispatcher("listUser");
		    request.setAttribute("teachername", teachername);
		    request.setAttribute("teacherid", teacherid);
		    dispatcher.forward(request, response);
	}
	
	private void deletefaculty(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		String teachername=request.getParameter("teachername");
		int teacherid = Integer.parseInt(request.getParameter("teacherid"));
		int facultyid = Integer.parseInt(request.getParameter("facultyid"));
		System.out.print(facultyid);
		userDAO.deletefaculty(facultyid);
		RequestDispatcher dispatcher= request.getRequestDispatcher("listfaculty");
	    request.setAttribute("teachername", teachername);
	    request.setAttribute("teacherid", teacherid);
	    dispatcher.forward(request, response);
	}
	
	//deleting a question
	private void deleteQuestion(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		int qno=Integer.parseInt(request.getParameter("qno"));
		String quizname=request.getParameter("quizname");
		String teachername=request.getParameter("teachername");
		int teacherid=Integer.parseInt(request.getParameter("teacherid"));
		System.out.println(teachername+"sadf"+teacherid+"fdgs");
		userDAO.deleteQuestion(qno,quizname);
		RequestDispatcher dispatcher=request.getRequestDispatcher("listQuestions");
		request.setAttribute("quizname", quizname);
		request.setAttribute("username", teachername);
		request.setAttribute("teachername",teachername);
		request.setAttribute("teacherid", teacherid);
		dispatcher.forward(request, response);
	}
	
	private void createQuiz(HttpServletRequest request , HttpServletResponse response)
	        throws SQLException , IOException, ServletException{
		String quizname=request.getParameter("quizname");
		String teachername=request.getParameter("teachername");
		int teacherid=Integer.parseInt(request.getParameter("teacherid"));
		String department=userDAO.takeFacultyDept(teacherid);
		System.out.print(teachername);
		userDAO.createQuiz(quizname);
		userDAO.insertQuiz(quizname, teachername, teacherid, department);
		RequestDispatcher dispatcher=request.getRequestDispatcher("addquestions.jsp");
		request.setAttribute("quizname", quizname);
		request.setAttribute("teachername",teachername);
		request.setAttribute("teacherid", teacherid);
		dispatcher.forward(request, response);
	}
	
	//faculty quiz details
	private void FacultyQuizdetails(HttpServletRequest request , HttpServletResponse response)
	        throws SQLException , IOException, ServletException{
		userDAO=new UserDAO();
		String teachername=request.getParameter("teachername");
		//String facultyname=request.getParameter("facultyname");
		int teacherid=Integer.parseInt(request.getParameter("teacherid"));
		System.out.println(teachername);
		System.out.println(teacherid);
		String department=userDAO.takeFacultyDept(teacherid);
		System.out.println(department);
		List<Quiz> listquiz=userDAO.selectFacultyQuiz(teachername,department);
		request.setAttribute("listQuiz", listquiz);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Quiz_list.jsp");
		request.setAttribute("teachername",teachername);
		//request.setAttribute("facultyname",facultyname);
		request.setAttribute("teacherid", teacherid);
		//request.setAttribute("department", dept);
		dispatcher.forward(request, response);
	}
	
	//student Quiz 
	private void studentQuiz(HttpServletRequest request , HttpServletResponse response)
	        throws SQLException , IOException, ServletException{
		String studentdept=request.getParameter("studentdept");
		int stuid=Integer.parseInt(request.getParameter("stuid"));
		String studentname= request.getParameter("studentname");
		List<Quiz> quizzes=userDAO.displayQuiz(studentdept);
		RequestDispatcher dispatcher=request.getRequestDispatcher("studentQuiz_list.jsp");
		request.setAttribute("Quizzes", quizzes);
		request.setAttribute("studentdept", studentdept);
		request.setAttribute("stuid", stuid);
		request.setAttribute("username", studentname);
		dispatcher.forward(request, response);
	}
}
