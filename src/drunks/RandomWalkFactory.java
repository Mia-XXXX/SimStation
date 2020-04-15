package drunks;
/*
 * Edit history:
 *   Hui, 4/13: created
 *
 *
 */

import mvc.Model;
import boids.Flocking;
import mvc.Model;
import mvc.View;
import simStation.SimStationFactory;
import simStation.SimStationView;

public class RandomWalkFactory extends SimStationFactory{
    @Override
    public View getView(Model model) {
        return new SimStationView((RandomWalk) model);
    }

    @Override
    public Model makeModel() {
        return new RandomWalk();
    }

    @Override
    public String toString() {
        return "RandomWalk Simulation";    }
}