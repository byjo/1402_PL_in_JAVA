package frame;

import java.util.ArrayList;

public class Frame {
	ArrayList<Integer> pins = new ArrayList<Integer>();
	boolean isStrike;
	boolean isSpare;
	
	/*
	 * savePins : 쓰러트린 핀의 개수를 저장한다.
	 */
	public void savePins(int numOfPin) {
		pins.add(numOfPin);
	}
	
	/*
	 * checkS : 스트라이크, 스페어 여부를 확인한다.
	 */
	public void checkS(){
		if (pins.size()==1){
			isStrike = checkStrike();
			return;
		}
		isSpare=checkSpare();
	}
	
	/*
	 * checkStrike : 스트라이크 여부를 확인 후, 그 결과를 반환한다.
	 */
	public boolean checkStrike(){
		if(pins.get(0)==10) {
			return true;
		}
		return false;
	}
	
	/*
	 * checkSpare : 스트라이크 여부를 확인 후, 그 결과를 반환한다.
	 */
	public boolean checkSpare(){
		if(pins.size()==1)
			return false;
		if(pins.get(0)+pins.get(1)==10)
			return true;
		return false;
	}
	
	/*
	 * getFirstPoint : 첫번째로 쓰러트린 핀의 개수를 반환한다.
	 */
	public int getFirstPoint() {
		return pins.get(0);
	}

	/*
	 * getFirstPoint : 두번째로 쓰러트린 핀의 개수를 반환한다.
	 */
	public int getSecondPoint() {
		return pins.get(1);
	}
	
	/*
	 * getFrameTotal : 현재 프레임에서 쓰러트린 핀의 총 개수를 반환한다.
	 */
	public int getFrameTotal() {
		int total=0;
		for(int i=0; i<pins.size(); i++){
			total += pins.get(i);
		}
		return total;
	}
	
	/*
	 * getFrameScore : scoreBoard에서 프린트할 각 프레임의 점수판을 반환한다.
	 */
	public String getFrameScore(){
		String score="";
		// 스트라이크, 스페어 여부 확인
		checkS();
		
		if (isStrike)
			return "X   ";
		if (isSpare)
			return pins.get(0) + " / " ;
		
		for(int i=0; i<pins.size(); i++){
			score += pins.get(i);
			score += " ";
		}
		return score;
	}
}
