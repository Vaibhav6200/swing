package JList_Examples;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class static_j_list{
	JFrame f;
	JList list;
	
	static_j_list(){
		f = new JFrame();
		f.setTitle("JFrame");
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		
		String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10"};
		list = new JList(items);
		list.setVisibleRowCount(5);
		
		JLabel label = new JLabel();
		
		panel.add(new JScrollPane(list));
		panel.add(label);
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					String value = (String) list.getSelectedValue();
					int index = list.getSelectedIndex();
					
					label.setText("Value : " + value + "  Index : " + index);
				}
			}
		});
		
		f.add(panel);
		f.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new static_j_list();
	}
}
