/*
 * ITEM Listener will be fired for
 * (i) ComboBox
 * (ii) RadioButton
 * (iii) JCheckBoxMenuItem
 * */



/*	METHODS In JComboBox
 *  combo.getSelectedItem();
 *  combo.removeItem(string);
 * 	combo.addItem(string);
 * */

package event_listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class item_event_on_combobox implements ItemListener{
	JComboBox combo;
	JLabel label;
	
	item_event_on_combobox(){
		JFrame f = new JFrame();
		f.setTitle("Item Event");
		f.setBounds(100, 100, 400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = f.getContentPane();
		c.setLayout(null);
		
		
		String[] items = {"Jan", "Feb", "Mar", "Apr"};
		combo = new JComboBox(items);
		combo.setBounds(50, 50, 100, 30);
		c.add(combo);
		
		combo.addItemListener(this);
		
		label = new JLabel();
		label.setBounds(250, 50, 100, 30);
		c.add(label);
		
		
		f.setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent e) {
		String str = combo.getSelectedItem().toString();
		label.setText(str);
	}
	
	public static void main(String[] args) {
		new item_event_on_combobox();
	}
}
