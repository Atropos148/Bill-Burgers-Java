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

	public Burger(Bread breadType, Meat meatType, int maxAdditions) {
		this.breadType = breadType;
		this.meatType = meatType;
		this.price = 2.0;
		this.name = "The Standard";
		this.maxAdditions = maxAdditions;
		this.currentAdditions = 0;

		this.additionFirst = null;
		this.additionSecond = null;
		this.additionThird = null;
		this.additionFourth = null;
	}

	public int getMaxAdditions() {
		return maxAdditions;
	}

	public double printReceipt(double taxRate, String currency) {
		double totalBurgerCost = price;
		double totalAdditionsCost = 0.0;

		totalBurgerCost += meatType.getCost();
		totalBurgerCost += breadType.getCost();

		System.out.println();
		System.out.println("Hello! This is your receipt for " + getClass().getSimpleName());
		System.out.println("Burger " + totalBurgerCost + " " + currency);
		if (additionFirst != null) {
			totalAdditionsCost += additionFirst.getCost();
			System.out.println(additionFirst.getName() + " " + additionFirst.getCost() + " "  + currency);
		}
		if (additionSecond != null) {
			totalAdditionsCost += additionSecond.getCost();
			System.out.println(additionSecond.getName() + " " + additionSecond.getCost() + " "  + currency);
		}
		if (additionThird != null) {
			totalAdditionsCost += additionThird.getCost();
			System.out.println(additionThird.getName() + " " + additionThird.getCost() + " "  + currency);
		}
		if (additionFourth != null) {
			totalAdditionsCost += additionFourth.getCost();
			System.out.println(additionFourth.getName() + " " + additionFourth.getCost() + " " + currency);
		}
		double completeTotal = totalBurgerCost + totalAdditionsCost;
		System.out.println("Total Additions Cost " + totalAdditionsCost + " "  + currency);
		System.out.println("Total before tax " + completeTotal  + " "  + currency);
		System.out.println("Total to pay " + (completeTotal + (completeTotal / taxRate)) + " "  + currency);
		return completeTotal + (completeTotal / taxRate);
	}

	public void addAddition(Addition newAddition) {
		if (currentAdditions < maxAdditions) {
			if (additionFirst == null) {
				additionFirst = newAddition;
				currentAdditions += 1;
			} else if (additionSecond == null) {
				additionSecond = newAddition;
				currentAdditions += 1;
			} else if (additionThird == null) {
				additionThird = newAddition;
				currentAdditions += 1;
			} else {
				additionFourth = newAddition;
				currentAdditions += 1;
			}
		} else {
			System.out.println("You cannot add more additions. Max additions:" + maxAdditions);
		}
	}


}
