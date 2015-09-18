package bowling;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bowling.exception.GameOverException;
import bowling.exception.OutOfMaxFrameException;
import bowling.exception.OutOfMaxPinNumberException;
import bowling.player.NormalPlayer;

public class BowlingGameTest {
	
	BowlingGame bowlingGame;
	NormalPlayer player1, player2, player3, player4;
	
	@Before
	public void setup() {
		player1 = new NormalPlayer();
		player2 = new NormalPlayer();
		player3 = new NormalPlayer();
		player4 = new NormalPlayer();
		bowlingGame = new BowlingGame(player1, player2, player3, player4);
	}
	
	@Test
	public void startGame() {
		assertTrue(bowlingGame instanceof BowlingGame);
	}
	
	@Test(expected=OutOfMaxFrameException.class)
	public void playFrameTest() throws OutOfMaxPinNumberException, OutOfMaxFrameException {
		for (int i=0; i<11; i++) {
			bowlingGame.playFrame();
			assertEquals(i, bowlingGame.getPlayedFrame());
		}
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
