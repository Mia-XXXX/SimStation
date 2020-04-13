package simStation;

import mvc.Model;
import mvc.View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class SimStationView extends View {

    protected ArrayList<Agent> getAgents() {
        Simulation model = (Simulation) this.model;
        return model.agents;
    }

    public SimStationView(Simulation model) {
        super(model);
        this.setPreferredSize(new Dimension(Simulation.WORLD_SIZE, Simulation.WORLD_SIZE));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    protected abstract void paintComponent(Graphics gc);
}
