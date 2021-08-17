package userDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.apache.tomcat.jni.Time;

import userBean.Faculty;
import userBean.Marks;
import userBean.Quiz;
import userBean.User;

public class UserDAO {
	private String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=samplelogin;";
	private String jdbcUsername = "sa";
	private String jdbcPassword = "root";

	private static final String INSERT_USERS_SQL = "INSERT INTO student" + "  (id,username, emailid, userpassword,confirmpassword) VALUES "
			+ " (?, ?, ?, ?, ?);";
	private static final String INSERT_FACULTY_SQL = "INSERT INTO faculty" + "  (facultyid,facultyname, facultyemail, facultypassword, facultyconfirmpassword, branch, subject) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id ,username ,emailid ,userpassword from student where id =?;";
	//private static final String SELECT_ALL_USERS = "select * from student;";
	private static final String DELETE_USERS_SQL = "delete from student where id = ?;";
	//private static final String UPDATE_USERS_SQL = "update student set username = ?, emailid= ?, userpassword =? where id = ?;";
	
	public UserDAO() {
	}

	//connection with sql server through JDBC driver
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//verify Registration 
	public int verifyRegister(int id) throws SQLException{
		int verify=1;
		String verification="select id from student where id="+id+";";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(verification)) {
			 ResultSet rs=preparedStatement.executeQuery();
			 while(rs.next()) {
				 int uid=rs.getInt("id");
				 if(uid==id)
					 verify=0;
				 else 
					 verify=1;
			 }
		} catch (SQLException e) {
			printSQLException(e);
		}
		return verify;
	}

	//verify faculty registration
	public int verifyFacultyRegister(int id) throws SQLException{
		int verify=1;
		String verification="select facultyid from faculty where facultyid="+id+";";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(verification)) {
			 ResultSet rs=preparedStatement.executeQuery();
			 while(rs.next()) {
				 int uid=rs.getInt("facultyid");
				 if(uid==id)
					 verify=0;
				 else 
					 verify=1;
			 }
		} catch (SQLException e) {
			printSQLException(e);
		}
		return verify;
	}
	
	//insert user
	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getEmailid());
			preparedStatement.setString(4, user.getUserpassword());
			preparedStatement.setString(5, user.getConfirmpassword());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	//insert Faculty
		public void insertFaculty(Faculty newFaculty) throws SQLException {
			try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FACULTY_SQL)) {
				preparedStatement.setInt(1, newFaculty.getFacultyid());
				preparedStatement.setString(2, newFaculty.getFacultyname());
				preparedStatement.setString(3, newFaculty.getFacultyemail());
				preparedStatement.setString(4, newFaculty.getFacultypassword());
				preparedStatement.setString(5, newFaculty.getFacultyconfirmpassword());
				preparedStatement.setString(6, newFaculty.getBranch());
				preparedStatement.setString(7, newFaculty.getSubject());
				preparedStatement.executeUpdate();
				//createfaculty(newFaculty.getFacultyname());
			} catch (SQLException e) {
				printSQLException(e);
			}
		}
		
	//inserting faculty dept and subject
		public void  facultyDept(int facultyid , String branch, String subject) throws SQLException {
			String insertfacdept="update faculty set branch=?, subject=? where facultyid=?";
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(insertfacdept);) {
				preparedStatement.setInt(3, facultyid);
				preparedStatement.setString(1,branch);
				preparedStatement.setString(2,subject);
				preparedStatement.executeUpdate();
			}catch (SQLException e) {
				printSQLException(e);
			}
		}
	  
	//insertMarks
	 public void insertMarks(int score, int x, String studept, String sub, int stuid) {
		 String insertMark="insert into marks"+"(studept,sub,stuid,marks, total)"+" values"+"(?,?,?,?,?);";
		 try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(insertMark)) {
					preparedStatement.setString(1, studept);
					preparedStatement.setString(2,sub);
					preparedStatement.setInt(3, stuid);
					preparedStatement.setInt(4, score);
					preparedStatement.setInt(5, x);
					//preparedStatement.setInt(6, conductedid);
					//preparedStatement.setString(7, conductedname);
					preparedStatement.executeUpdate();
					//createfaculty(newFaculty.getFacultyname());
				} catch (SQLException e) {
					printSQLException(e);
				}
	 }
	 
	 //display user marks
	 public List<Marks> DisplayMarks(int id) {
		 String selectMark="select * from marks where stuid=?";
		 List<Marks> marks=new ArrayList<>();
		 try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(selectMark)) {
			    preparedStatement.setInt(1,id);
			    ResultSet rs=preparedStatement.executeQuery();
			    while(rs.next()) {
			    	int marksid=rs.getInt("marksid");
			    	String studept=rs.getString("studept");
			    	String sub=rs.getString("sub");
			    	int mark=rs.getInt("marks");
			    	int total=rs.getInt("total");
			    	int conductedid=rs.getInt("conductedid");
			    	String conductedname=rs.getString("conductedname");
			    	marks.add(new Marks(marksid, studept, sub, id, mark, total, conductedid, conductedname));
			    }
		 }catch (SQLException e) {
				printSQLException(e);
			}
		 return marks;
	 }
		
	//select user details to edit
	public User selectUser(int id) {
		User user = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				String emailid = rs.getString("emailid");
				String userpassword = rs.getString("userpassword");
				user = new User(id, username, emailid, userpassword);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}
	
	//select faculty details to edit
	public Faculty selectFaculty(int facultyid) {
		Faculty faculty = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select facultyid ,facultyname , facultyemail ,facultypassword, branch, subject from faculty where facultyid =?;");) {
			preparedStatement.setInt(1, facultyid);
			//System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String facultyname = rs.getString("facultyname");
				String facultyemail = rs.getString("facultyemail");
				String facultypassword = rs.getString("facultypassword");
				String branch = rs.getString("branch");
				String subject = rs.getString("subject");
				faculty = new Faculty(facultyid, facultyname, facultyemail, facultypassword, branch, subject);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return faculty;
	}
	
	//select question to edit
	public Quiz selectQuestion(int qno , String quizname) {
		Quiz quiz=null;
		String editquestion="select qno, question, optiona, optionb, optionc, optiond, correctoption from "
		          +quizname+" where qno =?;";
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(editquestion);) {
			preparedStatement.setInt(1, qno);
			//System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String question = rs.getString("question");
				String optiona = rs.getString("optiona");
				String optionb = rs.getString("optionb");
				String optionc = rs.getString("optionc");
				String optiond = rs.getString("optiond");
				String correctoption = rs.getString("correctoption");
				quiz = new Quiz(qno, question, optiona, optionb, optionc, optiond, correctoption);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return quiz;
		
	}
	
    //select all users
	public List<User> selectAllUsers() {
		Connection connection = getConnection();
		List<User> users = new ArrayList<>();
		Statement st;
		try {

				// Step 2:Create a statement using connection object
		   // preparedStatement= connection.prepareStatement("select * from student;"); 
			st=connection.createStatement();
			//System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = st.executeQuery("select * from student");
			System.out.print("Hello");
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String emailid = rs.getString("emailid");
				String userpassword = rs.getString("userpassword");
				users.add(new User(id , username, emailid, userpassword));
			}
		} catch (SQLException e) {
			System.out.print("Catch block");
			printSQLException(e);
		}
		return users;
	}

	//select all faculty
		public List<Faculty> selectAllfaculty() {
			Connection connection = getConnection();
			List<Faculty> faculty= new ArrayList<>();
			Statement st;
			try {

					// Step 2:Create a statement using connection object
			   // preparedStatement= connection.prepareStatement("select * from student;"); 
				st=connection.createStatement();
				//System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = st.executeQuery("select * from faculty");
				//System.out.print("Hello fact");
				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int facultyid = rs.getInt("facultyid");
					String facultyname = rs.getString("facultyname");
					String facultyemail = rs.getString("facultyemail");
					String facultypassword = rs.getString("facultypassword");
					String branch = rs.getString("branch");
					String subject = rs.getString("subject");
					faculty.add(new Faculty(facultyid , facultyname, facultyemail, facultypassword, branch, subject));
				}
			} catch (SQLException e) {
				System.out.print("Catch block");
				printSQLException(e);
			}
			return faculty;
		}
		
	//list all quizzes
	public List<Quiz> selectAllQuiz(){
		Connection connection = getConnection();
		List<Quiz> quiz= new ArrayList<>();
		Statement st;
		try {
			st=connection.createStatement();
			ResultSet rs = st.executeQuery("select * from quiz;");
			while (rs.next()) {
				int quizid = rs.getInt("quizid");
				String quizname = rs.getString("quizname");
				int facultyid= rs.getInt("facultyid");
				String conducted = rs.getString("conducted");
				String department=rs.getString("department");
				Date date = rs.getDate("date");
				java.sql.Time time = rs.getTime("time");
				System.out.print(quizid+" "+quizname+" "+facultyid+" "+conducted+" "+department+" "+date+" "+time);
				System.out.println();
				quiz.add(new Quiz(quizid , quizname, facultyid, conducted, department, date, time));
			}
		} catch (SQLException e) {
			System.out.print("Catch block");
			printSQLException(e);
		}
		return quiz;
	}
		
	//select all questions
	public List<Quiz> selectAllQuestions(String quizname){
		Connection connection=getConnection();
		List<Quiz> questions=new ArrayList<>();
		Statement statement;
		try {
			statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from "+quizname+";");
			while(rs.next()) {
				int qno=rs.getInt("qno");
				String question=rs.getString("question");
				String optiona=rs.getString("optiona");
				String optionb=rs.getString("optionb");
				String optionc=rs.getString("optionc");
				String optiond=rs.getString("optiond");
				String correctoption=rs.getString("correctoption");
				System.out.print(qno+" "+question+" "+optiona+" "+optionb+" "+optionc+" "+optiond+" "+correctoption);
				System.out.println();
				questions.add(new Quiz(qno,question,optiona,optionb,optionc,optiond,correctoption));
			}
		}catch (SQLException e) {
			System.out.print("Catch block");
			printSQLException(e);
		}
		return questions;
	}
	
	public List<Marks> selectMarksList(){
		Connection connection=getConnection();
		List<Marks> marks=new ArrayList<>();
		Statement statement;
		try {
			statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from marks;");
			while(rs.next()) {
				int marksid=rs.getInt("marksid");
		    	String studept=rs.getString("studept");
		    	String sub=rs.getString("sub");
		    	int stuid=rs.getInt("stuid");
		    	int mark=rs.getInt("marks");
		    	int total=rs.getInt("total");
		    	int conductedid = rs.getInt("conductedid");
		    	String conductedname = rs.getString("conductedname");
		    	marks.add(new Marks(marksid, studept, sub, stuid, mark, total, conductedid, conductedname));
			}
		}catch (SQLException e) {
			System.out.print("Catch block");
			printSQLException(e);
		}
		return marks;
	}
		
	//delete user
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1,id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	//delete faculty
		public boolean deletefaculty(int facultyid) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement("delete from faculty where facultyid=?;");) {
				statement.setInt(1,facultyid);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}
		
	//delete a question
		public boolean deleteQuestion(int qno, String quizname) throws SQLException {
			boolean questionDeleted;
			String deletequestion="delete from "+quizname+" where qno=?;";
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(deletequestion);) {
				statement.setInt(1,qno);
				questionDeleted = statement.executeUpdate() > 0;
			}
			//setQuestionnum(quizname);
			return questionDeleted;
		}
    
	 //altering the number after deleting
