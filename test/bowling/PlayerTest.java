package bowling;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	
	Player player;

	@Before
	public void setUp() {
		player = new Player();
	}
	
	@Test
	public void roll() throws Exception {
		for(int i=0; i < 100; i++){
			int point = player.roll();
			assertTrue(point <= 10 && point >= 0);
		}
	}
}
