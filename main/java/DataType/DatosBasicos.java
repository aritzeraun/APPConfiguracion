package DataType;

public class DatosBasicos {
	private String DirectorioArchivosXML;
	private String DirectorioRecursos;
	private String DirectorioBaseDatos;
	private String NombreBaseBatos;
	
	public DatosBasicos(String directorioArchivosXML, String directorioRecursos, String directorioBaseDatos,String NombreBaseBatos) {
		super();
		this.DirectorioArchivosXML = directorioArchivosXML;
		this.DirectorioRecursos = directorioRecursos;
		this.DirectorioBaseDatos = directorioBaseDatos;
		this.NombreBaseBatos = NombreBaseBatos;
	}

	public DatosBasicos() {

	}

	public String getDirectorioArchivosXML() {
		return DirectorioArchivosXML;
	}

	public void setDirectorioArchivosXML(String directorioArchivosXML) {
		DirectorioArchivosXML = directorioArchivosXML;
	}

	public String getDirectorioRecursos() {
		return DirectorioRecursos;
	}

	public void setDirectorioRecursos(String directorioRecursos) {
		DirectorioRecursos = directorioRecursos;
	}

	public String getDirectorioBaseDatos() {
		return DirectorioBaseDatos;
	}

	public void setDirectorioBaseDatos(String directorioBaseDatos) {
		DirectorioBaseDatos = directorioBaseDatos;
	}

	public String getNombreBaseBatos() {
		return NombreBaseBatos;
	}

	public void setNombreBaseBatos(String nombreBaseBatos) {
		NombreBaseBatos = nombreBaseBatos;
	}
}