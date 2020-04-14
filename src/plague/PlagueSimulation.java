package plague;

import simStation.Agent;
import simStation.Simulation;

import java.util.Arrays;

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

    @Override
    public String[] getStats() {
        String[] old = super.getStats();
        String[] newStats = Arrays.copyOf(old, old.length + 2);
        int infectedAgents = 0;
        for (Agent a : agents) {
            PlagueAgent agent = (PlagueAgent) a;
            if (agent.isInfected())
                infectedAgents++;
        }

        newStats[old.length] = "Infected Agents: " + infectedAgents;
        newStats[old.length + 1] = "Healthy Agents: " + (agents.size() - infectedAgents);
        return newStats;
    }
}
