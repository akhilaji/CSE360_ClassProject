package gradeCalculator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFileChooser;

public class Start extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
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
	public Start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnLoadData = new JButton("Load Data");
		btnLoadData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chooseFile();
			}
		});
		GridBagConstraints gbc_btnLoadData = new GridBagConstraints();
		gbc_btnLoadData.insets = new Insets(0, 0, 5, 5);
		gbc_btnLoadData.gridx = 2;
		gbc_btnLoadData.gridy = 5;
		contentPane.add(btnLoadData, gbc_btnLoadData);
		
		JButton btnAppendData = new JButton("Append Data");
		btnAppendData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chooseFile();
			}
		});
		GridBagConstraints gbc_btnAppendData = new GridBagConstraints();
		gbc_btnAppendData.insets = new Insets(0, 0, 5, 0);
		gbc_btnAppendData.gridx = 6;
		gbc_btnAppendData.gridy = 5;
		contentPane.add(btnAppendData, gbc_btnAppendData);

	}
	
	public void chooseFile() {
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
	}

}
