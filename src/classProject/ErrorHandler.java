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
	 * 
	 */
	public ErrorHandler() {
		// TODO Auto-generated constructor stub
		ArrayList<String> errorMessages  = new ArrayList<String>();
	}
	
	void addNewError(String newMessage) {
		errorMessages.add(newMessage);
	}
	
	void printArray() {
		errorMessages.forEach(error -> {;
			System.out.println(error);
		});
	}
	
	

}
