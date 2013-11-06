package DataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataInput {
	
	ConnectToDB c = new ConnectToDB();
	Statement statement = null;
	DataOutput o = new DataOutput();
	
	//String[] orden = {"cliente","cliente_sucursal","orden","orden_pieza","pieza",
	//						"pieza_cliente","ruta","sucursal","sucursal_pieza","usuario"};
	
	public void orderEntry(String[] orden){
		
	}
	
	public void addClientInfo(int id_cliente, String nombre, String direccion, String telefono, String correo){
		
		//Query's para llenar la informacion del cliente
		String query1 = "INSERT INTO cliente (ID_Cliente,Nombre,Direccion,Telefono,Correo) VALUES (" + id_cliente + ",'" + nombre + "','" + direccion + "','" + telefono + "','" + correo + "')";
		
		try{
			c.setUpConnection();
			statement = c.CONNECT.createStatement();
			statement.executeUpdate(query1);
			
		}catch(SQLException e){
			System.out.println(e);
		}
		
	}
	
	public boolean addRoute(String nombre){
		
		//Query's para llenar la informacion de la ruta
		String query1 = "INSERT INTO ruta (ID_Ruta,Nombre) VALUES (default,'" + nombre + "')";
		
		try{
			c.setUpConnection();
			statement = c.CONNECT.createStatement();
			statement.executeUpdate(query1);
			
		}catch(SQLException e){
			System.out.println(e);
		}
		return false;
	}

	public void clientRoute(int id_cliente, int id_ruta){
	
		//Query's para llenar la informacion de la tabla cliente_ruta
		String query1 = "INSERT INTO cliente_ruta (ID_Cliente,ID_Ruta) VALUES ";
	
		try{
			c.setUpConnection();
			statement = c.CONNECT.createStatement();
			statement.executeUpdate(query1);
		
		}catch(SQLException e){
			System.out.println(e);
		}
		
	}
	
	public void addDestiny(String direccion, int id_cliente, int id_ruta){
		//Query's para llenar la informacion de la ruta
		
		String query1 = "INSERT INTO destino (ID_Destino,ID_Cliente,ID_Ruta,Direccion) VALUES (default," + id_cliente + "," + id_ruta + ",'" + direccion + "')";
				
			try{
				c.setUpConnection();
				statement = c.CONNECT.createStatement();
				statement.executeUpdate(query1);
					
			}catch(SQLException e){
				System.out.println(e);
			}
		
	}
	
	public void newUser(String[] user){
		try{
			c.setUpConnection();
			statement = c.CONNECT.createStatement();
			String insert = "INSERT INTO usuario VALUES ("+ user[0] + ",'" + user[1] + "','" + user[2] + "','" + user[3] + "'," + user[4] + ",'" + user[5] + "')";
			statement.executeUpdate(insert);
			
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	
	
	
	

}
