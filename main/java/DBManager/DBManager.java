package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private String name; 
	private String url;
	public Connection connection; 

	public DBManager() {
		this.name = "TBAIDatabase.db";
		this.url = "jdbc:sqlite:" + name;
		this.connect();
	}
	
	public void connect() {
		try {
			this.connection = DriverManager.getConnection(this.url);
		}catch(SQLException e) {
			System.out.print(e.getMessage());
		}
	}
	
	public void disconnect() {
		try {
				if (this.connection != null) {
					this.connection.close();
			}
		}catch(SQLException e) {
			System.out.print("Error closing database connection: "+e.getMessage());
		}
	}
}
