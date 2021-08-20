package ReadingFiles;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import DBManager.InsertData;

public class ReadFile {
	public ReadFile() {
	}
		
	public String read(String fileName, Connection connect) {
		String data = "";
		BufferedReader objReader = null;
		  try {
		   String strCurrentLine;

		   objReader = new BufferedReader(new FileReader(fileName));

		   while ((strCurrentLine = objReader.readLine()) != null) {
			 //  data = data+ strCurrentLine+"\n ";
			   data = strCurrentLine;
			   InsertData insert = new InsertData();
			   insert.insert(data, connect);
		   }
		  } catch (IOException e) {
			  e.printStackTrace();
		  } finally {
			  try {
				  if (objReader != null)
					  objReader.close();
		   } catch (IOException ex) {
			   ex.printStackTrace();
			   }
			  }
	    return data;
	}
}