//create a jframe containing 2 text fields 3 labels 1 button and 1 checkBox 
//name of checkbox show position of mismatch
//name of button is compare
//name of first label is First File
//name of second label is second file

package classPrograms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;


public class feb_6 implements ActionListener, ItemListener{
	JFrame f;
	JTextField input1, input2;
	JLabel label1, label2, label3, label4;
	JButton compare;
	JCheckBox check;
	JPanel panel;
	int position=-1;
	
	feb_6(){
		f = new JFrame();
		f.setSize(350, 250);
		f.setTitle("Program");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		
		panel = new JPanel();
		input1 = new JTextField();
		input1.setColumns(20);
		input2 = new JTextField();
		input2.setColumns(20);
		label1 = new JLabel("First File: ");
		label2 = new JLabel("Second File: ");
		label3 = new JLabel();
		label4 = new JLabel();
		compare = new JButton("Compare");
		check = new JCheckBox("Show Position of Missmatch: ");
		
		panel.add(label1);
		panel.add(input1);
		panel.add(label2);
		panel.add(input2);
		panel.add(compare);
		panel.add(check);
		panel.add(label3);
		panel.add(label4);
		
		check.addItemListener(this);
		compare.addActionListener(this);
		
		f.add(panel);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		String text1 = input1.getText();
		String text2 = input2.getText();
		
		if(text1.length() == 0 || text2.length() == 0)
			JOptionPane.showMessageDialog(f, "Input File Name", "Error", JOptionPane.ERROR_MESSAGE);
		
		else {
			String path = "C:\\Users\\Vaibhav\\Desktop\\Swing\\Implementation\\ClassProgramms\\src\\classroom\\";
			String path1= path + text1 + ".txt";
			String path2= path + text2 + ".txt";
	        File file1 = new File(path1);
	        File file2 = new File(path2);
	        
	        int count = 0;
	        
	        try {
				Scanner sc1 = new Scanner(file1);
				Scanner sc2 = new Scanner(file2);
				
//				Straight Content of File1
				String line1="";
				while(sc1.hasNextLine())
					line1 += sc1.nextLine() + " ";

//				Straight Content of File2
				String line2="";
				while(sc2.hasNextLine())
					line2 += sc2.nextLine();
				
//				Trim White Spaces
				line1 = line1.trim();
				line2 = line2.trim();
				
//				Comparing both FILES
				int i;
				int n1 = line1.length();
				int n2 = line2.length();
				int n = Math.min(n1, n2);
				for(i=0; i<n; i++) {
					if(line1.charAt(i) != line2.charAt(i)) {
						position = i;
						break;
					}
				}
				
				if(position == -1) {
					if(n1 == n2)
						label3.setText("Files Match !!!");
					else {
						label3.setText(text1 + " and " + text2 + " do not Match");
						position = n;
					}
				}
				else {
					label3.setText(text1 + " and " + text2 + " do not Match");					
				}
				System.out.println(line1);
				System.out.println(line2);
				System.out.println(position);

				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if(check.isSelected())
			label4.setText("Miss Match Position: " + position);
		else
			label4.setText(null);
	}
	
	public static void main(String[] args) {
		new feb_6();
	}
}
