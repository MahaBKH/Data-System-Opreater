

public class User {
	//STATE
	private String firstname;
	private String lastname;
	private int age; 
	private String race;
	private String job;
	private String password; 

 public User ()
 {
	 firstname = "";
	 lastname = "";
	 age = 0;
	 race = "";
	 job="";
	 password= "";
//	Constructers 
 }
 public User (String firstname, String lastname,int age, String race,String job,String password)  {
	this.firstname = firstname;
	this.lastname = lastname;
	this.age = age;
	this.race = race;
	this.job = job;
	this.password = password;		
 }
 
 public String getFirstname()
 {
	 return firstname;
 }
 
 public String getLastname()
 {
	 return lastname;
 }
 public int getAge()
 {
	 return age;
 }
 public String getRace()
 {
	 return race;
 }
 public String getJob()
 {
	 return job;
 }
 public String getPassword()
 {
	 return password;
 }
 
 public String toString() {
	 return firstname + "," + lastname + "," + password + "," + age + "," + race +","+ job ;
 }
 
 public String publicInfo() {
	 return "" + age + "," + race +","+ job ;
 }
}
 