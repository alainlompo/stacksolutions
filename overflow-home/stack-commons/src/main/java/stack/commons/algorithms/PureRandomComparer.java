package stack.commons.algorithms;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import stack.commons.aleas.Randomizer;

public class PureRandomComparer extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2804901097139028891L;
	
	private static final int SCREEN_WIDTH = 420;
	private static final int SCREEN_HEIGHT = 320;
	private static final int MAX_CANDIDATES_AT_TIME = 10;
	private static final int MAX_NUMBER_OF_POINTS = 1000;
	
	
	
	private List<Point> randomPoints = new ArrayList<Point>();
	private Point currentPoint;
	private int currentPointIndex =0;
	
	private Point[] candidatesBunch = new Point[MAX_CANDIDATES_AT_TIME];
	
	public PureRandomComparer() {
	
		this.setTitle("Pure random comparer");
		computeRandomPoints();
		initComponents();
	}
	
	
	private void computeRandomPoints() {
		
		do {
			
			currentPoint = getRandomPoint();
			randomPoints.add(currentPoint);
			currentPointIndex++;
		
		} while (currentPointIndex <MAX_NUMBER_OF_POINTS);
			
	}
	
	

	private Point getRandomPoint() {
		return new Point(Randomizer.getHelper().nextInt(SCREEN_WIDTH), Randomizer.getHelper().nextInt(SCREEN_HEIGHT));
		
	}
	
	private void initComponents() {
		this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		PaintPanel panel = new PaintPanel(randomPoints);
		panel.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setContentPane(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				new PureRandomComparer().setVisible(true);
				
			}});
	}
	

	
	
	

}
