package spaceinv.model.ships;

/*
 *   Type of space ship
 */
public class BattleCruiser extends AbstractSpaceShip{

    public BattleCruiser(double x, double y, int dir) {
        this.setX(x);
        this.setY(y);
        this.setDir(dir);
        this.setType("BattleCruiser");
    }

    public BattleCruiser(double x, double y) {
        this(x,y,1);
    }

    public BattleCruiser() {
        this(0,0, 1);
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public Object copyOf() {
        BattleCruiser copy = new BattleCruiser();
        copy.setX(this.getX());
        copy.setY(this.getY());
        copy.setDir(this.getDir());
        return copy;
    }
}
