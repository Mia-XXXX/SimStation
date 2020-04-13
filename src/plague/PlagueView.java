package plague;

import mvc.Model;
import mvc.View;
import simStation.Agent;
import simStation.SimStationView;
import simStation.Simulation;

import java.awt.*;
import java.util.ArrayList;

public class PlagueView extends SimStationView {

    public PlagueView(PlagueSimulation model) {
        super(model);
    }

    @Override
    protected void paintComponent(Graphics gc) {
        PlagueSimulation plagueSimulation = (PlagueSimulation) model;
        Color oldColor = gc.getColor();

        for (Agent agent : getAgents()) {

            PlagueAgent plagueAgent = (PlagueAgent) agent;

            //paint the healthy patients
            if (plagueAgent.isInfected())
                gc.setColor(Color.GREEN);
            else
                gc.setColor(Color.RED);

            int r = 10;
            gc.fillOval(agent.getXc(), agent.getYc(), r, r);
        }

        gc.setColor(oldColor);
    }
}
