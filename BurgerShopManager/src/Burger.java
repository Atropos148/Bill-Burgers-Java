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

		totalAdditionsCost += additionFirst.getCost();
		totalAdditionsCost += additionSecond.getCost();
		totalAdditionsCost += additionThird.getCost();
		totalAdditionsCost += additionFourth.getCost();

		totalBurgerCost += meatType.getCost();
		totalBurgerCost += breadType.getCost();

		double completeTotal = totalBurgerCost + totalAdditionsCost;

		System.out.println("Hello! This is your receipt for " + name);
		System.out.println("Burger " + totalBurgerCost);
		if (additionFirst != null) {
			System.out.println(additionFirst.getName() + " " + additionFirst.getCost() + currency);
		}
		if (additionSecond != null) {
			System.out.println(additionSecond.getName() + " " + additionSecond.getCost() + currency);
		}
		if (additionThird != null) {
			System.out.println(additionThird.getName() + " " + additionThird.getCost() + currency);
		}
		if (additionFourth != null) {
			System.out.println(additionFourth.getName() + " " + additionFourth.getCost() + currency);
		}
		System.out.println("Total Additions Cost " + totalAdditionsCost);
		System.out.println("Total before tax " + completeTotal);
		System.out.println("Total to pay " + (completeTotal + (completeTotal / taxRate)));
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
			System.out.println(newAddition.getName() + " added to burger " + this.name);
		} else {
			System.out.println("You cannot add more additions. Max additions:" + maxAdditions);
		}
	}


}
