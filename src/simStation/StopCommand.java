/*
 * Edit history:
 *   Hui, 4/2: created
 *
 *
 */

package simStation;

import mvc.Command;
import mvc.Model;

public class StopCommand extends Command {
    public StopCommand(Model model) { super(model); }
    public void execute() {
        Simulation simulation= (Simulation) model;
        simulation.stop();
    }
}