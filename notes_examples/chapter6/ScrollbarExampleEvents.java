package ee402;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ScrollbarExampleEvents extends Frame implements AdjustmentListener, ActionListener, WindowListener
{
	private Scrollbar scrollbar;
	private TextField status;
	private Button resetButton;

	public ScrollbarExampleEvents(){
		super("Scrollbar Example");
		this.setLayout(new GridLayout(2,1));
		Panel topPanel = new Panel();

		this.addWindowListener(this);
		
		this.status = new TextField(20);
		this.scrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 50, 10, 0, 110);
		this.resetButton = new Button("Reset");

		this.resetButton.addActionListener(this);
		this.scrollbar.addAdjustmentListener(this);

		topPanel.add(status);
		topPanel.add(resetButton);

		this.add(topPanel);
		this.add(scrollbar);

		this.updateText();
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		if (e.getActionCommand().equals("Reset")){
			this.scrollbar.setValue(0);
			this.updateText();
		}
	}

	public void adjustmentValueChanged(AdjustmentEvent e){
		if (e.getSource().equals(scrollbar)){
			this.updateText();
		}
	}

	private void updateText(){
		status.setText("Scroll Value = " + scrollbar.getValue());
	}

	public static void main(String[] args) {
		new ScrollbarExampleEvents();
	}

	public void windowActivated(WindowEvent arg0) {
		this.scrollbar.setValue(50);
		this.updateText();
	}
	public void windowClosed(WindowEvent arg0) {}
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}
}
