package stack.commons.graphics.swing;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FrameII extends JPanel implements ActionListener {
	 
    private static final long serialVersionUID = 1L;
    static BufferedImage bufferedImage = null;  // Don't need to make this final
    static File file = null;  // Don't need to make this final
    private Image MeSmaller1;
    private Image MeSmaller2;
    protected Timer timer;
    private float alpha;
    
    private static FrameII workFrame;
    
    
    public static FrameII getWorkFrame() {
    	return workFrame;
    }
    
    public static void setWorkFrame(FrameII frame) {
    	
    	workFrame = frame;
    }

    JPanel pnlButton = new JPanel();
    static JButton btnStartBlend = new JButton("Start Blend");
    static JButton btnStopBlend = new JButton("Stop Blend");
    static JButton saveImage = new JButton("Save Image To File");

    public FrameII() {
           
            loadImages();
            initTimer();

            pnlButton.add(btnStartBlend);
            this.add(pnlButton);
            pnlButton.add(btnStopBlend);
            this.add(pnlButton);
            pnlButton.add(saveImage);
            this.add(pnlButton);

            addListeners();
    }
            // start button action listener
    public void addListeners() {
            btnStartBlend.addActionListener(new ActionListener() {
                   
                    public void actionPerformed(ActionEvent e) {
                            initTimer();
                            timer.start();

                            System.out.println("Timer started");
                    }
            });
            // stop button actionlistener
            btnStopBlend.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                            // initTimer();
                            timer.stop();

                            System.out.println("Timer stopped");
                    }
            });

            // Save button actionlistener
            saveImage.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent saveImage) {
                            save(bufferedImage, getWorkFrame());
                            System.out.println("Save image clicked");
                    }
            });
    }

    private void loadImages() {
            // I did my local test using
    		MeSmaller1 = new ImageIcon("C:\\Tests\\Alain_Lompo.jpg").getImage();
            MeSmaller2 = new ImageIcon("C:\\Tests\\Alain_Lompo.jpg").getImage();
            
            //MeSmaller1 = new ImageIcon("MeSmaller1.jpg").getImage();
            //MeSmaller2 = new ImageIcon("MeSmaller2.jpg").getImage();
    }

    public void initTimer() {

            timer = new Timer(1000, this);
            timer.start();
            timer.stop();
            alpha = 1f;
    }

    private void doDrawing(Graphics g) {
            Graphics2D g2Dim = (Graphics2D) g;
            // below sets the size of picture
            bufferedImage = new BufferedImage(400, 600,
                            BufferedImage.TYPE_INT_ARGB);
            Graphics2D gBuffI = bufferedImage.createGraphics();
            AlphaComposite aComp = AlphaComposite.getInstance(
                            AlphaComposite.SRC_OVER, alpha);
            // decides where images are drawn in JFrame
            gBuffI.drawImage(MeSmaller1, 28, 55, null);
            gBuffI.setComposite(aComp);
            gBuffI.drawImage(MeSmaller2, 30, 48, null);
            g2Dim.drawImage(bufferedImage, 10, 10, null);
    }

    
    
    public static String getFileToSaveTo(FrameII frame) {
    	JFileChooser fc=new JFileChooser("Save a file");
    	fc.setDialogTitle("Save a file...");
    	  int returnVal=fc.showOpenDialog(frame);
    	  
    	  if (returnVal == JFileChooser.APPROVE_OPTION) {
    	    return fc.getSelectedFile().getAbsolutePath();
    	  }
    	 else {
    	    return null;
    	  }
    }
   
    public static void save(BufferedImage img, FrameII frame) {
    	       	
//    	Scanner scan = new Scanner(System.in);
//    	System.out.println("Enter the file name: ");
//    	String fileFullPath = scan.next();
    	String fileFullPath = getFileToSaveTo(frame);
        file = new File(fileFullPath);
    	saveToFile(img, file);
    	
    }
   
    public static void saveToFile(BufferedImage img, File file) {
         String filename = file.getName();

         String suffix = filename.substring(filename.lastIndexOf('.') + 1);
         suffix = suffix.toLowerCase();

         if (suffix.equals("jpg") || suffix.equals("png")) {
             try { ImageIO.write(img, suffix, file); }
             catch (IOException e) { e.printStackTrace(); }
         }
        else {
            System.out.println("Error: filename must end in .jpg or .png");
        }

    }

     
    @Override
    public void paintComponent(Graphics g) {
            super.paintComponent(g);
            doDrawing(g);
    }

    public void actionPerformed(ActionEvent e) {
            alpha -= 0.1;
            if (alpha <= 0) {
                    alpha = 0;
                    timer.stop();
                    System.out.println("Morph Finished please restart.");
            }
            repaint();
    }
    
    public static void main(String[] args) {
    	JFrame theFrame = new JFrame("Testing catess...");
    	theFrame.setSize(400, 400);
    	FrameII fr = new FrameII();
    	theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	theFrame.add(fr, BorderLayout.CENTER);
    	theFrame.setVisible(true);
    	FrameII.setWorkFrame(fr);
    }
}