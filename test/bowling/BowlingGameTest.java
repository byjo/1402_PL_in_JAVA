package bowling;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
	
	BowlingGame bowlingGame;
	Player player1, player2, player3, player4;
	
	@Before
	public void setup() {
		player1 = new Player();
		player2 = new Player();
		player3 = new Player();
		player4 = new Player();
		bowlingGame = new BowlingGame(player1, player2, player3, player4);
	}
	
	@Test
	public void startGame() {
		assertTrue(bowlingGame instanceof BowlingGame);
	}
	
	@Test
	public void setPlayers() {
		assertTrue(bowlingGame.getPlayers(0) == player1);
		assertTrue(bowlingGame.getPlayers(1) == player2);
		assertTrue(bowlingGame.getPlayers(2) == player3);
		assertTrue(bowlingGame.getPlayers(3) == player4);
		assertTrue(bowlingGame.getPlayers().size() == 4);
	}
	
	@Test(expected=GameOverException.class)
	public void terminateGame() {
		bowlingGame.end();
	}
	
	
}
