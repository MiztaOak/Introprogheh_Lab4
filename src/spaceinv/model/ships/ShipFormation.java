package spaceinv.model.ships;


import spaceinv.model.IPositionable;
import spaceinv.model.projectiles.Rocket;
import spaceinv.model.Gun;

import java.util.List;
import java.util.Random;

import static spaceinv.model.SpaceInv.GAME_WIDTH;

/*
    Handle movement of all ships (one at the time)
 */
public class ShipFormation {

    private final double PADDING_LEFT = 100;
    private final double PADDING_RIGHT = GAME_WIDTH - PADDING_LEFT;

    private static final Random rand = new Random();
    private final List<AbstractSpaceShip> ships;
    private int indexToMove;

    public ShipFormation(List<AbstractSpaceShip> ships) {
        this.ships = ships;
        indexToMove = ships.size() - 1;
    }

    // TODO Some method to move the ships
    public void updatePosition() {
        for (AbstractSpaceShip curShip : ships) {
            curShip.updatePosition();
        }
    }

    // TODO Some method to remove ship hit by rocket

    public void updateCollision(Rocket rocket, Gun gun) {
        for (int i = (ships.size() - 1); i >= 0; i--) {
//            System.out.println(i + " | " + ships.get(i));
            if (isColliding(i, rocket, gun)) {
                ships.remove(i);
            }
        }
    }

    private boolean isColliding(int i, Rocket rocket, Gun gun) {
        AbstractSpaceShip curShip = ships.get(i);

        if (rocket != null && rocket.isAlive() && isCollidingX(curShip, rocket) && isCollidingY(curShip,rocket)) {
            rocket.kill();
            return true;
        }

        if (isCollidingX(curShip, gun) && isCollidingY(curShip,gun)) {
            return true;
        }

        return false;
    }

    private boolean isCollidingX(IPositionable a, IPositionable b) {
        //Check left corner
        if (a.getX() >= b.getX() && a.getX() <= (b.getX() + b.getWidth())) {
            return true;
        }

        //Check middle
        if ((a.getX() + a.getWidth()/2) >= b.getX() && (a.getX() + a.getWidth()/2) <= (b.getX() + b.getWidth())) {
            return true;
        }

        //Check right corner
        if ((a.getX() + a.getWidth()) >= b.getX() && (a.getX() + a.getWidth()) <= (b.getX() + b.getWidth())) {
            return true;
        }
//        System.out.println("X = false");
        return false;
    }

    private boolean isCollidingY(IPositionable a, IPositionable b) {
        //Lowest point
        if ((a.getY() + a.getHeight()) >= b.getY() && (a.getY() + a.getHeight()) <= (b.getY() + b.getHeight())) {
            return true;
        }

        //Middle point
        if ((a.getY() + a.getHeight()/2) >= b.getY() && (a.getY() + a.getHeight()/2) <= (b.getY() + b.getHeight())) {
            return true;
        }

        //Highest point
        if (a.getY() >= b.getY() && a.getY() <= (b.getY() + b.getHeight())) {
            return true;
        }
//        System.out.println("Y = false");
        return false;
    }

    public int size() {
        return ships.size();
    }


    public List<AbstractSpaceShip> getShips() {
        return ships;
    }
}
