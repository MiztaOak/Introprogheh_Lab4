package spaceinv.model.ships;

import spaceinv.model.projectiles.Bomb;

/*
 *   Type of space ship
 */
public class Bomber extends AbstractSpaceShip{

    public Bomber(double x, double y, int dir) {
        this.setX(x);
        this.setY(y);
        this.setDir(dir);
        this.setType("Bomber");
    }

    public Bomber(double x, double y) {
        this(x,y,1);
    }

    public Bomber() {
        this(0,0,1);
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public Object copyOf() {
        Bomber copy = new Bomber();
        copy.setX(this.getX());
        copy.setY(this.getY());
        copy.setDir(this.getDir());
        return copy;
    }
}
