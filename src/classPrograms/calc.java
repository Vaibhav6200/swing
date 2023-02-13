package classPrograms;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;


public class calc implements ActionListener{
	JFrame f;
	JButton clear, backspace, percentage, divide, mult, sub, add, equal, dot, one, two, three, four, five, six, seven, eight, nine, zero;
	JTextField input;
	JPanel panel;
	GridBagConstraints c;
	
	calc(){
		f = new JFrame();
		f.setTitle("Calculator");
		f.setSize(400, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		clear = new JButton("AC");
		backspace = new JButton("<-");
		percentage = new JButton("%");
		divide = new JButton("/");
		mult = new JButton("*");
		sub = new JButton("-");
		add = new JButton("+");
		equal = new JButton("=");
		dot = new JButton(".");
		
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		
		designCalc();
		
		Font font = new Font("verdana", Font.PLAIN, 30);
		input = new JTextField();
		input.setFont(font);
		
		f.add(input, BorderLayout.PAGE_START);
		f.add(panel, BorderLayout.CENTER);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add) {
			String display = input.getText();
			input.setText(display + "+");
		}
		else if(e.getSource() == sub) {		
			String display = input.getText();
			input.setText(display + "-");
		}
		
		else if(e.getSource() == mult) {
			String display = input.getText();
			input.setText(display + "*");
		}
		
		else if(e.getSource() == divide) {	
			String display = input.getText();
			input.setText(display + "/");
		}
		
		if(e.getSource() == one || e.getSource() == two || e.getSource() == three || e.getSource() == four || e.getSource() == five || e.getSource() == six || e.getSource() == seven || e.getSource() == eight || e.getSource() == nine || e.getSource() == zero) {
			String display = input.getText();
			input.setText(display + e.getActionCommand());
		}
		
		if(e.getSource() == equal) {
			String expression = input.getText();
			int n = expression.length();
			
			Stack st = new Stack();
			
			for(int i=0; i<n; i++) {
				String x="";
				char ch = expression.charAt(i);
				if(ch>='0' && ch<='9')
					x += ch;
			}
		}
	}
	
	private void designCalc() {
		c.gridx = 0; c.gridy = 0;
		panel.add(clear, c);
		c.gridx = 1; c.gridy = 0;
		panel.add(backspace, c);
		c.gridx = 2; c.gridy = 0;
		panel.add(percentage, c);
		c.gridx = 3; c.gridy = 0;
		panel.add(divide, c);
		c.gridx = 0; c.gridy = 1;
		panel.add(seven, c);
		c.gridx = 1; c.gridy = 1;
		panel.add(eight, c);
		c.gridx = 2; c.gridy = 1;
		panel.add(nine, c);
		c.gridx = 3; c.gridy = 1;
		panel.add(mult, c);
		c.gridx = 0; c.gridy = 2;
		panel.add(four, c);
		c.gridx = 1; c.gridy = 2;
		panel.add(five, c);
		c.gridx = 2; c.gridy = 2;
		panel.add(six, c);
		c.gridx = 3; c.gridy = 2;
		panel.add(sub, c);
		c.gridx = 0; c.gridy = 3;
		panel.add(one, c);
		c.gridx = 1; c.gridy = 3;
		panel.add(two, c);
		c.gridx = 2; c.gridy = 3;
		panel.add(three, c);
		c.gridx = 3; c.gridy = 3;
		panel.add(add, c);
		c.gridx = 0; c.gridy = 4;
		c.gridwidth = 2;
		panel.add(zero, c);
		c.gridx = 2; c.gridy = 4;
		c.gridwidth = 1;		// reset Grid width back to 1
		panel.add(dot, c);
		c.gridx = 3; c.gridy = 4;
		panel.add(equal, c);
		
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		zero.addActionListener(this);
		
		clear.addActionListener(this);
		backspace.addActionListener(this);
		percentage.addActionListener(this);
		divide.addActionListener(this);
		mult.addActionListener(this);
		sub.addActionListener(this);
		add.addActionListener(this);
		equal.addActionListener(this);
		dot.addActionListener(this);
	}
		
//	5 + 6*2/3 - 1
	private static int precedence(char ch) {
		if(ch == '*' || ch == '/')
			return 2;
		if(ch == '+' || ch == '-')
			return 1;
		
		return 0;
	}
	
	private static double performOperation(double p, double q, char operation) {
		if(operation == '+')
			return p + q;
		
		else if(operation == '-')
			return p - q;
		
		else if(operation == '*')
			return p * q;
		
		else if(operation == '/')
			return p / q;
		
		return 0;
	}
	
	private static double infix(String exp) {
		try {
			Stack<Character> operator = new Stack<Character>();
			Stack<Double> operand = new Stack<Double>();
			
			int n = exp.length();
			String temp="";
			for(int i=0; i<n; i++) {
				char ch = exp.charAt(i);
				if(ch >= '0' && ch <= '9')
					temp += ch;
				else {
					double x = (double) Integer.parseInt(temp);
					operand.push(x);
					temp = "";
					
					if(operator.empty()) {
						operator.push(ch);
						break;
					}
					else {
						char top = operator.peek();
						while(precedence(top) >= precedence(ch)) {
							operator.pop();
							double p = operand.peek();
							operand.pop();
							double q = operand.peek();
							operand.pop();
							
							double result = performOperation(p, q, top);
							operand.push(result);
						}
						operator.push(ch);
					}
				}	
			}
			
			while(!operator.empty()) {
				double p = operand.peek();
				operand.pop();
				double q = operand.peek();
				operand.pop();
				
				char ch = operator.peek();
				operator.pop();
				
				double result = performOperation(p, q, ch);
				operand.push(result);
			}
			
			return operand.peek();
		}
		catch(Exception e) {
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
//		new calc();
		String expression = "5+6*2/3-1";
		double ans = infix(expression);
		System.out.println(ans);
	}
}
