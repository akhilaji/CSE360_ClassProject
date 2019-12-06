package classProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

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

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;

public class GCFrame extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GCFrame frame = new GCFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
				setBounds(100, 100, 800, 760);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				
				String low;
				
				JPanel titlePanel = new JPanel();
				titlePanel.setLayout(new MigLayout("", "[774px]", "[23px][][][][]"));
				
				JPanel valuePanel = new JPanel();
				
				JLabel lblLowBoundary = new JLabel("Low Boundary");
								
								JLabel lblHighBoundary = new JLabel("High Boundary");
								textField = new JTextField();
								
												textField.setColumns(10);
												
												
												textField_1 = new JTextField();
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
												GroupLayout gl_valuePanel = new GroupLayout(valuePanel);
												gl_valuePanel.setHorizontalGroup(
													gl_valuePanel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_valuePanel.createSequentialGroup()
															.addGap(88)
															.addGroup(gl_valuePanel.createParallelGroup(Alignment.LEADING)
																.addComponent(lblLowBoundary)
																.addComponent(textField, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblHighBoundary)
																.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
															.addGroup(gl_valuePanel.createParallelGroup(Alignment.LEADING)
																.addGroup(gl_valuePanel.createParallelGroup(Alignment.LEADING)
																	.addGroup(gl_valuePanel.createSequentialGroup()
																		.addGap(383)
																		.addGroup(gl_valuePanel.createParallelGroup(Alignment.LEADING)
																			.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																			.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																		.addContainerGap(137, Short.MAX_VALUE))
																	.addGroup(Alignment.TRAILING, gl_valuePanel.createSequentialGroup()
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(lblDeleteValue, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
																		.addGap(150)))
																.addGroup(Alignment.TRAILING, gl_valuePanel.createSequentialGroup()
																	.addPreferredGap(ComponentPlacement.RELATED)
																	.addComponent(lblAppendValue)
																	.addGap(145))))
												);
												gl_valuePanel.setVerticalGroup(
													gl_valuePanel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_valuePanel.createSequentialGroup()
															.addGap(10)
															.addGroup(gl_valuePanel.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblLowBoundary)
																.addComponent(lblDeleteValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
															.addGap(7)
															.addGroup(gl_valuePanel.createParallelGroup(Alignment.BASELINE)
																.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
															.addGap(21)
															.addGroup(gl_valuePanel.createParallelGroup(Alignment.BASELINE)
																.addComponent(lblHighBoundary)
																.addComponent(lblAppendValue))
															.addPreferredGap(ComponentPlacement.RELATED)
															.addGroup(gl_valuePanel.createParallelGroup(Alignment.BASELINE)
																.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
															.addGap(52))
												);
												valuePanel.setLayout(gl_valuePanel);
				
				JPanel analysisPanel = new JPanel();
				
				JLabel lblAnalysisInformation = new JLabel("Analysis Information");
				lblAnalysisInformation.setFont(new Font("Tahoma", Font.PLAIN, 18));
				
				JPanel panel = new JPanel();
				GroupLayout gl_contentPane = new GroupLayout(contentPane);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
								.addComponent(valuePanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
								.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 764, GroupLayout.PREFERRED_SIZE)
								.addComponent(analysisPanel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 764, Short.MAX_VALUE))
							.addContainerGap())
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(valuePanel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(analysisPanel, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
							.addContainerGap())
				);
				
				JLabel lblDistributionGraphs = new JLabel("Distribution Graphs");
				lblDistributionGraphs.setFont(new Font("Tahoma", Font.PLAIN, 18));
				
				JPanel distribution1 = new JPanel();
				distribution1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				
				JPanel distribution2 = new JPanel();
				distribution2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				GroupLayout gl_panel = new GroupLayout(panel);
				gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(306)
							.addComponent(lblDistributionGraphs)
							.addContainerGap(307, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap(84, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(distribution2, GroupLayout.PREFERRED_SIZE, 619, GroupLayout.PREFERRED_SIZE)
								.addComponent(distribution1, GroupLayout.PREFERRED_SIZE, 619, GroupLayout.PREFERRED_SIZE))
							.addGap(61))
				);
				gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDistributionGraphs)
							.addGap(18)
							.addComponent(distribution1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(distribution2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(30, Short.MAX_VALUE))
				);
				panel.setLayout(gl_panel);
				
				JLabel lblEntries = new JLabel("Entries:");
				lblEntries.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				table = new JTable();
				
				JLabel lblMean = new JLabel("Mean:");
				lblMean.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				JLabel lblMedian = new JLabel("Median:");
				lblMedian.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				JLabel lblMode = new JLabel("Mode:");
				lblMode.setFont(new Font("Tahoma", Font.BOLD, 14));
				
				JLabel cEntries = new JLabel("value");
				
				JLabel cMean = new JLabel("value");
				
				JLabel cMedian = new JLabel("value");
				
				JLabel cMode = new JLabel("value");
				
				JPanel barGraphPanel = new JPanel();
				barGraphPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
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
							.addGap(78)
							.addComponent(barGraphPanel, GroupLayout.PREFERRED_SIZE, 619, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(78, Short.MAX_VALUE))
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
							.addComponent(barGraphPanel, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
							.addContainerGap())
				);
				analysisPanel.setLayout(gl_analysisPanel);
				
				JLabel lblNewLabel = new JLabel("Grade Analytic Machine");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
				titlePanel.add(lblNewLabel, "cell 0 1,alignx center,aligny center");
				
				JLabel lblNewLabel_1 = new JLabel("Processes, analyzes, and outputs grade data.");
				titlePanel.add(lblNewLabel_1, "cell 0 2,alignx center,growy");
				
				JButton btnLoadData = new JButton("Load Data");
				btnLoadData.setFont(new Font("Tahoma", Font.BOLD, 12));
				titlePanel.add(btnLoadData, "flowx,cell 0 4,alignx center,aligny center");
				btnLoadData.setForeground(new Color(255, 140, 0));
				btnLoadData.setBackground(Color.WHITE);
				
				JButton btnAppendData = new JButton("Append Data");
				btnAppendData.setFont(new Font("Tahoma", Font.BOLD, 12));
				titlePanel.add(btnAppendData, "cell 0 4,alignx center,aligny center");
				btnAppendData.setForeground(new Color(255, 140, 0));
				btnAppendData.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						chooseFile();
					}
				});
				btnLoadData.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						chooseFile();
					}
				});
				contentPane.setLayout(gl_contentPane);
	}
	
	public String chooseFile() {
        final JFrame frame = new JFrame("Choose a file");
        
        final JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(true);
        
        String fileName = "";
        StringBuilder sb = new StringBuilder();
        int retVal = fc.showOpenDialog(frame);    
        if (retVal == JFileChooser.APPROVE_OPTION) {
            File[] selectedfiles = fc.getSelectedFiles();
            for (int i = 0; i < selectedfiles.length; i++) {
                sb.append(selectedfiles[i].getName() + "\n");               
            }
        }
        fileName = sb.toString();
        System.out.println(fileName);
        return fileName;
	}
}
