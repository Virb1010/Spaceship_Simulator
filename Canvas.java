/* Canvas.java 
 * Written By: Vir Bhatia
 * Email: vbhati02@tufts.edu 
 * 
 * This file contains the Canvas Class, a blank subclass of Jpanel which can be
 * drawn on.
 */

import javax.swing.*;
import java.awt.*;

// Creates a Canvas, a blank drawing space
public class Canvas extends JPanel {
    private Model model;

    public Canvas (Model model) {
        this.model = model;
    }       

    // handles all drawing for the program window
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        model.drawer(g);
    }
}