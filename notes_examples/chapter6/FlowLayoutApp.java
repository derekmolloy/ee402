package ee402;

import java.awt.*;

@SuppressWarnings("serial")
public class FlowLayoutApp extends Frame {

	public FlowLayoutApp() {
		super("FlowLayout");
		this.setLayout(new FlowLayout());
		
		 Button button1 = new Button("Button 1");
		 Button button2 = new Button("Button 2");
		 Button button3 = new Button("Button 3");
		 Button button4 = new Button("Button 4");
		 Button button5 = new Button("Button 5");
		 add(button1);
		 add(button2);
		 add(button3);
		 add(button4);
		 add(button5);
		
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FlowLayoutApp();
	}
}
