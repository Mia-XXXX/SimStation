/*
 * Edit history:
 *   Phuc Phan, 4/13: created
 *
 *
 */
package prisoner;

import mvc.AppPanel;
import simStation.*;

public class TournamentPanel extends SimStationPanel{

	private static final long serialVersionUID = 1L;
	
	public TournamentPanel(SimStationFactory factory) {
		super(factory);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {

        //Specify which customization to use here by changing the factory
        SimStationFactory factory = new TournamentFactory();
        AppPanel panel = new TournamentPanel(factory);
        panel.display();
    }

}
