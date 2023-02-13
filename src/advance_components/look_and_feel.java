package advance_components;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class look_and_feel {
	JFrame f;
	JTextField username, password;
	JLabel user, pass;
	JButton clear, login;
	JPanel panel;
	
	look_and_feel(){
		f = new JFrame();
		f.setSize(300, 200);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		username = new JTextField();
		password = new JTextField();
		username.setColumns(20);
		password.setColumns(20);
		user = new JLabel("Username: ");
		pass = new JLabel("Password: ");
		clear = new JButton("Clear");
		login = new JButton("Login");
		
		panel = new JPanel();
		panel.add(user);
		panel.add(username);
		panel.add(pass);
		panel.add(password);
		panel.add(clear);
		panel.add(login);
		
		f.add(panel);
		f.setVisible(true);
	}
	
	public static void main(String[] args) throws Exception{
//		String path = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
//		String path = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
//		String path = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
//		String path = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
		
// 		JTattoo Library Look and feels		
//		String path = "com.jtattoo.plaf.texture.TextureLookAndFeel";
//		String path = "com.jtattoo.plaf.smart.SmartLookAndFeel";
//		String path = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
//		String path = "com.jtattoo.plaf.aero.AeroLookAndFeel";
//		String path = "com.jtattoo.plaf.aluminimum.AluminiumLookAndFeel";
//		String path = "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";
//		String path = "com.jtattoo.plaf.fast.FastLookAndFeel";
//		String path = "com.jtattoo.plaf.graphite.GraphiteLookAndFeel";		
//		String path = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
		String path = "com.jtattoo.plaf.luna.LunaLookAndFeel";
//		String path = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
//		String path = "com.jtattoo.plaf.mint.MintLookAndFeel";
		UIManager.setLookAndFeel(path);
		
		new look_and_feel();
	}
}
