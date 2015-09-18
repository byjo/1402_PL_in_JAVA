package bowling.frame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bowling.exception.OutOfMaxPinNumberException;


public class FrameTest {

	
	@Before
	public void setup(){
	}
	
	@Test
	public void fftest() throws OutOfMaxPinNumberException {
		assertTrue(FrameFactory.getFrame(10,0) instanceof StrikeFrame);
		assertTrue(FrameFactory.getFrame(5,5) instanceof SpareFrame);
		assertTrue(FrameFactory.getFrame(1,3) instanceof MissFrame);
		
	}
	
	@Test
	public void getNextTest() throws OutOfMaxPinNumberException {
		Frame currentFrame = FrameFactory.getFrame(10,0);
		Frame nextFrame = currentFrame.createNextFrame(5, 5);
		assertEquals(nextFrame, currentFrame.getNextFrame());
	}
	
	@Test
	public void calcuateTest() throws OutOfMaxPinNumberException {
		List<Frame> frames = new ArrayList<Frame>();

		int[] frameResult = {18, 8, 28, 18, 8, 19, 9, 18, 9, 20};
		
		frames.add(FrameFactory.getFrame(9,1));
		frames.add(frames.get(0).createNextFrame(8, 0));
		frames.add(frames.get(1).createNextFrame(10, 0));
		frames.add(frames.get(2).createNextFrame(10, 0));
		frames.add(frames.get(3).createNextFrame(8, 0));
		frames.add(frames.get(4).createNextFrame(10, 0));
		frames.add(frames.get(5).createNextFrame(8, 1));
		frames.add(frames.get(6).createNextFrame(9, 1));
		frames.add(frames.get(7).createNextFrame(8, 1));
		
		//TODO 언젠간 해보겠지 
//		Arrays.stream(frames.toArray()).forEach((frame) -> frame.calculate());
		
		for(int i=0; i<frames.size(); i++) {
			assertEquals(frameResult[i], frames.get(i).caculate());
		}
	}

}
