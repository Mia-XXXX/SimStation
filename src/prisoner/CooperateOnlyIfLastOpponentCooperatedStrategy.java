/*
 * Edit history:
 *   Phuc Phan, 4/12: created
 *
 *
 */

package prisoner;

import java.util.ArrayList;

public class CooperateOnlyIfLastOpponentCooperatedStrategy implements Strategy{

	@Override
	public boolean cooperate(ArrayList <Boolean> cooperateHistory) {
		if(cooperateHistory.size() == 0){
			return false;
		}
		
		if(cooperateHistory.get(cooperateHistory.size() - 1)){
			return true;
		}
		
		return false;
	}

}
