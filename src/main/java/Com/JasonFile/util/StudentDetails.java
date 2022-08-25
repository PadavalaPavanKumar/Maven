package Com.JasonFile.util;

public class StudentDetails  {
    private int id;
    private String firstname;
    private  String lastname;
    private long phonenumber;
//	public StudentDetails(int id, String firstname, String lastname, long phonenumber) {
//		
//		this.id = id;
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.phonenumber = phonenumber;
//	}
	public int getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "StudentDetails[ id ="+id+"firstname = "+firstname+"lastname = "+lastname+"phonenumber = "+phonenumber+"]";
	}
	
    
}
