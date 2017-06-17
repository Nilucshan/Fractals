/**
 * Created by Nilucshan on 9/4/2016.
 * This is the Parent class to Mandelbrot and Julia
 */

import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FractalShape extends JPanel {

    //GUI parameters
    public static int WIDTH = 800;
    public static int HEIGHT = 800;
    public BufferedImage Image;//= new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    // public Canvas c2;

    public double reX1;               //Left corner corner in real axis
    public double reX2;               //Right corner in real axis
    public double imaY1;              //Bottom corner in imaginary axis
    public double imaY2;              //Top corner in imaginary axis
    public double iteration;          //No of iteration

    public FractalShape() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(Image, 0, 0, this);
    }

}
