package ee402;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ButtonEvents extends Frame implements ActionListener{

		private Button button1, button2, button3;
		private TextField status;
		
		public ButtonEvents()
		{
		  super("Button Events");
		  this.setLayout(new FlowLayout());
		  status = new TextField(20);

		  this.button1 = new Button("Button 1");
		  this.button2 = new Button("Button 2");
		  this.button3 = new Button("Button 3");

		  this.button1.addActionListener(this);
		  this.button2.addActionListener(this);
		  this.button3.addActionListener(this);

		  this.add(status);
		  this.add(button1);
		  this.add(button2);
		  this.add(button3);
		  
		  this.pack();
		  this.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent e)
		{
		  if (e.getActionCommand().equals("Button 1"))
		  {
		    status.setText("Button 1 Pressed");
		  }
		  else if (e.getActionCommand().equals("Button 2"))
		  {
		    status.setText("Button 2 Pressed");
		  }
		  else
		  {
		    status.setText("Button 3 Pressed");
		  }
		}

		public static void main(String[] args) {
			new ButtonEvents();
		}
}
