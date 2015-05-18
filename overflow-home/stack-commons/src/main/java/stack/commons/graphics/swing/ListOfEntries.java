package stack.commons.graphics.swing;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ListOfEntries extends JComponent {
	   //instance variables
    //worked until arrays added
    String[] telephones = {"5551234567", "5557654321", "5555671234"};
    String[] names = {"Emily", "Billy Bob", "Wiley Coyote"};
    String[] periods = {"2p - 3p", "1a - 5a", "4:30p - 11p"};
 private JLabel telephone = new JLabel(); 
 private JTextField name = new JTextField();
 private JButton period = new JButton();
 private StatusCombo serviceCycle = new StatusCombo();
 private AreaCombo area = new AreaCombo();

 //constructors
 public ListOfEntries() {
    setLayout(new GridLayout(2, 3));

    for (int x = 0; x == 2; x++) {         //worked until added
       telephone.setText(telephones[x]);   //worked until added
       name.setText(names[x]);             //worked until added
       period.setText(periods[x]);         //worked until added
       add(telephone);         
       add(name);
       add(area);
       add(period);
       add(serviceCycle); }                //worked until add: "}"

 Border line = BorderFactory.createLineBorder(Color.BLACK);
 Border titled = BorderFactory.createTitledBorder(line, "Day: DD MMM YYYY");
 //setBorder(this.isVisible());
 setVisible(true); }
}
