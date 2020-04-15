/*
 * Edit history:
 *   Hui, 4/13: created
 *
 *
 */

package boids;

import mvc.Model;
import mvc.View;
import simStation.SimStationFactory;
import simStation.SimStationView;

public class FlockingFactory extends SimStationFactory{
        @Override
        public View getView(Model model) {
            return new SimStationView((Flocking) model);
        }

        @Override
        public Model makeModel() {
            return new Flocking();
        }

    @Override
    public String toString() {
        return "Flocking Simulation";    }
}

