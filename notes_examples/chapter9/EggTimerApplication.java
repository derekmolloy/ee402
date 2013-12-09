/** Java Swing Examples - Written by Derek Molloy, Dublin City University, Ireland
 *  see: http://ee402.eeng.dcu.ie/ 
 */
package ee402;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.net.URL;
import java.applet.*;

@SuppressWarnings("serial")
public class EggTimerApplication extends JFrame implements ActionListener {
	
	private JProgressBar progressBar;
	private JButton startButton, stopButton;
	private JLabel textLabel;
	private EggTimer eggTimer;

	public EggTimerApplication()
	{
		super("Egg Timer");

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBorder(new TitledBorder("Egg Timer:"));

		progressBar = new JProgressBar(JProgressBar.HORIZONTAL,0,120);

		JPanel controls = new JPanel();
		textLabel = new JLabel("  0 Seconds ");
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		stopButton = new JButton("Stop");
		stopButton.addActionListener(this);

		p.add(progressBar);
		p.add(textLabel);
		controls.add(startButton);
		controls.add(stopButton);

		this.getContentPane().add("Center",p);
		this.getContentPane().add("South",controls);

		this.setSize(300,130);
		this.setVisible(true);

		URL clipLocation = this.getClass().getResource("ready.wav"); 
		AudioClip theSound = Applet.newAudioClip(clipLocation);
		this.eggTimer = new EggTimer(this.progressBar, this.textLabel, theSound);
	}
	
	public void actionPerformed(ActionEvent e)
	{
	  if (e.getSource().equals(startButton))
	  {
		this.eggTimer.start();
	  }
	  else if (e.getSource().equals(stopButton))
	  {
	        this.eggTimer.stopTimer();
	  }
	}
	
	public static void main(String[] args)
	{
		new EggTimerApplication();
	}
}


class EggTimer extends Thread {
	private boolean running = true;
	private JProgressBar progressReference;
	private JLabel textLabel;
	private AudioClip theSound;

	public EggTimer(JProgressBar progressReference, JLabel textLabel, AudioClip theSound) {
	  this.progressReference = progressReference;
	  this.textLabel = textLabel;
	  this.theSound = theSound;
	}

	public void run() {
		while(running)
		{
		  if (this.updateProgress()==false) running = false;
		  try {
			Thread.sleep(100); // should be 1000, but I don't want to wait in test
		  }
		  catch (InterruptedException e) {
		    System.out.println(e.toString());
		  }
		}
	}

	private boolean updateProgress() {
		int current = progressReference.getValue();
		int updateTo = ++current;
		if (updateTo <= 120) {
		  this.progressReference.setValue(updateTo);
		  this.textLabel.setText(" " + updateTo + " Seconds ");
		  return true;
		}
		else {
		  this.playSound();
		  return false;	
		}
	}

	public void stopTimer() {
	   this.running = false;
	   this.playSound();
	}
	
	private void playSound() {
	  if (this.theSound != null) {
		  this.theSound.play();
	   }
	  try{
	   	Thread.sleep(200);
	  }
	  catch(InterruptedException e) {
		System.out.println(e.toString());
	  }
	}
}