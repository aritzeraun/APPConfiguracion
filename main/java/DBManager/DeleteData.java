package DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {

	public DeleteData() {}
	
	public void DeleteFirmaElectronica(Connection connection) {
		
		final String sql = "DELETE FROM FIRMA_ELECTRONICA ";
		DeleteGenerico (sql, connection);
	}
	
	public void DeleteDatosConexion(Connection connection) {
		
		final String sql = "DELETE FROM DATOS_CONEXION ";
		DeleteGenerico (sql, connection);
	}
	
	public void DeleteDatosXML(Connection connection) {
		
		final String sql = "DELETE FROM DATOS_XML ";
		DeleteGenerico (sql, connection);
	}
	
	public void DeleteDatosBasicos(Connection connection) {
		
		final String sql = "DELETE FROM DATOS_BASICOS ";
		DeleteGenerico (sql, connection);
	}
	
	public void DeleteGenerico(String sql,Connection connection) {
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}