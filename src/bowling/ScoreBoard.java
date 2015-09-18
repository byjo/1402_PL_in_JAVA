package bowling;

import bowling.player.Player;

public class ScoreBoard {
	
	private Player[] players;

	public ScoreBoard(Player ... players) {
		this.players = players;
	}

	public int getAccumulativeScore(int playerIndex, int frameIndex) {
		int sum=0;
		
		for (int i=0; i<=frameIndex; i++) {
			sum += players[playerIndex].getFrameScore(i);
		}
		
		return sum;
	}

	//TODO
	public String getAllScoresAsString(int playerIndex) {
		String result = "";
		for(int i=0; i<10; i++){
			getAccumulativeScore(playerIndex, i);
		}
		return null;
	}
}
