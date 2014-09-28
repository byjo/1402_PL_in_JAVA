package scoreboard;

import frame.Frame;
import frame.LastFrame;

public class ScoreBoard {
	public int currentFrame=0;
	public int currentRoll=0;
	public Frame[] scoreboard = new Frame[10];
	
	public ScoreBoard() {
		int i;
		for(i=0; i<9; i++){
			scoreboard[i] = new Frame();
		}
		scoreboard[i] = new LastFrame();
	}
	
	public void saveScore(int numOfRoll, int pins){
		if (numOfRoll%2!=0 && numOfRoll!=21)
			currentFrame++;
		scoreboard[currentFrame-1].savePins(pins);
		this.currentRoll=numOfRoll;
	}

	public void printBoard(){
		printInfo();
		printOutline();
		printFrameNumber();
		printInnerLine();
		printFrameScore();
		printMidScore();
		printTotalScore();
		printOutline();
		System.out.println("");
	}
	
	public void printInfo(){
		System.out.println("엔터키를 눌러 공을 던지세요!");
	}
	
	public void printOutline(){
		System.out.println("===============================================================");
	}
	
	public void printInnerLine(){
		System.out.println("---------------------------------------------------------------");
	}
	
	public void printFrameNumber(){
		System.out.println("|  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |   10  |");
	}
	
	public void printFrameScore(){
		for(int i=0; i<currentFrame; i++){
			System.out.printf("| %2s", scoreboard[i].getFrameScore());
		}
		System.out.println("");
	}
	
	public void printMidScore(){
		for(int i=0; i<currentFrame; i++){
			System.out.printf("| %2d  ", scoreboard[i].getFrameTotal());
		}
		System.out.println("");
	}
	
	public void printTotalScore(){			
		int totalScore=0;
		for(int i=0; i<currentFrame; i++){
			totalScore += scoreboard[i].getFrameTotal();
			totalScore += this.getBonusScore(i);
			System.out.printf("| %3d ", totalScore);
		}
		if(currentRoll==21)
			System.out.printf("  |", totalScore);
		System.out.println("");
	}
	
	public int getBonusScore (int numOfFrame){
		int bonusFirst;
		int bonusSecond;
		if(numOfFrame==currentFrame-1)
			return 0;
		if(scoreboard[numOfFrame].checkStrike()){
			if(numOfFrame==currentFrame-2 && currentRoll%2==1)
				return 0;
			bonusFirst = scoreboard[numOfFrame+1].getFirstPoint();
			
			if(bonusFirst==10){
				if(numOfFrame==currentFrame-2)
					return 0;
				bonusSecond=scoreboard[numOfFrame+2].getFirstPoint();
				return bonusFirst+bonusSecond;
			}
			bonusSecond=scoreboard[numOfFrame+1].getSecondPoint();	
			return bonusFirst+bonusSecond;
		}
		
		if(scoreboard[numOfFrame].checkSpare()){
			return scoreboard[numOfFrame+1].getFirstPoint();
		}
		return 0;
	}
}
