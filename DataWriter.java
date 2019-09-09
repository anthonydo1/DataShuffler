package cs146F19.Do.project1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {
	
	private String[] data;
	
	
	public DataWriter(String[] data) {
		this.data = data;
	}
	
	
	public void writeData() throws IOException {
		FileWriter fw = new FileWriter("DoAnthonyShuffled.txt");
		BufferedWriter bw = new BufferedWriter(fw);
	
		for (int i = 0; i < data.length; i++) {
			bw.write(data[i]);
			bw.newLine();
		}
		
		bw.close();
		fw.close();
	}
	
	
	public void printdata() {
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
	
}
