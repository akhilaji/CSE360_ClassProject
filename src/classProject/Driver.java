package classProject;

import java.awt.EventQueue;

import javax.swing.JLabel;

public class Driver {
	
	public int minBoundary;
	public int maxBoundary;

	public static void main(String[] args) {
		//variables//
		GCFrame frame;
		GraphClass gClass;
		
		//GCFrame is the gui class, frame is our instance of the JFrame
		//all data is stored there so .get() it from frame
		frame = new GCFrame();
		frame.setVisible(true);
		
		//filling data from textbox
		
		
		
		//this is how you call the file 
		frame.getWorkingFile();
		
		//test and example of how to change the c values..
		frame.getcMean().setText("test");
		
		
		//Handle file in
		
		//Handle file processing
				//check file elemenents against boundaries
				//run calculations
				//write data back to mean/meadian/mode/element amount in GCFrame
				
		
		//Handle Data to Table
		
		//Handle Table to GraphClass
			// *********** delete this later !************
		int[] data = new int[] {100, 40, 30, 75, 80, 55, 67, 77, 88, 66};
			//**********************************************
			//take the frame, get the component that will hold the graph, set the scene of the graph to
			//the one now returned by barGraph function.
			//effectively this embeds the javafx into the swing component
		gClass = new GraphClass();			// VVVV the data will be from file, but barGraph method may need to change to accomodate
		frame.getDistribution1().setScene(gClass.barGraph(data)); 
		
		//Handle Distribution by percentage? not sure how this is different from bar graph.
		
		//Handle append to file from keyboard text box
		
		
	}
	
	
	static void printToFile() {
		
	}

	
	
}
