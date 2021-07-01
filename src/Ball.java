import java.awt.*;

public class Ball {

    private double a1,a2,a3,a4,a5,a6,b, a, y;
    private Color color;

    private int type;

    private double x = -100;




    public Ball(double b, double a, double x1, Color c){

        type = 1;

        this.b = b;

        if((int)Math.round(Math.random()) == 1){

            this.a = a;

        }

        else{

            this.a = -1 * a;

        }
        a1 = x1;
        color = c;

    }

    public Ball(double b, double a, double x1, double x2, Color c){

        type = 2;

        if((int)Math.round(Math.random()) == 1){

            this.a = a;

        }

        else{

            this.a = -1 * a;

        }

        this.b = b;
        a1 = x1;
        a2 = x2;
        color = c;

    }

    public Ball(double b, double a, double x1, double x2, double x3, Color c){

        type = 3;

        this.b = b;

        if((int)Math.round(Math.random()) == 1){

            this.a = a;

        }

        else{

            this.a = -1 * a;

        }

        a1 = x1;
        a2 = x2;
        a3 = x3;
        color = c;

    }

    public Ball(double b, double a,  double x1, double x2, double x3, double x4, Color c){

        type = 4;
        this.b = b;

        if((int)Math.round(Math.random()) == 1){

            this.a = a;

        }

        else{

            this.a = -1 * a;

        }

        a1 = x1;
        a2 = x2;
        a3 = x3;
        a4 = x4;
        color = c;

    }

    public Ball(double b, double a, double x1, double x2, double x3,double x4, double x5, Color c){

        type = 5;
        this.b = b;

        if((int)Math.round(Math.random()) == 1){

            this.a = a;

        }

        else{

            this.a = -1 * a;

        }

        a1 = x1;
        a2 = x2;
        a3 = x3;
        a4 = x4;
        a5 = x5;
        color = c;

    }

    public Ball(double b, double a, double x1, double x2, double x3,double x4, double x5, double x6, Color c){

        type = 6;
        this.b = b;

        if((int)Math.round(Math.random()) == 1){

            this.a = a;

        }

        else{

            this.a = -1 * a;

        }

        a1 = x1;
        a2 = x2;
        a3 = x3;
        a4 = x4;
        a5 = x5;
        a6 = x6;
        color = c;

    }

    public void move(){

        x += 5;

        if(type == 1){


            y = a/10 * (x - a1) + b;

        }

        if(type == 2){

            y = (a/Math.pow(10,3.2) * ((x - a1) * (x - a2))) + b;

        }

        if(type == 3){

            y = (a/Math.pow(10, 6.5) * ((x - a1) * (x - a2) * (x - a3))) + b;

        }

        if(type == 4){

            y = (a/(Math.pow(10, 7.5) + Math.pow(a1, 2.5) + Math.pow(a2, 2.5) + Math.pow(a3, 2.5) + Math.pow(a4, 2.5)) * ((x - a1) * (x - a2) * (x - a3) * (x - a4))) + b;

        }

        if(type == 5){

            y = (a/(Math.pow(10, 0) + Math.pow(a1, 3.4) + Math.pow(a2, 3.4) + Math.pow(a3, 3.4) + Math.pow(a4, 3.4) + Math.pow(a5, 3.4)) * ((x - a1) * (x - a2) * (x - a3) * (x - a4) * (x - a5))) + b;

        }

        if(type == 6){

            y = (a/(Math.pow(10, 13.3) +(Math.pow(a1, 4) + Math.pow(a2, 4) + Math.pow(a3, 4) + Math.pow(a4, 4) + Math.pow(a5, 4)) + Math.pow(a6, 4)) * ((x - a1) * (x - a2) * (x - a3) * (x - a4) * (x - a5) * (a - a6))) + b;

        }

    }

    public double getX(){

        return x;

    }

    public double getY(){

        return y;

    }

    public Color getColor(){

        return color;

    }

}
