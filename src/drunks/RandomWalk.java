/*
 * Edit history:
 *   Hui, 4/10: created
 *
 *
 */


package drunks;

import simStation.Agent;
import simStation.Simulation;


public class RandomWalk extends Simulation {
    public RandomWalk() {
        super();
    }

    public void populate(){
        for(int i=0; i<50; i++){
            Agent newAgent = new Drunk("drunks",this);
            agents.add(newAgent);
        }
        changed();
    }
}
