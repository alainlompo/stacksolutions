package stack.commons.maths.fractals;


import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Viewer {
	
	private BufferedImage image;               
    private JFrame frame;  
    private boolean isOriginUpperLeft = true;  
    private final int width, height;          
    
    public Viewer(int width, int height) {
        if (width  < 0) throw new IllegalArgumentException("width must be nonnegative");
        if (height < 0) throw new IllegalArgumentException("height must be nonnegative");
        this.width  = width;
        this.height = height;
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
    }
    
    public void setOriginUpperLeft() {
        isOriginUpperLeft = true;
    }
    
    public void setOriginLowerLeft() {
        isOriginUpperLeft = false;
    }

    
    public JLabel getJLabel() {
        if (image == null) { return null; }         // no image available
        ImageIcon icon = new ImageIcon(image);
        return new JLabel(icon);
    }
    
    public void show() {

        
        if (frame == null) {
            frame = new JFrame();

            frame.setContentPane(getJLabel());
            
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            frame.setResizable(false);
            frame.pack();
            frame.setVisible(true);
        }

        // draw
        frame.repaint();
    }
    
    public int height() {
        return height;
    }
    
    public int width() {
        return width;
    }
    
    public Color get(int col, int row) {
        if (col < 0 || col >= width())  throw new IndexOutOfBoundsException("col must be between 0 and " + (width()-1));
        if (row < 0 || row >= height()) throw new IndexOutOfBoundsException("row must be between 0 and " + (height()-1));
        if (isOriginUpperLeft) return new Color(image.getRGB(col, row));
        else                   return new Color(image.getRGB(col, height - row - 1));
    }
    
    public void set(int col, int row, Color color) {
        if (col < 0 || col >= width())  throw new IndexOutOfBoundsException("col must be between 0 and " + (width()-1));
        if (row < 0 || row >= height()) throw new IndexOutOfBoundsException("row must be between 0 and " + (height()-1));
        if (color == null) throw new NullPointerException("can't set Color to null");
        if (isOriginUpperLeft) image.setRGB(col, row, color.getRGB());
        else                   image.setRGB(col, height - row - 1, color.getRGB());
    }
    
    
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        Viewer that = (Viewer) obj;
        if (this.width()  != that.width())  return false;
        if (this.height() != that.height()) return false;
        for (int col = 0; col < width(); col++)
            for (int row = 0; row < height(); row++)
                if (!this.get(col, row).equals(that.get(col, row))) return false;
        return true;
    }
    
   

}
