package Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class jButton_event {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(200, 150, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.setLayout(null);
		
		JButton btn = new JButton("Click Me");
		btn.setBounds(100, 100, 100, 50);
		c.add(btn);

//		Note in addActionListener we have to pass the class jisne action listener ko implement kiya ho 
//		Instead of creating a class which implements ActionListener we can use Anonymous Inner Class
		btn.addActionListener(new ActionListener() {
			
			boolean flag = true;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(flag)
					c.setBackground(Color.RED);
				else
					c.setBackground(Color.YELLOW);
				flag = !flag;
			}
		});
	}
}
