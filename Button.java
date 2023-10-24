/* Button.java 
 * Written By: Vir Bhatia
 * Email: vbhati02@tufts.edu 
 * 
 * This file contains the Button Class, a button which users can press to prompt 
 * basic actions from the program.
*/

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Button extends JButton implements ActionListener {
    private String buttonMessage;

    // Creates a button with label label, which prints message on the terminal 
    // when pressed
    public Button (String label, String message) {
        setText(label);
        buttonMessage = message;
        addActionListener(this);
    }       

    public void actionPerformed (ActionEvent event) {
        System.out.println(buttonMessage);
    }
}