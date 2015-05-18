package stack.commons.graphics.swing;

import javax.swing.*;

import java.awt.*;

public class DrawingPanel extends JPanel {
	
	// Change the coordinate system, from a screen coordinate system
	// To a panel centered coordinate system
	
	public static double getNewX(double x, double width) {
		return x - (width/2);
	}
	
	
	public static double getNewY(double y, double height) {
		return (height/2) - y;
	}
	
	public static double getNativeX(double newX, double width) {
		return newX + (width/2);
	}
	
	public static double getNativeY(double newY, double height) {
		return (height/2) - newY;
	}
	
	
	/**
	 * All our drawing methods use our world coordinates
	 * @param x
	 * @param y
	 * @param g
	 */
	public static void drawPoint(double x, double y,double width,double height, Graphics g) {
		
		double nativeX = getNativeX(x, width);
		double nativeY = getNativeY(y, height);
		g.fillRect((int)nativeX, (int)nativeY, 1, 1);
		
	}
	
	public static void drawLine(double x0, double y0, double x1, double y1, double width, double height, Graphics g) {
		double nativeX0 = getNativeX(x0, width);
		double nativeY0 = getNativeY(y0, height);
		double nativeX1 = getNativeX(x1, width);
		double nativeY1 = getNativeY(y1, height);
		
		g.drawLine((int)nativeX0, (int)nativeY0, (int)nativeX1, (int)nativeY1);
	}
	
	
	public static void drawArc(double x,
	           double y,
	           double r,
	           double width,
	           double height,
	           double startAngle,
	           double endAngle,
	           Graphics g) {
		
		double nativeX = getNativeX(x, width);
		double nativeY = getNativeY(y, height);
		
		g.drawArc((int)nativeX, (int)nativeY, (int)r, (int)r, (int)startAngle, (int)(endAngle));		
		
	}
	
	public static void drawBressenhamsCircle( double width, double height, Graphics g) {
		
		int x,y,d;
		double r = Math.max(width/2, height/2);
		y = (int)r;
		x = 0;
		
		drawPoint((double)x, (double)y, width, height,g);
		d = (3-2*(int)r);
		while (x <= y) {
			
			if (d <= 0) {
				d = d + (4*x + 6);
			} else {
				d = d + 4*(x-y) + 10;
				y--;
			}
			x++;
			
			drawPoint((double)x, (double)y, width, height,g);
			
			drawPoint((double)-x, (double)y, width, height,g);
			drawPoint((double)x, (double)-y, width, height,g);
			
			drawPoint((double)-x, (double)-y, width, height,g);
			drawPoint((double)y, (double)x, width, height,g);
			drawPoint((double)-y, (double)x, width, height,g);
			drawPoint((double)y, (double)-x, width, height,g);
			
			drawPoint((double)-y, (double)-x, width, height,g);
			
		}
		
		
	}
	
	
	
	public static void drawBressenhamsCircle(int r, double width, double height, Graphics g) {
		
		int x,y,d;
		y = r;
		x = 0;
		
		drawPoint(x, y, width, height,g);
		d = (3-2*(int)r);
		while (x <= y) {
			
			if (d <= 0) {
				d = d + (4*x + 6);
			} else {
				d = d + 4*(x-y) + 10;
				y--;
			}
			x++;
			
			drawPoint(x, y, width, height,g);
			
			drawPoint(-x, y, width, height,g);
			drawPoint(x, -y, width, height,g);
			
			drawPoint(-x, -y, width, height,g);
			drawPoint(y, x, width, height,g);
			drawPoint(-y, x, width, height,g);
			drawPoint(y, -x, width, height,g);
			
			drawPoint(-y, -x, width, height,g);
			
		}	
	}
	
	
	public static void drawTrigonometricalCircle (double r, double width, double height, Graphics g) {
		
		double x0 = 0;
		double y0 = 0;
		boolean isStart = true;
				
		for (double angle = 0; angle <= 2*Math.PI; angle = angle + Math.PI/36) {
		
			double x = r * Math.cos(angle);
			double y = r * Math.sin(angle);
			
			drawPoint((double)x, y, width, height, g);
			
			if (!isStart) {
				drawLine(x0,  y0, x, y, width, height, g);
			}
			
			isStart = false;
			x0 = x;
			
			y0 = y;
			
		}
		
	}
	
