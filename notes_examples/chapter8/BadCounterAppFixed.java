/** Bad Counter Fixed Application Example - Derek Molloy, Dublin City University
 *   This code fixes the previous non-working version by adding threading
 */

package ee402;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class BadCounterAppFixed extends Frame implements ActionListener, Runnable {

	private int count = 0;
	private Button start, stop;
	private TextField countText;
	private boolean running = true;
	private Thread thread;
	
	public BadCounterAppFixed(){
		super("Bad Counter Fixed");
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
		this.thread = new Thread(this);
	}	
	
	public void run(){
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
		new BadCounterAppFixed();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(start)){
			this.thread.start();
		}
		else if (e.getSource().equals(stop)){
			this.running = false;
		}
	}
}
