/*
 * Edit history:
 *   Hui, 4/2: created
 *   Hui, 4/6: update to new method
 *   Hui, 4/11:update
 *   Hui, 4/13: debug getNeighbor()
 *   Phuc Phan, 4/14: add clock feature
 */



package simStation;

import mvc.Model;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Simulation extends Model {
    protected int clock;
    protected Timer timer;

    protected ArrayList<Agent> agents;

    public static Integer WORLD_SIZE = 250; // height & width of the world (& view)

    public Simulation(){
        agents = new ArrayList<>();
        clock = 0;
    }

    protected void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    protected void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    protected class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
        }
    }


    public void start(){
    	startTimer();
        agents = new ArrayList<>();
        populate();

        for(int i =0; i < agents.size(); i++){
            agents.get(i).start();
        }
        changed();
    }

    public void suspend(){
    	stopTimer();
        for(int i =0; i < agents.size(); i++){
            agents.get(i).suspend();
        }
        changed();
    }

    public void resume(){
    	startTimer();
        for(int i =0; i < agents.size(); i++){
            agents.get(i).resume();
        }
        changed();
    }

    public void stop(){
        stopTimer();
        for(int i = 0; i < agents.size(); i++){
            agents.get(i).stop();
        }
        changed();
    }

    public synchronized Agent getNeighbor(Agent seeker) {
        Agent agent = null;
        double min = Integer.MAX_VALUE;

        for (Agent a : agents) {
            if (seeker != a) {
                double distance = Math.sqrt(Math.pow((seeker.getXc() - a.getXc()), 2) + Math.pow((seeker.getYc() - a.getYc()), 2));
                if (distance < min) {
                    min = distance;
                    agent = a;
                }
            }
        }
        return agent;
    }

    protected abstract void populate();

    public String[] getStats() {
        String[] stats = new String[2];
        stats[0] = "#agents = " + agents.size();
        stats[1] = "clock = " + clock;
        return stats;
    }



}
