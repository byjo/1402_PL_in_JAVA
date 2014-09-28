package frame;

public class LastFrame extends Frame {
	
	/* override
	 * getFrameScore : scoreBoard에서 프린트할 각 프레임의 점수판을 반환한다.
	 */
	public String getFrameScore(){
		String score="";
		String thirdPoint;
		checkS();
		
		// 세번째 공을 던지지 않았을 때, 부모 클래스의 점수판 반환을 사용한다.
		if(pins.size()!=3)
			return super.getFrameScore();
		
		// 세번째 공을 던졌을 때, 스트라이크 혹은 거터 여부를 확인한다.
		if(pins.get(2)==10)
			thirdPoint="X";
		else if(pins.get(2)==0)
			thirdPoint="-";
		else
			thirdPoint=pins.get(2)+"";

		if (isStrike)
			return (super.getFrameScore() + thirdPoint + " |");
		
		if (isSpare)
			return (super.getFrameScore() + thirdPoint + " |");
		
		for(int i=0; i<pins.size()-1; i++){
			if(pins.get(i)==0)
				score += "- ";
			else{
				score += pins.get(i);
				score += " ";
			}
		}
		return score+"  |";
	}
}
