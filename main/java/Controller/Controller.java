package Controller;



import java.io.File;
import java.io.IOException;

import DBManager.DBManager;
import GUIConfiguracion.ConfigureWindow;
import ReadingFiles.FicheroOculto;
import ReadingFiles.ReadFile;



public class Controller {
	
	public static void main (String[] args) {
		
		//Verificamos si existe el fichero oculto de configuracion y, en su caso, lo creamos
		String filePathString =".\\ficheroDeConfiguracion.txt";
		
		File f = new File(filePathString);
		if(f.exists() || f.isHidden() == true) { 
		}else {
			FicheroOculto ficeheroOculto = new FicheroOculto();
			try {
				ficeheroOculto.CrearFicheroOculto(".txt", "ficheroDeConfiguracion",".\\", ";TBAIDatabase.db;.\\src\\main\\resources\\ArchivosPlanos\\");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		ReadFile reder =  new ReadFile();
		String datos =reder.read(filePathString, null);
		String[]datosSeparados =datos.split(";");
		
		File baseDatos = new File(datosSeparados[0] + datosSeparados[1]);
		if (baseDatos.exists()) {
			//la base de datos existe
		}else {
			DBManager manager = new DBManager(datosSeparados[1], "jdbc:sqlite:"+datosSeparados[0]);
			manager.crearBaseDatos(datosSeparados[1], "jdbc:sqlite:"+datosSeparados[0], datosSeparados[2]);
		}

		ConfigureWindow framePrincipal = new ConfigureWindow(datosSeparados[1], "jdbc:sqlite:"+datosSeparados[0], datosSeparados[2]);
		framePrincipal.setVisible(true);	
	}
}