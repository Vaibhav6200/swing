package menu_bar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class create_menubar implements ActionListener{

	JMenuBar menubar;
	JMenu file, edit;
	JMenuItem i1, i2, i3, i4, i5, i6, i7;
	JTextArea t;
	
	create_menubar(){
		JFrame f = new JFrame();
		f.setBounds(200, 150, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = f.getContentPane();
		c.setLayout(null);
		
		
		menubar = new JMenuBar();
		file = new JMenu("File");
		edit = new JMenu("Edit");
		
		i1 = new JMenuItem("New");
		i2 = new JMenuItem("Open");
		i3 = new JMenuItem("Save");
		i4 = new JMenuItem("Cut");
		i5 = new JMenuItem("Copy");
		i6 = new JMenuItem("Paste");
		i7 = new JMenuItem("Select All");
		
		file.add(i1);
		file.add(i2);
		file.add(i3);
		
		edit.add(i4);
		edit.add(i5);
		edit.add(i6);
		edit.add(i7);
		
		menubar.add(file);
		menubar.add(edit);
		
		f.setJMenuBar(menubar);
		
		t = new JTextArea();
		t.setLineWrap(true);
		t.setWrapStyleWord(true);
		t.setBounds(50, 25, 380, 180);
		c.add(t);

		i1.addActionListener(this);
		i2.addActionListener(this);
		i3.addActionListener(this);
		i4.addActionListener(this);
		i5.addActionListener(this);
		i6.addActionListener(this);
		i7.addActionListener(this);
		
		
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == i1)
			t.setText("Button Pressed: New");
			
		else if(e.getSource() == i2)
			t.setText("Button Pressed: Open");
		
		else if(e.getSource() == i3)
			t.setText("Button Pressed: Save");
		
		else if(e.getSource() == i4)
			t.cut();
		
		else if(e.getSource() == i5)
			t.copy();
		
		else if(e.getSource() == i6)
			t.paste();
		
		else if(e.getSource() == i7)
			t.selectAll();
		
	}
	
	public static void main(String[] args) {
		new create_menubar();
	}
}
