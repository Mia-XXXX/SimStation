/*
 * Edit history:
 *   Hui, 4/2: created
 *
 *
 */
package simStation;

import mvc.Command;
import mvc.Model;

import javax.swing.*;

public class ResumeCommand extends Command {
    public ResumeCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Simulation simulation = (Simulation) model;
        simulation.resume();
    }
}
