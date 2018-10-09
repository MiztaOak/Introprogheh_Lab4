package spaceinv.model.projectiles;


import spaceinv.model.IPositionable;
import spaceinv.model.statics.OuterSpace;

// Shoot by the gun
public class Rocket implements IPositionable {
    private static final double ROCKET_WIDTH = 15;
    private static final double ROCKET_HEIGHT = 25;
    private static final double ROCKET_DY = 4;

    private double ROCKET_X;
    private double ROCKET_Y;

    private boolean ROCKET_ALIVE;

    public Rocket(double GUN_X, double GUN_Y, double GUN_WIDTH) {
        this.ROCKET_X = GUN_X + (GUN_WIDTH/2);
        this.ROCKET_Y = GUN_Y;
        this.ROCKET_ALIVE = true;
    }

    public void update() {
        this.ROCKET_Y -= ROCKET_DY;
        if(ROCKET_Y < OuterSpace.OUTERSPACE_HEIGHT) {
            this.ROCKET_ALIVE = false;
        }
    }

    public boolean isAlive() {
        return ROCKET_ALIVE;
    }

    public void kill() {
        ROCKET_ALIVE = false;
    }

    public void setX(double x) {
        this.ROCKET_X = x;
    }

    public void setY(double y) {
        this.ROCKET_Y = y;
    }

    @Override
    public double getX() {
        return ROCKET_X;
    }

    @Override
    public double getY() {
        return ROCKET_Y;
    }

    @Override
    public double getWidth() {
        return ROCKET_WIDTH;
    }

    @Override
    public double getHeight() {
        return ROCKET_HEIGHT;
    }
}
