import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BallPanel extends JPanel {

    private int diameter = 20;
    private int shape = 1;

    private double a1Center = 200;
    private double a1Max = 0;
    
    private double a2Center = 400;
    private double a2Max = 0;
    
    private double a3Center = 600;
    private double a3Max = 0;

    private double a4Center = 800;
    private double a4Max = 0;

    private double a5Center = 1000;
    private double a5Max = 0;

    private double a6Center = 1200;
    private double a6Max = 0;
    
    private double bCenter = 450;
    private double bMax = 0;

    private double slopeCenter = 1;
    private double slopeMax = 0;
    
    private int spawnDelay = 50;
    private int moveDelay = 5;
    private int colorDelay = 50;

    private int colorPos = 0;

    private int generation = 6;
    private int color = 1;

    private boolean forward = true;
    private int orientation = 0;

    private int red = 255;
    private int green = 255;
    private int blue = 255;

    private boolean on = true;
    private boolean paused = false;

    private Color[] colorList = new Color[1275];

    private Timer spawnTimer = new Timer(spawnDelay, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        if(!paused && on) {

            if (generation == 6) {
                balls.add(new Ball(getValue(bCenter, bMax), getValue(slopeCenter, slopeMax), getValue(a1Center, a1Max), getValue(a2Center, a2Max), getValue(a3Center, a3Max), getValue(a4Center, a4Max), getValue(a5Center, a5Max), getValue(a6Center, a6Max), getColor()));
            } else if (generation == 5) {

                balls.add(new Ball(getValue(bCenter, bMax), getValue(slopeCenter, slopeMax), getValue(a1Center, a1Max), getValue(a2Center, a2Max), getValue(a3Center, a3Max), getValue(a4Center, a4Max), getValue(a5Center, a5Max), getColor()));

            } else if (generation == 4) {

                balls.add(new Ball(getValue(bCenter, bMax), getValue(slopeCenter, slopeMax), getValue(a1Center, a1Max), getValue(a2Center, a2Max), getValue(a3Center, a3Max), getValue(a4Center, a4Max), getColor()));

            } else if (generation == 3) {

                balls.add(new Ball(getValue(bCenter, bMax), getValue(slopeCenter, slopeMax), getValue(a1Center, a1Max), getValue(a2Center, a2Max), getValue(a3Center, a3Max), getColor()));

            } else if (generation == 2) {

                balls.add(new Ball(getValue(bCenter, bMax), getValue(slopeCenter, slopeMax), getValue(a1Center, a1Max), getValue(a2Center, a2Max), getColor()));

            } else if (generation == 1) {

                balls.add(new Ball(getValue(bCenter, bMax), getValue(slopeCenter, slopeMax), getValue(a1Center, a1Max), getColor()));

            } else if (generation == 0) {

                generateRandomBall();

            }
        }
        }});
    
    
        
    
    private Timer moveTimer = new Timer(moveDelay, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(!paused){

            for(int i = 0; i < balls.size(); i++){

                balls.get(i).move();

            }

            repaint();

        }
        }
    });

    private Timer colorTimer = new Timer(colorDelay, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(!paused && on){

            if(colorPos == 1275 && forward){colorPos = 1;}

            else if(colorPos == 0){colorPos = 1274;}

            if(forward){

                colorPos++;

            }
            else{

               colorPos--;

            }


        }
        }
    });

    public BallPanel(int width, int height){

        setPreferredSize(new Dimension(width, height));
        fillColorList();

        moveTimer.start();
        spawnTimer.start();
        colorTimer.start();

    }

    private ArrayList<Ball> balls = new ArrayList<Ball>();

    public void paintComponent(Graphics g){

        g.setColor(Color.black);
        g.fillRect(0,0,getWidth(), getHeight());

        for(int i = 0; i < balls.size(); i++) {

            g.setColor(balls.get(i).getColor());


            if (outOfBounds(balls.get(i))) {

                balls.remove(i);

            }
            
            else{
                
                int x = round(balls.get(i).getX());
                int y = round(balls.get(i).getY());
                
                if (orientation == 0) {
                
                     if (shape == 0) {

                    g.drawOval(x, y, diameter, diameter);

                         } else if (shape == 1) {

                    g.fillOval(x, y, diameter, diameter);

                        } else if (shape == 2) {

                    g.drawRect(x, y, diameter, diameter);

                      } else if (shape == 3) {

                    g.fillRect(x, y, diameter, diameter);

                }
            } else if (orientation == 1) {

                if (shape == 0) {

                    g.drawOval(Math.abs(y), Math.abs(x - getHeight()), diameter, diameter);

                } else if (shape == 1) {

                    g.fillOval(Math.abs(y), Math.abs(x - getHeight()), diameter, diameter);

                } else if (shape == 2) {

                    g.drawRect(Math.abs(y), Math.abs(x - getHeight()), diameter, diameter);

                } else if (shape == 3) {

                    g.fillRect(Math.abs(y), Math.abs(x - getHeight()), diameter, diameter);
                }
            }

        }}
    }

    private void generateRandomBall(){
        
        int gen = (int)(Math.random() * 6 + 1);

        if(gen == 6){
            balls.add(new Ball(getValue(bCenter, bMax), getValue(slopeCenter, slopeMax), getValue(a1Center, a1Max), getValue(a2Center, a2Max), getValue(a3Center, a3Max), getValue(a4Center, a4Max), getValue(a5Center, a5Max), getValue(a6Center, a6Max), getColor() ));
        }

        else if(gen == 5){

            balls.add(new Ball(getValue(bCenter, bMax), getValue(slopeCenter, slopeMax), getValue(a1Center, a1Max), getValue(a2Center, a2Max), getValue(a3Center, a3Max), getValue(a4Center, a4Max), getValue(a5Center, a5Max), getColor() ));

        }

        else if(gen == 4){

            balls.add(new Ball(getValue(bCenter, bMax), getValue(slopeCenter, slopeMax), getValue(a1Center, a1Max), getValue(a2Center, a2Max), getValue(a3Center, a3Max), getValue(a4Center, a4Max), getColor() ));

        }

        else if(gen == 3){

            balls.add(new Ball(getValue(bCenter, bMax), getValue(slopeCenter, slopeMax), getValue(a1Center, a1Max), getValue(a2Center, a2Max), getValue(a3Center, a3Max), getColor() ));

        }

        else if(gen == 2){

            balls.add(new Ball(getValue(bCenter, bMax), getValue(slopeCenter, slopeMax), getValue(a1Center, a1Max), getValue(a2Center, a2Max), getColor() ));

        }

        else if(gen == 1){

            balls.add(new Ball(getValue(bCenter, bMax), getValue(slopeCenter, slopeMax), getValue(a1Center, a1Max), getColor() ));

        }

    }    

    public void setOrientation(int num){
        
        orientation = num;
        
    }
    
    public void setRed(int red) {
        this.red = red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public void changeRainbow(){

       forward = !forward;

    }

    public double getValue(double center, double max){

       int x;

        if(round(Math.random()) == 1){

            x = 1;

        }

        else{

            x = -1;

        }

        return center + (x * Math.random() * max);

    }

    private int round(double a){

        return (int)Math.round(a);

    }

    public void clearBalls(){

        balls.clear();
        repaint();

    }

    public boolean outOfBounds(Ball ball){

        if(orientation == 0){

        return ball.getX() >= 1700;}

        else{

            return ball.getX() > 2000;

        }

    }

    public void setSpawnDelay(int delay){

        spawnTimer.setDelay(delay);

    }

    public void setOn(boolean b){

        on = b;

    }


    public void setPaused(boolean b){

       paused = b;

    }

    public void setA1Center(double a1Center) {
        this.a1Center = a1Center;
    }

    public void setA1Max(double a1Max) {
        this.a1Max = a1Max;
    }

    public void setA2Center(double a2Center) {
        this.a2Center = a2Center;
    }

    public void setA2Max(double a2Max) {
        this.a2Max = a2Max;
    }

    public void setA3Center(double a3Center) {
        this.a3Center = a3Center;
    }

    public void setA3Max(double a3Max) {
        this.a3Max = a3Max;
    }

    public void setA4Center(double a4Center) {
        this.a4Center = a4Center;
    }

    public void setA4Max(double a4Max) {
        this.a4Max = a4Max;
    }

    public void setA5Center(double a5Center) {
        this.a5Center = a5Center;
    }

    public void setA5Max(double a5Max) {
        this.a5Max = a5Max;
    }

    public void setA6Center(double a6Center) {
        this.a6Center = a6Center;
    }

    public void setA6Max(double a6Max) {
        this.a6Max = a6Max;
    }

    public void setbCenter(double bCenter) {
        this.bCenter = bCenter;
    }

    public void setbMax(double bMax) {
        this.bMax = bMax;
    }

    public void setSlopeCenter(double slopeCenter) {
        this.slopeCenter = slopeCenter;
    }

    public void setSlopeMax(double slopeMax) {
        this.slopeMax = slopeMax;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public void setShape(int shape){this.shape = shape;}

    public void setDiameter(int diam){this.diameter = diam;}

    public void setColorDelay(int delay){

        colorTimer.setDelay(delay);

    }

    public void setMoveDelay(int delay){

        moveTimer.setDelay(delay); 

    }

    public void setColor(int color){

        this.color = color;

    }

    private Color getColor(){

        if(color == 1) {

            colorTimer.start();

            red = colorList[Math.abs(colorPos % 1275)].getRed();
            green = colorList[Math.abs(colorPos % 1275)].getGreen();
            blue = colorList[Math.abs(colorPos % 1275)].getBlue();

           return new Color(red,green,blue);

        }

        if(color == 2){

            colorTimer.stop();
            
            red = (int)(Math.random() * 256);
            green = (int)(Math.random() * 256);
            blue = (int)(Math.random() * 256 );
            
            return new Color(red, green, blue);

        }
        
        else{
            colorTimer.stop();
            return new Color(red, green, blue);
        }
    }

    private void fillColorList(){

        for(int i = 0; i < 1275; i++){

            if(i<255){

                colorList[i] = new Color(255,i % 255,0);

            }

            else if(i<510){

                colorList[i] = new Color(255 - (i % 255),255,0);

            }

            else if(i<765){

                colorList[i] = new Color(0,255,i % 255);

            }

            else if(i<1020){

                colorList[i] = new Color(0,255 - (i % 255),255);

            }

            else if(i<1275){

                colorList[i] = new Color(i % 255,0,255 - (i % 255));

            }
            
        }

    }

}
