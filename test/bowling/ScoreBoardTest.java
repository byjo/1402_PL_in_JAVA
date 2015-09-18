package bowling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScoreBoardTest {

	GameRecord gameRecord;
	ScoreBoard scoreBoard;
	int numberOfFrame = 10;
	int numberOfplayer = 4;
	
	@Before
	public void before() throws Exception {
		gameRecord = new GameRecord(numberOfplayer, numberOfFrame);
		scoreBoard = new ScoreBoard(numberOfplayer, numberOfFrame);
	}

	//TODO	
//	@Test
//	public void totalScoreTest() {
//		for (int i = 0; i < numberOfplayer; i++) {
//			assertEquals(scoreBoard.getTotalScore(i), i*10);
//		}
//	}
	
	@Test
	public void calculateMissScoreTest() throws Exception {
		
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
		
		
		int[][] result = scoreBoard.calculate(gameRecord);
		
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
	
	@Test
	public void calculateScoreTest() throws Exception {
		
		gameRecord = new GameRecord(1, 2);
		scoreBoard = new ScoreBoard(1, 2);
		
		FrameRecord frameRecord1 = new FrameRecord();
		frameRecord1.setFallenPin(0, 10);
		frameRecord1.setFallenPin(1, 0);
		gameRecord.setPinRecord(0, 0, frameRecord1);
		
		FrameRecord frameRecord2 = new FrameRecord();
		frameRecord2.setFallenPin(0, 5);
		frameRecord2.setFallenPin(1, 3);
		gameRecord.setPinRecord(0, 1, frameRecord2);		
		
		int[][] result = scoreBoard.calculate(gameRecord);
		
		assertEquals(18, result[0][0]);
		assertEquals(26, result[0][1]);
	}
	
	@Test
	public void calculate2StrikesScoreTest() throws Exception {
		
		gameRecord = new GameRecord(1, 3);
		scoreBoard = new ScoreBoard(1, 3);
		
		FrameRecord frameRecord1 = new FrameRecord();
		frameRecord1.setFallenPin(0, 10);
		frameRecord1.setFallenPin(1, 0);
		gameRecord.setPinRecord(0, 0, frameRecord1);
		
		FrameRecord frameRecord2 = new FrameRecord();
		frameRecord2.setFallenPin(0, 10);
		frameRecord2.setFallenPin(1, 0);
		gameRecord.setPinRecord(0, 1, frameRecord2);	
		
		FrameRecord frameRecord3 = new FrameRecord();
		frameRecord3.setFallenPin(0, 5);
		frameRecord3.setFallenPin(1, 3);
		gameRecord.setPinRecord(0, 2, frameRecord3);		
		
		int[][] result = scoreBoard.calculate(gameRecord);
		
		assertEquals(25, result[0][0]);
		assertEquals(43, result[0][1]);
		assertEquals(51, result[0][2]);
	}
	
	@Test
	public void calculateSpareScoreTest() throws Exception {
		
		gameRecord = new GameRecord(1, 2);
		scoreBoard = new ScoreBoard(1, 2);
		
		FrameRecord frameRecord1 = new FrameRecord();
		frameRecord1.setFallenPin(0, 5);
		frameRecord1.setFallenPin(1, 5);
		gameRecord.setPinRecord(0, 0, frameRecord1);
		
		FrameRecord frameRecord2 = new FrameRecord();
		frameRecord2.setFallenPin(0, 9);
		frameRecord2.setFallenPin(1, 0);
		gameRecord.setPinRecord(0, 1, frameRecord2);			
		
		int[][] result = scoreBoard.calculate(gameRecord);
		
		assertEquals(19, result[0][0]);
		assertEquals(28, result[0][1]);
	}
	
	@Test
	public void calculateGivenDataScoreTest() throws Exception {
		
		gameRecord = new GameRecord(1, 9);
		scoreBoard = new ScoreBoard(1, 9);
		
		FrameRecord frameRecord0 = new FrameRecord();
		frameRecord0.setFallenPin(0, 9);
		frameRecord0.setFallenPin(1, 1);
		gameRecord.setPinRecord(0, 0, frameRecord0);
		
		FrameRecord frameRecord1 = new FrameRecord();
		frameRecord1.setFallenPin(0, 8);
		frameRecord1.setFallenPin(1, 0);
		gameRecord.setPinRecord(0, 1, frameRecord1);
		
		FrameRecord frameRecord2 = new FrameRecord();
		frameRecord2.setFallenPin(0, 10);
		frameRecord2.setFallenPin(1, 0);
		gameRecord.setPinRecord(0, 2, frameRecord2);
		
		FrameRecord frameRecord3 = new FrameRecord();
		frameRecord3.setFallenPin(0, 10);
		frameRecord3.setFallenPin(1, 0);
		gameRecord.setPinRecord(0, 3, frameRecord3);
		
		FrameRecord frameRecord4 = new FrameRecord();
		frameRecord4.setFallenPin(0, 8);
		frameRecord4.setFallenPin(1, 0);
		gameRecord.setPinRecord(0, 4, frameRecord4);
		
		FrameRecord frameRecord5 = new FrameRecord();
		frameRecord5.setFallenPin(0, 10);
		frameRecord5.setFallenPin(1, 0);
		gameRecord.setPinRecord(0, 5, frameRecord5);
		
		FrameRecord frameRecord6 = new FrameRecord();
		frameRecord6.setFallenPin(0, 8);
		frameRecord6.setFallenPin(1, 1);
		gameRecord.setPinRecord(0, 6, frameRecord6);
		
		FrameRecord frameRecord7 = new FrameRecord();
		frameRecord7.setFallenPin(0, 9);
		frameRecord7.setFallenPin(1, 1);
		gameRecord.setPinRecord(0, 7, frameRecord7);
		
		FrameRecord frameRecord8 = new FrameRecord();
		frameRecord8.setFallenPin(0, 8);
		frameRecord8.setFallenPin(1, 1);
		gameRecord.setPinRecord(0, 8, frameRecord8);
				
		int[][] result = scoreBoard.calculate(gameRecord);
		
		assertEquals(18, result[0][0]);
		assertEquals(26, result[0][1]);
		assertEquals(54, result[0][2]);
		assertEquals(72, result[0][3]);
		assertEquals(80, result[0][4]);
		assertEquals(99, result[0][5]);
		assertEquals(108, result[0][6]);
		assertEquals(126, result[0][7]);
		assertEquals(135, result[0][8]);
	}
}
