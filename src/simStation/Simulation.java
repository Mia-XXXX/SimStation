/*
 * Edit history:
 *   Hui, 4/2: created
 *
 *
 */



package simStation;

import mvc.Model;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Simulation extends Model {
    private int clock;
    private Timer timer;
    private ArrayList<Agent> agents;

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
            //changed();
        }
    }

    public Simulation(){
        clock = 0;
    }

    public  abstract void start();

    public abstract void suspend();

    public abstract void resume();

    public abstract void stop();

    public abstract void populate();

    public abstract ArrayList<String> getStats();

}
