/**
 * Created by Nilucshan on 9/3/2016.
 * This class is created in order to bring the concept of imaginary numbers
 * Basic addition and square and absolute value are defined here
 */

public class Complex {
    private double x;               //Considering the precision loss in mathematical operations it is set as double variables
    private double y;

    public Complex(double realPart,double imaginaryPart) {
        x=realPart;
        y=imaginaryPart;
    }

    //ADDITION=>Method will be called on a Complex number
    public Complex add(Complex argument2){
        return new Complex(x+(argument2.x),y+(argument2.y));
    }

    //SQUARE OF ABSOLUTE VALUE
    public double absSquare(){
        return ((x*x)+(y*y));
    }

    //SQUARE OF THE COMPLEX NUMBER
    public Complex square(){
        return new Complex((x*x)-(y*y),2*x*y);
    }

    //GETTING REAL PART
    public double getReal(){
        return x;
    }

    //GETTING IMAGINARY PART
    public double getImaginary(){
        return y;
    }

    //TO STRING METHOD
    public String toString() {
        if (y==0) {
            return ""+x;
        }
        if (y>0) {
            return ""+x+"+"+y+"*I";
        }
        return ""+x+"-"+(-y)+"*I";
    }
}
