package bowling.frame;

public class MissFrame extends Frame {
	private int firstPins;
	private int secondPins;
	
	public MissFrame(int firstPins, int secondPins) {
		this.firstPins = firstPins;
		this.secondPins = secondPins;
	}

	@Override
	public int caculate() {
		return this.firstPins + this.secondPins;
	}
	
	@Override
	public int getFirstPins() {
		return this.firstPins;
	}
	
	@Override
	public int getTotalPins() {
		return this.firstPins + this.secondPins;
	}
}
