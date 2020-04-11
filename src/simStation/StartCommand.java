/*
 * Edit history:
 *   Hui, 4/2: created
 *
 *
 */
package simStation;

import mvc.Command;
import mvc.Model;

public class StartCommand extends Command {
    public StartCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Simulation simulation = (Simulation) model;

        simulation.start();
    }
}
