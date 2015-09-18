package bowling.frame;

import bowling.exception.OutOfMaxPinNumberException;

public abstract class Frame {
	
	private Frame nextFrame;
	
	public abstract int caculate();	

	public Frame createNextFrame(int firstPins, int secondPins) throws OutOfMaxPinNumberException {
		this.nextFrame = FrameFactory.getFrame(firstPins, secondPins);
		return this.nextFrame;
	}
	
	public Frame getNextFrame(){
		return this.nextFrame;
	}

	public abstract int getFirstPins();

	public abstract int getTotalPins();
}
