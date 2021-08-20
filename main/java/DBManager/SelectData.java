package DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import DataType.DatosConexion;
import DataType.DatosXML;
import DataType.FirmaElectronica;

public class SelectData {
	
	public SelectData() {}
	
	public HashMap<String,String> selectL1(Connection connection){
		
		HashMap<String,String> L1 = new HashMap<>();
		String sql ="SELECT * FROM L1 ORDER BY L1.Indicativo DESC;";
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			ResultSet rs = pstmt.executeQuery();
			
			 while (rs.next()){
	            	String valores = rs.getString("Indicativo");
	            	String Descripcion = rs.getString("NombrePais");
	            	L1.put(valores, Descripcion);
	 	         }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return L1;
	}

	public HashMap<String,String> selectL2(Connection connection){
		
		String sql ="SELECT * FROM L2 ORDER BY L2.Valores DESC;";
		HashMap<String,String> L2 = selectGeneral(connection, sql);
		
		return L2;
	}
	
	public HashMap<String,String> selectL6(Connection connection){
		
		String sql ="SELECT * FROM L6 ORDER BY L6.Valores DESC;";
		HashMap<String,String> L6 = selectGeneral(connection, sql);
		
		return L6;
	}
	
	public HashMap<String,String> selectL9(Connection connection){
		
		String sql ="SELECT * FROM L9 ORDER BY L9.Valores DESC;";
		HashMap<String,String> L9 = selectGeneral(connection, sql);
		
		return L9;
	}

	public HashMap<String,String> selectL10(Connection connection){
		
		String sql ="SELECT * FROM L10 ORDER BY L10.Valores DESC;";
		HashMap<String,String> L10 = selectGeneral(connection, sql);
		
		return L10;
	}
	
	public HashMap<String,String> selectL11(Connection connection){
		
		String sql ="SELECT * FROM L11 ORDER BY L11.Valores DESC;";
		HashMap<String,String> L11 = selectGeneral(connection, sql);
		
		return L11;
	}
	
	public HashMap<String,String> selectL12(Connection connection){
		
		String sql ="SELECT * FROM L12 ORDER BY L12.Valores DESC;";
		HashMap<String,String> L12 = selectGeneral(connection, sql);
		
		return L12;
	}
	
	public HashMap<String,String> selectL13(Connection connection){
		
		String sql ="SELECT * FROM L13 ORDER BY L13.Valores DESC;";
		HashMap<String,String> L13 = selectGeneral(connection, sql);
		
		return L13;
	}

	public HashMap<String,String> selectGeneral(Connection connection, String sql){
		
		HashMap<String,String> L = new HashMap<>();
		
		try (PreparedStatement pstmt = connection.prepareStatement(sql)){
			ResultSet rs = pstmt.executeQuery();
			
			 while (rs.next()){
	            	String valores = rs.getString("Valores");
	            	String Descripcion = rs.getString("Descripcion");
	            	L.put(valores, Descripcion);
	 	         }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return L;
	}
	
	public DatosXML CreateTableDatosXML(Connection connection) {
		
		final String sql ="SELECT * FROM DATOS_XML;";
		DatosXML DatosXML = null;
		
		 try (PreparedStatement pstmt = connection.prepareStatement(sql)){
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()){
					
					String IDVersionTBAI = rs.getString("IDVersionTBAI");
	            	String NIF = rs.getString("NIF");
	            	String RazonSocial = rs.getString("RazonSocial");
	            	String L6 = rs.getString("L6");
	            	String L9 = rs.getString("L9");
	            	String L10 = rs.getString("L10");
	            	String L11 = rs.getString("L11");
	            	String L12 = rs.getString("L12");
	            	String L13 = rs.getString("L13");
	            	
	            	DatosXML = new DatosXML(IDVersionTBAI, NIF, RazonSocial, L6, L9, L10, L11, L12, L13);
				}
					 	      
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return DatosXML;
	}
	
	public DatosConexion selectDatosConexion(Connection connection) {
		
		final String sql = "SELECT * FROM DATOS_CONEXION;";
		DatosConexion DatosConexion = null;
		
		 try (PreparedStatement pstmt = connection.prepareStatement(sql)){
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()){
					String EnlaceAlta = rs.getString("EnlaceAlta");
	            	String EnlaceAnulacion = rs.getString("EnlaceAnulacion");
	            	
	            	DatosConexion = new DatosConexion(EnlaceAlta, EnlaceAnulacion);
				}				 	      
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return DatosConexion;
	 }
	
	public FirmaElectronica selectFirmaElectronica(Connection connection) {
		
		 final String sql = "SELECT * FROM FIRMA_ELECTRONICA;";
		 FirmaElectronica firma = null;
		 
		 try (PreparedStatement pstmt = connection.prepareStatement(sql)){
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()){
					String LicenciaTBAI = rs.getString("LicenciaTBAI");
	            	String NIF = rs.getString("NIF");
	            	String CodigoPais= rs.getString("CodigoPais");
	            	String IDType = rs.getString("IdType");
	            	String ID = rs.getString("ID");
	            	String Nombre = rs.getString("Nombre");
	            	String Version = rs.getString("Version");
	            	String Dispositivo = rs.getString("Dispositivo");
	            	
	            	firma = new FirmaElectronica(LicenciaTBAI,NIF,CodigoPais,IDType,ID,Nombre,Version,Dispositivo);
				}
					 	      
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 return firma;
	 }
}