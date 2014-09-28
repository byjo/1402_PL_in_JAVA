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
	private static Scanner keyboard = new Scanner(System.in); 
	String key="";
	

	/*
	 * startGame : 볼링 게임을 시작한다.
	 * 1. 플레이어가 공을 굴려 쓰러트린 핀의 개수(pins)를 구한다.
	 * 2. scoreBoard에 쓰러트린 핀의 개수를 기록한다.
	 * 3. 현재까지 플레이한 결과를 출력한다.
	 */
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
