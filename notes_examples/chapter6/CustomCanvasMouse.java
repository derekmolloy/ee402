package ee402;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("serial")
public class CustomCanvasMouse extends Canvas implements MouseListener{

	int width, height;
	Vector<Point> points = new Vector<Point>(10);
	static int radius = 10;
	
	public CustomCanvasMouse(int width, int height){
		this.setSize(width,height);
		this.width = width;
		this.height = height;
		this.addMouseListener(this);
		this.repaint();
	}
		
	public void paint(Graphics g){
		g.setColor(Color.red);
		for(int i=0; i<points.size(); i++){
			Point p = points.elementAt(i);
			g.drawOval(p.x, p.y, 2*radius, 2*radius);
		}
	}

	public void mouseClicked(MouseEvent e) {
		points.addElement(new Point(e.getX()-radius, e.getY()-radius));
		this.repaint();
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
