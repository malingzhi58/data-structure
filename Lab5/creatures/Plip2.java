package Lab5.creatures;

import Lab5.huglife.Action;
import Lab5.huglife.Creature;
import Lab5.huglife.Direction;
import Lab5.huglife.Occupant;

import java.awt.*;
import java.util.Map;

public class Plip2 extends Creature {

    /**
     * Creates a creature with the name N. The intention is that this
     * name should be shared between all creatures of the same type.
     *
     * @param n
     */
    public Plip2(String n) {
        super(n);
    }

    /**
     * Required method that returns a color.
     */
    @Override
    public Color color() {
        return null;
    }

    /**
     * Called when this creature moves.
     */
    @Override
    public void move() {

    }

    /**
     * Called when this creature attacks C.
     *
     * @param c
     */
    @Override
    public void attack(Creature c) {

    }

    /**
     * Called when this creature chooses replicate.
     * Must return a creature of the same type.
     */
    @Override
    public Creature replicate() {
        return null;
    }

    /**
     * Called when this creature chooses stay.
     */
    @Override
    public void stay() {

    }

    /**
     * Returns an action. The creature is provided information about its
     * immediate NEIGHBORS with which to make a decision.
     *
     * @param neighbors
     */
    @Override
    public Action chooseAction(Map <Direction, Occupant> neighbors) {
        return null;
    }
}
