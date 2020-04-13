/*
 * Edit history:
 *   Phuc Phan, 4/12: created
 *
 *
 */
package prisoner;

import java.util.ArrayList;

import simStation.*;

class Prisoner extends Agent {
	private static final long serialVersionUID = 1L;
	private int fitness = 100;
	private Strategy strategy;
	private ArrayList<Boolean> cooperateHistory;

	public Prisoner(String name, Simulation world) {
		super(name, world);
		strategy = new AlwaysCooperateStrategy();
		cooperateHistory = new ArrayList<Boolean>();
	}
	
	public void addCooperateHistory(boolean b){
		cooperateHistory.add(b);
	}

	public void setStrategy(Strategy s) {
		strategy = s;
	}

	public void increaseFitness(int num) {
		fitness += num;
	}

	public int getFitness() {
		return fitness;
	}

	public boolean cooperate() {
		return strategy.cooperate(cooperateHistory);
	}

	@Override
	public void update() {
		Tournament tournament = (Tournament) world;
		Prisoner neighbor = (Prisoner) tournament.getNeighbor(this);
		
		boolean prison1Choice = cooperate();
		boolean prison2Choice = neighbor.cooperate();
		
		if(prison1Choice && prison2Choice){
			increaseFitness(3);
			neighbor.increaseFitness(3);
		}else if(!prison1Choice && prison2Choice){
			increaseFitness(5);
			neighbor.increaseFitness(0);
		}else if(prison1Choice && !prison2Choice){
			increaseFitness(0);
			neighbor.increaseFitness(5);
		}else{
			increaseFitness(1);
			neighbor.increaseFitness(1);
		}
		
		addCooperateHistory(prison2Choice);
		neighbor.addCooperateHistory(prison1Choice);
		
		this.heading = Heading.values()[random.nextInt(4)];
		this.speed = random.nextInt(10);

		move(speed);
		world.changed();

	}
}
