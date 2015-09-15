package bowling;

import java.util.Arrays;
import java.util.List;

public class BowlingGame {
	
	List<Player> players;

	public BowlingGame(Player ... players) {
		 this.players = Arrays.asList(players);
	}
	
	public void start() {
	}

	public void end() {
		throw new GameOverException();
	}

	public List<Player> getPlayers() {
		return this.players;
	}
	
	public Player getPlayers(int index) {
		return this.players.get(index);
	}

}
