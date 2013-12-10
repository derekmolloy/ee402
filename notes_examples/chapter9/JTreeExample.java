package ee402;

import javax.swing.*;
import javax.swing.tree.*;

@SuppressWarnings("serial")
public class JTreeExample extends JFrame
{	
	JTree myTree;
	
	public JTreeExample() {
		super("JTree Example");

		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Student Tree");
		myTree = new JTree(top);		
		DefaultMutableTreeNode ugNode = new DefaultMutableTreeNode("Undergraduate");
		DefaultMutableTreeNode johnDoe = new DefaultMutableTreeNode(
			new Student("John Doe", "912345676", "EE1"));
		DefaultMutableTreeNode janeDoe = new DefaultMutableTreeNode(
			new Student("Jane Doe", "912345677", "ME1"));
		DefaultMutableTreeNode pgNode = new DefaultMutableTreeNode("Postgraduate");
		DefaultMutableTreeNode jamesDoe = new DefaultMutableTreeNode(
			new Student("James Doe", "912345678", "GDE1"));

		top.add(ugNode);
		ugNode.add(johnDoe);
		ugNode.add(janeDoe);
		top.add(pgNode);
		pgNode.add(jamesDoe);

		JScrollPane p = new JScrollPane(this.myTree,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.getContentPane().add("Center", p); 	 

		this.pack(); 
		this.setVisible(true);	 
	}
	
	public static void main(String[] args) {
		new JTreeExample();
	}
}


class Student 
{
	private String name;
	private String id;
	private String classname;

	Student(String name, String id, String classname) {
		this.name = name;
		this.id = id;
		this.classname = classname;
	}
		
	public String toString() {
		return name;
	}
}