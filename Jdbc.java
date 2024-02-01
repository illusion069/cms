package JavaPro;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {
	public static void main(String[] args) {
		String url = "jdbc.mysql:localhost";
		String username = "root";
		String password = "";
		
		try {
			Connection conn = DriverManager.getConnection(url,username,password);
			
			Statement stm = conn.createStatement();
			
			String query = "";
			
			stm.execute(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
