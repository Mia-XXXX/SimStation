/*
 * Edit history:
 *   Hui, 4/10: created
 *
 *
 */



package boids;

import simStation.Agent;
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
        move(this.speed);
        world.changed();
    }

}
