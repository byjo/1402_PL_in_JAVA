package scoreboard;

import frame.Frame;
import frame.LastFrame;

public class ScoreBoard {
	public int currentFrame=0;
	public int currentRoll=0;
	public Frame[] scoreBoard = new Frame[10];
	
	/*
	 * ScoreBoard : 점수판은 9개의 일반 프레임과 1개의 마지막 프레임으로 이루어진다.
	 */
	public ScoreBoard() {
		int i;
		for(i=0; i<9; i++){
			scoreBoard[i] = new Frame();
		}
		scoreBoard[i] = new LastFrame();
	}
	
	/*
	 * saveScore : 투구 횟수에 따라 현재 프레임수를 계산하고, 이 프레임에 쓰러트린 핀의 개수를 기록한다.
	 */
	public void saveScore(int numOfRoll, int pins){
		if (numOfRoll%2!=0 && numOfRoll!=21)
			currentFrame++;
		scoreBoard[currentFrame-1].savePins(pins);
		this.currentRoll=numOfRoll;
	}

	/*
	 * printBoard : 점수판을 출력한다.
	 */
	public void printBoard(){
		printInfo();
		printOutline();
		printFrameNumber();
		printInnerLine();
		printFrameScore();
		printTotalScore();
		printOutline();
	}
	
	// printInfo : 안내문을 출력한다.
	public void printInfo(){
		System.out.println("엔터키를 눌러 공을 던지세요!");
	}
	
	// printOutline : 점수판의 외곽선을 출력한다.
	public void printOutline(){
		System.out.println("===============================================================");
	}
	
	// printInnerLine : 점수판의 내부 선을 출력한다.
	public void printInnerLine(){
		System.out.println("---------------------------------------------------------------");
	}
	
	// printFrameNumber : 점수판의 프레임 번호를 출력한다.
	public void printFrameNumber(){
		System.out.println("|  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |   10  |");
	}
	
	// printFrameScore : 각 프레임의 점수 표시를 출력한다.
	public void printFrameScore(){
		for(int i=0; i<currentFrame; i++){
			System.out.printf("| %2s", scoreBoard[i].getFrameScore());
		}
		System.out.println("");
	}
	
	/*
	 *  printTotalScore : 각 프레임의 점수를 출력한다.
	 *  - 프레임의 총점은 기본 점수와 보너스 점수로 구성된다.
	 *  - 기본 점수는 첫 번째, 두 번째 시도 때 쓰러트린 핀의 개수(getFrameTotal)이다.
	 *  - 보너스 점수(getbonusScore)는 스트라이크나 스페어 발생 시, 다음 프레임의 쓰러트린 핀의 개수로 결정되는 점수이다.
	 */
	public void printTotalScore(){			
		int totalScore=0;
		for(int i=0; i<currentFrame; i++){
			totalScore += scoreBoard[i].getFrameTotal();
			totalScore += this.getBonusScore(i);
			System.out.printf("| %3d ", totalScore);
		}
		if(currentRoll==21)
			System.out.printf("  |", totalScore);
		System.out.println("");
	}
	
	/*
	 *  printTotalScore : 각 프레임의 보너스 점수를 출력한다.
	 *  - 다음 프레임이 진행되지 않았을 때, 보너스 점수는 0점으로 반환한다. (게임이 진행된 후 갱신 가능)
	 *  - 스트라이크를 했을 땐, 이후 두 번의 투구로 쓰러트린 핀의 개수를 반환한다.
	 *  - 이 두번의 투구는 일반적으로 다음 프레임의 첫 번째, 두 번째 시도로 결정되나, 
	 *  첫 번째 시도에 또 다시 스트라이크가 발생하면 그 다음 프레임의 첫 번째 시도로 결정된다.
	 *  - 스페어를 했을 땐, 이후 한 번의 투구(다음 프레임의 첫 번째 시도)로 쓰러트린 핀의 개수를 반환한다.
	 */
	public int getBonusScore (int numOfFrame){
		int bonusFirst;
		int bonusSecond;
		
		if(numOfFrame==currentFrame-1)
			return 0;
		
		if(scoreBoard[numOfFrame].checkStrike()){
			if(numOfFrame==currentFrame-2 && currentRoll%2==1)
				return 0;
			
			bonusFirst = scoreBoard[numOfFrame+1].getFirstPoint();
			
			if(bonusFirst==10){
				if(numOfFrame==currentFrame-2)
					return 0;
				bonusSecond=scoreBoard[numOfFrame+2].getFirstPoint();
				return bonusFirst+bonusSecond;
			}
			bonusSecond=scoreBoard[numOfFrame+1].getSecondPoint();	
			return bonusFirst+bonusSecond;
		}
		
		if(scoreBoard[numOfFrame].checkSpare()){
			return scoreBoard[numOfFrame+1].getFirstPoint();
		}
		
		return 0;
	}
}
