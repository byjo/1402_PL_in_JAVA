package bowling;

import java.util.Arrays;

public class FrameRecord {
	
	private int[] fallenPins = new int[2];

	public void setFallenPin(int period, int numberOfPins) {
		fallenPins[period] = numberOfPins; 
	}
	
	public int getFallenPin(int period) {
		return fallenPins[period]; 
	}

	public int getFallenPin() {
		return Arrays.stream(this.fallenPins).sum();
	}

	public boolean isStrike() {
		return fallenPins[0] == 10;
	}

	public boolean isSpare() {
		return (fallenPins[0] != 10) && (fallenPins[0]+fallenPins[1] == 10);
	}


}
