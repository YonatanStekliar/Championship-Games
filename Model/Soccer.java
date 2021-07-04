package Model;

import java.util.List;

public class Soccer extends Game {
	private int score1 = 0;
	private int score2 = 0;
	int win;

	public Soccer() {
		super();
	}

	public Soccer(List<String> name) {
		super(name);

	}

	public void winAGame(int win, int gameIndex, int tournamentIndex) {
		super.winAQuarterFinals(win, gameIndex, tournamentIndex);
	}

	public int whichTeamWin(int[] team1, int[] team2) {
		win = 0;
		score1 = 0;
		score2 = 0;
		for (int i = 0; i < 2; i++) {
			score1 = score1 + team1[i]; // sums the score of team 1 in both halves of the game
			score2 = score2 + team2[i]; // sums the score of team 2 in both halves of the game
		}
		if (score1 > score2)
			win = 1; // team 1 won the game
		else if (score1 < score2)
			win = 2; // team 2 won the game
		else
			win = 0; // tie
		return win;
	}

	public int overTime(int[] team1, int[] team2) { // if the 2 halves ends in a tie
		win = 0;
		score1 = score1 + team1[2]; // sums the score of team 1 in the overtime
		score2 = score2 + team2[2]; // sums the score of team 2 in the overtime
		if (score1 > score2)
			win = 1; // team 1 won the game
		else if (score1 < score2)
			win = 2; // team 2 won the game
		else
			win = 0; // tie
		return win;
	}

	public int penalty(int team1, int team2) { // if the overtime ends in a tie
		if (team1 > team2)
			win = 1; // team 1 won the game
		else if (team1 < team2)
			win = 2; // team 2 won the game
		else
			win = 0; // tie - controller will randomize the winner
		return win;
	}

	public void createPlayerOrTeam(List<String> name) {
		super.createPlayerOrTeam(name);
	}

}
