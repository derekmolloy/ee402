package ee402;

import javax.swing.*;

@SuppressWarnings("serial")
public class JTableExample extends JFrame {	
	private JTable myTable;
	
	public JTableExample() {
		super("JTable Example");

		String[] columnNames = {"Name", "ID Number", "Class"};		
		String[][] data = {{"John Doe", "91234567", "EE1" },
				   {"Jane Doe", "91234568", "ME1" },
				   {"James Doe", "91234569", "GDE1" }};
		
		myTable = new JTable(data, columnNames);

		JScrollPane p = new JScrollPane(this.myTable,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.getContentPane().add("Center", p); 	 
		this.pack(); 
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTableExample();
	}
}

