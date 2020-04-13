/*
 * Edit history:
 *   Phuc Phan, 4/12: created
 *
 *
 */

package prisoner;
import simStation.*;

public class Tournament extends Simulation {
	private static final long serialVersionUID = 1L;

	public Tournament(){
        super();
    }

    protected void populate(){
        for(int i=0; i<10; i++){
        	Prisoner p = new Prisoner("prisoner",this);
        	p.setStrategy(new AlwaysCheatStrategy());
            Agent newAgent = p;
            agents.add(newAgent);
        }

        for(int i=10; i<20; i++){
        	Prisoner p = new Prisoner("prisoner",this);
        	p.setStrategy(new AlwaysCooperateStrategy());
            Agent newAgent = p;
            agents.add(newAgent);
        }
        

        for(int i=20; i<30; i++){
        	Prisoner p = new Prisoner("prisoner",this);
        	p.setStrategy(new CooperateOnlyIfLastOpponentCooperatedStrategy());
            Agent newAgent = p;
            agents.add(newAgent);
        }
        

        for(int i=30; i<50; i++){
        	Prisoner p = new Prisoner("prisoner",this);
        	p.setStrategy(new RandomlyCooperateStrategy());
            Agent newAgent = p;
            agents.add(newAgent);
        }
        
        changed();
    }
    
    @Override
    public String[] getStats() {
        String[] stats = new String[6];
        stats[0] = "#agents = " + agents.size();
        stats[1] = "clock = " + clock;
        
        double average;
        
        average = 0.0;
        for(int i=0; i<10; i++){
        	Prisoner p = (Prisoner)agents.get(i);
        	average += p.getFitness();
        }
        average /= 10.0;
        stats[2] = "Always Cheat Strategy Prisoners' average fitness = " + average;

        average = 0.0;
        for(int i=10; i<20; i++){
        	Prisoner p = (Prisoner)agents.get(i);
        	average += p.getFitness();
        }
        average /= 10.0;
        stats[3] = "Always Cooperate Strategy Prisoners' average fitness = " + average;
        
        average = 0.0;
        for(int i=20; i<30; i++){
        	Prisoner p = (Prisoner)agents.get(i);
        	average += p.getFitness();
        }
        average /= 10.0;
        stats[4] = "Cooperate Only If LastOpponent Cooperated Strategy Prisoners' average fitness = " + average;
        
        average = 0.0;
        for(int i=30; i<50; i++){
        	Prisoner p = (Prisoner)agents.get(i);
        	average += p.getFitness();
        }
        average /= 20.0;
        stats[5] = "Randomly Cooperate Strategy Prisoners' average fitness = " + average;
        
        return stats;
    }
}
