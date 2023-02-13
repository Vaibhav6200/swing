package menu_bar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class checkBox_menubar {
	JFrame f;
	JMenuBar menubar;
	JMenu file, edit, format;
	JMenuItem m1, m2, m3, m4, m5;
	JCheckBoxMenuItem checkMenuItem;
	JTextArea textarea;
	
	checkBox_menubar(){
		f = new JFrame();
		f.setTitle("NotePad");
		f.setBounds(200, 150, 600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		Container c = f.getContentPane();
		
		menubar = new JMenuBar();
		
		file = new JMenu("File");
		edit = new JMenu("Edit");
		format = new JMenu("Format");
		
		m1 = new JMenuItem("New");
		m2 = new JMenuItem("Open");
		m3 = new JMenuItem("Save");
		m4 = new JMenuItem("Cut");
		m5 = new JMenuItem("Paste");
		checkMenuItem = new JCheckBoxMenuItem("Word Wrap");
		
		file.add(m1);
		file.add(m2);
		file.add(m3);
		
		edit.add(m4);
		edit.add(m5);
		
		format.add(checkMenuItem);
		menubar.add(file);
		menubar.add(edit);
		menubar.add(format);
		
		
		textarea = new JTextArea("Swing has about four times the number of User Interface [UI] components as AWT and is part of the standard Java distribution. By today’s application GUI requirements, AWT is a limited implementation, not quite capable of providing the components required for developing complex GUI’s required in modern commercial applications. The AWT component set has quite a few bugs and really does take up a lot of system resources when compared to equivalent Swing resources. Netscape introduced its Internet Foundation Classes [IFC] library for use with Java. Its Classes became very popular with programmers creating GUI’s for commercial applications.");
		textarea.setBorder(new EmptyBorder(10, 10, 10, 10));
		c.add(new JScrollPane(textarea), BorderLayout.CENTER);
		c.add(menubar, BorderLayout.PAGE_START);
		
		c.validate();
		
		checkMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkMenuItem.isSelected()) {
					textarea.setLineWrap(true);
					textarea.setWrapStyleWord(true);
				}
				else {					
					textarea.setLineWrap(false);
					textarea.setWrapStyleWord(false);
				}
			}
		});
	}
	
	
	public static void main(String[] args) {
		new checkBox_menubar();
	}
}
