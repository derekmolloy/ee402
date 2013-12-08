/** The Non-Synchronized Gate-Counter Example - Derek Molloy, Dublin City University
 *  ee402.eeng.dcu.ie 
 */

package ee402;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class GateCounterApp extends Frame implements ActionListener{
	
	private Button start, toggle;
	private TextField gate1, gate2, total, gateDetailsTotal;
	private GateCounter gate1Counter, gate2Counter;
	private StadiumDetails stadiumDetails;

	public GateCounterApp() {
		super("Gate Counter Application");
		this.setLayout(new FlowLayout());
		gate1 = new TextField(10);
		gate2 = new TextField(10);
		total = new TextField(10);
		gateDetailsTotal = new TextField(10);
		this.add(new Label("Gate1:"));
		this.add(gate1);
		this.add(new Label("Gate2:"));
		this.add(gate2);
		this.add(new Label("Total should be:"));
		this.add(total);
		this.add(new Label("Actual Total is:"));
		this.add(gateDetailsTotal);

		this.start = new Button("Start");
		this.start.addActionListener(this);
		this.add(start);
		toggle = new Button("Toggle/Total");
		toggle.addActionListener(this);
		this.add(toggle);

		stadiumDetails = new StadiumDetails();
		this.gate1Counter = new GateCounter(gate1, stadiumDetails);
		this.gate2Counter = new GateCounter(gate2, stadiumDetails);
		this.pack();
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
	  if (e.getSource().equals(start)) {
	    this.gate1Counter.start();
	    this.gate2Counter.start();
	  }
	  else if (e.getSource().equals(toggle)) {
	    this.gate1Counter.toggleCounter();
	    this.gate2Counter.toggleCounter();
	    this.gateDetailsTotal.setText(""+stadiumDetails.getTotalSpectators());
	    int indivGateSum = this.gate1Counter.getCount() + this.gate2Counter.getCount();
	    this.total.setText(""+indivGateSum);
	  }
	}

	public static void main(String[] args) {
		new GateCounterApp();
	}
}


class StadiumDetails
{
	private int numberSpectators;

	public void spectatorEntered() {
		int tempInt = this.numberSpectators;
		try { 
			Thread.sleep(5);  //added to cause problems.
		}
		catch (InterruptedException e) {
			System.out.println(e.toString());
		}
		tempInt++;
		this.numberSpectators = tempInt;
	}

	public int getTotalSpectators() { return numberSpectators; }
}


class GateCounter extends Thread {
	private int count;
	private boolean running = true, paused = false;
	private TextField theField;
	private StadiumDetails gateDetails;

	public GateCounter(TextField t, StadiumDetails d) {
	  this.theField = t;
	  this.count = 0;
	  this.gateDetails = d;
	}

	public void run() {
	  while (running) {
	    this.count++;
	    theField.setText("" + count);
	    gateDetails.spectatorEntered();
	    try { 
	    	Thread.sleep(1); 
	    	synchronized(this) {
	    		while (paused) wait();
	    	}
        } 
	    catch (InterruptedException e) {  
	    	theField.setText("Gate Count Interrupted!");
	    	this.stopCounter();
	    }   
	  }
	}

	public void stopCounter() { this.running = false; }

	public int getCount() { return count; }
	
	public synchronized void toggleCounter() { 
		this.paused = !this.paused; 
		if (!this.paused) notify();
	}
}