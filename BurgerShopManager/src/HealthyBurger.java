public class HealthyBurger extends Burger{
	private Addition additionFifth;
	private Addition additionSixth;

	public HealthyBurger(Bread breadType, Meat meatType, int maxAdditions) {
		super(breadType, meatType, maxAdditions);
	}

	public void addExtraAdditions(Addition newAddition) {
		if (getCurrentAdditions() < getMaxAdditions()) {
			if (additionFifth == null) {
				additionFifth = newAddition;
				setCurrentAdditions(getCurrentAdditions() + 1);
			} else if (additionSixth == null) {
				additionSixth = newAddition;
				setCurrentAdditions(getCurrentAdditions() + 1);
			}
		} else {
			System.out.println("You cannot add more additions. Max additions:" + getMaxAdditions());
		}
	}

	@Override
	public double printReceipt(double taxRate, String currency) {
		double totalBurgerCost = getPrice();
		double totalAdditionsCost = 0.0;

		totalBurgerCost += getMeatType().getCost();
		totalBurgerCost += getBreadType().getCost();

		System.out.println();
		System.out.println("Hello! This is your receipt for " + getClass().getSimpleName());
		System.out.println("Burger " + totalBurgerCost + " " + currency);
		if (getAdditionFirst() != null) {
			totalAdditionsCost += getAdditionFirst().getCost();
			System.out.println(getAdditionFirst().getName() + " " + getAdditionFirst().getCost() + " "  + currency);
		}
		if (getAdditionSecond() != null) {
			totalAdditionsCost += getAdditionSecond().getCost();
			System.out.println(getAdditionSecond().getName() + " " + getAdditionSecond().getCost() + " "  + currency);
		}
		if (getAdditionThird() != null) {
			totalAdditionsCost += getAdditionThird().getCost();
			System.out.println(getAdditionThird().getName() + " " + getAdditionThird().getCost() + " "  + currency);
		}
		if (getAdditionFourth() != null) {
			totalAdditionsCost += getAdditionFourth().getCost();
			System.out.println(getAdditionFourth().getName() + " " + getAdditionFourth().getCost() + " " + currency);
		}
		if (additionFifth != null) {
			totalAdditionsCost += additionFifth.getCost();
			System.out.println(additionFifth.getName() + " " + additionFifth.getCost() + " " + currency);
		}
		if (additionSixth != null) {
			totalAdditionsCost += additionSixth.getCost();
			System.out.println(additionSixth.getName() + " " + additionSixth.getCost() + " " + currency);
		}
		double completeTotal = totalBurgerCost + totalAdditionsCost;
		System.out.println("Total Additions Cost " + totalAdditionsCost + " "  + currency);
		System.out.println("Total before tax " + completeTotal  + " "  + currency);
		System.out.println("Total to pay " + (completeTotal + (completeTotal / taxRate)) + " "  + currency);
		return completeTotal + (completeTotal / taxRate);
	}
}
