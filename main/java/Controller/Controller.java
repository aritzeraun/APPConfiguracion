package Controller;

import DBManager.CreateTables;
import DBManager.DBManager;
import GUIConfiguracion.ConfigureWindow;
import ReadingFiles.ReadFile;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Controller {
	
	public static void main (String[] args) {

		String url = "jdbc:sqlite:" +"TBAIDatabase.db";

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
		        System.out.println("The driver name is " + meta.getDriverName());
		        System.out.println("A new database has been created.");
		        
		        DBManager manager = new DBManager();
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
		        table.CreateTableDatosConexion(conect);
		        table.CreateTableDatosXML(conect);
		        table.CreateTableFirmaElectronica(conect);
		        manager.disconnect();
		        
		        manager.connect();
		        Connection conecti =manager.connection;
		        
		        ReadFile read = new ReadFile();
		        read.read(".\\src\\main\\resources\\ArchivosPlanos\\L1.txt", conecti);
		        read.read(".\\src\\main\\resources\\ArchivosPlanos\\L2.txt", conecti);
		        read.read(".\\src\\main\\resources\\ArchivosPlanos\\L6.txt", conecti);
		        read.read(".\\src\\main\\resources\\ArchivosPlanos\\L9.txt", conecti);
		        read.read(".\\src\\main\\resources\\ArchivosPlanos\\L10.txt", conecti);
		        read.read(".\\src\\main\\resources\\ArchivosPlanos\\L11.txt", conecti);
		        read.read(".\\src\\main\\resources\\ArchivosPlanos\\L12.txt", conecti);
		        read.read(".\\src\\main\\resources\\ArchivosPlanos\\L13.txt", conecti);
		        manager.disconnect();
		        ConfigureWindow panelPrincipal = new ConfigureWindow();
		        panelPrincipal.setVisible(true);
		        
                if(conect ==null) {
                	
                }
            }
        } catch (SQLException e) {
		        System.out.println(e.getMessage());
		}
	}
}