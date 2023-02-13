package classPrograms;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.util.Vector;
import java.awt.*;
import java.awt.event.*;


public class Group_Students_LMS extends MouseAdapter implements ActionListener{
	
//	Variable Declarations
	JFrame frame1, frame2;
	JButton btn, done, add, remove;
	JPanel panel1, panel2, p1, p2, p3, p4, p5;
	JTable group_table, students_table;
	DefaultTableModel group_model, student_model;
	JList groups, students, availableStudents;
	DefaultListModel groupModel, studentModel, availableStudentsModel;
	JSplitPane splitPaneF1, splitPaneF2;
	int group_id, student_id;
	
//	Default Constructor
	Group_Students_LMS(){
		
//		CREATE OUR OWN DATABASE

		String[] column1 = {"Group ID", "Group Name", "Student ID"};
		String[] column2 = {"Student ID", "Name", "Selected"};
		
//		Create JList Default Data
		Object[][] group_data = {{101, "D-Batch", 308}, {102, "D-Batch", 317}, {103, "D-Batch", 167}, {104, "D-Batch", 293}};
		Object[][] student_data = {{308, "Vaibhav", false}, {317, "Vini", false}, {167, "Mukund", false}, {293, "Aneri", false}, {315, "Vedant", false}, {312, "Utsav", false}};
		
		group_model = new DefaultTableModel(group_data, column1);
		student_model = new DefaultTableModel(student_data, column2);
		group_table = new JTable(group_model);
		students_table = new JTable(student_model);
		
		setFrame1UI();
	}

	
	public void mouseClicked(MouseEvent e) {
		JList list = (JList)e.getSource();
		if(e.getClickCount() == 2) {
			int index = list.locationToIndex(e.getPoint());
			System.out.println(index);
		}
	}
	
//	ACTION LISTENERS
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn) {
			if(groups.isSelectionEmpty())
				JOptionPane.showMessageDialog(frame1, "Select a Group First", "Error", JOptionPane.ERROR_MESSAGE);
			
			else {
				group_id = groups.getSelectedIndex();

				frame1.dispose();
				
//				Fetch Available Students Data from Students Model (Database)
				Vector data = student_model.getDataVector();
				
//				Create a list in which we can display available student in frame2
				availableStudentsModel = new DefaultListModel();				
				for(int i=0; i<data.size(); i++) {
					Vector temp = (Vector) data.get(i);
					String name = (String) temp.get(1);			// fetch name
					availableStudentsModel.addElement(name);
				}
				availableStudents = new JList(availableStudentsModel);
				
				setFrame2UI();
				
			}
		}
		
		else if(e.getSource() == done) {
			frame2.dispose();
			frame1.setVisible(true);
		}
		
		else if(e.getSource() == add) {
			if(availableStudents.isSelectionEmpty())
				JOptionPane.showMessageDialog(frame1, "Select a Student to Add", "Error", JOptionPane.ERROR_MESSAGE);
			else {
				student_id = availableStudents.getSelectedIndex();
//				Add this selected Student in our Group
			}
		}
		
		else if(e.getSource() == remove) {
			if(availableStudents.isSelectionEmpty())
				JOptionPane.showMessageDialog(frame1, "First Select a Student to Remove", "Error", JOptionPane.ERROR_MESSAGE);
			else {
				student_id = availableStudents.getSelectedIndex();
				
			}
		}
	}

	
	
	
	
	
	
//	UI of FRAME 1
	private void setFrame1UI() {
		frame1 = new JFrame();
		frame1.setTitle("Group Add");
		frame1.setSize(700, 500);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLocationRelativeTo(null);
		
		panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		
//		Create List Model to display on split Pane
		groupModel = new DefaultListModel();
		studentModel = new DefaultListModel();
		
//		Initialize Items in our list model
		groupModel.addElement("Group A");
		groupModel.addElement("Group B");
		groupModel.addElement("Group C");
		groupModel.addElement("Group D");
		
		
//		Create our List with default list model
		groups = new JList(groupModel);
		groups.addMouseListener(this);		// Mouse Listener
		
		students = new JList(studentModel);
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) groups.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.add(new JScrollPane(groups));
		
		p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(new JScrollPane(students));
		
		splitPaneF1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);
		splitPaneF1.setDividerLocation(150);
		
		btn = new JButton("Add or Remove Students");
		btn.addActionListener(this);

		
		panel1.add(splitPaneF1, BorderLayout.CENTER);
		panel1.add(btn, BorderLayout.PAGE_END);
		
		frame1.add(panel1);
		frame1.setVisible(true);
	}
	
	
//	UI of FRAME 2
	private void setFrame2UI() {
		frame2 = new JFrame();
		frame2.setTitle("Edit Panel");
		frame2.setSize(700, 500);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setLocationRelativeTo(null);
	
		panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		p3 = new JPanel();
		p3.setLayout(new BorderLayout());
		p3.add(availableStudents);
		
		p4 = new JPanel();
		splitPaneF2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p3, p4);
		splitPaneF2.setDividerLocation(200);
		
		p5 = new JPanel();
		p5.setLayout(new GridLayout(1, 3));
		add = new JButton("Add");
		remove = new JButton("Remove");
		done = new JButton("Done");
		p5.add(add);
		p5.add(remove);
		p5.add(done);
		
		add.addActionListener(this);
		remove.addActionListener(this);
		done.addActionListener(this);
		
		panel2.add(splitPaneF2, BorderLayout.CENTER);
		panel2.add(p5, BorderLayout.PAGE_END);
		frame2.add(panel2);	
		
		frame2.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Group_Students_LMS();
	}
}
