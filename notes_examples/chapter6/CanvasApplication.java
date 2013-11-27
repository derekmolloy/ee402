package ee402;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class CanvasApplication extends Frame implements ActionListener, WindowListener{
	
	private CustomCanvas canvas;
	private Button refresh;
	
	public CanvasApplication(){
		super("Canvas Application");
		this.refresh = new Button("Refresh");
		this.add(refresh, BorderLayout.NORTH);
		this.refresh.addActionListener(this);
		this.canvas = new CustomCanvas(250,250);
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
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(refresh)){
			this.canvas.update();
		}
	}

	public static void main(String[] args) {
		new CanvasApplication();
	}
}
