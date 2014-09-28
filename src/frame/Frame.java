package frame;

import java.util.ArrayList;

public class Frame {
	ArrayList<Integer> pins = new ArrayList<Integer>();
	boolean isStrike;
	boolean isSpare;
	
	public void savePins(int numOfPin) {
		pins.add(numOfPin);
	}
	
	public void checkS(){
		if (pins.size()==1){
			isStrike = checkStrike();
			return;
		}
		isSpare=checkSpare();
	}
	
	public boolean checkStrike(){
		if(pins.get(0)==10) {
			return true;
		}
		return false;
	}
	
	public boolean checkSpare(){
		if(pins.size()==1)
			return false;
		if(pins.get(0)+pins.get(1)==10)
			return true;
		return false;
	}
	
	public int getFirstPoint() {
		return pins.get(0);
	}

	public int getSecondPoint() {
		return pins.get(1);
	}
	
	public int getFrameTotal() {
		int total=0;
		for(int i=0; i<pins.size(); i++){
			total += pins.get(i);
		}
		return total;
	}
	
	public String getFrameScore(){
		String score="";
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
