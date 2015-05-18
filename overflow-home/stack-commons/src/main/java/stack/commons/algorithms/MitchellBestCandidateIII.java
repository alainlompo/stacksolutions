package stack.commons.algorithms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import stack.commons.aleas.Randomizer;

public class MitchellBestCandidateIII extends JFrame {
	
	private static final int SCREEN_WIDTH = 800;
	private static final int SCREEN_HEIGHT = 600;
	private static final int MAX_CANDIDATES_AT_TIME = 10;
	private static final int MAX_NUMBER_OF_POINTS = 1000;
	
	
	
	private List<Point> mitchellPoints = new ArrayList<Point>();
	private Point currentPoint;
	private int currentPointIndex =0;
	private boolean isBeginning = true;
	private Point[] candidatesBunch = new Point[MAX_CANDIDATES_AT_TIME];
	
	public MitchellBestCandidateIII() {
	
		computeBestPoints();
		initComponents();
	}
	
	
	private void computeBestPoints() {
		
		do {
			
			currentPoint = getRandomPoint();
			mitchellPoints.add(currentPoint);
					
			setCandidates();
			Point bestCandidate = pickUpCandidateFor(currentPoint);
			mitchellPoints.add(bestCandidate);
			currentPoint = bestCandidate;
			currentPointIndex++;
		
		} while (currentPointIndex <MAX_NUMBER_OF_POINTS);
		
		
		
	}
	
	private Point pickUpCandidateFor(Point p) {
		double biggestDistance = 0.0D;
		Point  result = null;
		for (int i = 0; i < MAX_CANDIDATES_AT_TIME; i++) {
			
			double d = distanceBetween(p, candidatesBunch[i]);
			if (biggestDistance < d) {
				biggestDistance = d;
				result = candidatesBunch[i];
				
			}
		}
		
		return result;
	}
	
	private void setCandidates() {
		for (int i = 0; i < MAX_CANDIDATES_AT_TIME; i++) {
			candidatesBunch[i] = getRandomPoint();
		}
	}
	
	
	
	private Point getRandomPoint() {
		return new Point(Randomizer.getHelper().nextInt(SCREEN_WIDTH), Randomizer.getHelper().nextInt(SCREEN_HEIGHT));
		
	}
	
	private void initComponents() {
		this.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		PaintPanel panel = new PaintPanel(mitchellPoints);
		panel.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setContentPane(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				new MitchellBestCandidateIII().setVisible(true);
				
			}});
	}
	
	public double distanceBetween(Point p1, Point p2) {
		
		double deltaX = p1.getX() - p2.getX();
		double deltaY = p1.getY() - p2.getY();
		double deltaXSquare = Math.pow(deltaX, 2);
		double deltaYSquare = Math.pow(deltaY, 2);
		
		return Math.sqrt(deltaXSquare + deltaYSquare);
		
				
		
	}

}


