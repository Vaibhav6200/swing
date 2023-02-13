package classPrograms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


class register extends JFrame implements ActionListener{
	Container c;
	JLabel label1, label2, label3, label4, label5, label6, label7, registration;
	JPasswordField password;
	JTextField username, full_name, mobile;
	JTextArea address, display;
	JComboBox day, month, year;
	JButton submit;
	JRadioButton male, female;
	ButtonGroup gender;
	
	register(){	
		c = this.getContentPane();
		c.setLayout(null);
		
//		Declaring all variables
		label1 = new JLabel("Full Name");
		label2 = new JLabel("Username");
		label3 = new JLabel("Password");
		label4 = new JLabel("Mobile");
		label5 = new JLabel("Gender");
		label6 = new JLabel("DOB");
		label7 = new JLabel("Address");
		registration = new JLabel("Registration Form", SwingConstants.CENTER);
		
		submit = new JButton("Submit");
		username = new JTextField();
		full_name = new JTextField();
		mobile = new JTextField();
		address = new JTextArea();
		display = new JTextArea();
		password = new JPasswordField();
		
		male = new JRadioButton("male");
		female = new JRadioButton("female");
		gender = new ButtonGroup();
		gender.add(male);
		gender.add(female);
		
		String d[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
		String m[] = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
		String y[] = {"2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000"};
		
		day = new JComboBox(d);
		month = new JComboBox(m);
		year = new JComboBox(y);
		
		
		Font font = new Font("verdana", Font.BOLD, 30);
		registration.setBounds(150, 0, 450, 40);
		registration.setFont(font);
		
//		Style Full Name
		label1.setBounds(20, 50, 150, 20);
		full_name.setBounds(130, 50, 180, 20);
		
//		Style Username
		label2.setBounds(20, 100, 150, 20);
		username.setBounds(130, 100, 180, 20);
		
//		Style Password
		label3.setBounds(20, 150, 150, 20);
		password.setBounds(130, 150, 180, 20);
		
//		Style Mobile
		label4.setBounds(20, 200, 150, 20);
		mobile.setBounds(130, 200, 180, 20);
		
//		Style Gender
		label5.setBounds(20, 250, 150, 20);
		male.setBounds(130, 250, 100, 20);
		female.setBounds(230, 250, 100, 20);
		
//		Style DOB
		label6.setBounds(20, 300, 150, 20);
		day.setBounds(130, 300, 60, 20);
		month.setBounds(190, 300, 60, 20);
		year.setBounds(250, 300, 60, 20);
		
//		Style Address
		label7.setBounds(20, 350, 150, 20);
		address.setBounds(130, 350, 180, 100);
		address.setLineWrap(true);
		address.setWrapStyleWord(true);
		
//		Style Submit Button
		submit.setBounds(130, 500, 130, 30);
		
//		SETTING DISPLAY
		display.setBounds(375, 50, 300, 400);
		display.setLineWrap(true);
		display.setWrapStyleWord(true);
		display.setEditable(false);
		
//		Adding all components to our jframe
		c.add(label1); c.add(label2); c.add(label3); c.add(label4); c.add(label5); c.add(label6); c.add(label7); 
		c.add(username); c.add(password); c.add(full_name); c.add(mobile); c.add(submit); c.add(registration);
		c.add(male); c.add(female); c.add(day); c.add(month); c.add(year);  c.add(address); c.add(display);
		
//		Adding action listener to our submit button
		submit.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String display_text = "";
		if(submit == e.getSource()) {	// means submit button is pressed
			display_text = "Full Name: " + full_name.getText() + "\n";
			display_text += "Username: " + username.getText() + "\n";
			display_text += "Password: " + password.getText() + "\n";
			display_text += "Mobile No: " + mobile.getText() + "\n";
			
			String gen;
			if(male.isSelected())
				gen = "Male";
			else 
				gen = "Female";
			
			display_text += "Gender: " + gen + "\n";
			
			String dd = (String)day.getSelectedItem();
			String mm = (String)month.getSelectedItem();
			String yy = (String)year.getSelectedItem();
			
			display_text += "Date of Birth: " + dd + mm + yy + "\n";
			display_text += "Address: " + address.getText() + "\n";
		}
		
		display.setText(display_text);
	}
}


public class registrationForm {
	public static void main(String[] args) {
		register frame = new register();
		frame.setBounds(200, 50, 750,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}