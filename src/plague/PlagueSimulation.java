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
        for (int i = 0; i < 50; i++) {
            Agent newAgent = new PlagueAgent("PlagueAgent", this);
            agents.add(newAgent);
        }
        changed();

    }
}
