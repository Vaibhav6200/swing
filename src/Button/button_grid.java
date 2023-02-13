package Button;

import java.awt.*;    
import javax.swing.*; 


public class button_grid {
	JFrame f;    
	button_grid(){    
	    f=new JFrame();    
	    f.setBounds(200, 150, 600,600);   
	    
	    Container c = f.getContentPane();
	    c.setLayout(null);
	    
	    JPanel panel = new JPanel();
	    panel.setSize(300, 300);    
	    
	    JButton b1=new JButton("1");    
	    JButton b2=new JButton("2");    
	    JButton b3=new JButton("3");    
	    JButton b4=new JButton("4");    
	    JButton b5=new JButton("5");    
	    JButton b6=new JButton("6");    
	    JButton b7=new JButton("7");    
	    JButton b8=new JButton("8");    
	    JButton b9=new JButton("9");    
	    
	     // adding buttons to the frame       
	    panel.add(b1); panel.add(b2); panel.add(b3);  
	    panel.add(b4); panel.add(b5); panel.add(b6);  
	    panel.add(b7); panel.add(b8); panel.add(b9);    
	  
	    f.add(panel);
	    
	    // setting grid layout of 3 rows and 3 columns    
	    panel.setLayout(new GridLayout(3,3));    
	    
	    
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);    
	}    
	
	public static void main(String[] args) {    
	    new button_grid();    
	}    
}       