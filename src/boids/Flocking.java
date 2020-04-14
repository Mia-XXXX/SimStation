/*
 * Edit history:
 *   Hui, 4/10: created
 *
 *
 */



package boids;


import simStation.Agent;
import simStation.Simulation;


public class Flocking extends Simulation {

    public Flocking(){
        super();
    }

    protected void populate(){
        for(int i=0; i<50; i++){
            Agent newAgent = new Bird(""+i,this);
            agents.add(newAgent);
        }
        changed();
    }
}
