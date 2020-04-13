package plague;

import mvc.Model;
import mvc.View;
import simStation.SimStationFactory;

public class PlagueFactory extends SimStationFactory {
    @Override
    public View getView(Model model) {
        return new PlagueView((PlagueSimulation) model);
    }

    @Override
    public Model makeModel() {
        return new PlagueSimulation();
    }
}
