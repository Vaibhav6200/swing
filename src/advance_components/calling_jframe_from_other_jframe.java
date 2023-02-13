package advance_components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class calling_jframe_from_other_jframe implements ActionListener{
	JFrame frame1, frame2;
	JTextField textfield;
	JButton click, submit;
	JLabel label;
	
	calling_jframe_from_other_jframe(){
		frame1 = new JFrame();
		frame1.setSize(400, 300);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		click = new JButton("Click Me");
		label = new JLabel("Text will appear here...");
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(click);
		
		click.addActionListener(this);
		
		frame1.add(panel);
		
		frame1.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == click) {
			frame1.dispose();
			
			frame2 = new JFrame();
			frame2.setBounds(200, 150, 400, 200);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setVisible(true);
			
			textfield = new JTextField();
			textfield.setColumns(20);
			submit = new JButton("Submit");

			JPanel panel = new JPanel();
			panel.add(textfield);
			panel.add(submit);
			
			frame2.add(panel);
			
			submit.addActionListener(this);
		}
		else if(e.getSource() == submit) {
			String str = textfield.getText();
			label.setText(str);
			frame2.dispose();
			frame1.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new calling_jframe_from_other_jframe();
	}
}
