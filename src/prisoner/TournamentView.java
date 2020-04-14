/*
 * Edit history:
 *   Phuc Phan, 4/13: created
 *
 *
 */
package prisoner;

import simStation.*;
import java.awt.*;

public class TournamentView extends SimStationView {
	private static final long serialVersionUID = 1L;

	public TournamentView(TournamentSimulation model) {
        super(model);
    }

    @Override
    protected void paintComponent(Graphics gc) {
        Color oldColor = gc.getColor();

        for (Agent agent : getAgents()) {
            int r = 10;
            gc.fillOval(agent.getXc(), agent.getYc(), r, r);
        }

        gc.setColor(oldColor);
    }
}

