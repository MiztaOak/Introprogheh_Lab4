package spaceinv.model.ships;

/*
 *   Type of space ship
 */
public class Frigate extends AbstractSpaceShip {

    public Frigate(double x, double y, int dir) {
        this.setX(x);
        this.setY(y);
        this.setDir(dir);
        this.setType("Frigate");
    }

    public Frigate(double x, double y) {
        this(x, y, 1);
    }

    public Frigate() {
        this(0,0,1);
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public Frigate copyOf() {
        Frigate copy = new Frigate();
        copy.setX(this.getX());
        copy.setY(this.getY());
        copy.setDir(this.getDir());
        return copy;
    }

}
