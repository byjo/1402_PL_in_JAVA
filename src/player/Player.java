package player;

public class Player {
	public int MAXPINS=10;
	public int leftPins;
	public int pins;
	
	/*
	 * roll : 공을 굴려 쓰러트린 핀의 개수를 반환한다.
	 * - 각 프레임의 첫번째 시도 때, 핀의 개수를 0~10사이의 숫자를 랜덤으로 발생시키고, 남은 핀의 개수를 저장해둔다.
	 * - 각 프레임의 두번째 시도 때, 남읜 핀의 개수 중 랜덤으로 숫자가 발생한다.
	 * - 마지막 프레임의 두번째 시도 때, 남은 핀의 개수를 저장해둔다.
	 * - 만약 위에서 저장한 핀의 개수가 0개라면, 보너스 보너스 투구를 한다.
	 */
	public int roll(int numOfRoll) {
		if(numOfRoll==20){
			pins= ((int)(Math.random()*leftPins));
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
		pins= ((int)(Math.random()*leftPins));
		return pins;
	}
}
