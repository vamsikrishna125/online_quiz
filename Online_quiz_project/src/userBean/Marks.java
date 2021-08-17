package userBean;

public class Marks {
  private int marksid;
  private String studept;
  private String sub;
  private int stuid;
  private int marks;
  private int total;
  private int conductedid;
  private String conductedname;
  
  public Marks(String studept, String sub, int stuid, int marks, int total) {
	super();
	this.studept = studept;
	this.sub = sub;
	this.stuid = stuid;
	this.marks = marks;
	this.total = total;
 }

 public Marks(int marksid, String studept, String sub, int stuid, int marks, int total, int conductedid, String conductedname) {
	super();
	this.marksid = marksid;
	this.studept = studept;
	this.sub = sub;
	this.stuid = stuid;
	this.marks = marks;
	this.total = total;
	this.conductedid = conductedid;
	this.conductedname = conductedname;
 }

public int getMarksid() {
	return marksid;
}

public void setMarksid(int marksid) {
	this.marksid = marksid;
}

public String getStudept() {
	return studept;
}

public void setStudept(String studept) {
	this.studept = studept;
}

public String getSub() {
	return sub;
}

public void setSub(String sub) {
	this.sub = sub;
}

public int getStuid() {
	return stuid;
}

public void setStuid(int stuid) {
	this.stuid = stuid;
}

public int getMarks() {
	return marks;
}

public void setMarks(int marks) {
	this.marks = marks;
}

public int getTotal() {
	return total;
}

public void setTotal(int total) {
	this.total = total;
}

public int getConductedid() {
	return conductedid;
}

public void setConductedid(int conductedid) {
	this.conductedid = conductedid;
}

public String getConductedname() {
	return conductedname;
}

public void setConductedname(String conductedname) {
	this.conductedname = conductedname;
}  
}
