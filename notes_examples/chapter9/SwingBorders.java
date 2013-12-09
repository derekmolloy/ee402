/** Java Swing Examples - Written by Derek Molloy, Dublin City University, Ireland
 *  see: http://ee402.eeng.dcu.ie/ 
 */
package ee402;

import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.border.*;
import java.awt.Color;

@SuppressWarnings("serial")
public class SwingBorders extends JFrame implements ActionListener {

	private JButton button1, button2;
	private JTextField status;
	
	public SwingBorders() {
	  super("Simple Borders Example");
  
	  URL iconLocation = this.getClass().getResource("image.gif"); 
	  System.out.println("Icon is at: " + iconLocation);
	  ImageIcon icon = new ImageIcon(iconLocation, "A running dog icon");
	  
	  this.status = new JTextField(20);
	  this.status.setBorder(new EmptyBorder(10,10,10,10));
	  this.button1 = new JButton("Button 1", icon);
	  this.button1.setBorder(new MatteBorder(10,10,10,10,Color.blue));
	  this.button1.setToolTipText("Press this Button to Display Button 1 Information");
	  this.button2 = new JButton("Button 2", icon);
	  this.button2.setBorder(new LineBorder(Color.green, 10, true));
	  this.button2.setToolTipText("Press this Button to Display Button 2 Information");

	  this.button1.addActionListener(this);
	  this.button2.addActionListener(this);

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
	   new SwingBorders();
	}
}
