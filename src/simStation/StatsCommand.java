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
import java.util.ArrayList;

public class StatsCommand extends Command {
    public StatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() {
        Simulation simulation = (Simulation) model;
        String[] stats = simulation.getStats();
        //TODO: JOptionPane.showMessageDialog(
    }
}
