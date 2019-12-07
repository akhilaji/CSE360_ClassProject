package gradeCalculator;

/*
 * Class creates and maintains an ArrayList of grade values.
 * A file is read and the ArrayList is loaded with the values 
 * contained in the file.
 * The contents of the ArrayList can then be printed.
 */

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class GradeFileReader {
	private ArrayList<Float> gradeValues;

	/*
	 * Constructor takes in a file name, opens it, and saves its
	 * contents to the class' ArrayList.
	 * Input: A file name, can be txt or csv
	 */
	public GradeFileReader( String fileName ) throws Exception {
		this.gradeValues = new ArrayList<Float>();
		
		File file = new File(fileName);
		Scanner fileReader = new Scanner(file);
		fileReader.useDelimiter(",|\\n");
		
		String readValue;
		float value;
		while (fileReader.hasNext() ) {
			readValue = fileReader.next();
			value = Integer.parseInt(readValue);
			gradeValues.add(value);
		}
		
		fileReader.close();
	}
	
	/*
	 * Prints all values in the class' ArrayList variable.
	 */
	public void printAllGradeValues() {
		for ( int i = 0; i < gradeValues.size(); i++ ) {
			System.out.println( gradeValues.get(i) );
		}
	}
	
	
}
