/** Java Swing Examples - Written by Derek Molloy, Dublin City University, Ireland
 *  see: http://ee402.eeng.dcu.ie/ 
 */

package ee402;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class SimpleSwingApplication extends JFrame implements ActionListener {

	private JButton button1, button2;
	private JTextField status;
	
	public SimpleSwingApplication() {
	  // call the parent class constructor - sets the frame title
	  super("Simple Swing Example");

	  this.status = new JTextField(20);
	  this.button1 = new JButton("Button 1");
	  this.button2 = new JButton("Button 2");

	  this.button1.addActionListener(this);
	  this.button2.addActionListener(this);

	  // default layout is border layout for Frame/JFrame
	  this.getContentPane().add("North",this.status);
	  this.getContentPane().add("Center",this.button1);
	  this.getContentPane().add("South",this.button2);

	  this.pack();
	  this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
	  if (e.getActionCommand().equals("Button 1")) {
	    this.status.setText("Button 1 Pressed");
	  }
	  else if (e.getActionCommand().equals("Button 2")) {
	    status.setText("Button 2 Pressed");
	  }
	}

	public static void main(String args[]) {
	   new SimpleSwingApplication();
	}
}
