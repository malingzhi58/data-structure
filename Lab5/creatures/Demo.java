package creatures;

import huglife.Action;
import huglife.Direction;
import huglife.Impassible;
import huglife.Occupant;

import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {
        Plip p = new Plip(1.2);
        HashMap <Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());
        System.out.println(surrounded);
        System.out.println(surrounded.get(Direction.TOP));

        System.out.println(surrounded.get(Direction.TOP).name());

        Action actual = p.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);
        System.out.println("acutal="+ actual);

    }
}
