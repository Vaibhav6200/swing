package classPrograms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class myFrame extends JFrame implements ActionListener{
	Container c;
	JLabel label1, label2;
	JPasswordField pass;
	JTextField username;
	JButton login;
	
	myFrame(){
		this.setBounds(200, 150, 400, 300);
		c = this.getContentPane();
		c.setLayout(null);
		
		label1 = new JLabel("Username");
		label2 = new JLabel("Password");
		login = new JButton("Login");
		username = new JTextField();
		pass = new JPasswordField();
		
		label1.setBounds(20, 50, 100, 20);
		label2.setBounds(20, 100, 100, 20);
		login.setBounds(130, 150, 100, 20);
		username.setBounds(130, 50, 150, 20);
		pass.setBounds(130, 100, 150, 20);
		
		c.add(label1); c.add(label2); c.add(username); c.add(pass); c.add(login); 
		login.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Username: " + username.getText());
		System.out.println("Password: " + pass.getText());
	}
}

public class loginForm {
	public static void main(String[] args) {
		myFrame frame = new myFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
