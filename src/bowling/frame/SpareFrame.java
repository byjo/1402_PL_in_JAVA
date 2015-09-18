package bowling.frame;

public class SpareFrame extends Frame{
	private int firstPins;
	private int secondPins;
	
	public SpareFrame(int firstPins, int secondPins) {
		this.firstPins = firstPins;
		this.secondPins = secondPins;
	}

	@Override
	public int caculate() {
		return this.getTotalPins() + this.getNextFrame().getFirstPins();
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
