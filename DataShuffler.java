package cs146F19.Do.project1;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class DataShuffler {
	
	private String[] data;
	
	
	/**
	 * Constructs a DataShuffler object.
	 * @param data An array of Strings.
	 */
	public DataShuffler(String[] data) {
		this.data = data;
	}
	
	
	/**
	 * Shuffles the data using the Fisher-Yates algorithm.
	 */
	public void shuffle() {
		Random random = new Random();
		random.setSeed(20);
		
		for (int i = data.length - 1; i >= 1; i--) {
			int j = random.nextInt(i - 1 + 1);
			swap(i, j);
		}
	}
	
	
	/**
	 * Swaps elements i and j.
	 * @param i The index of the first element.
	 * @param j The index of the second element.
	 */
	public void swap(int i, int j) {
		String temp = data[j];
		data[j] = data[i];
		data[i] = temp;
	}
	
	
	/**
	 * Returns the data of the object.
	 * @return The data.
	 */
	public String[] getData() {
		return data;
	}
	
	
	/**
	 * Prints the data.
	 */
	public void printData() {
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		double start = System.currentTimeMillis();
		DataConverter fc = new DataConverter(new File("ErdosCA.txt"));
		DataShuffler ds = new DataShuffler(fc.convert());
		ds.shuffle();
		
		DataWriter dw = new DataWriter(ds.getData());
		dw.writeData();
		
		System.out.println("Completed in " + (System.currentTimeMillis() - start) + " Milliseconds");
	}
	
}
