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


public class item_event_on_checkBox implements ItemListener{
	JCheckBox c1, c2, c3, c4;
	JTextArea t;
	
	item_event_on_checkBox(){
		JFrame f = new JFrame();
		f.setTitle("Item Event");
		f.setBounds(100, 100, 400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = f.getContentPane();
		c.setLayout(null);
		
		
		c1 = new JCheckBox("10th");
		c2 = new JCheckBox("12th");
		c3 = new JCheckBox("Under Graduation");
		c4 = new JCheckBox("Post Graduation");
		
		c1.setBounds(50, 50, 100, 30);
		c2.setBounds(50, 100, 100, 30);
		c3.setBounds(50, 150, 100, 30);
		c4.setBounds(50, 200, 100, 30);
		
		
		t = new JTextArea();
		t.setBounds(200, 50, 150, 300);
		
		
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		c4.addItemListener(this);
		
		c.add(c1); c.add(c2); c.add(c3); c.add(c4); c.add(t);
		
		f.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(c1.isSelected()) {
			t.setText("10th\n");
		}
		if(c2.isSelected()) {
			t.setText(t.getText() + "12th \n");
		}
		if(c3.isSelected()) {
			t.setText(t.getText() + "Pre-Graduation \n");
		}
		if(c4.isSelected()) {
			t.setText(t.getText() + "Post-Graduation \n");
		}
	}
	
	public static void main(String[] args) {
		new item_event_on_checkBox();
	}
}
