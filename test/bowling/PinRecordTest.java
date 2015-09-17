package bowling;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PinRecordTest {

	FrameRecord pinRecord;
	
	@Before
	public void before() throws Exception {
		pinRecord = new FrameRecord();
	}
	
	@Test
	public void isStrikeTest() {
		pinRecord.setFallenPin(0, 10);
		assertTrue(pinRecord.isStrike());
	}
	
	@Test
	public void isSpareTest() {
		pinRecord.setFallenPin(0, 5);
		pinRecord.setFallenPin(1, 5);
		
		assertFalse(pinRecord.isStrike());
		assertTrue(pinRecord.isSpare());
	}

}
