package tables;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

import javax.swing.table.DefaultTableModel;



public class basic_table {
	JFrame f;
	JTable table;
	DefaultTableModel model;
	JTextField roll, name, age;
	JButton add_row, update_row, delete_row;
	JLabel label1, label2, label3;
	
	
	basic_table(){
		f = new JFrame();
		f.setSize(600, 400);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		Container c = f.getContentPane();
		c.setLayout(new GridLayout(3, 1));
		
		Object[][] data = {{101, "Vaibhav", 21}, {102, "John", 33}, {103, "Jahnavi", 28}};
		String[] columnNames = {"Roll No.", "Name", "Age"};
		
		model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		
		
//		Designing Update Panel and then add it to our frame
		label1 = new JLabel("Roll No", SwingConstants.CENTER);
		label2 = new JLabel("Name", SwingConstants.CENTER);
		label3 = new JLabel("Age", SwingConstants.CENTER);
		
		roll = new JTextField();
		name = new JTextField();
		age = new JTextField();
		
		add_row = new JButton("Add");
		update_row = new JButton("Update");
		delete_row = new JButton("Delete");
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 10, 10, 100));		// used to set padding {top, left, bottom, right}
		panel.setLayout(new GridLayout(3, 3));
		panel.add(label1); 
		panel.add(roll); 
		panel.add(add_row); 
		
		panel.add(label2); 
		panel.add(name); 
		panel.add(update_row); 
		
		panel.add(label3);
		panel.add(age);
		panel.add(delete_row);
 		
		
		c.add(new JScrollPane(table));
		c.add(new JPanel());
		c.add(panel);
		
		
//		Handle Row Add Operation in Table
		add_row.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(roll.getText().length() == 0 || name.getText().length() == 0 || age.getText().length() == 0) {
					JOptionPane.showMessageDialog(c, "Enter All Fields", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					int r = Integer.parseInt(roll.getText());
					String n = name.getText();
					int a = Integer.parseInt(age.getText());
					
					Object[] newData = {r, n, a};
					model.addRow(newData);
					
					roll.setText(null);
					name.setText(null);
					age.setText(null);
				}
			}
		});
		
		
//		Handle Row Update Operation in Table
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
//				Step1: Get Selected Row
				int row = table.getSelectedRow();
				
				int old_roll = (int) model.getValueAt(row, 0);
				String old_name = (String) model.getValueAt(row, 1);
				int old_age = (int) model.getValueAt(row, 2);
				
//				Step2: Set these old values to our Text Fields
				roll.setText(Integer.toString(old_roll));
				name.setText(old_name);
				age.setText(Integer.toString(old_age));
			}
		});
		
//		Step3: Now User will enter new values in text fields and will press update button
		update_row.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(roll.getText().length() == 0 || name.getText().length() == 0 || age.getText().length() == 0) {
					JOptionPane.showMessageDialog(c, "Enter All Fields", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
//				Step4: Get New Values Entered By User in TextFields 
					int new_roll = Integer.parseInt(roll.getText());
					String new_name = name.getText();
					int new_age = Integer.parseInt(age.getText());
					
					int row = table.getSelectedRow();
					
					model.setValueAt(new_roll, row, 0);
					model.setValueAt(new_name, row, 1);
					model.setValueAt(new_age, row, 2);
					
					roll.setText(null);
					name.setText(null);
					age.setText(null);
				}
			}
		});
		
		
		
//		Handle Row Delete Operation in Table
		delete_row.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1)		// no row selected for delete
					JOptionPane.showMessageDialog(null, "Select a Row to Delete", "Message", JOptionPane.INFORMATION_MESSAGE);
				
				int selection = JOptionPane.showConfirmDialog(null, "Do you want to delete this row", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(selection == JOptionPane.YES_OPTION)
					model.removeRow(table.getSelectedRow());
			}
		});
		
		c.validate();	// used to perform relayout
	}


	public static void main(String[] args) {
		new basic_table();
	}
}
