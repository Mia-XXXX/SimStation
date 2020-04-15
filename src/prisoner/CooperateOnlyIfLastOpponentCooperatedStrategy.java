/*
 * Edit history:
 *  Phuc Phan, 4/12: created
 *	Phuc Phan 1/14: add owner for strategy
 *
 */

package prisoner;

import java.util.ArrayList;

public class CooperateOnlyIfLastOpponentCooperatedStrategy implements Strategy{
	private PrisonerAgent owner;
	public CooperateOnlyIfLastOpponentCooperatedStrategy(PrisonerAgent owner) { 
		this.owner = owner; 
	}
	@Override
	public boolean cooperate() {
		ArrayList<Boolean> cooperateHistory = owner.getCooperateHistory();
		if(cooperateHistory.size() == 0){
			return false;
		}
		
		if(cooperateHistory.get(cooperateHistory.size() - 1)){
			return true;
		}
		
		return false;
	}

}
