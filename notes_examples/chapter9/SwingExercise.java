package ee402;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CustomColor{
	
	private Color c;
	private String name;
	
	public CustomColor(Color c, String name){
		this.c = c;
		this.name = name;
	}
	
	public String toString() { return name; }
	
	public Color getColor() { return c; }
}


@SuppressWarnings("serial")
public class SwingExercise extends JFrame implements ActionListener {
	
	private JButton button;
	private JTextArea textArea;
	private JTextField status;
	private JCheckBox editable;
	private JComboBox<CustomColor> colorBox;
	private boolean isTextEditable = true;
	
	public SwingExercise() {
	  super("Swing Exercise");

	  // controls panel
	  JPanel controls = new JPanel(new FlowLayout());
	  this.button = new JButton("Clear Text");
	  this.button.addActionListener(this);	
	  controls.add(this.button);

	  editable = new JCheckBox("Read-Only");
	  editable.addActionListener(this);
	  controls.add(this.editable);

	  controls.add(new JLabel("  Text Color:"));
	  CustomColor[] items = { new CustomColor (Color.black, "Black"), 
			  new CustomColor (Color.red, "Red"),
			  new CustomColor (Color.green, "Green"),
			  new CustomColor (Color.blue, "Blue")};
	  colorBox = new JComboBox<CustomColor>(items);
	  colorBox.addActionListener(this);
	  controls.add(colorBox);

	  // status TextField
	  this.status = new JTextField();
	  this.updateStatus("Application Started.");

	  // main area, with scrolling and wrapping
	  this.textArea = new JTextArea(20,40);
	  JScrollPane p = new JScrollPane(this.textArea,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	  this.textArea.setWrapStyleWord(true);

	  this.getContentPane().add("North",controls);
	  this.getContentPane().add("South",this.status);
	  this.getContentPane().add("Center",p);

	  this.pack();  //set the size of the frame according 
	  this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
	  if (e.getSource().equals(button)) {
	    this.textArea.setText("");
	    this.updateStatus("Text Area Cleared.");
	  }
	  else if (e.getSource().equals(editable)) {
	    this.isTextEditable = !this.isTextEditable;
	    this.textArea.setEditable(this.isTextEditable);
	    this.updateStatus("Set Text Area Editable - "+this.isTextEditable);
	  }
	  else if (e.getSource().equals(colorBox)) {
	    CustomColor selection = (CustomColor) this.colorBox.getSelectedItem();
	    this.textArea.setForeground(selection.getColor());
	    this.updateStatus("Set Text Color to - " + selection);
	  }
	}

	private void updateStatus(String theStatus) {
	  this.status.setText("Status: " + theStatus);
	}

	public static void main(String args[]) {
	   new SwingExercise();
	}
}