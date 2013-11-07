package DataBase;

public class Run {

	/**
	 * @param args
	 */
	public static void go(String[] args) {
		// TODO Auto-generated method stub
		ConnectToDB c = new ConnectToDB();
		DataInput d = new DataInput();
		DataOutput o = new DataOutput();
		
		String[] user = {"5","armando","admin","armando_m@live.com","01/06/1992","Macedo","Armando"};
		//d.newUser(user);
		o.getUsers();
		
	}

}
