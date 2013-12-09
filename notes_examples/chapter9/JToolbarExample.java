/** Java Swing Examples - Written by Derek Molloy, Dublin City University, Ireland
 *  see: http://ee402.eeng.dcu.ie/ 
 */
package ee402;

import javax.swing.*;
import java.awt.event.*;
import java.net.URL;

@SuppressWarnings("serial")
public class JToolbarExample extends JFrame implements ActionListener
{	
	JToolBar theToolbar;
	JTextArea theTextArea;
	JButton testButton;
	JComboBox<String> comboBox;
	JToggleButton toggleButton;
	
	public JToolbarExample() {
		super("JToolBar Example");

		theToolbar = new JToolBar("My Toolbar");
		theToolbar.setFloatable(true);

		theTextArea = new JTextArea(20,20);
		JScrollPane p = new JScrollPane(this.theTextArea,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		URL iconLocation = this.getClass().getResource("image.gif"); 
		ImageIcon icon = new ImageIcon(iconLocation, "A running dog icon");
		JLabel theLabel = new JLabel(icon);
		theToolbar.add(theLabel);

		testButton = new JButton("Test");
		testButton.addActionListener(this);
		theToolbar.add(testButton);
		
		String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
	  	comboBox = new JComboBox<String>(items);
	  	comboBox.addActionListener(this);
	  	theToolbar.add(comboBox);

		theToolbar.addSeparator();
		
		toggleButton = new JToggleButton("Test Toggle");
		toggleButton.addActionListener(this);
		theToolbar.add(toggleButton);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu firstMenu = new JMenu("First Menu");
		JMenuItem item1 = new JMenuItem("First Item", KeyEvent.VK_F);
		JMenuItem item2 = new JMenuItem("Second Item", KeyEvent.VK_S);
		JMenuItem item3 = new JMenuItem("Third Item", KeyEvent.VK_T);
		JMenuItem item4 = new JMenuItem("Some Item", icon);
		JMenuItem sub1 = new JMenuItem("Sub Menu Item 1");
		JMenuItem sub2 = new JMenuItem("Sub Menu Item 2");
		JMenu aSubMenu = new JMenu("Sub Menu");
		aSubMenu.add(sub1);
		aSubMenu.add(sub2);		

		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		sub1.addActionListener(this);
		sub2.addActionListener(this);

		menuBar.add(firstMenu);
		firstMenu.add(item1);
		firstMenu.add(item2);
		firstMenu.add(item3);
		firstMenu.add(item4);
		firstMenu.add(aSubMenu);

		this.getContentPane().add("North", theToolbar);
		this.getContentPane().add("Center", p); 	 
	
		this.setJMenuBar(menuBar);
		this.pack();	
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(testButton))
			this.theTextArea.append("Test Button Pressed! \n");
		else if (e.getSource().equals(comboBox))
			this.theTextArea.append("Selected Item: " + comboBox.getSelectedItem() + "\n");
		else if (e.getSource().equals(toggleButton))
			this.theTextArea.append("Toggle Item: " + toggleButton.isSelected() + "\n");
		else {
		  this.theTextArea.append("Menu Item \"" + e.getActionCommand() + "\" selected.\n");
		}
	}

	public static void main(String[] args)
	{
		new JToolbarExample();
	}
}