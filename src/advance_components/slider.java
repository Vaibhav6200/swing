package advance_components;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;


public class slider implements ChangeListener{
	JFrame f;
	JSlider slider;
	JLabel label;
	
	slider(){
		f = new JFrame();
		f.setBounds(200, 150, 300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = f.getContentPane();
		c.setLayout(new FlowLayout());
		
		
		slider = new JSlider();
//		slider.setOrientation(JSlider.VERTICAL);
		
		slider.setMinimum(0);
		slider.setMaximum(200);
		slider.setValue(20);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(10);
		
		slider.setPaintTrack(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		slider.addChangeListener(this);
		
		label = new JLabel("The Value Of Slider : ");		
		label.setBounds(100, 100, 100, 20);
		
		c.add(slider); c.add(label);
		f.setVisible(true);
	}
	
	public void stateChanged(ChangeEvent e) {
		String text = String.valueOf(slider.getValue());
		label.setText("The Value Of Slider : " + text);
	}
	
	public static void main(String[] args) {
		new slider();
	}
}
