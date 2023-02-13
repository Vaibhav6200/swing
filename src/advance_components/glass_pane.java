package advance_components;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class glass_pane {
	JFrame f;
	JPanel panel;
	JButton btn, show, hide;
	
	glass_pane(){
		f = new JFrame();
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		btn = new JButton("Show Text");
		show = new JButton("Show");
		panel.add(btn);
		panel.add(show);
		
		Container glasspane = (Container) f.getGlassPane();
		
		
		f.add(panel);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new glass_pane();
	}
}
