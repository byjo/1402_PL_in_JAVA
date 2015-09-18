package bowling.frame;

import bowling.exception.OutOfMaxPinNumberException;


public class FrameFactory {

	public static Frame getFrame(int firstPins, int secondPins) throws OutOfMaxPinNumberException{
		if (firstPins + secondPins > 10) 
			throw new OutOfMaxPinNumberException();
		
		if (firstPins == 10)
			return new StrikeFrame();
		
		else if (firstPins + secondPins == 10)
			return new SpareFrame(firstPins, secondPins);
		
		//TODO last frame처리 
		return new MissFrame(firstPins, secondPins);
	}

}
