import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class BallApplet extends JApplet{

    private static final int WIDTH = 1900;
    private static final int HEIGHT = 1000;

    private JButton on = new JButton("On");
    private JButton clear = new JButton("Clear");
    private JButton pause = new JButton("Pause");

    private Dimension slider = new Dimension(370,50);

    private boolean off = false;
    private boolean paused = false;

    private JSlider speedSlider = new JSlider(SwingConstants.HORIZONTAL,1, 50, 5);
    private JSlider spawnSlider = new JSlider(SwingConstants.HORIZONTAL, 1, 200, 50);
    private JSlider sizeSlider = new JSlider(SwingConstants.HORIZONTAL, 1, 100, 20);

    private JComboBox shapes = new JComboBox(new String[]{"Filled Circle", "Hollow Circle", "Filled Square", "Hollow Square"});
    private JLabel titleLabel = new JLabel("Main Settings:");

    private Font title = new Font("Arial", Font.BOLD, 40);

    public static BallPanel ball = new BallPanel(WIDTH - 300, HEIGHT - 100);
    public static ControlPanel control = new ControlPanel(300, HEIGHT - 100);
    public static ColorPanel color = new ColorPanel(WIDTH, 50);

    public void init(){
        setSize(WIDTH, HEIGHT);
        getContentPane().setBackground(new Color(40,40,40));

        setLayout(new FlowLayout(FlowLayout.LEFT, 0 , 0));

        getContentPane().add(ball);
        getContentPane().add(control);
        getContentPane().add(color);

        properties();
        add1();


    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//                    ex.printStackTrace();
//                }
//
//                JFrame frame = new JFrame("Testing");
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.add(new BallApplet());
//                frame.pack();
//                frame.setLocationRelativeTo(null);
//                frame.setVisible(true);
//            }
//        });
//    }

    private void properties(){

        on.setPreferredSize(new Dimension(60,50));
        on.setBackground(new Color(81,220, 57));
        on.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!off ){

                    off = true;
                    ball.setOn(false);
                    on.setText("Off");
                    on.setBackground(new Color(240, 66, 49));

                }

                else {

                    off = false;
                    ball.setOn(true);
                    on.setText("On");
                    on.setBackground(new Color(81,220,57));

                    }
                }


        });

        clear.setPreferredSize(new Dimension(80,50));
        clear.setBackground(new Color(26, 147, 230));
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ball.clearBalls();

            }
        });

        pause.setPreferredSize(new Dimension(90,50));
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(paused){

                    paused = false;
                    ball.setPaused(false);
                    pause.setText("Pause");

                }

                else{

                    paused = true;
                    ball.setPaused(true);
                    pause.setText("Resume");}

            }
        });
        
        Hashtable speedTable = new Hashtable();
        speedTable.put(speedSlider.getMinimum(), new JLabel("Slow"));
        speedTable.put(speedSlider.getMaximum()/2, new JLabel("Speed"));
        speedTable.put(speedSlider.getMaximum(), new JLabel("Fast"));
        speedSlider.setLabelTable(speedTable);
        speedSlider.setPreferredSize(slider);
        speedSlider.setPaintLabels(true);
        speedSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                
                ball.setMoveDelay(Math.abs(speedSlider.getValue() - speedSlider.getMaximum() + 1));
                
            }
        });

        Hashtable spawnTable = new Hashtable();
        spawnTable.put(spawnSlider.getMinimum(), new JLabel("Slow"));
        spawnTable.put(spawnSlider.getMaximum()/2, new JLabel("Spawn Rate"));
        spawnTable.put(spawnSlider.getMaximum(), new JLabel("Fast"));
        spawnSlider.setLabelTable(spawnTable);
        spawnSlider.setPreferredSize(slider);
        spawnSlider.setPaintLabels(true);
        spawnSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                ball.setSpawnDelay(Math.abs(spawnSlider.getValue() - spawnSlider.getMaximum()) + 1);

            }
        });

        Hashtable sizeTable = new Hashtable();
        sizeTable.put(sizeSlider.getMinimum(), new JLabel("Small"));
        sizeTable.put(sizeSlider.getMaximum()/2, new JLabel("Size"));
        sizeTable.put(sizeSlider.getMaximum(), new JLabel("Large"));
        sizeSlider.setLabelTable(sizeTable);
        sizeSlider.setPreferredSize(slider);
        sizeSlider.setPaintLabels(true);
        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                BallApplet.ball.setDiameter(sizeSlider.getValue());

            }
        });

        shapes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(shapes.getSelectedItem().equals("Filled Circle")){

                    ball.setShape(1);

                }

                else if(shapes.getSelectedItem().equals("Hollow Circle")){

                    ball.setShape(0);

                }

                else if(shapes.getSelectedItem().equals("Hollow Square")){

                    ball.setShape(2);

                }

                else if(shapes.getSelectedItem().equals("Filled Square")){

                    ball.setShape(3);

                }

            }
        });

        titleLabel.setFont(title);
        titleLabel.setPreferredSize(new Dimension(285,50));
        titleLabel.setForeground(new Color(230,230,230));
    }

    private void add1(){

        JLabel space1 = new JLabel();
        space1.setPreferredSize(new Dimension(40,50));
        JLabel space2 = new JLabel();
        space2.setPreferredSize(new Dimension(40,50));
        JLabel space3 = new JLabel();
        space3.setPreferredSize(new Dimension(40,50));
        JLabel space4 = new JLabel();
        space4.setPreferredSize(new Dimension(40,50));

        add(titleLabel);
        add(on);
        add(clear);
        add(pause);
        add(space2);
        add(spawnSlider);
        add(space3);
        add(speedSlider);
        add(space1);
        add(shapes);
        add(space4);
        add(sizeSlider);

    }

}
