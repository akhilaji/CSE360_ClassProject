package classProject;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import javafx.embed.swing.JFXPanel;

import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GCFrame extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTable gradeTable;
	private JFXPanel distribution1;
	private JLabel cEntries;
	private JLabel cMean;
	private JLabel cMedian;
	private JLabel cMode;
	private String workingFile;
	
	private int highB;
	private int lowB;
	
	JTextArea errorArea;
	
	private GradeCalculations gCalcs = new GradeCalculations();
	GradeFileReader gFileReader;
	
	public int getHighB() {
		return highB;
	}

	public void setHighB(int highB) {
		this.highB = highB;
	}

	public int getLowB() {
		return lowB;
	}

	public void setLowB(int lowB) {
		this.lowB = lowB;
	}
	
	public String getWorkingFile() {
		return workingFile;
	}

	public void setWorkingFile(String workingFile) {
		this.workingFile = workingFile;
	}

	public JTable getGradeTable() {
		return gradeTable;
	}

	public void setGradeTable(JTable gradeTable) {
		this.gradeTable = gradeTable;
	}

	public JFXPanel getDistribution1() {
		return distribution1;
	}

	public void setDistribution1(JFXPanel distribution1) {
		this.distribution1 = distribution1;
	}

	public JLabel getcEntries() {
		return cEntries;
	}

	public void setcEntries(JLabel cEntries) {
		this.cEntries = cEntries;
	}

	public JLabel getcMean() {
		return cMean;
	}

	public void setcMean(JLabel cMean) {
		this.cMean = cMean;
	}

	public JLabel getcMedian() {
		return cMedian;
	}

	public void setcMedian(JLabel cMedian) {
		this.cMedian = cMedian;
	}

	public JLabel getcMode() {
		return cMode;
	}

	public void setcMode(JLabel cMode) {
		this.cMode = cMode;
	}

	/**
	 * Create the frame.
	 */
	public GCFrame() {
		setResizable(false);
		setTitle("Grade Analytic Machine");
		// Value to hold low boundary
				String lowerBoundary = "";
				
				
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 800, 950);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				
				String low;
				
				JPanel titlePanel = new JPanel();
				titlePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				titlePanel.setLayout(new MigLayout("", "[774px]", "[23px][][][][]"));
				
				JPanel valuePanel = new JPanel();
				valuePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				
				JLabel lblLowBoundary = new JLabel("Low Boundary");
								
								JLabel lblHighBoundary = new JLabel("High Boundary");
												textField = new JTextField("0");
												textField.setColumns(10);
												
												
												textField_1 = new JTextField("100");
												textField_1.addKeyListener(new KeyAdapter() {
													@Override
													public void keyReleased(KeyEvent e) {
														String low = "";
														low = textField_1.getText();
														System.out.println(lowerBoundary);
													}
												});
												textField_1.setColumns(10);
												
												JLabel lblDeleteValue = new JLabel("Delete Value");
												
												textField_2 = new JTextField();
												textField_2.setColumns(10);
												
												JLabel lblAppendValue = new JLabel("Append Value");
												
												textField_3 = new JTextField();
												textField_3.setColumns(10);
												
												JButton btnAppend = new JButton("Append");
												btnAppend.setForeground(new Color(255, 140, 0));
												btnAppend.setBackground(Color.WHITE);
												btnAppend.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseClicked(MouseEvent e) {
														handleAppend(textField_3.getText());
													}
												});
												
												JButton btnDelete = new JButton("Delete");
												btnDelete.setForeground(new Color(255, 140, 0));
												btnDelete.setBackground(Color.WHITE);
												btnDelete.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseClicked(MouseEvent e) {
														handleDelete(textField_2.getText());
													}
												});
												
												JButton btnBoundary = new JButton("Submit Boundaries");
												btnBoundary.setForeground(new Color(255, 140, 0));
												btnBoundary.setBackground(Color.WHITE);
												btnBoundary.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseClicked(MouseEvent e) {
														updateBoundaries(textField.getText(), textField_1.getText());
													}
												});
												
												GroupLayout gl_valuePanel = new GroupLayout(valuePanel);
												gl_valuePanel.setHorizontalGroup(
													gl_valuePanel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_valuePanel.createSequentialGroup()
															.addGroup(gl_valuePanel.createParallelGroup(Alignment.LEADING, false)
																.addGroup(gl_valuePanel.createSequentialGroup()
																	.addGap(170)
																	.addGroup(gl_valuePanel.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblLowBoundary)
																		.addComponent(textField, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
																	.addGap(18)
																	.addGroup(gl_valuePanel.createParallelGroup(Alignment.LEADING)
																		.addComponent(lblHighBoundary)
																		.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
																	.addGap(49))
																.addGroup(Alignment.TRAILING, gl_valuePanel.createSequentialGroup()
																	.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																	.addComponent(btnBoundary)
																	.addGap(72)))
															.addGroup(gl_valuePanel.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_valuePanel.createParallelGroup(Alignment.LEADING)
																	.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
																	.addComponent(lblAppendValue, Alignment.TRAILING))
																.addComponent(btnAppend))
															.addGap(18)
															.addGroup(gl_valuePanel.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_valuePanel.createSequentialGroup()
																	.addComponent(lblDeleteValue, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
																	.addContainerGap(46, Short.MAX_VALUE))
																.addGroup(gl_valuePanel.createSequentialGroup()
																	.addGroup(gl_valuePanel.createParallelGroup(Alignment.TRAILING, false)
																		.addComponent(textField_2, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
																		.addComponent(btnDelete, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																	.addContainerGap())))
												);
												gl_valuePanel.setVerticalGroup(
													gl_valuePanel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_valuePanel.createSequentialGroup()
															.addContainerGap()
															.addGroup(gl_valuePanel.createParallelGroup(Alignment.TRAILING)
																.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addGroup(gl_valuePanel.createSequentialGroup()
																	.addGroup(gl_valuePanel.createParallelGroup(Alignment.BASELINE)
																		.addComponent(lblLowBoundary)
																		.addComponent(lblHighBoundary))
																	.addPreferredGap(ComponentPlacement.RELATED)
																	.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_valuePanel.createParallelGroup(Alignment.BASELINE)
																	.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																	.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_valuePanel.createSequentialGroup()
																	.addGroup(gl_valuePanel.createParallelGroup(Alignment.BASELINE)
																		.addComponent(lblAppendValue)
																		.addComponent(lblDeleteValue, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
																	.addGap(29)))
															.addPreferredGap(ComponentPlacement.RELATED)
															.addGroup(gl_valuePanel.createParallelGroup(Alignment.BASELINE)
																.addComponent(btnDelete)
																.addComponent(btnAppend)
																.addComponent(btnBoundary))
															.addGap(11))
												);
												valuePanel.setLayout(gl_valuePanel);
				
				JPanel analysisPanel = new JPanel();
				analysisPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				
				JLabel lblAnalysisInformation = new JLabel("Analysis Information");
				lblAnalysisInformation.setFont(new Font("Tahoma", Font.PLAIN, 18));
				
				JPanel distributionPanel = new JPanel();
				distributionPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				
				JPanel errorPanel = new JPanel();
				errorPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				GroupLayout gl_contentPane = new GroupLayout(contentPane);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(errorPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
								.addComponent(analysisPanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(valuePanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
									.addComponent(titlePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE))
								.addComponent(distributionPanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
							.addGap(31))
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(valuePanel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(analysisPanel, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(distributionPanel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(errorPanel, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
				);
				
				JLabel lblNewLabel_2 = new JLabel("Error Logging");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
				
	
				
				errorArea = new JTextArea("No errors have occurred yet!");
				errorArea.setLineWrap(true);
				errorArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
				errorArea.setEditable(false);
				
				JButton btnWriteLogTo = new JButton("Write Log to File");
				btnWriteLogTo.setForeground(new Color(255, 140, 0));
				btnWriteLogTo.setBackground(Color.WHITE);
				btnWriteLogTo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						handleWriteToLog();
					}
				});
				
				JButton btnWriteGradesTo = new JButton("Write Grades to File");

				btnWriteGradesTo.setForeground(new Color(255, 140, 0));
				btnWriteGradesTo.setBackground(Color.WHITE);
				btnWriteGradesTo.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						 handleWriteToGrades();
					}
				});
				
				
				GroupLayout gl_errorPanel = new GroupLayout(errorPanel);
				gl_errorPanel.setHorizontalGroup(
					gl_errorPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_errorPanel.createSequentialGroup()
							.addGroup(gl_errorPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_errorPanel.createSequentialGroup()
									.addGap(331)
									.addComponent(lblNewLabel_2))
								.addGroup(gl_errorPanel.createSequentialGroup()
									.addGap(149)
									.addComponent(btnWriteLogTo, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
									.addGap(138)
									.addComponent(btnWriteGradesTo, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_errorPanel.createSequentialGroup()
									.addContainerGap()
									.addComponent(errorArea, GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)))
							.addContainerGap())
				);
				gl_errorPanel.setVerticalGroup(
					gl_errorPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_errorPanel.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(errorArea, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_errorPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnWriteLogTo)
								.addComponent(btnWriteGradesTo))
							.addGap(5))
				);
				errorPanel.setLayout(gl_errorPanel);
				
				JLabel lblDistributionGraphs = new JLabel("Distribution Graph");
				lblDistributionGraphs.setFont(new Font("Tahoma", Font.PLAIN, 18));
				
				distribution1 = new JFXPanel();
				distribution1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				GroupLayout gl_distributionPanel = new GroupLayout(distributionPanel);
				gl_distributionPanel.setHorizontalGroup(
					gl_distributionPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_distributionPanel.createSequentialGroup()
							.addGroup(gl_distributionPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_distributionPanel.createSequentialGroup()
									.addGap(306)
									.addComponent(lblDistributionGraphs))
								.addGroup(gl_distributionPanel.createSequentialGroup()
									.addGap(57)
									.addComponent(distribution1, GroupLayout.PREFERRED_SIZE, 619, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(61, Short.MAX_VALUE))
				);
				gl_distributionPanel.setVerticalGroup(
					gl_distributionPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_distributionPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDistributionGraphs)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(distribution1, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
							.addContainerGap())
				);
				distributionPanel.setLayout(gl_distributionPanel);
				
				JLabel lblEntries = new JLabel("Entries:");
				lblEntries.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				table = new JTable();
				
				JLabel lblMean = new JLabel("Mean:");
				lblMean.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				JLabel lblMedian = new JLabel("Median:");
				lblMedian.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				JLabel lblMode = new JLabel("Mode:");
				lblMode.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				cEntries = new JLabel("value");
				
				cMean = new JLabel("value");
				
				cMedian = new JLabel("value");
				
				cMode = new JLabel("value");
				
				gradeTable = new JTable();
				gradeTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				GroupLayout gl_analysisPanel = new GroupLayout(analysisPanel);
				gl_analysisPanel.setHorizontalGroup(
					gl_analysisPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_analysisPanel.createSequentialGroup()
							.addGap(258)
							.addGroup(gl_analysisPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_analysisPanel.createSequentialGroup()
									.addGap(10)
									.addComponent(cEntries))
								.addGroup(gl_analysisPanel.createSequentialGroup()
									.addGap(1)
									.addComponent(lblEntries, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_analysisPanel.createSequentialGroup()
									.addGap(10)
									.addComponent(cMedian))
								.addComponent(lblMedian, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_analysisPanel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_analysisPanel.createSequentialGroup()
									.addGroup(gl_analysisPanel.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_analysisPanel.createSequentialGroup()
											.addGap(10)
											.addComponent(cMode))
										.addComponent(lblMode)
										.addGroup(gl_analysisPanel.createSequentialGroup()
											.addGap(10)
											.addComponent(cMean))
										.addComponent(lblMean, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
									.addGap(162))
								.addGroup(gl_analysisPanel.createSequentialGroup()
									.addComponent(lblAnalysisInformation)
									.addGap(295))))
						.addGroup(gl_analysisPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(gradeTable, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(52, Short.MAX_VALUE))
				);
				gl_analysisPanel.setVerticalGroup(
					gl_analysisPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_analysisPanel.createSequentialGroup()
							.addGap(5)
							.addComponent(lblAnalysisInformation)
							.addGap(18)
							.addGroup(gl_analysisPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_analysisPanel.createSequentialGroup()
									.addComponent(lblMean)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cMean)
									.addGap(18)
									.addComponent(lblMode)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cMode))
								.addGroup(gl_analysisPanel.createSequentialGroup()
									.addComponent(lblEntries)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cEntries)
									.addGap(18)
									.addComponent(lblMedian)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cMedian)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gradeTable, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addContainerGap())
				);
				analysisPanel.setLayout(gl_analysisPanel);
				
				JLabel lblNewLabel = new JLabel("Grade Analytic Machine");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
				titlePanel.add(lblNewLabel, "cell 0 1,alignx center,aligny center");
				
				JLabel lblNewLabel_1 = new JLabel("Processes, analyzes, and outputs grade data.");
				titlePanel.add(lblNewLabel_1, "cell 0 2,alignx center,growy");
				
				JButton btnLoadData = new JButton("Load Data File");
				btnLoadData.setFont(new Font("Tahoma", Font.BOLD, 12));
				titlePanel.add(btnLoadData, "flowx,cell 0 4,alignx center,aligny center");
				btnLoadData.setForeground(new Color(255, 140, 0));
				btnLoadData.setBackground(Color.WHITE);
				
				JButton btnAppendData = new JButton("Append Data File");
				btnAppendData.setBackground(Color.WHITE);
				btnAppendData.setFont(new Font("Tahoma", Font.BOLD, 12));
				titlePanel.add(btnAppendData, "cell 0 4,alignx center,aligny center");
				btnAppendData.setForeground(new Color(255, 140, 0));
				btnAppendData.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						chooseFile();
						try {
							appendCurrentList();
						} catch (Exception e1) {
							gCalcs.addNewError("Exception thrown when updating list from btnLoadData" + e1.getClass());
							updateErrors();
						}
					}
					
				});
				btnLoadData.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						chooseFile();
						try {
							updateCurrentList();
						} catch (Exception e1) {
							gCalcs.addNewError("Exception thrown when updating list from btnLoadData" + e1.getClass());
							updateErrors();
						}
					}
				});
				contentPane.setLayout(gl_contentPane);
				//-----------------non generated
				//updating values after window is setup
				updateCalculations();
				updateBoundaries(textField.getText(), textField_1.getText());
	}
	
	private void chooseFile() {
        final JFrame frame = new JFrame("Choose a file");
        
        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text", "csv");
        fc.setFileFilter(filter);
        fc.setMultiSelectionEnabled(false);
        
        String fileName = "";
        int retVal = fc.showOpenDialog(frame);    
        if (retVal == JFileChooser.APPROVE_OPTION) {
            fileName = fc.getSelectedFile().getAbsolutePath();
        }
        workingFile = fileName;
	}
	
	private void updateBoundaries(String low, String high) {
		highB = Integer.parseInt(high);
		lowB = Integer.parseInt(low);
		
		gCalcs.setHighBound(getHighB());
		gCalcs.setLowBound(getLowB());
		try {
			gCalcs.checkBoundaries(gCalcs.getScoresList());
		} catch (Exception e) {}
		updateCalculations();
		updateErrors();
	}
	
	private void updateCurrentList() throws Exception {
		gFileReader = new GradeFileReader(workingFile);
		gCalcs.setScoresList(gFileReader.getGradeValues());
		try {
			gCalcs.checkBoundaries(gCalcs.getScoresList());
		} catch (Exception e) {}
		updateCalculations();
	}
	
	private void appendCurrentList() throws Exception {
		ArrayList<Double> newList = new ArrayList<Double>();
		gFileReader = new GradeFileReader(workingFile);
		try {
			newList.addAll(gCalcs.getScoresList());
			newList.addAll(gFileReader.getGradeValues());
			gCalcs.setScoresList(newList);
			gCalcs.checkBoundaries(gCalcs.getScoresList());
		} catch (Exception e) {}
		updateCalculations();
	}
	
	private void updateCalculations() {
		gCalcs.updateAll();
		this.cEntries.setText(gCalcs.getScoresList().size()+"");
		this.cMean.setText(gCalcs.getMean()+"");
		this.cMedian.setText(gCalcs.getMedian()+"");
		this.cMode.setText(gCalcs.getMode()+"");
	}


	private void handleAppend(String number) {
		Double value = Double.parseDouble(number);
		if (value >= lowB && value <= highB) {
			gCalcs.getScoresList().add(Double.parseDouble(number));
			updateCalculations();
		}
		else {
			gCalcs.addNewError("The value input was outside the appropriate range.");
			updateErrors();
		}
	}
	
	private void handleDelete(String number) {
		gCalcs.delete(Double.parseDouble(number), gCalcs.getScoresList());
		updateCalculations();
		updateErrors();
	}
	
	private void handleWriteToLog() {
		try {
			if(gCalcs.getErrorMessages() != null)
				gFileReader.writeErrorsToFile(gCalcs.getErrorMessages());
		} catch (IOException e) {
			gCalcs.addNewError("Exception thrown when writing file " + e.getClass());
			updateErrors();
		}
	}
	
	private void handleWriteToGrades() {
		try {
			if(gCalcs.getScoresList() != null)
				gFileReader.writeGradesToFile();
		} catch (IOException e) {
			gCalcs.addNewError("Exception thrown when writing file " + e.getClass());
			updateErrors();
		}
	}
	
	private void updateErrors() {
		String result = "";
		for(String st : gCalcs.getErrorMessages()) {
			result += st + "\n";
		}
		errorArea.setText(result);
	}
	
	private void handleTable() {
		JTable table;
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		Vector model = new Vector();
		Vector row = new Vector();
		int rows = gCalcs.getScoresList().size() % 4;
		
		for(int i = 0; i < rows; i++) {
			row.add(gCalcs.getScoresList().get(i));
			if(i == rows - 1)
				model.add(row);
		}

	}
}
