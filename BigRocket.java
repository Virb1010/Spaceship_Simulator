/* BigRocket.java 
 * Written By: Vir Bhatia
 * Email: vbhati02@tufts.edu 
 * 
 * This file contains the BigRocket class, a subclass of Vehicle
 */

import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class BigRocket extends Vehicle {

    public BigRocket(int tX, int tY, int xDirection, double defaultSpeed, 
                    double speed, String name) {
        super(tX, tY, xDirection, defaultSpeed, speed, name);
    }

    @Override
    public void draw(Graphics g) {
        // draws the image "rocket2.png" and a title at a specified location
        try {
            File imageFile = new File("rocket2.png");
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(image, this.tX, this.tY, null);
        g.drawString(name, this.tX, this.tY - 10);
    }
}