package bowling;

public class ScoreBoard {

	private int[][] score;
	
	public ScoreBoard(int player, int frame) {
		score = new int[player][frame];
	}

	public int[][] calculate(GameRecord gameRecord) {

		//each player
		for (int player = 0; player < score.length; player++) {
			//each frame
			for (int frame = 0; frame < score[player].length; frame++) {
				 FrameRecord currentPin = gameRecord.getPinRecord(player, frame);
				
				if (frame>1 && gameRecord.getPinRecord(player, frame-1).isStrike() && gameRecord.getPinRecord(player, frame-2).isStrike()) {
					score[player][frame-2] += currentPin.getFallenPin(0);
					score[player][frame-1] += (currentPin.getFallenPin(0) + currentPin.getFallenPin()) ;
				} else if (frame > 0 && gameRecord.getPinRecord(player, frame-1).isStrike()) {
					score[player][frame-1] += currentPin.getFallenPin();	
				}
				
				if (frame>0 && gameRecord.getPinRecord(player, frame-1).isSpare())
					score[player][frame-1] += currentPin.getFallenPin(0);
					
					
				if(frame == 0){
					score[player][frame] = gameRecord.getPinRecord(player, frame).getFallenPin();
				}else{
					score[player][frame] = 
						score[player][frame-1] + 
						gameRecord.getPinRecord(player, frame).getFallenPin();	
				}
			}
		}
		return score;
	}
}
