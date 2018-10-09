package spaceinv.model.levels;



import spaceinv.model.Gun;
import spaceinv.model.ships.*;
import spaceinv.model.statics.Ground;
import spaceinv.model.statics.OuterSpace;

import java.util.List;

import static spaceinv.model.levels.LevelUtils.*;

/*
    Basic level to test ships and movement of

 */
public class Level0 implements ILevel {

    private final List<AbstractSpaceShip> ships =
            addAll(
                    distribute(asList(new BattleCruiser(70, -180), 12), 5),
                    distribute(asList(new Bomber(70, -160,-1), 8), 30),
                    distribute(asList(new Bomber(70, -120, -1), 8), 30),
                    distribute(asList(new BattleCruiser(70, -80), 12), 5),
                    distribute(asList(new Frigate(70, -40), 12), 5)
            );

    @Override
    public OuterSpace getOuterSpace() {
        return new OuterSpace(); // TODO new OuterSpace(0); // Dummy for testing usage
    }

    @Override
    public Ground getGround() {
        return new Ground(); // TODO new Ground(0); // Dummy for testing usage
    }

    @Override
    public Gun getGun() {
        return new Gun(); // TODO new Gun(0, 0, 0); // Dummy for testing usage
    }

    @Override
    public ShipFormation getFormation() {
        return new ShipFormation(ships);
    }

}
