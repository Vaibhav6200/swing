package advance_components;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class welcome_screen_using_jwindow {
	JFrame f;
	JWindow window;
	Timer timer;
	
	welcome_screen_using_jwindow(){
//		First Show Welcome Screen
		showWelcomeScreen();
		
		f = new JFrame();
		f.setSize(600, 400);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.add(new JLabel("This is Main Frame"));
				
		f.add(panel);
//		f.setVisible(true);
	}
	
	private void showWelcomeScreen() {
		window = new JWindow(f);
		window.setSize(600, 400);
		window.setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setLayout(new BorderLayout());
		
		String iconPath = System.getProperty("user.dir") + "\\src\\advance_components\\loading.jpg";
		
		JLabel icon = new JLabel(new ImageIcon(iconPath), SwingConstants.CENTER);
		
		JProgressBar progress = new JProgressBar(0, 100);
		progress.setForeground(Color.DARK_GRAY);
		
		panel.add(icon, BorderLayout.CENTER);
		panel.add(progress, BorderLayout.PAGE_END);
		
//		After every 100 ms Timer class will call this action listener
		timer = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = progress.getValue();
				if(x == 100) {
					window.dispose();
					f.setVisible(true);
					timer.stop();
				}
				else
					progress.setValue(x+4);
			}
		});
		
		timer.start();
		
		window.add(panel);
		window.setVisible(true);
	}
	

	public static void main(String[] args) {
		new welcome_screen_using_jwindow();
	}
}
