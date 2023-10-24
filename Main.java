/* Main.java 
 * Written By: Vir Bhatia
 * Email: vbhati02@tufts.edu 
 * 
 * This file contains the main function which handles the programs control flow
 */

import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;

public class Main extends JFrame implements ActionListener {

    private int frameNumber = 0;
    private Model model;
    private Canvas canvas;
    public static void main(String [] args) {
        java.awt.EventQueue.invokeLater (new Runnable() {
            public void run() {
                new Main();
            }
        });
    }

    public Main() {
        // Initialize the window
        setSize(1400, 1400);
        setLayout(new BorderLayout());

        // Initialize and allocate memory for each class
        model = new Model();
        
        canvas = new Canvas(model);

        Timer timer = new Timer(200, this);
        timer.start();

        TextField spaceship_name = new TextField("Name your Spaceship!", 
                    "textfield used!");

        TextField xField = new TextField("x: 0", 
                    "x field is: ");

        TextField yField = new TextField("y: 0", "y field is ");

        CheckBox auto_mode = new CheckBox("Enable Auto-Mode", 
            "Auto-Mode Enabled", 
            "Auto-Mode Disabled");

        Button addSmall = new Button("Add Small Rocket", 
                        "small rocket added");

        Button addBig = new Button("Add Big Rocket", 
                        "big rocket added");

        JLabel title = new JLabel ("SPACESHIP CONTROL SIMULATOR");

        ToggleButton pause_button = new ToggleButton("Pause Simulation", "Resume",
            "Game Paused", "Game Unpaused");

        JLabel speedbar_label = new JLabel("Spaceship Speed:");

        ScrollBar spaceship_speed = new ScrollBar();


        JPanel control_center = new JPanel();
        control_center.setBackground(Color.GRAY);
        
        // gives the model access to each class in the program
        model.instantiate(spaceship_name, xField, yField, auto_mode, addSmall, 
                            addBig, title, pause_button, speedbar_label, 
                            spaceship_speed, control_center, canvas, timer);

        // Add each widget to the control center
        control_center.add(spaceship_name);
        control_center.add(xField);
        control_center.add(yField);
        control_center.add(auto_mode);
        control_center.add(addSmall);
        control_center.add(addBig);
        control_center.add(title);
        control_center.add(pause_button);
        control_center.add(speedbar_label);
        control_center.add(spaceship_speed);
    
        // add the control center and canvas to the screen and setVisible
        add(control_center, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        setVisible(true);
    }

    public int getFrameNumber() { return frameNumber; }

    @Override
    public void actionPerformed(ActionEvent e) {
        frameNumber++;
        canvas.repaint();
    }
}

