package stack.commons.graphics.swing;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GUI {
	
	public JButton getLoad() {
		JButton result = new JButton();
		result.setText("Load");
		return result;
	}

	public JPanel getModel() {
		JPanel panel = new Editor();
		return panel;
	}
	
	

}
