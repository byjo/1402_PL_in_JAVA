package bowling;

import java.util.Arrays;

public class GameRecord {
	
	private FrameRecord[][] frameRecords;
	
	public GameRecord() {
		
	}

	public GameRecord(int numberOfplayer, int frame) {
		this.frameRecords = new FrameRecord[numberOfplayer][frame];
	}

	public void setPinRecord(int player, int frame, FrameRecord frameRecord) {
		this.frameRecords[player][frame] = frameRecord;
	}
	
	public FrameRecord getPinRecord(int player, int frame) {
		return this.frameRecords[player][frame];
	}
	

}
