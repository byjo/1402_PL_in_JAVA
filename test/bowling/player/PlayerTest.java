package bowling.player;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import bowling.frame.Frame;
import bowling.player.NormalPlayer;

public class PlayerTest {
	
	NormalPlayer player;

	@Before
	public void setUp() {
		player = new NormalPlayer();
	}
	
//	@Test
//	public void roll() throws Exception {
//		for(int i=0; i < 100; i++){
//			int point = player.roll();
//			assertTrue(point <= 10 && point >= 0);
//		}
//	}
	
	@Test
	public void playFrametest() throws Exception {
		player.playFrame();
		assertTrue(player.getFrame(0) instanceof Frame);
		
		player.playFrame();
		assertTrue(player.getFrame(1) instanceof Frame);
		
		
	}
}
