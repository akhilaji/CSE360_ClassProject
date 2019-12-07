package classProject;

import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Driver {
	
	public int minBoundary;
	public int maxBoundary;

	public static void main(String[] args) {
		//variables//
		GCFrame frame;
		GraphClass gClass;
		ErrorHandler eHandler;
		
		//GCFrame is the gui class, frame is our instance of the JFrame, GradeCalculation does as named
		frame = new GCFrame();
		frame.setVisible(true);
		

		// *********** delete this later !************
		int[] data = new int[] {100, 40, 30, 75, 80, 55, 67, 77, 88, 66};
		int rows =  4;
		gClass = new GraphClass();
		frame.getDistribution1().setScene(gClass.barGraph(data)); 
		
		
		//this is how you call the file 
		frame.getWorkingFile();
		
		//file
		
		
		
		
		JTable table = new JTable(new DefaultTableModel(4, rows));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[]{"Column 1", "Column 2", "Column 3"});
		
		frame.getGradeTable().setModel(model);
		
		//Handle file in
		
		//Handle file processing
		
		//get boundaries from gui, pass to gCalcs
				//check file elemenents against boundaries
				//run calculations
				//write data back to mean/meadian/mode/element amount in GCFrame
				
		
		//Handle Data to Table
		
		//Handle Table to GraphClass
		
		//Handle Distribution by percentage? not sure how this is different from bar graph.
		
		//Handle append to file from keyboard text box
		
	}
	
	
	static void printToFile() {
		
	}

	
	
}
