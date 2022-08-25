package Maven.Maven;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import Maven.Maven.*;

import Com.JasonFile.util.StudentDetails;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.*;

public class XmlToJavaObjectUsingUnmarshling {
	public static void main(String[] args) throws Exception {

		Class.forName("org.postgresql.Driver");

		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
				"root");

		File file = new File("details.xml");
		JAXBContext jaxbcontext = JAXBContext.newInstance(StudentsMainClass.class);
		Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
		StudentsMainClass studentdetailslist = (StudentsMainClass) unmarshaller.unmarshal(file);
		ArrayList<StudentsSubClass> studentlist = studentdetailslist.getList();

		for (StudentsSubClass student : studentlist) {
			StringBuilder querry1 = new StringBuilder();
			querry1.append("insert into studentdetailslist values(?,?,?)");
			PreparedStatement ps = connection.prepareStatement(querry1.toString());

			Class<?> classofclass = StudentsSubClass.class;
			int i = 1;
			for (Field field : classofclass.getDeclaredFields()) {

				field.setAccessible(true);
				Class<?> type = field.getType();

				if (type.equals(int.class)) {
					ps.setInt(i, (int) field.get(student));
				} else {
					ps.setString(i, (String) field.get(student));
				}
				i = i + 1;
			}
			ps.executeUpdate();

		}

	}

}
