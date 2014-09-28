package main;

import java.util.Scanner;

import main.GameOverException;
import player.Player;
import scoreboard.ScoreBoard;

public class BowlingGame {
	
	public int pins;
	public int numOfRoll=1;
	public ScoreBoard scoreBoard = new ScoreBoard();
	public Player player=new Player();
	String key="";
	private static Scanner keyboard = new Scanner(System.in); 
	
	public void startGame() throws GameOverException{
		System.out.println("엔터키를 누르면 첫번째 공을 던지며 게임을 시작합니다.");
		while(true){
			key=keyboard.nextLine();
		
			pins = player.roll(numOfRoll);
			scoreBoard.saveScore(numOfRoll, pins);
			scoreBoard.printBoard();
			numOfRoll++;
		
			if(numOfRoll==22)
				throw new GameOverException("게임이 끝났습니다!!");
		}
	}
}
