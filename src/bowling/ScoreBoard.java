package bowling;

public class ScoreBoard {

	private static int[][] score;
	
	public ScoreBoard(int player, int frame) {
		score = new int[player][frame];
	}

	public static int[][] calculate(GameRecord gameRecord) {

		//each player
		for (int player = 0; player < score.length; player++) {
			//each frame
			for (int frame = 0; frame < score[player].length; frame++) {
				
				if(frame == 0){
					score[player][frame] = gameRecord.getPinRecord(player, frame).getTotalFallenPin();
				}else{
					score[player][frame] = 
						score[player][frame-1] + 
						gameRecord.getPinRecord(player, frame).getTotalFallenPin();	
				}
			}
		}
		return null;
	}
}
