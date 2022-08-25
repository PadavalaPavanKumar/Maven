package Com.JasonFile.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaObjectToJasonFileConversion {
      public static void main(String[] args) throws Exception {
    	  File file=new File("Student1.json");
    	  ObjectMapper mapper = new ObjectMapper();
    	  Student1Class sd= mapper.readValue(file, Student1Class.class);
    	 System.out.println(sd);
    	 Student1Class st1= new Student1Class();
    	 Class<?> cl=st1.getClass();
    	
    	
    	 
      }
}
