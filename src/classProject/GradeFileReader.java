package classProject;

/*
 * Class creates and maintains an ArrayList of grade values.
 * A file is read and the ArrayList is loaded with the values 
 * contained in the file.
 * The contents of the ArrayList can then be printed.
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class GradeFileReader {
	private ArrayList<Double> gradeValues;

	/*
	 * Constructor takes in a file name, opens it, and saves its
	 * contents to the class' ArrayList.
	 * Input: A file name, can be txt or csv
	 */
	public GradeFileReader( String fileName ) throws Exception {
		this.gradeValues = new ArrayList<Double>();
		
		File file = new File(fileName);
		Scanner fileReader = new Scanner(file);
		fileReader.useDelimiter(",|\\n");
		
		String readValue;
		Double value;
		while (fileReader.hasNext() ) {
			readValue = fileReader.next();
			value = Double.parseDouble(readValue);
			gradeValues.add(value);
		}
		
		fileReader.close();
	}
	
	public ArrayList<Double> getGradeValues() {
		return gradeValues;
	}

	public void setGradeValues(ArrayList<Double> gradeValues) {
		this.gradeValues = gradeValues;
	}

	/*
	 * Prints all values in the class' ArrayList variable.
	 */
	public void printAllGradeValues() {
		for ( int i = 0; i < gradeValues.size(); i++ ) {
			System.out.println( gradeValues.get(i) );
		}
	}
	
	/*
	 * Prints all values in the class' ArrayList to a file.
	 */
	public void writeGradesToFile() throws IOException {
		String value = "";
		BufferedWriter gradeWriter = new BufferedWriter( new FileWriter( "gradeValues.txt") );
		for ( int i = 0; i < gradeValues.size(); i++ ) {
			value = Double.toString( gradeValues.get(i) );
			gradeWriter.write(value);
			gradeWriter.newLine();
		}
		gradeWriter.close();
	}
	
	public void writeErrorsToFile(ArrayList<String> errors) throws IOException {
		String value = "";
		BufferedWriter gradeWriter = new BufferedWriter( new FileWriter( "errorLog.txt") );
		for ( int i = 0; i < errors.size(); i++ ) {
			value = errors.get(i);
			gradeWriter.write(value);
			gradeWriter.newLine();
		}
		gradeWriter.close();
	}
}
