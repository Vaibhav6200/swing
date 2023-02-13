package advance_components;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class editor_pane {
	JFrame f;
	JEditorPane pane;
	JButton btn;
	
	editor_pane(){
		f = new JFrame();
		f.setTitle("Main Frame");
		f.setBounds(200, 150, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = f.getContentPane();
		
		pane = new JEditorPane();
//		TYPE 1 Editor (Plain Editor)
//		pane.setContentType("text/plain");
//		pane.setText("Swing has about four times the number of User Interface [UI] components as AWT and is part of the standard Java distribution. By today’s application GUI requirements, AWT is a limited implementation, not quite capable of providing the components required for developing complex GUI’s required in modern commercial applications. The AWT component set has quite a few bugs and really does take up a lot of system resources when compared to equivalent Swing resources. Netscape introduced its Internet Foundation Classes [IFC] library for use with Java. Its Classes became very popular with programmers creating GUI’s for commercial applications.");
		
//		TYPE 2 Editor (HTML Editor)
		String str = "<html>"
				+ "<h1 color='red'>Welcome to HTML Code Editor </h1>"
				+ "<ol>"
				+ "<li>Item1</li>"
				+ "<li>Item2</li>"
				+ "<li>Item3</li>"
				+ "</ol>"
				+ "</html>";
		pane.setContentType("text/html");
		pane.setText(str);
		
		btn = new JButton("Show Code");
		
		c.add(pane, BorderLayout.CENTER);
		c.add(btn, BorderLayout.PAGE_END);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(pane.getText());
			}
		});
		
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new editor_pane();
	}
}
