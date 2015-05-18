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

public class MitchellBestCandidateIV extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7874344109745141056L;
	private static final int SCREEN_WIDTH = 420;
	private static final int SCREEN_HEIGHT = 320;
	private static final int MAX_CANDIDATES_AT_TIME = 10;
	private static final int MAX_NUMBER_OF_POINTS = 1000;
	
	private List<Point> mitchellPoints = new ArrayList<Point>();
	private Point currentPoint;
	private int currentPointIndex =0;
	
	private Point[] candidatesBunch = new Point[MAX_CANDIDATES_AT_TIME];
	
	public MitchellBestCandidateIV() {
	
		this.setTitle("Mitchell's best candidate algorithm");
		computeBestPoints();
		initComponents();
	}
	
	
	private void computeBestPoints() {
		
		do {
			
			currentPoint = getRandomPoint();
			mitchellPoints.add(currentPoint);
			currentPointIndex++;
			
			setCandidates();
			Point bestCandidate =  pickUpCandidate();
			mitchellPoints.add(bestCandidate);
			currentPoint = bestCandidate;
			currentPointIndex++;
		
		} while (currentPointIndex <MAX_NUMBER_OF_POINTS);
			
	}
	
	
	private Point pickUpCandidate() {
		
		Map<Point, Double> candidatesMinimalDistance = new HashMap<Point, Double>();
		for (Point candidate:candidatesBunch ) {
			double minimalDistanceToCloud = minimalDistanceFromCloudToCandidate(candidate);
			candidatesMinimalDistance.put(candidate, Double.valueOf(minimalDistanceToCloud));
		}
		
		Point bestCandidate = getFarthestPoint(candidatesMinimalDistance);
		return bestCandidate;		
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
				new MitchellBestCandidateIV().setVisible(true);
				
			}});
	}
	
	public double distanceBetween(Point p1, Point p2) {
		
		double deltaX = p1.getX() - p2.getX();
		double deltaY = p1.getY() - p2.getY();
		double deltaXSquare = Math.pow(deltaX, 2);
		double deltaYSquare = Math.pow(deltaY, 2);
		
		return Math.sqrt(deltaXSquare + deltaYSquare);
	}
	
	
	public Point getFarthestPoint(Map<Point, Double> pointsMinimalDistances) {
		Point result = null;
		double maxDistance = 0.0D;
		for (Point p: pointsMinimalDistances.keySet()) {
			if (maxDistance < pointsMinimalDistances.get(p)) {
				result = p;
				maxDistance = pointsMinimalDistances.get(p);
			}
		}
		
		return result;
	}
		
	public double minimalDistanceFromCloudToCandidate(Point candidate) {
		double minimalDistance = 0.0D;
		
		for (Point p: mitchellPoints) {
			double d = distanceBetween(candidate,  p);
			if (minimalDistance == 0.0D || d < minimalDistance) {
				minimalDistance = d;
			}
		}
		
		return minimalDistance;
	}


}
