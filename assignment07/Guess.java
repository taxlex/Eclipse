package assignment07;

import java.util.Random;

public class Guess implements Play {
	private Random random = new Random();
	@Override
	public int takeTurn(int currentState) {
		int val = 0;
		if(currentState == 1) val = 1;
		else{
			val = random.nextInt((currentState/2)) + 1;
		}
		return val;
	}

}