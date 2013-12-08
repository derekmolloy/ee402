/** Up Down Counter Solution Example - Derek Molloy, Dublin City University
 *   Solution to the question posed in the notes
 */

package ee402;

import java.awt.*;
import java.awt.event.*;

class UpDownCounter extends Thread{
	private int count = 0, delay;
	private boolean running = true, paused = false, countup = true;
	private TextField outputField;
	
	public UpDownCounter(TextField t, int delay, int startAt){
		this.outputField = t;
		this.delay = delay;
		this.count = startAt;
	}
	
	public void run(){
		while(running){
			this.outputField.setText("Count: " + count);
			if(countup) count++;
			else count--;
			try{
				Thread.sleep(this.delay);
				synchronized(this){
					while (this.paused) wait();
				}
			}
			catch (InterruptedException e){
				System.out.println("Counter was Interrupted!");
				this.running = false;
			}
		}
	}
	
	public void stopCount() { this.running = false; }
	
	public void toggleCount() { 		
		synchronized(this){
			this.paused = !this.paused;
			if (!this.paused) this.notify();
		}
	}
	
	public void toggleDirection(){
		this.countup = !this.countup;
	}
}

@SuppressWarnings("serial")
public class UpDownCounterApp extends Frame implements ActionListener{

	private UpDownCounter count1, count2;    //two separate threads
	private TextField count1Field, count2Field;
	private Button start, stop, toggle, updown;
	
	public UpDownCounterApp() {
		super("Multi-Thread Up/Down Counter");
		
		this.count1Field = new TextField(10);
		this.count2Field = new TextField(10);
		this.count1 = new UpDownCounter(count1Field, 100, 0);    // delay 100ms start at 0
		this.count2 = new UpDownCounter(count2Field, 200, 50);   // delay 200ms start at 50
		this.start = new Button("Start");
		this.stop = new Button("Stop");
		this.toggle = new Button("Toggle");
		this.updown = new Button("Up/Down");
		
		this.start.addActionListener(this);
		this.stop.addActionListener(this);
		this.toggle.addActionListener(this);
		this.updown.addActionListener(this);
		
		this.setLayout(new FlowLayout());
		this.add(this.count1Field);
		this.add(this.count2Field);
		this.add(this.start);
		this.add(this.stop);
		this.add(this.toggle);
		this.add(this.updown);
	
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(start)){
			this.count1.start();
			this.count2.start();
		}
		else if (e.getSource().equals(stop)){
			this.count1.stopCount();
			this.count2.stopCount();
		}
		else if (e.getSource().equals(toggle)){
			this.count1.toggleCount();
			this.count2.toggleCount();
		}
		else if (e.getSource().equals(updown)){
			this.count1.toggleDirection();
			this.count2.toggleDirection();
		}
	}
	
	public static void main(String[] args) {
		new UpDownCounterApp();
	}
}


