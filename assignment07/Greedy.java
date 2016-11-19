package assignment07;

public class Greedy implements Play {

	@Override
	public int takeTurn(int currentState) {
		int val = 0;
		if(currentState == 1) val = 1;
		else val = currentState/2;
		return val;
	}

}