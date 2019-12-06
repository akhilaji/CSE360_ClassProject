package classProject;

import java.awt.EventQueue;

import javax.swing.JLabel;

public class Driver {

	public static void main(String[] args) {
		//variables//
		GCFrame frame;
		GraphClass gClass;
		
		//GCFrame is the gui class, frame is our instance of the JFrame
		//all data is stored there so .get() it from frame
		frame = new GCFrame();
		frame.setVisible(true);
		
		// *********** delete this later !************
		int[] data = new int[] {100, 40, 30, 75, 80, 55, 67, 77, 88, 66};
		//**********************************************
		//take the frame, get the component that will hold the graph, set the scene of the graph to
		//the one now returned by barGraph function.
		//effectively this embeds the javafx into the swing component
		gClass = new GraphClass();			// VVVV the data will be from file, but barGraph method may need to change to accomodate
		frame.getDistribution1().setScene(gClass.barGraph(data)); 
		
		
		//this is how you call the file 
		frame.getWorkingFile();
		
		//test and example of how to change the c values..
		frame.getcMean().setText("test");
	}
}
