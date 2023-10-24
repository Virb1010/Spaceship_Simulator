/* Model.java 
 * Written By: Vir Bhatia
 * Email: vbhati02@tufts.edu 
 * 
 * This file contains the Model class, which handles communications between the 
 * widgets and the canvas
 */

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;


public class Model extends JPanel implements ActionListener {
    
    private TextField spaceship_name;
    private TextField xField;
    private TextField yField;
    private CheckBox auto_mode;
    private Button addSmall;
    private Button addBig;
    private JLabel title;
    private ToggleButton pause_button;
    private JLabel speedbar_label;
    private ScrollBar spaceship_speed;
    private Vector<Vehicle> vehicle_list = new Vector<Vehicle>();
    private JPanel control_center; 
    private Canvas canvas;
    private Timer timer;

    private String currName;
    private int currTX = 100, currTY = 100, rocketNumber = 1;
    
    public Model() {
    }

    // gains access to each class in the program and adds action listeners to
    // relevant widgets
    public void instantiate (TextField spaceship_name, TextField xField, 
                    TextField yField, CheckBox auto_mode, Button addSmall, 
                    Button addBig, JLabel title, ToggleButton pause_button, 
                    JLabel speedbar_label, ScrollBar spaceship_speed,
                    JPanel control_center, Canvas canvas, Timer timer) {

        
        this.spaceship_name = spaceship_name;
        spaceship_name.addActionListener(this);
        this.xField = xField;
        xField.addActionListener(this);
        this.yField = yField;
        yField.addActionListener(this);   
        this.auto_mode = auto_mode;
        auto_mode.addActionListener(this);
        this.addSmall = addSmall;
        addSmall.addActionListener(this);
        this.addBig = addBig;
        addBig.addActionListener(this);
        this.title = title;
        this.pause_button = pause_button;
        pause_button.addActionListener(this);
        this.speedbar_label = speedbar_label;
        this.spaceship_speed = spaceship_speed;
        this.control_center = control_center;
        this.canvas = canvas;
        this.timer = timer;
    }   

    public void actionPerformed(ActionEvent e) {
        // alters behavior of simulation based on user interaction with widgets
        if (e.getSource() == spaceship_name) {
            currName = spaceship_name.getText();
            System.out.println("currName is " + currName);
        } 
        else if (e.getSource() == xField) {
            // takes user input for x, converts it to an int, and sets currTx 
            // to inputted value
            String input = xField.getText();
            String inputNum = input.replaceAll("[^0-9]", "");
            currTX = Integer.parseInt(inputNum);
            if (currTX < 10) { currTX = 10;}
            System.out.println("currtx is " + currTX);
        } 
        else if (e.getSource() == yField) {
            // takes user input for y, converts it to an int, and sets currTy 
            // to inputted value
            String input = yField.getText();
            String inputNum = input.replaceAll("[^0-9]", "");
            currTY = Integer.parseInt(inputNum);
            if (currTY < 10) { currTY = 10;}
            System.out.println("currty is " + currTY);
        }
        else if (e.getSource() == auto_mode) {
            // toggles between auto-naming and placing rockets, or taking user 
            // input based on state of checkbox. Also disables name and 
            // coordinate fields in automode
            if (auto_mode.isSelected()) {
                currName = "Rocket #" + rocketNumber;
                currTX = 100;
                currTY = 100;
                spaceship_name.setEnabled(false);
                xField.setEnabled(false);
                yField.setEnabled(false);
            }
            else {
                currName = spaceship_name.getText();

                String input = xField.getText();
                String inputNum = input.replaceAll("[^0-9]", "");
                currTX = Integer.parseInt(inputNum);

                input = yField.getText();
                inputNum = input.replaceAll("[^0-9]", "");
                currTY = Integer.parseInt(inputNum);
                if (currTX < 10) { currTX = 10;}
                if (currTY < 10) { currTY = 10;}

                spaceship_name.setEnabled(true);
                xField.setEnabled(true);
                yField.setEnabled(true);
            }
        }
        else if (e.getSource() == addSmall) {
            // adds a small rocket to the simulation based on user paramters
            //  auto parameters
            Vehicle smallRocket = new SmallRocket(currTX, currTY, 1,
                                        2, 2, currName);
            vehicle_list.add(smallRocket);
            rocketNumber++;
            if (auto_mode.isSelected()) {currName = "Rocket #" + rocketNumber;}
        }
        else if (e.getSource() == addBig) {
            // adds a small rocket to the simulation based on user paramters
            //  auto parameters
            Vehicle smallRocket = new BigRocket(currTX, currTY, 1, 
                                        1, 1, currName);
            vehicle_list.add(smallRocket);
            rocketNumber++;
            if (auto_mode.isSelected()) {currName = "Rocket #" + rocketNumber;}
        }
        else if (e.getSource() == pause_button) {
            // pauses or unpauses the simulation
            for (Vehicle vehicle : vehicle_list) {
                if (pause_button.get_toggleState()) {
                    vehicle.speed = 0;
                }
                else {
                    vehicle.speed = vehicle.defaultSpeed;
                }
            }
        }
    }
    // handles the logic for interactions between widgets and the canvas
    public void drawer (Graphics g) {
        if (!pause_button.get_toggleState()) {
            g.drawString("game is paused", 700, 50); 
        }
        for (Vehicle vehicle : vehicle_list) {
            vehicle.draw(g);
            vehicle.translate();
        }
        canvas.repaint();
    }
}
