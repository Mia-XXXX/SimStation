/*
 * Edit history:
 *   Phuc Phan, 4/12: created
 *
 *
 */

package prisoner;

import java.util.ArrayList;

public class AlwaysCooperateStrategy implements Strategy{

	@Override
	public boolean cooperate(ArrayList <Boolean> cooperateHistory) {
		return true;
	}

}
