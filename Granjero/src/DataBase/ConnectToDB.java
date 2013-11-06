package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
	String url = "jdbc:mysql://localhost/granjero"; 
	String user = "root";
	String password = "admin";
	

	Connection CONNECT = null;
	
	public void setUpConnection(){
		try {
	        Class.forName("com.mysql.jdbc.Driver"); //busca el driver que conecta la base de datos 
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
		
		try { 
			CONNECT = DriverManager.getConnection(url,user,password); //se conecta con la base de datos ingresada
			System.out.println("Conexion a base de datos exitosa");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
