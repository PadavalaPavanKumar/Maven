package Com.JasonFile.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Maven.Maven.StudentsSubClass;

public class JasonToJavaObject {
	public static void main(String[] args) throws Exception {

		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
				"root");

		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File("Student.json");
		// List<StudentDetails> stu=
		// objectMapper.readValue(file,StudentClass.class).getstudentDetailsList();
		// List<StudentDetails> stu=std.getstudentDetailsList(); new
		// TypeReference<list<StudentClass>>
		List<StudentDetails> std = objectMapper.readValue(file, new TypeReference<List<StudentDetails>>() {
		});

		for (StudentDetails studentdetails : std) {
			int i = 1;
			String querry = "insert into studentdetails values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(querry);
			Class<?> classofclass = StudentDetails.class;
			for (Field field : classofclass.getDeclaredFields()) {
				field.setAccessible(true);
				Class<?> type = field.getType();
				if (type.equals(int.class)) {
					ps.setInt(i, (int) field.get(studentdetails));
				} else if (type.equals(String.class)) {
					ps.setString(i, (String) field.get(studentdetails));
				} else {
					ps.setLong(i, (long) field.get(studentdetails));
				}
				i = i + 1;
			}
			ps.executeUpdate();
			ps.close();
		}

		connection.close();

	}

}
