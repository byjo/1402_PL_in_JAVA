package bowling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bowling.player.*;

public class ScoreBoardTest {

	ScoreBoard scoreBoard;
	int numberOfFrame = 10;
	int[] totalResult = {18, 26, 54, 72, 80, 99, 108, 126, 135};
	
	Player p1;
	
	@Before
	public void before() throws Exception {
		p1 = new MockPlayer();
		scoreBoard = new ScoreBoard(p1);
	}
	
	@Test
	public void accumulativeScoreTest() throws Exception {
		for (int i = 0; i < totalResult.length; i++) {
			assertEquals(totalResult[i], scoreBoard.getAccumulativeScore(0,i));	
		}
	}
	
	
	//TODO
	@Test
	public void printScoreTest() throws Exception {
		assertEquals("9/8-x x 8-X 819/81", scoreBoard.getAllScoresAsString(0));
	}
}
