package cs146F19.Do.project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataConverter {
	
	private File file;
	
	
	/**
	 * Constructs a DataConverter object.
	 * @param file The file to be converted.
	 */
	public DataConverter(File file) {
		this.file = file;
	}
	
	
	/**
	 * Converts the file into an array of Strings.
	 * @return An array of Strings.
	 * @throws IOException
	 */
	public String[] convert() throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		List<String> ids = new ArrayList<>();
		
		boolean endOfFile = false;
		
		while (endOfFile == false) {
			String id = br.readLine();
			if (id == null) {
				endOfFile = true;
			} else {
				ids.add(id);	
			}
		}
		
		br.close();
		fr.close();

		return ids.toArray(new String[0]);
	}
	
}