	public static void drawTrigonometricalCircle (double width, double height, Graphics g) {
		
		double x0 = 0;
		double y0 = 0;
		boolean isStart = true;
		double R = Math.min(width/2, height/2) ;
		
		for (double angle = 0; angle <= 2*Math.PI; angle = angle + Math.PI/36) {
		
			double x = R * Math.cos(angle);
			double y = R * Math.sin(angle);
			
			drawPoint((double)x, y, width, height, g);
			
			if (!isStart) {
				drawLine(x0,  y0, x, y, width, height, g);
			}
			
			isStart = false;
			x0 = x;
			
			y0 = y;
			
		}
		
	}
	
	public static void drawStandardCircle(double r, double width, double height, Graphics g) {
		drawArc(0, 0, r, width, height, 0, 360, g);
	}
	
	
	/**
	 * Draws a 1000 circles using drawArc method
	 * @param width
	 * @param height
	 * @param g
	 */
	public static void drawABunchOfStandardCircles(int numOfCircles, double width, double height, Graphics g) {
		double r = 5;
		double step = (300.0-5.0)/numOfCircles;
		for (int i = 1; i <= numOfCircles; i++) {
			drawStandardCircle(r, width, height, g);
			r += step;
		}
	}
	
	public static void drawABunchOfTrigonometricalCircles(int numOfCircles, double width, double height, Graphics g) {
		
		double r = 5;
		double step = (300.0-5.0)/numOfCircles;
		
		for (int i = 1; i <= numOfCircles; i++) {
			drawTrigonometricalCircle(r, width, height, g);
			r += step;
		}
	}
	
	public static void drawABunchOfBressenhamsCircles(int numOfCircles, double width, double height, Graphics g) {
		double r = 5;
		double step = (300.0-5.0)/numOfCircles;
		
		for (int i = 1; i <= numOfCircles; i++) {
			drawBressenhamsCircle((int)r, width, height, g);
			r += step;
		}
	}
	
	public void paint(Graphics g) {
				
		Graphics2D g2D = (Graphics2D)g;
		
		g2D.setColor(Color.RED);
		
		long trigoStartTime = System.currentTimeMillis();
		drawABunchOfTrigonometricalCircles(1000, this.getWidth(), this.getHeight(), g);
		long trigoEndTime = System.currentTimeMillis();
		long trigoDelta = trigoEndTime - trigoStartTime;

		g2D.setColor(Color.BLUE);
		
		long bressenHamsStartTime = System.currentTimeMillis();
		drawABunchOfBressenhamsCircles(1000, this.getWidth(), this.getHeight(), g);
		long bressenHamsEndTime = System.currentTimeMillis();
		long bressenDelta = bressenHamsEndTime - bressenHamsStartTime;

		g2D.setColor(Color.GREEN);
		
		long standardStarTime = System.currentTimeMillis();
		drawABunchOfStandardCircles(1000, this.getWidth(), this.getHeight(),g);
		long standardEndTime = System.currentTimeMillis();
		long standardDelta = standardEndTime - standardStarTime;
		
		System.out.println("Trigo : " + trigoDelta  + " milliseconds");
		System.out.println("Bressenham :" + bressenDelta +  " milliseconds");
		System.out.println("Standard :" + standardDelta +  " milliseconds");
		
		
	}
	
	public static void main(String[] args) {
		JFrame tester = new JFrame("Testing bressenham's circle algorithm");
		tester.setSize(300, 300);
		tester.setVisible(true);
		tester.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tester.add(new DrawingPanel());
	}
	
}
