/*
 * Edit history:
 *   Hui, 4/2: created
 *
 *
 */



package simStation;

import java.util.ArrayList;

public abstract class Simulation {
    private int clock;
    private ArrayList<Agent> agents;



    public Simulation(){
        clock = 0;
    }

    public  abstract void start();

    public abstract void suspend();

    public abstract void resume();

    public abstract void stop();

    public abstract void populate();

}
