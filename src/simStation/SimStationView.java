package simStation;

import mvc.Model;
import mvc.View;
import plague.PlagueAgent;
import plague.PlagueSimulation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SimStationView extends View {

    protected ArrayList<Agent> getAgents() {
        Simulation model = (Simulation) this.model;
        return model.agents;
    }

    public SimStationView(Simulation model) {
        super(model);
        this.setPreferredSize(new Dimension(Simulation.WORLD_SIZE, Simulation.WORLD_SIZE));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    protected void paintComponent(Graphics gc){
        Simulation simulationPaint = (Simulation) model;
        Color oldColor = gc.getColor();
        gc.setColor(Color.GREEN);

        for (Agent agent : getAgents()) {
            gc.fillOval(agent.getXc(), agent.getYc(), 5, 5);
        }

        gc.setColor(oldColor);
    };
}
