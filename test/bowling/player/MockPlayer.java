package bowling.player;

import bowling.exception.OutOfMaxPinNumberException;
import bowling.frame.Frame;
import bowling.player.Player;

public class MockPlayer implements Player {

	int[] frameResult = {18, 8, 28, 18, 8, 19, 9, 18, 9, 20};

	@Override
	public void playFrame() throws OutOfMaxPinNumberException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Frame getFrame(int frameIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPlayedFrameNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFrameScore(int frameIndex) {
		return frameResult[frameIndex];
	}

	
}
