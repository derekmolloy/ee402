package ee402;

import javax.swing.*;

import java.awt.*; 
import java.awt.event.*;

import javax.swing.border.*;

@SuppressWarnings("serial")
public class JDialogExample extends JFrame implements ActionListener
{	
	private JButton messageButton, inputButton, confirmButton, optionsButton, 
		myDialogButton, myModelessButton;
	private JTextArea status;

	public JDialogExample()
	{
		super("JDialog Example");

		JPanel predefined = new JPanel();
		predefined.setLayout(new GridLayout(4,1));
		predefined.setBorder(new TitledBorder("Modal JOptionPane examples:"));

		messageButton = new JButton("Message Dialog");
		messageButton.addActionListener(this);
		inputButton = new JButton("Input Dialog");
		inputButton.addActionListener(this);
		confirmButton = new JButton("Confirm Dialog");
		confirmButton.addActionListener(this);
		optionsButton = new JButton("Input Dialog (with Options)");
		optionsButton.addActionListener(this);
			
		predefined.add(messageButton);
		predefined.add(inputButton);
		predefined.add(confirmButton);
		predefined.add(optionsButton);
		
		JPanel customized = new JPanel();
		customized.setLayout(new GridLayout(2,1));
		customized.setBorder(new TitledBorder("Customized Dialog examples:"));

		myDialogButton = new JButton("My Modal Dialog");
		myDialogButton.addActionListener(this);
		customized.add(myDialogButton);
		myModelessButton = new JButton("My Modeless Dialog");
		myModelessButton.addActionListener(this);
		customized.add(myModelessButton);

		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.getContentPane().add(predefined);
		this.getContentPane().add(customized);

		status = new JTextArea("Status area: \n",20,20);
		this.getContentPane().add(new JScrollPane(status));

		this.setSize(260,350); 
		this.setVisible(true); 
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(messageButton))
		{
			JOptionPane.showMessageDialog(this, "An error has occurred", 
				"Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (e.getSource().equals(inputButton))
		{
			String s = JOptionPane.showInputDialog(this, "What is your age?", 
				"A Question", JOptionPane.QUESTION_MESSAGE);
			this.sendMessage("Your age is " + s + ".\n");
		}
		else if (e.getSource().equals(confirmButton))
		{	
			int selected = JOptionPane.showConfirmDialog(this, "Are you sure?", 
				"A Question", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
			if (selected == JOptionPane.NO_OPTION)
				this.sendMessage("You are not sure!\n");
			else if (selected == JOptionPane.YES_OPTION)
				this.sendMessage("You are sure!\n");	
			else this.sendMessage("You cancelled!\n");		
		}
		else if(e.getSource().equals(optionsButton))
		{
			String[] theDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
			String selected = (String) JOptionPane.showInputDialog( this, 
					"Today is: ", "Working Week Input",
					JOptionPane.INFORMATION_MESSAGE, null,
					theDays, theDays[0]);
			this.sendMessage("You selected " + selected + ".\n");	
		}
		else if(e.getSource().equals(myDialogButton))
		{
			new MyDialog(this, "My Modal Dialog", this, true);
		}
		else if(e.getSource().equals(myModelessButton))
		{
			new MyDialog(this, "My Modeless Dialog", this, false);
		}
	}

	public void sendMessage(String message)
	{
		this.status.append("Message: " + message);
	}
	
	public static void main(String[] args)
	{
		new JDialogExample();
	}
}

@SuppressWarnings("serial")
class MyDialog extends JDialog implements ActionListener
{
	private JTextField entryField;
	private JDialogExample callingApp;

	public MyDialog(Frame frame, String title, JDialogExample callingApp, boolean isModal) {
	   super(frame, title, isModal);
	   this.callingApp = callingApp;

	   this.getContentPane().setLayout(new FlowLayout());
	   this.getContentPane().add(new JLabel("Enter a number between 1 and 10:"));
	   entryField = new JTextField(10);
	   entryField.addActionListener(this);
	   this.getContentPane().add(entryField);

	   //prevent the dialog from closing without a value
	   this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	
	   this.setSize(400,80);
	   this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
	   String entry = entryField.getText();
	   try{
		Integer i = new Integer(entry);
		if (i.intValue()<=10 && i.intValue()>=1) {
			callingApp.sendMessage("Valid number "+ i +" entered!\n");
		  this.dispose();
		}
		else {
			callingApp.sendMessage("Invalid Number Entered " + i +"!\n");
		}
	   }
	   catch (NumberFormatException exept) {
		   callingApp.sendMessage("Invalid Number Entered!\n");
	   }
	}
}