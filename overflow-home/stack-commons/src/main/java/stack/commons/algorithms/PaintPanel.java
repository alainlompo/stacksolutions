package stack.commons.algorithms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

import javax.swing.JPanel;

import stack.commons.aleas.Randomizer;

class PaintPanel extends JPanel {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5614021935627523089L;
	private List<Point> pointsToDraw;
	
	public PaintPanel(List<Point> pointsToDraw) {
		this.pointsToDraw = pointsToDraw;
		this.setBackground(Color.BLACK);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (null== pointsToDraw) {
			return;
		}
		
		for (Point p: pointsToDraw) {
			
			g.setColor(Color.WHITE);
			g.drawArc(
					(int)p.getX(), 
					(int)p.getY(), 
					5, 5, 0,(int) (2*Math.PI * 180));	
		}
		
	}
}