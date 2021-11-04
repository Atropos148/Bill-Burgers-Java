public class Burger {
	private String name;
	private int breadType;
	private int meatType;
	private int maxAdditions;
	private double price;

	public Burger(int breadType, int meatType, double price) {
		this.breadType = breadType;
		this.meatType = meatType;
		this.price = price;
		this.name = "The Standard";
		this.maxAdditions = 4;
	}
}
