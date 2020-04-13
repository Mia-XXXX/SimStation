package plague;

import simStation.Agent;
import simStation.Simulation;

public class PlagueSimulation extends Simulation {

    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection

    public PlagueSimulation() {
        super();
        populate();
    }

    @Override
    protected void populate() {
        for (int i = 0; i < 49; i++) {
            Agent newAgent = new PlagueAgent("PlagueAgent", this);
            agents.add(newAgent);
        }

        //make an infected agent
        Agent newAgent = new PlagueAgent("PlagueAgent", this, true);
        agents.add(newAgent);

        changed();

    }
}
