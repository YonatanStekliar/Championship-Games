package Model;

import java.util.List;

public class Tennis extends Game {
	private int score1 = 0;
	private int score2 = 0;
	int win;

	public Tennis() {
		super();
	}

	public Tennis(List<String> name) {
		super(name);
	}

	public void winAGame(int win, int gameIndex, int tournamentIndex) {
		super.winAQuarterFinals(win, gameIndex, tournamentIndex);
	}

	public int whichPlayerWinsIn3sets(int[] player1, int[] player2) {
		win = 0;
		score1 = 0;
		score2 = 0;
		for (int i = 0; i < 3; i++) {
			if (player1[i] > player2[i])
				score1++; // sums the score of player 1 in all sets of the game
			else if (player1[i] < player2[i])
				score2++; // sums the score of player 2 in all sets of the game
		}
		if (score1 == 3 && score2 == 0) {
			win = 1; // p1 wins
			return win;
		} else if (score2 == 3 && score1 == 0) {
			win = 2; // p2 wins
			return win;
		}
		return win; // tie
	}

	public int whichPlayerWinsIn5Sets(int[] player1, int[] player2) { // will be activated if needed in the controller
		win = 0;
		for (int i = 0; i < 2; i++) {
			if (player1[i + 3] > player2[i + 3])
				score1++; // sums the score of player 1 in all sets of the game
			else if (player1[i + 3] < player2[i + 3])
				score2++; // sums the score of player 2 in all sets of the game
		}
		if ((score1 == 4 && score2 == 1) || (score1 == 3 && score2 == 2)) {
			win = 1;
			return win; // p1 wins
		} else if ((score2 == 4 && score1 == 1) || (score2 == 3 && score1 == 2)) {
			win = 2; // p2 wins
			return win;
		}

		return win; // tie - controller will randomize the winner
	}

	public void createPlayerOrTeam(List<String> name) {
		super.createPlayerOrTeam(name);
	}
}
