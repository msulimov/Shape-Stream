import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class ControlPanel extends JPanel {

    private Dimension slider = new Dimension(300,40);
    private Dimension label = new Dimension(300,30);
    
    private JSlider bCenter = new JSlider(SwingConstants.HORIZONTAL, 0, 900, 450);
    private JSlider bMax = new JSlider(SwingConstants.HORIZONTAL, 0, 450, 0);

    private JSlider slopeCenter = new JSlider(SwingConstants.HORIZONTAL,0, 100000, 10000);
    private JSlider slopeMax = new JSlider(SwingConstants.HORIZONTAL,0,1000,0);

    private JSlider x1Center = new JSlider(SwingConstants.HORIZONTAL,0,1700,200);
    private JSlider x1Max = new JSlider(SwingConstants.HORIZONTAL,0,300,0);

    private JSlider x2Center = new JSlider(SwingConstants.HORIZONTAL,0,1700,400);
    private JSlider x2Max = new JSlider(SwingConstants.HORIZONTAL,0,300,0);

    private JSlider x3Center = new JSlider(SwingConstants.HORIZONTAL,0,1700,600);
    private JSlider x3Max = new JSlider(SwingConstants.HORIZONTAL,0,300,0);

    private JSlider x4Center = new JSlider(SwingConstants.HORIZONTAL,0,1700,800);
    private JSlider x4Max = new JSlider(SwingConstants.HORIZONTAL,0,300,0);

    private JSlider x5Center = new JSlider(SwingConstants.HORIZONTAL,0,1700,1000);
    private JSlider x5Max = new JSlider(SwingConstants.HORIZONTAL,0,300,0);

    private JSlider x6Center = new JSlider(SwingConstants.HORIZONTAL,0,1700,1200);
    private JSlider x6Max = new JSlider(SwingConstants.HORIZONTAL,0,300,0);

    private final Color grey1 = new Color(150, 150, 150);
    private final Color grey2 = new Color(110, 110, 110);
    private final Color grey3 = new Color(164, 164, 164);
    private final Color grey4 = new Color(99, 99, 99);

    JLabel x1Label = new JLabel();
    JLabel x2Label = new JLabel();
    JLabel x3Label = new JLabel();
    JLabel x4Label = new JLabel();
    JLabel x5Label = new JLabel();
    JLabel x6Label = new JLabel();
    JLabel x7Label = new JLabel();

    private JMenuBar menuBar = new JMenuBar();
    private JMenu generationType = new JMenu("Hexic");
    private JMenu orientation = new JMenu("Horizontal");

    private JRadioButtonMenuItem x1 = new JRadioButtonMenuItem("Linear");
    private JRadioButtonMenuItem x2 = new JRadioButtonMenuItem("Parabolic");
    private JRadioButtonMenuItem x3 = new JRadioButtonMenuItem("Cubic");
    private JRadioButtonMenuItem x4 = new JRadioButtonMenuItem("Quartic");
    private JRadioButtonMenuItem x5 = new JRadioButtonMenuItem("Quintic");
    private JRadioButtonMenuItem x6 = new JRadioButtonMenuItem("Hexic");
    private JRadioButtonMenuItem all = new JRadioButtonMenuItem("All");
    private JRadioButtonMenuItem h = new JRadioButtonMenuItem("Horizontal Based Rendering");
    private JRadioButtonMenuItem v = new JRadioButtonMenuItem("Vertex Based Rendering");

    private Color background = new Color(37, 37, 37);

    public ControlPanel(int width, int height){

        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        setPreferredSize(new Dimension(width, height));



        properties();
        actions();
        add1();

        setBackground(background);

    }

    public void actions(){


        slopeCenter.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setSlopeCenter(slopeCenter.getValue() / 10000.0);

            }
        });

        slopeMax.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            BallApplet.ball.setSlopeMax(slopeMax.getValue() / 100.0);

            }
        });

        x1Center.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                
                BallApplet.ball.setA1Center(x1Center.getValue());
                
            }
        });   
        
        x1Max.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                
                BallApplet.ball.setA1Max(x1Max.getValue());
                
            }
        });

        x2Center.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setA2Center(x2Center.getValue());

            }
        });

        x2Max.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setA2Max(x2Max.getValue());

            }
        });

        x3Center.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setA3Center(x3Center.getValue());

            }
        });

        x3Max.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setA3Max(x3Max.getValue());

            }
        });

        x4Center.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setA4Center(x4Center.getValue());

            }
        });

        x4Max.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setA4Max(x4Max.getValue());

            }
        });

        x5Center.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setA5Center(x5Center.getValue());

            }
        });

        x5Max.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setA5Max(x5Max.getValue());

            }
        });

        x6Center.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setA6Center(x6Center.getValue());

            }
        });

        x6Max.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setA6Max(x6Max.getValue());

            }
        });

        bCenter.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setbCenter(Math.abs(bCenter.getValue() - bCenter.getMaximum()));

            }
        });

        bMax.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setbMax(bMax.getValue());

            }
        });

        x1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                BallApplet.ball.clearBalls();

                setVisible(true, false, false, false, false, false);
                setSelected(true, false, false, false, false, false, false);
                generationType.setText("Linear");
                BallApplet.ball.setGeneration(1);

            }
        });

        x2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                setVisible(true, true, false, false, false, false);
                setSelected(false, true, false, false, false, false, false);
                generationType.setText("Parabolic");
                BallApplet.ball.setGeneration(2);

            }
        });

        x3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(true, true, true, false, false, false);
                setSelected(false, false, true, false, false, false, false);
                generationType.setText("Cubic");
                BallApplet.ball.setGeneration(3);

            }
        });

        x4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(true, true, true, true, false, false);
                setSelected(false, false, false, true, false, false, false);
                generationType.setText("Quartic");
                BallApplet.ball.setGeneration(4);

            }
        });

        x5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(true, true, true, true, true, false);
                setSelected(false, false, false, false, true, false, false);
                generationType.setText("Quintic");
                BallApplet.ball.setGeneration(5);

            }
        });

        x6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(true, true, true, true, true, true);
                setSelected(false, false, false, false, false, true, false);
                generationType.setText("Hexic");
                BallApplet.ball.setGeneration(6);

            }
        });

        all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setVisible(true, true, true, true, true, true);
                setSelected(false, false, false, false, false, false, true);
                generationType.setText("Linear - Hexic");
                BallApplet.ball.setGeneration(0);

            }
        });

        v.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                h.setSelected(false);
                orientation.setText("Vertical");
                BallApplet.ball.setOrientation(1);

            }
        });

        h.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                v.setSelected(false);
                orientation.setText("Horizontal");
                BallApplet.ball.setOrientation(0);

            }
        });

    }


    public void properties(){

        x6.setSelected(true);
        h.setSelected(true);

        Hashtable bCenterTable = new Hashtable();
        bCenterTable.put(bCenter.getMinimum(), new JLabel("Low"));
        bCenterTable.put(bCenter.getMaximum()/2, new JLabel("Origin Center"));
        bCenterTable.put(bCenter.getMaximum(), new JLabel("High"));
        bCenter.setLabelTable(bCenterTable);
        bCenter.setPreferredSize(new Dimension(slider));
        bCenter.setPaintLabels(true);
        bCenter.setBackground(grey4);

        Hashtable bMaxTable = new Hashtable();
        bMaxTable.put(bMax.getMinimum(), new JLabel("Less"));
        bMaxTable.put(bMax.getMaximum()/2, new JLabel("Origin Deviation"));
        bMaxTable.put(bMax.getMaximum(), new JLabel("More"));
        bMax.setLabelTable(bMaxTable);
        bMax.setPreferredSize(slider);
        bMax.setPaintLabels(true);
        bMax.setBackground(grey4);
        
        Hashtable slopeCenterTable = new Hashtable();
        slopeCenterTable.put(slopeCenter.getMinimum(), new JLabel("Shallow"));
        slopeCenterTable.put(slopeCenter.getMaximum()/2, new JLabel("Slope Steepness Center"));
        slopeCenterTable.put(slopeCenter.getMaximum(), new JLabel("Deep"));
        slopeCenter.setLabelTable(slopeCenterTable);
        slopeCenter.setPreferredSize(new Dimension(slider));
        slopeCenter.setPaintLabels(true);
        slopeCenter.setBackground(grey3);

        Hashtable slopeMaxTable = new Hashtable();
        slopeMaxTable.put(slopeMax.getMinimum(), new JLabel("Less"));
        slopeMaxTable.put(slopeMax.getMaximum()/2, new JLabel("Slope Steepness Deviation"));
        slopeMaxTable.put(slopeMax.getMaximum(), new JLabel("More"));
        slopeMax.setLabelTable(slopeMaxTable);
        slopeMax.setPreferredSize(slider);
        slopeMax.setPaintLabels(true);
        slopeMax.setBackground(grey3);

        Hashtable xCenterTable = new Hashtable();
        xCenterTable.put(x1Center.getMinimum(), new JLabel("Left"));
        xCenterTable.put(x1Center.getMaximum()/2, new JLabel("Zero Center"));
        xCenterTable.put(x1Center.getMaximum(), new JLabel("Right"));

        Hashtable xMaxTable = new Hashtable();
        xMaxTable.put(x1Max.getMinimum(), new JLabel("Less"));
        xMaxTable.put(x1Max.getMaximum()/2, new JLabel("Zero Deviation"));
        xMaxTable.put(x1Max.getMaximum(), new JLabel("More"));


        x1Center.setLabelTable(xCenterTable);
        x1Center.setPreferredSize(slider);
        x1Center.setPaintLabels(true);
        x1Center.setBackground(grey1);

        x2Center.setLabelTable(xCenterTable);
        x2Center.setPreferredSize(slider);
        x2Center.setPaintLabels(true);
        x2Center.setBackground(grey2);

        x3Center.setLabelTable(xCenterTable);
        x3Center.setPreferredSize(slider);
        x3Center.setPaintLabels(true);
        x3Center.setBackground(grey1);

        x4Center.setLabelTable(xCenterTable);
        x4Center.setPreferredSize(slider);
        x4Center.setPaintLabels(true);
        x4Center.setBackground(grey2);

        x5Center.setLabelTable(xCenterTable);
        x5Center.setPreferredSize(slider);
        x5Center.setPaintLabels(true);
        x5Center.setBackground(grey1);
        
        x6Center.setLabelTable(xCenterTable);
        x6Center.setPreferredSize(slider);
        x6Center.setPaintLabels(true);
        x6Center.setBackground(grey2);

        x1Label.setPreferredSize(label);
        x2Label.setPreferredSize(label);
        x3Label.setPreferredSize(label);
        x4Label.setPreferredSize(label);
        x5Label.setPreferredSize(label);
        x6Label.setPreferredSize(new Dimension(300,60));
        x7Label.setPreferredSize(label);
        
        x1Max.setLabelTable(xMaxTable);
        x1Max.setPreferredSize(slider);
        x1Max.setPaintLabels(true);
        x1Max.setBackground(grey1);

        x2Max.setLabelTable(xMaxTable);
        x2Max.setPreferredSize(slider);
        x2Max.setPaintLabels(true);
        x2Max.setBackground(grey2);

        x3Max.setLabelTable(xMaxTable);
        x3Max.setPreferredSize(slider);
        x3Max.setPaintLabels(true);
        x3Max.setBackground(grey1);

        x4Max.setLabelTable(xMaxTable);
        x4Max.setPreferredSize(slider);
        x4Max.setPaintLabels(true);
        x4Max.setBackground(grey2);

        x5Max.setLabelTable(xMaxTable);
        x5Max.setPreferredSize(slider);
        x5Max.setPaintLabels(true);
        x5Max.setBackground(grey1);

        x6Max.setLabelTable(xMaxTable);
        x6Max.setPreferredSize(slider);
        x6Max.setPaintLabels(true);
        x6Max.setBackground(grey2);

        
        menuBar.setPreferredSize(new Dimension(300, 20));
        menuBar.setVisible(true);

        generationType.setPreferredSize(new Dimension(150, 40));
        orientation.setPreferredSize(new Dimension(150, 40));

        generationType.add(x1);
        generationType.add(x2);
        generationType.add(x3);
        generationType.add(x4);
        generationType.add(x5);
        generationType.add(x6);
        generationType.add(all);
        orientation.add(h);
        orientation.add(v);

        menuBar.add(generationType);
        menuBar.add(orientation);
    }

    private void add1(){

        add(menuBar);

        add(x1Center);
        add(x1Max);
        add(x1Label);

        add(x2Center);
        add(x2Max);
        add(x2Label);

        add(x3Center);
        add(x3Max);
        add(x3Label);

        add(x4Center);
        add(x4Max);
        add(x4Label);

        add(x5Center);
        add(x5Max);
        add(x5Label);

        add(x6Center);
        add(x6Max);
        add(x6Label);

        add(slopeCenter);
        add(slopeMax);
        add(x7Label);

        add(bCenter);
        add(bMax);

    }
    
    public void setVisible(boolean b1, boolean b2, boolean b3, boolean b4, boolean b5, boolean b6){

        BallApplet.ball.clearBalls();
        x1Center.setVisible(b1);
        x1Max.setVisible(b1);
        x2Center.setVisible(b2);
        x2Max.setVisible(b2);
        x3Center.setVisible(b3);
        x3Max.setVisible(b3);
        x4Center.setVisible(b4);
        x4Max.setVisible(b4);
        x5Center.setVisible(b5);
        x5Max.setVisible(b5);
        x6Center.setVisible(b6);
        x6Max.setVisible(b6);

    }

    public void setSelected(boolean b1, boolean b2, boolean b3, boolean b4, boolean b5, boolean b6, boolean b7){

        x1.setSelected(b1);
        x2.setSelected(b2);
        x3.setSelected(b3);
        x4.setSelected(b4);
        x5.setSelected(b5);
        x6.setSelected(b6);
        all.setSelected(b7);

    }

}
