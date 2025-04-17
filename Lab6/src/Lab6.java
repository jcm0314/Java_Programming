import java.util.Random;

public class Lab6 {
    public static void main(String[] args) throws Exception {
        System.out.println("(1) value~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		TripleValue value1 = new TripleValue(1, 2, 3); // (1)
		System.out.println("value1=" + value1);
		TripleValue value2 = new TripleValue(value1); // (2)
		System.out.println("value2=" + value2); 
		TripleValue value3 = new TripleValue(); // (3)
		System.out.println("value3=" + value3);
		TripleValue value4 = value1; 
		System.out.println("value4=" + value4);
		value4.set(-1,-2,-3);
		System.out.println("value1=" + value1);
		System.out.println("value2=" + value2);
		System.out.println("value3=" + value3);
		System.out.println("value4=" + value4);

		Random rand = new Random();
        for (TripleOperator op : TripleOperator.values()) {
			TripleValue value = new TripleValue(rand.nextInt(100), rand.nextInt(100), rand.nextInt(100));  
			TripleCalculator calc = new TripleCalculator(value, op);
            System.out.println("calc=" + calc);
        }

		Coffee coffee = new Coffee(new Origin("Costa Rica"), new Roast(2));
		System.out.println(coffee);
		coffee = new Coffee(new Origin("Brazil"), new Roast(3));
		System.out.println(coffee);
		Coffee[] coffees = {
			new Coffee(new Origin("Costa Rica"), new Roast(2)),
			new Coffee(new Origin("Brazil"), new Roast(3)),
			new Coffee(new Origin("Ethiopia"), new Roast(1))
		};
		for (var c : coffees) {
			System.out.println(c);
		}

		Chocolate ghana  = new Chocolate(new ChocolateBrand("Ghana", "South Korea"), ChocolateType.MILK_CHOCOLATE);
		System.out.println(ghana);

		Chocolate[] chocolates = new Chocolate[5];
        chocolates[0] = new Chocolate(new ChocolateBrand("Lindt", "Swiss"), ChocolateType.MILK_CHOCOLATE);
        chocolates[1] = new Chocolate(new ChocolateBrand("Godiva", "Belgium"), ChocolateType.DARK_CHOCOLATE);
        chocolates[2] = new Chocolate(new ChocolateBrand("Ghirardelli", "USA"), ChocolateType.DARK_CHOCOLATE);
        chocolates[3] = new Chocolate(new ChocolateBrand("Ferrero Rocher", "Italy"), ChocolateType.NUTELLA_CHOCOLATE);
        chocolates[4] = new Chocolate(new ChocolateBrand("Royce", "Japan"), ChocolateType.PAVE_CHOCOLATE);
		for (Chocolate chocolate: chocolates) {
			System.out.println(chocolate);
		}

	}
}
