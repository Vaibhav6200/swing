/*
 * ITEM Listener will be fired for
 * (i) ComboBox
 * (ii) RadioButton
 * (iii) JCheckBoxMenuItem
 * */

package event_listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class item_event_on_radioButton implements ItemListener{
	JRadioButton male, female;
	JTextArea t;
	
	item_event_on_radioButton(){
		JFrame f = new JFrame();
		f.setTitle("Item Event");
		f.setBounds(100, 100, 400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = f.getContentPane();
		c.setLayout(null);
		
		
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		male.setBounds(50, 50, 100, 30);
		female.setBounds(50, 100, 100, 30);
		c.add(male);
		c.add(female);
		ButtonGroup gender = new ButtonGroup();
		gender.add(male);
		gender.add(female);
		
		t = new JTextArea();
		t.setBounds(150, 50, 200, 100);
		c.add(t);
		
		male.addItemListener(this);
		female.addItemListener(this);
		
		f.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(male.isSelected()) {
			t.setText("Male Selected");
		}
		else if(female.isSelected()) {
			t.setText("Female Selected");
		}
	}
	
	public static void main(String[] args) {
		new item_event_on_radioButton();
	}
}
