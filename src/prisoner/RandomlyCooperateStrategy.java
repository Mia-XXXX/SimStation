/*
 * Edit history:
 *  Phuc Phan, 4/12: created
 *	Phuc Phan 1/14: add owner for strategy
 *
 */

package prisoner;
import java.util.Random;

public class RandomlyCooperateStrategy implements Strategy{

	@Override
	public boolean cooperate() {
		boolean result = true;
		Random random = new Random();
		int num  = random.nextInt(2);
		if(num == 0){
			result = false;
		}
		return result;
	}

}
