package ee402;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class CustomCanvas extends Canvas {

	int width, height;
	
	public CustomCanvas(int width, int height){
		this.setSize(width,height);
		this.width = width;
		this.height = height;
		this.update();
	}
	
	public void update() { this.repaint(); }
	
	public void paint(Graphics g){
		for(int i=0; i<200; i++){
			Color tempColor = new Color((float)Math.random(), 
					(float)Math.random(), (float)Math.random());
			g.setColor(tempColor);
			g.drawOval((int)(Math.random()*width),(int)(Math.random()*height), 20, 20);
		}
	}
}
