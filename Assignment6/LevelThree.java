package Assignment6;

public class LevelThree extends LevelFour{
	private BankAccount[] bankArray;
	public LevelThree(double[] balances){
		super(balances.length);
		bankArray = new BankAccount[balances.length];
		for(int i = 0; i < balances.length; i++){
			bankArray[i] = new BankAccount(balances[i]);
		}
	}
	@Override
	public double measure(){
		double ret = 0;
		for(int i = 0; i < bankArray.length; i++){
			ret += bankArray[i].getBalance();
		}
		return ret;
				
	}
	public double distance(int i, double mean){
		double x = Math.abs(bankArray[i].getBalance() - mean);
		return x;
	}
	public BankAccount[] getBankArray(){
		return bankArray;
	}

}
