/**
 * 
 */
package classProject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author akhilaji
 *
 */
public class ErrorHandler {
	
	ArrayList<String> errorMessages  = new ArrayList<String>();

	/**
	 * Constructor used to create object that handles error log.
	 */
	public ErrorHandler() {
		// TODO Auto-generated constructor stub
		ArrayList<String> errorMessages  = new ArrayList<String>();
	}
	
	/**
	* Adds a new error to the error log
	*/
	void addNewError(String newMessage) {
		errorMessages.add(newMessage);
	}
	
	/**
	* Prints the error log
	*/
	void printArray() {
		errorMessages.forEach(error -> {;
			System.out.println(error);
		});
	}

}
