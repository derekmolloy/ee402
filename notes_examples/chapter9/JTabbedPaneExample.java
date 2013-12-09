/** Java Swing Examples - Written by Derek Molloy, Dublin City University, Ireland
 *  see: http://ee402.eeng.dcu.ie/ 
 */
package ee402;

import java.net.URL;
import javax.swing.*;

@SuppressWarnings("serial")
public class JTabbedPaneExample extends JFrame
{	
	
	public JTabbedPaneExample() {
		super("JTabbed Pane Example");

		JPanel panel1 = new JPanel();	
		panel1.add(new JScrollPane(new JTextArea("A test text area",20,20)
			, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS));

		JPanel panel2 = new JPanel();
		panel2.add(new JLabel("Test Label"));
		panel2.add(new JButton("Test Button"));	

		URL iconLocation = this.getClass().getResource("image.gif"); 
		ImageIcon icon = new ImageIcon(iconLocation, "A running dog icon");

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Tab One", icon, panel1, "This is The First Tab");
		tabbedPane.addTab("Tab Two", icon, panel2, "This is The Second Tab");

		this.getContentPane().add("Center", tabbedPane);

		this.pack(); 
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JTabbedPaneExample();
	}
}
