/*
 * Edit history:
 *   Phuc Phan, 4/12: created
 *
 *
 */

package prisoner;

import java.util.ArrayList;
import java.util.Random;

public class RandomlyCooperateStrategy implements Strategy{

	@Override
	public boolean cooperate(ArrayList <Boolean> cooperateHistory) {
		boolean result = true;
		Random random = new Random();
		int num  = random.nextInt(2);
		if(num == 0){
			result = false;
		}
		return result;
	}

}
