package ScreenShotApplication;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Take_Screenshot {
	
	public static void main(String[] args) {
		   JFrame frame = new JFrame("Screenshot");
	        frame.setSize(500,200);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(new BorderLayout());

//	        JTextField textField = new JTextField();
//	        textField.setHorizontalAlignment(JTextField.RIGHT);
//	        frame.add(textField, BorderLayout.NORTH);
	        

	        JPanel panel = new JPanel(new GridBagLayout());
	        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Paddin
	        
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        

	        // Row 0 - URL
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        panel.add(new JLabel("URL:"), gbc);

	        gbc.gridx = 1;
	        gbc.weightx = 1.0;
	        JTextField text1 = new JTextField(30);
	        panel.add(text1, gbc);

	        // Row 1 - Username
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        gbc.weightx = 0;
	        panel.add(new JLabel("Username:"), gbc);

	        gbc.gridx = 1;
	        gbc.weightx = 1.0;
	        JTextField text2 = new JTextField(20);
	        panel.add(text2, gbc);

	        // Row 2 - Password
	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        gbc.weightx = 0;
	        panel.add(new JLabel("Password:"), gbc);

	        gbc.gridx = 1;
	        gbc.weightx = 1.0;
	        JPasswordField text3 = new JPasswordField(20);
	        panel.add(text3, gbc);

	        // Row 3 - Button
	        gbc.gridx = 1;
	        gbc.gridy = 3;
	        gbc.anchor = GridBagConstraints.EAST;
	        gbc.fill = GridBagConstraints.NONE;
	        JButton btn1 = new JButton("Capture Screenshot");
	        panel.add(btn1, gbc);

	        // Add panel to frame
	        frame.add(panel, BorderLayout.CENTER);
	        frame.setVisible(true);
	        
	        
	        btn1.addActionListener(e ->{
	        	
	        	String url = text1.getText().trim();
	        	String Username = text2.getText().trim();
	        	String Password = text3.getText().trim();
	        	
	        	 if (!url.startsWith("http://") && !url.startsWith("https://")) {
	                 JOptionPane.showMessageDialog(frame,
	                         "Invalid URL. It should start with http:// or https://",
	                         "Error", JOptionPane.ERROR_MESSAGE);
	             } else {
	                 // Show info
	                 JOptionPane.showMessageDialog(frame,
	                         "URL: " + url +
	                         "\nUsername: " + Username +
	                         "\nPassword: " + Password,
	                         "Details Submitted", JOptionPane.INFORMATION_MESSAGE);
	             }
	        	
	        	 GUI_steps gui = new GUI_steps();
	        	 try {
					gui.application_login(url,Username, Password);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	
	        });
	        
	        
	}
	
	
	
}