//	  public void setQuestionnum(String quizname) throws SQLException {
//		  String setquestionnum="alter table "+quizname+" alter column  qno identity(1,1) primary key";
//		  try (Connection connection = getConnection();
//					PreparedStatement statement = connection.prepareStatement(setquestionnum);) {
//			statement.executeQuery();
//			}
//	  }

		
	//update user
	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement("update student set username=?,emailid=?,userpassword=?, confirmpassword=? where id=?;");) {
			System.out.println("updated User:"+statement);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getEmailid());
			statement.setString(3, user.getUserpassword());
			statement.setString(4, user.getUserpassword());
			statement.setInt(5, user.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//update faculty
	public boolean updateFaculty(Faculty faculty) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement("update faculty set facultyname=?,facultyemail=?,facultypassword=?,branch=?,subject=? where facultyid=?;");) {
			statement.setString(1, faculty.getFacultyname());
			statement.setString(2, faculty.getFacultyemail());
			statement.setString(3, faculty.getFacultypassword());
            statement.setString(4, faculty.getBranch());
            statement.setString(5, faculty.getSubject());
            statement.setInt(6, faculty.getFacultyid());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//update questions
	public boolean updateQuestion(Quiz quiz , String quizname) throws SQLException{
		boolean rowUpdated;
		System.out.print(quizname);
		String updatequestion="update "+quizname+" set question=?, optiona=?, optionb=?, optionc=?, optiond=?, correctoption=? where qno=?;";
		try(Connection connection = getConnection();
				PreparedStatement statement= connection.prepareStatement(updatequestion)){
			 statement.setString(1, quiz.getQuestion());
			 statement.setString(2, quiz.getOptiona());
			 statement.setString(3, quiz.getOptionb());
			 statement.setString(4, quiz.getOptionc());
			 statement.setString(5, quiz.getOptiond());
			 statement.setString(6, quiz.getCorrectoption());
			 statement.setInt(7, quiz.getQno());
			 rowUpdated=statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	 //creating faculty table
//		public void createfaculty(String facultyname) {
//			String CREATE_FACULTY="create table "+facultyname+ "(fid int);";
//			try (Connection connection = getConnection();
//					PreparedStatement preparedStatement = connection.prepareStatement(CREATE_FACULTY)) {
//				preparedStatement.executeQuery();
//			}catch (SQLException e) {
//				printSQLException(e);
//			}
//		}
	
	//create Quiz
	public void createQuiz(String quizname) {
	    String createquiz="create table "+quizname+"(qno int identity(1,1) primary key , question varchar(1000) , "
	    		+ "optiona varchar(100), optionb varchar(100), optionc varchar(100), optiond varchar(100),"
	    		+ "correctoption varchar(100));";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(createquiz)){
			statement.executeQuery();
		}catch (SQLException e) {
			System.out.print("Catch block");
			printSQLException(e);
		}
	}
	
	//inserting questions in database
	public void insertQuiz(String quizname, String conducted, int facultyid, String department) {
		String insertquiz="insert into quiz (quizname, facultyid, conducted, department, date, time) values"+"(?, ?, ?, ?, getdate(),current_timestamp)";
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(insertquiz)){
			   statement.setString(1, quizname);
			   statement.setInt(2, facultyid);
			   statement.setString(3, conducted);
			   statement.setString(4, department);
			statement.executeUpdate();
		}catch (SQLException e) {
			System.out.print("Catch block");
			printSQLException(e);
		}
	}
	
	//inserting questions in database
	public void insertQuestion(Quiz quiz, String quizname) throws SQLException {
		  String insertquestion="insert into "+quizname+"(question, optiona, optionb, optionc, optiond, correctoption) values"+
	              "(?, ?, ?, ?, ?, ?);";
			try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(insertquestion)) {
				statement.setString(1, quiz.getQuestion());
				statement.setString(2, quiz.getOptiona());
				statement.setString(3, quiz.getOptionb());
				statement.setString(4, quiz.getOptionc());
				statement.setString(5, quiz.getOptiond());
				statement.setString(6, quiz.getCorrectoption());
				statement.executeUpdate();
			}catch (SQLException e) {
				System.out.print("Catch block");
				printSQLException(e);
			}
	}
	
	//view quizzes conducted by individual faculty
	public List<Quiz> selectFacultyQuiz(String conduct, String department) {
		String faculty="select * from quiz where conducted=?;";
		List<Quiz> quiz= new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(faculty);) {
			preparedStatement.setString(1, conduct);
			//preparedStatement.setString(2, department);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int quizid = rs.getInt("quizid");
				String quizname = rs.getString("quizname");
				int facultyid=rs.getInt("facultyid");
				String dept=department;
				Date date = rs.getDate("date");
				java.sql.Time time = rs.getTime("time");
				System.out.print("Faculty Quiz"+quizid+" "+quizname+" "+dept+" "+date+" "+time);
				System.out.println();
				quiz.add(new Quiz(quizid, quizname, facultyid, conduct, dept, date, time));
			}
		} catch (SQLException e) {
			System.out.print("Catch block");
			printSQLException(e);
		}
		return quiz;
	}
	
	//take faculty dept
	public String takeFacultyDept(int fid) {
		String facultydept="select branch from faculty where facultyid=?";
		String dept="cse";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(facultydept);) {
				preparedStatement.setInt(1, fid);
				ResultSet rs=preparedStatement.executeQuery();
				while(rs.next()) {
					String branch=rs.getString("branch");
					dept=branch;
				}
		}catch (SQLException e) {
			System.out.print("Catch block");
			printSQLException(e);
		}
		return dept; 
	}
	
	//displaying available quizzes for students
	public List<Quiz> displayQuiz(String branch) {
		List<Quiz> available=new ArrayList<>();
		String availablequiz="select quizname from quiz where department=?";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(availablequiz);) {
				preparedStatement.setString(1, branch);
				ResultSet rs=preparedStatement.executeQuery();
				while(rs.next()) {
					String quizname=rs.getString("quizname");
					System.out.println(quizname);
					available.add(new Quiz(quizname));
				}
		}catch (SQLException e) {
			System.out.print("Catch block");
			printSQLException(e);
		}
	  return available;
	}
	
	//view Student profile
	public User studentprofile(int id,String studentname) {
		User user=null;
		String profile = "select * from student where id=?";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(profile);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				String emailid = rs.getString("emailid");
				String userpassword = rs.getString("userpassword");
				user = new User(id, username, emailid, userpassword);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
