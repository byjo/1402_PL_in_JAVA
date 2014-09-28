package frame;

public class LastFrame extends Frame {
	
	public String getFrameScore(){
		String score="";
		String thirdPoint;
		checkS();
		
		if(pins.size()!=3)
			return super.getFrameScore();
		
		if(pins.get(2)==10)
			thirdPoint="X";
		else
			thirdPoint=pins.get(2)+"";

		if (isStrike)
			return (super.getFrameScore() + thirdPoint + " |");
		
		if (isSpare)
			return (super.getFrameScore() + thirdPoint + " |");
		
		for(int i=0; i<pins.size()-1; i++){
			score += pins.get(i);
			score += " ";
		}
		return score+"  |";
	}
}
