package advance_components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class toggle_button {
	JFrame f;
	JToggleButton toggle;
	
	private Color defaultColor;
	
	toggle_button(){
		f = new JFrame();
		f.setTitle("Toggle Button");
		f.setBounds(200, 150, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = f.getContentPane();
		c.setLayout(null);
		defaultColor = c.getBackground();
		
		toggle = new JToggleButton("OFF");		// by default its OFF
		toggle.setBounds(200, 100, 100, 50);
		c.add(toggle);
		
		toggle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(toggle.isSelected()) {
					c.setBackground(Color.DARK_GRAY);
					toggle.setText("ON");
				}
				else {
					c.setBackground(defaultColor);
					toggle.setText("OFF");					
				}
			}
		});
		
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new toggle_button();
	}
}
