package Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class myFrame extends JFrame implements ActionListener{
	Container c;
	JButton btn1, btn2, btn3;
	myFrame(){
		c = this.getContentPane();
		c.setLayout(null);
		
		btn1 = new JButton("Red");
		btn2 = new JButton("Yellow");
		btn3 = new JButton("Green");
		
		btn1.setBounds(100, 100, 100, 50);
		btn2.setBounds(250, 100, 100, 50);
		btn3.setBounds(400, 100, 100, 50);
		c.add(btn1); c.add(btn2); c.add(btn3);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) 
			c.setBackground(Color.RED);
		else if(e.getSource() == btn2)
			c.setBackground(Color.YELLOW);
		else if(e.getSource() == btn3)
			c.setBackground(Color.GREEN);
	}
};

public class handleMultipleButton {
	public static void main(String[] args) {
		myFrame frame = new myFrame();
		frame.setBounds(200, 150, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
