/*
 * Edit history:
 *   Hui, 4/2: created
 *
 *
 */


package simStation;

import mvc.Command;
import mvc.Model;

public class SuspendCommand extends Command {
    public SuspendCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Simulation simulation = (Simulation) model;
        simulation.suspend();
    }
}
