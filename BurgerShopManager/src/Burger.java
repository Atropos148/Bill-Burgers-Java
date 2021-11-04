public class Burger {
	private String name;
	private int breadType;
	private int meatType;
	private int maxAdditions;
	private double price;

	private Addition additionFirst;
	private Addition additionSecond;
	private Addition additionThird;
	private Addition additionFourth;

	public Burger(int breadType, int meatType, double price) {
		this.breadType = breadType;
		this.meatType = meatType;
		this.price = price;
		this.name = "The Standard";
		this.maxAdditions = 4;

		this.additionFirst = null;
		this.additionSecond = null;
		this.additionThird = null;
		this.additionFourth = null;
	}

	public Addition getAdditionFirst() {
		return additionFirst;
	}

	public Addition getAdditionSecond() {
		return additionSecond;
	}

	public Addition getAdditionThird() {
		return additionThird;
	}

	public Addition getAdditionFourth() {
		return additionFourth;
	}


}
