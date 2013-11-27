package ee402;

import java.awt.*;

@SuppressWarnings("serial")
public class BorderLayoutApp extends Frame {

	public BorderLayoutApp() {
		 super("BorderLayout");
		 //this.setLayout(new BorderLayout());  default layout for a Frame 
		
		 Button button1 = new Button("Button 1");
		 Button button2 = new Button("Button 2");
		 Button button3 = new Button("Button 3");
		 Button button4 = new Button("Button 4");
		 Button button5 = new Button("Button 5");
		 add(button1, BorderLayout.NORTH);
		 add(button2, BorderLayout.SOUTH);
		 add(button3, BorderLayout.EAST);
		 add(button4, BorderLayout.WEST);
		 add(button5, BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayoutApp();
	}
}