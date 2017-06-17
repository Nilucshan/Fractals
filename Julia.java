/**
 * Created by Nilucshan on 9/3/2016.
 * This includes the Implementation to draw the Julia.
 * Julia Declaration and Drawing method.
 */

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Julia extends FractalShape {

    private Complex c;

    public Julia(double x, double y) {
        this.reX1 = -1;
        this.reX2 = 1;
        this.imaY1 = 1;
        this.imaY2 = -1;
        this.iteration = 1000;
        this.c = new Complex(x, y);
        Image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    }

    //Setting up the z0 in the complex plane
    public Complex convertToMap(double x, double y) {
        x = (x - WIDTH / 2.0) * ((reX1 - reX2) / WIDTH);
        y = (y - HEIGHT / 2.0) * ((imaY2 - imaY1) / HEIGHT);

        //converting into the complex plane(i.e: creating a complex number)
        Complex complexNo = new Complex(x, y);
        return complexNo;
    }

    //checking wether it in the julia set
    public int isIntheSet(double x, double y) {
        Complex z0 = convertToMap(x, y);
        Complex zn;// = new Complex(-0.25,0.754);
        int i;
        for (i = 0; i < iteration; i++) {
            zn = z0.square().add(c);
            z0 = zn;
            if (z0.absSquare() > 4) {
                return i;
            }
        }
        return i;
    }


    //method to draw the shape
    public void draw() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Image.setRGB(i, j, isIntheSet(i, j));
            }
        }
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this);
        frame.setBounds(0, 0, WIDTH, HEIGHT);
        frame.setVisible(true);
    }

    //@Override
    //protected void paintComponent(Graphics g) {
      //  g.drawImage(Image, 0, 0, this);
    //}
}

