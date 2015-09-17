package bowling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScoreBoardTest {

	GameRecord gameRecord;
	int numberOfFrame = 10;
	int numberOfplayer = 4;
	
	@Before
	public void before() throws Exception {
		gameRecord = new GameRecord(numberOfplayer, numberOfFrame);
	}

	//TODO	
//	@Test
//	public void totalScoreTest() {
//		for (int i = 0; i < numberOfplayer; i++) {
//			assertEquals(scoreBoard.getTotalScore(i), i*10);
//		}
//	}
	
	@Test
	public void calculateScoreTest() throws Exception {
		
		//each player
		for (int player = 0; player < numberOfplayer; player++) {
			//each frame
			for (int frame = 0; frame < numberOfFrame ; frame++) {
				FrameRecord frameRecord = new FrameRecord();
				frameRecord.setFallenPin(0, player);
				frameRecord.setFallenPin(1, player);
				gameRecord.setPinRecord(player, frame, frameRecord);
			}
		}
		
		int[][] result = ScoreBoard.calculate(gameRecord);
		
		//each player
		for (int player = 0; player < numberOfplayer; player++) {
			//each frame
			for (int frame = 0; frame < numberOfFrame ; frame++) {
				if (frame == 0) {
					assertEquals(result[player][frame], 2*player); 
				} else {
					assertEquals(result[player][frame], result[player][frame-1]+2*player); 
				}
			}
		}
	}
}
