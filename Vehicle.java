/* Vehicle.java 
 * Written By: Vir Bhatia
 * Email: vbhati02@tufts.edu 
 * 
 * This file contains the abstract Vehicle class, which defines variables and
 * methods of abstract vehicles
 */

import java.awt.*;

public abstract class Vehicle {
    protected int tX, tY, xDirection;
    protected double defaultSpeed, speed;
    protected String name;
    protected Image image;

    public Vehicle(int tX, int tY, int xDirection, double defaultSpeed,
                            double speed, String name) {
        this.tX = tX;
        this.tY = tY;
        this.xDirection = xDirection;
        this.defaultSpeed = defaultSpeed;
        this.speed = speed;
        this.name = name;
    }

    public void translate() {
        // bounces the vehicle horizontally along the boundaries at speed 
        // velocity
        tX += speed * xDirection;

        if (tX > 1400) {
            xDirection = -1;
        }
        if (tX < 0) {
            xDirection = 1;
        }
    }

    // public abstract void translate();
    public abstract void draw(Graphics g);
}