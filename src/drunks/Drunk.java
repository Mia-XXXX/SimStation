/*
 * Edit history:
 *   Hui, 4/10: created
 *
 *
 */



package drunks;

import simStation.Agent;
import simStation.Heading;
import simStation.Simulation;

public class Drunk extends Agent {


    public Drunk(String name, Simulation world) {
        super(name, world);
    }

    public void update(){
        this.heading = Heading.values()[random.nextInt(4)];
        this.speed  = random.nextInt(10);

        move(speed);
        world.changed();
    }




}
