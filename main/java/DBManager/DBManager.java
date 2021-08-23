package DBManager;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import ReadingFiles.ReadFile;

public class DBManager {
	
	private String url;
	public Connection connection; 

	public DBManager(String name, String url) {
		this.url = url + name;
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
	
	public void crearBaseDatos(String name, String url, String recursos) {
		try (Connection conn = DriverManager.getConnection(url+name)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
		        System.out.println("The driver name is " + meta.getDriverName());
		        System.out.println("A new database has been created.");
		        
		        DBManager manager = new DBManager(name, url);
		        manager.connect();
		        Connection conect =manager.connection;
		        CreateTables table = new CreateTables(); 
		        table.CreateTableL1(conect);
		        table.CreateTableL2(conect);
		        table.CreateTableL6(conect);
		        table.CreateTableL9(conect);
		        table.CreateTableL10(conect);
		        table.CreateTableL11(conect);
		        table.CreateTableL12(conect);
		        table.CreateTableL13(conect);
		        table.CreateTableDatosBasicos(conect);
		        table.CreateTableDatosConexion(conect);
		        table.CreateTableDatosXML(conect);
		        table.CreateTableFirmaElectronica(conect);
		        manager.disconnect();
		        
		        manager.connect();
		        Connection conecti =manager.connection;
		        
		        ReadFile read = new ReadFile();
		        read.read(recursos+"L1.txt", conecti);
		        read.read(recursos+"L2.txt", conecti);
		        read.read(recursos+"L6.txt", conecti);
		        read.read(recursos+"L9.txt", conecti);
		        read.read(recursos+"L10.txt", conecti);
		        read.read(recursos+"L11.txt", conecti);
		        read.read(recursos+"L12.txt", conecti);
		        read.read(recursos+"L13.txt", conecti);
		        manager.disconnect();

                if(conect ==null) {
                	
                }
            }
        } catch (SQLException e) {
		        System.out.println(e.getMessage());
		}
	}
}
