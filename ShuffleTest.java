package cs146F19.Do.project1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class ShuffleTest {

	@Test
	void test() throws IOException {
		double start = System.currentTimeMillis();
		DataConverter fc = new DataConverter(new File("ErdosCA.txt"));
		DataShuffler ds = new DataShuffler(fc.convert());
		ds.shuffle();
		
		DataWriter dw = new DataWriter(ds.getData());
		dw.writeData();
		
		System.out.println("Shuffle was completed in " + (System.currentTimeMillis() - start) + " Milliseconds");
		
		BufferedReader Out = new BufferedReader(new FileReader("DoAnthonyShuffled.txt"));
		BufferedReader In = new BufferedReader(new FileReader("Target2.txt"));
		
		String expectedLine;
		
		while ((expectedLine = In.readLine()) != null) {
			String actualLine = Out.readLine();
			assertEquals(expectedLine, actualLine);
		}
	}
}
