package advance_components;

import javax.swing.*;

public class basics {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame f = new  JFrame();
				f.setSize(500, 500);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);				
			}
			
		});
	}
}
