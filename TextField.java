/* TextField.java 
 * Written By: Vir Bhatia
 * Email: vbhati02@tufts.edu 
 * 
 * This file contains the TextField Class, a text field which users can type in 
 * to prompt basic actions from the program.
*/

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Creates a Textfield with label label, which prints the Spaceship name on the
// terminal once the user has named it
public class TextField extends JTextField implements ActionListener {

    public TextField (String label, String message) {
        setText(label);
        addActionListener(this);
    }       

    @Override
    public void actionPerformed (ActionEvent event) {
    }
}