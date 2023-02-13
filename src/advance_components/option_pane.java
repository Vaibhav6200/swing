package advance_components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class option_pane implements ActionListener{
	JFrame f;
	JButton btn1, btn2, btn3;
	option_pane(){
		f = new JFrame();
		f.setBounds(200, 150, 600, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		Container c = f.getContentPane();
		
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER, 30, 10);
		c.setLayout(flow);
		
		btn1 = new JButton("Open Input Dialog");
		btn2 = new JButton("Open Message Dialog");
		btn3 = new JButton("Open Confirm Dialog");
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		c.add(btn1); c.add(btn2); c.add(btn3);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			String name = JOptionPane.showInputDialog("Enter Your Name ");
			if(name.length() > 0)
				System.out.println("Entered Name: " + name);
		}
		else if(e.getSource() == btn2) {
			String message = "This is a Sample Message.";
			String title = "Message";
			
//			JOptionPane.showMessageDialog(f, message, title, JOptionPane.PLAIN_MESSAGE);
//			JOptionPane.showMessageDialog(f, message, title, JOptionPane.INFORMATION_MESSAGE);
//			JOptionPane.showMessageDialog(f, message, title, JOptionPane.QUESTION_MESSAGE);
//			JOptionPane.showMessageDialog(f, message, title, JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(f, message, title, JOptionPane.WARNING_MESSAGE);
		}
		
		else if(e.getSource() == btn3) {
			String message = "This is a Sample Message.";
			String title = "Confirm";
			int result = JOptionPane.showConfirmDialog(f, message, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
//			int result = JOptionPane.showConfirmDialog(f, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
//			System.out.println(result);
//			RETURNS yes = 0, No = 1, Cancel = 2;
			
			
			if(result == JOptionPane.YES_OPTION)
				System.out.println("Yes Option Selected \n");
			
			else if(result == JOptionPane.NO_OPTION)
				System.out.println("No Option Selected \n");
			
			else if(result == JOptionPane.CANCEL_OPTION)
				System.out.println("Cancel Option Selected \n");
			
		}
	}
	
	
	public static void main(String[] args) {
		new option_pane();
	}

}
