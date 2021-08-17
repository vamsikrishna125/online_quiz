package userBean;

import java.util.Date;
//import org.apache.tomcat.jni.Time;

public class Quiz {
    private int quizid;
    private String quizname;
    private String conducted;
    private int facultyid;
    private String department;
    private String subject;
    private Date date;
    private java.sql.Time time;
    private int qno;
    private String question;
    private String optiona;
    private String optionb;
    private String optionc;
    private String optiond;
    private String correctoption;
    public Quiz(String quizname, String conducted,Date date, java.sql.Time time) {
		super();
		this.quizname = quizname;
		this.conducted = conducted;
		this.date=date;
		this.time=time;
	}
       
	public Quiz(int quizid, String quizname, int facultyid, String conducted, String department, Date date, java.sql.Time time) {
		super();
		this.quizid = quizid;
		this.quizname = quizname;
		this.facultyid = facultyid;
		this.conducted = conducted;
		this.department = department;
		this.date=date;
		this.time=time;
	}
	
	public Quiz(int quizid, String quizname, String conducted, int facultyid, String department, String subject, Date date,
			java.sql.Time time) {
		super();
		this.quizid = quizid;
		this.quizname = quizname;
		this.conducted = conducted;
		this.facultyid = facultyid;
		this.department = department;
		this.subject = subject;
		this.date = date;
		this.time = time;
	}

	public Quiz(int qno, String question, String optiona, String optionb, String optionc, String optiond,
			String correctoption) {
		super();
		this.qno = qno;
		this.question = question;
		this.optiona = optiona;
		this.optionb = optionb;
		this.optionc = optionc;
		this.optiond = optiond;
		this.correctoption = correctoption;
	}

	public Quiz(String question, String optiona, String optionb, String optionc, String optiond, String correctoption) {
		super();
		this.question = question;
		this.optiona = optiona;
		this.optionb = optionb;
		this.optionc = optionc;
		this.optiond = optiond;
		this.correctoption = correctoption;
	}
	
	public Quiz(String quizname) {
		super();
		this.quizname= quizname;
	}

	public int getQuizid() {
		return quizid;
	}
	public void setQuizid(int quizid) {
		this.quizid = quizid;
	}
	public String getQuizname() {
		return quizname;
	}
	public void setQuizname(String quizname) {
		this.quizname = quizname;
	}
	public int getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}

	public String getConducted() {
		return conducted;
	}
	public void setConducted(String conducted) {
		this.conducted = conducted;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public java.sql.Time getTime() {
		return time;
	}

	public void setTime(java.sql.Time time) {
		this.time = time;
	}
     
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptiona() {
		return optiona;
	}

	public void setOptiona(String optiona) {
		this.optiona = optiona;
	}

	public String getOptionb() {
		return optionb;
	}

	public void setOptionb(String optionb) {
		this.optionb = optionb;
	}

	public String getOptionc() {
		return optionc;
	}

	public void setOptionc(String optionc) {
		this.optionc = optionc;
	}

	public String getOptiond() {
		return optiond;
	}

	public void setOptiond(String optiond) {
		this.optiond = optiond;
	}

	public String getCorrectoption() {
		return correctoption;
	}

	public void setCorrectoption(String correctoption) {
		this.correctoption = correctoption;
	}
	
}
