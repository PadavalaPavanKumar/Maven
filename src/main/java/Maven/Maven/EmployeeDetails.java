package Maven.Maven;


import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeDetails {
 
  private int id;
  private String name;
  private String project;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getProject() {
	return project;
}
public void setProject(String project) {
	this.project = project;
}

}
