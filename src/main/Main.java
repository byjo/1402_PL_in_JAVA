package main;

public class Main {
	public static void main(String[] args) {
		BowlingGame game = new BowlingGame();
		try {
			game.startGame();
		} catch (GameOverException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
}
