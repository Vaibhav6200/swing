package classPrograms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class newFrame extends JFrame implements ActionListener{
	Container c;
	JLabel num1, num2, result;
	JButton add, sub, mult, div;
	JTextField text1, text2;
	newFrame(){
		c = this.getContentPane();
		c.setLayout(null);
		
		num1 = new JLabel("First Number: ");
		num2 = new JLabel("Second Number: ");
		result = new JLabel("Result: ");
		text1 = new JTextField();
		text2 = new JTextField();
		add = new JButton("+");
		sub = new JButton("-");
		mult = new JButton("*");
		div = new JButton("/");
		
		
		num1.setBounds(20, 10, 100, 20);
		num2.setBounds(20, 30, 100, 20);
		
		text1.setBounds(130, 10, 150, 20);
		text2.setBounds(130, 30, 150, 20);
		
		add.setBounds(50, 60, 50, 20);
		sub.setBounds(110, 60, 50, 20);
		mult.setBounds(170, 60, 50, 20);
		div.setBounds(230, 60, 50, 20);
		
		result.setBounds(20, 100, 300, 20);
		
		
		add.addActionListener(this);
		sub.addActionListener(this);
		mult.addActionListener(this);
		div.addActionListener(this);
		
		
		c.add(num1); c.add(num2); c.add(text1); c.add(text2); c.add(add); c.add(sub); c.add(mult); c.add(div); c.add(result); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == add) {
				int x = Integer.parseInt(text1.getText());
				int y = Integer.parseInt(text2.getText());
				
				result.setText("Result: " + (x+y));
			}
			else if(e.getSource() == sub) {
				int x = Integer.parseInt(text1.getText());
				int y = Integer.parseInt(text2.getText());
				
				result.setText("Result: " + (x-y));			
			}
			else if(e.getSource() == mult) {
				int x = Integer.parseInt(text1.getText());
				int y = Integer.parseInt(text2.getText());
				
				result.setText("Result: " + (x*y));			
			}
			else if(e.getSource() == div) {
				int x = Integer.parseInt(text1.getText());
				int y = Integer.parseInt(text2.getText());
				
				result.setText("Result: " + ((float)x/y));			
			}
		}
		catch(NumberFormatException ex) {
			result.setText("Result: Please Enter Numbers Only");
		}
		catch(ArithmeticException ar) {
			result.setText("Result: Cannot Divide by 0");
		}

	}
}

public class calculator {
	public static void main(String[] args) {
		newFrame frame = new newFrame();
		frame.setBounds(200, 150, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
