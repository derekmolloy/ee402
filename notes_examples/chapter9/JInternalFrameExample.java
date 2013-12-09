/** Java Swing Examples - Written by Derek Molloy, Dublin City University, Ireland
 *  see: http://ee402.eeng.dcu.ie/ 
 */
package ee402;

import javax.swing.*;
import java.awt.*; 
import java.net.URL;

@SuppressWarnings("serial")
public class JInternalFrameExample extends JFrame
{	
	public JInternalFrameExample() {
		super("JInternalFrame Example");
		JDesktopPane desktop = new JDesktopPane();		

		this.getContentPane().add("North", new JLabel("A Regular JLabel"));
		this.getContentPane().add("Center", desktop);

		JInternalFrame internal1 = new JInternalFrame("Frame 1", true, true, true, true);
		internal1.setSize(300,300);
		internal1.show();
		
		URL imageURL = this.getClass().getResource("test.jpg"); 
		Image testImage = this.getToolkit().getImage(imageURL);
		internal1.getContentPane().add(new JScrollPane(new JLabel(new ImageIcon(testImage))));
		internal1.setLocation(50,50);
		desktop.add(internal1);

		this.setSize(400,400);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JInternalFrameExample();
	}
}
