package main;

import main.GameOverException;
import player.Player;
import scoreboard.ScoreBoard;

public class BowlingGame {
	
	public int pins;
	public int numOfRoll=1;
	public ScoreBoard scoreBoard = new ScoreBoard();
	public Player player=new Player();
	
	public void startGame() throws GameOverException{
		while(true){
		pins = player.roll(numOfRoll);
		scoreBoard.saveScore(numOfRoll, pins);
		scoreBoard.printBoard();
		numOfRoll++;
			
		if(numOfRoll==22)
			throw new GameOverException("게임이 끝났습니다!!");
		}
	}
}
