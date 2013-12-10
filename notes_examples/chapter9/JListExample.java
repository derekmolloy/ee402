package ee402;

import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class JListExample extends JFrame implements ListSelectionListener {	
	JList<String> myJList;

	public JListExample() {
		super("JList Example");
	
		String[] data = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		
		myJList = new JList<String>(data);
		myJList.addListSelectionListener(this);

		JScrollPane p = new JScrollPane(this.myJList,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		this.getContentPane().add("Center", p); 	 

		this.pack(); 
		this.setVisible(true);
	}

	public void valueChanged(ListSelectionEvent e) {
		JOptionPane.showMessageDialog(this, "You selected : " + myJList.getSelectedValue(), 
			"Selection", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void main(String[] args) {
		new JListExample();
	}
}

