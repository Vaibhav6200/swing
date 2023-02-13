package advance_components;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;


public class spinner implements ChangeListener{
	JFrame f;
	JSpinner s1, s2, s3;
	SpinnerModel model1, model2, model3;
	JLabel label;
	
	spinner(){
		f = new JFrame();
		f.setBounds(200, 150, 700, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		Container c = f.getContentPane();
		c.setLayout(null);
		
		
		String[] months = {"January", "February", "March" , "April" , "May" , "June" , "July" , "August" , "September" , "October" , "November", "December"};
		
		String year = String.valueOf(java.time.Year.now());
		int currYear = Integer.parseInt(year);		// conversion = Yearobject -> String -> Integer
		
		model1 = new SpinnerNumberModel(1, 1, 31, 1);	// {value, min_value, max_value, step_size}
		model2 = new SpinnerListModel(months);
		model3 = new SpinnerNumberModel(currYear, currYear-100, currYear, 1);
		
		s1 = new JSpinner(model1);
		s2 = new JSpinner(model2);
		s3 = new JSpinner(model3);
		
		s1.setBounds(100, 50, 100, 20);
		s2.setBounds(100, 100, 100, 20);
		s3.setBounds(100, 150, 100, 20);
		
		s1.addChangeListener(this);
		s2.addChangeListener(this);
		s3.addChangeListener(this);
		
		label = new JLabel("Date : ");
		label.setBounds(100, 200, 200, 20);
		
		
		c.add(s1); c.add(s2); c.add(s3); c.add(label);
		
		
		c.validate();
	}
	
	public void addDOB() {
		int day = (Integer)s1.getValue();
		String month = (String)s2.getValue();
		int year = (Integer)s3.getValue();
		label.setText("Date : " + day + "-" + month + "-" + year);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		addDOB();
	}
	
	public static void main(String[] args) {
		new spinner();
	}
}
