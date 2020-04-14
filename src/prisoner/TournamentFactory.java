/*
 * Edit history:
 *   Phuc Phan, 4/13: created
 *
 *
 */
package prisoner;

import mvc.*;
import simStation.*;

public class TournamentFactory extends SimStationFactory {
    @Override
    public View getView(Model model) {
        return new TournamentView((TournamentSimulation) model);
    }

    @Override
    public Model makeModel() {
        return new TournamentSimulation();
    }
}

