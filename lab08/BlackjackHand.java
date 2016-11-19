package lab08;

public class BlackjackHand extends CardHand {
	public int value(){
		int add = 0;
		int Ace = 0;
		int finval = 0;
		for(int i = 0; i < cards.size(); i++){
			if(cards.get(i).getValue() == 11) Ace++;
			else add+= cards.get(i).getValue();
		}
		if((add + (Ace*11)) < 22) finval = (add + (Ace*11));
		if(Ace == 0) finval = add;
		if((add + (Ace*11)) > 21 && Ace > 0){
			for(int j = 0; Ace > -1; j++){
				Ace--;
				if((add + (Ace*11) + 1 + j) < 22){
					finval = (add + (Ace*11) + 1 + j);
					break;
				}
				if(Ace == 0){
					finval = (add + (Ace*11) + 1 + j);
					break;
				}
				
			}
		}
		return finval;
	}
}
