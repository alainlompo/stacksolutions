package stack.commons.graphics.swing;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Controller {

	private GUI view;
	private JButton buttonLoad;
//	private JButton buttonZoom;
//	private JButton buttonDrag;
//	private JButton buttonSave;
//	private JButton buttonRotate;
//	private JButton buttonDraw;
	private JMenuBar menuB;
	private JPanel dPanel;
	private MouseListener e;
	Graphics g;

	public Controller(GUI gui) throws ClassNotFoundException{

	    this.view = gui;
	   // menuB = view.getMenu();
	    buttonLoad = view.getLoad();
//	    buttonZoom = view.getZoom();
//	    buttonRotate = view.getRotate();
//	    buttonSave = view.getSave();
//	    buttonDrag = view.getDrag();
//	    buttonDraw = view.getDraw();
	    dPanel = view.getModel();
	    dPanel.add(buttonLoad, BorderLayout.NORTH);
	    g = dPanel.getGraphics();

		
		JFrame frame = new JFrame("Top level container...");
		frame.add(dPanel, BorderLayout.CENTER);
		frame.setSize(400, 400);
		frame.setVisible(true);
		
		Class c = Class.forName("String");
		//c.newInstance();
		

	    FunctionListener x = new FunctionListener();
//	    MenuBarListener y = new MenuBarListener();
	    buttonLoad.addActionListener(x);
//	    buttonZoom.addActionListener(x);
//	    buttonRotate.addActionListener(x);
//	    buttonSave.addActionListener(x);
//	    buttonDrag.addActionListener(x);
//	    buttonDraw.addActionListener(x);
	    //menuB.addMenuListener(y);
	}
	
	
	class FunctionListener implements ActionListener{

	    public void actionPerformed(ActionEvent e)
	    {
//	        if(e.getSource().equals(buttonZoom)){
//	            Editor editor = new Editor();
//	            editor.getPanel(dPanel);
//	            editor.paintComponent(g);
	//
//	        }
	    	
	         Editor editor = new Editor();
	         editor.getPanel(dPanel);
	         editor.paintComponent(g);
	    	
	    	
	    	
	    }
	    
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		GUI gui = new GUI();
		Controller controller = new Controller(gui);
	}
	
	
}


	