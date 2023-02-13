package advance_components;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.awt.event.*;



public class j_tree {
	JFrame f;
	JTree tree;
	DefaultMutableTreeNode rootNode, A, B, A1, A2, B1, B2, B3;
	
	j_tree(){
		f = new JFrame();
		f.setSize(500, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		rootNode = new DefaultMutableTreeNode();
		A = new DefaultMutableTreeNode("C Drive");
		B = new DefaultMutableTreeNode("D Drive");
		A1 = new DefaultMutableTreeNode("College");
		A2 = new DefaultMutableTreeNode("Projects");
		B1 = new DefaultMutableTreeNode("Development");
		B2 = new DefaultMutableTreeNode("Courses");
		B3 = new DefaultMutableTreeNode("Doc");
		
		A.add(A1);
		A.add(A2);
		B.add(B1);
		B.add(B2);
		B.add(B3);
		rootNode.add(A);
		rootNode.add(B);
		
		tree = new JTree(rootNode);
		
		f.add(tree);
		
		f.setVisible(true);
	}
	
	public static void main(String[] args) throws Exception {
		String path = "com.jtattoo.plaf.fast.FastLookAndFeel";
		UIManager.setLookAndFeel(path);

		
		new j_tree();
	}
}
