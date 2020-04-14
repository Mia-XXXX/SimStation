/*
 * Edit history:
 *   Hui, 4/2: created
 *	Phuc Phan, 4/13 add message box
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
        String message = "";
        for(int i = 0; i < stats.length; i++){
        	message += stats[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, message);
    }
}
