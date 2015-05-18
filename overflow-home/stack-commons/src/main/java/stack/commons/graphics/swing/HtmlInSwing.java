package stack.commons.graphics.swing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.HyperlinkListener;

public class HtmlInSwing {
	
	private static JFrame frame;
	private static JPanel panel;
	private static JOptionPane optionPane;
	private static JEditorPane editorPane;
	
	public static void main(String[] args) {
		frame = new JFrame("Demo frame...");
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		
		
		optionPane = new JOptionPane();
		optionPane.setSize(400, 300);
		editorPane = new JEditorPane();
		panel.add(optionPane, BorderLayout.CENTER);
		optionPane.add(editorPane, BorderLayout.CENTER);
		
		
		editorPane.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
		editorPane.setEditable(false);
		
		HyperlinkListener hyperlinkListener = new ActivatedHyperlinkListener(frame, editorPane);
		editorPane.addHyperlinkListener(hyperlinkListener);
		
		
		editorPane.setText("<a href='http://www.stackoverflow.com'>Go to the stack</a>");
		
		editorPane.setToolTipText("if you click on <b>that link you go to the stack");
		
		frame.setVisible(true);
		
	}
	
	

}
