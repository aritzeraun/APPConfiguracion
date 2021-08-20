package DataType;

public class FirmaElectronica {

	private String LicenciaTBAI;
	private String NIF;
	private String CodigoPais;
	private String IDType;
	private String ID;
	private String Nombre;
	private String Version;
	private String Dispositivo;
	


	public FirmaElectronica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FirmaElectronica(String licenciaTBAI, String nIF, String codigoPais, String iDType, String iD, String nombre,
			String version, String dispositivo) {
		super();
		this.LicenciaTBAI = licenciaTBAI;
		this.NIF = nIF;
		this.CodigoPais = codigoPais;
		this.IDType = iDType;
		this.ID = iD;
		this.Nombre = nombre;
		this.Version = version;
		this.Dispositivo = dispositivo;
	}

	public String getLicenciaTBAI() {
		return LicenciaTBAI;
	}

	public void setLicenciaTBAI(String licenciaTBAI) {
		LicenciaTBAI = licenciaTBAI;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getCodigoPais() {
		return CodigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		CodigoPais = codigoPais;
	}

	public String getIDType() {
		return IDType;
	}

	public void setIDType(String iDType) {
		IDType = iDType;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}

	public String getDispositivo() {
		return Dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		Dispositivo = dispositivo;
	}

}
