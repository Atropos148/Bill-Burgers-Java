import java.util.Objects;

public class Shop {
	private String name;
	private double taxRate;
	private String currency;
	private double totalForToday;
	private int orderNumber;

//	Bread types
	private Bread standardBread;
	private Bread brownRyeBread;

//	Meat types
	private Meat standardBeef;
	private Meat impossibleMeat;

//	Standard Additions
	private Addition lettuce;
	private Addition cheeseShredded;
	private Addition cheeseSquare;
	private Addition tomato;
	private Addition carrot;
	private Addition eggSlices;
	private Addition onionRings;

//	Deluxe Additions
	private Addition frenchFries;
	private Addition drink;

	public Shop(String name, double taxRate, String currency) {
		this.name = name;
		this.taxRate = taxRate;
		this.currency = currency;
		this.totalForToday = 0.00;
		this.orderNumber = 0;

		this.standardBread = new Bread("White Bun", 1.00);
		this.brownRyeBread = new Bread("Brown Rye Bun", 2.20);

		this.standardBeef = new Meat("Beef Patty", 2.00);
		this.impossibleMeat = new Meat("Impossible Patty", 4.50);

		this.lettuce = new Addition("Lettuce", 1.00);
		this.cheeseShredded = new Addition("Shredded Cheese", 2.00);
		this.cheeseSquare = new Addition("Square of Cheese", 1.20);
		this.tomato = new Addition("Tomato", 2.00);
		this.carrot = new Addition("Carrot slices", 2.00);
		this.eggSlices = new Addition("Egg", 1.50);
		this.onionRings = new Addition("Onion Rings", 0.50);

		this.frenchFries = new Addition("French Fries", 3.50);
		this.drink = new Addition("One Standard Cup", 2.20);
	}

	public Burger newOrder(Bread orderBread, Meat orderMeat, String typeOfBurger) {
		Burger order = null;
		if (Objects.equals(typeOfBurger, "healthy")){
			order = new HealthyBurger(orderBread, orderMeat, 6);
		} else if (Objects.equals(typeOfBurger, "standard")) {
			order = new Burger(orderBread, orderMeat, 4);
		} else if (Objects.equals(typeOfBurger, "deluxe")) {
			order = new DeluxeBurger(orderBread, orderMeat, 2);
			order.addAddition(frenchFries);
			order.addAddition(drink);
		}
		assert order != null;

		orderNumber += 1;
		return order;
	}

	public void addToDayTotal(double orderCost) {
		totalForToday += orderCost;
	}

	public double getTotalForToday() {
		return totalForToday;
	}

	public static void main(String[] args) {
		Shop billShop = new Shop("Bill's Shop", 20, "Euro");

		Burger standard = billShop.newOrder(billShop.standardBread, billShop.standardBeef, "standard");
		standard.addAddition(billShop.lettuce);
		billShop.addToDayTotal(standard.printReceipt(billShop.taxRate, billShop.currency));
		System.out.println("Thank you for eating at " + billShop.name + "! Order #: " + billShop.orderNumber);

		HealthyBurger healthy = (HealthyBurger) billShop.newOrder(billShop.brownRyeBread, billShop.impossibleMeat, "healthy");
		healthy.addAddition(billShop.tomato);
		healthy.addAddition(billShop.eggSlices);
		healthy.addAddition(billShop.lettuce);
		healthy.addAddition(billShop.cheeseShredded);
		healthy.addExtraAdditions(billShop.carrot);
		healthy.addExtraAdditions(billShop.onionRings);
		billShop.addToDayTotal(healthy.printReceipt(billShop.taxRate, billShop.currency));
		System.out.println("Thank you for eating at " + billShop.name + "! Order #: " + billShop.orderNumber);

		Burger deluxe = billShop.newOrder(billShop.standardBread, billShop.standardBeef, "deluxe");
		deluxe.addAddition(billShop.lettuce);
		billShop.addToDayTotal(deluxe.printReceipt(billShop.taxRate, billShop.currency));
		System.out.println("Thank you for eating at " + billShop.name + "! Order #: " + billShop.orderNumber);

		System.out.println("Today's total: " + billShop.getTotalForToday());
	}
}
