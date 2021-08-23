package DataType;

public class DatosConexion {
	
	private String EnlaceAlta;
	private String EnlaceBaja;
	
	public DatosConexion(String enlaceAlta, String enlaceBaja) {
		super();
		this.EnlaceAlta = enlaceAlta;
		this.EnlaceBaja = enlaceBaja;
	}
	
	public DatosConexion() {
	}

	public String getEnlaceAlta() {
		return EnlaceAlta;
	}

	public void setEnlaceAlta(String enlaceAlta) {
		EnlaceAlta = enlaceAlta;
	}

	public String getEnlaceBaja() {
		return EnlaceBaja;
	}

	public void setEnlaceBaja(String enlaceBaja) {
		EnlaceBaja = enlaceBaja;
	}
}