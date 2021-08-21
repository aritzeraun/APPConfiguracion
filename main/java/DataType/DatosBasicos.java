package DataType;

public class DatosBasicos {
	private String DirectorioArchivosXML;
	private String DirectorioRecursos;
	private String DirectorioBaseDatos;
	
	public DatosBasicos(String directorioArchivosXML, String directorioRecursos, String directorioBaseDatos) {
		super();
		DirectorioArchivosXML = directorioArchivosXML;
		DirectorioRecursos = directorioRecursos;
		DirectorioBaseDatos = directorioBaseDatos;
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
}