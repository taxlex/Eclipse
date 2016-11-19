package assignment07;

import java.util.Random;

public class Smart implements Play {
	private Random random = new Random();
	@Override
	public int takeTurn(int currentState) {
		int val = 0;
		int x = 1;
		int y = 0;
		while(y < (currentState+1)/2){
			x = x*2;
			y = x;
		}
		val = currentState - x + 1;
		if(val == 0){
			val = random.nextInt((currentState/2)) + 1;
		}
		return val;
	}

}