package advance_components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class internal_frame {
	JFrame f;
	JInternalFrame iframe;
	
	internal_frame(){
		f = new JFrame();
		f.setTitle("Main Frame");
		f.setBounds(200, 150, 700, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		
		iframe = new JInternalFrame("New Frame", true, true, true, true);
		initNewFrame(iframe);
		f.add(iframe);
		
		
		f.setVisible(true);
	}
	
	private void initNewFrame(JInternalFrame iframe) {
		iframe.setBounds(50, 50, 300, 200);
		iframe.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		iframe.setVisible(true);
		iframe.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Button");
		iframe.add(btn);
		
		iframe.setVisible(true);
	}

	public static void main(String[] args) {
		new internal_frame();
	}
}
