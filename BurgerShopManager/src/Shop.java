public class Shop {
	private String name;
	private double taxRate;
	private String currency;

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

//	Deluxe Additions
	private Addition frenchFries;
	private Addition drink;

	public Shop(String name, double taxRate, String currency) {
		this.name = name;
		this.taxRate = taxRate;
		this.currency = currency;

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

		this.frenchFries = new Addition("French Fries", 3.50);
		this.drink = new Addition("One Standard Cup", 2.20);
	}

	public void newOrder(Bread orderBread, Meat orderMeat) {
		Burger order = new Burger(orderBread, orderMeat);
		System.out.println(order);
	}
}
