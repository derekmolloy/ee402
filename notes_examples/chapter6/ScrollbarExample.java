package ee402;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ScrollbarExample extends Frame implements AdjustmentListener, ActionListener
{
	private Scrollbar scrollbar;
	private TextField status;
	private Button resetButton;

	public ScrollbarExample(){
		super("Scrollbar Example");
		this.setLayout(new GridLayout(2,1));
		Panel topPanel = new Panel();

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
		new ScrollbarExample();
	}
}
