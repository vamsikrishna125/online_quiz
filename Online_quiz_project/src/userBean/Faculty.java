package userBean;

public class Faculty {
	   private int facultyid;
	   private String facultyname;
	   private String facultyemail;
	   private String facultypassword;
	   private String facultyconfirmpassword;
	   private String branch;
	   private String subject;
	   
	public Faculty() {
		super();
	}
   
	public Faculty(int facultyid, String facultyname, String facultyemail, String facultypassword) {
		super();
		this.facultyid = facultyid;
		this.facultyname = facultyname;
		this.facultyemail = facultyemail;
		this.facultypassword = facultypassword;
	}

	public Faculty(int facultyid, String facultyname, String facultyemail, String facultypassword, String facultyconfirmpassword) {
		super();
		this.facultyid = facultyid;
		this.facultyname = facultyname;
		this.facultyemail = facultyemail;
		this.facultypassword = facultypassword;
		this.facultyconfirmpassword = facultyconfirmpassword;
	}
   
	public Faculty(int facultyid, String facultyname, String facultyemail, String facultypassword,
			String facultyconfirmpassword, String branch, String subject) {
		super();
		this.facultyid = facultyid;
		this.facultyname = facultyname;
		this.facultyemail = facultyemail;
		this.facultypassword = facultypassword;
		this.facultyconfirmpassword = facultyconfirmpassword;
		this.branch = branch;
		this.subject = subject;
	}
	
	public Faculty(int facultyid, String facultyname, String facultyemail, String facultypassword, String branch, String subject) {
		super();
		this.facultyid = facultyid;
		this.facultyname = facultyname;
		this.facultyemail = facultyemail;
		this.facultypassword = facultypassword;
		this.branch = branch;
		this.subject = subject;
	}

	public int getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}

	public String getFacultyname() {
		return facultyname;
	}

	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
	}

	public String getFacultyemail() {
		return facultyemail;
	}

	public void setFacultyemail(String facultyemail) {
		this.facultyemail = facultyemail;
	}

	public String getFacultypassword() {
		return facultypassword;
	}

	public void setFacultypassword(String facultypassword) {
		this.facultypassword = facultypassword;
	}

	public String getFacultyconfirmpassword() {
		return facultyconfirmpassword;
	}

	public void setFacultyconfirmpassword(String facultyconfirmpassword) {
		this.facultyconfirmpassword = facultyconfirmpassword;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	   
	
	   
}
