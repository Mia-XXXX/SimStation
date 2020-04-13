/*
 * Edit history:
 *   Phuc Phan, 4/12: created
 *
 *
 */

package prisoner;

import java.util.ArrayList;

public interface Strategy {
	public boolean cooperate(ArrayList <Boolean> cooperateHistory);
}
