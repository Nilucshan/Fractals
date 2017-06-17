/**
 * Created by Nilucshan on 9/3/2016.
 * This includes the Implementation to draw the Mandelbrot.
 * Mandelbrot Declaration and Drawing method.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Mandelbrot extends FractalShape {

    //Creating MendelBrot set with given all 5 parameters
    public Mandelbrot(double reX1, double reX2, double imaY1, double imaY2, double iteration) {
        this.reX1 = reX1;
        this.reX2 = reX2;
        this.imaY1 = imaY1;
        this.imaY2 = imaY2;
        this.iteration = iteration;
        Image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
    }

    //Creating MendelBrot set with given 4 parameters
    public Mandelbrot(double reX1, double reX2, double imaY1, double imaY2) {
        this.reX1 = reX1;
        this.reX2 = reX2;
        this.imaY1 = imaY1;
        this.imaY2 = imaY2;
        this.iteration = 1000;
        Image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
    }

    //Default constructor for mandelbrot set
    public Mandelbrot() {
        this.reX1 = 1;
        this.reX2 = -1;
        this.imaY1 = 1;
        this.imaY2 = -1;
        this.iteration = 1000;
        Image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
    }

    //Convert the given pixel into complex co-ordinates
    public Complex convertToMap(double x, double y) {
        x = (x - WIDTH / 2.0) * ((reX1 - reX2) / WIDTH);
        y = (y - HEIGHT / 2.0) * ((imaY2 - imaY1) / HEIGHT);

        //converting into the complex plane(i.e: creating a complex number)
        Complex complexNo = new Complex(x, y);
        return complexNo;
    }

    //checking whether it is in the Mandelbrot set
    public boolean isIntheSet(double x, double y) {
        Complex z0 = new Complex(0, 0);
        Complex c = convertToMap(x, y);
        Complex zn;
        int i;

        for (i = 0; i < iteration; i++) {
            zn = z0.square().add(c);                //Setting the c in the equation Zn=Z0^2 + C
            z0 = zn;
            if (z0.absSquare() > 4) {               //If the ABS(Z0) < 2 the considered point is in the set
                return false;
            }
        }
        return true;                                //Default return true
    }

    //method to draw
    public void draw() {
        for (int i = 0; i < WIDTH; i++)
            for (int j = 0; j < HEIGHT; j++) {
                float s = 1200f;
                float b;
                if (isIntheSet(i, j)) {
                    Image.setRGB(i, j, Color.black.getRGB());
			//Image.setRGB(i, j, i);
                }
                else {
                    Image.setRGB(i, j, Color.RED.getRGB());
		}
            }

        // Set other Frame settings.
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        frame.setBounds(0, 0, WIDTH, HEIGHT);
        frame.setVisible(true);
    }
}
