package Model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	protected List<PlayerOrTeam> playersOrTeams; // players/teams in the game
	protected List<PlayerOrTeam> winnersOfQuarter;
	protected int winsNum; // number of wins
	protected int lossNum; // number of losses
	private int counterPlayGame;

	public Game() {
		playersOrTeams = new ArrayList<PlayerOrTeam>();
		winnersOfQuarter = new ArrayList<PlayerOrTeam>();
	}

	public Game(List<String> name) {
		this();
		createPlayerOrTeam(name);
	}

	public void createPlayerOrTeam(List<String> name) { // create player for name
		for (int i = 0; i < name.size(); i++) {
			playersOrTeams.add(new PlayerOrTeam(name.get(i)));
		}
	}

	public void winAQuarterFinals(int win, int gameIndex, int tournamentIndex) { // creates a list of the winners in the
																					// 1/4 finals
		if (tournamentIndex == 1) {
			counterPlayGame++;
			winnersOfQuarter.add(winAGame(win, gameIndex, tournamentIndex)); // creates // itself
			if (counterPlayGame == 4) {
				playersOrTeams.clear();
				counterPlayGame = 0;
			}

		}
		if (tournamentIndex == 2) {
			counterPlayGame++;
			playersOrTeams.add(winAGame(win, gameIndex, tournamentIndex));
			if (counterPlayGame == 2) {
				winnersOfQuarter.clear();
			}
		}
		if (tournamentIndex == 3) {
			winnersOfQuarter.add(winAGame(win, gameIndex, tournamentIndex));
		}
	}

	private PlayerOrTeam winAGame(int win, int gameIndex, int tournamentIndex) {
		// 1-> player 1 win ,2->player 2 win
		PlayerOrTeam winner = null;
		if (tournamentIndex == 1) {
			setWinner(win, gameIndex, winner);
		}
		if (tournamentIndex == 2) {
			setWinner1(win, gameIndex, winner);
		}
		if (tournamentIndex == 3) {
			setWinner2(win, gameIndex, winner);
		}
		return winner;
	}

	private void setWinner2(int win, int gameIndex, PlayerOrTeam winner) {
		if (win == 1)
			winner = playersOrTeams.get(0);
		else
			winner = playersOrTeams.get(1);
	}

	private void setWinner1(int win, int gameIndex, PlayerOrTeam winner) {
		if (gameIndex == 1) {
			if (win == 1)
				winner = winnersOfQuarter.get(0);
			else
				winner = winnersOfQuarter.get(1);
		}
		if (gameIndex == 2) {
			if (win == 1)
				winner = winnersOfQuarter.get(2);
			else
				winner = winnersOfQuarter.get(3);
		}
	}

	private void setWinner(int win, int gameIndex, PlayerOrTeam winner) {
		if (gameIndex == 1) {
			if (win == 1)
				winner = playersOrTeams.get(0);
			else
				winner = playersOrTeams.get(1);
		}
		if (gameIndex == 2) {
			if (win == 1)
				winner = playersOrTeams.get(2);
			else
				winner = playersOrTeams.get(3);
		}
		if (gameIndex == 3) {
			if (win == 1)
				winner = playersOrTeams.get(4);
			else
				winner = playersOrTeams.get(5);
		}
		if (gameIndex == 4) {
			if (win == 1)
				winner = playersOrTeams.get(6);
			else
				winner = playersOrTeams.get(7);
		}
	}

	public int getWinsNum() {
		return winsNum;
	}

	public void setWinsNum(int winsNum) {
		this.winsNum = winsNum;
	}

	public int getLossNum() {
		return lossNum;
	}

	public void setLossNum(int lossNum) {
		this.lossNum = lossNum;
	}

	public List<PlayerOrTeam> getPlayersOrTeams() {
		return playersOrTeams;
	}

	public List<PlayerOrTeam> getWinnersOfQuarter() {
		return winnersOfQuarter;
	}

}
