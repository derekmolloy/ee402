package ee402;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class CustomComponentApp extends Frame implements ActionListener, WindowListener {

	private Button okay;
	private IntegerTextField intField;
	
	public CustomComponentApp()
	{
	  super("Custom Component");
	  this.setLayout(new FlowLayout());
	  intField = new IntegerTextField(20);

	  this.okay = new Button("Okay");
	  this.okay.addActionListener(this);

	  this.add(intField);
	  this.add(okay);
	  
	  this.pack();
	  this.setVisible(true);
	  this.addWindowListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(okay)){
			this.intField.setText("0");
		}
	}

	public static void main(String[] args) {
		new CustomComponentApp();
	}

	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}
