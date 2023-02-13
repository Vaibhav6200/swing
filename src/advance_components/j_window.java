package advance_components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class j_window implements ActionListener{
	JFrame f;
	
	j_window(){
		f = new JFrame();
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		JButton btn = new JButton("Click");
		panel.add(btn);
		
		btn.addActionListener(this);
		
		f.add(panel);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		JWindow window = new JWindow(f);
		window.setSize(300, 150);
		window.setLocationRelativeTo(f);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setBackground(Color.yellow);
		panel.add(new JLabel("This is JWindow"));
		
		panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {		// if we double click the window then close it
					window.dispose();
				}
			}
		});
		
		window.add(panel);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		new j_window();
	}
}
