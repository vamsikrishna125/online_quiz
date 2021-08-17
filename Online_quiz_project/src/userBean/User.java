package userBean;

public class User {
   private int id;
   private String username;
   private String emailid;
   private String userpassword;
   private String confirmpassword;
  
   
    
public User(int id, String username, String emailid, String userpassword, String confirmpassword) {
	super();
	this.id = id;
	this.username = username;
	this.emailid = emailid;
	this.userpassword = userpassword;
	this.confirmpassword = confirmpassword;
}

public User(int id, String username, String emailid, String userpassword) {
	  super();
	  this.id = id;
	  this.username = username;
	  this.emailid = emailid;
	  this.userpassword = userpassword;
  }

  public int getId() {
	  return id;
  }

  public void setId(int id) {
	  this.id = id;
  }

   public String getUsername() {
	  return username;
  }

  public void setUsername(String username) {
   	this.username = username;
  }

  public String getEmailid() {
   	return emailid;
  }

  public void setEmailid(String emailid) {
	  this.emailid = emailid;
  }

  public String getUserpassword() {
	   return userpassword;
  }

  public void setUserpassword(String userpassword) {
	   this.userpassword = userpassword;
  }
   
  public String getConfirmpassword() {
	return confirmpassword;
   }

   public void setConfirmpassword(String confirmpassword) {
	    this.confirmpassword = confirmpassword;
   }

   
}
