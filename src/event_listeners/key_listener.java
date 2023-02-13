package event_listeners;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class key_listener implements KeyListener{
	JTextArea t;
	key_listener(){
		JFrame f = new JFrame();
		f.setTitle("Key Event");
		f.setBounds(100, 100, 430, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = f.getContentPane();
		c.setLayout(null);
		
		t = new JTextArea();
		t.setBounds(5, 5, 400, 350);
		c.add(t);
		
		
		t.addKeyListener(this);
		
		f.setVisible(true);
	}
	
	public void keyPressed(KeyEvent e) {
		t.setText(t.getText() + "Key Pressed : " + e.getKeyChar() + " \n");
	}
	
	public void keyTyped(KeyEvent e) {
		t.setText(t.getText() + "Key Typed \n");
		
	}
	
	public void keyReleased(KeyEvent e) {
		t.setText(t.getText() + "Key Released \n");		
	}
	
	public static void main(String[] args) {
		new key_listener();
	}
}
