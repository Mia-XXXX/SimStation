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

    public synchronized Agent getNeighbor(Agent seeker) {
        Agent agent = null;
        double min =1000;
        try {
            wait();
        }
        catch(InterruptedException e) {
            System.out.print(e.getLocalizedMessage());
        }
        for(Agent a:agents) {
            double distance = Math.sqrt(Math.pow((seeker.getXc() - a.getXc()),2) + Math.pow((seeker.getYc() - a.getYc()),2));
            if(distance < min) {
                min = distance;
                agent = a;
            }
        }
        return agent;
    }

    protected void populate(){
        for(int i=0; i<50; i++){
            Agent newAgent = new Bird("bird",this);
            agents.add(newAgent);
        }
        changed();
    }
}
