package stack.commons.graphics.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Editor extends JPanel implements MouseListener, MouseMotionListener {
    private int index = 0;
    private Point[] arr = new Point[100000];
    private JPanel xPanel = new JPanel();
    Updater upDate = new Updater();


	public void getPanel(JPanel dPanel)
	{
		xPanel = dPanel;
		xPanel.addMouseListener(this);
		xPanel.addMouseMotionListener(this);
		xPanel.setBackground(Color.white);
		xPanel.setSize(300, 300);
		xPanel.setVisible(true);
	}
	
	public void paintComponent(Graphics g)
	{
		System.out.println("Got to this point");
		xPanel.paintComponents(g);
		for(int i = 0; i < index - 1; i++)
		{
		    System.out.println("And here 2");
		    g.drawLine(arr[i].x, arr[i].y, arr[i+1].x, arr[i+1].y);
		    System.out.println("And here 3");
		}
	}
	
	public void mousePressed(java.awt.event.MouseEvent e) {
		arr[index] = new Point(e.getX(), e.getY());
		index++;
		System.out.println(index);
		upDate.update(xPanel);
	}
	
	public void mouseDragged(java.awt.event.MouseEvent e) {
		arr[index] = new Point(e.getX(), e.getY());
		index++;
		System.out.println(index);
		upDate.update(xPanel);
	}
	
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
