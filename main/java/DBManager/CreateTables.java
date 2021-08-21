 package DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTables {
	public CreateTables() {	
	}
	
	public void CreateTableL1 (Connection connection) {
		
		final String sql ="CREATE TABLE IF NOT EXISTS  L1 (Indicativo text PRIMARY KEY, NombrePais text NOT NULL);";
		crearTablas(connection, sql);
	}
	
	public void CreateTableL2(Connection connection) {
		
		final String sql ="CREATE TABLE IF NOT EXISTS L2 (Valores text PRIMARY KEY, Descripcion text NOT NULL);";
		crearTablas(connection, sql);
	}
	
	public void CreateTableL6(Connection connection) {
		
		final String sql ="CREATE TABLE IF NOT EXISTS L6 (Valores text PRIMARY KEY, Descripcion text NOT NULL);";
		crearTablas(connection, sql);
	}

	public void CreateTableL9(Connection connection) {
		
		final String sql ="CREATE TABLE IF NOT EXISTS L9 (Valores text PRIMARY KEY, Descripcion text NOT NULL);";
		crearTablas(connection, sql);
	}
	
	public void CreateTableL10(Connection connection) {
		
		final String sql ="CREATE TABLE IF NOT EXISTS L10 (Valores text PRIMARY KEY, Descripcion text NOT NULL);";
		crearTablas(connection, sql);
	}
	
	public void CreateTableL11(Connection connection) {
		
		final String sql ="CREATE TABLE IF NOT EXISTS L11 (Valores text PRIMARY KEY, Descripcion text NOT NULL);";
		crearTablas(connection, sql);
	}
	
	public void CreateTableL12(Connection connection) {
		
		final String sql ="CREATE TABLE IF NOT EXISTS L12 (Valores text PRIMARY KEY, Descripcion text NOT NULL);";
		crearTablas(connection, sql);
	}
	
	public void CreateTableL13(Connection connection) {
		
		final String sql ="CREATE TABLE IF NOT EXISTS L13 (Valores text PRIMARY KEY, Descripcion text NOT NULL);";
		crearTablas(connection, sql);
	}
	
	public void CreateTableFirmaElectronica(Connection connection) {
		final String sql ="CREATE TABLE IF NOT EXISTS  FIRMA_ELECTRONICA (LicenciaTBAI text, NIF text, CodigoPais text, IDtype text,"
				+ " ID text, Nombre text, Version text, Dispositivo text);";
		crearTablas(connection, sql);
	}
	
	public void CreateTableDatosXML(Connection connection) {
		final String sql ="CREATE TABLE IF NOT EXISTS  DATOS_XML (IDVersionTBAI text NOT NULL, NIF text NOT NULL, RazonSocial text NOT NULL,"
				+ "L6 varchar(2) NOT NULL, L9 varchar(2) NOT NULL, L10 varchar(2) NOT NULL, L11 varchar(2) NOT NULL,"
				+ "L12 varchar(2) NOT NULL, L13 varchar(2) NOT NULL);";
		crearTablas(connection, sql);
	}
	
	public void CreateTableDatosBasicos(Connection connection) {
		final String sql ="CREATE TABLE IF NOT EXISTS  DATOS_BASICOS (DirectorioArchivosXML text NOT NULL, DirectorioRecursos text NOT NULL,"
				+ " DirectorioBaseDatos text NOT NULL);";
		crearTablas(connection, sql);
	}
	
	public void CreateTableDatosConexion(Connection connection) {
		final String sql ="CREATE TABLE IF NOT EXISTS  DATOS_CONEXION (EnlaceAlta text NOT NULL, EnlaceAnulacion text NOT NULL);";
		crearTablas(connection, sql);
	}
	
	public void crearTablas(Connection connection, String sql) {
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}