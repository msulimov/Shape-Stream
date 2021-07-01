import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class ColorPanel extends JPanel {

    private JSlider rainbowSlider = new JSlider(SwingConstants.HORIZONTAL, 10, 400, 50);
    private JSlider redSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 255);
    private JSlider greenSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 255);
    private JSlider blueSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 255, 255);
    private JButton rainbowButton = new JButton();

    Hashtable redTable = new Hashtable();
    Hashtable greenTable = new Hashtable();
    Hashtable blueTable = new Hashtable();
    Hashtable rainbowTable = new Hashtable();

    private Timer paintTimer = new Timer(1, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

           if(colorType.getSelectedItem().equals("Rainbow Colors")){ setBackground(new Color(BallApplet.ball.getRed(), BallApplet.ball.getGreen(), BallApplet.ball.getBlue()));}

           else if(colorType.getSelectedItem().equals("Given Color")){

                int grayscale = Math.abs((getBackground().getRed() + getBackground().getGreen() + getBackground().getBlue())/3 - 255);

                autoUpdate.setForeground(new Color(grayscale, grayscale, grayscale));
                titleLabel.setForeground(new Color(grayscale, grayscale, grayscale));

           }

           else{setBackground(background);}

        }
    });

    private JLabel redLabel = new JLabel("255");
    private JLabel greenLabel = new JLabel("255");
    private JLabel blueLabel = new JLabel("255");
    private JLabel titleLabel = new JLabel();

    private int red = 255;
    private int blue = 255;
    private int green = 255;

    private Color Red = new Color(244, 23, 23);
    private Color Green = new Color(40,244, 40);

    private JButton update = new JButton("Update");
    private JButton random = new JButton("Random Color");
    private JCheckBox autoUpdate = new JCheckBox("Auto Update?");

    private Font title = new Font("Arial", Font.BOLD, 40);
    private Font label = new Font("Arial", Font.PLAIN, 25);

    private Color background = new Color(80,80,80);

    private JComboBox colorType = new JComboBox(new String[]{"Rainbow Colors", "Random Colors", "Given Color"});

    public ColorPanel(int width, int height){

        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        //setSize(width, height);
        setPreferredSize(new Dimension(width, height));
        setBackground(background);

        properties();
        action();
        add1();
        paintTimer.start();

    }

    private void add1(){

        Dimension space = new Dimension(40,50);

        JLabel space1 = new JLabel();
        JLabel space2 = new JLabel();
        JLabel space3 = new JLabel();
        JLabel space4 = new JLabel();
        JLabel space5 = new JLabel();
        JLabel space6 = new JLabel();
        JLabel space7 = new JLabel();
        JLabel space8 = new JLabel();


        space1.setPreferredSize(space);
        space2.setPreferredSize(space);
        space3.setPreferredSize(space);
        space4.setPreferredSize(space);
        space5.setPreferredSize(space);
        space6.setPreferredSize(space);
        space7.setPreferredSize(space);
        space8.setPreferredSize(space);

        add(titleLabel);
        add(colorType);
        add(space1);
        add(rainbowSlider);
        add(redSlider);
        add(space2);
        add(redLabel);
        add(space3);
        add(greenSlider);
        add(space4);
        add(greenLabel);
        add(space5);
        add(blueSlider);
        add(space6);
        add(blueLabel);
        add(space7);
        add(autoUpdate);
        add(space8);
        add(update);
        add(rainbowButton);
        add(random);

        setGivenColorComponentVisible(false);

    }

    private void properties(){

        autoUpdate.setOpaque(false);
        rainbowButton.setPreferredSize(new Dimension(200,40));
        rainbowButton.setText("Change Rainbow Direction");

        redTable.put(0, new JLabel("0"));
        redTable.put(255/2, new JLabel("Red"));
        redTable.put(255, new JLabel("255"));

        greenTable.put(0, new JLabel("0"));
        greenTable.put(255/2, new JLabel("Green"));
        greenTable.put(255, new JLabel("255"));

        blueTable.put(0, new JLabel("0"));
        blueTable.put(255/2, new JLabel("Blue"));
        blueTable.put(255, new JLabel("255"));

        rainbowTable.put(rainbowSlider.getMinimum(), new JLabel("Slow"));
        rainbowTable.put(rainbowSlider.getMaximum()/2, new JLabel("Rainbow Cycle Speed"));
        rainbowTable.put(rainbowSlider.getMaximum(), new JLabel("Fast"));

        redSlider.setLabelTable(redTable);
        redSlider.setBackground(Color.red);
        redSlider.setPaintLabels(true);
        redSlider.setPreferredSize(new Dimension(200,40));
        redLabel.setBackground(Color.red);
        redLabel.setOpaque(true);
        redLabel.setPreferredSize(new Dimension(60,40));
        redLabel.setFont(label);
        redLabel.setHorizontalAlignment(SwingConstants.CENTER);

        greenSlider.setLabelTable(greenTable);
        greenSlider.setPaintLabels(true);
        greenSlider.setBackground(Color.green);
        greenSlider.setPreferredSize(new Dimension(200,40));
        greenLabel.setBackground(Color.green);
        greenLabel.setPreferredSize(new Dimension(60,40));
        greenLabel.setFont(label);
        greenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        greenLabel.setOpaque(true);

        blueSlider.setLabelTable(blueTable);
        blueSlider.setBackground(Color.blue);
        blueSlider.setPaintLabels(true);
        blueSlider.setPreferredSize(new Dimension(200,40));
        blueLabel.setBackground(Color.blue);
        blueLabel.setPreferredSize(new Dimension(60,40));
        blueLabel.setFont(label);
        blueLabel.setHorizontalAlignment(SwingConstants.CENTER);
        blueLabel.setOpaque(true);

        rainbowSlider.setLabelTable(rainbowTable);
        rainbowSlider.setPaintLabels(true);
        rainbowSlider.setPreferredSize(new Dimension(800, 40));

        update.setPreferredSize(new Dimension(100,40));
        update.setText("Apply");
        update.setBackground(Green);

        autoUpdate.setPreferredSize(new Dimension(140, 40));
        autoUpdate.setText("Auto Update");
        autoUpdate.setSelected(false);
        autoUpdate.setFont(new Font("Arial", Font.PLAIN, 18));
        autoUpdate.setForeground(Color.black);

        titleLabel.setPreferredSize(new Dimension(300,50));
        titleLabel.setForeground(Color.black);
        titleLabel.setText("Color Settings:");
        titleLabel.setFont(title);

        colorType.setSelectedIndex(0);
        colorType.setPreferredSize(new Dimension(140, 40));
    }

    private void action(){

        colorType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                BallApplet.ball.clearBalls();

                if(colorType.getSelectedItem().equals("Rainbow Colors")){

                    setGivenColorComponentVisible(false);
                    rainbowSlider.setVisible(true);
                    rainbowButton.setVisible(true);
                    BallApplet.ball.setColor(1);

                }

                else if(colorType.getSelectedItem().equals("Random Colors")){

                    rainbowSlider.setVisible(false);
                    rainbowButton.setVisible(false);
                    setGivenColorComponentVisible(false);
                    BallApplet.ball.setColor(2);


                }

                else if(colorType.getSelectedItem().equals("Given Color")){

                    setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
                    rainbowSlider.setVisible(false);
                    rainbowButton.setVisible(false);
                    setGivenColorComponentVisible(true);
                    BallApplet.ball.setColor(3);
                    setColor();

                }

            }
        });

        rainbowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                BallApplet.ball.changeRainbow();
                
            }
        });
        
        rainbowSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setColorDelay(Math.abs(rainbowSlider.getValue() - rainbowSlider.getMaximum() + 1));

            }
        });

        random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                redSlider.setValue((int)(Math.random() * 255 + 1));
                greenSlider.setValue((int)(Math.random() * 255 + 1));
                blueSlider.setValue((int)(Math.random() * 255 + 1));

                random.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));

                if(autoUpdate.isSelected()){

                    setColor();

                }
            }
        });

        redSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            red = redSlider.getValue();

            checkBackground();

            updateLabel();

            if(autoUpdate.isSelected()){

                setColor();

            }

            }
        });

        greenSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                green = greenSlider.getValue();

                checkBackground();

                updateLabel();

                if(autoUpdate.isSelected()){

                    setColor();

                }

            }
        });

        blueSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                blue = blueSlider.getValue();

                updateLabel();

                checkBackground();

                if(autoUpdate.isSelected()){

                    setColor();

                }

            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setColor();
                update.setBackground(Green);
                if(autoUpdate.isSelected()){

                    autoUpdate.setSelected(false);

                }

            }
        });

    }

    private void setColor(){

        BallApplet.ball.setRed(red);
        BallApplet.ball.setGreen(green);
        BallApplet.ball.setBlue(blue);

    }

    private void setGivenColorComponentVisible(boolean b){

        redSlider.setVisible(b);
        greenSlider.setVisible(b);
        blueSlider.setVisible(b);
        update.setVisible(b);
        autoUpdate.setVisible(b);
        redLabel.setVisible(b);
        greenLabel.setVisible(b);
        blueLabel.setVisible(b);
        random.setVisible(b);

    }

    private void updateLabel(){

       redLabel.setText(red + "");
       redSlider.setBackground(new Color (red, 0, 0));
       redSlider.setLabelTable(redTable);

       greenLabel.setText("" + green);
       greenSlider.setLabelTable(greenTable);
       greenSlider.setBackground(new Color(0, green, 0));

       blueLabel.setText(blue + "");
       blueSlider.setBackground(new Color(0,0, blue));
       blueSlider.setLabelTable(blueTable);

       setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));

    }

    public void checkBackground(){



            if(greenSlider.getValue() != BallApplet.ball.getGreen() || blueSlider.getValue() != BallApplet.ball.getBlue() || redSlider.getValue() != BallApplet.ball.getRed()){

                if(!autoUpdate.isSelected()) {

            update.setBackground(Red);}

        }

        else{

            update.setBackground(Green);

        }

    }
}
