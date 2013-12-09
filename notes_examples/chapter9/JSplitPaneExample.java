/** Java Swing Examples - Written by Derek Molloy, Dublin City University, Ireland
 *  see: http://ee402.eeng.dcu.ie/ 
 */
package ee402;

import java.awt.Image;
import java.net.URL;
import javax.swing.*;

@SuppressWarnings("serial")
public class JSplitPaneExample extends JFrame {	
	
	public JSplitPaneExample() {
		super("JSplitPane Example");

		JScrollPane pane2 = new JScrollPane(new JTextArea("A test text area",20,20)
			, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		URL imageURL = this.getClass().getResource("test.jpg"); 
		Image testImage = this.getToolkit().getImage(imageURL);
		
		JScrollPane pane1 = new JScrollPane(new JLabel(new ImageIcon(testImage))
			, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                         pane1, pane2);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(400);
		
		this.getContentPane().add("Center", splitPane);
		this.setSize(600,400);	// set the size 
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JSplitPaneExample();
	}
}
