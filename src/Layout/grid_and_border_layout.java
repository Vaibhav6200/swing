package Layout;

import javax.swing.*;
import java.awt.*;


public class grid_and_border_layout {
	JFrame f;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18;
	
	grid_and_border_layout(){
		f = new JFrame();
		f.setVisible(true);
		f.setBounds(250, 100, 1000, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = f.getContentPane();
		f.setLayout(null);
		f.setLayout(new GridLayout(1,2));
		
		b1 = new JButton("Button 1");
		b2 = new JButton("Button 2");
		b3 = new JButton("Button 3");
		b4 = new JButton("Button 4");
		b5 = new JButton("Button 5");
		b6 = new JButton("Button 6");
		b7 = new JButton("Button 7");
		b8 = new JButton("Button 8");
		b9 = new JButton("Button 9");
		b10 = new JButton("Button 10");
		b11 = new JButton("Button 11");
		b12 = new JButton("Button 12");
		b13 = new JButton("Button 13");
		b14 = new JButton("Button 14");
		b15 = new JButton("Button 15");
		b16 = new JButton("Button 16");
		b17 = new JButton("Button 17");
		b18 = new JButton("Button 18");
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2, 3));
		panel1.add(b1);
		panel1.add(b2);
		panel1.add(b3);
		panel1.add(b4);
		panel1.add(b5);
		panel1.add(b6);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(4,2));
		panel3.add(b11);
		panel3.add(b12);
		panel3.add(b13);
		panel3.add(b14);
		panel3.add(b15);
		panel3.add(b16);
		panel3.add(b17);
		panel3.add(b18);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.add(b7, BorderLayout.PAGE_START);
		panel2.add(b8, BorderLayout.PAGE_END);
		panel2.add(b9, BorderLayout.LINE_END);
		panel2.add(b10, BorderLayout.LINE_START);
		panel2.add(panel3, BorderLayout.CENTER);
		
		
		c.add(panel1); c.add(panel2); 
		c.validate();
	}
	
	public static void main(String[] args) {
		new grid_and_border_layout();
	}
}
