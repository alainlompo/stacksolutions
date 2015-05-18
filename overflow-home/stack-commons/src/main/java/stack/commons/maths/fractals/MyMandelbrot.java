package stack.commons.maths.fractals;

import java.awt.Color;

import org.apache.commons.math3.complex.Complex;

public class MyMandelbrot {
	   
    public static int numberOfIterationsToCheck(Complex z0, int max) {
        Complex z = z0;
        for (int t = 0; t < max; t++) {
            if (z.abs() > 2.0) return t;
            z =z.multiply(z).add(z0);
        }
        return max;
    }

    public static void main(String[] args)  {
        double xc   = Double.parseDouble(args[0]);
        double yc   = Double.parseDouble(args[1]);
        double size = Double.parseDouble(args[2]);

        int N   = 512;   
        int max = 255;   

        Viewer viewer = new Viewer(N, N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
               
            	double x0 = xc - size/2 + size*i/N;
                double y0 = yc - size/2 + size*j/N;
                
                Complex z0 = new Complex(x0, y0);
                
                /*int gray = max - numberOfIterationsToCheck(z0, max);
                
                Color color = new Color(gray, gray, gray);
                if (z0.abs() > 2.0 ) {
                	
                	color = new Color(gray, 128, gray);
                } else if (z0.abs() > 2.0 && numberOfIterationsToCheck(z0, max) > max/2) {
                	color = new Color(255, gray, 255);
                } else  if (z0.abs() > 2.0 &&  numberOfIterationsToCheck(z0, max) < max/2) {
                	color = new Color(gray, 128,128);
                }
                
                else if (z0.abs() > 1.0 &&  numberOfIterationsToCheck(z0, max) < max/2 ) {
                	color = new Color(128, gray, 128);
                } else if (z0.abs() > 1.0) {
                	
                	color = new Color(128, gray, 128);
                }
                
                else if (z0.abs() <= 1.0) {
                	color = new Color(gray, gray, 128);
                }*/
                
                int escapeIterations = numberOfIterationsToCheck(z0, max);
                // set color varying hue based on escape iterations:
                Color color = Color.getHSBColor((float)escapeIterations * 2.0f / (float)max, 1.0f, 1.0f);
                
                viewer.set(i, N-1-j, color);
            }
        }
        viewer.show();
    }

}
