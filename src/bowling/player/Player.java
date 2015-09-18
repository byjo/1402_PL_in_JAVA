package bowling.player;

import bowling.exception.OutOfMaxFrameException;
import bowling.exception.OutOfMaxPinNumberException;
import bowling.frame.Frame;
import bowling.frame.FrameFactory;

public interface Player {

	public void playFrame() throws OutOfMaxPinNumberException, OutOfMaxFrameException;

	public Frame getFrame(int frameIndex);
	
	public int getPlayedFrameNumber();
	
	public int getFrameScore(int frameIndex);
}
