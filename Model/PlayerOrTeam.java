package Model;

public class PlayerOrTeam {
	String name;
	int points;

	public PlayerOrTeam(String name) {
		this.name = name;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}

	public String getName() {
		return name;
	}
}
