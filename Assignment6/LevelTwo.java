package Assignment6;

public class LevelTwo extends LevelThree {
	public LevelTwo(double[] balances){
		super(balances);
	}
	@Override
	public double measure(){
		if(super.getBankArray().length == 0) return 0;
		double x = 0;
		x = super.measure();
		x = x/super.getBankArray().length;
		return x;
	}
}