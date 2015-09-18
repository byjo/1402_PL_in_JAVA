package bowling.player;

import java.util.ArrayList;
import java.util.List;

import bowling.exception.OutOfMaxFrameException;
import bowling.exception.OutOfMaxPinNumberException;
import bowling.frame.Frame;
import bowling.frame.FrameFactory;

public class NormalPlayer implements Player{
	
	private List<Frame> frames = new ArrayList<Frame>();
	
	private int roll() {
		return (int)Math.floor(Math.random()*11);
	}
	
	private int roll(int leftPins) {
		return (int)Math.floor(Math.random()*(leftPins + 1));
	}
	
	public void playFrame() throws OutOfMaxPinNumberException, OutOfMaxFrameException {
		if(getPlayedFrameNumber() == 9) throw new OutOfMaxFrameException();
		int firstPins = roll();
		int secondPins = roll(10-firstPins);
		
		
		if (getPlayedFrameNumber() == -1)
			frames.add(FrameFactory.getFrame(firstPins, secondPins));
		else
			frames.add(frames.get(getPlayedFrameNumber()).createNextFrame(firstPins, secondPins));
	}

	public Frame getFrame(int frameIndex) {
		return frames.get(frameIndex);
	}
	
	public int getPlayedFrameNumber() {
		return frames.size()-1;
	}

	@Override
	public int getFrameScore(int frameIndex) {
		return frames.get(frameIndex).caculate();
	}

}
