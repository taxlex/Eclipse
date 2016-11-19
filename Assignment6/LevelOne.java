package Assignment6;

public class LevelOne extends LevelTwo{
	public LevelOne(double[] balances){
		super(balances);
	}
	@Override
	public double measure(){
		double dif = Double.MIN_VALUE;
		BankAccount[] ba = getBankArray();
		for(int i = 0; i < ba.length ; i++){
			if(Math.abs(super.measure() - ba[i].getBalance()) > dif) dif =Math.abs(super.measure() - ba[i].getBalance());
		}
		return dif;
	}

}
