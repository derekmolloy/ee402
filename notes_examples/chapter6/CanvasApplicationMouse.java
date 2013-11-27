package ee402;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class CanvasApplicationMouse extends Frame implements WindowListener{
	
	private CustomCanvasMouse canvas;
	
	public CanvasApplicationMouse(){
		super("Canvas Mouse Application");
		this.canvas = new CustomCanvasMouse(250,250);
		this.add(canvas, BorderLayout.CENTER);
		this.addWindowListener(this);
		this.pack();
		this.setVisible(true);
	}

	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
	public void windowClosing(WindowEvent arg0) { System.exit(0); }
	public void windowDeactivated(WindowEvent arg0) {}
	public void windowDeiconified(WindowEvent arg0) {}
	public void windowIconified(WindowEvent arg0) {}
	public void windowOpened(WindowEvent arg0) {}

	public static void main(String[] args) {
		new CanvasApplicationMouse();
	}
}
