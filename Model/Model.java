package Model;

public class Model {
	private Basketball basketball;
	private Soccer soccer;
	private Tennis tennis;

	public Model() {
		basketball = new Basketball();
		soccer = new Soccer();
		tennis = new Tennis();
	}

	public Basketball getBasketball() {
		return basketball;
	}

	public Soccer getSoccer() {
		return soccer;
	}

	public Tennis getTennis() {
		return tennis;
	}

}
