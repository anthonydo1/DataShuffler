package cs146F19.Do.project1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


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
		
		String firstLine = br.readLine();
		String[] str = firstLine.split(" ");
		String[] ids = new String[Integer.parseInt(str[3])];
		
		boolean endOfFile = false;
		int count = 0;
		
		while (endOfFile == false) {
			String id = br.readLine();
			if (id == null) {
				endOfFile = true;
			} else {
				ids[count] = id;
				count++;
			}
		}
		
		br.close();
		fr.close();

		return ids;
	}
	
}
