package Maven.Maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertingDataIntoDbms {
	public void dbms() throws Exception {
		
	
  Class.forName("org.postgresql.Driver");
   
  Connection connection =DriverManager.getConnection("jdbc:postgresql/localhost:5432//postgres","postgres","root");
  String querry="insert into kspl.studentdetailslist values(?,?,?)";
  PreparedStatement ps=connection.prepareStatement(querry);
	}
}
