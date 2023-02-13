package advance_components;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class j_dialog implements ActionListener{
	JFrame f;
	JDialog dialog1, dialog2;
	JButton btn1, btn2;
	
	j_dialog(){
		f = new JFrame();
		f.setTitle("JFrame");
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		btn1 = new JButton("Button 1");
		panel.add(btn1);
		
		btn1.addActionListener(this);
				
		f.add(panel);
		
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Button 1")) {
			dialog1 = new JDialog(f, "Dialog 1");		// {Owner, Title}
			dialog1.setVisible(true);
			dialog1.setBounds(250, 200, 200, 200);
			dialog1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog1.setLayout(new FlowLayout());
			
			btn2 = new JButton("Button 2");
			btn2.addActionListener(this);
			
			dialog1.add(btn2);
		}
		
		if(e.getActionCommand().equals("Button 2")) {
			dialog2 = new JDialog(dialog1, "Dialog 2");
			dialog2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog2.setVisible(true);
			dialog2.setBounds(350, 250, 250, 150);
			dialog2.setLayout(new FlowLayout());
			
			dialog2.add(new JLabel("This is Dialog 2"));
		}
	}
	
	public static void main(String[] args) {
		new j_dialog();
	}
}
