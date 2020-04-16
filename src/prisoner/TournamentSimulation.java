/*
 * Edit history:
 *  Phuc Phan, 4/12: created
 *	Phuc Phan 1/14: add owner for strategy
 *
 */

package prisoner;
import simStation.*;

import java.util.Timer;
import java.util.TimerTask;

public class TournamentSimulation extends Simulation {
	private static final long serialVersionUID = 1L;

	public TournamentSimulation(){
        super();
    }

    protected void populate(){
        for(int i=0; i<10; i++){
        	PrisonerAgent p = new PrisonerAgent("prisoner",this);
        	p.setStrategy(new AlwaysCheatStrategy());
            Agent newAgent = p;
            agents.add(newAgent);
        }

        for(int i=10; i<20; i++){
        	PrisonerAgent p = new PrisonerAgent("prisoner",this);
        	p.setStrategy(new AlwaysCooperateStrategy());
            Agent newAgent = p;
            agents.add(newAgent);
        }


        for(int i=20; i<30; i++){
        	PrisonerAgent p = new PrisonerAgent("prisoner",this);
        	p.setStrategy(new CooperateOnlyIfLastOpponentCooperatedStrategy(p));
            Agent newAgent = p;
            agents.add(newAgent);
        }


        for(int i=30; i<40; i++){
        	PrisonerAgent p = new PrisonerAgent("prisoner",this);
        	p.setStrategy(new RandomlyCooperateStrategy());
            Agent newAgent = p;
            agents.add(newAgent);
        }

        changed();
    }

    @Override
    protected void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    protected class ClockUpdater extends Simulation.ClockUpdater {
        public void run() {
            clock++;
            for (int i = 0; i < getStats().length; i++) {
                System.out.println(getStats()[i]);
            }
        }
    }

    @Override
    public String[] getStats() {
        String[] stats = new String[6];
        stats[0] = "#agents = " + agents.size();
        stats[1] = "clock = " + clock;
        
        double average;
        
        average = 0.0;
        for(int i=0; i<10; i++){
        	PrisonerAgent p = (PrisonerAgent)agents.get(i);
        	average += p.getFitness();
        }
        average /= 10.0;
        stats[2] = "Always Cheat Strategy Prisoners' average fitness = " + average;

        average = 0.0;
        for(int i=10; i<20; i++){
        	PrisonerAgent p = (PrisonerAgent)agents.get(i);
        	average += p.getFitness();
        }
        average /= 10.0;
        stats[3] = "Always Cooperate Strategy Prisoners' average fitness = " + average;
        
        average = 0.0;
        for(int i=20; i<30; i++){
        	PrisonerAgent p = (PrisonerAgent)agents.get(i);
        	average += p.getFitness();
        }
        average /= 10.0;
        stats[4] = "Cooperate Only If LastOpponent Cooperated Strategy Prisoners' average fitness = " + average;
        
        average = 0.0;
        for(int i=30; i<40; i++){
        	PrisonerAgent p = (PrisonerAgent)agents.get(i);
        	average += p.getFitness();
        }
        average /= 10.0;
        stats[5] = "Randomly Cooperate Strategy Prisoners' average fitness = " + average;
        
        return stats;
    }
}
