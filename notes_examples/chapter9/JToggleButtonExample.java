/** Java Swing Examples - Written by Derek Molloy, Dublin City University, Ireland
 *  see: http://ee402.eeng.dcu.ie/ 
 */
package ee402;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class JToggleButtonExample extends JFrame implements ActionListener
{	
	JToggleButton toggleButton;
	JTextField theTextField;
	
	public JToggleButtonExample() {
		super("JToggleButton Example");

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
		p.setBorder(new TitledBorder("Toggle Buttons:"));

		toggleButton = new JToggleButton("A Toggle Button");
		toggleButton.addActionListener(this);
		
		theTextField = new JTextField(10);
	
		p.add(toggleButton);
		p.add(theTextField);
		this.getContentPane().add(p);

		this.pack();	 
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(toggleButton)) {
		  theTextField.setText("State: " + toggleButton.isSelected());			
		}
	}
	
	public static void main(String[] args) {
		new JToggleButtonExample();
	}
}
