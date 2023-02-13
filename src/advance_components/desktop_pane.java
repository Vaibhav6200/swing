package advance_components;

import javax.swing.*;
import java.awt.*;

public class desktop_pane {
	JFrame f;
	JDesktopPane dp;
	
	desktop_pane(){
		f = new JFrame();
		f.setTitle("Main Frame");
		f.setBounds(200, 150, 700, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = f.getContentPane();
		
		dp = new JDesktopPane();
		initDisplay(dp);
		c.add(dp);
		
		f.setVisible(true);
	}
	
	private void initDisplay(JDesktopPane dp2) {
		int num_tabs = 3, x = 30, y = 30;
		
		for(int i=0; i<num_tabs; i++) {
			JInternalFrame iframe = new JInternalFrame("Frame " + (i+1), true, true, true, true);
			iframe.setVisible(true);
			iframe.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
			iframe.setBounds(x, y, 250, 100);
			
			dp.add(iframe);
			
			y += 100;
		}
	}

	public static void main(String[] args) {
		new desktop_pane();
	}
}
