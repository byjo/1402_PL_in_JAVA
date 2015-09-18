package bowling;

import java.util.Arrays;
import java.util.List;

import bowling.exception.GameOverException;
import bowling.exception.OutOfMaxFrameException;
import bowling.exception.OutOfMaxPinNumberException;
import bowling.player.NormalPlayer;
import bowling.player.Player;

public class BowlingGame {
	
	private List<Player> players;
	private ScoreBoard scoreBoard; 

	public BowlingGame(Player ... players) {
		 this.players = Arrays.asList(players);
		 scoreBoard = new ScoreBoard(players);
	}
	
	public void start() throws OutOfMaxPinNumberException, OutOfMaxFrameException {
		while(isFinished()) {
			playFrame();
		}
		end();
	}
	
	public void playFrame() throws OutOfMaxPinNumberException, OutOfMaxFrameException {
		for (Player player : players) {
			player.playFrame();
		}
	}

	public void end() {
		throw new GameOverException();
	}
	
	public int getPlayedFrame() {
		return players.get(players.size()-1).getPlayedFrameNumber();
	}
	
	public boolean isFinished() {
		return players.get(players.size()-1).getPlayedFrameNumber() == 10;
	}

	public List<Player> getPlayers() {
		return this.players;
	}
	
	public Player getPlayers(int index) {
		return this.players.get(index);
	}

}
