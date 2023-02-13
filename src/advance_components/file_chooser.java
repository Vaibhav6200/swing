package advance_components;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class file_chooser {
	JFrame f;
	
	file_chooser(){
		f = new JFrame();
		f.setSize(500, 300);
		f.setTitle("File Chooser");
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		Container c = f.getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("Open");
		JButton btn2 = new JButton("Save");
		JLabel label = new JLabel("New Window");
		c.add(btn1);
		c.add(btn2);
		
	}
	
	public static void main(String[] args) {
		new file_chooser();
	}

}