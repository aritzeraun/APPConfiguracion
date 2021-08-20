package DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DataType.DatosConexion;
import DataType.DatosXML;
import DataType.FirmaElectronica;

public class InsertData {
	 public InsertData() {
	 }
	 
	 public void insertFirmaElectronica(FirmaElectronica firmaElectronica, Connection connection) {
		 final String sql = "INSERT INTO  FIRMA_ELECTRONICA (LicenciaTBAI, NIF, CodigoPais, IDtype, ID, Nombre, Version, Dispositivo)"
		 		+ " VALUES(?,?,?,?,?,?,?,?);";
		 
		 try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			 	pstmt.setString(1, firmaElectronica.getLicenciaTBAI());
			 	pstmt.setString(2, firmaElectronica.getNIF());
			 	pstmt.setString(3, firmaElectronica.getCodigoPais());
			 	pstmt.setString(4, firmaElectronica.getIDType());
			 	pstmt.setString(5, firmaElectronica.getID());
			 	pstmt.setString(6, firmaElectronica.getNombre());
			 	pstmt.setString(7, firmaElectronica.getVersion());
			 	pstmt.setString(8, firmaElectronica.getDispositivo());
			 	
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	 }
	 
	 public void insertDatosXML(DatosXML datos, Connection connection) {
		 final String sql = "INSERT INTO  DATOS_XML (IDVersionTBAI, NIF, RazonSocial, L6, L9, L10, L11, L12, L13)"
		 		+ " VALUES(?,?,?,?,?,?,?,?,?);";
		 
		 try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			 	pstmt.setString(1,datos.getIDVersionTBAI());
			 	pstmt.setString(2, datos.getNIF());
			 	pstmt.setString(3, datos.getRazonSocial());
			 	pstmt.setString(4, datos.getL6());
			 	pstmt.setString(5, datos.getL9());
			 	pstmt.setString(6, datos.getL10());
			 	pstmt.setString(7, datos.getL11());
			 	pstmt.setString(8, datos.getL12());
			 	pstmt.setString(8, datos.getL13());
			 	
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	 }
	 
	 public void insertDatosConexion(DatosConexion datosConexion, Connection connection) {
		 final String sql = "INSERT INTO  DATOS_CONEXION (EnlaceAlta, EnlaceAnulacion)"
		 		+ " VALUES(?,?);";
		 
		 try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			 	pstmt.setString(1, datosConexion.getEnlaceAlta());
			 	pstmt.setString(2, datosConexion.getEnlaceBaja());
			 	
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	 }
	 
	 public void insert(String sql, Connection connection) {
	       
	        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.execute();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
}