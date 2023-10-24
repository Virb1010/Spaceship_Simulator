/* ScrollBar.java 
 * Written By: Vir Bhatia
 * Email: vbhati02@tufts.edu 
 * 
 * This file contains the ScrolBar Class, a scrollbar which users can 
 * scroll to prompt basic actions from the program.
*/

import java.awt.event.*;
import javax.swing.*;

public class ScrollBar extends JScrollBar implements AdjustmentListener {

    // Creates a ScrollBar which prints the spaceship speed on the 
    // terminal when adjusted
    public ScrollBar() {
        setOrientation(HORIZONTAL);
        addAdjustmentListener(this);
    }       

    public void adjustmentValueChanged (AdjustmentEvent event) {
        System.out.println("Spaceship Speed: " + getValue());
    }
}