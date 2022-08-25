package Maven.Maven;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="StudentDetailsList")
public class StudentsMainClass {
	@XmlElement(name="StudentDetails")
	private ArrayList<StudentsSubClass>  studentlist=new ArrayList<StudentsSubClass>();
	
    public ArrayList<StudentsSubClass> getList(){
    	return studentlist;
    }
}
