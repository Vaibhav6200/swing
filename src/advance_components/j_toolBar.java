package advance_components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class j_toolBar implements ActionListener{
	JToolBar toolbar;
	JFrame f;
	JButton btn1, btn2;
	JTextField textfield;
	JComboBox combo;
	JLabel label;
	
	j_toolBar(){
		f = new JFrame();
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		
		String[] items = {"Cut", "Copy", "Paste", "Save", "Save As"};
		
		btn1 = new JButton("Button 1");
		btn2 = new JButton("Button 2");
		textfield = new JTextField();
		combo = new JComboBox(items);
		
		toolbar = new JToolBar();
		toolbar.add(combo);
		toolbar.add(textfield);
		toolbar.add(btn1);
		toolbar.add(btn2);
		
		toolbar.setFloatable(false);   // set it to false so that user cannot drag toolbar
		
		label = new JLabel("Selected Option will be Displayed Here ... ", SwingConstants.CENTER);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		textfield.addActionListener(this);
		combo.addActionListener(this);
		
		f.add(label, BorderLayout.CENTER);
		f.add(toolbar, BorderLayout.PAGE_START);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) 
			label.setText("Button 1 Selected");
		
		else if(e.getSource() == btn2) 
			label.setText("Button 2 Selected");
		
		else if(e.getSource() == textfield) 
			label.setText(textfield.getText());
		
		else if(e.getSource() == combo) 
			label.setText(combo.getSelectedItem() + " : Item Selected");
	}
	
	public static void main(String[] args) {
		new j_toolBar();
	}
}
