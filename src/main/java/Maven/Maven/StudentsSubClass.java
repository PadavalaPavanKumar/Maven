package Maven.Maven;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentsSubClass {
   private int id;
   private String name;
   private int age;
public int getId() {
	return id;
}
@XmlElement
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
@XmlElement
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
@XmlElement
public void setAge(int age) {
	this.age = age;
}

@Override
public String toString() {
	
	return "student [ id = "+id+", name = "+name+", age = "+age+"]";
}

}
