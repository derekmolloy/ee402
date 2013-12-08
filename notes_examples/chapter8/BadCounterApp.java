/** Bad Counter Application Example - Derek Molloy, Dublin City University
 *   This code will not work correctly and the question is why? 
 *   I correct this in the next version.
 */

package ee402;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class BadCounterApp extends Frame implements ActionListener {

	private int count = 0;
	private Button start, stop;
	private TextField countText;
	private boolean running = true;
	
	public BadCounterApp(){
		super("Bad Counter");
		this.setLayout(new FlowLayout());
		this.countText = new TextField(10);
		this.add(countText);
		this.start = new Button("Start");
		this.add(start);
		this.start.addActionListener(this);
		this.stop = new Button("Stop");
		this.add(stop);
		this.stop.addActionListener(this);
		this.pack();
		this.setVisible(true);
	}	
	
	public void go(){
		while(running){
			this.countText.setText("Count: " + count++);
			try{
				Thread.sleep(100);
			}
			catch(InterruptedException e){
				System.out.println("Thread was Interrupted!");
			}
		}
	}
	
	public static void main(String[] args) {
		new BadCounterApp();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(start)){
			this.go();
		}
		else if (e.getSource().equals(stop)){
			this.running = false;
		}
	}
}
