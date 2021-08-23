package ReadingFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;


public class FicheroOculto {
	public FicheroOculto() {
		
	}

	public void CrearFicheroOculto(String exteString, String nombre, String path, String text) throws IOException {
        try {
            File file = new File(path + nombre + exteString);

            Path toCreatePath = Paths.get(file.toURI());
          
            Files.createFile(toCreatePath);
            Files.setAttribute(file.toPath(), "dos:hidden", true);
           
            Files.write(toCreatePath, text.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
         } catch (IOException e) {        	e.getMessage();
        }
    }
	
	public void moverFiceheros(String recursosDirectorioViejo, String recursosDirectorioNuevo, String nombreViejo, String nombreNuevo, String BDDirectorioViejo, String BDDirectorioNuevo) throws IOException {
		    try {

		    	if (!BDDirectorioNuevo.equals("")) {
		    		Files.copy(Paths.get(BDDirectorioViejo), Paths.get(BDDirectorioNuevo), StandardCopyOption.REPLACE_EXISTING);
		    	}
		    	if (!nombreNuevo.equals("")) {
		    		if (!BDDirectorioNuevo.equals("")){
		    			File file =new File(BDDirectorioNuevo+nombreViejo);
		    			File newFile = new File(BDDirectorioNuevo+nombreNuevo);
		    			file.renameTo(newFile);
		    		}else{
		    			File file =new File(BDDirectorioViejo+nombreViejo);
		    			File newFile = new File(BDDirectorioViejo+nombreNuevo);
		    			file.renameTo(newFile);
		    		}
		    	}
		    	
		    	if(recursosDirectorioNuevo.equals("")) {
		    		recursosDirectorioNuevo = recursosDirectorioViejo;
		    	}
		    	
		    	if(nombreNuevo.equals("")) {
		    		nombreNuevo = nombreViejo;
		    	}
		    
		    	if(BDDirectorioNuevo.equals("")) {
		    		BDDirectorioNuevo = BDDirectorioViejo;
		    	}

		    	CrearFicheroOculto(".txt", "ficheroDeConfiguracion",".\\",BDDirectorioNuevo+ ";"+nombreNuevo+";"+recursosDirectorioNuevo);		       

		    } catch (Exception e) {

		        e.printStackTrace();
		    }

    }
}