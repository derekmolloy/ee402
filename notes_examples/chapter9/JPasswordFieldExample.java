/** Java Swing Examples - Written by Derek Molloy, Dublin City University, Ireland
 *  see: http://ee402.eeng.dcu.ie/ 
 */

package ee402;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

@SuppressWarnings("serial")
public class JPasswordFieldExample extends JFrame implements ActionListener {	
	JLabel l1 = new JLabel("This is a Test Swing Application");
	JButton b1, b2;
	JPasswordField pwd;
	
	public JPasswordFieldExample()
	{
		super("JPassword Field Example");

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBorder(new TitledBorder("Enter Your Password:"));

		pwd = new JPasswordField(20);
		pwd.addActionListener(this);
	
		p.add(pwd);
		this.getContentPane().add(p);

		this.pack();	// set the size automatically
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(pwd))
		{
			char[] thePassword = pwd.getPassword();
			String s = new String(thePassword);
			System.out.println("Password is " + s);
		}
	}
	
	public static void main(String[] args)
	{
		new JPasswordFieldExample();
	}
}
