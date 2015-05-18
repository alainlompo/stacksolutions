package stack.commons.algorithms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import stack.commons.aleas.Randomizer;

public class MitchellBestCandidate {
	
	static final int MAX_WIDTH = 50;
	static final int MAX_HEIGHT = 50;
	static final int SAMPLE_INCREASE_VOLUME = 10;
	static final int TWO_PI_DEGREES = 360;
	static final Color[] DOTS_COLORS = {Color.GREEN, Color.LIGHT_GRAY, Color.BLUE, Color.MAGENTA};
	static final int MAX_DOTS_LIMIT =1000;
	
	static final Random randomizer = new Random();
	
	private int screenWidth = 420;
	private int screenHeight = 420;
	
	
	int dotLimit = 1000;
	
	int speed = 50;
	int a = 255;
	
	int currentCandidateX;
	int currentCandidateY;
	
	Point[] currentCandidatesSample = new Point[SAMPLE_INCREASE_VOLUME];
	Point currentPoint = getRandomPoint();
	List<Point> samples = new ArrayList<Point>();
	
	int numberOfPoints = 0;
	
	
	
	
	public CandidateInfo findClosest() {
		double smallestDistance = 0;
		int index = 0;
		
		for (int i = 0; i < samples.size(); i++) {
			double one = Math.pow(currentCandidateX-samples.get(i).getX(),2);
			double two = Math.pow(currentCandidateY - samples.get(i).getY(), 2);
			double distance = Math.sqrt(one + two);
			if (smallestDistance == 0 || distance < smallestDistance) {
				smallestDistance = distance;
				index = i;
			}
		}
		
		return new CandidateInfo(index, smallestDistance);
	}
	
	public CandidateInfo findClosestII() {
		double smallestDistance = 0;
		int index = 0;
		
		for (int i = 0; i < currentCandidatesSample.length; i++) {
			double one = Math.pow(currentCandidateX-currentCandidatesSample[i].getX(),2);
			double two = Math.pow(currentCandidateY - currentCandidatesSample[i].getY(), 2);
			double distance = Math.sqrt(one + two);
			if (smallestDistance == 0 || distance < smallestDistance) {
				smallestDistance = distance;
				index = i;
			}
		}
		
		return new CandidateInfo(index, smallestDistance);
	}
	
	public void drawScreen(Graphics g) {
		for (int i = 0; i < samples.size(); i++) {
			Point p = samples.get(i);
			drawPoint(p, g);			
		}
		
	}
	
	public void drawPoint(Point p,Graphics g) {
		g.setColor(Color.BLUE);
		//g.setColor((Color)Randomizer.oneOf(DOTS_COLORS));
		g.fillArc((int)p.getX(), (int)p.getY(), 25/*randomWidth()*/, 25/*randomHeight()*/, 0, TWO_PI_DEGREES);
	}
	
	
	public void increasedSetOfPoints() {
		
		for (int i = 0; i < SAMPLE_INCREASE_VOLUME; i++  ) {
			Point p = getRandomPoint();
			currentCandidatesSample[i] = p;
		}
		
		
		
	}
	
	public void printPointsArray(Point[] points) {
		
		System.out.print("[");
		for (Point p:points) {
			System.out.print("(" + p.getX() + "," + p.getY() + ")");
		}
		System.out.println("]");
		
	}
	
	void printIncreasedSet() {
		printPointsArray(currentCandidatesSample);
	}
	
	void printTargetWithSet(Point target) {
		
		System.out.print("target is : (" + target.getX() + "," + target.getY() + ") ==>");
		printIncreasedSet();
	}
	
	public void draw(Graphics g) {
		
		boolean hasNewPoint = true;
		
		//do {
			
			if (hasNewPoint) {
				drawPoint(currentPoint, g);
				try {
					
					Thread.sleep(5);
					
				} catch (Exception ex) {
					
				}
			
				samples.add(currentPoint);
			
				numberOfPoints++;
				
				hasNewPoint = false;
			}
			
			increasedSetOfPoints();
			printTargetWithSet(currentPoint);
			
			
				
			double largestDistance = 0;
				
			for (int i = 0; i < SAMPLE_INCREASE_VOLUME; i++) {
				CandidateInfo candidate = findClosestII();
				System.out.println(candidate);
				if (largestDistance == 0 || candidate.getDistance() > largestDistance) {
					largestDistance = candidate.getDistance();
					currentPoint = new Point(
							(int)currentCandidatesSample[candidate.getIndex()].getX(), 
							(int)currentCandidatesSample[candidate.getIndex()].getY()
							);
						
					currentCandidateX = (int)currentPoint.getX();
					currentCandidateY = (int)currentPoint.getY();
						
					if (largestDistance != 0) {
						hasNewPoint = true;
					}
						
						
				}
			}
			
		//} while (numberOfPoints <= MAX_DOTS_LIMIT);
	}
	
	public int randomWidth() {
		return (int)( randomizer.nextDouble()* MAX_WIDTH);
	}
	
	public int randomHeight() {
		return (int) (randomizer.nextDouble() * MAX_HEIGHT);
	}
	
	public Point getRandomPoint() {
		return new Point(Randomizer.getHelper().nextInt(screenWidth), Randomizer.getHelper().nextInt(screenHeight));
		
	}
	
	
	
	private Container container;
	
	
	public MitchellBestCandidate() {
		initComponents();
	}
	
	private void initComponents() {

		container = new Container();
		
		WorkPanel workPanel = new WorkPanel(this);
		workPanel.setBackground(Color.WHITE);
		workPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		container.setSize(420, 420);
		container.setContentPane(workPanel);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public Container getContainer() {
		return container;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				
				(new MitchellBestCandidate()).getContainer().setVisible(true);
			}
		}
		 
		
		);
	}

}

class Container extends JFrame {

	
}

class WorkPanel extends JPanel {
	
	MitchellBestCandidate candidatizer;
	
	public WorkPanel(MitchellBestCandidate candidatizer) {
		this.setPreferredSize(new Dimension(420,420));
		this.candidatizer = candidatizer;
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		candidatizer.draw(g);
		
		
	}
	
}

class CandidateInfo {
	
	private int index;
	private double distance;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public CandidateInfo(int index, double distance) {
		super();
		this.index = index;
		this.distance = distance;
	}
	
	public String toString() {
		return "==> ==> retained candidate : " + index + " for distance: " + distance;
	}
	
	
}
