package enumcheck;

public class Connection {

	private static Connection INSTANCE;
	
	private Connection() {
		
	}
	
	public Connection getInstance() {
		if(INSTANCE != null) {
			INSTANCE = new Connection();
		}
		return INSTANCE;
	}
}
