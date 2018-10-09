package spaceinv.model;


import spaceinv.model.projectiles.Rocket;

import static spaceinv.model.SpaceInv.GAME_HEIGHT;
import static spaceinv.model.SpaceInv.GAME_WIDTH;

/*
 * A Gun for the SpaceInv game
 */
public class Gun implements IPositionable{

    public static final double MAX_SPEED = 2;
    public static final double GUN_WIDTH = 30;
    public static final double GUN_HEIGHT = 40;
    private double GUN_X;
    private double GUN_Y;
    private int GUN_DIR;

    public Gun(double x, double y) {
        this.GUN_X = x;
        this.GUN_Y = y;
        this.GUN_DIR = 0;
    }

    public Gun() {
        this(GAME_WIDTH/2,GAME_HEIGHT-50);
    }

    private boolean isValidPositionX(double newPosX) {
        if (newPosX > 0 && (newPosX+GUN_WIDTH) < GAME_WIDTH) {
            return true;
        }
        return false;
    }

    public void updatePosition() {
        double newPosX = GUN_X + MAX_SPEED * GUN_DIR;
        if (newPosX != GUN_X && isValidPositionX(newPosX)) {
            GUN_X = newPosX;
        }
    }

    public double getX() {
        return GUN_X;
    }
    public void setX(double x) {
        this.GUN_X = x;
    }

    public double getY() {
        return GUN_Y;
    }

    @Override
    public double getWidth() {
        return GUN_WIDTH;
    }

    @Override
    public double getHeight() {
        return GUN_HEIGHT;
    }

    public int getDir() {
        return GUN_DIR;
    }

    public void setDir(int dir) {
        this.GUN_DIR = dir;
    }
}
