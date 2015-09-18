package bowling.frame;

public class StrikeFrame extends Frame{

	private int firstPins = 10;

	@Override
	public int caculate() {
		return getFirstPins() +this.getNextFrame().getTotalPins();
	}

	@Override
	public int getFirstPins() {
		return this.firstPins;
	}

	@Override
	public int getTotalPins() {
		return getFirstPins() + this.getNextFrame().getFirstPins();
	}

}
