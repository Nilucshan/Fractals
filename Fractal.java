/**
 * Created by Nilucshan on 9/4/2016.
 */

import javax.swing.*;
import java.util.Scanner;

public class Fractal extends JPanel {

    public static void main(String[] args) {
        int count = args.length;                //getting the argument length

        //If user wants a Mandelbrot set
        if (args[0].equalsIgnoreCase("mandelbrot")) {

            //Creating the corresponding set according to no of arguments
            Mandelbrot mandelbrot;// = new Mandelbrot();
            if (count == 1) {
                mandelbrot = new Mandelbrot();
                mandelbrot.draw();
            } else if (count == 5) {
                mandelbrot = new Mandelbrot(Double.parseDouble(args[2]), Double.parseDouble(args[1]), Double.parseDouble(args[4]), Double.parseDouble(args[3]));
                mandelbrot.draw();
            } else if (count == 6) {
                mandelbrot = new Mandelbrot(Double.parseDouble(args[2]), Double.parseDouble(args[1]), Double.parseDouble(args[4]), Double.parseDouble(args[3]), Double.parseDouble(args[5]));
                mandelbrot.draw();
            } else {
                System.out.println("There is an Error in input");
            }

        }

        //If user want a Julia set
        else if (args[0].equalsIgnoreCase("julia")) {
            Julia julia;// = new Julia(-0.4, 0.6);
            if (count == 1) {
                julia = new Julia(-0.4, 0.6);
                julia.draw();
            } else if (count == 3) {
                julia = new Julia(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                julia.draw();
            } else {
                System.out.println("There is an Error in input");
            }
        }

        //If something went wrong with the input format
        else {
            System.out.println("Error  in the input format.Please give a valid input.");
            System.out.println("If you are unaware of How to use this program please type Help in the terminal, to know about the Author pls type author");
            Scanner HelpMe = new Scanner(System.in);
            String helpMe = HelpMe.nextLine();
            if (helpMe.equalsIgnoreCase("help")) {
                System.out.println("Follow below Steps for a Default implementation");
                System.out.println("If MANDELBROT => java Fractal Mandelbrot");
                System.out.println("If MANDELBROT => java Fractal Julia");
		System.out.println("For a Sample Image type : java Fractal Mandelbrot -1 1 -1 1 1000 & java Julia");
                System.out.println("Mail to tonilucshan@gmail.com");
            } else if (helpMe.equalsIgnoreCase("Author")) {
                System.out.println("Siva Nilucshan");
                System.out.println("Contact through tonilucshan@gmail.com");
            }
            }
        }

    }





