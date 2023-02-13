package JList_Examples;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class dynamic_j_list extends MouseAdapter implements ActionListener{
	DefaultListModel model;
	JFrame f;
	JList list;
	JTextField textfield;
	JButton add, update, delete;
	int selectedIndex;
	
	dynamic_j_list(){
		f = new JFrame();
		f.setTitle("JFrame");
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(1, 2));
	
		JPanel panel = new JPanel();
		model = new DefaultListModel();
		model.addElement("Harry");
		model.addElement("Severus");
		model.addElement("Voldemort");
		model.addElement("Hermoine");
		model.addElement("Ron");
		list = new JList(model);
		list.setVisibleRowCount(5);
		JScrollPane scroll = new JScrollPane(list);
		Dimension d = list.getPreferredSize();		// used to specify width of JList
		d.width = 200;
		scroll.setPreferredSize(d);
		panel.add(scroll);
		
		
		JPanel panel2 = new JPanel();
		textfield = new JTextField();
		textfield.setColumns(20);
		add = new JButton("Add");
		update = new JButton("Update");
		delete = new JButton("Delete");
		panel2.add(textfield);
		panel2.add(add);
		panel2.add(update);
		panel2.add(delete);
		
		add.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		list.addMouseListener(this);
		
		f.add(panel);
		f.add(panel2);
		f.setVisible(true);
	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			String value = (String)list.getSelectedValue();
			selectedIndex = list.getSelectedIndex();
			textfield.setText(value);
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Add")) {
			String value = textfield.getText();
			if(value.length() != 0) {
				textfield.setText(null);
				model.addElement(value);
			}
			else 
				JOptionPane.showMessageDialog(f,  "Enter Some Value", "Message", JOptionPane.WARNING_MESSAGE);
		}
		else if(e.getActionCommand().equals("Update")) {
			String newValue = textfield.getText();
			model.setElementAt(newValue, selectedIndex);
			textfield.setText(null);    // after update remove text in textfield
		}
		
		else if(e.getActionCommand().equals("Delete")) {
			int selection = JOptionPane.showConfirmDialog(f, "Are you sure you want to delete this field", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(selection == JOptionPane.YES_OPTION) {
				model.removeElementAt(selectedIndex);
				textfield.setText(null);
			}
		}
	}
	
	public static void main(String[] args) {
		new dynamic_j_list();
	}
}



