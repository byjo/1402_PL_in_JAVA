package player;

public class Player {
	public int MAXPINS=10;
	public int leftPins;
	public int pins;
	
	public int roll(int numOfRoll) {
		if(numOfRoll==20){
			pins= ((int)(Math.random()*leftPins)+1);
			leftPins-=pins;
			return pins;
		}
		
		if(numOfRoll==21){
			if(leftPins==0){
				pins= ((int) (Math.random()*MAXPINS) + 1);
				return pins;
			}
			return 0;
		}
		
		if (numOfRoll%2!=0){
			pins= ((int) (Math.random()*MAXPINS) + 1);
			leftPins=MAXPINS-pins;
			return pins;
		}
		
		if(leftPins==0)
			return 0;
		pins= ((int)(Math.random()*leftPins)+1);
		return pins;
	}
}
