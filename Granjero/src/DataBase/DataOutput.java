package DataBase;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class DataOutput {
	
	ResultSet rs;
	Statement statement = null;
	ConnectToDB c = new ConnectToDB();
	
	public void getUsers(){	
		String query = "SELECT * FROM usuario";
		
		try {
			c.setUpConnection();
			statement = c.CONNECT.createStatement();
			
			rs = statement.executeQuery(query);
			
			while(rs.next()){
				//String user_id = rs.getString("ID_Usuario");
				int user_id = rs.getInt("ID_Usuario");
				String username = rs.getNString("Username");
				String password = rs.getNString("Password");
				String correo = rs.getNString("Correo");
				//Date date = rs.getDate("Birthday");
				String lastname = rs.getNString("Apellidos");
				String name = rs.getNString("Nombres");
				
				System.out.println("Name: " + name + 
									"\nLastname: " + lastname + 
									"\nUsername: " + username + 
									"\nPassword: " + password + 
									"\nMail: " + correo );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	public boolean verifyUser(String username, String password){
		String query = "SELECT Username,Password FROM usuario WHERE Username = '" + username + "'" ;
		
		try {
			c.setUpConnection();
			statement = c.CONNECT.createStatement();
			
			rs = statement.executeQuery(query);
			
			while(rs.next()){
				if(password.equals(rs.getNString("Password"))){
					System.out.println("Si encontro la contra");
					return true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return false;
    }
	
	public int getCurrentClientID(String client_name){
		
		String query = "SELECT ID_Cliente,Nombre FROM cliente WHERE Nombre = '" + client_name + "'" ;
		int key = -1; 
		
		try {
			c.setUpConnection();
			statement = c.CONNECT.createStatement();
			
			rs = statement.executeQuery(query);
			
			while(rs.next()){
				key = rs.getInt("ID_Cliente");
			}
			
			return key;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return key;
		
	}
	
	public int getCurrentRouteID(String route_name){
		String query = "SELECT ID_Route, Nombre FROM ruta WHERE Nombre = '" + route_name + "'";
		int key = -1;
		
		try {
			c.setUpConnection();
			statement = c.CONNECT.createStatement();
			
			rs = statement.executeQuery(query);
			
			while(rs.next()){
				key = rs.getInt("ID_Cliente");
			}
			
			return key;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return key;
	}
	


}
