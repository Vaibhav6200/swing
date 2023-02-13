package Layout;

import java.awt.*;    
import javax.swing.*; 


public class grid_bag_layout{
	public static void main(String[] args) {    
	    JFrame f = new JFrame();
	    f.setBounds(100, 200, 500, 300);   
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);    
	    Container c = f.getContentPane();
	    c.setLayout(null);
	    
	    JButton b1 = new JButton("button 1");
	    JButton b2 = new JButton("button 2");
	    JButton b3 = new JButton("button 3");
	    JButton b4 = new JButton("button 4");
	    JButton b5 = new JButton("button 5");
	    
	    
	    GridBagLayout grid = new GridBagLayout();
	    c.setLayout(grid);
	   
	    GridBagConstraints gbc = new GridBagConstraints(); 
	    
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.weightx = 0.1;
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    c.add(b1, gbc);

//	    gbc.weightx = 0;	// reset
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    c.add(b2, gbc);
	    
	    gbc.gridx = 2;
	    gbc.gridy = 0;
	    c.add(b3, gbc);
	    
	    gbc.gridwidth = 3; 		// now it will span 3 columns
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.ipady = 10;
	    c.add(b4, gbc);
	    
	    gbc.gridwidth = 2;
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    gbc.ipady = 0;
	    gbc.weighty = 1;
	    gbc.anchor = GridBagConstraints.PAGE_END;
	    c.add(b5, gbc);
	    
	    
	    f.pack();
	}    
}       