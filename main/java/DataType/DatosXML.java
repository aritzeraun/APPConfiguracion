package DataType;

public class DatosXML {
	
	private String IDVersionTBAI;
	private String NIF;
	private String RazonSocial;
	private String L6;
	private String L9;
	private String L10;
	private String L11;
	private String L12;
	private String L13;

	public DatosXML() {
	}

	public DatosXML(String iDVersionTBAI, String nIF, String razonSocial, String l6, String l9, String l10, String l11,
			String l12, String l13) {
		super();
		this.IDVersionTBAI = iDVersionTBAI;
		this.NIF = nIF;
		this.RazonSocial = razonSocial;
		this.L6 = l6;
		this.L9 = l9;
		this.L10 = l10;
		this.L11 = l11;
		this.L12 = l12;
		this.L13 = l13;
	}

	public String getIDVersionTBAI() {
		return IDVersionTBAI;
	}

	public void setIDVersionTBAI(String iDVersionTBAI) {
		IDVersionTBAI = iDVersionTBAI;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getRazonSocial() {
		return RazonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}

	public String getL6() {
		return L6;
	}

	public void setL6(String l6) {
		L6 = l6;
	}

	public String getL9() {
		return L9;
	}

	public void setL9(String l9) {
		L9 = l9;
	}

	public String getL10() {
		return L10;
	}

	public void setL10(String l10) {
		L10 = l10;
	}

	public String getL11() {
		return L11;
	}

	public void setL11(String l11) {
		L11 = l11;
	}

	public String getL12() {
		return L12;
	}

	public void setL12(String l12) {
		L12 = l12;
	}

	public String getL13() {
		return L13;
	}

	public void setL13(String l13) {
		L13 = l13;
	}
}