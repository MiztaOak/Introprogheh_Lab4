package spaceinv.model.ships;

import spaceinv.model.IPositionable;

import java.util.Random;


/*
 * An alien attacker for the space invaders game
 *
 * Base class for all ships
 */

public abstract class AbstractSpaceShip  implements IPositionable {

    public static final double SHIP_WIDTH = 40;
    public static final double SHIP_HEIGHT = 30;
    public static final double SHIPS_DX = 5;
    public static final double SHIPS_DY = 14;

    private static Random rand = new Random();   // TODO

    private double minX;  // min and max for ship to move i x-dir
    private double maxX;

    private String SHIPS_TYPE;
    private double SHIPS_X;
    private double SHIPS_Y;
    private int SHIPS_DIR;


    // To be overridden
    public abstract int getPoints();

    // To be overridden
    public abstract Object copyOf();

    public double getX() {
        return SHIPS_X;
    }

    public void setX(double x) {
        this.SHIPS_X = x;
    }

    public double getY() {
        return SHIPS_Y;
    }

    public void setY(double y) {
        this.SHIPS_Y = y;
    }

    public int getDir() {
        return SHIPS_DIR;
    }

    public void setDir(int dir) {
        this.SHIPS_DIR = dir;
    }

    public String getType() {
        return SHIPS_TYPE;
    }

    public void setType(String type) {
        this.SHIPS_TYPE = type;
    }

    public double getWidth() {
        return SHIP_WIDTH;
    }

    public double getHeight() {
        return SHIP_HEIGHT;
    }

    // For ships moving back and forth
    public void setMoveInterval(double minX, double maxX) {
        this.minX = minX;
        this.maxX = maxX;
    }

    private boolean isValidPositionX(double newPosX) {
        if (newPosX > minX && newPosX + SHIP_WIDTH < maxX) {
            return true;
        } else {
            return false;
        }
    }

    public void updatePosition() {
        double newPosX = SHIPS_X + SHIPS_DX * SHIPS_DIR;
        if (isValidPositionX(newPosX)) {
            SHIPS_X = newPosX;
        } else {
            SHIPS_DIR *= -1;
            SHIPS_Y += SHIPS_DY;
        }
    }

    @Override
    public String toString() {
        return "AbstractSpaceShip{" +
                "SHIPS_TYPE='" + SHIPS_TYPE + '\'' +
                ", SHIPS_X=" + SHIPS_X +
                ", SHIPS_Y=" + SHIPS_Y +
                '}';
    }
}
