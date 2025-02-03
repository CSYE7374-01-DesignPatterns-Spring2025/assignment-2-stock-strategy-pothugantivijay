package edu.neu.csye7374;

/**
 * 
 * @author Yesha
 * 
 */

public class Driver {
	public static void main(String[] args) {
		System.out.println("============Main Execution Start===================\n\n");

         // Create Bull and Bear market strategies
        PricingStrategy bullStrategy = new BullMarketStrategy();
        PricingStrategy bearStrategy = new BearMarketStrategy();

        // Create stocks with initial strategies
        BaseStock techStock = new TechStock("TECH", 100.0, bullStrategy);
        BaseStock pharmaStock = new PharmaStock("PHARMA", 50.0, bearStrategy);

        // Display initial prices
        System.out.println("Initial Prices:");
        System.out.printf("%s: $%.2f%n", techStock.getSymbol(), techStock.getPrice());
        System.out.printf("%s: $%.2f%n%n", pharmaStock.getSymbol(), pharmaStock.getPrice());

        // Update prices with current strategies
        techStock.updatePrice();
        pharmaStock.updatePrice();

        // Display prices after first update
        System.out.println("Prices after Bull/Bear Market Update:");
        System.out.printf("%s: $%.2f%n", techStock.getSymbol(), techStock.getPrice());
        System.out.printf("%s: $%.2f%n%n", pharmaStock.getSymbol(), pharmaStock.getPrice());

        // Switch strategies
        techStock.setPricingStrategy(bearStrategy);
        pharmaStock.setPricingStrategy(bullStrategy);

        // Update prices again with new strategies
        techStock.updatePrice();
        pharmaStock.updatePrice();

        // Display prices after switching strategies
        System.out.println("Prices after Switching Strategies:");
        System.out.printf("%s: $%.2f%n", techStock.getSymbol(), techStock.getPrice());
        System.out.printf("%s: $%.2f%n", pharmaStock.getSymbol(), pharmaStock.getPrice());

		 
		System.out.println("\n\n============Main Execution End===================");
	}

}
