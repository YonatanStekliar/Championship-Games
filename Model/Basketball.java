package Model;

import java.util.List;

public class Basketball extends Game {
	int win;

	public Basketball() {
		super();
	}

	public Basketball(List<String> name) {
		super(name);
	}

	public int whichTeamWin(int[] team1, int[] team2) {
		int score1 = 0, score2 = 0;
		win = 0;
		for (int i = 0; i < 4; i++) {
			score1 = score1 + team1[i]; // sums the score of team 1 in all quarters of the game
			score2 = score2 + team2[i]; // sums the score of team 2 in all quarters of the game
		}
		if (score1 > score2)
			win = 1; // team 1 won the game
		else if (score1 < score2)
			win = 2; // team 2 won the game
		else
			win = 0; // tie
		return win;
	}

	public void winAGame(int win, int gameIndex, int tournamentIndex) {
		super.winAQuarterFinals(win, gameIndex, tournamentIndex);
	}

	public void createPlayerOrTeam(List<String> name) {
		super.createPlayerOrTeam(name);
	}

}
