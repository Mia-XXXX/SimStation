/*
 * Edit history:
 *   Hui, 4/10: created
 *
 *
 */



package boids;

import simStation.Agent;
import simStation.Heading;
import simStation.Simulation;

public class Bird extends Agent {

    public Bird(String name, Simulation world) {
        super(name, world);
    }



    public void update(){
        Flocking flocking = (Flocking) world;
        Bird a = (Bird) flocking.getNeighbor(this);
        this.speed = a.speed;
        this.heading = a.heading;
        move(speed);
        world.changed();
    }

}
