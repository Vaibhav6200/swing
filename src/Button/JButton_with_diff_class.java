package Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class firstButton implements ActionListener{
	Container c;
	firstButton(Container container){
		c = container;
	}
	
	public void actionPerformed(ActionEvent e) {
		c.setBackground(Color.RED);
	}
}



class secondButton implements ActionListener{
	Container c;
	secondButton(Container container){
		c = container;
	}
	
	public void actionPerformed(ActionEvent e) {
		c.setBackground(Color.YELLOW);
	}
}



class thirdButton implements ActionListener{
	Container c;
	thirdButton(Container container){
		c = container;
	}
	
	public void actionPerformed(ActionEvent e) {
		c.setBackground(Color.GREEN);
	}
}


public class JButton_with_diff_class {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(200, 150, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.setLayout(null);
		
		JButton btn1 = new JButton("Red");
		JButton btn2 = new JButton("Yellow");
		JButton btn3 = new JButton("Green");
		
		btn1.setBounds(100, 100, 100, 50);
		btn2.setBounds(250, 100, 100, 50);
		btn3.setBounds(400, 100, 100, 50);
		c.add(btn1); c.add(btn2); c.add(btn3);
		
		btn1.addActionListener(new firstButton(c));
		btn2.addActionListener(new secondButton(c));
		btn3.addActionListener(new thirdButton(c));
	}
}
