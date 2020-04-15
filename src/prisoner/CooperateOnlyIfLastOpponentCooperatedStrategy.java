/*
 * Edit history:
 *  Phuc Phan, 4/12: created
 *	Phuc Phan 1/14: add owner for strategy
 *
 */

package prisoner;

public class CooperateOnlyIfLastOpponentCooperatedStrategy implements Strategy{
	private PrisonerAgent owner;
	public CooperateOnlyIfLastOpponentCooperatedStrategy(PrisonerAgent owner) { 
		this.owner = owner; 
	}
	@Override
	public boolean cooperate() {
		boolean cooperateHistory = owner.getCooperateHistory();
		
		if(cooperateHistory){
			return true;
		}
		
		return false;
	}

}
