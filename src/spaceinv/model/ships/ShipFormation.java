package spaceinv.model.ships;


import spaceinv.event.Event;
import spaceinv.event.EventService;
import spaceinv.event.ePos;
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

    public void updateFormation() {
        for(int i = 0; i < ships.size(); i++){
            AbstractSpaceShip ship = ships.get(i);
            if(ship instanceof Bomber) {
                Bomber b = (Bomber)ship;
                b.update();
            }else {
                ship.update();
            }
        }
    }

    // TODO Some method to remove ship hit by rocket

    private boolean isHit(Rocket rocket, AbstractSpaceShip ship){
        return rocket.getY() <= ship.getY()+ship.getHeight() && rocket.getY() >= ship.getY() &&
                rocket.getX() <= ship.getX()+ship.getWidth() && rocket.getX() >= ship.getX();
    }

    public void killShips(Rocket rocket){
        for(int i = 0; i < ships.size(); i++){
            AbstractSpaceShip ship = ships.get(i);
            if (isHit(rocket, ship) && !rocket.isHit()) {
                ships.remove(ship);
                EventService.add(new Event(Event.Type.ROCKET_HIT_SHIP,new ePos(ship.getX(),ship.getY())));
                rocket.setHit(true);
            }
        }
    }

    public int size() {
        return ships.size();
    }


    public List<AbstractSpaceShip> getShips() {
        return ships;
    }
}
