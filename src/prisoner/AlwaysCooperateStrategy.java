/*
 * Edit history:
 *  Phuc Phan, 4/12: created
 *	Phuc Phan 1/14: add owner for strategy
 *
 */

package prisoner;

public class AlwaysCooperateStrategy implements Strategy{

	@Override
	public boolean cooperate() {
		return true;
	}

}
