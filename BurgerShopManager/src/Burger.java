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

	public double printReceipt(double taxRate, String currency) {
		double totalBurgerCost = price;
		double totalAdditionsCost = 0.0;

		totalBurgerCost += meatType.getCost();
		totalBurgerCost += breadType.getCost();

		double completeTotal = totalBurgerCost + totalAdditionsCost;

		System.out.println("Hello! This is your receipt for " + name);
		System.out.println("Burger " + totalBurgerCost);
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
		System.out.println("Total Additions Cost " + totalAdditionsCost + " "  + currency);
		System.out.println("Total before tax " + completeTotal  + " "  + currency);
		System.out.println("Total to pay " + (completeTotal + (completeTotal / taxRate)) + " "  + currency);
		return completeTotal + (completeTotal / taxRate);
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
		} else {
			System.out.println("You cannot add more additions. Max additions:" + maxAdditions);
		}
	}


}
