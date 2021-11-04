public class Burger {
	private String name;
	private Bread breadType;
	private Meat meatType;
	private int maxAdditions;
	private int currentAdditions;
	private double price;

	private Addition additionFirst;
	private Addition additionSecond;
	private Addition additionThird;
	private Addition additionFourth;

	public Burger(Bread breadType, Meat meatType) {
		this.breadType = breadType;
		this.meatType = meatType;
		this.price = 2.0;
		this.name = "The Standard";
		this.maxAdditions = 4;
		this.currentAdditions = 0;

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

	public void addAddition(Addition newAddition) {
		if (currentAdditions + 1 <= maxAdditions) {
			if (additionFirst == null) {
				additionFirst = newAddition;
			} else if (additionSecond == null) {
				additionSecond = newAddition;
			} else if (additionThird == null) {
				additionThird = newAddition;
			} else {
				additionFourth = newAddition;
			}
			System.out.println(newAddition.getName() + " added to burger " + this.name);
		} else {
			System.out.println("You cannot add more additions. Max additions:" + maxAdditions);
		}
	}


}
