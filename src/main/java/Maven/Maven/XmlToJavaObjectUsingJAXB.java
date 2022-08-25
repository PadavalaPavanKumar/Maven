package Maven.Maven;

import java.io.File;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

public class XmlToJavaObjectUsingJAXB {
	public static void main(String[] args) throws Exception {
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
				"root");
		String querry = "insert into kspl.employeedetails values(?,?,?)";
		PreparedStatement ps = connection.prepareStatement(querry);
		File file = new File("File.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeDetails.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		EmployeeDetails employeeDetails = new EmployeeDetails();

		employeeDetails = (EmployeeDetails) unmarshaller.unmarshal(file);
		System.out.println(
				employeeDetails.getId() + " " + employeeDetails.getName() + " " + employeeDetails.getProject());
		ps.setInt(1, employeeDetails.getId());
		ps.setString(2, employeeDetails.getName());
		ps.setString(3, employeeDetails.getProject());
		ps.executeUpdate();
		ps.close();
		connection.close();
	}
}
