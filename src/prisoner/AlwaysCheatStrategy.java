/*
 * Edit history:
 *   Phuc Phan, 4/12: created
 *
 *
 */

package prisoner;

import java.util.ArrayList;

public class AlwaysCheatStrategy  implements Strategy{
	
	@Override
	public boolean cooperate(ArrayList <Boolean> cooperateHistory) {
		return false;
	}

}
