package ee402;

import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class JTableExample2 extends JFrame implements ListSelectionListener
{	
	JTable myTable;

	public JTableExample2()	{
		super("JTable Example");

		String[] columnNames = {"Name", "ID Number", "Class"};		
		String[][] data = {{"John Doe", "91234567", "EE1" },
				   {"Jane Doe", "91234568", "ME1" },
				   {"James Doe", "91234569", "GDE1" }};
		
		myTable = new JTable(data, columnNames);
		myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ListSelectionModel selectModel = myTable.getSelectionModel();
		selectModel.addListSelectionListener(this);

		JScrollPane p = new JScrollPane(this.myTable,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.getContentPane().add("Center", p); 	 

		this.pack(); 
		this.setVisible(true);	 
	}
	
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		int selectedRow = lsm.getMinSelectionIndex();		
		JOptionPane.showMessageDialog(this, "You selected the " + selectedRow + " row.", 
			"Selection", JOptionPane.INFORMATION_MESSAGE);

	}

	public static void main(String[] args) {
		new JTableExample2();
	}
}

